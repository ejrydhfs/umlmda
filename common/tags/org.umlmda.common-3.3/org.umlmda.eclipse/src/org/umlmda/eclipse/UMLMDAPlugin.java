package org.umlmda.eclipse;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.*;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.umlmda.eclipse.util.PluginClassloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * The main plugin class to be used in the desktop.
 */
public class UMLMDAPlugin extends AbstractUIPlugin {
   /** Extension point id for template paths */
   public static final String EXT_POINT_TEMPLATE_PATH = "org.umlmda.eclipse.templatePath";

   /** Extension point id for class loaders */
   public static final String EXT_POINT_CLASS_LOADER = "org.umlmda.eclipse.extensionClassloader";

   /** Extension point id for model factories */
   public static final String EXT_POINT_MODEL_FACTORY = "org.umlmda.eclipse.modelFactory";
   
   /** Extension point id for model factories */
   public static final String EXT_POINT_JAVA_CODE_FORMATTER = "org.umlmda.eclipse.formatterProvider";
   
   //The shared instance.
   private static UMLMDAPlugin plugin;

   //Resource bundle.
   private ResourceBundle resourceBundle;

   /**
    * Registered tmeplate paths from other plugins
    */
   private List externalTemplatePaths = new ArrayList();

   /**
    * List of extension class loaders
    */
   private List extensionClassLoaders = new ArrayList();
   
   /**
    * Map of model factories
    */
   private Map extensionModelFactories = new HashMap();
   
   private List javaCodeFormatters;
   
   /** preference value for logging */
   public static final String P_LOG = "loggingPreference";

   /** preference value for template apths */
   public static final String P_TEMPLATE_PATHS = "templatePathsPreference";

   public static final String P_JAVA_CODE_FORMATTER = "javaCodeFormatterPreference";

   public static final String P_JAVA_CODE_FORMATTER_PROPERTIES = "javaCodeFormatterPropertyPreference";

   public static class CodeFormatterEntry {
      final public Bundle bundle;
      final public String formatterClassName;
      
      public CodeFormatterEntry(Bundle bundle, String formatterClassName) {
         this.bundle = bundle;
         this.formatterClassName = formatterClassName;
      }
   }
   
   /**
    * The constructor.
    */
   public UMLMDAPlugin() {
      super();
      plugin = this;
      try {
         resourceBundle = ResourceBundle.getBundle("org.umlmda.eclipse.UMLMDAPluginResources");
      } catch (MissingResourceException x) {
         resourceBundle = null;
      }
   }

   /**
    * This method is called upon plug-in activation
    */
   public void start(BundleContext context) throws Exception {
      super.start(context);
      
      loadExtensionPathes(externalTemplatePaths, EXT_POINT_TEMPLATE_PATH);
      loadExtensionClassloader(EXT_POINT_CLASS_LOADER);
      loadExtensionModelFactories(extensionModelFactories, EXT_POINT_MODEL_FACTORY);
   }

   /**
    * This method is called when the plug-in is stopped
    */
   public void stop(BundleContext context) throws Exception {
      super.stop(context);
   }

   /**
    * Returns the shared instance.
    */
   public static UMLMDAPlugin getDefault() {
      return plugin;
   }

   /**
    * Returns the string from the plugin's resource bundle, or 'key' if not
    * found.
    */
   public static String getResourceString(String key) {
      ResourceBundle bundle = UMLMDAPlugin.getDefault().getResourceBundle();
      try {
         return (bundle != null) ? bundle.getString(key) : key;
      } catch (MissingResourceException e) {
         return key;
      }
   }

