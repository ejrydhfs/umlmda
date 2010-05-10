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
package org.umlmda.model.uml.nsuml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.impl.ModelAssociationAdapter;

import ru.novosoft.uml.foundation.core.MAssociationEnd;
import ru.novosoft.uml.foundation.core.MAttribute;
import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MFeature;
import ru.novosoft.uml.foundation.core.MGeneralization;
import ru.novosoft.uml.foundation.core.MOperation;

/**
 * ModelClass of a UML model. This class wraps ru.novosoft.uml.foundation.core.MClass to make a more easy access to the class
 * members and relations.
 * 
 * @author Dieter Moroff
 */
public class ModelClassImpl extends ModelClassifierImpl implements ModelClassBase
{
   private final MClassifier modelClass;
   private ModelClassBase    superClass      = null;
   private ModelPackageBase  modelPackage    = null;
   private List              attributes      = null;
   private List              constants       = null;
   private List              methods         = null;
   private List              associations    = null;
   private List              allAssociations = null;
   private List              generalizations = null;

   public ModelClassImpl(ModelImpl model, MClassifier modelClass) {
      super(model, modelClass);
      this.modelClass = modelClass;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getAllAssociations()
    */
   public List getAllAssociations() {
      if ( allAssociations == null )
         getAssociations();
      return allAssociations;
   }

   /**
    * @return
    */
   public List getAssociations() {
      if ( associations == null ) {
         associations = new ArrayList();
         allAssociations = new ArrayList();

         for ( Iterator iter = modelClass.getAssociationEnds().iterator(); iter.hasNext(); ) {
            MAssociationEnd associationEnd = (MAssociationEnd) iter.next();
            ModelAssociationBase association = new ModelAssociationImpl(model, associationEnd);

            allAssociations.add(association);
            if ( association.isNavigatableToTarget() )
               associations.add(association);
         }
         // sort associations alphabetically by name
         Collections.sort(associations, new ModelAssociationAdapter.Comparator());
         Collections.sort(allAssociations, new ModelAssociationAdapter.Comparator());
      }
      return associations;
   }

   private List getAttributeList(boolean constants) {
      List attributes = new ArrayList();
      for ( Iterator ia = modelClass.getFeatures().iterator(); ia.hasNext(); ) {
         MFeature feature = (MFeature) ia.next();

         if ( feature instanceof MAttribute ) {
            MAttribute attribute = (MAttribute) feature;

            if ( (constants == true && ModelAttributeImpl.isConstant(attribute))
                  || (constants == false && !ModelAttributeImpl.isConstant(attribute)) )
               attributes.add(new ModelAttributeImpl(model, (MAttribute) feature));
         }
      }
      return attributes;
   }

   /**
    * @return
    */
   public List getAttributes() {
      if ( attributes == null ) {
         attributes = getAttributeList(false);
      }
      return attributes;
   }

   /**
    * Returns a collection containing all constant attributes (a constant must be mark frozen, scope classifier and have an
    * initial value).
    */
   public List getConstants() {
      if ( constants == null ) {
         constants = getAttributeList(true);
      }
      return constants;
   }

   /**
    * @return
    */
   public List getMethods() {
      if ( methods == null ) {
         methods = new ArrayList();

         for ( Iterator iter = modelClass.getFeatures().iterator(); iter.hasNext(); ) {
            MFeature feature = (MFeature) iter.next();

            if ( feature instanceof MOperation )
               methods.add(new ModelMethodImpl(model, (MOperation) feature));
         }
      }
      return methods;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getName()
    */
   public String getName() {
      return modelClass.getName();
   }

   public ModelPackageBase getPackageBase() {
      if ( modelPackage == null )
         modelPackage = model.findPackage(modelClass.getNamespace());
      return modelPackage;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClass#isAbstract()
    */
   public boolean isAbstract() {
      return modelClass.isAbstract();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClassBase#getGeneralizations()
    */
   public List getGeneralizations() {
      if ( generalizations == null ) {
         generalizations = new ArrayList(modelClass.getGeneralizations().size());

         for ( Iterator ig = modelClass.getGeneralizations().iterator(); ig.hasNext(); ) {
            MGeneralization generalization = (MGeneralization) ig.next();

            generalizations.add(new ModelGeneralizationImpl((ModelImpl) getModelBase(), generalization));
         }
      }
      return generalizations;
   }
}
