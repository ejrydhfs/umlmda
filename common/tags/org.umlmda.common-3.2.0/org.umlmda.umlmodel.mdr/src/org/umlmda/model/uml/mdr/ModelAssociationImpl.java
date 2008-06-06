// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelMDR/src/org/umlmda/model/uml/mdr/ModelAssociationImpl.java,v 1.7 2006/11/23 13:39:19 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelMDR/src/org/umlmda/model/uml/mdr/ModelAssociationImpl.java,v $
// $Revision: 1.7 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/11/23 13:39:19 $
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
package org.umlmda.model.uml.mdr;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.omg.uml.foundation.core.AssociationEnd;
import org.omg.uml.foundation.core.Attribute;
import org.omg.uml.foundation.core.Constraint;
import org.omg.uml.foundation.core.Feature;
import org.omg.uml.foundation.core.ModelElement;
import org.omg.uml.foundation.core.Stereotype;
import org.omg.uml.foundation.core.TaggedValue;
import org.omg.uml.foundation.core.UmlClass;
import org.omg.uml.foundation.datatypes.AggregationKindEnum;
import org.omg.uml.foundation.datatypes.MultiplicityRange;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.attributes.Multiplicity;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ModelAssociationImpl extends ModelStructuralFeatureImpl implements ModelAssociationBase {
   final private AssociationEnd sourceEnd;
   final private AssociationEnd targetEnd;
   private ModelClassBase target;
   private ModelClassBase source;
   private ModelAssociationBase reverseAssoc;
   private Multiplicity multiplicity = null;
   private List qualifiers = null;
   private Boolean ordered = null;
   private Boolean unique = null;
   private Boolean readOnly = null;
   private Set stereoTypes = null;
   
   /**
    * @param modelElement
    */
   ModelAssociationImpl(ModelImpl model, AssociationEnd associationEnd) {
      super(model, associationEnd);
      this.sourceEnd = associationEnd;
      if ( sourceEnd.getAssociation().getConnection().get(0) != sourceEnd ) {
         targetEnd = (AssociationEnd)sourceEnd.getAssociation().getConnection().get(0);
      }
      else {             
         targetEnd = (AssociationEnd)sourceEnd.getAssociation().getConnection().get(1);
      }
         
   }

   /**
    * @return
    */
   public ModelClassBase getSourceBase() {
      if ( source == null ) {
         source = model.findClass((UmlClass)sourceEnd.getParticipant());
      }
      return source;
   }
   
   
   /**
    * @return
    */
   public ModelClassBase getTargetBase() {
      if ( target == null ) {
         target = model.findClass((UmlClass)targetEnd.getParticipant());
      }
      return target;
   }

   public String toString() {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append("->");
      buffer.append(getTargetBase().getName());
      buffer.append(" : ");
      buffer.append(getName());
      return buffer.toString();
   }
   
   public boolean isAggregation() {
      return sourceEnd.getAggregation() == AggregationKindEnum.AK_AGGREGATE;
   }
   
   public boolean isComposition() {
      return sourceEnd.getAggregation() == AggregationKindEnum.AK_COMPOSITE;
   }
   
   public boolean isMultiple() {
      return ((MultiplicityRange)targetEnd.getMultiplicity().getRange().iterator().next()).getUpper() != 1;      
   }

   public boolean isOptional() {
      return ((MultiplicityRange)targetEnd.getMultiplicity().getRange().iterator().next()).getLower() == 0;      
   }

   
	/**
	 * checks whether the target could be navigated through this association
	 * @return
	 */
	public boolean isNavigatableToTarget() {
		return targetEnd.isNavigable();
	}

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociation#isNavigatableToSource()
    */
   public boolean isNavigatableToSource() {
      return sourceEnd.isNavigable();
   }
   
   /**
    * @return
    */
   public boolean isUnspecified() {
      return (isAggregation() || isComposition()) == false;
   }
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getName()
    */
   public String getName() {
      if ( StringUtils.isEmpty(targetEnd.getName())) {
         return Introspector.decapitalize(getTargetBase().getName());
      }
      else {
         return targetEnd.getName();
      }
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotype()
    */
   public String getStereotype() {
      if ( sourceEnd.getAssociation().getStereotype().size() > 0 ) {
         Stereotype stereotype = (Stereotype) sourceEnd.getAssociation().getStereotype().iterator().next();
           
         return stereotype.getName();
      }
      else
         return EMPTY;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotype()
    */
   public Collection getStereotypes() {
      if ( stereoTypes == null ) {
         stereoTypes = new HashSet();
         
         for (Iterator is = sourceEnd.getAssociation().getStereotype().iterator(); is.hasNext();) {
            Stereotype stereotype = (Stereotype) is.next();
            
            stereoTypes.add(stereotype.getName());
         }
         
         for (Iterator is = targetEnd.getStereotype().iterator(); is.hasNext();) {
            Stereotype stereotype = (Stereotype) is.next();
            
            stereoTypes.add(stereotype.getName());
         }
      }
      return stereoTypes;
   }
   
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getTaggedValues()
    */
   public Properties getTaggedValues() {
      if ( taggedValues == null ) {
         taggedValues = new Properties();
         if ( targetEnd != null ) {
            for (Iterator itv = targetEnd.getTaggedValue().iterator(); itv.hasNext();) {
               addTaggedValue(itv);
            }
            for (Iterator itv = targetEnd.getAssociation().getTaggedValue().iterator(); itv.hasNext();) {
               addTaggedValue(itv);
            }
         }
      }
      return taggedValues;
   }

   private void addTaggedValue(Iterator itv) {
      TaggedValue taggedValue = (TaggedValue) itv.next();
      if ( taggedValue.getName().length() > 0 && taggedValue.getDataValue().size() > 0 ) 
        taggedValues.put(taggedValue.getName(), taggedValue.getDataValue().iterator().next());
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociationBase#getReverseBase()
    */
   public ModelAssociationBase getReverseBase() {
		if (reverseAssoc == null) {
			ModelClassBase target = getTargetBase();
			for (Iterator iter = target.getAllAssociations().iterator(); iter.hasNext();) {
				ModelAssociationImpl otherAssoc = (ModelAssociationImpl) iter.next();
				if (sourceEnd != otherAssoc.sourceEnd && sourceEnd.getAssociation() == otherAssoc.sourceEnd.getAssociation()) {
					reverseAssoc = otherAssoc;
				}
			}
		}
		return reverseAssoc;
    }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#getMultiplicity()
    */
   public Multiplicity getMultiplicity() {
      if (multiplicity == null) {
         Collection range = targetEnd.getMultiplicity().getRange();
         Iterator ir = range.iterator();
         int lower = ((Integer)ir.next()).intValue();
         int upper = ((Integer)ir.next()).intValue();
         multiplicity = new Multiplicity(lower, upper);
      }
      return multiplicity;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getQualifiers()
    */
   public List getQualifiers() {
      qualifiers = new ArrayList();
      for (Iterator ia = targetEnd.getQualifier().iterator(); ia.hasNext();) {
         Feature feature = (Feature) ia.next();

         if (feature instanceof Attribute) {
            Attribute attribute = (Attribute) feature;

            qualifiers.add(new ModelAttributeImpl(model, (Attribute) feature));
         }
      }
      return qualifiers;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getConstraints()
    */
   public String getConstraints() {
      ModelElement constraintsHolder = targetEnd;
      return getConstraints(constraintsHolder);
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isOrdered()
    */
   public boolean isOrdered() {
      if ( ordered == null ) {
         unique = hasConstraint("ordered");
      }
      return ordered.booleanValue();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isUnique()
    */
   public boolean isUnique() {
      if ( unique == null ) {
         unique = hasConstraint("unique");
      }
      return unique.booleanValue();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelStructuralFeatureBase#isReadOnly()
    */
   public boolean isReadOnly() {
      if ( readOnly == null ) {
         readOnly = hasConstraint("frozen");
      }
      return readOnly.booleanValue();
   }
   
   private Boolean hasConstraint(String constraintName) {
      Boolean hasConstraint = null;
      
      for (Iterator ic = targetEnd.getConstraint().iterator(); ic.hasNext();) {
         Constraint constraint = (Constraint) ic.next();
         
         if ( constraint.getBody().getBody().equals(constraintName)) {
            hasConstraint = Boolean.TRUE;
         }
      }
      
      if ( hasConstraint == null ) {
         hasConstraint = Boolean.FALSE;
      }
      
      return hasConstraint;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getOwnerBase()
    */
   public ModelElementBase getOwnerBase() {
      return ((ModelImpl)model).findClassifier(sourceEnd.getParticipant());
   }
   
}
