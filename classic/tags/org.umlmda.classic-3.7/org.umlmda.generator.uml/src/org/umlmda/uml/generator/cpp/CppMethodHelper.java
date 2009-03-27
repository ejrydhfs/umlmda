// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/CppMethodHelper.java,v 1.4 2006/07/10 15:37:15 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/CppMethodHelper.java,v $
// $Revision: 1.4 $
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

import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.uml.generator.AbstractMethodHelper;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CppMethodHelper extends AbstractMethodHelper {
   private boolean sourceScope = false;
   
   /**
    * @param classHelper
    */
   public CppMethodHelper(IClassHelper classHelper, boolean sourceScope) {
      super(classHelper);
      this.sourceScope = sourceScope;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getExceptionDeclKeyword()
    */
   protected String getExceptionDeclKeyword() {
      return "throw (";
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getExceptionEndDeclKeyword()
    */
   protected String getExceptionEndDeclKeyword() {
      return " )";
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getParameterSignature(net.sourceforge.umlmda.xmi.uml.ModelParameter)
    */
   protected String getParameterSignature(ModelParameter parameter) {
      ModelClassifier type = parameter.getType();
      StringBuffer signature = new StringBuffer();
   
      if ( !(type instanceof ModelDataType) && parameter.getDirection() == ModelParameter.IN )
         signature.append("const ");
      signature.append(getClassHelper().getType(type));
      signature.append(" ");
      if ( !(type instanceof ModelDataType) && parameter.getDirection() == ModelParameter.IN )
         signature.append("&");
      if ( !(type instanceof ModelDataType) && parameter.getDirection() == ModelParameter.IN_OUT )
         signature.append("*");
      if ( !(type instanceof ModelDataType) && parameter.getDirection() == ModelParameter.OUT )
         signature.append("**");
      if ( (type instanceof ModelDataType)  && parameter.getDirection() == ModelParameter.IN_OUT )
         signature.append("*");
      signature.append(parameter.getName());   
      return signature.toString();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getReturnTypeSignature(net.sourceforge.umlmda.xmi.uml.ModelMethod)
    */
   protected String getReturnTypeSignature(ModelMethod method) {
      if ( method.getReturnType() instanceof ModelClass ) {
         return super.getReturnTypeSignature(method) + " *";
      }
      else {
         return super.getReturnTypeSignature(method);
      }
      
   }


   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getClassScopeSignature(net.sourceforge.umlmda.xmi.uml.ModelMethod)
    */
   protected String getClassScopeSignature(ModelMethod method) {
      if ( isSourceScope() )
         return method.getOwningClass().getName()+"::";
      else
         return StringUtil.EMPTY;
   }
   /**
    * @return Returns the sourceScope.
    */
   public boolean isSourceScope() {
      return sourceScope;
   }
   /**
    * @param sourceScope The sourceScope to set.
    */
   public void setSourceScope(boolean sourceScope) {
      this.sourceScope = sourceScope;
   }
}


//-------------------------------------------------------------------------
//$Log: CppMethodHelper.java,v $
//Revision 1.4  2006/07/10 15:37:15  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.3  2006/06/26 20:37:26  moroff
//Refactory, generator independent stuf now in org.umlmda.generator.uml.psm
//
//Revision 1.2  2005/10/27 19:04:41  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:29  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.2  2005/03/03 22:19:31  moroff
//Bugfix #1151133: added classname in c++ generation of modeled methods in business objects
//
//Revision 1.1  2004/10/09 20:14:04  moroff
//*** empty log message ***
//
//-------------------------------------------------------------------------