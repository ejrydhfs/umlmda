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
package org.umlmda.model.uml.uml2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelMethodBase;

/**
 * @author moroff
 */
public class ModelMethodImpl extends ModelElementImpl implements ModelMethodBase
{
   private final Operation           method;
   private List<ModelParameterImpl>  parameters;
   private List<ModelClassifierBase> exceptions;
   private ModelClassifierBase       returnType;

   public ModelMethodImpl(ModelImpl model, Operation method) {
      super(model, method);
      this.method = method;
   }

   /**
    * @return
    */
   public List<ModelParameterImpl> getParameters() {
      if ( parameters == null ) {
         parameters = new ArrayList<ModelParameterImpl>(method.getOwnedParameters().size());
         exceptions = new ArrayList<ModelClassifierBase>();

         for ( Parameter parameter : method.getOwnedParameters() ) {
            if ( parameter.getDirection().getValue() == ParameterDirectionKind.OUT && parameter.isException() )
               exceptions.add(model.findClassifier((Classifier) parameter.getType()));
            else if ( parameter.getDirection().getValue() == ParameterDirectionKind.RETURN ) {
               if ( parameter.getType() != null ) {
                  returnType = model.findClassifier((Classifier) parameter.getType());
               }
               else {
                  returnType = null;
               }
            }
            else
               parameters.add(new ModelParameterImpl(model, parameter));
         }
      }
      return parameters;
   }

   public List<ModelClassifierBase> getExceptions() {
      if ( exceptions == null ) {
         getParameters();
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

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttribute#getOwningClass()
    */
   public ModelClassBase getOwningClass() {
      return model.findClass((Class) method.getOwner());
   }

}
