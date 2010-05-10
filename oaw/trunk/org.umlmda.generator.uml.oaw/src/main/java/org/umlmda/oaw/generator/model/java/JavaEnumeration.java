package org.umlmda.oaw.generator.model.java;

public interface JavaEnumeration extends JavaModelClass
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