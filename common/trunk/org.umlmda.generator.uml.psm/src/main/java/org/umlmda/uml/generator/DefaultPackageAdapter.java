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
 *  Created on 14.11.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator;

import java.io.File;
import java.util.StringTokenizer;

import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.GeneratorUtils;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.NamespaceUsage;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.impl.ModelPackageAdapter;

/**
 * Default implementation of generator package for uml models
 * 
 * @author MOROFF
 */
public class DefaultPackageAdapter extends ModelPackageAdapter implements GeneratorPackage
{

   /**
    * @param modelPackage
    * @param modelAdapter
    */
   public DefaultPackageAdapter(ModelPackageBase modelPackage, Model modelAdapter) {
      super(modelPackage, modelAdapter);
   }

   public String getGeneratedPath() {
      StringBuffer buffer = new StringBuffer();
      Artefact artefact = getGeneratorModel().getContext().getCurrentArtefact();

      if ( artefact.getUseNamespace() == NamespaceUsage.FULL_QUALIFIED_LITERAL
            || artefact.getUseNamespace() == NamespaceUsage.TRUE_LITERAL ) {
         StringTokenizer parsePackage = new StringTokenizer(getQualifiedPackageName(artefact.getName()), ".");
         while ( parsePackage.hasMoreTokens() ) {
            buffer.append(File.separator);
            buffer.append(parsePackage.nextToken());
         }
      }
      else if ( artefact.getUseNamespace() == NamespaceUsage.NAME_ONLY_LITERAL ) {
         buffer.append(File.separator);

         String genName = GeneratorUtils.getGeneratedName(this, artefact.getName());
         buffer.append(genName.replace('/', File.separatorChar));
      }
      else if ( artefact.getUseNamespace() == NamespaceUsage.FALSE_LITERAL ) {
         // Do nothing
      }
      else {
         throw new RuntimeException("Unsupported namespace usage " + artefact.getUseNamespace().toString());
      }

      return buffer.toString();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorPackage#getGeneratedName(java.lang.String)
    */
   public String getGeneratedName(String artefactName) {
      return getName();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorPackage#getGeneratedName()
    */
   public String getGeneratedName() {
      return getName();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorPackage#getQualifiedPackageName(java.lang.String)
    */
   public String getQualifiedPackageName(String artefactType) {
      return getQualifiedName(artefactType);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorPackage#getQualifiedName(java.lang.String)
    */
   public String getQualifiedName(String artefactType) {
      return getQualifiedName();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorPackage#getQualifiedName(java.lang.String,
    * org.umlmda.generator.model.uml.GeneratorPackage)
    */
   public String getQualifiedName(String artefactType, GeneratorPackage modelPackage) {
      return modelPackage.getQualifiedName(artefactType);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   /*
    * (non-Javadoc)
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

}
