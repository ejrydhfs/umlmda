// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelElement.java,v 1.5 2006/02/15 19:42:27 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelElement.java,v $
// $Revision: 1.5 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/02/15 19:42:27 $
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
public interface ModelElement extends ModelElementBase, Comparable {
   /**
    * Returns the base element
    * @param stereotype
    */
   public ModelElementBase getBase();
   
   /**
    * Removes a stereotype from the adapter model
    * @return
    */
   public abstract void removeStereotype(String stereotype);
   /**
    * @return
    * @deprecated Used getStereotypes() or hasStereotype() since UML2 allows more than
    * one stereotype
    */
   public abstract String getStereotype();
   /**
    * Checks whether the modelelement has a stereotype with the given 
    * name
    */
   public abstract boolean hasStereotype(String string);
   /**
    * Returns the full qualified name of the model element
    */
   public abstract String getQualifiedName();
   /**
    * Returns the Owner of the modelelement or null if owner is 
    * the model.
    */
   public abstract ModelElement getOwner();
   /**
    * Returns the model containing this element
    * 
    * @deprecated introduces hard to find inconsistencies. Model should be supplied by caller where needed
    */
   public abstract Model getModel();
   
}