// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelDataTypeAdapter.java,v 1.3 2006/04/27 11:30:49 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelDataTypeAdapter.java,v $
// $Revision: 1.3 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/04/27 11:30:49 $
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
// Created on Jun 8, 2005
package org.umlmda.model.uml.impl;

import java.util.HashMap;
import java.util.Map;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelVisitor;

/**
 * platform independent adapter to MOF model data type.
 * extend for specific platform to override the following properties:
 * platform specific type names
 *
 * @author vpussel
 *
 */
public class ModelDataTypeAdapter extends ModelElementAdapter implements ModelDataType {

   private final ModelDataTypeBase modelDataType;
   private static Map typeMapping = new HashMap();
   
   static {
      typeMapping.put(ModelDataType.BINARY, ModelDataType.BINARY);
      typeMapping.put(ModelDataType.BOOLEAN, ModelDataType.BOOLEAN);
      typeMapping.put(ModelDataType.CHAR, ModelDataType.CHAR);
      typeMapping.put(ModelDataType.DATE, ModelDataType.DATE);
      typeMapping.put(ModelDataType.DATE_TIME, ModelDataType.DATE_TIME);
      typeMapping.put(ModelDataType.DECIMAL, ModelDataType.DECIMAL);
      typeMapping.put(ModelDataType.DOUBLE, ModelDataType.DOUBLE);
      typeMapping.put(ModelDataType.FLOAT, ModelDataType.FLOAT);
      typeMapping.put(ModelDataType.INT, ModelDataType.INT);
      typeMapping.put(ModelDataType.LONG, ModelDataType.LONG);
      typeMapping.put(ModelDataType.SHORT, ModelDataType.SHORT);
      typeMapping.put(ModelDataType.STRING, ModelDataType.STRING);
      typeMapping.put(ModelDataType.TIMESTAMP, ModelDataType.TIMESTAMP);
      typeMapping.put(ModelDataType.VOID, ModelDataType.VOID);
   }
   
   /**
    * create adapter for model data type
    */
   public ModelDataTypeAdapter(ModelDataTypeBase modelDataType, Model model) {
      super(modelDataType, model);

      this.modelDataType = modelDataType;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

}
