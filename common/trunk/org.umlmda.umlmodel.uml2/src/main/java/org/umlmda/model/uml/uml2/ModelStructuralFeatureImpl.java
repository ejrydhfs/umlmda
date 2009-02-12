// jUMLMDA, UMLModel-API
//
// $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelStructuralFeatureImpl.java,v 1.1.2.1 2006/11/20 10:47:08 moroff Exp $
// $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelStructuralFeatureImpl.java,v $
// $Revision: 1.1.2.1 $
//  $State: Exp $
//   $Name: oAW $
//   $Date: 2006/11/20 10:47:08 $
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
//
package org.umlmda.model.uml.uml2;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;
import org.umlmda.model.uml.ModelStructuralFeatureBase;


/**
 * @author moroff
 */
public abstract class ModelStructuralFeatureImpl extends ModelElementImpl implements
      ModelStructuralFeatureBase {

   /**
    * @param model
    * @param modelElement
    */
   public ModelStructuralFeatureImpl(ModelImpl model, Element modelElement) {
      super(model, modelElement);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeature#isDerived()
    */
   public boolean isDerived() {
      StructuralFeature feature = (StructuralFeature) modelElement;

      if (feature instanceof Property) {
         Property property = (Property) feature;
         
         return property.isDerived();
      }
      else
         return false;
   }
   
}
