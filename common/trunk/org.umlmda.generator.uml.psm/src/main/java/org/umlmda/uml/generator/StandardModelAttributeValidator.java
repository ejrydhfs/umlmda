/*
 *   $Header$
 *   $Source$
 * $Revision$
 *     $Name$
 *     $Date$
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (17.11.2005)
 */
package org.umlmda.uml.generator;

import java.util.Collections;
import java.util.List;

import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.validate.AbstractModelAttributeValidator;
import org.umlmda.profile.ModelStereotype;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StandardModelAttributeValidator extends AbstractModelAttributeValidator {
   final private boolean noTypesAllowed;
   
   /**
    * 
    */
   public StandardModelAttributeValidator() {
      this(false);
   }

   /**
    * 
    */
   public StandardModelAttributeValidator(boolean noTypesAllowed) {
      super();
      this.noTypesAllowed = noTypesAllowed;
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public List validateAttribute(ModelAttribute modelAttribute) {
      List results = Collections.EMPTY_LIST;
      ModelClassifier classifier = modelAttribute.getModelClassifier();
      
      results = validateTypeExistence(modelAttribute, results, classifier);
      results = validateTypeValidity(modelAttribute, results, classifier);
      return results;
   }

   /**
    * Checks if the attribute has a type
    * @param modelAttribute
    * @param results
    * @param classifier
    * @return
    */
   protected List validateTypeExistence(ModelAttribute modelAttribute, List results, ModelClassifier classifier) {
      if ( classifier == null ) {
         if ( noTypesAllowed == false ) {
            return addResult(modelAttribute, results, "No type specified");
         }
      }
      return results;
   }

   /**
    * Checks if the attribute has a type
    * @param modelAttribute
    * @param results
    * @param classifier
    * @return
    */
   protected List validateTypeValidity(ModelAttribute modelAttribute, List results, ModelClassifier classifier) {
      if ( classifier != null ) {
         if ( classifier instanceof ModelClass && classifier.hasStereotype(ModelStereotype.ENUMERATION) == false ) {
            return addResult(modelAttribute, results, "Only primitive types or enumerations allowed as attribute types");
         }
      }
      return results;
   }

   
   
}
