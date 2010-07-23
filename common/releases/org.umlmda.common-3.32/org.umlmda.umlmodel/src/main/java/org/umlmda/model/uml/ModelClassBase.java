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
//  Created on Nov 9, 2004
package org.umlmda.model.uml;

import java.util.List;

/**
 * interface for basic model class access
 * 
 * @author vpussel
 */
public interface ModelClassBase extends ModelClassifierBase
{
   String PROPERTY_ASSOCIATIONS     = "associations";
   String PROPERTY_ALL_ASSOCIATIONS = "allAssociations";
   String PROPERTY_SUPER_CLASSES    = "superClasses";
   String PROPERTY_METHODS          = "methods";
   String PROPERTY_CONSTANTS        = "constants";
   String PROPERTY_ATTRIBUTES       = "attributes";
   String PROPERTY_GENERALIZATIONS  = "generalizations";

   /**
    * @return the package holding this class
    */
   ModelPackageBase getPackageBase();

   /**
    * @return the list of variable attributes
    */
   List getAttributes();

   /**
    * Returns the list of constant attributes (a constant must be mark frozen, scope classifier and have an initial value).
    */
   List getConstants();

   /**
    * @return the list of methods, sorted by name
    */
   List getMethods();

   /**
    * Returns the associations which are navigatable from the class, sorted by name
    */
   List getAssociations();

   /**
    * Returns all associations (navigatable or not), sorted by name
    */
   List getAllAssociations();

   /**
    * @return true if the class is abstract
    */
   boolean isAbstract();

   /**
    * Gets a list of associations to generalizations of the current class
    */
   List getGeneralizations();
}