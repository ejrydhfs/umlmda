// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelMethodImpl.java,v 1.2 2006/04/13 23:03:54 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelMethodImpl.java,v $
// $Revision: 1.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/04/13 23:03:54 $
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
package org.umlmda.model.uml.nsuml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelMethodBase;

import ru.novosoft.uml.behavior.common_behavior.MSignal;
import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MOperation;
import ru.novosoft.uml.foundation.core.MParameter;

/**
 * @author moroff
 */
public class ModelMethodImpl extends ModelElementImpl implements ModelMethodBase {
   private final MOperation method;
   private List parameters;
   private List exceptions;
   private ModelClassifierBase returnType;
      
   public ModelMethodImpl(ModelImpl model, MOperation method) {
      super(model, method);
      this.method = method;
   }
   
   /**
    * @return
    */
   public List getParameters() {
      if ( parameters == null ) {
         parameters = new ArrayList(method.getParameters().size());
                 
         for (Iterator iter = method.getParameters().iterator(); iter.hasNext();) {
            MParameter parameter = (MParameter) iter.next();

            if ( parameter.getName().equals("return") ) {
               if ( parameter.getType().getName().equals(ModelDataType.VOID) == false ) {
                  returnType = model.findClassifier((MClassifier)parameter.getType());
               }
            }
            else
               parameters.add(new ModelParameterImpl(model, parameter));
         }                 
      }
      return parameters;
   }

   public List getExceptions() {
      if ( exceptions == null ) {
         exceptions = new ArrayList();
         
         for (Iterator iter = method.getRaisedSignals().iterator(); iter.hasNext();) {
            MSignal signal = (MSignal) iter.next();
            
            exceptions.add(model.findClassifier(signal));
         }
      }
      return exceptions;
   }
   /**
    * @return
    */
   public ModelClassifierBase getReturnTypeBase() {
      if ( returnType == null ) {
         getParameters();
      }
      return returnType;
   }

   /**
    * @return
    */
   public String getName() {
      return method.getName();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getOwningClass()
    */
   public ModelClassBase getOwningClass() {
      return model.findClass((MClass)method.getOwner());
   }
   
}
