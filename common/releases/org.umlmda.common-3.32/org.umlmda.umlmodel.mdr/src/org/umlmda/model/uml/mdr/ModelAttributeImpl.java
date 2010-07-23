// UMLMDA, UMLModel-API
// 
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
package org.umlmda.model.uml.mdr;



import java.util.Collection;
import java.util.Iterator;

import org.omg.uml.foundation.core.Attribute;
import org.omg.uml.foundation.core.DataType;
import org.omg.uml.foundation.core.UmlClass;
import org.omg.uml.foundation.datatypes.ChangeableKindEnum;
import org.omg.uml.foundation.datatypes.Expression;
import org.omg.uml.foundation.datatypes.ScopeKindEnum;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.attributes.Multiplicity;

/**
 * @author moroff
 *
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ModelAttributeImpl extends ModelStructuralFeatureImpl implements ModelAttributeBase {
   private ModelClassBase modelClass = null;
   private ModelDataTypeBase modelDataType = null;
   final Attribute attribute;
   private Multiplicity multiplicity = null;
	
	/**
	 * @param attribute
	 */
	public ModelAttributeImpl(ModelImpl model, Attribute attribute) {
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
      if ( modelClass == null && !isPrimitiveType() )
         modelClass = model.findClass((UmlClass)attribute.getType());
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
    * @see org.umlmda.model.uml.ModelAttributeBase#isReadOnly()
    */
   public boolean isReadOnly() {
      return attribute.getChangeability() == ChangeableKindEnum.CK_FROZEN;
   }
	
   /* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isOptional()
	 */
	public boolean isOptional() {
		return false;
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
      return Boolean.getBoolean(getTaggedValue("transient", "false"));
   }
   
   public String getInitialValue() {
      Expression expr = attribute.getInitialValue();

      return expr != null ? expr.getBody() : "";
   }
   
   static boolean isConstant(Attribute attribute) {
      return (
         attribute.getInitialValue() != null
            && attribute.getOwnerScope() == ScopeKindEnum.SK_CLASSIFIER
            && attribute.getChangeability() == ChangeableKindEnum.CK_FROZEN);
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getOwningClass()
    */
   public ModelClassBase getOwningClassBase() {
      return model.findClass((UmlClass)attribute.getOwner());
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getMultiplicity()
    */
   public Multiplicity getMultiplicity() {
      if (multiplicity == null) {
         Collection range = attribute.getMultiplicity().getRange();
         Iterator ir = range.iterator();
         int lower = ((Integer)ir.next()).intValue();
         int upper = ((Integer)ir.next()).intValue();
         multiplicity = new Multiplicity(lower, upper);
      }
      return multiplicity;
   }
   
}
