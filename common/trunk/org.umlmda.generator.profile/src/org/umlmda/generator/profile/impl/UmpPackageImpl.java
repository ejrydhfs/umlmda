/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.impl;

import java.util.Properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.umlmda.generator.profile.AbstractMappingContainer;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.MetaModelElement;
import org.umlmda.generator.profile.MetaModelElementType;
import org.umlmda.generator.profile.NamespaceUsage;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.profile.Property;
import org.umlmda.generator.profile.Stereotype;
import org.umlmda.generator.profile.UmpFactory;
import org.umlmda.generator.profile.UmpPackage;
import org.umlmda.generator.profile.WriterType;
import org.umlmda.generator.set.UmsPackage;
import org.umlmda.generator.set.impl.UmsPackageImpl;

import org.umlmda.model.uml.ModelElementBase;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmpPackageImpl extends EPackageImpl implements UmpPackage
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String copyright                      = "www.umlmda.org";

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             profileEClass                  = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             stereotypeEClass               = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             artefactEClass                 = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             mappingEClass                  = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             propertyEClass                 = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             metaModelElementEClass         = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass             abstractMappingContainerEClass = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EEnum              writerTypeEEnum                = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EEnum              namespaceUsageEEnum            = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EEnum              metaModelElementTypeEEnum      = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EDataType          propertiesEDataType            = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private EDataType          modelElementEDataType          = null;

   /**
    * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
    * EPackage.Registry} by the package package URI value.
    * <p>
    * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see org.umlmda.generator.profile.UmpPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private UmpPackageImpl() {
      super(eNS_URI, UmpFactory.eINSTANCE);
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
   public static UmpPackage init() {
      if ( isInited )
         return (UmpPackage) EPackage.Registry.INSTANCE.getEPackage(UmpPackage.eNS_URI);

      // Obtain or create and register package
      UmpPackageImpl theUmpPackage = (UmpPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UmpPackageImpl ? EPackage.Registry.INSTANCE
            .getEPackage(eNS_URI)
            : new UmpPackageImpl());

      isInited = true;

      // Obtain or create and register interdependencies
      UmsPackageImpl theUmsPackage = (UmsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UmsPackage.eNS_URI) instanceof UmsPackageImpl ? EPackage.Registry.INSTANCE
            .getEPackage(UmsPackage.eNS_URI)
            : UmsPackageImpl.eINSTANCE);

      // Create package meta-data objects
      theUmpPackage.createPackageContents();
      theUmsPackage.createPackageContents();

      // Initialize created meta-data
      theUmpPackage.initializePackageContents();
      theUmsPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theUmpPackage.freeze();

      return theUmpPackage;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getProfile() {
      return profileEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getProfile_Name() {
      return (EAttribute) profileEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getProfile_Description() {
      return (EAttribute) profileEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getProfile_AdapterFactory() {
      return (EAttribute) profileEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getProfile_ValidatorFactory() {
      return (EAttribute) profileEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getProfile_Stereotypes() {
      return (EReference) profileEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getProfile_Artefacts() {
      return (EReference) profileEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getProfile_DefaultProperties() {
      return (EReference) profileEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getProfile_BasedOn() {
      return (EReference) profileEClass.getEStructuralFeatures().get(7);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getProfile_MetaModelElements() {
      return (EReference) profileEClass.getEStructuralFeatures().get(8);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getStereotype() {
      return stereotypeEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getStereotype_Name() {
      return (EAttribute) stereotypeEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getArtefact() {
      return artefactEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Name() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Alias() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Description() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Filename() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_FileExtension() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(4);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Prefix() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(5);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Postfix() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(6);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_UseNamespace() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(7);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_NamespacePrefix() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(8);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_NamespacePostfix() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(9);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Replacement() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(10);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_ReplacementPattern() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(11);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Type() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(12);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Writer() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(13);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_Properties() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(14);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getArtefact_GenerationStrategy() {
      return (EAttribute) artefactEClass.getEStructuralFeatures().get(15);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getArtefact_DefaultProperties() {
      return (EReference) artefactEClass.getEStructuralFeatures().get(16);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getMapping() {
      return mappingEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getMapping_Artefact() {
      return (EReference) mappingEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getMapping_SubMappings() {
      return (EReference) mappingEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getMapping_MappingProperties() {
      return (EReference) mappingEClass.getEStructuralFeatures().get(3);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getMapping_Properties() {
      return (EAttribute) mappingEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getProperty() {
      return propertyEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getProperty_Name() {
      return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getProperty_Value() {
      return (EAttribute) propertyEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getMetaModelElement() {
      return metaModelElementEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EAttribute getMetaModelElement_Type() {
      return (EAttribute) metaModelElementEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getAbstractMappingContainer() {
      return abstractMappingContainerEClass;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getAbstractMappingContainer_Mappings() {
      return (EReference) abstractMappingContainerEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EEnum getWriterType() {
      return writerTypeEEnum;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EEnum getNamespaceUsage() {
      return namespaceUsageEEnum;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EEnum getMetaModelElementType() {
      return metaModelElementTypeEEnum;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EDataType getProperties() {
      return propertiesEDataType;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EDataType getModelElement() {
      return modelElementEDataType;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public UmpFactory getUmpFactory() {
      return (UmpFactory) getEFactoryInstance();
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
      profileEClass = createEClass(PROFILE);
      createEAttribute(profileEClass, PROFILE__NAME);
      createEAttribute(profileEClass, PROFILE__DESCRIPTION);
      createEAttribute(profileEClass, PROFILE__ADAPTER_FACTORY);
      createEAttribute(profileEClass, PROFILE__VALIDATOR_FACTORY);
      createEReference(profileEClass, PROFILE__STEREOTYPES);
      createEReference(profileEClass, PROFILE__ARTEFACTS);
      createEReference(profileEClass, PROFILE__DEFAULT_PROPERTIES);
      createEReference(profileEClass, PROFILE__BASED_ON);
      createEReference(profileEClass, PROFILE__META_MODEL_ELEMENTS);

      stereotypeEClass = createEClass(STEREOTYPE);
      createEAttribute(stereotypeEClass, STEREOTYPE__NAME);

      artefactEClass = createEClass(ARTEFACT);
      createEAttribute(artefactEClass, ARTEFACT__NAME);
      createEAttribute(artefactEClass, ARTEFACT__ALIAS);
      createEAttribute(artefactEClass, ARTEFACT__DESCRIPTION);
      createEAttribute(artefactEClass, ARTEFACT__FILENAME);
      createEAttribute(artefactEClass, ARTEFACT__FILE_EXTENSION);
      createEAttribute(artefactEClass, ARTEFACT__PREFIX);
      createEAttribute(artefactEClass, ARTEFACT__POSTFIX);
      createEAttribute(artefactEClass, ARTEFACT__USE_NAMESPACE);
      createEAttribute(artefactEClass, ARTEFACT__NAMESPACE_PREFIX);
      createEAttribute(artefactEClass, ARTEFACT__NAMESPACE_POSTFIX);
      createEAttribute(artefactEClass, ARTEFACT__REPLACEMENT);
      createEAttribute(artefactEClass, ARTEFACT__REPLACEMENT_PATTERN);
      createEAttribute(artefactEClass, ARTEFACT__TYPE);
      createEAttribute(artefactEClass, ARTEFACT__WRITER);
      createEAttribute(artefactEClass, ARTEFACT__PROPERTIES);
      createEAttribute(artefactEClass, ARTEFACT__GENERATION_STRATEGY);
      createEReference(artefactEClass, ARTEFACT__DEFAULT_PROPERTIES);

      mappingEClass = createEClass(MAPPING);
      createEAttribute(mappingEClass, MAPPING__PROPERTIES);
      createEReference(mappingEClass, MAPPING__ARTEFACT);
      createEReference(mappingEClass, MAPPING__SUB_MAPPINGS);
      createEReference(mappingEClass, MAPPING__MAPPING_PROPERTIES);

      propertyEClass = createEClass(PROPERTY);
      createEAttribute(propertyEClass, PROPERTY__NAME);
      createEAttribute(propertyEClass, PROPERTY__VALUE);

      metaModelElementEClass = createEClass(META_MODEL_ELEMENT);
      createEAttribute(metaModelElementEClass, META_MODEL_ELEMENT__TYPE);

      abstractMappingContainerEClass = createEClass(ABSTRACT_MAPPING_CONTAINER);
      createEReference(abstractMappingContainerEClass, ABSTRACT_MAPPING_CONTAINER__MAPPINGS);

      // Create enums
      writerTypeEEnum = createEEnum(WRITER_TYPE);
      namespaceUsageEEnum = createEEnum(NAMESPACE_USAGE);
      metaModelElementTypeEEnum = createEEnum(META_MODEL_ELEMENT_TYPE);

      // Create data types
      propertiesEDataType = createEDataType(PROPERTIES);
      modelElementEDataType = createEDataType(MODEL_ELEMENT);
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

      // Add supertypes to classes
      stereotypeEClass.getESuperTypes().add(this.getAbstractMappingContainer());
      metaModelElementEClass.getESuperTypes().add(this.getAbstractMappingContainer());

      // Initialize classes and features; add operations and parameters
      initEClass(profileEClass, Profile.class, "Profile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getProfile_Name(), ecorePackage.getEString(), "name", null, 0, 1, Profile.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getProfile_Description(), ecorePackage.getEString(), "description", null, 0, 1, Profile.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getProfile_AdapterFactory(), ecorePackage.getEString(), "adapterFactory", null, 0, 1, Profile.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getProfile_ValidatorFactory(), ecorePackage.getEString(), "validatorFactory", null, 0, 1, Profile.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getProfile_Stereotypes(), this.getStereotype(), null, "stereotypes", null, 0, -1, Profile.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);
      initEReference(getProfile_Artefacts(), this.getArtefact(), null, "artefacts", null, 1, -1, Profile.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getProfile_DefaultProperties(), this.getProperty(), null, "defaultProperties", null, 0, -1, Profile.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);
      initEReference(getProfile_BasedOn(), this.getProfile(), null, "basedOn", null, 0, -1, Profile.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getProfile_MetaModelElements(), this.getMetaModelElement(), null, "metaModelElements", null, 0, -1,
            Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(stereotypeEClass, Stereotype.class, "Stereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getStereotype_Name(), ecorePackage.getEString(), "name", null, 0, 1, Stereotype.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(artefactEClass, Artefact.class, "Artefact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getArtefact_Name(), ecorePackage.getEString(), "name", null, 0, 1, Artefact.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, Artefact.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Description(), ecorePackage.getEString(), "description", null, 0, 1, Artefact.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Filename(), ecorePackage.getEString(), "filename", null, 0, 1, Artefact.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_FileExtension(), ecorePackage.getEString(), "fileExtension", null, 0, 1, Artefact.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, Artefact.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Postfix(), ecorePackage.getEString(), "postfix", null, 0, 1, Artefact.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_UseNamespace(), this.getNamespaceUsage(), "useNamespace", "true", 0, 1, Artefact.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_NamespacePrefix(), ecorePackage.getEString(), "namespacePrefix", null, 0, 1, Artefact.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_NamespacePostfix(), ecorePackage.getEString(), "namespacePostfix", null, 0, 1, Artefact.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Replacement(), ecorePackage.getEString(), "replacement", null, 0, 1, Artefact.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_ReplacementPattern(), ecorePackage.getEString(), "replacementPattern", null, 0, 1,
            Artefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
            IS_ORDERED);
      initEAttribute(getArtefact_Type(), this.getWriterType(), "type", "Jostraca", 0, 1, Artefact.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Writer(), ecorePackage.getEString(), "writer", null, 0, 1, Artefact.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_Properties(), this.getProperties(), "properties", null, 0, 1, Artefact.class, IS_TRANSIENT,
            IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getArtefact_GenerationStrategy(), ecorePackage.getEString(), "generationStrategy", null, 0, 1,
            Artefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
            IS_ORDERED);
      initEReference(getArtefact_DefaultProperties(), this.getProperty(), null, "defaultProperties", null, 0, -1, Artefact.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);

      initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getMapping_Properties(), this.getProperties(), "properties", null, 0, 1, Mapping.class, IS_TRANSIENT,
            IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getMapping_Artefact(), this.getArtefact(), null, "artefact", null, 1, 1, Mapping.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getMapping_SubMappings(), this.getAbstractMappingContainer(), null, "subMappings", null, 0, -1,
            Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getMapping_MappingProperties(), this.getProperty(), null, "mappingProperties", null, 0, -1, Mapping.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);

      initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, Property.class, !IS_TRANSIENT,
            !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(metaModelElementEClass, MetaModelElement.class, "MetaModelElement", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getMetaModelElement_Type(), this.getMetaModelElementType(), "type", null, 0, 1, MetaModelElement.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      EOperation op = addEOperation(metaModelElementEClass, ecorePackage.getEBoolean(), "match");
      addEParameter(op, this.getModelElement(), "modelElement");

      initEClass(abstractMappingContainerEClass, AbstractMappingContainer.class, "AbstractMappingContainer", IS_ABSTRACT,
            !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getAbstractMappingContainer_Mappings(), this.getMapping(), null, "mappings", null, 0, -1,
            AbstractMappingContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
            !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Initialize enums and add enum literals
      initEEnum(writerTypeEEnum, WriterType.class, "WriterType");
      addEEnumLiteral(writerTypeEEnum, WriterType.JOSTRACA_LITERAL);
      addEEnumLiteral(writerTypeEEnum, WriterType.JET_LITERAL);
      addEEnumLiteral(writerTypeEEnum, WriterType.VELOCITY_LITERAL);
      addEEnumLiteral(writerTypeEEnum, WriterType.FREE_MARKER_LITERAL);
      addEEnumLiteral(writerTypeEEnum, WriterType.NONE_LITERAL);
      addEEnumLiteral(writerTypeEEnum, WriterType.EXPAND_LITERAL);

      initEEnum(namespaceUsageEEnum, NamespaceUsage.class, "NamespaceUsage");
      addEEnumLiteral(namespaceUsageEEnum, NamespaceUsage.TRUE_LITERAL);
      addEEnumLiteral(namespaceUsageEEnum, NamespaceUsage.FULL_QUALIFIED_LITERAL);
      addEEnumLiteral(namespaceUsageEEnum, NamespaceUsage.NAME_ONLY_LITERAL);
      addEEnumLiteral(namespaceUsageEEnum, NamespaceUsage.FALSE_LITERAL);

      initEEnum(metaModelElementTypeEEnum, MetaModelElementType.class, "MetaModelElementType");
      addEEnumLiteral(metaModelElementTypeEEnum, MetaModelElementType.MODEL_LITERAL);
      addEEnumLiteral(metaModelElementTypeEEnum, MetaModelElementType.PACKAGE_LITERAL);
      addEEnumLiteral(metaModelElementTypeEEnum, MetaModelElementType.CLASS_LITERAL);

      // Initialize data types
      initEDataType(propertiesEDataType, Properties.class, "Properties", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
      initEDataType(modelElementEDataType, ModelElementBase.class, "ModelElement", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

      // Create resource
      createResource(eNS_URI);
   }

} // UmpPackageImpl
