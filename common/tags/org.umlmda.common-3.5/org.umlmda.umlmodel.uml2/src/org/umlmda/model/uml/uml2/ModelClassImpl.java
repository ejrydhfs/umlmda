// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelClassImpl.java,v 1.2.2.1.2.1 2008/02/25 14:51:10 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelClassImpl.java,v $
// $Revision: 1.2.2.1.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/02/25 14:51:10 $
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
package org.umlmda.model.uml.uml2;

import java.util.ArrayList;
import java.util.Iterator;
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
 * ModelClass of a UML model. This class wraps
 * ru.novosoft.uml.foundation.core.MClass to make a more easy access to the
 * class members and relations.
 * 
 * @author Dieter Moroff
 */
public class ModelClassImpl extends ModelClassifierImpl implements ModelClassBase {
   private final Class modelClass;

   private ModelPackageBase modelPackage = null;

   private List attributes = null;

   private List constants = null;

   private List methods = null;

   private List associations = null;

   private List allAssociations = new ArrayList();

   private List referencedTypes = null;

   private List generalizations = null;
   
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
      if (modelPackage == null)
         modelPackage = model.findPackage(modelClass.getNamespace());
      return modelPackage;
   }

   /**
    * @return
    */
   public List getAttributes() {
      if (attributes == null) {
         attributes = getAttributeList(false);
      }
      return attributes;
   }

   /**
    * Returns a collection containing all constant attributes (a constant must
    * be mark frozen, scope classifier and have an initial value).
    */
   public List getConstants() {
      if (constants == null) {
         constants = getAttributeList(true);
      }
      return constants;
   }

   private List getAttributeList(boolean constants) {
      List attributes = new ArrayList();
      for (Iterator ia = modelClass.getAttributes().iterator(); ia.hasNext();) {
         Property feature = (Property) ia.next();

         if (feature.getAssociation() == null) {
            Property attribute = (Property) feature;

            if ((constants == true && ModelAttributeImpl.isConstant(attribute))
                  || (constants == false && !ModelAttributeImpl.isConstant(attribute)))
               attributes.add(new ModelAttributeImpl(model, (Property) feature));
         }
      }
      return attributes;
   }

   /**
    * @return
    */
   public List getMethods() {
      if (methods == null) {
         methods = new ArrayList();

         for (Iterator iter = modelClass.getFeatures().iterator(); iter.hasNext();) {
            Feature feature = (Feature) iter.next();

            if (feature instanceof Operation)
               methods.add(new ModelMethodImpl(model, (Operation) feature));
         }
      }
      return methods;
   }

   
   public List getGeneralizations() {
      if ( generalizations == null ) {
         generalizations = new ArrayList();

         for (Iterator iter = modelClass.getGeneralizations().iterator(); iter.hasNext();) {
            Generalization generalization = (Generalization) iter.next();

            if (generalization.getSpecific() == modelClass)
               generalizations.add(new ModelGeneralizationImpl((ModelImpl)getModelBase(), generalization));
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
   public List getAssociations() {
      if (associations == null) {
         associations = new ArrayList();

         for (Iterator iter = modelClass.getFeatures().iterator(); iter.hasNext();) {
            Feature feature = (Feature) iter.next();

            if (feature instanceof Property) {
               Property property = (Property) feature;

               if (property.getAssociation() != null) {
                  ModelAssociationBase association = new ModelAssociationImpl(model, this, property);

                  allAssociations.add(association);
                  if (association.isNavigatableToTarget())
                     associations.add(association);
                  if (association.getTargetBase() != null && association.isNavigatableToSource() == false)
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
    * 
    * @see org.umlmda.model.uml.ModelClass#getAllAssociations()
    */
   public List getAllAssociations() {
      if (allAssociations == null)
         getAssociations();
      return allAssociations;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelClass#isAbstract()
    */
   public boolean isAbstract() {
      return modelClass.isAbstract();
   }

}
