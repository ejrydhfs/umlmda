//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelStructuralFeatureAdapter.java,v 1.4 2006/11/18 11:57:57 moroff Exp $
//$Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelStructuralFeatureAdapter.java,v $
//$Revision: 1.4 $
// $State: Exp $
//  $Name:  $
//  $Date: 2006/11/18 11:57:57 $
//$Locker:  $
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Library General Public
//License as published by the Free Software Foundation; either
//version 2 of the License, or (at your option) any later version.
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//Library General Public License for more details.
//
//You should have received a copy of the GNU Library General Public
//License along with this library; if not, write to the
//Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//Boston, MA  02111-1307, USA. The text of license can be also found
//at http://www.gnu.org/copyleft/lgpl.html
//
//Created on Jun 9, 2005
package org.umlmda.model.uml.impl;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelStructuralFeature;
import org.umlmda.model.uml.ModelStructuralFeatureBase;
import org.umlmda.model.uml.attributes.Multiplicity;
import org.umlmda.profile.ModelStereotype;


/**
 * platform independent adapter to MOF model structural feature.
 * extend for specific platform to override the following properties:
 * isDerived, owning class
 *
 * @author vpussel
 *
 */
public abstract class ModelStructuralFeatureAdapter extends ModelElementAdapter
		implements ModelStructuralFeature {

	private final ModelStructuralFeatureBase modelStructuralFeature;
	private ModelClass owningClass = null;
	
	public ModelStructuralFeatureAdapter(ModelStructuralFeatureBase modelStructuralFeature, Model model) {
		super( modelStructuralFeature, model);
      this.modelStructuralFeature = modelStructuralFeature;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#getOwningClass()
	 */
	public ModelClassBase getOwningClassBase() {
		if (owningClass == null) {
			owningClass = adaptedModel.getModelClass(modelStructuralFeature.getOwningClassBase());
		}
		return owningClass;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isDerived()
	 */
	public boolean isDerived() {
		return modelStructuralFeature.isDerived();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isDerived()
	 */
	public boolean isReadOnly() {
		return modelStructuralFeature.isReadOnly();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#isOptional()
	 */
	public boolean isOptional() {
		boolean result = getMultiplicity().getLower() == 0
                      || hasStereotype(ModelStereotype.FEATURE_OPTIONAL) 
                      || hasStereotype(ModelStereotype.FEATURE_OPTIONAL_MULTIVALUE);
		return result;
	}

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeature#isMultivalue()
    */
   public boolean isMultivalue() {
      return getMultiplicity().isMultiple()
          || hasStereotype(ModelStereotype.FEATURE_MULTIVALUE) 
          || hasStereotype(ModelStereotype.FEATURE_OPTIONAL_MULTIVALUE);
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getMultiplicity()
    */
   public Multiplicity getMultiplicity() {
      return modelStructuralFeature.getMultiplicity();
   }
   
}
