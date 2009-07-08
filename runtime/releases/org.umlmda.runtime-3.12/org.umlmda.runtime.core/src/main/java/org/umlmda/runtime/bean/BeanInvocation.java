package org.umlmda.runtime.bean;

/**
 * Interface to make reflective calls to a bean, usable in both java and google webtoolkit
 * environment.
 * 
 * @author Dieter Moroff (11.4.2008)
 */
public interface BeanInvocation {

   /**
    * Dynamic setter call
    * @param propertyName
    * @param value
    */
   public abstract void setValue(String propertyName, Object value);

   /**
    * Dynamic getter call
    * @param propertyName
    * @return
    */
   public abstract Object getValue(String propertyName);
   
   /**
    * Dynamic method invocation
    * @param methodName
    * @param params
    * @return
    */
   public abstract Object invoke(String methodName, Object... params);

   public interface Factory {
      public abstract BeanInvocation create(Object object);
   }
}
