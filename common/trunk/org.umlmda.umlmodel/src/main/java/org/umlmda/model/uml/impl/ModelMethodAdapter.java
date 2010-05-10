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
// Created on Jun 7, 2005
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.model.uml.ModelVisitor;

/**
 * platform independent adapter to MOF model method. extend for specific platform to override the following properties:
 * parameters, exceptions, return type, owning class
 * 
 * @author vpussel
 */
public class ModelMethodAdapter extends ModelElementAdapter implements ModelMethod
{

   private final ModelMethodBase modelMethod;
   private List                  parameters  = null;
   private List                  exceptions  = null;
   private ModelClassifier       returnType  = null;
   private ModelClass            owningClass = null;

   /**
    * create adapter for model method
    */
   public ModelMethodAdapter(ModelMethodBase modelMethod, Model model) {
      super(modelMethod, model);

      this.modelMethod = modelMethod;
   }

   /**
    * Reset cached information
    * 
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      if ( PROPERTY_PARAMETERS.equals(arg) && parameters != null ) {
         parameters.clear();
         parameters = null;
      }
      else if ( PROPERTY_EXCEPTIONS.equals(arg) && exceptions != null ) {
         exceptions.clear();
         exceptions = null;
      }
      else if ( PROPERTY_RETURN_TYPE_BASE.equals(arg) && returnType != null ) {
         returnType = null;
      }
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethod#getParameters()
    */
   public final List getParameters() {
      if ( parameters == null ) {
         parameters = new ArrayList();
         for ( Iterator iter = modelMethod.getParameters().iterator(); iter.hasNext(); ) {
            ModelParameterBase parm = (ModelParameterBase) iter.next();
            ModelParameter newParm = adaptedModel.getModelParameter(parm);
            parameters.add(newParm);
         }
      }
      return parameters;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethod#getExceptions()
    */
   public List getExceptions() {
      if ( exceptions == null ) {
         exceptions = new ArrayList();
         for ( Iterator iter = modelMethod.getExceptions().iterator(); iter.hasNext(); ) {
            ModelClassBase exc = (ModelClassBase) iter.next();
            ModelClass newExc = adaptedModel.getModelClass(exc);
            exceptions.add(newExc);
         }
      }
      return exceptions;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethod#getReturnType()
    */
   public ModelClassifier getReturnType() {
      if ( returnType == null ) {
         returnType = adaptedModel.getModelClassifier(modelMethod.getReturnTypeBase());
      }
      return returnType;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethodBase#getReturnTypeBase()
    */
   public ModelClassifierBase getReturnTypeBase() {
      return getReturnType();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethod#getOwningClass()
    */
   public ModelClassBase getOwningClass() {
      if ( owningClass == null ) {
         owningClass = adaptedModel.getModelClass(modelMethod.getOwningClass());
      }
      return owningClass;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

}
