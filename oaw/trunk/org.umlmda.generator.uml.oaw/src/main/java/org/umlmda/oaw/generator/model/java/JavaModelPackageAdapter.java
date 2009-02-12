/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.oaw/src/org/umlmda/oaw/generator/model/java/JavaModelPackageAdapter.java,v 1.2 2006/10/23 09:45:06 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.oaw/src/org/umlmda/oaw/generator/model/java/JavaModelPackageAdapter.java,v $
 * $Revision: 1.2 $
 *     $Name:  $
 *     $Date: 2006/10/23 09:45:06 $
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
 * Created on 24.07.2006 (Dieter Moroff)
 */
package org.umlmda.oaw.generator.model.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.profile.ModelStereotype;

/**
 * @author MOROFF
 *
 */
public class JavaModelPackageAdapter extends org.umlmda.uml.generator.java.JavaModelPackageAdapter implements JavaModelPackage {

   /**
    * @param modelPackage
    * @param modelAdapter
    */
   public JavaModelPackageAdapter(ModelPackageBase modelPackage, Model modelAdapter) {
      super(modelPackage, modelAdapter);
   }

   public List<JavaBusinessObject> getBusinessObjects() {
      List<JavaBusinessObject> businessObjects = new ArrayList<JavaBusinessObject>();
      
      for (Iterator ic = getClasses(ModelStereotype.BUSINESS_OBJECT).iterator(); ic.hasNext();) {
         JavaBusinessObject businessObject = (JavaBusinessObject) ic.next();
         
         businessObjects.add(businessObject);
      }
      return businessObjects;
    }

   public List<JavaBusinessService> getBusinessServices() {
      List<JavaBusinessService> businessServices = new ArrayList<JavaBusinessService>();
      
      for (Iterator ic = getClasses(ModelStereotype.BUSINESS_SERVICE).iterator(); ic.hasNext();) {
         JavaBusinessService businessService = (JavaBusinessService) ic.next();
         
         businessServices.add(businessService);
      }
      return businessServices;
   }

}
