/*
 * UMLMDA - MDA generator and architecture 
 * 
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelClass.java,v 1.1 2006/12/04 10:49:49 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelClass.java,v $
 * $Revision: 1.1 $
 *    $State: Exp $
 *     $Name:  $
 *     $Date: 2006/12/04 10:49:49 $
 *   $Locker:  $
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
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModelClass extends JavaModelClass, WSModelClassifier {

   /**
    * Checks if the model class contains any attributes or associations
    * which have an optimization with the stereotypes <b>In</b> or 
    * <b>Out</b>.
    */
   public boolean isOptimized();

   public boolean hasDerivedOptimizedClasses();

   /**
    * Checks if the modelclass used as a service parameter
    * in a method of the <b>BusinessService</b> class.
    */
   public boolean usedAsParameter(WSModelClass serviceClass);
   
   /**
    * Checks if the modelclass used as a service parameter
    * in a method of the <b>BusinessService</b> class or 
    * referenced as an association target.
    */
   public boolean usedAsParameterOrReference(WSModelClass serviceClass);
   
   public String getDirectionType(String direction);
   
   public String getDirectionTypeOrHierarchie(String direction);
   
   public String getTypeOrHierarchie(String direction);
   
   public List getReferencedPackages();
   
   public List getReferencedClasses();
   
   public List getReferencedClasses(WSModelPackage modelPackage);
   
   /**
    * Returns a list with the type to be defined as complex types 
    * @return
    */
   public List getSchemaComplexTypes();
   
   /**
    * Returns a list with the type to be defined as simple enumeration
    * types 
    * @return
    */
   public List getSchemaEnumTypes();
   
   /**
    * Returns a list of classes which could be instances of this
    * class. That are all non abstract subclasses and the class 
    * itself if not abstract.
    */
   public List getInstanceClasses();
   
   /**
    * If class is a webservice psm class the pim class is return
    * @return
    */
   public JavaModelClass getPIMClass();

   /**
    * @return
    */
   public List getReferencedPIMTypes();
}
