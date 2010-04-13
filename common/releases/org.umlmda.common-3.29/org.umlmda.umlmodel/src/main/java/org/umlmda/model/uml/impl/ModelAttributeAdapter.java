// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAttributeAdapter.java,v 1.5 2006/04/12 20:18:23 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAttributeAdapter.java,v $
// $Revision: 1.5 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/04/12 20:18:23 $
//   $Locker:  $
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
// Created on Jun 7, 2005
package org.umlmda.model.uml.impl;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelVisitor;

/**
 * platform independent adapter to MOF model attributes.
 * extend for specific platform to override the following properties:
 * type, data type
 *
 * @author vpussel
 *
 */
public class ModelAttributeAdapter extends ModelStructuralFeatureAdapter implements
		ModelAttribute {
	
	private final ModelAttributeBase modelAttribute;

	private ModelClass modelClass = null; // class type of this attribute
	private ModelDataType modelDataType = null;
	private ModelClassifier modelClassifier = null;
	private ModelClass owningClass = null;

	/**
	 * create adapter from model attribute
	 */
	public ModelAttributeAdapter(ModelAttributeBase modelAttribute, Model model) {
		super(modelAttribute, model);

		this.modelAttribute = modelAttribute;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getDataType()
	 */
	public ModelDataType getDataType() {
		if (modelDataType == null) {
			modelDataType = adaptedModel.getModelDataType(modelAttribute.getDataTypeBase());
		}
		return modelDataType;
	}

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAttributeBase#getDataTypeBase()
    */
   public ModelDataTypeBase getDataTypeBase() {
      return getDataType();
   }
   
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getInitialValue()
	 */
	public String getInitialValue() {
		return modelAttribute.getInitialValue();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getModelClassifier()
	 */
	public ModelClassifier getModelClassifier() {
      if ( isPrimitiveType() )
         return getDataType();
      else
         return getModelClass(); 
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getModelClass()
	 */
	public ModelClass getModelClass() {
		if (modelClass == null) {
			modelClass = adaptedModel.getModelClass(modelAttribute.getModelClassBase());
		}
		return modelClass;
	}

	public ModelClassBase getModelClassBase() {
		return getModelClass();
	}

	public ModelClass getOwningClass() {
		return (ModelClass)getOwningClassBase();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getType()
	 */
	public String getType() {
		return modelAttribute.getType();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#isClassInstance()
	 */
	public boolean isClassInstance() {
	   return isPrimitiveType() == false;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#isConstant()
	 */
	public boolean isConstant() {
		return modelAttribute.isConstant();
	}

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isReadOnly()
    */
   public boolean isReadOnly() {
      return modelAttribute.isReadOnly();
   }
   
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#isPrimitiveType()
	 */
	public boolean isPrimitiveType() {
		return modelAttribute.isPrimitiveType();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#isTransient()
	 */
	public boolean isTransient() {
		return modelAttribute.isTransient();
	}
   
   public String toString() {
      if ( getModelClassifier() != null ) {
         return getQualifiedName() + " : " + getModelClassifier().getQualifiedName();
      }
      else {
         return getQualifiedName();
      }
   }


   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }
   
}