   /**
    * @return
    */
   private void loadExtensionClassloader(String extensionPointId) {
      IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
      IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(extensionPointId);
      if ( extensionPoint != null ) {
         IExtension extensions[] = extensionPoint.getExtensions();
         
         for (int i = 0; i < extensions.length; i++) {
            IExtension extension = extensions[i];
            
            String pluginId         = extension.getNamespace();
            Bundle bundle           = Platform.getBundle(pluginId);
            
            extensionClassLoaders.add(new PluginClassloader(bundle));
            getLog().log(new Status(IStatus.INFO, getBundle().getSymbolicName(), 0, extensionPointId+": added classloader from " + bundle.getSymbolicName(), null));
         }
      }
      else {
         getLog().log(new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, "extension point "+extensionPointId+" not found", null));
      }
   }
   
   /**
    * @return
    */
   private void loadExtensionPathes(List externalPathList, String extensionPointId) {
      IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
      IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(extensionPointId);
      if ( extensionPoint != null ) {
         IExtension extensions[] = extensionPoint.getExtensions();
         
         for (int i = 0; i < extensions.length; i++) {
            IExtension extension = extensions[i];
            IConfigurationElement elements[] = extension.getConfigurationElements();
            String pluginId    = extension.getNamespace();
            Bundle bundle = Platform.getBundle(pluginId);

            for (int j = 0; j < elements.length; j++) {
               IConfigurationElement element = elements[j];
               String templatePath  = element.getAttribute("path");

               try {
                  URL bundleRootURL = bundle.getEntry("/");
                  bundleRootURL = org.eclipse.core.runtime.Platform.resolve(bundleRootURL);
                  URL nativeURL = new URL(bundleRootURL, templatePath);
                  String urlProtocol = nativeURL.getProtocol();
                  
                  if (nativeURL != null && "file".equals(urlProtocol) ) {
                     String templateURLPath = nativeURL.getPath().substring(1); 
                     externalPathList.add(templateURLPath);
                     getLog().log(
                           new Status(IStatus.INFO, getBundle().getSymbolicName(), 0, extensionPointId
                                 + ": templates loaded from " + templateURLPath, null));
                  }
                  else {
                     getLog().log(
                           new Status(IStatus.INFO, getBundle().getSymbolicName(), 0, extensionPointId
                                 + ": templates from " + templatePath + "("+nativeURL+") could not be loaded", null));
                  }
               } catch (MalformedURLException e) {
                  getLog().log(
                           new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, extensionPointId
                                 + ":" + e.getMessage(), e));
               } catch (IOException e) {
                  getLog().log(
                        new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, extensionPointId
                              + ":" + e.getMessage(), e));
               }
            }
         }
      }
      else {
         getLog().log(new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, "extension point "+extensionPointId+" not found", null));
      }
   }
   
   /**
    * @return
    */
   private void loadExtensionModelFactories(Map externalModelFactoryMap, String extensionPointId) {
      IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
      IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(extensionPointId);
      if (extensionPoint != null) {
         IExtension extensions[] = extensionPoint.getExtensions();

         for (int i = 0; i < extensions.length; i++) {
            IExtension extension = extensions[i];
            IConfigurationElement elements[] = extension.getConfigurationElements();
            String pluginId = extension.getNamespace();
            Bundle bundle = Platform.getBundle(pluginId);

            for (int j = 0; j < elements.length; j++) {
               IConfigurationElement element = elements[j];
               String factoryClassName = element.getAttribute("class");
               
               try {
                  Class factoryClass = bundle.loadClass(factoryClassName);
                  IConfigurationElement fileExtensions[] = element.getChildren("fileExtension");

                  for (int k = 0; k < fileExtensions.length; k++) {
                     IConfigurationElement fileExtElement = fileExtensions[k];
                     String fileExt = fileExtElement.getAttribute("ext");

                     externalModelFactoryMap.put(fileExt, factoryClass);

                     getLog().log(
                           new Status(IStatus.INFO, getBundle().getSymbolicName(), 0, extensionPointId + ": "
                                 + factoryClassName + " loaded for file extension " + fileExt, null));
                  }
               } catch (ClassNotFoundException e) {
                  getLog().log(
                        new Status(IStatus.WARNING, getBundle().getSymbolicName(), 0, "model factory class " + factoryClassName
                              + " not found", null));
               }
            }
         }
      } else {
         getLog().log(
               new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, "extension point " + extensionPointId
                     + " not found", null));
      }
   }
   
   /**
    * Returns the plugin's resource bundle,
    */
   public ResourceBundle getResourceBundle() {
      return resourceBundle;
   }
   
   /**
    * Returns as list containing the template paths defined in the preference
    * page.
    * 
    * @return List of <code>java.io.File</code>
    */
   public List getTemplatePaths() {
      List templatePaths = new ArrayList();
      StringTokenizer parsePaths = new StringTokenizer(getPreferenceStore().getString(P_TEMPLATE_PATHS), File.pathSeparator);
      
      while ( parsePaths.hasMoreTokens() ) {
         File templatePath = new File(parsePaths.nextToken());
         
         if ( templatePath.exists() ) {
            templatePaths.add(templatePath);
         }
      }
      
      templatePaths.addAll(externalTemplatePaths);
      
      return templatePaths;
   }

   public Class getJavaCodeFormatter() {
      String codeFormatter = getPreferenceStore().getString(P_JAVA_CODE_FORMATTER);

      if ( StringUtils.isNotEmpty(codeFormatter) ) {
         StringTokenizer javaCodeFormatter = new StringTokenizer(codeFormatter, "@");
         String javaCodeFormatClassName = javaCodeFormatter.nextToken();
         String javaCodeFormatBundle = javaCodeFormatter.nextToken();
         
         try {
            Bundle bundle = Platform.getBundle(javaCodeFormatBundle);
            return bundle.loadClass(javaCodeFormatClassName);
         } catch (ClassNotFoundException e) {
            error("Unable to load formatter " + e.getMessage(), e);
            return null;
         }
      }
      else {
         return null;
      }
   }
   
   public URL getJavaCodeFormatterProperties() {
      String codeFormatter = getPreferenceStore().getString(P_JAVA_CODE_FORMATTER);

      if ( StringUtils.isNotEmpty(codeFormatter) ) {
         StringTokenizer javaCodeFormatter = new StringTokenizer(codeFormatter, "@");
         String javaCodeFormatClassName = javaCodeFormatter.nextToken();
         String javaCodeFormatBundle = javaCodeFormatter.nextToken();
         String resourceName = getPreferenceStore().getString(P_JAVA_CODE_FORMATTER_PROPERTIES);
         Bundle bundle = Platform.getBundle(javaCodeFormatBundle);
         URL resource = bundle.getResource(resourceName);
         
         return resource;
      }
      else {
         return null;
      }
   }
   
   public List getJavaCodeFormatters() {
      if ( javaCodeFormatters == null ) {
         javaCodeFormatters = new ArrayList();
         
         IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
         IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(EXT_POINT_JAVA_CODE_FORMATTER);
         if (extensionPoint != null) {
            IExtension extensions[] = extensionPoint.getExtensions();

            for (int i = 0; i < extensions.length; i++) {
               IExtension extension = extensions[i];
               IConfigurationElement elements[] = extension.getConfigurationElements();
               
               for (int j = 0; j < elements.length; j++) {
                  IConfigurationElement element = elements[j];
                  
                  String formatterClass = element.getAttribute("class");
                  
                  javaCodeFormatters.add(new CodeFormatterEntry(Platform.getBundle(extension.getNamespaceIdentifier()), formatterClass));
               }
            }
         }
      }
      
      return javaCodeFormatters;
   }
   
   public List getClasspaths() {
      return extensionClassLoaders;
   }
   
   /**
    * Returns the workspace instance.
    * @return shell object
    */
   public static Shell getShell() {
       return getDefault().getWorkbench().getActiveWorkbenchWindow()
           .getShell();
   }
   
   /**
    * Shows and error dialog and create a log message.
    * @param messageID
    * @param error
    */
   public static void error(String messageID, Throwable error) {
       Shell shell = getShell();
       String message = getResourceString("UMLMDA.Error"); //$NON-NLS-1$
       if (messageID != null) {
           message = getResourceString(messageID);
       }
       message = message + " " + error.getMessage();//$NON-NLS-1$
       MessageDialog.openError(
           shell, getResourceString("UMLMDA.Title"), //$NON-NLS-1$
           message);

       log(message, null, IStatus.ERROR);
   }
   
   /**
    * @param statusID one of IStatus. constants like IStatus.ERROR etc
    * @param error
    */
   public static void log(Throwable error, int statusID) {
      log(null, error, statusID);
   }

   /**
    * @param statusID one of IStatus. constants like IStatus.ERROR etc
    * @param error
    */
   public static void log(String message, Throwable error, int statusID) {
       String pluginId = getDefault().getBundle().getSymbolicName();
       
       if ( message == null && error != null ) {
          message = error.getMessage();
          if ( message == null ) {
             message = error.toString();
          }
       }
       
       getDefault().getLog()
           .log(
               new Status(
                   statusID,
                   pluginId, 0, message, error)); 
   }
   
}
