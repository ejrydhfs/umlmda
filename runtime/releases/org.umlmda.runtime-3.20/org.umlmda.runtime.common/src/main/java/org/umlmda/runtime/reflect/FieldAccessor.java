package org.umlmda.runtime.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author moroff
 */
public class FieldAccessor
{
   /**
    * Direct field set.
    * 
    * @param object
    *    bean containing the field
    * @param fieldName
    *    name of the field to be set
    * @param value
    *    value to be set
    */
   public static void set(final Object object, String fieldName, Object value) {
      try {
         Field f = object.getClass().getDeclaredField(fieldName);
         int modifiers = f.getModifiers();
         
         if ( Modifier.isFinal(modifiers) ) {
            throw new IllegalArgumentException("field is final");
         }

         boolean accessible = f.isAccessible();
         if ( !accessible ) {
            f.setAccessible(true);
         }
         f.set(object, value);
         if ( !accessible ) {
            f.setAccessible(false);
         }
      }
      catch (NoSuchFieldException e) {
         throw new IllegalArgumentException(e);
      }
      catch (NoSuchFieldError e) {
         throw new IllegalArgumentException(e);
      }
      catch (SecurityException e) {
         throw new RuntimeException(e);
      }
      catch (IllegalAccessException e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * Direct field get
    * 
    * @param object
    *    bean containing the field
    * @param fieldName
    *    name of the field to be set
    * @return
    *    value of the field
    */
   public static Object get(final Object object, String fieldName) {
      try {
         Field f = object.getClass().getDeclaredField(fieldName);
         boolean accessible = f.isAccessible();
         if ( !accessible ) {
            f.setAccessible(true);
         }
         Object value = f.get(object);
         if ( !accessible ) {
            f.setAccessible(false);
         }
         
         return value;
      }
      catch (NoSuchFieldException e) {
         throw new IllegalArgumentException(e);
      }
      catch (NoSuchFieldError e) {
         throw new IllegalArgumentException(e);
      }
      catch (SecurityException e) {
         throw new RuntimeException(e);
      }
      catch (IllegalAccessException e) {
         throw new RuntimeException(e);
      }
      
   }
}
