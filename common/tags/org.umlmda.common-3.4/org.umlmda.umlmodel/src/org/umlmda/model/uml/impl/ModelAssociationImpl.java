/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAssociationImpl.java,v 1.4 2006/10/29 10:44:10 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAssociationImpl.java,v $
 * $Revision: 1.4 $
 *     $Name:  $
 *     $Date: 2006/10/29 10:44:10 $
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

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.utils.observer.ObservableList;

/**
 * Basic implementation of a model association.
 * @author Dieter Moroff (03.04.2006), last change $Date: 2006/10/29 10:44:10 $ $Name:  $
 * @version $Revision: 1.4 $
 */
public class ModelAssociationImpl extends ModelStructuralFeatureImpl implements ModelAssociationBase {
   private ModelClassBase sourceBase;
   private ModelClassBase targetBase;
   private ModelAssociationBase reverseBase;
   private boolean aggregation = false;
   private boolean composition = false;
   private boolean navigatableToTarget = true;
   private boolean navigatableToSource = false;
   private ObservableList qualifiers = new ObservableList(new ArrayList());
   private boolean ordered = false;
   private boolean unique = true;
   
   /**
    * @param model
    * @param owner
    */
   public ModelAssociationImpl(ModelBase model, ModelElementBase owner) {
      super(model, owner);
      qualifiers.addObserver(this);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      super.update(o, arg);
      if ( o == qualifiers ) {
         notifyObservers(PROPERTY_QUALIFIER);
      }
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getSourceBase()
    */
   public ModelClassBase getSourceBase() {
      return sourceBase;
   }

   public void setSourceBase(ModelClassBase sourceBase) {
      this.sourceBase = sourceBase;
      notifyObservers(PROPERTY_SOURCE_BASE);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getTargetBase()
    */
   public ModelClassBase getTargetBase() {
      return targetBase;
   }

   public void setTargetBase(ModelClassBase targetBase) {
      this.targetBase = targetBase;
      notifyObservers(PROPERTY_TARGET_BASE);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getReverseBase()
    */
   public ModelAssociationBase getReverseBase() {
      return reverseBase;
   }

   public void setReverseBase(ModelAssociationBase reverseBase) {
      this.reverseBase = reverseBase;
      notifyObservers(PROPERTY_REVERSE_BASE);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isAggregation()
    */
   public boolean isAggregation() {
      return aggregation;
   }

   public void setAggregation(boolean aggregation) {
      this.aggregation = aggregation;
      notifyObservers(PROPERTY_AGGREGATION);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isComposition()
    */
   public boolean isComposition() {
      return composition;
   }

   public void setComposition(boolean composition) {
      this.composition = composition;
      notifyObservers(PROPERTY_COMPOSITION);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isMultiple()
    */
   public boolean isMultiple() {
      return getMultiplicity().isMultiple();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isNavigatableToTarget()
    */
   public boolean isNavigatableToTarget() {
      return navigatableToTarget;
   }

   public void setNavigatableToTarget(boolean navigatableToTarget) {
      this.navigatableToTarget = navigatableToTarget;
      notifyObservers(PROPERTY_NAVIGATABLE_TO_TARGET);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isNavigatableToSource()
    */
   public boolean isNavigatableToSource() {
      return navigatableToSource;
   }

   public void setNavigatableToSource(boolean navigatableToSource) {
      this.navigatableToSource = navigatableToSource;
      notifyObservers(PROPERTY_NAVIGATABLE_TO_SOURCE);
   }

   /**
    * Creates the reverse association from target to source
    * @return
    */
   public ModelAssociationImpl createReverse() {
      ModelAssociationImpl reverse = new ModelAssociationImpl(getModelBase(), getTargetBase());
      
      reverse.setName(null);
      reverse.setNavigatableToSource(isNavigatableToTarget());
      reverse.setNavigatableToTarget(isNavigatableToSource());
      reverse.setTargetBase(getSourceBase());
      reverse.setSourceBase(getTargetBase());
      reverse.setReverseBase(this);

      setReverseBase(reverse);
      
      return reverse;
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getQualifiers()
    */
   public List getQualifiers() {
      return qualifiers;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isOrdered()
    */
   public boolean isOrdered() {
      return ordered;
   }

   public void setOrdered(boolean ordered) {
      this.ordered = ordered;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isUnique()
    */
   public boolean isUnique() {
      return unique;
   }
   
   public void setUnique(boolean unique) {
      this.unique = unique;
   }
}
