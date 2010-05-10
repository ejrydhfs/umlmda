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

import java.util.Collection;
import java.util.Properties;

/**
 * Interface for the base of all model elements.
 * 
 * @author Dieter Moroff (09.11.2004)
 */
public interface ModelElementBase
{
   String PROPERTY_DEPENDENCIES  = "dependencies";
   String PROPERTY_STEREOTYPES   = "stereotypes";
   String PROPERTY_DOCUMENTATION = "documentation";
   String PROPERTY_NAME          = "name";
   String PROPERTY_CONSTRAINTS   = "constraints";

   /**
    * Returns the unique model id
    */
   String getModelUId();

   /**
    * Return the tagged values set for the model element
    * 
    * @deprecated use getStereotypeProperty() instead
    */
   Properties getTaggedValues();

   /**
    * Return the tagged values set for the model element
    * 
    * @param name
    *           Name of the stereotype property (tagged value)
    */
   String getStereotypeProperty(String name);

   /**
    * Return the tagged values set for the model element
    * 
    * @param name
    *           Name of the stereotype property (tagged value)
    * @param defaultValue
    *           Default value if not found in the properties
    */
   String getStereotypeProperty(String name, String defaultValue);

   /**
    * Return a list of stereotype which are assigned to the model element.
    */
   Collection getStereotypes();

   /**
    * Returns the name of a model element
    */
   String getName();

   /**
    * Returns the name of the model element
    */
   String getDocumentation();

   /**
    * Returns the Owner of the modelelement or null if owner is the model.
    */
   ModelElementBase getOwnerBase();

   /**
    * Returns the model containing this element
    * 
    * @deprecated introduces hard to find inconsistencies. Model should be supplied by caller where needed
    */
   ModelBase getModelBase();

   /**
    * Returns a list of dependencies, where the current element is supplier
    */
   Collection getDependencies();

   /**
    * Returns a newline separated list of constraints defined on the model elements
    */
   String getConstraints();

}