/**
 * 
 */
package org.umlmda.runtime.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;

/**
 * Property descriptor forces to overwrite createPropertyEditor. 
 * @author MOROFF
 *
 */
public abstract class DynamicEditorPropertyDescriptor extends PropertyDescriptor {

   public DynamicEditorPropertyDescriptor(String propertyName, Class<?> beanClass) throws IntrospectionException {
      super(propertyName, beanClass);
   }

   @Override
   public abstract PropertyEditor createPropertyEditor(Object bean);

   
}
