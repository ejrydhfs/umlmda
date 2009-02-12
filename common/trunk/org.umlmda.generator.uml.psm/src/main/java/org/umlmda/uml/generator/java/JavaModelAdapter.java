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
 *  Created on 17.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.impl.ModelClassImpl;
import org.umlmda.model.uml.impl.ModelPackageImpl;
import org.umlmda.model.uml.utils.ModelVisitableIterator;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.DefaultModelAdapter;

/**
 * Implementation of a model adapter for java generation 
 * @author Dieter Moroff
 */
public class JavaModelAdapter extends DefaultModelAdapter implements JavaModel {
   private boolean init = false;
   
   public Collection getClasses() {
      init();
      return super.getClasses();
   }
   public Collection getPackages() {
      init();
      return super.getPackages();
   }
   /**
    * @param factory
    * @param srcModel
    */
   public JavaModelAdapter(ModelAdapterFactory factory, ModelBase srcModel) {
      super(factory, srcModel);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#getModelElements()
    */
   public final Set getModelElements() {
      final Set modelElements = new HashSet();
      init();

      // Using the visitor to collect all packages and classes for generation
      new ModelVisitableIterator(new DefaultModelVisitor(logger) {
         public boolean visit(ModelPackage modelPackage) {
            super.visit(modelPackage);
            modelElements.add(modelPackage);
            return true;
         }

         public boolean visit(ModelClass modelClass) {
            super.visit(modelClass);
            modelElements.add(modelClass);
            return true;
         }

      }).iterate(this);

      return modelElements;
   }

   /**
    * @param packageName
    * @param model
    * @return
    */
   protected ModelPackage createPackage(String packageName, ModelElement owner) {
      ModelPackage modelPackage;
      ModelPackageImpl modelPackageImpl = new ModelPackageImpl(getModel(), owner);
      Model model = owner != null ? owner.getModel() : this;

      modelPackageImpl.setName(packageName);
      modelPackage = model.getModelPackage(modelPackageImpl);
      model.getPackages().add(modelPackage);
      return modelPackage;
   }
   
   /**
    * @param packageName
    * @param model
    * @return
    */
   protected ModelClass createClass(String packageName, ModelPackage owner, String stereotype) {
      ModelClass modelClass;
      ModelClassImpl modelClassImpl = new ModelClassImpl(getModel(), owner);
      Model model = owner != null ? owner.getModel() : this;

      modelClassImpl.setName(packageName);
      if ( stereotype != null )
         modelClassImpl.getStereotypes().add(stereotype);
      modelClass = model.getModelClass(modelClassImpl);
      owner.getClasses().add(modelClass);
      model.getClasses().add(modelClass);
      return modelClass;
   }
   
   public void init() {
      if ( ! init ) {
         this.init = true;

         createCommonModelElements();
         
         // Using visitor to handle <<AsyncCall>> methods
         new ModelVisitableIterator(new JavaPSMCreateListenerVisitor()).iterate(this);
      }
   }
   
   /**
    * Create common elements used in the writers for the java plattform. 
    */
   protected void createCommonModelElements() {
      // Create common java classes
      ModelPackage java = (ModelPackage) find("java"); 
      if ( java == null ) {
         java = createPackage("java", getModel());
      }
      ModelPackage javaLang = (ModelPackage) find("java.lang"); 
      if ( javaLang == null ) {
         javaLang = createPackage("lang", java);
      }
      ModelClass javaLangThrowable = (ModelClass)find(Throwable.class.getName());
      if ( javaLangThrowable == null ) {
         javaLangThrowable = createClass("Throwable", javaLang, ModelStereotype.NATIVE_CLASS);
      }
      ModelClass javaLangException = (ModelClass)find(Exception.class.getName());
      if ( javaLangException == null ) {
         javaLangException = createClass("Exception", javaLang, ModelStereotype.NATIVE_CLASS);
      }
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModel#isSpringSupported()
    */
   public boolean isSpringSupported() {
      return Boolean.valueOf(getProperties().getProperty(PROPERTY_SPRING_SUPPORT, PROPERTY_SPRING_SUPPORT_DEFAULT)).booleanValue();
   }
   
   
}
