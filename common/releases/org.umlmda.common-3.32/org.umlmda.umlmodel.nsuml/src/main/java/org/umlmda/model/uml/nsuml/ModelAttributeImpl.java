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
package org.umlmda.model.uml.nsuml;

import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.attributes.Multiplicity;
import org.umlmda.model.uml.internal.utils.ModelBaseUtils;

import ru.novosoft.uml.foundation.core.MAttribute;
import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MDataType;
import ru.novosoft.uml.foundation.data_types.MChangeableKind;
import ru.novosoft.uml.foundation.data_types.MExpression;
import ru.novosoft.uml.foundation.data_types.MMultiplicity;
import ru.novosoft.uml.foundation.data_types.MScopeKind;

/**
 * @author moroff Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ModelAttributeImpl extends ModelStructuralFeatureImpl implements ModelAttributeBase
{
   private ModelClassBase    modelClass    = null;
   private ModelDataTypeBase modelDataType = null;
   private final MAttribute  attribute;
   private Multiplicity      multiplicity  = null;

   /**
    * @param attribute
    */
   public ModelAttributeImpl(ModelImpl model, MAttribute attribute) {
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
            modelClass = model.findClass((MClass) attribute.getType());
      }
      return modelClass;
   }

   /**
    * @return
    */
   public ModelDataTypeBase getDataTypeBase() {
      if ( modelDataType == null && isPrimitiveType() )
         modelDataType = model.findDataType((MDataType) attribute.getType());
      return modelDataType;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isOptional()
    */
   public boolean isOptional() {
      return false;
   }

   /**
    * Checks whether the type of the attribute is a primitve type
    * 
    * @return <code>true</code> attribute type is primitive, <code>false</code> attribute type is not primitive.
    */
   public boolean isPrimitiveType() {
      return attribute.getType() instanceof MDataType;
   }

   public boolean isConstant() {
      return isConstant(attribute);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isReadOnly()
    */
   public boolean isReadOnly() {
      return attribute.getChangeability() == MChangeableKind.FROZEN;
   }

   public boolean isTransient() {
      return Boolean.valueOf(attribute.getTaggedValue("transient", "false")).booleanValue();
   }

   public String getInitialValue() {
      MExpression expr = attribute.getInitialValue();

      return expr != null ? expr.getBody() : null;
   }

   static boolean isConstant(MAttribute attribute) {
      return (attribute.getInitialValue() != null && attribute.getOwnerScope() == MScopeKind.CLASSIFIER && attribute
            .getChangeability() == MChangeableKind.FROZEN);
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAttributeBase#getOwningClassBase()
    */
   public ModelClassBase getOwningClassBase() {
      return model.findClass((MClass) attribute.getOwner());
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getMultiplicity()
    */
   public Multiplicity getMultiplicity() {
      if ( multiplicity == null ) {
         MMultiplicity range = attribute.getMultiplicity();

         if ( range != null ) {
            multiplicity = new Multiplicity(range.getLower(), range.getUpper());
         }
         else {
            multiplicity = ModelBaseUtils.getMultiplicityByStereotype(this);
         }
      }
      return multiplicity;
   }

}
