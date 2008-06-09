package org.umlmda.generator.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class GeneratorPlugin extends Plugin {
   private static final String EXT_POINT_WRITER = "org.umlmda.generator.core.writer";
   private static final String EXT_POINT_ADAPTERFACTORY = "org.umlmda.generator.core.adapterfactory";
   private static final String EXT_POINT_VALIDATION_FACTORY = "org.umlmda.generator.core.validationFactory";
   
   /**
    * The shared instance.
    */
   private static GeneratorPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
   /** 
    * Registered writers from other plugins
    */
   private Map externalWriters = new HashMap();
   /**
    * Registered adapter factories from other plugins
    */
   private Map externalAdapterFactories = new HashMap();
   /**
    * Registered adapter factories from other plugins
    */
   private Map externalValidationFactories = new HashMap();
   /**
    * List of classloaders to load writers, adapters, validation, 
    * patterns, ...
    */
   private List externalClassLoader = new ArrayList();

	/**
	 * The constructor.
	 */
	public GeneratorPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("org.umlmda.generator.plugin.GeneratorPluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);

      // Load classes defined in extension points
//      loadExtensionClasses(externalWriters, EXT_POINT_WRITER);
//      loadExtensionClasses(externalAdapterFactories, EXT_POINT_ADAPTERFACTORY);
//      loadExtensionClasses(externalValidationFactories, EXT_POINT_VALIDATION_FACTORY);
      
      // Load preferences
//      getPluginPreferences().get
   }

	/**
    * @return
    * @throws ClassNotFoundException
    */
   private void loadExtensionClasses(Map externalClassMap, String extensionPointId) throws ClassNotFoundException {
      IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
      IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(extensionPointId);
      if ( extensionPoint != null ) {
         IExtension extensions[] = extensionPoint.getExtensions();
         
         for (int i = 0; i < extensions.length; i++) {
            IExtension extension = extensions[i];
            IConfigurationElement elements[] = extension.getConfigurationElements();
            
            for (int j = 0; j < elements.length; j++) {
               IConfigurationElement element = elements[j];
               
               String writerName  = element.getAttribute("name");
               String className   = element.getAttribute("class");
               String pluginId    = extension.getNamespace();
               Bundle bundle = Platform.getBundle(pluginId);
               Class writerClass = bundle.loadClass(className);

               if ( writerClass != null ) {
                  externalClassMap.put(writerClass.getName(), writerClass);
                  getLog().log(new Status(IStatus.INFO, getBundle().getSymbolicName(), 0, extensionPointId+": class "+className+" loaded from " + bundle.getSymbolicName(), null));
               } else {
                  getLog().log(new Status(IStatus.WARNING, getBundle().getSymbolicName(), 0, extensionPointId+": class "+className+" not found in " + bundle.getSymbolicName(), null));
               }
            }
         }
      }
      else {
         getLog().log(new Status(IStatus.ERROR, getBundle().getSymbolicName(), 0, "extension point "+extensionPointId+" not found", null));
      }
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
	public static GeneratorPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = GeneratorPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

   public Map getExternalWriters() {
      return externalWriters;
   }
   
   public Map getExternalAdapterFactories() {
   	return externalAdapterFactories;
   }

   public Map getExternalValidationFactories() {
      return externalValidationFactories;
   }
   
   public List getExternalClassLoader() {
      return externalClassLoader;
   }
}
