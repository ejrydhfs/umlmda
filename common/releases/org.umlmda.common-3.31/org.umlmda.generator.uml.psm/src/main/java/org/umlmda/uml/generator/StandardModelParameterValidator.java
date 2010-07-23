/* This library is free software; you can redistribute it and/or
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

import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.validate.AbstractModelParameterValidator;

/**
 * @author MOROFF
 */
public class StandardModelParameterValidator extends AbstractModelParameterValidator
{
   final private boolean noTypesAllowed;

   /**
    * 
    */
   public StandardModelParameterValidator() {
      this(false);
   }

   /**
    * 
    */
   public StandardModelParameterValidator(boolean noTypesAllowed) {
      super();
      this.noTypesAllowed = noTypesAllowed;
   }

   /*
    * (non-Javadoc)
    * @see
    * org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public List validateParameter(ModelParameter parameter) {
      List results = Collections.EMPTY_LIST;
      ModelClassifier classifier = parameter.getType();
      ModelMethod method = (ModelMethod) parameter.getOwner();

      results = validateTypeExistence(method, parameter, results, classifier);
      return results;
   }

   /**
    * Checks if the attribute has a type
    * 
    * @param modelAttribute
    * @param results
    * @param classifier
    * @return
    */
   protected List validateTypeExistence(ModelMethod method, ModelParameter parameter, List results, ModelClassifier classifier) {
      if ( classifier == null ) {
         if ( noTypesAllowed == false ) {
            return addResult(method, results, "No type specified for " + parameter.getName());
         }
      }
      return results;
   }

}
