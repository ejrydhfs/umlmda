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

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.attributes.Multiplicity;

/**
 * Implementation of a association from a owning class to a target class for UML2.
 * 
 * @author moroff
 */
public class ModelAssociationImpl extends ModelStructuralFeatureImpl implements ModelAssociationBase
{
   /**
    * Model class to which the association points
    */
   final private ModelClassBase     target;
   /**
    * Property in the owner containing the endpoint of the assocations
    */
   final private Property           targetEnd;
   /**
    * Model class which owns this assocations
    */
   final private ModelClassBase     owner;
   /**
    * association which connects source and target in opposite direction
    */
   private ModelAssociationBase     reverseAssoc = null;
   /**
    * Property in the target containing the other endpoint of the assocations
    */
   final private Property           ownerEnd;
   /**
    * Tagged values of the assocation
    */
   private Properties               taggedValues = null;
   private Multiplicity             multiplicity = null;
   private List<ModelAttributeImpl> qualifiers   = null;
   private Set<String>              stereoTypes  = null;

   /**
    * @param modelElement
    */
   ModelAssociationImpl(ModelImpl model, ModelClassBase owner, Property targetEnd) {
      super(model, targetEnd);
      this.owner = owner;
      if ( targetEnd.getType() == null ) {
         logger.error(targetEnd.getName() + " has no type specified");
         this.target = null;
      }
      else {
         this.target = model.findClass((Class) targetEnd.getType());
      }
      this.targetEnd = targetEnd;
      if ( targetEnd.getAssociation().getMemberEnds().get(0) != targetEnd ) {
         ownerEnd = (Property) targetEnd.getAssociation().getMemberEnds().get(0);
      }
      else {
         ownerEnd = (Property) targetEnd.getAssociation().getMemberEnds().get(1);
      }
   }

   ModelAssociationBase createReverse() {
      ModelAssociationBase reverse = new ModelAssociationImpl((ModelImpl) getModelBase(), getTargetBase(), getOwnerEnd());

      return reverse;
   }

   /**
    * @return
    */
   public ModelClassBase getTargetBase() {
      return target;
   }

   /**
    * @return
    */
   public ModelClassBase getSourceBase() {
      return owner;
   }

   public boolean isAggregation() {
      return targetEnd.getAggregation().getValue() == AggregationKind.SHARED;
   }

   public boolean isComposition() {
      return targetEnd.getAggregation().getValue() == AggregationKind.COMPOSITE;
   }

   public boolean isMultiple() {
      return targetEnd.isMultivalued();
   }

   public boolean isOptional() {
      return targetEnd.lowerBound() == 0;
   }

   /**
    * checks whether the target could be navigated through this association
    * 
    * @return
    */
   public boolean isNavigatableToTarget() {
      return targetEnd.isNavigable();
   }

   public boolean isNavigatableToSource() {
      return ownerEnd.isNavigable();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getName()
    */
   public String getName() {
      if ( StringUtils.isEmpty(targetEnd.getName()) ) {
         return Introspector.decapitalize(getTargetBase().getName());
      }
      else {
         return targetEnd.getName();
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.nsuml.ModelElementImpl#getModelElement()
    */
   protected Element getModelElement() {
      return ownerEnd.getAssociation();
   }

   public String getDocumentation() {
      List<Comment> comments = ownerEnd.getAssociation().getOwnedComments();
      if ( comments.size() > 0 ) {
         Comment comment = (Comment) comments.get(0);

         return comment.getBody();
      }
      else
         return StringUtils.EMPTY;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotype()
    */
   public Collection<String> getStereotypes() {
      if ( stereoTypes == null ) {
         stereoTypes = new HashSet<String>();

         for ( Stereotype stereotype : ownerEnd.getAssociation().getAppliedStereotypes() ) {
            stereoTypes.add(stereotype.getName());
         }

         for ( Stereotype stereotype : targetEnd.getAppliedStereotypes() ) {
            stereoTypes.add(stereotype.getName());
         }
      }
      return stereoTypes;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getTaggedValues()
    */
   public Properties getTaggedValues() {
      if ( taggedValues == null ) {
         taggedValues = new Properties();

         getTaggedValues(targetEnd.getAssociation(), taggedValues);
      }
      return taggedValues;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeature#getOwningClass()
    */
   public ModelClassBase getOwningClassBase() {
      return getSourceBase();
   }

   Property getOwnerEnd() {
      return ownerEnd;
   }

   Property getTargetEnd() {
      return targetEnd;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getReverseBase()
    */
   public ModelAssociationBase getReverseBase() {
      if ( reverseAssoc == null ) {
         ModelClassBase target = getTargetBase();
         for ( Iterator iter = target.getAllAssociations().iterator(); iter.hasNext(); ) {
            ModelAssociationImpl otherAssoc = (ModelAssociationImpl) iter.next();
            if ( ownerEnd != otherAssoc.ownerEnd && ownerEnd.getAssociation() == otherAssoc.ownerEnd.getAssociation() ) {
               reverseAssoc = otherAssoc;
            }
         }
      }
      return reverseAssoc;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getOwner()
    */
   public ModelElementBase getOwnerBase() {

      // getOwner() returns the containing package
      // we need the class from which the association comes from
      Element container = ((Property) modelElement).getOwner();

      if ( container instanceof Classifier )
         return model.findClassifier((Classifier) container);
      else if ( container instanceof Package )
         return model.findPackage((Package) container);
      else
         return null;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getMultiplicity()
    */
   public Multiplicity getMultiplicity() {
      if ( multiplicity == null ) {
         multiplicity = new Multiplicity(targetEnd.lowerBound(), targetEnd.upperBound());
      }
      return multiplicity;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getQualifiers()
    */
   public List<ModelAttributeImpl> getQualifiers() {
      qualifiers = new ArrayList<ModelAttributeImpl>();
      for ( Property feature : targetEnd.getQualifiers() ) {
         if ( feature.getAssociation() == null ) {
            Property attribute = (Property) feature;
            qualifiers.add(new ModelAttributeImpl(model, attribute));
         }
      }
      return qualifiers;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getConstraints()
    */
   public String getConstraints() {
      return getConstraints(targetEnd);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isOrdered()
    */
   public boolean isOrdered() {
      return targetEnd.isOrdered();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isUnique()
    */
   public boolean isUnique() {
      return targetEnd.isUnique();
   }

   /**
    * Derived can be set on association and association end.
    */
   public boolean isDerived() {
      return super.isDerived() || targetEnd.isDerived();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#isReadOnly()
    */
   public boolean isReadOnly() {
      return targetEnd.isReadOnly();
   }
}
