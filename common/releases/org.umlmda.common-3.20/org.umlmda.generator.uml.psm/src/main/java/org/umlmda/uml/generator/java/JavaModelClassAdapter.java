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
 *  Created on 08.08.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import org.apache.log4j.Logger;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorClassHelper;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelStructuralFeature;
import org.umlmda.model.uml.impl.ModelClassAdapter;
import org.umlmda.model.uml.utils.ModelIterator;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.profile.ModelTaggedValues;
import org.umlmda.uml.generator.util.ArtefactUtils;

/**
 * Implementation of a model and generator class for common java generation
 * @author MOROFF
 */
public class JavaModelClassAdapter extends ModelClassAdapter implements GeneratorClass, JavaModelClass {
   private final JavaImportHelper importHelper = new JavaImportHelperImpl(this);
   private final GeneratorClassHelper classHelper = new GeneratorClassHelper(this);
//   private Map registeredImports = null;
//   private Set ambiguousImports = null;
//   private JavaModelPackage genPackage = (JavaModelPackage) getPackage();
   private final JavaModelElementHelper delegate;
   private List attributes = null;
   private List associations = null;
   private List methods = null;
   private List implementationReferencedTypes;
   private static Logger logger = Logger.getLogger(JavaModelClassAdapter.class);
      
