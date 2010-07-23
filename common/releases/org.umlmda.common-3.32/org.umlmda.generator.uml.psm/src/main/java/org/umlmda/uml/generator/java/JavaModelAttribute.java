/*
 * Created on 28.11.2005
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorAttribute;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelMethod;

/**
 * @author MOROFF
 */
public interface JavaModelAttribute extends JavaModelStructuraleFeature, GeneratorAttribute, ModelAttribute
{

   /**
    * Returns the java datatype in the generated sources
    */
   String getJavaType();

   /**
    * Checks if the attribute is implemented by a primitive java type
    */
   boolean isJavaPrimitiveType();
}
