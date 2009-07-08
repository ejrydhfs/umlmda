package org.umlmda.runtime.bean;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class BeanDescriptor {
   private Map<String, PropertyDescriptor> propertyDescriptorMap = new HashMap<String, PropertyDescriptor>();
   
   PropertyDescriptor getPropertyDescriptor(String propertyName) {
      return propertyDescriptorMap.get(propertyName);
   }
   
   protected void addPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
      propertyDescriptorMap.put(propertyDescriptor.getName(), propertyDescriptor);
   }
}
