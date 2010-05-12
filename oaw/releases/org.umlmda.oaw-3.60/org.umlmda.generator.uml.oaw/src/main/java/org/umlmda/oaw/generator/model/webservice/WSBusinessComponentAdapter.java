/*
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
package org.umlmda.oaw.generator.model.webservice;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.profile.ModelStereotype;

/**
 * @author MOROFF
 */
public class WSBusinessComponentAdapter extends WSModelPackageAdapter implements WSBusinessComponent
{

   /**
    * @param modelPackage
    * @param modelAdapter
    */
   public WSBusinessComponentAdapter(ModelPackageBase modelPackage, Model modelAdapter) {
      super(modelPackage, modelAdapter);
   }

   @SuppressWarnings("unchecked")
   public List<WSBusinessObject> getBusinessObjects() {
      return new ArrayList<WSBusinessObject>(getClasses(WSBusinessObject.class, ModelStereotype.BUSINESS_OBJECT));
   }

   @SuppressWarnings("unchecked")
   public List<WSBusinessService> getBusinessServices() {
      return new ArrayList<WSBusinessService>(getClasses(WSBusinessService.class, ModelStereotype.BUSINESS_SERVICE));
   }

}
