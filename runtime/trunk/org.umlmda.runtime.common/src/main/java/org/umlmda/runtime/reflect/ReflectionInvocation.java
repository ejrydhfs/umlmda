package org.umlmda.runtime.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.umlmda.runtime.bean.BeanInvocation;
import org.umlmda.runtime.exception.FeatureNotImplemementedException;

/**
 * @author moroff
 */
public class ReflectionInvocation implements BeanInvocation
{

   private final Object bean;

   public ReflectionInvocation(Object bean) {
      this.bean = bean;
   }

   public Object getValue(String propertyName) {
      try {
         PropertyDescriptor descriptor = getDescriptor(propertyName);

         return descriptor.getReadMethod().invoke(bean, (Object[]) null);
      }
      catch (IllegalArgumentException e) {
         throw new RuntimeException(e);
      }
      catch (IllegalAccessException e) {
         throw new RuntimeException(e);
      }
      catch (InvocationTargetException e) {
         throw new RuntimeException(e);
      }
   }

   public void setValue(String propertyName, Object value) {
      try {
         PropertyDescriptor descriptor = getDescriptor(propertyName);

         descriptor.getWriteMethod().invoke(bean, new Object[] { value });
      }
      catch (IllegalArgumentException e) {
         throw new RuntimeException(e);
      }
      catch (IllegalAccessException e) {
         throw new RuntimeException(e);
      }
      catch (InvocationTargetException e) {
         throw new RuntimeException(e);
      }
      finally {

      }

   }

   public Object invoke(String methodName, Object... params) {
      throw new FeatureNotImplemementedException();
   }

   private PropertyDescriptor getDescriptor(String propertyName) {
      try {
         PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, bean.getClass());

         return descriptor;
      }
      catch (IntrospectionException e) {
         throw new RuntimeException(e);
      }
   }

}
