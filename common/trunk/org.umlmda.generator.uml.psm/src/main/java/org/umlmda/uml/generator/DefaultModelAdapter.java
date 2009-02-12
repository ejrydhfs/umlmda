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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.umlmda.generator.logging.LoggingWriter;
import org.umlmda.generator.model.uml.GeneratorContext;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.uml.GeneratorModelImpl;
import org.umlmda.generator.model.util.CodeEmitter;
import org.umlmda.generator.model.util.RcsHelper;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.impl.ModelAdapter;

/**
 * Default implementation for generator model for uml models
 * @author MOROFF
 */
public class DefaultModelAdapter extends ModelAdapter implements GeneratorModel {
   GeneratorModel delegate = new GeneratorModelImpl() {

      public Set getModelElements() {
         return DefaultModelAdapter.this.getModelElements();
      }
      
   };

   /**
    * @param factory
    * @param srcModel
    */
   public DefaultModelAdapter(ModelAdapterFactory factory, ModelBase srcModel) {
      super(factory, srcModel);
   }

   /**
    * @return
    */
   public Artefact getArtefact() {
      return delegate.getArtefact();
   }
   /**
    * @param artefactName
    * @return
    */
   public Artefact getArtefact(String artefactName, GeneratorModelElement modelElement) {
      return delegate.getArtefact(artefactName, modelElement);
   }
   /**
    * @param stereotype
    * @return
    */
   public Set getArtefacts(String stereotype) {
      return delegate.getArtefacts(stereotype);
   }
   /**
    * @return
    */
   public GeneratorContext getContext() {
      return delegate.getContext();
   }
   /**
    * @return
    */
   public GenerationProfile getProfile() {
      return delegate.getProfile();
   }
   /**
    * @return
    */
   public Properties getProperties() {
      return delegate.getProperties();
   }
   /**
    * @return
    */
   public RcsHelper getRcsHelper() {
      return delegate.getRcsHelper();
   }
   /**
    * @return
    */
   public LoggingWriter getLoggingWriter() {
      return delegate.getLoggingWriter();
   }
   /**
    * @param generationProfile
    */
   public void setProfile(GenerationProfile generationProfile) {
      delegate.setProfile(generationProfile);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModel#getModelElements()
    */
   public Set getModelElements() {
      Set modelElementSet = new HashSet();
      
      for (Iterator ip = getPackages().iterator(); ip.hasNext();) {
         ModelPackage modelPackage = (ModelPackage) ip.next();

         modelElementSet.add(modelPackage);
      }
      
      for (Iterator ic = getClasses().iterator(); ic.hasNext();) {
         ModelClass modelClass = (ModelClass) ic.next();
         
         modelElementSet.add(modelClass);
      }
      
      return modelElementSet;
   }
   
   /**
    * @return
    */
   public CodeEmitter createEmitter() {
      return delegate.createEmitter();
   }
   
   public GenerationSet getGenerationSet() {
      return delegate.getGenerationSet();
   }
   
   public void setGenerationSet(GenerationSet generationSet) {
      delegate.setGenerationSet(generationSet);
   }
}
