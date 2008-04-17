/**
 * 
 */
package org.umlmda.eclipse.jdt.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.SourceType;
import org.umlmda.eclipse.UMLMDAPlugin;

/**
 * @author MOROFF
 *
 */
public class ProjectClassLoader extends ClassLoader {
   private final IJavaProject javaProject;
   private final Map classMap = new HashMap();
   
   public ProjectClassLoader(IJavaProject javaProject) {
      super();
      this.javaProject = javaProject;
   }

//   /**
//    * Overwritten loadClass to ensure that the classes are loaded from the 
//    * project first.
//    */
//   public Class loadClass(String className) throws ClassNotFoundException {
//      Class javaClass = (Class) classMap.get(className);
//      
//      if ( javaClass == null ) {
//         try {
//            javaClass = findClass(className);
//            classMap.put(className, javaClass);
//            UMLMDAPlugin.log("loaded class "+className+" from java project "+javaProject.getElementName(), null, IStatus.INFO);
//         } catch (ClassNotFoundException e) {
//            javaClass = super.loadClass(className);
//         }
//      }
//      return javaClass;
//   }
   
   /* (non-Javadoc)
    * @see java.lang.ClassLoader#findClass(java.lang.String)
    */
   protected Class findClass(String className) throws ClassNotFoundException {
      Class clazz;
      try {
         IType type = javaProject.findType(className);

//         if ( type == null ) {
//            return super.findClass(className);
//         }
         if ( type instanceof SourceType ) {
            byte byteCode[] = JdtUtils.getBytecode(type);
            
            clazz = defineClass(className, byteCode, 0, byteCode.length);
            UMLMDAPlugin.log("loaded class "+className+" from java project "+javaProject.getElementName(), null, IStatus.INFO);
            return clazz;
         }
         else {
            throw new ClassNotFoundException(className);
         }
      } catch (JavaModelException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new ClassNotFoundException(className, e);
      }
   }
   
   /**
    * Resets the hash map with the cached classes.
    */
   public void reset() {
      classMap.clear();
   }
   
}
