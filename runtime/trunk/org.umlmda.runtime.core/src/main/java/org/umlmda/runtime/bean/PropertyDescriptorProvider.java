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
      return beanDescriptorMap.get(beanClass).getPropertyDescriptor(propertyName);
   }
   
   public static void registerDescriptor(Class<?> beanClass, BeanDescriptor beanDescriptor) {
      beanDescriptorMap.put(beanClass, beanDescriptor);
   }
   
}
