/*
 * Created on 08.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorDataType;
import org.umlmda.model.uml.ModelDataType;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface JavaModelDataType extends JavaModelClassifier, ModelDataType, GeneratorDataType {

   /**
    * Returns the java datatype
    * @return
    */
   public String getJavaType();

   /**
    * Returns the java datatype for optional values
    * @return
    */
   public String getOptionalJavaType();

   /**
    * Checks if the attribute is implemented by a primitive java type
    */
   public boolean isJavaPrimitiveType();
      
   public TypeMappingStrategy getJavaTypeMappingStrategy();
   
   public TypeMappingStrategy getPSMTypeMappingStrategy();
   
}
