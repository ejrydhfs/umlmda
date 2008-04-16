package org.umlmda.runtime.sdo.change.test.model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import org.umlmda.runtime.bean.BeanDescriptor;

public class RootChildrenClass extends BeanDescriptor {

   public static final RootChildrenClass INSTANCE = new RootChildrenClass();

   private RootChildrenClass() {
      try {
         addPropertyDescriptor(new PropertyDescriptor(
            RootChildren.PROPERTY_STRING_ATTR, 
            new Method(RootChildren.class, Member.PUBLIC, "getStringAttr") {
               @Override
               public Class<?> getReturnType() {
                  return String.class;
               }
   
               @Override
               public Class<?>[] getParameterTypes() {
                  return new Class<?>[0];
               }
   
               @Override
               public Object invoke(Object obj, Object[] args) {
                  return ((RootChildren) obj).getStringAttr();
               }
            }, new Method(RootChildren.class, Member.PUBLIC, "setStringAttr") {
               @Override
               public Class<?> getReturnType() {
                  return Void.class;
               }
   
               @Override
               public Class<?>[] getParameterTypes() {
                  return new Class<?>[] { String.class };
               }
   
               @Override
               public Object invoke(Object obj, Object[] args) {
                  ((RootChildren) obj).setStringAttr((String) args[0]);
                  return null;
               }
            }));
      } catch (IntrospectionException e) {

      }
   }
}
