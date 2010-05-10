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
//  Created on Nov 9, 2004
package org.umlmda.model.uml;

/**
 * Model interface to the persistent UML attribute. Extended information available in @link org.umlmda.model.uml.ModelAttribute.
 * 
 * @author moroff
 */
public interface ModelAttributeBase extends ModelStructuralFeatureBase
{
   String PROPERTY_INITIAL_VALUE    = "initialValue";
   String PROPERTY_READ_ONLY        = "readOnly";
   String PROPERTY_TRANSIENT        = "transient";
   String PROPERTY_CONSTANT         = "constant";
   String PROPERTY_MODEL_CLASS_BASE = "modelClassBase";
   String PROPERTY_DATA_TYPE_BASE   = "dataTypeBase";

   String getType();

   /**
    * @return
    */
   ModelClassBase getModelClassBase();

   /**
    * @return
    */
   ModelDataTypeBase getDataTypeBase();

   /**
    * Checks whether the type of the attribute is a primitve type
    * 
    * @return <code>true</code> attribute type is primitive, <code>false</code> attribute type is not primitive.
    */
   boolean isPrimitiveType();

   boolean isConstant();

   boolean isTransient();

   /**
    * Attribute is readonly, no setter available
    */
   boolean isReadOnly();

   String getInitialValue();
}