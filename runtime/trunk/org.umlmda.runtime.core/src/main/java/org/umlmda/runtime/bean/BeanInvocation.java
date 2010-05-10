package org.umlmda.runtime.bean;

/**
 * Interface to make reflective calls to a bean, usable in both java and google webtoolkit environment.
 * 
 * @author Dieter Moroff (11.4.2008)
 */
public interface BeanInvocation
{

   /**
    * Dynamic setter call
    * 
    * @param propertyName
    * @param value
    */
   void setValue(String propertyName, Object value);

   /**
    * Dynamic getter call
    * 
    * @param propertyName
    * @return
    */
   Object getValue(String propertyName);

   /**
    * Dynamic method invocation
    * 
    * @param methodName
    * @param params
    * @return
    */
   Object invoke(String methodName, Object... params);

   public interface Factory
   {
      BeanInvocation create(Object object);
   }
}
