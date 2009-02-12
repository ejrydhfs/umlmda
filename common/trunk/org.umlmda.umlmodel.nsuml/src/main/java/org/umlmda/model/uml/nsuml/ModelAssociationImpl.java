// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelAssociationImpl.java,v 1.10 2006/11/28 10:01:17 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelAssociationImpl.java,v $
// $Revision: 1.10 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/11/28 10:01:17 $
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

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.attributes.Multiplicity;

import ru.novosoft.uml.foundation.core.MAssociationEnd;
import ru.novosoft.uml.foundation.core.MAttribute;
import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MFeature;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.MNamespace;
import ru.novosoft.uml.foundation.core.MOperation;
import ru.novosoft.uml.foundation.data_types.MAggregationKind;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ModelAssociationImpl extends ModelStructuralFeatureImpl implements ModelAssociationBase {
   final private MAssociationEnd sourceEnd;

   final private MAssociationEnd targetEnd;

   private ModelClassBase target;

   private ModelClassBase source;

   private ModelAssociationBase reverseAssoc = null;

   private Properties taggedValues = null;

   private Multiplicity multiplicity = null;
   
   private List qualifiers = null;
   
   private Boolean ordered = null;
   
   private Boolean unique = null;
   
   private Boolean readOnly = null;
   
   private Set stereoTypes = null;
   
   /**
    * @param modelElement
    */
   ModelAssociationImpl(ModelImpl model, MAssociationEnd associationEnd) {
      super(model, associationEnd);
      this.sourceEnd = associationEnd;
      if (sourceEnd.getAssociation().getConnections().get(0) != sourceEnd) {
         targetEnd = (MAssociationEnd) sourceEnd.getAssociation().getConnections().get(0);
      }
      else {
         targetEnd = (MAssociationEnd) sourceEnd.getAssociation().getConnections().get(1);
      }

   }

   /**
    * @return
    */
   public ModelClassBase getTargetBase() {
      if (target == null) {
         target = model.findClass((MClass) targetEnd.getType());
      }
      return target;
   }

   /**
    * @return
    */
   public ModelClassBase getSourceBase() {
      if (source == null) {
         source = model.findClass((MClass) sourceEnd.getType());
      }
      return source;
   }

   public String toString() {
      StringBuffer buffer = new StringBuffer();

      buffer.append(getName());
      buffer.append("->");
      buffer.append(getTargetBase().getName());
      return buffer.toString();
   }

   public boolean isAggregation() {
      return sourceEnd.getAggregation() == MAggregationKind.AGGREGATE;
   }

   public boolean isComposition() {
      return sourceEnd.getAggregation() == MAggregationKind.COMPOSITE;
   }

   public boolean isMultiple() {
      return targetEnd.getMultiplicity().getUpper() != 1 || hasQualifier();
   }

   /**
    * @return
    * @@@TODO move to interface
    */
   private boolean hasQualifier() {
      return targetEnd.getQualifiers().size() > 0;
   }

   public boolean isOptional() {
      return targetEnd.getMultiplicity().getLower() == 0;
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

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getName()
    */
   public String getName() {
      if (StringUtils.isEmpty(targetEnd.getName())) {
         return Introspector.decapitalize(getTargetBase().getName());
      }
      else {
         return targetEnd.getName();
      }
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.nsuml.ModelElementImpl#getModelElement()
    */
   protected MModelElement getModelElement() {
      return sourceEnd.getAssociation();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotype()
    */
   public Collection getStereotypes() {
      if ( stereoTypes == null ) {
         stereoTypes = new HashSet();
         
         if (sourceEnd.getAssociation().getStereotype() != null) {
            stereoTypes.add(sourceEnd.getAssociation().getStereotype().getName());
         }
         if ( targetEnd.getStereotype() != null ) {
            stereoTypes.add(targetEnd.getStereotype().getName());
         }
      }
      return stereoTypes;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getTaggedValues()
    */
   public Properties getTaggedValues() {
      if (taggedValues == null) {
         taggedValues = new Properties();
         if (targetEnd != null) {
            for (Iterator itv = targetEnd.getTaggedValues().iterator(); itv.hasNext();) {
               addTaggedValue(itv);
            }
            for (Iterator itv = targetEnd.getAssociation().getTaggedValues().iterator(); itv.hasNext();) {
               addTaggedValue(itv);
            }
         }
      }
      return taggedValues;
   }

   private void addTaggedValue(Iterator itv) {
      MTaggedValue taggedValue = (MTaggedValue) itv.next();
      if (taggedValue.getTag().length() > 0 && taggedValue.getValue() != null)
         taggedValues.put(taggedValue.getTag(), taggedValue.getValue());
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#isDerived()
    */
   public boolean isDerived() {
      return Boolean.valueOf(targetEnd.getAssociation().getTaggedValue("derived", "false")).booleanValue();
   }

   public String getDocumentation() {
      String documentation = EMPTY;

      documentation = sourceEnd.getAssociation().getTaggedValue("documentation");
      return StringUtils.isEmpty(documentation) ? EMPTY : documentation;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelStructuralFeature#getOwningClass()
    */
   public ModelClassBase getOwningClassBase() {
      return getSourceBase();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAssociationBase#getReverse()
    */
   public ModelAssociationBase getReverseBase() {
      if (reverseAssoc == null) {
         ModelClassBase target = getTargetBase();
         for (Iterator iter = target.getAllAssociations().iterator(); iter.hasNext();) {
            ModelAssociationImpl otherAssoc = (ModelAssociationImpl) iter.next();
            if (sourceEnd != otherAssoc.sourceEnd
                  && sourceEnd.getAssociation() == otherAssoc.sourceEnd.getAssociation()) {
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
         multiplicity = new Multiplicity(
               targetEnd.getMultiplicity().getLower(),
               targetEnd.getMultiplicity().getUpper());
      }
      return multiplicity;
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getQualifiers()
    */
   public List getQualifiers() {
      qualifiers = new ArrayList();
      for (Iterator ia = targetEnd.getQualifiers().iterator(); ia.hasNext();) {
         MFeature feature = (MFeature) ia.next();

         if (feature instanceof MAttribute) {
            MAttribute attribute = (MAttribute) feature;

            qualifiers.add(new ModelAttributeImpl(model, (MAttribute) feature));
         }
      }
      return qualifiers;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getConstraints()
    */
   public String getConstraints() {
      return getConstraints(targetEnd);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#isOrdered()
    */
   public boolean isOrdered() {
      if ( ordered == null ) {
         ordered = hasConstraint("ordered");
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
      
      for (Iterator ic = targetEnd.getConstraints().iterator(); ic.hasNext();) {
         MConstraint constraint = (MConstraint) ic.next();
         
         if ( constraint.getBody().getBody().indexOf(constraintName) != -1 ) {
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
      return ((ModelImpl)model).findClassifier(sourceEnd.getType());
   }
   
}
