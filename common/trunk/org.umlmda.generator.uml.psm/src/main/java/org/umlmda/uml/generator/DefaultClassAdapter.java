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

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.impl.ModelClassAdapter;

/**
 * Defaultimplementation of generator class for uml models
 * @author MOROFF
 */
public class DefaultClassAdapter extends ModelClassAdapter implements GeneratorClass {

   /**
    * @param modelClass
    * @param model
    */
   public DefaultClassAdapter(ModelClassBase modelClass, Model model) {
      super(modelClass, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getGeneratedName()
    */
   public String getGeneratedName() {
      return getName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getGeneratedPath()
    */
   public String getGeneratedPath() {
      // TODO Auto-generated method stub
      return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getGeneratedName(java.lang.String)
    */
   public String getGeneratedName(String artefactType) {
      return getName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getQualifiedName(java.lang.String)
    */
   public String getQualifiedName(String artefactName) {
      return getQualifiedName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getQualifiedName(java.lang.String, org.umlmda.generator.model.uml.GeneratorClass)
    */
   public String getQualifiedName(String artefactName, GeneratorClass modelClass) {
      return modelClass.getQualifiedName(artefactName);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getQualifiedName(java.lang.String, org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String getQualifiedName(String artefactName, GeneratorMethod method) {
      return ((ModelMethod)method).getQualifiedName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getGeneratorPackage()
    */
   public GeneratorPackage getGeneratorPackage() {
      return (GeneratorPackage) getPackage();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getScopedName(java.lang.String)
    */
   public String getScopedName(String artefactName) {
      return getQualifiedName(artefactName);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getScopedName(java.lang.String, org.umlmda.generator.model.uml.GeneratorClass)
    */
   public String getScopedName(String artefactName, GeneratorClass genClass) {
      return genClass.getQualifiedName(artefactName);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getScopedName(java.lang.String, org.umlmda.generator.model.uml.GeneratorPackage)
    */
   public String getScopedName(String artefactName, GeneratorPackage modelPackage) {
      return modelPackage.getQualifiedName(artefactName);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getReplacementName()
    */
   public String getReplacementName() {
      return getName();
   }

   public String getDocumentation(String context) {
      return getDocumentation();
   }

   public void setAsCurrentArtefact(String artefact) {
      getGeneratorModel().getContext().setCurrentModelElement(this);
      getGeneratorModel().getContext().setCurrentArtefact(getGeneratorModel().getArtefact(artefact, this));
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClassifier#getPsmType()
    */
   public String getPsmType() {
      return getGeneratedName();
   }
}
