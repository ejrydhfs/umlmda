/*
 *  Copyright (C) 2003, 2004 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://umlmda.sf.net)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on 08.08.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.model.uml.impl.ModelAdapterFactoryImpl;
import org.umlmda.model.uml.pattern.ModelPatternFactory;
import org.umlmda.model.uml.validate.ModelValidatorFactory;
import org.umlmda.uml.generator.StandardModelValidatorFactory;

/**
 * Implementation for a model adapter factory for the java model adaption
 * 
 * @author MOROFF
 */
public class JavaModelAdapterFactory extends ModelAdapterFactoryImpl
{

   public JavaModelAdapterFactory() {
      super();
   }

   public ModelPatternFactory getPatternFactory() {
      return new ModelPatternFactory() {

         public List createPatterns() {
            List patterns = new ArrayList();

            patterns.add(new PersistenceServicePattern());
            return patterns;
         }

      };
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#getValidatorFactory()
    */
   public ModelValidatorFactory getValidatorFactory() {
      return new StandardModelValidatorFactory();
   }

   protected Model createPsmModel(Model model) {
      return new JavaModelAdapter(this, model);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelClass(org.umlmda.model.uml.ModelClassBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelClass createModelClass(ModelClassBase modelClassBase, Model destModel) {
      return new JavaModelClassAdapter(modelClassBase, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelDataType(org.umlmda.model.uml.ModelDataTypeBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelDataType createModelDataType(ModelDataTypeBase modelDataType, Model destModel) {
      return new JavaModelDataTypeAdapter(modelDataType, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelPackage(org.umlmda.model.uml.ModelPackageBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model destModel) {
      return new JavaModelPackageAdapter(modelPackage, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelMethod(org.umlmda.model.uml.ModelMethodBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelMethod createModelMethod(ModelMethodBase modelMethod, Model destModel) {
      return new JavaModelMethodAdapter(modelMethod, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelAssociation(org.umlmda.model.uml.ModelAssociationBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelAssociation createModelAssociation(ModelAssociationBase modelAssociation, Model destModel) {
      return new JavaModelAssociationAdapter(modelAssociation, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelAttribute(org.umlmda.model.uml.ModelAttributeBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelAttribute createModelAttribute(ModelAttributeBase modelAttribute, Model destModel) {
      return new JavaModelAttributeAdapter(modelAttribute, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelParameter(org.umlmda.model.uml.ModelParameterBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelParameter createModelParameter(ModelParameterBase modelParameter, Model destModel) {
      return new JavaModelParameterAdapter(modelParameter, destModel);
   }
}
