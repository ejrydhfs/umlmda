package org.umlmda.oaw.generator.model.webservice;

public interface WSEnumeration extends WSModelClass
{

   /**
    * Returns the java type of the literals
    */
   String getJavaValueType();

   /**
    * Returns if the literal is of a java primitive type
    */
   boolean isValuePrimitive();
}