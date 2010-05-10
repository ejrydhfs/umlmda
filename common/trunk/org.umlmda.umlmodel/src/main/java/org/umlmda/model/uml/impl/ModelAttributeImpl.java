/*
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (10.04.2006)
 */
package org.umlmda.model.uml.impl;

import java.util.Observable;

import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelElementBase;

/**
 * Basic implementation of an attribute.
 * 
 */
public class ModelAttributeImpl extends ModelStructuralFeatureImpl implements ModelAttributeBase
{
   private ModelClassifierBase classifierBase;
   private ModelDataTypeBase   dataTypeBase;
   private ModelClassBase      modelClassBase;
   private boolean             constant     = false;
   private boolean             readOnly     = false;
   private boolean             _transient   = false;
   private String              initialValue = null;

   /**
    * @param model
    * @param owner
    */
   public ModelAttributeImpl(ModelBase model, ModelElementBase owner) {
      super(model, owner);
      initObserver();
   }

   public ModelAttributeImpl(ModelBase model, ModelElementBase owner, ModelAttributeBase source) {
      super(model, owner, source);
      setConstant(source.isConstant());
      setInitialValue(source.getInitialValue());
      setReadOnly(source.isReadOnly());
      setTransient(source.isTransient());
      if ( source.isPrimitiveType() )
         setDataTypeBase(source.getDataTypeBase());
      else
         setModelClassBase(source.getModelClassBase());
      initObserver();
   }

   private void initObserver() {
   }

   /*
    * (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      super.update(o, arg);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#getType()
    */
   public String getType() {
      return classifierBase.getName();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#getModelClassBase()
    */
   public ModelClassBase getModelClassBase() {
      return modelClassBase;
   }

   public void setModelClassBase(ModelClassBase modelClassBase) {
      this.modelClassBase = modelClassBase;
      this.classifierBase = modelClassBase;
      if ( this.dataTypeBase != null ) {
         this.dataTypeBase = null;
         notifyObservers(PROPERTY_DATA_TYPE_BASE);
      }
      notifyObservers(PROPERTY_MODEL_CLASS_BASE);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#getDataTypeBase()
    */
   public ModelDataTypeBase getDataTypeBase() {
      return dataTypeBase;
   }

   public void setDataTypeBase(ModelDataTypeBase dataTypeBase) {
      this.dataTypeBase = dataTypeBase;
      this.classifierBase = dataTypeBase;
      if ( this.modelClassBase != null ) {
         this.modelClassBase = null;
         notifyObservers(PROPERTY_MODEL_CLASS_BASE);
      }
      notifyObservers(PROPERTY_DATA_TYPE_BASE);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isPrimitiveType()
    */
   public boolean isPrimitiveType() {
      return dataTypeBase != null;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isConstant()
    */
   public boolean isConstant() {
      return constant;
   }

   public void setConstant(boolean constant) {
      this.constant = constant;
      notifyObservers(PROPERTY_CONSTANT);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isTransient()
    */
   public boolean isTransient() {
      return _transient;
   }

   public void setTransient(boolean _transient) {
      this._transient = _transient;
      notifyObservers(PROPERTY_TRANSIENT);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#getInitialValue()
    */
   public String getInitialValue() {
      return initialValue;
   }

   public void setInitialValue(String initialValue) {
      this.initialValue = initialValue;
      notifyObservers(PROPERTY_INITIAL_VALUE);
   }

   /**
    * @param classifierBase
    */
   public void setModelClassifierBase(ModelClassifierBase classifierBase) {
      if ( classifierBase instanceof ModelClassBase ) {
         setModelClassBase((ModelClassBase) classifierBase);
      }
      else {
         setDataTypeBase((ModelDataTypeBase) classifierBase);
      }
   }
}
