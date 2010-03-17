// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/Model.java,v 1.5 2006/08/09 10:40:26 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/Model.java,v $
// $Revision: 1.5 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/08/09 10:40:26 $
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
//  Created on Nov 9, 2004
package org.umlmda.model.uml;


/**
 * interface for a model suitable for UMLMDA 
 * @author vpussel
 */
public interface Model extends ModelBase, ModelElement, ModelVisitable {

//   /**
//    * get or create an adapter for a model association
//    */
//   public abstract ModelAdapterFactory getModelAdapterFactory();

    /**
     * Returns the adapted model
     */
    public ModelBase getSrcModel();
    
	/**
	 * get or create an adapter for a model association
	 */
	public abstract ModelAssociation getModelAssociation( ModelAssociationBase modelAssociation);

	/**
	 * get or create an adapter for a model attribute
	 */
	public abstract ModelAttribute getModelAttribute( ModelAttributeBase modelAttribute);

	/**
	 * get or create an adapter for a model class
	 */
	public abstract ModelClass getModelClass( ModelClassBase modelClass);

	/**
	 * get or create an adapter for a model classifier
	 */
	public abstract ModelClassifier getModelClassifier( ModelClassifierBase modelClassifier);

	/**
	 * get or create an adapter for a model data type
	 */
	public abstract ModelDataType getModelDataType( ModelDataTypeBase modelDataType);

	/**
	 * get or create an adapter for a model element 
	 */
	public abstract ModelElement getModelElement( ModelElementBase modelElement);

	/**
	 * get or create an adapter for a model method
	 */
	public abstract ModelMethod getModelMethod( ModelMethodBase modelMethod);

	/**
	 * get or create an adapter for a model package
	 */
	public abstract ModelPackage getModelPackage( ModelPackageBase modelPackage);

	/**
	 * get or create an adapter for a model parameter
	 */
	public abstract ModelParameter getModelParameter( ModelParameterBase modelParameter);

   /**
    * get or create an adapter for a model dependency
    */
   public abstract ModelDependency getModelDependency(ModelDependencyBase dependencyBase);

   /**
    * get or create an adapter for a model generalization
    */
   public ModelGeneralization getModelGeneralization(ModelGeneralizationBase gen);

   /**
    * Finds a model class or a model package by its full qualified name
    * full qualified names can be specified with "::" or "." separator
    */
   public abstract ModelElement find(String string);

   /**
    * Initialize the modell adapter after creation, should allway be done before any
    * other operation on the model is done.
    */
   public abstract void init();



}