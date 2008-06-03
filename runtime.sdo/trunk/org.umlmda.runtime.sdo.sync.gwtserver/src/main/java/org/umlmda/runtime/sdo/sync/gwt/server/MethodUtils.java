package org.umlmda.runtime.sdo.sync.gwt.server;

import java.lang.reflect.Method;

/**
 * Reflection utilities dealing with methods 
 * @author MOROFF
 */
public class MethodUtils {

   /**
    * Find a method matching the given parameter arguments. The first match found is returned. 
    * @param clazz
    *    Class to search the methods 
    * @param methodName
    *    Name of the method
    * @param parameters
    *    Array of parameters
    * @return
    *    The applicable method
    * @throws NoSuchMethodException
    *    No applicable method found
    */
   public static Method findMatchingMethod(Class<?> clazz, String methodName, Object [] parameters) throws NoSuchMethodException {
      for (int i = 0; i < clazz.getMethods().length; i++) {
         Method method = clazz.getMethods()[i];
         
         if ( methodName.equals(method.getName())) {
            if ( isMatching(method, parameters) ) {
               return method; 
            }
         }
      }
      
      throw new NoSuchMethodException("No applicable method "+methodName+"  found");
   }

   private static boolean isMatching(Method method, Object[] parameters) {
      Class<?>[] parameterTypes = method.getParameterTypes();
      
      // Check for same parameter count
      if ( parameters.length != parameterTypes.length ) {
         return false;
      }
      
      for (int i = 0; i < parameterTypes.length; i++) {
         Class<?> parameterClass = parameterTypes[i];
      
         if ( parameterClass.isAssignableFrom(parameters[i].getClass()) == false ) {
            return false;
         }
      }
      return true;
   }
}
