/*
 * Created on 17.11.2005
 */
package org.umlmda.model.uml.validate;

import java.util.Collection;
import java.util.List;

import org.umlmda.model.uml.ModelElement;

/**
 * @author MOROFF
 */
public interface ModelElementValidator
{

   /**
    * @param modelElement
    * @return
    */
   boolean isAppropriateFor(Class modelElementType);

   /**
    * @param stereotypes
    * @return
    */
   boolean isAppropriateForStereotypes(Collection stereotypes);

   /**
    * Validates a model element, returns a list of @link ValidationResult
    * 
    * @param modelElement
    * @return
    */
   List validate(ModelElement modelElement);

}
