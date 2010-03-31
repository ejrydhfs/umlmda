// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/IDLMethodHelper.java,v 1.3 2006/07/10 15:37:10 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/IDLMethodHelper.java,v $
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

import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.uml.generator.AbstractMethodHelper;

import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class IDLMethodHelper extends AbstractMethodHelper {

   /**
    * @param classHelper
    */
   public IDLMethodHelper() {
      super(null);
   }

   /**
    * @param classHelper
    */
   public IDLMethodHelper(IClassHelper classHelper) {
      super(classHelper);
   }

   /**
    *  
    * @param method
    * @return
    */
   protected String getReturnTypeSignature(ModelMethod method) {
      return getClassHelper().getType(method.getReturnType());
   }
   
   protected String getParameterSignature(ModelParameter parameter) {
      ModelClassifier type = parameter.getType();
      StringBuffer signature = new StringBuffer();
      
      signature.append("in ");
      signature.append(getClassHelper().getType(type));
      signature.append(" ");
      signature.append(parameter.getName());   
      return signature.toString();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getExceptionDeclKeyword()
    */
   protected String getExceptionDeclKeyword() {
      return "raises (";
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getExceptionEndDeclKeyword()
    */
   protected String getExceptionEndDeclKeyword() {
      return " )";
   }

}


//-------------------------------------------------------------------------
//$Log: IDLMethodHelper.java,v $
//Revision 1.3  2006/07/10 15:37:10  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.2  2005/10/27 19:01:19  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:29  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.2  2004/10/09 20:27:35  moroff
//Supporting method signature with quoted exceptions (C++ and IDL)
//
//Revision 1.1  2004/10/06 19:33:14  moroff
//* Target language specific signatures put in help-classes, delegating to these 
//   classes inside the writer classes
//
//-------------------------------------------------------------------------