/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.set.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.umlmda.generator.profile.UmpPackage;

import org.umlmda.generator.profile.impl.UmpPackageImpl;

import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;
import org.umlmda.generator.set.UmsFactory;
import org.umlmda.generator.set.UmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmsPackageImpl extends EPackageImpl implements UmsPackage
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String copyright               = "www.umlmda.org";

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             generationSetEClass     = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             generationProfileEClass = null;

   /**
    * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
    * EPackage.Registry} by the package package URI value.
    * <p>
    * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see org.umlmda.generator.set.UmsPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private UmsPackageImpl() {
      super(eNS_URI, UmsFactory.eINSTANCE);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private static boolean isInited = false;

   /**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends. Simple
    * dependencies are satisfied by calling this method on all dependent packages before doing anything else. This method drives
    * initialization for interdependent packages directly, in parallel with this package, itself.
    * <p>
    * Of this package and its interdependencies, all packages which have not yet been registered by their URI values are first
    * created and registered. The packages are then initialized in two steps: meta-model objects for all of the packages are
    * created before any are initialized, since one package's meta-model objects may refer to those of another.
    * <p>
    * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static UmsPackage init() {
      if ( isInited )
         return (UmsPackage) EPackage.Registry.INSTANCE.getEPackage(UmsPackage.eNS_URI);

      // Obtain or create and register package
      UmsPackageImpl theUmsPackage = (UmsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UmsPackageImpl ? EPackage.Registry.INSTANCE
            .getEPackage(eNS_URI)
            : new UmsPackageImpl());

      isInited = true;

      // Obtain or create and register interdependencies
      UmpPackageImpl theUmpPackage = (UmpPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UmpPackage.eNS_URI) instanceof UmpPackageImpl ? EPackage.Registry.INSTANCE
            .getEPackage(UmpPackage.eNS_URI)
            : UmpPackageImpl.eINSTANCE);

      // Create package meta-data objects
      theUmsPackage.createPackageContents();
      theUmpPackage.createPackageContents();

      // Initialize created meta-data
      theUmsPackage.initializePackageContents();
      theUmpPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theUmsPackage.freeze();

      return theUmsPackage;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getGenerationSet() {
      return generationSetEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationSet_Name() {
      return (EAttribute) generationSetEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationSet_Description() {
      return (EAttribute) generationSetEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationSet_Exclusive() {
      return (EAttribute) generationSetEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationSet_Target() {
      return (EAttribute) generationSetEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationSet_Model() {
      return (EAttribute) generationSetEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getGenerationSet_GenerationProfile() {
      return (EReference) generationSetEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getGenerationSet_ReferencedSets() {
      return (EReference) generationSetEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getGenerationProfile() {
      return generationProfileEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationProfile_Destination() {
      return (EAttribute) generationProfileEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationProfile_PackagePrefix() {
      return (EAttribute) generationProfileEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getGenerationProfile_Active() {
      return (EAttribute) generationProfileEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getGenerationProfile_Profile() {
      return (EReference) generationProfileEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getGenerationProfile_Properties() {
      return (EReference) generationProfileEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public UmsFactory getUmsFactory() {
      return (UmsFactory) getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private boolean isCreated = false;

   /**
    * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void createPackageContents() {
      if ( isCreated )
         return;
      isCreated = true;

      // Create classes and their features
      generationSetEClass = createEClass(GENERATION_SET);
      createEAttribute(generationSetEClass, GENERATION_SET__NAME);
      createEAttribute(generationSetEClass, GENERATION_SET__DESCRIPTION);
      createEAttribute(generationSetEClass, GENERATION_SET__EXCLUSIVE);
      createEAttribute(generationSetEClass, GENERATION_SET__TARGET);
      createEAttribute(generationSetEClass, GENERATION_SET__MODEL);
      createEReference(generationSetEClass, GENERATION_SET__GENERATION_PROFILE);
      createEReference(generationSetEClass, GENERATION_SET__REFERENCED_SETS);

      generationProfileEClass = createEClass(GENERATION_PROFILE);
      createEAttribute(generationProfileEClass, GENERATION_PROFILE__DESTINATION);
      createEAttribute(generationProfileEClass, GENERATION_PROFILE__PACKAGE_PREFIX);
      createEAttribute(generationProfileEClass, GENERATION_PROFILE__ACTIVE);
      createEReference(generationProfileEClass, GENERATION_PROFILE__PROFILE);
      createEReference(generationProfileEClass, GENERATION_PROFILE__PROPERTIES);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private boolean isInitialized = false;

   /**
    * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any invocation
    * but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void initializePackageContents() {
      if ( isInitialized )
         return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      UmpPackageImpl theUmpPackage = (UmpPackageImpl) EPackage.Registry.INSTANCE.getEPackage(UmpPackage.eNS_URI);

      // Add supertypes to classes

      // Initialize classes and features; add operations and parameters
      initEClass(generationSetEClass, GenerationSet.class, "GenerationSet", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getGenerationSet_Name(), ecorePackage.getEString(), "name", null, 0, 1, GenerationSet.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getGenerationSet_Description(), ecorePackage.getEString(), "description", null, 0, 1, GenerationSet.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getGenerationSet_Exclusive(), ecorePackage.getEBoolean(), "exclusive", "true", 0, 1, GenerationSet.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getGenerationSet_Target(), ecorePackage.getEString(), "target", null, 0, 1, GenerationSet.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getGenerationSet_Model(), ecorePackage.getEString(), "model", null, 0, 1, GenerationSet.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getGenerationSet_GenerationProfile(), this.getGenerationProfile(), null, "GenerationProfile", null, 1, -1,
            GenerationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getGenerationSet_ReferencedSets(), this.getGenerationSet(), null, "referencedSets", null, 0, -1,
            GenerationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(generationProfileEClass, GenerationProfile.class, "GenerationProfile", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getGenerationProfile_Destination(), ecorePackage.getEString(), "destination", null, 0, 1,
            GenerationProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
            IS_ORDERED);
      initEAttribute(getGenerationProfile_PackagePrefix(), ecorePackage.getEString(), "packagePrefix", null, 0, 1,
            GenerationProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
            IS_ORDERED);
      initEAttribute(getGenerationProfile_Active(), ecorePackage.getEBoolean(), "active", "true", 0, 1, GenerationProfile.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getGenerationProfile_Profile(), theUmpPackage.getProfile(), null, "profile", null, 1, 1,
            GenerationProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
            !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getGenerationProfile_Properties(), theUmpPackage.getProperty(), null, "properties", null, 0, -1,
            GenerationProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
            !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} // UmsPackageImpl
