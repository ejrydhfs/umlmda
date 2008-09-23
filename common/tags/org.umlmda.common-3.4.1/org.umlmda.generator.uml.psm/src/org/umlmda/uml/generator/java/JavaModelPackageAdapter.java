/*
 *  $Header$
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
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
 *  Created on 17.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.GeneratorUtils;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.uml.generator.DefaultPackageAdapter;

/**
 * Implementation of a model package adapter for java generation
 */
public class JavaModelPackageAdapter extends DefaultPackageAdapter implements JavaModelPackage {
   private final JavaImportHelper importHelper = new JavaImportHelperImpl(this);
   private final JavaModelElementHelper delegate;
   
   /**
    * @param modelPackage
    * @param modelAdapter
    */
   public JavaModelPackageAdapter(ModelPackageBase modelPackage, Model modelAdapter) {
      super(modelPackage, modelAdapter);
      delegate = new JavaModelElementHelper(this);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorPackage#getGeneratedName(java.lang.String)
    */
   public String getGeneratedName(String artefactName) {
   	  return GeneratorUtils.getGeneratedName(this, artefactName);
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorPackage#getGeneratedName()
    */
   public String getGeneratedName() {
      Artefact artefact = getGeneratorModel().getContext().getCurrentArtefact();
      return getGeneratedName(artefact); 
   }

   /**
    * @param artefact
    * @return
    */
   private String getGeneratedName(Artefact artefact) {
      String generatedName = GeneratorUtils.getGeneratedName(this, artefact.getName());
      
   	  return generatedName;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModelPackage#getQualifiedName(java.lang.String)
    */
   public String getQualifiedName(String artefactType) {
      return getQualifiedName(artefactType, this); 
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModelPackage#getQualifiedName(java.lang.String, net.sourceforge.umlmda.xmi.uml.ModelPackageBase)
    */
   public String getQualifiedName(String artefactType, GeneratorPackage modelPackage) {
      Artefact artefact = getGeneratorModel().getArtefact(artefactType, modelPackage);
      StringBuffer buffer = new StringBuffer();
      
      if ( artefact == null ) {
         throw new RuntimeException("Artefact "+artefactType+" not found in profile");
      }
      
      if ( StringUtils.isNotEmpty(artefact.getNamespacePrefix()))
         buffer.append(artefact.getNamespacePrefix());
      buffer.append((((ModelPackage)modelPackage).getQualifiedName()));
      if ( StringUtils.isNotEmpty(artefact.getNamespacePostfix()))
         buffer.append(artefact.getNamespacePostfix());
      buffer.append(".");
      buffer.append(modelPackage.getGeneratedName(artefactType));
      return buffer.toString(); 
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaImportHelper#getScopedName(java.lang.String)
    */
   public String getScopedName(String artefactName) {
      return importHelper.getScopedName(artefactName);
   }

   public String getScopedName(String artefactName, GeneratorClass genClass) {
      return importHelper.getScopedName(artefactName, genClass);
   }

   public String getScopedName(String artefactName, GeneratorPackage genPackage) {
      return importHelper.getScopedName(artefactName, genPackage);
   }

   public String registeredImports() {
      return importHelper.registeredImports();
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaImportHelper#registerImport(java.lang.String)
    */
   public void registerImport(String artefactName) {
      importHelper.registerImport(artefactName);
   }

   public void registerImport(String artefactName, JavaModelClass genClass) {
      importHelper.registerImport(artefactName, genClass);
   }
   
   public void registerImport(String artefactName, JavaModelPackage genClass) {
      importHelper.registerImport(artefactName, genClass);
   }

   public void registerImports(String business_interface, Collection classes) {
      importHelper.registerImports(business_interface, classes);
   }
   
   public void registerImports(String business_interface, Collection classes, String stereotype) {
      importHelper.registerImports(business_interface, classes, stereotype);
   }

   public void resetImports() {
      importHelper.resetImports();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorPackage#getQualifiedPackageName(java.lang.String)
    */
   public String getQualifiedPackageName(String artefactType) {
      String qualifiedName = getQualifiedName(artefactType);
      
      if ( qualifiedName.indexOf(".") >= 0 ) {
         return qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
      }
      else {   
         return qualifiedName;
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getReplacementName()
    */
   public String getReplacementName() {
      return getName();
   }

   public String getDocumentation(String context) {
      return delegate.getDocumentation(context);
   }
   
   public String getUpperCaseIdentifier() {
      return StringUtil.toUpperCaseIdentifier(getName());
   }
   
}


