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
 * Created by Dieter Moroff (02.05.2006)
 */
package org.umlmda.uml.generator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.validate.AbstractModelMethodValidator;
import org.umlmda.profile.ModelStereotype;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (02.05.2006), last change $Date$ $Name$
 * @version $Revision$
 */
public class StandardModelMethodValidator extends AbstractModelMethodValidator {

   /**
    * 
    */
   public StandardModelMethodValidator() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.validate.AbstractModelMethodValidator#validateMethod(org.umlmda.model.uml.ModelMethod)
    */
   protected List validateMethod(ModelMethod method) {
      List results = Collections.EMPTY_LIST;
      
      results = validateReturnType(method, method.getReturnType(), results);
      results = validateExceptions(method, method.getExceptions(), results);
      return results;
   }

   /**
    * Checks if the attribute has a type
    * @param modelAttribute
    * @param results
    * @param classifier
    * @return
    */
   protected List validateReturnType(ModelMethod method, ModelClassifier returnType, List results) {
      if ( returnType != null ) {
         if ( returnType instanceof ModelDataType && returnType.getName().equals(ModelDataType.VOID) ) {
            return addResult(method, results, "Returntype void not valid, remove return type");
         }
      }
      return results;
   }

   /**
    * @param method
    * @param exceptions
    * @param results
    * @return
    */
   protected List validateExceptions(ModelMethod method, List exceptions, List results) {
      for (Iterator ie = exceptions.iterator(); ie.hasNext();) {
         ModelClass exception = (ModelClass) ie.next();
         
         if ( exception.hasStereotype(ModelStereotype.BUSINESS_EXCEPTION) == false 
           && exception.hasStereotype(ModelStereotype.NATIVE_CLASS) == false ) {
            return addResult(method, results, "Exception classes, must contain stereotype <<"+ModelStereotype.BUSINESS_EXCEPTION
                  +">> or <<"+ModelStereotype.NATIVE_CLASS+">>");
         }
      }
      return results;
   }

   
}
