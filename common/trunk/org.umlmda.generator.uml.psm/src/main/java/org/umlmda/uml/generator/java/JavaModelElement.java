/*
 * Created on 29.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.model.uml.ModelElement;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface JavaModelElement extends GeneratorModelElement, ModelElement {
   
   /**
    * Returns the name of the model element as an uppercase identifier. 
    * @return
    */
   public String getUpperCaseIdentifier();

}
