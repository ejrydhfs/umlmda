/**
 * 
 */
package org.umlmda.runtime.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;

/**
 * Property descriptor for readonly properties forcing to overwrite {@link PropertyDescriptor#createPropertyEditor(Object)}.
 * 
 * @author Dieter Moroff
 */
public abstract class ReadOnlyPropertyDescriptor extends PropertyDescriptor
{

   public ReadOnlyPropertyDescriptor(String propertyName, Class<?> beanClass, String getterName) throws IntrospectionException {
      super(propertyName, beanClass, getterName, null);
   }

   @Override
   public abstract PropertyEditor createPropertyEditor(Object bean);

}