   /**
    * @param modelClassBase
    * @param model
    */
   public JavaModelClassAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
      delegate = new JavaModelElementHelper(this);
   }

   /**
    * Reset cached information 
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      super.update(o, arg);
      
      if ( PROPERTY_ATTRIBUTES.equals(arg) && attributes != null ) {
         attributes.clear();
         attributes = null;
      }
      else if ( PROPERTY_METHODS.equals(arg) && methods != null ) {
         methods.clear();
         methods = null;
      }
      else if ( PROPERTY_ASSOCIATIONS.equals(arg) && associations != null ) {
         associations.clear();
         associations = null;
      }
      
   }
   
   public JavaModelPackage getJavaPackage() {
      return (JavaModelPackage) getPackage();
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorClass#getQualifiedName(java.lang.String)
    */
   public String getQualifiedName(String artefactType) {
      return getQualifiedName(artefactType, this);
   }

   public String getGeneratedName() {
      return classHelper.getGeneratedName();
   }

   public String getGeneratedPath() {
	   String packageName = ((JavaModelPackage)getGeneratorPackage()).getQualifiedPackageName(getGeneratorModel().getArtefact().getName());
	   
	   return packageName.replace('.', '/');
   }
   
   public String getGeneratedName(String artefactType) {
      return classHelper.getGeneratedName(artefactType);
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorClass#getQualifiedName(java.lang.String, org.umlmda.uml.generator.GeneratorClass)
    */
   public String getQualifiedName(String artefactType, GeneratorClass genClass) {
      ModelClass modelClass = (ModelClass) genClass;
      String packageName = ((GeneratorPackage)modelClass.getPackage()).getQualifiedPackageName(artefactType);
      
      return packageName + "." + genClass.getGeneratedName(artefactType); 
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClass#getQualifiedName(java.lang.String, org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String getQualifiedName(String artefactName, GeneratorMethod method) {
      GeneratorClass modelClass = method.getGeneratorClass();
      GeneratorPackage genPackage = modelClass.getGeneratorPackage();
      String packageName = genPackage.getQualifiedPackageName(artefactName);
      
      return packageName + "." + method.getGeneratedName(artefactName); 
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorClass#getGeneratorPackage()
    */
   public GeneratorPackage getGeneratorPackage() {
      return (GeneratorPackage) getPackage();
   }

   public String getSkopedName() {
      return getScopedName(getGeneratorModel().getContext().getCurrentArtefact().getName());
   }

   public String getScopedName(String artefactName) {
      return getScopedName(artefactName, this);
   }


   public void registerImport(String artefactName) {
      registerImport(artefactName, this);
   }

   public String getScopedName(String business_interface, GeneratorClass genClass) {
      return importHelper.getScopedName(business_interface, genClass);
   }
   
   public String getScopedName(String artefactName, GeneratorPackage genPackage) {
      return importHelper.getScopedName(artefactName, genPackage);
   }
   
   public String registeredImports() {
      return importHelper.registeredImports();
   }
   
   public void registerImport(String artefactName, JavaModelPackage genClass) {
      importHelper.registerImport(artefactName, genClass);
   }

   public void registerImport(String artefactName, JavaModelClass genClass) {
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
    * @see org.umlmda.uml.generator.java.JavaModelClass#hasAsyncMethods()
    */
   public boolean hasAsyncMethods() {
      boolean asyncMethods = false; 
      for (Iterator im = getMethods().iterator(); asyncMethods == false && im.hasNext();) {
         ModelMethod method = (ModelMethod) im.next();
         
         if ( method.hasStereotype(ModelStereotype.ASYNC_CALL))
            asyncMethods = true;
      }
      return asyncMethods;
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

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClassifier#getType(java.lang.String)
    */
   public String getType(String artefact) {
      return getScopedName(artefact);
   }

   /**
    * Returns the package containing the class and has the stereotype <code>BusinessComponent</code>
    */
   public JavaModelPackage getComponent() {
      try {
         ModelPackage component = getPackage();
         
         while ( component != null && component.hasStereotype(ModelStereotype.BUSINESS_COMPONENT) == false ) {
            component = component.getPackage();
         }
         return (JavaModelPackage)component;
      } catch (RuntimeException e) {
         logger.error(e.getMessage()+" determining component of "+getQualifiedName(), e);
         throw e;
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getModelVersion()
    */
   public String getModelVersion() {
      String modelVersion;
      ModelPackage component = getComponent();
      
      if ( component != null ) {
         String majorVersion = component.getStereotypeProperty(ModelTaggedValues.MAJOR_VERSION, "1");
         String minorVersion = component.getStereotypeProperty(ModelTaggedValues.MINOR_VERSION, "0");
         
         modelVersion = majorVersion + "." + minorVersion;
      }
      else {
         modelVersion = "N/A";
      }

      return modelVersion;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getSerialVersionUID()
    */
   public String getSerialVersionUID() {
      long serialVersionUID;
      ModelPackage component = getComponent();
      
      if ( component != null ) {
         long majorVersion = Long.parseLong(component.getStereotypeProperty(ModelTaggedValues.MAJOR_VERSION, "1"));
         long minorVersion = Long.parseLong(component.getStereotypeProperty(ModelTaggedValues.MINOR_VERSION, "0"));
         
         serialVersionUID = majorVersion * 1000 + minorVersion;
      }
      else {
         serialVersionUID = 0;
      }

      return Long.toString(serialVersionUID)+"L";
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClassifier#getJavaType()
    */
   public String getJavaType() {
      if ( getGeneratorModel().getContext().getCurrentModelElement() instanceof JavaModelClass ) {
         JavaModelClass genClass = (JavaModelClass) getGeneratorModel().getContext().getCurrentModelElement();

         if (hasStereotype(ModelStereotype.BUSINESS_OBJECT)) {
            return genClass.getScopedName(ArtefactUtils.getDefaultMapping(ModelStereotype.BUSINESS_OBJECT), this);
         }
         else if (hasStereotype(ModelStereotype.BUSINESS_SERVICE)) {
            return genClass.getScopedName(ArtefactUtils.getDefaultMapping(ModelStereotype.BUSINESS_SERVICE), this);
         }
         else if (hasStereotype(ModelStereotype.BUSINESS_EXCEPTION)) {
            return genClass.getScopedName(ArtefactUtils.getDefaultMapping(ModelStereotype.BUSINESS_EXCEPTION), this);
         }
         else if (hasStereotype(ModelStereotype.ENUMERATION)) {
            return genClass.getScopedName(ArtefactUtils.getDefaultMapping(ModelStereotype.ENUMERATION), this);
         }
         else if (hasStereotype(ModelStereotype.NATIVE_CLASS)) {
            return genClass.getScopedName(ArtefactUtils.getDefaultMapping(ModelStereotype.NATIVE_CLASS), this);
         }
         else if (hasStereotype(ModelStereotype.NATIVE_INTERFACE)) {
            return genClass.getScopedName(ArtefactUtils.getDefaultMapping(ModelStereotype.NATIVE_INTERFACE), this);
         } 
         else if (hasStereotype(ModelStereotype.SERVICE_LISTENER)) {
            return genClass.getScopedName(JavaArtefacts.SERVICE_LISTENER, this);
         }
      } 
      else if ( getGeneratorModel().getContext().getCurrentModelElement() instanceof JavaModelPackage )  {
         JavaModelPackage genPackage = (JavaModelPackage) getGeneratorModel().getContext().getCurrentModelElement();

         if (hasStereotype(ModelStereotype.BUSINESS_OBJECT)) {
            return genPackage.getScopedName(JavaArtefacts.BUSINESS_OBJECT_INTERFACE, this);
         }
         else if (hasStereotype(ModelStereotype.BUSINESS_SERVICE)) {
            return genPackage.getScopedName(JavaArtefacts.BUSINESS_SERVICE_INTERFACE, this);
         }
         else if (hasStereotype(ModelStereotype.BUSINESS_EXCEPTION)) {
            return genPackage.getScopedName(JavaArtefacts.BUSINESS_EXCEPTION, this);
         }
         else if (hasStereotype(ModelStereotype.ENUMERATION)) {
            return genPackage.getScopedName(JavaArtefacts.ENUMERATION, this);
         }
         else if (hasStereotype(ModelStereotype.NATIVE_CLASS)) {
            return genPackage.getScopedName(JavaArtefacts.PLAIN_CLASS, this);
         }
         else if (hasStereotype(ModelStereotype.NATIVE_INTERFACE)) {
            return genPackage.getScopedName(JavaArtefacts.PLAIN_INTERFACE, this);
         } 
      }
      throw new IllegalArgumentException(getQualifiedName()+" have no supported stereotype <<"+getStereotypes().toString()+">>");
   }
   
   public void setAsCurrentArtefact(String artefact) {
      getGeneratorModel().getContext().setCurrentModelElement(this);
      getGeneratorModel().getContext().setCurrentArtefact(getGeneratorModel().getArtefact(artefact, this));
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorClassifier#getPsmType()
    */
   public String getPsmType() {
      return getJavaType();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getExtendedClass()
    */
   public JavaModelClass getExtendedClass() {
      if ( getSuperClasses().size() == 1) {
         return (JavaModelClass) getSuperClasses().get(0);
      }
      else if ( getSuperClasses().size() > 1 ) {
         JavaModelClass superClass = null;
         
         for (Iterator ig = getGeneralizations().iterator(); superClass == null && ig.hasNext();) {
            ModelGeneralization	generalization = (ModelGeneralization) ig.next();
            
            if ( generalization.hasStereotype(ModelStereotype.EXTENDS) ) {
               superClass = (JavaModelClass) generalization.getGeneral();
            }
         }
         return superClass;
      }
      else {
         return null;
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getImplementedInterfaces()
    */
   public List getImplementedInterfaces() {
      // TODO Auto-generated method stub
      return null;
   }
   
   /**
    * Returns all own attributes and all attributes of none <<Extends>> base classes.
    */
   public List getImplementedAttributes() {
      if ( attributes == null ) {
         attributes = new ArrayList();
         
         if ( getGeneralizations().size() > 1 ) {
            List allExtendedClasses = getAllExtendedClasses();

            // Add attributes from none extended bases classes
            iterateNoneExtendedBaseClasses(this, allExtendedClasses, new ModelIterator.Action() {

	               public void process(ModelElement modelElement) {
	                  ModelClass modelClass = (ModelClass) modelElement;

	                  
	                  addNoneExistierungAttributes(attributes, modelClass.getAttributes(false));
	               }
               });
            
            // Add own attributes
            addNoneExistierungAttributes(attributes, super.getAttributes());
         }
         else {
            attributes = super.getAttributes();
         }
      }
      return attributes;
   }

   private static void addNoneExistierungAttributes(List attributes, List attributesToAdd) {
      for (Iterator iaa = attributesToAdd.iterator(); iaa.hasNext();) {
         ModelAttribute attributeToAdd = (ModelAttribute) iaa.next();
         boolean alreadyExisting = false;
         
         for (Iterator ia = attributes.iterator(); ia.hasNext();) {
            ModelAttribute attribute = (ModelAttribute) ia.next();
            
            if ( attribute.getName().equals(attributeToAdd.getName())) {
               if ( attribute.getDataType() != null && attribute.getDataType().equals(attributeToAdd.getDataType()) == false ) {
                  logger.warn(attribute.getQualifiedName()+" has different type than "+attributeToAdd.getQualifiedName()+" in derived class");
               }
               alreadyExisting = true;
            }
         }
         
         if ( alreadyExisting == false ) {
            attributes.add(attributeToAdd);
         }
      }
   }
   
   private static void iterateNoneExtendedBaseClasses(ModelClass modelClass, List allExtendedClasses, ModelIterator.Action action) {
      // Add attributes from none <<Extends>> generalizations
      for (Iterator ig = modelClass.getGeneralizations().iterator(); ig.hasNext();) {
         ModelGeneralization generalization = (ModelGeneralization) ig.next();
         ModelClass generalClass = generalization.getGeneral();
         
         if (generalization.hasStereotype(ModelStereotype.EXTENDS) == false && allExtendedClasses.contains(generalClass) == false ) {
            action.process(generalClass);
            iterateNoneExtendedBaseClasses(generalClass, allExtendedClasses, action);
         }
      }
   }
   
   /**
    * Returns all own associations and all associations of none <<Extends>> base classes.
    */
   public List getImplementedAssociations() {
      if ( associations == null ) {
         associations = new ArrayList();
         
         if ( getGeneralizations().size() > 1 ) {
            List allExtendedClasses = getAllExtendedClasses();
            
            // Add attributes from none extended bases classes
            iterateNoneExtendedBaseClasses(this, allExtendedClasses, new ModelIterator.Action() {

	               public void process(ModelElement modelElement) {
	                  ModelClass modelClass = (ModelClass) modelElement;
	                  
	                  associations.addAll(modelClass.getAssociations(false));
	               }
               });
            
            // Add own attributes
            associations.addAll(super.getAssociations());
         }
         else {
            associations = super.getAssociations();
         }
      }
      return associations;
   }

   /**
    * Returns all own methods and all methods of none <<Extends>> base classes.
    */
   public List getImplementedMethods() {
      if ( methods == null ) {
         methods = new ArrayList();
         
         if ( getGeneralizations().size() > 1 ) {
            List allExtendedClasses = getAllExtendedClasses();
            
            // Add attributes from none extended bases classes
            iterateNoneExtendedBaseClasses(this, allExtendedClasses, new ModelIterator.Action() {

	               public void process(ModelElement modelElement) {
	                  ModelClass modelClass = (ModelClass) modelElement;
	                  
	                  methods.addAll(modelClass.getMethods(false));
	               }
               });
            
            // Add own attributes
            methods.addAll(super.getMethods());
         }
         else {
            methods = super.getMethods();
         }
      }
      return methods;
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getAllExtendedClasses()
    */
   public List getAllExtendedClasses() {
      List allExtendedClasses = new ArrayList(getAllExtendedClasses(this, new HashSet()));
      
      return allExtendedClasses;
   }
   
   private static Set getAllExtendedClasses(JavaModelClass modelClass, Set extendedClassSet) {
      JavaModelClass extendedClass = modelClass.getExtendedClass();
      
      if ( extendedClass != null && extendedClassSet.add(extendedClass) ) {
         getAllExtendedClasses(extendedClass, extendedClassSet);
      }
      
      return extendedClassSet;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getDeclaredAttributes()
    */
   public List getDeclaredAttributes() {
      return super.getAttributes(false);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getDeclaredAssociations()
    */
   public List getDeclaredAssociations() {
      return super.getAssociations(false);
   }

  /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#getDeclaredMethods()
    */
   public List getDeclaredMethods() {
      return super.getMethods(false);
   }

   public JavaModelClass getJavaSuperClass() {
      return (JavaModelClass) getSuperClass();
   }

   /**
    * Checks whether the given class has an own primary key. That happensc if 
    * it has own pkey attributes or inherited pkey attributes from it's 
    * parent.
    */
   public boolean isOwningAPKey() {
      int keyAttrCount = getKeyAttributes().size();
      boolean hasOwnPKey = keyAttrCount > 1;
      
      for (Iterator is = getSuperClasses().iterator(); is.hasNext();) {
         ModelClass superClass = (ModelClass) is.next();
         int scKeyAttrCount = superClass.getKeyAttributes().size();
         
         if ( scKeyAttrCount > 0  && scKeyAttrCount == keyAttrCount ) {
            hasOwnPKey = false;
         }
      }
      
      return hasOwnPKey;
   }
   
   public boolean isPKeyInheritedFromParent() {
      ModelAssociation parentComposition = getParentComposition();
      
      if ( parentComposition != null ) {
         return Boolean.valueOf(parentComposition.getStereotypeProperty(ModelTaggedValues.DB_PKEY_INHERIT, "false")).booleanValue();
      }
      else {
         return false;
      }
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelClass#hasNoneGenerateableFeatures()
    */
   public boolean hasNoneGenerateableFeatures() {
      boolean derivedFeatures = false;
      
      if ( getMethods().size() == 0 ) {
         for (Iterator iattr = getImplementedAttributes().iterator(); derivedFeatures == false && iattr.hasNext();) {
            ModelStructuralFeature feature = (ModelStructuralFeature) iattr.next();

            if (feature.isDerived()) {
               derivedFeatures = true;
            }
         }

         for (Iterator iassoc = getImplementedAssociations().iterator(); derivedFeatures == false && iassoc.hasNext();) {
            ModelStructuralFeature feature = (ModelStructuralFeature) iassoc.next();

            if (feature.isDerived()) {
               derivedFeatures = true;
            }
         }
      }
      
      return derivedFeatures || getMethods().size() > 0;
   }
 
   public boolean isDelegationInterfaceNeeded() {
      Collection abstractBaseClassesWithNoneGenerateableFeatures = getAbstractBaseClassesWithNoneGenerateableFeatures();
      
      return hasNoneGenerateableFeatures() || abstractBaseClassesWithNoneGenerateableFeatures.size() > 0;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#hasBoundProperties()
    */
   public boolean hasBoundProperties() {
      GeneratorModel genModel = getGeneratorModel();
      boolean propertyChangeSupport = Boolean.valueOf(genModel.getArtefact().getProperties().getProperty("PropertyChangeSupport", "false")).booleanValue();

      if ( propertyChangeSupport )
         return propertyChangeSupport;
      
      return propertyHasStereotype(ModelStereotype.BOUND, getAttributes()) ||
             propertyHasStereotype(ModelStereotype.BOUND, getAssociations());
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#hasConstrainedProperties()
    */
   public boolean hasConstrainedProperties() {
      return propertyHasStereotype(ModelStereotype.CONSTRAINED, getAttributes()) ||
             propertyHasStereotype(ModelStereotype.CONSTRAINED, getAssociations());
   }

   private boolean propertyHasStereotype(String stereotype, List features) {
      boolean hasConstrainedProperty = false;
      
      for (Iterator im = features.iterator(); im.hasNext() && !hasConstrainedProperty;) {
         ModelStructuralFeature feature = (ModelStructuralFeature) im.next();
         
         if ( feature.hasStereotype(stereotype)) {
            hasConstrainedProperty = true;
         }
      }
      return hasConstrainedProperty;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#hasInitializer()
    */
   public ModelMethod getInitializerMethod() {
      boolean hasInitializer = false;
      
      for (Iterator im = getMethods().iterator(); im.hasNext() && !hasInitializer;) {
         ModelMethod method = (ModelMethod) im.next();
         
         if ( method.hasStereotype(ModelStereotype.INITIALIZER)) {
            return method;
         }
      }
      return null;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#superClassHasBoundProperties()
    */
   public boolean superClassHasBoundProperties() {
      if ( getJavaSuperClass() != null )
         return getJavaSuperClass().hasBoundProperties() || getJavaSuperClass().superClassHasBoundProperties();
      else
         return false;
   }
   
   public String getUpperCaseIdentifier() {
      return StringUtil.toUpperCaseIdentifier(getName());
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClass#getReferencedTypes()
    */
   public List getImplementationReferencedTypes() {
      if ( implementationReferencedTypes == null ) {
         final Set referencedTypeSet = new HashSet();
         
         for (Iterator iter = getImplementedAttributes().iterator(); iter.hasNext();) {
            ModelAttribute attribute = (ModelAttribute) iter.next();

            if ( attribute.getModelClassifier() != null ) {
               addReferencedType(referencedTypeSet, attribute.getModelClassifier(), getModelClass());
            }
         }

         for (Iterator iter = getImplementedAssociations().iterator(); iter.hasNext();) {
            ModelAssociation association = (ModelAssociation) iter.next();
            if (association.isNavigatableToTarget()) {
               ModelClassBase modelClass = association.getTarget();

               addReferencedType(referencedTypeSet, modelClass, getModelClass());
            }
         }

         for (Iterator iter = getImplementedMethods().iterator(); iter.hasNext();) {
            ModelMethod method = (ModelMethod) iter.next();

            for (Iterator ip = method.getExceptions().iterator(); ip.hasNext();) {
               ModelClass exceptionClass = (ModelClass) ip.next();
               
               addReferencedType(referencedTypeSet, exceptionClass, getModelClass());
            }

            for (Iterator ip = method.getParameters().iterator(); ip.hasNext();) {
               addReferencedType(referencedTypeSet, ((ModelParameter) ip.next()).getType(), getModelClass());
            }

            addReferencedType(referencedTypeSet, method.getReturnTypeBase(), getModelClass());
         }
         
         implementationReferencedTypes = new ArrayList(referencedTypeSet);
         Collections.sort(implementationReferencedTypes); 
      }
      return implementationReferencedTypes;
   }

}
