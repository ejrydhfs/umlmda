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
 * Created by Dieter Moroff (03.04.2006)
 */
package org.umlmda.model.uml.impl;

import java.util.Observable;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelStructuralFeatureBase;
import org.umlmda.model.uml.attributes.Multiplicity;

/**
 * Basic implementation of a structural feature
 * 
 */
public class ModelStructuralFeatureImpl extends ModelElementImpl implements ModelStructuralFeatureBase
{
   private boolean      derived      = false;
   private boolean      readOnly     = false;
   private Multiplicity multiplicity = new Multiplicity(0, 1);

   /**
    * @param model
    * @param owner
    */
   public ModelStructuralFeatureImpl(ModelBase model, ModelElementBase owner) {
      super(model, owner);
      initObserver();
   }

   /**
    * @param model
    * @param owner
    * @param source
    */
   public ModelStructuralFeatureImpl(ModelBase model, ModelElementBase owner, ModelStructuralFeatureBase source) {
      super(model, owner, source);
      setDerived(source.isDerived());
      setMultiplicity(source.getMultiplicity());
      initObserver();
   }

   private void initObserver() {
      multiplicity.addObserver(this);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      super.update(o, arg);
      if ( o == multiplicity ) {
         notifyObservers(PROPERTY_MULTIPLICITY);
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#isDerived()
    */
   public boolean isDerived() {
      return derived;
   }

   public void setDerived(boolean derived) {
      this.derived = derived;
      notifyObservers(PROPERTY_DERIVED);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#isOptional()
    */
   public boolean isOptional() {
      return multiplicity.getLower() < 1;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getOwningClassBase()
    */
   public ModelClassBase getOwningClassBase() {
      return (ModelClassBase) getOwner();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getMultiplicity()
    */
   public Multiplicity getMultiplicity() {
      return multiplicity;
   }

   public void setMultiplicity(Multiplicity multiplicity) {
      this.multiplicity.deleteObserver(this);
      this.multiplicity = multiplicity;
      this.multiplicity.addObserver(this);
      notifyObservers(PROPERTY_MULTIPLICITY);
   }

   /**
    * @return Returns the readOnly.
    */
   public boolean isReadOnly() {
      return readOnly;
   }

   /**
    * @param readOnly
    *           The readOnly to set.
    */
   public void setReadOnly(boolean readOnly) {
      this.readOnly = readOnly;
      notifyObservers(PROPERTY_READ_ONLY);
   }
}
