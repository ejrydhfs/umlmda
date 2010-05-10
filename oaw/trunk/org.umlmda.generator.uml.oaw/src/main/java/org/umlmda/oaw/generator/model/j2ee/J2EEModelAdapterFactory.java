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
 * Created on 08.08.2006 (Dieter Moroff)
 */
package org.umlmda.oaw.generator.model.j2ee;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.oaw.generator.model.java.JavaModelAdapterFactory;
import org.umlmda.profile.ModelStereotype;

public class J2EEModelAdapterFactory extends JavaModelAdapterFactory
{

   @Override
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model destModel) {
      if ( modelPackage.getStereotypes().contains(ModelStereotype.BUSINESS_COMPONENT) ) {
         return new J2EEBusinessComponentAdapter(modelPackage, destModel);
      }
      else {
         return new J2EEModelPackageAdapter(modelPackage, destModel);
      }
   }

   @Override
   public ModelClass createModelClass(ModelClassBase modelClassBase, Model destModel) {
      if ( modelClassBase.getStereotypes().contains(ModelStereotype.BUSINESS_SERVICE) ) {
         return new J2EEBusinessServiceAdapter(modelClassBase, destModel);
      }
      else {
         return super.createModelClass(modelClassBase, destModel);
      }
   }

   @Override
   protected Model createPsmModel(Model model) {
      return new J2EEModelAdapter(this, model);
   }

}
