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
 * Created on 01.12.2006 (Dieter Moroff)
 */
package org.umlmda.uml.generator.emf;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.uml.generator.webservices.WSModelAdapterFactory;

/**
 * @author MOROFF
 */
public class EMFModelAdapterFactory extends WSModelAdapterFactory
{

   /**
    * 
    */
   public EMFModelAdapterFactory() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.impl.ModelAdapterFactoryImpl#createPsmModel(org.umlmda.model.uml.Model)
    */
   protected Model createPsmModel(Model model) {
      return new EMFModelAdapter(this, model);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelDataType(org.umlmda.model.uml.ModelDataTypeBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelDataType createModelDataType(ModelDataTypeBase modelDataType, Model destModel) {
      return new EMFModelDataTypeAdapter(modelDataType, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelAttribute(org.umlmda.model.uml.ModelAttributeBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelAttribute createModelAttribute(ModelAttributeBase modelAttribute, Model destModel) {
      return new EMFModelAttributeAdapter(modelAttribute, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelAssociation(org.umlmda.model.uml.ModelAssociationBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelAssociation createModelAssociation(ModelAssociationBase modelAssociation, Model destModel) {
      return new EMFModelAssociationAdapter(modelAssociation, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelClass(org.umlmda.model.uml.ModelClassBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelClass createModelClass(ModelClassBase modelClassBase, Model destModel) {
      return new EMFModelClassAdapter(modelClassBase, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelPackage(org.umlmda.model.uml.ModelPackageBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model model) {
      return new EMFModelPackageAdapter(modelPackage, model);
   }
}
