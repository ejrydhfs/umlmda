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

import java.util.HashSet;
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
import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.impl.ModelAdapter;
import org.umlmda.model.uml.utils.ModelVisitableIterator;

/**
 * Default implementation for generator model for uml models
 * 
 * @author MOROFF
 */
public class DefaultModelAdapter extends ModelAdapter implements GeneratorModel
{
   GeneratorModel delegate = new GeneratorModelImpl() {

                              public Set<ModelElement> getModelElements() {
                                 return DefaultModelAdapter.this.getModelElements();
                              }

                              public Set<ModelElement> getAllModelElements() {
                                 return DefaultModelAdapter.this.getAllModelElements();
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
   public Set<Artefact> getArtefacts(String stereotype) {
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

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModel#getModelElements()
    */
   public Set<ModelElement> getModelElements() {
      final Set<ModelElement> modelElements = new HashSet<ModelElement>();

      // Using the visitor to collect all packages and classes for generation
      new ModelVisitableIterator(new DefaultModelVisitor(logger) {
         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelPackage)
          */
         public boolean visit(ModelPackage modelPackage) {
            super.visit(modelPackage);
            modelElements.add(modelPackage);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelClass)
          */
         public boolean visit(ModelClass modelClass) {
            super.visit(modelClass);
            modelElements.add(modelClass);
            return true;
         }

      }).iterate(this);

      return modelElements;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModel#getAllModelElements()
    */
   public Set<ModelElement> getAllModelElements() {
      final Set<ModelElement> modelElements = new HashSet<ModelElement>();

      // Using the visitor to collect all packages and classes for generation
      new ModelVisitableIterator(new DefaultModelVisitor(logger) {
         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.Model)
          */
         @Override
         public boolean visit(Model model) {
            super.visit(model);
            modelElements.add(model);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelPackage)
          */
         @Override
         public boolean visit(ModelPackage modelPackage) {
            super.visit(modelPackage);
            modelElements.add(modelPackage);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelClass)
          */
         @Override
         public boolean visit(ModelClass modelClass) {
            super.visit(modelClass);
            modelElements.add(modelClass);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelAttribute)
          */
         @Override
         public boolean visit(ModelAttribute modelAttribute) {
            super.visit(modelAttribute);
            modelElements.add(modelAttribute);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelAssociation)
          */
         @Override
         public boolean visit(ModelAssociation modelAssociation) {
            super.visit(modelAssociation);
            modelElements.add(modelAssociation);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelMethod)
          */
         @Override
         public boolean visit(ModelMethod modelMethod) {
            super.visit(modelMethod);
            modelElements.add(modelMethod);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelDataType)
          */
         @Override
         public boolean visit(ModelDataType dataType) {
            super.visit(dataType);
            modelElements.add(dataType);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelDependency)
          */
         @Override
         public boolean visit(ModelDependency dependency) {
            super.visit(dependency);
            modelElements.add(dependency);
            return true;
         }

         /*
          * (non-Javadoc)
          * @see org.umlmda.model.uml.DefaultModelVisitor#visit(org.umlmda.model.uml.ModelParameter)
          */
         @Override
         public boolean visit(ModelParameter parameter) {
            super.visit(parameter);
            modelElements.add(parameter);
            return true;
         }
      }).iterate(this);

      return modelElements;
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
