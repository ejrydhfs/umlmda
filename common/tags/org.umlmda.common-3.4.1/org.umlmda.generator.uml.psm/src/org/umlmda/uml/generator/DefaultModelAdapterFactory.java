/*
 *  $Header$
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
 *  Created on 14.11.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.impl.ModelAdapterFactoryImpl;

/**
 * Implementation of model adapter factory for default adapters
 * @author MOROFF
 */
public class DefaultModelAdapterFactory extends ModelAdapterFactoryImpl {

   public DefaultModelAdapterFactory() {
      super();
   }
   
   protected Model createPsmModel(Model model) {
      return new DefaultModelAdapter(this, model);
   }

   public ModelClass createModelClass(ModelClassBase modelClassBase, Model destModel) {
      if ( modelClassBase instanceof DefaultClassAdapter )
         return (ModelClass) modelClassBase;
      else
         return new DefaultClassAdapter(modelClassBase, destModel);
   }
   
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model destModel) {
      if ( modelPackage instanceof DefaultPackageAdapter )
         return (ModelPackage) modelPackage;
      else
         return new DefaultPackageAdapter(modelPackage, destModel);
   }
      
}
