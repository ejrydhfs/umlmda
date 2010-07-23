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
package org.umlmda.model.uml.mdr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.omg.uml.foundation.core.Classifier;
import org.omg.uml.foundation.core.Operation;
import org.omg.uml.foundation.core.Parameter;
import org.omg.uml.foundation.core.UmlClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelMethodBase;


/**
 * @author moroff
 */
public class ModelMethodImpl extends ModelElementImpl implements ModelMethodBase {
   private final Operation method;
   private List parameters;
   private List exceptions;
   private ModelClassifierBase returnType;
      
   public ModelMethodImpl(ModelImpl model, Operation method) {
      super(model, method);
      this.method = method;
   }
   
   /**
    * @return
    */
   public List getParameters() {
      if ( parameters == null ) {
         parameters = new ArrayList(method.getParameter().size());
                 
         for (Iterator iter = method.getParameter().iterator(); iter.hasNext();) {
            Parameter parameter = (Parameter) iter.next();

            if ( parameter.getName().equals("return") )
               returnType = model.findClassifier((Classifier)parameter.getType());
            else
               parameters.add(new ModelParameterImpl(model, parameter));
         }                 
      }
      return parameters;
   }

   public List getExceptions() {
      if ( exceptions == null ) {
         exceptions = new ArrayList();
         
         //TODO read exceptions         
//         for (Iterator iter = method.getRaisedSignal().iterator(); iter.hasNext();) {
//            MSignal signal = (MSignal) iter.next();
//            
//            exceptions.add(model.findClassifier(signal));
//         }
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
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethod#getOwningClass()
    */
   public ModelClassBase getOwningClass() {
      return model.findClass((UmlClass)method.getOwner());
   }
}
