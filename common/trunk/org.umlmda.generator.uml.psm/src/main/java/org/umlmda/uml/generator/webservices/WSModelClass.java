/*
 * UMLMDA - MDA generator and architecture 
 * 
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (08.11.2005)
 */
package org.umlmda.uml.generator.webservices;

import java.util.List;

import org.umlmda.uml.generator.java.JavaModelClass;

/**
 * @author MOROFF
 */
public interface WSModelClass extends JavaModelClass, WSModelClassifier
{

   /**
    * Checks if the model class contains any attributes or associations which have an optimization with the stereotypes <b>In</b>
    * or <b>Out</b>.
    */
   boolean isOptimized();

   boolean hasDerivedOptimizedClasses();

   /**
    * Checks if the modelclass used as a service parameter in a method of the <b>BusinessService</b> class.
    */
   boolean usedAsParameter(WSModelClass serviceClass);

   /**
    * Checks if the modelclass used as a service parameter in a method of the <b>BusinessService</b> class or referenced as an
    * association target.
    */
   boolean usedAsParameterOrReference(WSModelClass serviceClass);

   String getDirectionType(String direction);

   String getDirectionTypeOrHierarchie(String direction);

   String getTypeOrHierarchie(String direction);

   List getReferencedPackages();

   List getReferencedClasses();

   List getReferencedClasses(WSModelPackage modelPackage);

   /**
    * Returns a list with the type to be defined as complex types
    * 
    * @return
    */
   List getSchemaComplexTypes();

   /**
    * Returns a list with the type to be defined as simple enumeration types
    * 
    * @return
    */
   List getSchemaEnumTypes();

   /**
    * Returns a list of classes which could be instances of this class. That are all non abstract subclasses and the class itself
    * if not abstract.
    */
   List getInstanceClasses();

   /**
    * If class is a webservice psm class the pim class is return
    * 
    * @return
    */
   JavaModelClass getPIMClass();

   /**
    * @return
    */
   List getReferencedPIMTypes();
}
