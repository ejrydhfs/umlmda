/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/StandardModelClassValidator.java,v 1.1.2.1 2008/03/11 15:46:23 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/StandardModelClassValidator.java,v $
 * $Revision: 1.1.2.1 $
 *     $Name:  $
 *     $Date: 2008/03/11 15:46:23 $
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
 * Created on 02.11.2006 (Dieter Moroff)
 */
package org.umlmda.uml.generator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.validate.AbstractModelClassValidator;
import org.umlmda.profile.ModelStereotype;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StandardModelClassValidator extends AbstractModelClassValidator {

   /**
    * 
    */
   public StandardModelClassValidator() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.validate.AbstractModelClassValidator#validateClass(org.umlmda.model.uml.ModelClass)
    */
   public List validateClass(ModelClass modelClass) {
      List results = Collections.EMPTY_LIST;
      
      // Check enumerations
      if ( modelClass.hasStereotype(ModelStereotype.ENUMERATION)) {
         if ( modelClass.getAttributes().size() == 0 ) {
            return addResult(modelClass, results, "Enumeration does not contain attributes");
         }
      }
      
      // Check generalizations
      int countExtendGen = 0;
      for (Iterator ig = modelClass.getGeneralizations().iterator(); ig.hasNext();) {
         ModelGeneralization generalization = (ModelGeneralization) ig.next();
         
         if ( generalization.hasStereotype(ModelStereotype.EXTENDS)) {
            ++countExtendGen;
         }
         
         if ( generalization.getGeneral() == null ) {
            addResult(modelClass, results, "General end not defined or unreachable");
         }
      }

      if ( countExtendGen > 1 ) {
         addResult(modelClass, results, "Only one <<Extend>> generalization allowed");
      }
      return results;
   }

}
