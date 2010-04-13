/*
 * Created on 28.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorAttribute;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelMethod;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface JavaModelAttribute extends JavaModelStructuraleFeature, GeneratorAttribute, ModelAttribute {

   /**
    * Returns the java datatype in the generated sources 
    */
   public String getJavaType();
   
   /**
    * Checks if the attribute is implemented by a primitive java type
    */
   public boolean isJavaPrimitiveType();
}
