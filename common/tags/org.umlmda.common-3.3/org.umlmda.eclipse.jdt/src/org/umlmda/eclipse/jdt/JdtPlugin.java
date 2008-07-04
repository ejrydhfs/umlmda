package org.umlmda.eclipse.jdt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.umlmda.eclipse.UMLMDAPlugin;
import org.umlmda.eclipse.jdt.ui.JavaProjectSelection;
import org.umlmda.eclipse.jdt.util.ProjectClassLoader;

/**
 * The main plugin class to be used in the desktop.
 */
public class JdtPlugin extends AbstractUIPlugin {
   //The shared instance.
   private static JdtPlugin plugin;

   //Resource bundle.
   private ResourceBundle resourceBundle;

   // Preference entry for java projects
   public static final String P_JAVA_PROJECTS = "javaProjects";

   /**
    * The constructor.
    */
   public JdtPlugin() {
      super();
      plugin = this;
      try {
         resourceBundle = ResourceBundle.getBundle("org.umlmda.eclipse.jdt.JdtPluginResources");
      } catch (MissingResourceException x) {
         resourceBundle = null;
      }
   }

   /**
    * This method is called upon plug-in activation
    */
   public void start(BundleContext context) throws Exception {
      super.start(context);
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
   public static JdtPlugin getDefault() {
      return plugin;
   }

   /**
    * Returns the string from the plugin's resource bundle, or 'key' if not
    * found.
    */
   public static String getResourceString(String key) {
      ResourceBundle bundle = JdtPlugin.getDefault().getResourceBundle();
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

   /**
    * Returns a list containing classpath created from the java projects
    * defined in the prefence page.
    * @param parentClassLoader
    * @return List of <code>java.lang.ClassLoader</code>
    */
   public List getProjectClassPaths(ClassLoader parentClassLoader) {
      List projectClassPaths = new ArrayList();
      
      String projects = getPreferenceStore().getString(P_JAVA_PROJECTS);
      StringTokenizer projectsParser = new StringTokenizer(projects, File.pathSeparator);
      
      while ( projectsParser.hasMoreTokens() ) {
         String project = projectsParser.nextToken();
         IJavaProject javaProject = JavaProjectSelection.getWorkspaceJavaProject(project);

         projectClassPaths.add(new ProjectClassLoader(javaProject));
      }
      
      projectClassPaths.addAll(UMLMDAPlugin.getDefault().getClasspaths());
      return projectClassPaths;
   }
   

   
}
