/*
 * Created on 17.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml.validate;

import java.util.Collection;
import java.util.List;

import org.umlmda.model.uml.ModelElement;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ModelElementValidator {

   /**
    * 
    * @param modelElement
    * @return
    */
   boolean isAppropriateFor(Class modelElementType);
   
   /**
    * 
    * @param stereotypes
    * @return
    */
   boolean isAppropriateForStereotypes(Collection stereotypes);
   
   /**
    * Validates a model element, returns a list of @link ValidationResult 
    * @param modelElement
    * @return
    */
   List validate(ModelElement modelElement);
   
}
