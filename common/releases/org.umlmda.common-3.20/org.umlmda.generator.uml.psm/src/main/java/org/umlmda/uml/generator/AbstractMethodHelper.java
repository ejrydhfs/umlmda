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
package org.umlmda.uml.generator;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.uml.generator.java.JavaArtefacts;
import org.umlmda.uml.generator.java.JavaClassHelper;
import org.umlmda.uml.generator.java.JavaModelClass;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractMethodHelper implements IMethodHelper {
   private IClassHelper classHelper = null;

   /**
    * 
    */
   public AbstractMethodHelper(IClassHelper classHelper) {
      super();
      this.classHelper = classHelper;
   }

   /**
    *  
    * @param method
    * @return
    */
   protected String getReturnTypeSignature(ModelMethod method) {
      if ( method.getReturnType() instanceof GeneratorClass ) {
         return getClassHelper().getGenClass().getScopedName(JavaArtefacts.BUSINESS_OBJECT_INTERFACE, (GeneratorClass)method.getReturnType());
      }
      else {
         return getClassHelper().getType((ModelDataType)method.getReturnType());
      }
   }
   
   public String getMethodSignature(ModelMethod method) {
      StringBuffer signature = new StringBuffer(1024);

      signature.append(getReturnTypeSignature(method));
      signature.append(" ");
      signature.append(getClassScopeSignature(method));
      signature.append(method.getName());
      signature.append(" (");
      signature.append(getParameterSignature(method));      
      signature.append(")");
      signature.append(getExceptionSignature(method));      
      return signature.toString();
   }

   /**
    * @param method
    * @return
    */
   protected String getClassScopeSignature(ModelMethod method) {
      return StringUtil.EMPTY;
   }

   /**
    * @param method
    * @return
    */
   protected String getExceptionSignature(ModelMethod method) {
      String platformExceptions = getPlatformExceptions();
      
      if ( method.getExceptions().size() > 0 || !StringUtils.isEmpty(platformExceptions) ) {
         StringBuffer signature = new StringBuffer(1024);
         
         signature.append(" ");
         signature.append(getExceptionDeclKeyword());
         signature.append(" ");
         if ( !StringUtils.isEmpty(platformExceptions) ) {
            signature.append(platformExceptions);
            if ( method.getExceptions().isEmpty() == false )
               signature.append(", ");
         }
         for (Iterator iter = method.getExceptions().iterator(); iter.hasNext();) {
            JavaModelClass exceptionClass = (JavaModelClass) iter.next();
            
            signature.append(exceptionClass.getJavaType());
            if ( iter.hasNext() ) {
               signature.append(", ");
            }
         }
         signature.append(getExceptionEndDeclKeyword());
         return signature.toString();
      }
      else
         return StringUtil.EMPTY;
   }

   /**
    * Overwrite to return a string with a comma separated list of
    * fully qualified exception names thrown on every method.
    * @return
    */
   protected String getPlatformExceptions() {
      return null;
   }

   /**
    * @return
    */
   protected String getExceptionEndDeclKeyword() {
      return StringUtil.EMPTY;
   }

   /**
    * @return
    */
   abstract protected String getExceptionDeclKeyword();

   /**
    * @param method
    * @return
    */
   protected String getParameterSignature(ModelMethod method) {
      StringBuffer signature = new StringBuffer(1024);
      
      for (Iterator iter = method.getParameters().iterator(); iter.hasNext();) {
         ModelParameter parameter = (ModelParameter) iter.next();
         
         signature.append(getParameterSignature(parameter));
         if ( iter.hasNext() )
            signature.append(", ");
      }
//TODO remove      
//      if ( method.hasStereotype(ModelStereotype.ASYNC_CALL) ) {
//         GeneratorClass serviceClass = (GeneratorClass) method.getOwner();
//         signature.append(", ");
//         signature.append(serviceClass.getScopedName(JavaArtefacts.SERVICE_LISTENER, serviceClass));
//         signature.append(" serviceListener");
//      }
      return signature.toString();
   }

   /**
    * @param parameter
    * @return
    */
   protected abstract String getParameterSignature(ModelParameter parameter);

   /**
    * @return
    */
   public IClassHelper getClassHelper() {
      return classHelper;
   }

   /**
    * @param helper
    */
   public void setClassHelper(IClassHelper helper) {
      classHelper = helper;
   }

}


//-------------------------------------------------------------------------
//$Log$
//Revision 1.3  2007/11/08 09:34:05  moroff
//Support NativeClass as modelled exceptions
//
//Revision 1.2  2007/02/12 09:06:58  moroff
//Organized imports
//
//Revision 1.1  2006/07/10 15:35:34  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.3  2006/06/26 20:37:25  moroff
//Refactory, generator independent stuf now in org.umlmda.generator.uml.psm
//
//Revision 1.2  2005/10/27 17:58:55  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:30  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.4  2005/03/03 22:19:31  moroff
//Bugfix #1151133: added classname in c++ generation of modeled methods in business objects
//
//Revision 1.3  2005/01/22 20:57:08  moroff
//New getPlatformExceptions
//
//Revision 1.2  2004/10/09 20:27:35  moroff
//Supporting method signature with quoted exceptions (C++ and IDL)
//
//Revision 1.1  2004/10/06 19:33:14  moroff
//* Target language specific signatures put in help-classes, delegating to these 
//   classes inside the writer classes
//
//-------------------------------------------------------------------------