// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelElementBase.java,v 1.5 2006/06/24 18:48:39 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelElementBase.java,v $
// $Revision: 1.5 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/06/24 18:48:39 $
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
import java.util.Properties;

/**
 * Interface for the base of all model elements.
 * @author Dieter Moroff (09.11.2004)
 */
public interface ModelElementBase  {
   public static final String PROPERTY_DEPENDENCIES = "dependencies";
   public static final String PROPERTY_STEREOTYPES = "stereotypes";
   public static final String PROPERTY_DOCUMENTATION = "documentation";
   public static final String PROPERTY_NAME = "name";
   public static final String PROPERTY_CONSTRAINTS = "constraints";

   /**
    * Returns the unique model id
    */
   public String getModelUId();
   
   /**
    * Return the tagged values set for the model element
    * @deprecated use getStereotypeProperty() instead
    */
   public abstract Properties getTaggedValues();
   /**
    * Return the tagged values set for the model element
    * @param name Name of the stereotype property (tagged value)
    */
   public abstract String getStereotypeProperty(String name);
   /**
    * Return the tagged values set for the model element
    * @param name Name of the stereotype property (tagged value)
    * @param defaultValue Default value if not found in the
    * properties
    */
   public abstract String getStereotypeProperty(String name, String defaultValue);
   /**
    * Return a list of stereotype which are assigned to the model element.
    */
   public abstract Collection getStereotypes();
   /**
    * Returns the name of a model element
    */
   public abstract String getName();
   /**
    * Returns the name of the model element
    */
   public abstract String getDocumentation();
   /**
    * Returns the Owner of the modelelement or null if owner is 
    * the model.
    */
   public abstract ModelElementBase getOwnerBase();
   /**
    * Returns the model containing this element
    * 
    * @deprecated introduces hard to find inconsistencies. Model should be supplied by caller where needed
    */
   public abstract ModelBase getModelBase();
   /**
    * Returns a list of dependencies, where the current element is supplier
    */
   public abstract Collection getDependencies();

   /**
    * Returns a newline separated list of constraints defined on the model elements
    */
   public String getConstraints();

}