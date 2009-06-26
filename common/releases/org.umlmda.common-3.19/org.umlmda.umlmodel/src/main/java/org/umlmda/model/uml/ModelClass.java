// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelClass.java,v 1.11.2.1 2008/03/11 15:48:20 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelClass.java,v $
// $Revision: 1.11.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/03/11 15:48:20 $
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

import java.util.Collection;
import java.util.List;

/**
 * interface for sophisticated model class access
 * 
 * @author vpussel
 */
public interface ModelClass extends ModelClassifier, ModelClassBase, ModelVisitable {
	/**
	 * return all variable attributes, optional including the base class attributes
	 * @param includeBaseClasses
	 */
   public abstract List getAttributes(boolean includeBaseClasses);
   /**
	 * return all methods, optional including the base class methods
	 * @param includeBaseClasses
    */
   public abstract List getMethods(boolean includeBaseClasses);
	/**
    * @return list of all direct superclasses, sorted by name
    */
   public abstract List getSuperClasses();
   /**
    * Returns an alphabetically sorted list of all direct and inherited superclasses
    */
   public abstract List getAllSuperClasses();
   /** 
    * Get all classes which are directly inherited from this class 
    */
   public abstract List getSubClasses();
   /**
    * Checks if derived classes exists for the class
    * @return
    */
   public boolean hasDerivedClasses();
   /** 
    * Get all classes which are directly or indirectly inherited from this class 
    */
   public abstract List getAllSubClasses();
   /**
    * Returns all associations and if required the associations of all base classes
    */
   public abstract List getAssociations(boolean includeBaseClasses);

   /**
    * Returns all associations (navigatable or not), sorted by name, and 
    * if required the associations of all base classes
    */
   public abstract List getAllAssociations(boolean includeBaseClasses);
   
   /**
    * @return an alphabetically sorted list with all referenced classes,
    * consisting of sub and super classes, method parameters, method return types,
    * and method exceptions
    */
   public abstract List getReferencedTypes();
   /**
    * @return a collection of ModelElements which reference this class.
    * A class can be referenced by another class whichs has a navigatable 
    * association to the class, or which is derived from this class. 
    */
   public abstract List getReferencedBy(); 

   public abstract List getReferencedBy(Class type);
   /**
    * Checks whether this class is inherited from the given class  
    */
   public abstract boolean isInheritedFrom(ModelClass segmentClass);

	/**
    * Returns the parent of a class, a parent class is the class
    * with has a composition to the class.
    */
   public abstract ModelClass getParent();

	/**
    * Returns the composition assocations containing this class
    * as target.
    */
   public abstract Collection getParentCompositions();
   
	/**
	 * @return the package holding this class 
	 */
   public abstract ModelPackage getPackage();

   /**
    * Returns the composition of the parent class, which points to this
    * class.
    */
   public abstract ModelAssociation getParentComposition();

	/**
    * returns the superclass if unique, else null
	 * @deprecated
	 */
	public abstract ModelClass getSuperClass();

	/**
	 * @return true if the class is used in associations and has subclasses.
	 */
	public abstract boolean hasPolymorphicAssociations();
	
	/**
	 * @return all classes belonging to a service class' schema
	 * a schema contains all classes passed as parameters, or as return types,
	 * or as exceptions, plus all types directly and indirectly referenced by these
	 * via data associations or inheritance relations
	 * 
	 * @author pussel
	 */
	public abstract List getSchemaTypes();

   /**
    * Returns a list of attributes containing the primary key of the object. Includes
    * attributes from parents, if key attributes from compostition parent are inherited.
    * @return List of <code>ModelAttribute<code>s containing the key attributes.  
    */
   public abstract List getKeyAttributes();
   
   /**
    * Returns a list of attributes containing the primary key of the object, which are
    * part of this class or one of the super classes.
    * @return List of <code>ModelAttribute<code>s containing the key attributes.  
    */
   public abstract List getOwnedKeyAttributes(boolean includeSuperClasses);

   /**
    * Returns a list of key attributes inherited from the parent. 
    * @return List of <code>ModelAttribute<code>s containing the key attributes.  
    */
   public abstract List getInheritedKeyAttributes();
   
   /**
    * Returns the inheritance tree the modell class is part of (all base and sub classes)
    */
   public List getInheritanceTree();
   
   /**
    * Checks if the class contains featutes (methods or derived attibutes or associations)
    * which could not be generated. 
    */
   public boolean isNoneGenerateableFeaturesOwned();
   
   /**
    * Checks if the class contains featutes (methods or derived attibutes or associations)
    * which could not be generated. 
    * 
    * @deprecated use isNoneGenerateableFeaturesOwned()
    */
   public boolean hasNoneGenerateableFeatures();
   
   /**
    * Return all visible abstract base classes with none generatable code.
    * @see #hasNoneGenerateableFeatures()
    */
   public List getAbstractBaseClassesWithNoneGenerateableFeatures();
}