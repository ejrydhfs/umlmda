// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelAttribute.java,v 1.2 2006/04/12 20:18:30 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelAttribute.java,v $
// $Revision: 1.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/04/12 20:18:30 $
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
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface ModelAttribute extends ModelStructuralFeature, ModelAttributeBase, ModelVisitable {

	/**
	 * @return the type name of this attribute 
	 */
	public abstract String getType();

	/**
    * @return the class of this attribute or null if it is a primitive type
    */
   public abstract ModelClass getModelClass();

	/**
    * @return the abstract type classifier of this attribute
    */
   public abstract ModelClassifier getModelClassifier();

	/**
	 * @return the class owning this attribute
	 */
	public abstract ModelClass getOwningClass();

   /**
    * @return
    */
   public abstract ModelDataType getDataType();

   /**
    * @return true if the attribute is a class type
    */
   public abstract boolean isClassInstance();
}