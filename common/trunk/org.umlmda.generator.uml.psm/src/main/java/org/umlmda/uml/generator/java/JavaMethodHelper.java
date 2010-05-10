// UMLMDA, GeneratorBase-API
//  
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

import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.AbstractMethodHelper;

/**
 * This helperclass for generating method signature. This base implementation return a java method signature. It can be derived to
 * generate c++ or idl methd signatures.
 * 
 * @author Dieter Moroff
 */
public class JavaMethodHelper extends AbstractMethodHelper
{

   /**
    * @param classHelper
    */
   public JavaMethodHelper() {
      super(null);
   }

   /**
    * @param classHelper
    */
   public JavaMethodHelper(IClassHelper classHelper) {
      super(classHelper);
   }

   protected String getParameterSignature(ModelParameter parameter) {
      ModelClassifier type = parameter.getType();
      StringBuffer signature = new StringBuffer();

      if ( type instanceof JavaModelClass ) {
         signature.append(((JavaModelClass) type).getJavaType());
      }
      else {
         signature.append(getClassHelper().getType((ModelDataType) type));
      }
      signature.append(" ");
      signature.append(parameter.getName());
      return signature.toString();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractMethodHelper#getExceptionDeclKeyword()
    */
   protected String getExceptionDeclKeyword() {
      return "throws";
   }

   protected String getReturnTypeSignature(ModelMethod method) {
      if ( method instanceof JavaModelMethod ) {
         JavaModelMethod javaMethod = (JavaModelMethod) method;

         return javaMethod.getJavaType();
      }
      else {
         return super.getReturnTypeSignature(method);
      }
   }

}