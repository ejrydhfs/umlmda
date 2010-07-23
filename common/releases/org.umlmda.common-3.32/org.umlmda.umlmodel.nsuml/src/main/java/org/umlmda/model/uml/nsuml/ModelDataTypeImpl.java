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

import org.umlmda.model.uml.ModelDataTypeBase;

import ru.novosoft.uml.foundation.core.MDataType;

/**
 * primitive DataType of a UML model. This class wraps ru.novosoft.uml.foundation.core.MDataType to make a more easy access.
 * 
 * @author Dieter Moroff
 */
public class ModelDataTypeImpl extends ModelClassifierImpl implements ModelDataTypeBase
{
   private final MDataType modelDataType;

   ModelDataTypeImpl() {
      super();
      this.modelDataType = null;
   }

   public ModelDataTypeImpl(ModelImpl model, MDataType modelDataType) {
      super(model, modelDataType);
      this.modelDataType = modelDataType;
   }

   /**
    * @return the fully qualified name of the class
    */
   public String getQualifiedName() {
      return getName();
   }

}
