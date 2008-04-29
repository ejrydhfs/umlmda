/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.beans;

import java.lang.reflect.Method;

/**
 * Implementation of PropertyDescriptor for GWT compatibility.
 * 
 * @author Dieter Moroff (14.04.2008)
 */
public abstract class PropertyDescriptor extends FeatureDescriptor {
   boolean constrained;
   boolean bound;
   private final Class<?> beanClass;
   private String getterName;
   private String setterName;

   public PropertyDescriptor(String propertyName, Class<?> beanClass, String getterName, String setterName)
         throws IntrospectionException {
      this.beanClass = beanClass;
      this.getterName = getterName;
      this.setterName = setterName;
      super.setName(propertyName);
   }

   public PropertyDescriptor(String propertyName, Method getter, Method setter) throws IntrospectionException {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public PropertyDescriptor(String propertyName, Class<?> beanClass) throws IntrospectionException {
      this.beanClass = beanClass;
      super.setName(propertyName);
   }

   public void setWriteMethod(Method setter) throws IntrospectionException {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public void setReadMethod(Method getter) throws IntrospectionException {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public Method getWriteMethod() {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public Method getReadMethod() {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public void setPropertyEditorClass(Class<?> propertyEditorClass) {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public abstract Class<?> getPropertyType();

   public Class<?> getPropertyEditorClass() {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public void setConstrained(boolean constrained) {
      this.constrained = constrained;
   }

   public void setBound(boolean bound) {
      this.bound = bound;
   }

   public boolean isConstrained() {
      return constrained;
   }

   public boolean isBound() {
      return bound;
   }

   void setReadMethod(Class<?> beanClass, String getterName) throws IntrospectionException {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   void setWriteMethod(Class<?> beanClass, String setterName) throws IntrospectionException {
      throw new UnsupportedOperationException("Not GWT compatible");
   }

   public abstract PropertyEditor createPropertyEditor(Object bean);
}
