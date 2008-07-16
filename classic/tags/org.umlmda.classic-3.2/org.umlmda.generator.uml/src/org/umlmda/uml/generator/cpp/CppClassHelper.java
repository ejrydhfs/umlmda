// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/CppClassHelper.java,v 1.3 2006/07/10 15:37:15 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/CppClassHelper.java,v $
// $Revision: 1.3 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/07/10 15:37:15 $
//   $Locker:  $
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
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// Created on:      07.10.2004
package org.umlmda.uml.generator.cpp;

import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.profile.ModelTaggedValues;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelDataType;

/**
 * @author moroff
 */
public class CppClassHelper extends AbstractClassHelper {
   private String namespace = null;

   /**
    * C++ specific mapping of the IDL types
    * @see org.umlmda.generator.model.util.IClassHelper#getType(net.sourceforge.umlmda.xmi.uml.ModelDataType)
    */
   public String getType(ModelDataType type) {
      if ( type == null ) {
         return "void";
      }
      else if ( type.getName().equals(ModelDataType.BOOLEAN)) {
         return "bool";
      }
      else if ( type.getName().equals(ModelDataType.DATE)) {
         return "long";
      }
      else if ( type.getName().equals(ModelDataType.DATE_TIME)) {
         return "std::string";
      }
      else if ( type.getName().equals(ModelDataType.DECIMAL)) {
         return "double";
      }
      else if ( type.getName().equals(ModelDataType.STRING)) {
         return "std::string";
      }
      else if ( type.getName().equals(ModelDataType.TIMESTAMP)) {
         return "std::string";
      } 
      else
         return type.getName();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespace()
    */
   public String getNamespace(ModelClass modelClass) {
      return modelClass.getPackage().getTaggedValues().getProperty(ModelTaggedValues.CPP_NAMESPACE, modelClass.getPackage().getName());
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespaceSep()
    */
   public String getNamespaceSep() {
      return "::";
   }

}


//-------------------------------------------------------------------------
//$Log: CppClassHelper.java,v $
//Revision 1.3  2006/07/10 15:37:15  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.2  2005/10/27 19:04:41  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:29  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.8  2005/09/29 14:55:16  vpussel
//use tagged values from umlmda profile
//
//Revision 1.7  2005/06/24 15:33:01  vpussel
//add support for data type decimal
//
//Revision 1.6  2005/06/24 13:43:15  vpussel
//support data type "dateTime"
//
//Revision 1.5  2005/06/22 11:39:02  moroff
//handling getReturnType() == null
//
//Revision 1.4  2005/06/17 10:14:28  vpussel
//use data type literals
//
//Revision 1.3  2005/03/13 17:09:49  moroff
//Avoid dependency c++ from idl writers
//
//Revision 1.2  2005/03/10 20:38:57  moroff
//boolean mapped to bool for c++ generation
//
//Revision 1.1  2004/10/09 20:14:04  moroff
//*** empty log message ***
//
//-------------------------------------------------------------------------