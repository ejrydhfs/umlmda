// UMLMDA, UMLModel-API
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
 * Interface for sophisticated model package access
 * 
 * @author vpussel
 */
public interface ModelPackage extends ModelElement, ModelPackageBase, ModelVisitable
{

   /**
    * @return the package containing this package
    */
   public abstract ModelPackage getPackage();

   /**
    * @return an alphabetically sorted list of all packages on with this package depends
    */
   public abstract List getReferencedPackages();

   /**
    * @return an alphabetically sorted list of all referenced classes
    */
   public abstract List getReferencedClasses();

   /**
    * Returns a list containing only objects of the given stereotype
    */
   public abstract List getClasses(String stereotype);

   /**
    * @return A list of nested packages.
    */
   public abstract List<? extends ModelPackageBase> getNestedPackages();
}