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
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelVisitor;

/**
 * platform independent adapter to MOF model association. extend for specific platform to override the following properties:
 * source, target, reverse, owning class
 * 
 * @author vpussel
 */
public class ModelAssociationAdapter extends ModelStructuralFeatureAdapter implements ModelAssociation
{

   public static class Comparator implements java.util.Comparator
   {
      public int compare(Object o1, Object o2) {
         ModelAssociationBase a1 = (ModelAssociationBase) o1;
         ModelAssociationBase a2 = (ModelAssociationBase) o2;

         return a1.getName().compareTo(a2.getName());
      }
   }

   private final ModelAssociationBase modelAssociation;

   private ModelClass                 target      = null;
   private ModelClass                 source      = null;
   private ModelAssociation           reverse     = null;
   private ModelClass                 owningClass = null;
   private List                       qualifiers  = null;

   /**
    * create adapter for model association
    */
   public ModelAssociationAdapter(ModelAssociationBase modelAssociation, Model model) {
      super(modelAssociation, model);

      this.modelAssociation = modelAssociation;
   }

   /**
    * Reset cached information
    * 
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      if ( PROPERTY_SOURCE_BASE.equals(arg) ) {
         source = null;
      }
      else if ( PROPERTY_TARGET_BASE.equals(arg) ) {
         target = null;
      }
      else if ( PROPERTY_QUALIFIER.equals(arg) ) {
         qualifiers.clear();
         qualifiers = null;
      }
      else {
         super.update(o, arg);
      }
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#getSource()
    */
   public ModelClass getSource() {
      if ( source == null ) {
         source = adaptedModel.getModelClass(modelAssociation.getSourceBase());
      }
      return source;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociationBase#getSourceBase()
    */
   public ModelClassBase getSourceBase() {
      return getSource();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#getTarget()
    */
   public ModelClass getTarget() {
      if ( target == null ) {
         target = adaptedModel.getModelClass(modelAssociation.getTargetBase());
      }
      return target;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociationBase#getTargetBase()
    */
   public ModelClassBase getTargetBase() {
      return getTarget();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#getReverse()
    */
   public ModelAssociation getReverse() {
      if ( reverse == null ) {
         reverse = adaptedModel.getModelAssociation(modelAssociation.getReverseBase());

         if ( reverse == null ) {
            // TODO Better exception handling
            System.err.println("Reverse of " + getQualifiedName() + " not found");
         }
      }

      return reverse;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociationBase#getReverseBase()
    */
   public ModelAssociationBase getReverseBase() {
      return getReverse();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isAggregation()
    */
   public boolean isAggregation() {
      return modelAssociation.isAggregation();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isComposition()
    */
   public boolean isComposition() {
      return modelAssociation.isComposition();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isMultiple()
    */
   public boolean isMultiple() {
      return modelAssociation.isMultiple();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isOptional()
    */
   public boolean isOptional() {
      return modelAssociation.isOptional();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isNavigatableToTarget()
    */
   public boolean isNavigatableToTarget() {
      return modelAssociation.isNavigatableToTarget();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isNavigatableToSource()
    */
   public boolean isNavigatableToSource() {
      return modelAssociation.isNavigatableToSource();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isUnspecified()
    */
   public boolean isUnspecified() {
      return (isAggregation() || isComposition()) == false;
   }

   public String toString() {
      StringBuffer buffer = new StringBuffer();

      buffer.append(getSource().getQualifiedName());
      buffer.append(".");
      buffer.append(getName());
      buffer.append(" : ");
      buffer.append(getTarget().getQualifiedName());
      return buffer.toString();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

   public List getQualifiers() {
      if ( qualifiers == null ) {
         qualifiers = new ArrayList(modelAssociation.getQualifiers().size());
         for ( Iterator iter = modelAssociation.getQualifiers().iterator(); iter.hasNext(); ) {
            ModelAttributeBase att = (ModelAttributeBase) iter.next();
            ModelAttribute newAtt = adaptedModel.getModelAttribute(att);
            qualifiers.add(newAtt);
         }
      }
      return qualifiers;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isOrdered()
    */
   public boolean isOrdered() {
      return modelAssociation.isOrdered();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isUnique()
    */
   public boolean isUnique() {
      return modelAssociation.isUnique();
   }

}
