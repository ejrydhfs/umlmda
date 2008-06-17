package org.umlmda.runtime.bean;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class PropertyDescriptorProvider {
   private static PropertyDescriptorProvider theInstance = new PropertyDescriptorProvider();
   private static Map<Class<?>, BeanDescriptor> beanDescriptorMap = new HashMap<Class<?>, BeanDescriptor>();
   
   public static PropertyDescriptorProvider getInstance() {
      return theInstance;
   }

   public static PropertyDescriptor getPropertyDescriptor(String propertyName, Class<?> beanClass) {
      BeanDescriptor beanDescriptor = beanDescriptorMap.get(beanClass);
      
      if ( beanDescriptor == null ) {
         throw new IllegalArgumentException("Not description registered for "+beanClass.getName());
      }
      
      PropertyDescriptor descriptor = beanDescriptor.getPropertyDescriptor(propertyName);
      
      if ( descriptor == null ) {
         throw new IllegalArgumentException("Property "+propertyName+" not registered for "+beanClass.getName());
      }

      return descriptor; 
   }
   
   public static void registerDescriptor(Class<?> beanClass, BeanDescriptor beanDescriptor) {
      beanDescriptorMap.put(beanClass, beanDescriptor);
   }
   
}
