// UMLMDA, UMLModel-API
//
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
//
// Created on Oct 14, 2005

package org.umlmda.model.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * @author pussel helper functionality for any UML model
 */
public class UMLModelHelper
{

   static public List<ModelPackage> getPackagesFromClassList(Collection<ModelClass> classList) {
      return getPackagesFromClassList(classList, null);
   }

   /**
    * @param classList
    *           to examine for different packages
    * @return alphabetically sorted list of all packages occurring in the given class list
    */
   static public List<ModelPackage> getPackagesFromClassList(Collection<ModelClass> classList, String packageStereotype) {
      Set<ModelPackage> set = new HashSet<ModelPackage>();
      for ( Iterator<ModelClass> iter = classList.iterator(); iter.hasNext(); ) {
         ModelClass mClass = iter.next();
         ModelPackage mPackage = mClass.getPackage();

         if ( StringUtils.isEmpty(packageStereotype) || mPackage.hasStereotype(packageStereotype) )
            set.add(mClass.getPackage());
      }
      List<ModelPackage> packageList = new ArrayList<ModelPackage>(set.size());
      packageList.addAll(set);
      Collections.sort(packageList);
      return packageList;
   }

}
