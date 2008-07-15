// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/IDLClassHelper.java,v 1.3 2006/07/10 15:37:10 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/IDLClassHelper.java,v $
// $Revision: 1.3 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/07/10 15:37:10 $
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
// Created on:      06.10.2004
package org.umlmda.uml.generator.idl;

import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.profile.ModelTaggedValues;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;

/**
 * This helperclass for generating class signatures. This base implementation
 * return a java method signature. It can be derived to generate c++ or idl
 * class signatures.
 * @author Dieter Moroff
 */
public class IDLClassHelper extends AbstractClassHelper {
   
   /**
    * 
    */
   public IDLClassHelper() {
      super();
   }

   /**
    * @param type
    * @return
    */
   public String getType(ModelDataType type) {
      if ( type == null ) 
         return "void";
      else if ( type.getName().equals(ModelDataType.DECIMAL))
         return "double";
      else if ( type.getName().equals(ModelDataType.DATE))
         return "long";
      else if ( type.getName().equals(ModelDataType.INT))
         return "long";
      else if ( type.getName().equals(ModelDataType.DATE_TIME))
         return "string";
      else if ( type.getName().equals(ModelDataType.TIMESTAMP))
         return "string";
      else   
         return type.getName();
   }

   /**
    * Returns the qualified name of the given class. If the class is in the
    * same package the classname without package postfix will be returned.
    * If the class is in another package, the name with the ful qualified
    * package name is returned.
    */
   public String getType(ModelClassifier modelClassifier) {
      if (modelClassifier instanceof ModelClass) {
         ModelClass modelClass = (ModelClass) modelClassifier;

         if ( getNamespace(getModelClass()).equals(getNamespace(modelClass)) ) {
            return getClassName(modelClass);         
         }
         else
            return getNamespace(modelClass)+getNamespaceSep()+getClassName(modelClass);         
      }
      else
         return getType((ModelDataType)modelClassifier);         
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespace()
    */
   public String getNamespace(ModelClass modelClass) {
      return modelClass.getPackage().getTaggedValues().getProperty(ModelTaggedValues.CORBA_MODULE);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespaceSep()
    */
   public String getNamespaceSep() {
      return "::";
   }

}


//-------------------------------------------------------------------------
//$Log: IDLClassHelper.java,v $
//Revision 1.3  2006/07/10 15:37:10  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.2  2005/10/27 19:01:19  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:29  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.10  2005/09/29 14:55:16  vpussel
//use tagged values from umlmda profile
//
//Revision 1.9  2005/06/24 15:33:01  vpussel
//add support for data type decimal
//
//Revision 1.8  2005/06/24 13:43:15  vpussel
//support data type "dateTime"
//
//Revision 1.7  2005/06/21 20:21:12  moroff
//Handling no return type (void)
//
//Revision 1.6  2005/06/09 13:31:48  moroff
//Bugfix #1187205: idl name from package
//
//Revision 1.5  2005/03/13 17:09:49  moroff
//Avoid dependency c++ from idl writers
//
//Revision 1.4  2005/03/10 21:35:12  moroff
//Bugfix #1146208: mapping IDL types
//
//Revision 1.3  2004/12/08 22:13:39  moroff
//*** empty log message ***
//
//Revision 1.2  2004/10/09 20:18:32  moroff
//New method getNamespace()
//
//Revision 1.1  2004/10/06 19:33:14  moroff
//* Target language specific signatures put in help-classes, delegating to these 
//   classes inside the writer classes
//
//-------------------------------------------------------------------------