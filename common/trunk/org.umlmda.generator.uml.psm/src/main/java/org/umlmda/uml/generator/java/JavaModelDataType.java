/*
 * Created on 08.12.2005
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorDataType;
import org.umlmda.model.uml.ModelDataType;

/**
 * @author MOROFF
 */
public interface JavaModelDataType extends JavaModelClassifier, ModelDataType, GeneratorDataType
{

   /**
    * Returns the java datatype
    * 
    * @return
    */
   String getJavaType();

   /**
    * Returns the java datatype for optional values
    * 
    * @return
    */
   String getOptionalJavaType();

   /**
    * Checks if the attribute is implemented by a primitive java type
    */
   boolean isJavaPrimitiveType();

   TypeMappingStrategy getJavaTypeMappingStrategy();

   TypeMappingStrategy getPSMTypeMappingStrategy();

}
