// jUMLMDA, GeneratorBase-API
//  
//   $Header$
//   $Source$
// $Revision$
//    $State$
//     $Name$
//     $Date$
//   $Locker$
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
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelDataType;

/**
 * This helperclass for generating class signatures. This base implementation
 * return a java method signature. It can be derived to generate c++ or idl
 * class signatures.
 * @author Dieter Moroff
 */
public class JavaClassHelper extends AbstractClassHelper {
   /**
    * 
    */
   public JavaClassHelper() {
      super();
   }

   public String getType(ModelAttribute attribute) {
      return ((JavaModelAttribute)attribute).getJavaType();
   }

   public String getInitializer(ModelAttribute attribute) {
      if ( attribute.isOptional() || attribute.isMultivalue() ) {
         return "null";
      }
      else {
         return super.getInitializer(attribute);
      }
   }
   
   /**
    * @param type
    * @return
    */
   public String getType(ModelDataType type) {
      if ( type != null ) {
         return ((JavaModelDataType)type).getJavaType();
      }
      else {
         return "void";
      }
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespaceSep()
    */
   public String getNamespaceSep() {
      return ".";
   }


}


//-------------------------------------------------------------------------
//$Log$
//Revision 1.2  2007/01/15 09:27:30  moroff
//Support for timezone independent date (date and dateTime) types
//
//Revision 1.1  2006/07/10 15:35:33  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.4  2006/02/15 20:09:40  moroff
//Multiplicity
//
//Revision 1.3  2005/12/08 22:45:55  moroff
//Avoid NPE on missing attribute types
//
//Revision 1.2  2005/10/27 19:01:18  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:29  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.10  2005/06/24 15:33:01  vpussel
//add support for data type decimal
//
//Revision 1.9  2005/06/24 13:43:15  vpussel
//support data type "dateTime"
//
//Revision 1.8  2005/06/22 11:39:22  moroff
//* getStereotype() is deprecated
//* avoid using ModelElement.getStereotype()
//
//Revision 1.7  2005/06/09 08:51:22  moroff
//no type return void
//
//Revision 1.6  2005/05/25 11:28:38  tkacr
//handling optional attributes
//
//Revision 1.5  2005/04/07 20:16:03  moroff
//* Using constants
//
//Revision 1.4  2005/03/13 17:09:49  moroff
//Avoid dependency c++ from idl writers
//
//Revision 1.3  2005/01/22 20:54:24  moroff
//Use getPackageName to compare whether generated class and used class are in the same package.
//
//Revision 1.2  2004/10/09 20:18:32  moroff
//New method getNamespace()
//
//Revision 1.1  2004/10/06 19:33:14  moroff
//* Target language specific signatures put in help-classes, delegating to these 
//   classes inside the writer classes
//
//-------------------------------------------------------------------------