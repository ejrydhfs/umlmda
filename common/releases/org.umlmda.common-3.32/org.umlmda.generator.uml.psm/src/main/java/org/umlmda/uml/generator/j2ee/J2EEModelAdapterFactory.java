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
package org.umlmda.uml.generator.j2ee;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.uml.generator.java.JavaModelAdapterFactory;

/**
 * Implementation for a model adapter factory for the j2ee model adaption
 * 
 * @author MOROFF
 */
public class J2EEModelAdapterFactory extends JavaModelAdapterFactory
{

   public J2EEModelAdapterFactory() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModel(org.umlmda.model.uml.ModelBase)
    */
   protected Model createPsmModel(Model model) {
      return new J2EEModelAdapter(this, model);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelClass(org.umlmda.model.uml.ModelClassBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelClass createModelClass(ModelClassBase modelClassBase, Model destModel) {
      // if ( modelClassBase instanceof J2EEModelClassAdapter )
      // return (ModelClass) modelClassBase;
      // else {
      // ModelClass modelClass = null;
      //         
      // if ( modelClassBase instanceof ModelClass ) {
      // modelClass = (ModelClass) modelClassBase;
      // }
      // else {
      // modelClass = super.createModelClass(modelClassBase, destModel);
      // }

      return new J2EEModelClassAdapter(modelClassBase, destModel);
      // }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelPackage(org.umlmda.model.uml.ModelPackageBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model destModel) {
      // if ( modelPackage instanceof J2EEModelPackageAdapter )
      // return (ModelPackage) modelPackage;
      // else
      return new J2EEModelPackageAdapter(modelPackage, destModel);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAdapterFactory#createModelMethod(org.umlmda.model.uml.ModelMethodBase,
    * org.umlmda.model.uml.Model)
    */
   public ModelMethod createModelMethod(ModelMethodBase modelMethod, Model destModel) {
      // if ( modelMethod instanceof J2EEModelMethodAdapter )
      // return (ModelMethod) modelMethod;
      // else
      return new J2EEModelMethodAdapter(modelMethod, destModel);
   }
}
