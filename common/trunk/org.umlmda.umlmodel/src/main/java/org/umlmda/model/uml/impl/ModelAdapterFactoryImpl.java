// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAdapterFactoryImpl.java,v 1.5 2006/08/09 10:40:24 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAdapterFactoryImpl.java,v $
// $Revision: 1.5 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/08/09 10:40:24 $
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
// Created on Jun 7, 2005
package org.umlmda.model.uml.impl;

import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelDependencyBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelGeneralizationBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.model.uml.pattern.ModelPatternFactory;
import org.umlmda.model.uml.pattern.ModelPatternIterator;
import org.umlmda.model.uml.validate.ModelValidationException;
import org.umlmda.model.uml.validate.ModelValidator;
import org.umlmda.model.uml.validate.ModelValidatorFactory;
import org.umlmda.model.uml.validate.ValidationResult;

/**
 * implementation of ModelAdapterFactory
 * 
 * @see ModelAdapterFactory
 * @author vpussel
 *  
 */
public class ModelAdapterFactoryImpl implements ModelAdapterFactory {

   /**
    * create a model adapter from the original model, applies the
    * pattern and checks standard validations if defined. Init
    * is not executed on the model because profile and generation
    * set is not yet assigned.
    */
   public final Model createModel(ModelBase model)  throws ModelValidationException {
      Model pimModel;
      
      if ((model instanceof Model) == false) {
         pimModel = new ModelAdapter(new ModelAdapterFactoryImpl(), model);
         pimModel.init();
      }
      else {
         pimModel = (Model) model; 
      }
      
      // Validate the pim model
      if ( getValidatorFactory() != null ) {
         ModelValidator validator = new ModelValidator();
         List results;
         boolean hasErrors = false;
         
         getValidatorFactory().registerValidators(validator);
         results = validator.validate(pimModel);
         for (Iterator ir = results.iterator(); ir.hasNext();) {
            ValidationResult result = (ValidationResult) ir.next();
            
            if ( result.getSeverity() == ValidationResult.ERROR ) {
               hasErrors = true;
            }
         }
         if ( hasErrors ) {
            throw new ModelValidationException(results);
         }
      }
      
      // Apply the patterns on the pim modell
      if ( getPatternFactory() != null ) {
         new ModelPatternIterator(getPatternFactory()).apply(pimModel);
      }
      
      Model psmModel = createPsmModel(pimModel);
      
      if ( psmModel != null ) {
         return psmModel;
      }
      else {
         return pimModel;
      }
   }

   /**
    * create a psm model adapter from the original model
    */
   protected Model createPsmModel(Model model) {
      return null;
   }

   /**
    * No defaultfacory used.
    * 
    * @see org.umlmda.model.uml.ModelAdapterFactory#getPatternFactory()
    */
   public ModelPatternFactory getPatternFactory() {
      return null;
   }

   /**
    * No defaultfacory used.
    * 
    * @see ModelAdapterFactory#getValidatorFactory()
    */
   public ModelValidatorFactory getValidatorFactory() {
      return null;
   }

   /**
    * create a model association adapter from the original model association
    */
   public ModelAssociation createModelAssociation(ModelAssociationBase modelAssociation, Model destModel) {
      return new ModelAssociationAdapter(modelAssociation, destModel);
   }

   /**
    * create a model attribute adapter from the original model attribute
    */
   public ModelAttribute createModelAttribute(ModelAttributeBase modelAttribute, Model destModel) {
      return new ModelAttributeAdapter(modelAttribute, destModel);
   }

   /**
    * create a model class adapter from the original model class
    */
   public ModelClass createModelClass(ModelClassBase modelClass, Model destModel) {
      return new ModelClassAdapter(modelClass, destModel);
   }

   /**
    * create a model data type adapter from the original model data type
    */
   public ModelDataType createModelDataType(ModelDataTypeBase modelDataType, Model destModel) {
      return new ModelDataTypeAdapter(modelDataType, destModel);
   }

   /**
    * create a model method adapter from the original model method
    */
   public ModelMethod createModelMethod(ModelMethodBase modelMethod, Model destModel) {
      return new ModelMethodAdapter(modelMethod, destModel);
   }

   /**
    * create a model package adapter from the original model package
    */
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model destModel) {
      return new ModelPackageAdapter(modelPackage, destModel);
   }

   /**
    * create a model parameter adapter from the original model parameter
    */
   public ModelParameter createModelParameter(ModelParameterBase modelParameter, Model destModel) {
      return new ModelParameterAdapter(modelParameter, destModel);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelDependency(org.umlmda.model.uml.ModelDependencyBase,
    *      org.umlmda.model.uml.Model)
    */
   public ModelDependency createModelDependency(ModelDependencyBase modelDependency, Model destModel) {
      return new ModelDependencyAdapter(modelDependency, destModel);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelGeneralization(org.umlmda.model.uml.ModelGeneralizationBase, org.umlmda.model.uml.Model)
    */
   public ModelGeneralization createModelGeneralization(ModelGeneralizationBase modelGeneralization, Model destModel) {
      return new ModelGeneralizationAdapter(modelGeneralization, destModel);
   }
   
   /*
    * (non-Javadoc)
    * 
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelElement(org.umlmda.model.uml.ModelElementBase,
    *      org.umlmda.model.uml.Model)
    */
   public ModelElement createModelElement(ModelElementBase elementBase, Model model) {
      if (elementBase instanceof ModelBase) {
         try {
            return createModel((ModelBase) elementBase);
         } catch (ModelValidationException e) {
            throw new RuntimeException(e);
         }
      }
      else if (elementBase instanceof ModelPackageBase) {
         return createModelPackage((ModelPackageBase) elementBase, model);
      }
      else if (elementBase instanceof ModelClassBase) {
         return createModelClass((ModelClassBase) elementBase, model);
      }
      else if (elementBase instanceof ModelAssociationBase) {
         return createModelAssociation((ModelAssociationBase) elementBase, model);
      }
      else if (elementBase instanceof ModelAttributeBase) {
         return createModelAttribute((ModelAttributeBase) elementBase, model);
      }
      else if (elementBase instanceof ModelDataTypeBase) {
         return createModelDataType((ModelDataTypeBase) elementBase, model);
      }
      else if (elementBase instanceof ModelDependencyBase) {
         return createModelDependency((ModelDependencyBase) elementBase, model);
      }
      else if (elementBase instanceof ModelMethodBase) {
         return createModelMethod((ModelMethodBase) elementBase, model);
      }
      else if (elementBase instanceof ModelParameterBase) {
         return createModelParameter((ModelParameterBase) elementBase, model);
      }
      else {
         throw new IllegalArgumentException(elementBase.getClass().getName());
      }
   }

}
