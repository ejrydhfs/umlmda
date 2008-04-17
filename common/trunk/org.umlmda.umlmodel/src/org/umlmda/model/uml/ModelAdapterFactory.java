// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelAdapterFactory.java,v 1.5 2006/08/09 10:40:27 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelAdapterFactory.java,v $
// $Revision: 1.5 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/08/09 10:40:27 $
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
package org.umlmda.model.uml;

import org.umlmda.model.uml.pattern.ModelPatternFactory;
import org.umlmda.model.uml.validate.ModelValidationException;
import org.umlmda.model.uml.validate.ModelValidatorFactory;

/**
 * Interface for platform specific model factories.
 *
 * Implementors must overload the create methods or delegate to ModelAdapterFactoryImpl
 * Overloaded create methods must create Adapters derived from appropriate
 * Adapter classes. Derivations of Adapter classes must call the base class ctor.
 * 
 * instances of ModelElement, ModelClassifier or ModelStructuralFeature must not be 
 * created since they are base classes.
 *
 * @see ModelAdapterFactoryImpl
 * @author vpussel
 *
 */
public interface ModelAdapterFactory {

   /**
    * Returns the pattern factory to apply on the pim model before 
    * creating the model adapter 
    * @return
    */
   public ModelPatternFactory getPatternFactory();
   
   /**
    * Returns the validation factory to ensure the model is appropriate 
    * for the adapter. 
    * @param model
    * @return
    */
   public ModelValidatorFactory getValidatorFactory();
   
	/**
	 * create and initialize an adapter for a model
	 */
	public abstract Model createModel(ModelBase model) throws ModelValidationException;

	/**
	 * create an adapter for a model assocication
	 */
	public abstract ModelAssociation createModelAssociation(
			ModelAssociationBase modelAssociation, Model destModel);

	/**
	 * create an adapter for a model generalization
	 */
	public abstract ModelGeneralization createModelGeneralization(
			ModelGeneralizationBase modelGeneralization, Model destModel);

	/**
	 * create an adapter for a model attribute
	 */
	public abstract ModelAttribute createModelAttribute(
			ModelAttributeBase modelAttribute, Model destModel);

	/**
	 * create an adapter for a model class
	 */
	public abstract ModelClass createModelClass(
			ModelClassBase modelClass, Model destModel);
			
	/**
	 * create an adapter for a model data type
	 */
	public abstract ModelDataType createModelDataType(
			ModelDataTypeBase modelDataType, Model destModel);

	/**
	 * create an adapter for a model method
	 */
	public abstract ModelMethod createModelMethod(
			ModelMethodBase modelMethod, Model destModel);

	/**
	 * create an adapter for a model package
	 */
	public abstract ModelPackage createModelPackage(
			ModelPackageBase modelPackage, Model destModel);

	/**
	 * create an adapter for a model parameter
	 */
	public abstract ModelParameter createModelParameter(
			ModelParameterBase modelParameter, Model destModel);

   public abstract ModelDependency createModelDependency(
         ModelDependencyBase modelDependency, Model destModel);

   /**
    * Creates an adapter for any model element type
    * @param elementBase
    * @param model
    * @return
    */
   public abstract ModelElement createModelElement(
         ModelElementBase elementBase, Model model);
}