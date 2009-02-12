// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelAttributeImpl.java,v 1.2.2.1.2.1 2008/04/09 13:05:33 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelAttributeImpl.java,v $
// $Revision: 1.2.2.1.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/04/09 13:05:33 $
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
package org.umlmda.model.uml.uml2;

import org.apache.commons.lang.StringUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.attributes.Multiplicity;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ModelAttributeImpl extends ModelStructuralFeatureImpl implements ModelAttributeBase {
   private ModelClassBase modelClass = null;
   private ModelDataTypeBase modelDataType = null;
   private final Property attribute;
   private Multiplicity multiplicity = null;
	
	/**
	 * @param attribute
	 */
	public ModelAttributeImpl(ModelImpl model, Property attribute) {
		super(model, attribute);
		this.attribute = attribute;
	}

	public String toString() {
		return attribute.getName() + " : " + attribute.getType().getName();
	}
   
   public String getType() {
      return attribute.getType().getName();
   }
   
   /**
    * @return
    */
   public ModelClassBase getModelClassBase() {
      if ( attribute.getType() != null ) {
         if ( modelClass == null && !isPrimitiveType() )
            modelClass = model.findClass((Class)attribute.getType());
      }
      return modelClass;
   }

   /**
    * @return
    */
   public ModelDataTypeBase getDataTypeBase() {
      if ( modelDataType == null && isPrimitiveType() )
         modelDataType = model.findDataType((DataType)attribute.getType());
      return modelDataType;
   }

   public boolean isConstant() {
      return isConstant(attribute);
   }

   /* (non-Javadoc)
	 * @see org.umlmda.model.uml.ModelStructuralFeature#isOptional()
	 */
	public boolean isOptional() {
		return false;
	}

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isReadOnly()
    */
   public boolean isReadOnly() {
      return attribute.isReadOnly();
   }
   
	/**
	 * Checks whether the type of the attribute is a primitve type
	 * @return <code>true</code> attribute type is primitive, <code>false</code>
	 * attribute type is not primitive.
	 */
	public boolean isPrimitiveType() {
	   return attribute.getType() instanceof DataType;
	}

	public boolean isTransient() {
      //TODO ModelAttributeImpl.isTransient()
      //return Boolean.getBoolean(attribute.getTaggedValue("transient", "false"));
      return false;
   }

   public String getInitialValue() {
      ValueSpecification expr = attribute.getDefaultValue();
      String initialValue = expr != null ? expr.stringValue() : null;
      
      if ( getDataTypeBase() != null && getDataTypeBase().getName().equals(ModelDataType.STRING) && expr instanceof LiteralString ) {
         return "\"" + initialValue + "\"";
      }
      else {
         return initialValue;
      }
   }
   
   static boolean isConstant(Property attribute) {
      return attribute.isStatic() && attribute.isReadOnly() && StringUtils.isNotEmpty(attribute.getDefault());
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttribute#getOwningClass()
    */
   public ModelClassBase getOwningClassBase() {
      return model.findClass((Class)attribute.getOwner());
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getMultiplicity()
    */
   public Multiplicity getMultiplicity() {
      if (multiplicity == null) {
         multiplicity = new Multiplicity(
               attribute.getLower(),
               attribute.getUpper());
      }
      return multiplicity;
   }
   
}
