/*
 * Created on 29.11.2005
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.model.uml.ModelElement;

/**
 * @author moroff
 */
public interface JavaModelElement extends GeneratorModelElement, ModelElement
{

   /**
    * Returns the name of the model element as an uppercase identifier.
    * 
    * @return
    */
   String getUpperCaseIdentifier();

}
