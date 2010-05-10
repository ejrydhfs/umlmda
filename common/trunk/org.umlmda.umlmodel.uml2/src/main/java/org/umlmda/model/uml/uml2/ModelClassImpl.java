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
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackageBase;

/**
 * ModelClass of a UML model. This class wraps ru.novosoft.uml.foundation.core.MClass to make a more easy access to the class
 * members and relations.
 * 
 * @author Dieter Moroff
 */
public class ModelClassImpl extends ModelClassifierImpl implements ModelClassBase
{
   private final Class                   modelClass;

   private ModelPackageBase              modelPackage    = null;

   private List<ModelAttributeImpl>      attributes      = null;

   private List<ModelAttributeImpl>      constants       = null;

   private List<ModelMethodImpl>         methods         = null;

   private List<ModelAssociationBase>    associations    = null;

   private List<ModelAssociationBase>    allAssociations = new ArrayList<ModelAssociationBase>();

   @SuppressWarnings( { "unchecked", "unused" })
   private List                          referencedTypes = null;

   private List<ModelGeneralizationImpl> generalizations = null;

   ModelClassImpl() {
      super();
      this.modelClass = null;
      this.modelPackage = new ModelPackageImpl();
   }

   public ModelClassImpl(ModelImpl model, Class modelClass) {
      super(model, modelClass);
      this.modelClass = modelClass;
   }

   public ModelPackageBase getPackageBase() {
      if ( modelPackage == null )
         modelPackage = model.findPackage(modelClass.getNamespace());
      return modelPackage;
   }

   /**
    * @return
    */
   public List<ModelAttributeImpl> getAttributes() {
      if ( attributes == null ) {
         attributes = getAttributeList(false);
      }
      return attributes;
   }

   /**
    * Returns a collection containing all constant attributes (a constant must be mark frozen, scope classifier and have an
    * initial value).
    */
   public List<ModelAttributeImpl> getConstants() {
      if ( constants == null ) {
         constants = getAttributeList(true);
      }
      return constants;
   }

   private List<ModelAttributeImpl> getAttributeList(boolean constants) {
      List<ModelAttributeImpl> attributes = new ArrayList<ModelAttributeImpl>();
      for ( Property feature : modelClass.getAttributes() ) {
         if ( feature.getAssociation() == null ) {
            Property attribute = (Property) feature;

            if ( (constants == true && ModelAttributeImpl.isConstant(attribute))
                  || (constants == false && !ModelAttributeImpl.isConstant(attribute)) )
               attributes.add(new ModelAttributeImpl(model, (Property) feature));
         }
      }
      return attributes;
   }

   /**
    * @return
    */
   public List<ModelMethodImpl> getMethods() {
      if ( methods == null ) {
         methods = new ArrayList<ModelMethodImpl>();

         for ( Feature feature : modelClass.getFeatures() ) {
            if ( feature instanceof Operation )
               methods.add(new ModelMethodImpl(model, (Operation) feature));
         }
      }
      return methods;
   }

   public List<ModelGeneralizationImpl> getGeneralizations() {
      if ( generalizations == null ) {
         generalizations = new ArrayList<ModelGeneralizationImpl>();

         for ( Generalization generalization : modelClass.getGeneralizations() ) {
            if ( generalization.getSpecific() == modelClass )
               generalizations.add(new ModelGeneralizationImpl((ModelImpl) getModelBase(), generalization));
         }
      }
      return generalizations;
   }

   /**
    * @return
    */
   public String getName() {
      return modelClass.getName();
   }

   /**
    * @return
    */
   public List<ModelAssociationBase> getAssociations() {
      if ( associations == null ) {
         associations = new ArrayList<ModelAssociationBase>();

         for ( Feature feature : modelClass.getFeatures() ) {
            if ( feature instanceof Property ) {
               Property property = (Property) feature;

               if ( property.getAssociation() != null ) {
                  ModelAssociationBase association = new ModelAssociationImpl(model, this, property);

                  allAssociations.add(association);
                  if ( association.isNavigatableToTarget() )
                     associations.add(association);
                  if ( association.getTargetBase() != null && association.isNavigatableToSource() == false )
                     ((ModelClassImpl) (association.getTargetBase())).addReverse(association);
               }
            }
         }
      }
      return associations;
   }

   /**
    * @param association
    */
   private void addReverse(ModelAssociationBase association) {
      allAssociations.add(((ModelAssociationImpl) association).createReverse());
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#getAllAssociations()
    */
   public List<ModelAssociationBase> getAllAssociations() {
      if ( allAssociations == null )
         getAssociations();
      return allAssociations;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#isAbstract()
    */
   public boolean isAbstract() {
      return modelClass.isAbstract();
   }

}
