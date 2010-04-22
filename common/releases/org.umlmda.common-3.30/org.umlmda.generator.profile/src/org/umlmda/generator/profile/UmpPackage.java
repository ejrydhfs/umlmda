/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmpPackage.java,v 1.12 2007/01/03 21:07:49 moroff Exp $
 */
package org.umlmda.generator.profile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.profile.UmpFactory
 * @generated
 */
public interface UmpPackage extends EPackage{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "profile";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "http:///org/umlmda/generator/profile.ecore";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "org.umlmda.generator.profile";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   UmpPackage eINSTANCE = org.umlmda.generator.profile.impl.UmpPackageImpl.init();

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.impl.ProfileImpl <em>Profile</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.impl.ProfileImpl
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getProfile()
    * @generated
    */
   int PROFILE = 0;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__NAME = 0;

   /**
    * The feature id for the '<em><b>Description</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__DESCRIPTION = 1;

   /**
    * The feature id for the '<em><b>Adapter Factory</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__ADAPTER_FACTORY = 2;

   /**
    * The feature id for the '<em><b>Validator Factory</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__VALIDATOR_FACTORY = 3;

   /**
    * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__STEREOTYPES = 4;

   /**
    * The feature id for the '<em><b>Artefacts</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__ARTEFACTS = 5;

   /**
    * The feature id for the '<em><b>Default Properties</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__DEFAULT_PROPERTIES = 6;

   /**
    * The feature id for the '<em><b>Based On</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__BASED_ON = 7;

   /**
    * The feature id for the '<em><b>Meta Model Elements</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE__META_MODEL_ELEMENTS = 8;

   /**
    * The number of structural features of the the '<em>Profile</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROFILE_FEATURE_COUNT = 9;

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.impl.AbstractMappingContainerImpl <em>Abstract Mapping Container</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.impl.AbstractMappingContainerImpl
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getAbstractMappingContainer()
    * @generated
    */
   int ABSTRACT_MAPPING_CONTAINER = 6;

   /**
    * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ABSTRACT_MAPPING_CONTAINER__MAPPINGS = 0;

   /**
    * The number of structural features of the the '<em>Abstract Mapping Container</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ABSTRACT_MAPPING_CONTAINER_FEATURE_COUNT = 1;

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.impl.StereotypeImpl <em>Stereotype</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.impl.StereotypeImpl
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getStereotype()
    * @generated
    */
   int STEREOTYPE = 1;

   /**
    * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STEREOTYPE__MAPPINGS = ABSTRACT_MAPPING_CONTAINER__MAPPINGS;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STEREOTYPE__NAME = ABSTRACT_MAPPING_CONTAINER_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the the '<em>Stereotype</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STEREOTYPE_FEATURE_COUNT = ABSTRACT_MAPPING_CONTAINER_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.impl.ArtefactImpl <em>Artefact</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.impl.ArtefactImpl
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getArtefact()
    * @generated
    */
   int ARTEFACT = 2;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__NAME = 0;

   /**
    * The feature id for the '<em><b>Alias</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__ALIAS = 1;

   /**
    * The feature id for the '<em><b>Description</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__DESCRIPTION = 2;

   /**
    * The feature id for the '<em><b>Filename</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__FILENAME = 3;

   /**
    * The feature id for the '<em><b>File Extension</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__FILE_EXTENSION = 4;

   /**
    * The feature id for the '<em><b>Prefix</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__PREFIX = 5;

   /**
    * The feature id for the '<em><b>Postfix</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__POSTFIX = 6;

   /**
    * The feature id for the '<em><b>Use Namespace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__USE_NAMESPACE = 7;

   /**
    * The feature id for the '<em><b>Namespace Prefix</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__NAMESPACE_PREFIX = 8;

   /**
    * The feature id for the '<em><b>Namespace Postfix</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__NAMESPACE_POSTFIX = 9;

   /**
    * The feature id for the '<em><b>Replacement</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__REPLACEMENT = 10;

   /**
    * The feature id for the '<em><b>Replacement Pattern</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__REPLACEMENT_PATTERN = 11;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__TYPE = 12;

   /**
    * The feature id for the '<em><b>Writer</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__WRITER = 13;

   /**
    * The feature id for the '<em><b>Properties</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__PROPERTIES = 14;

   /**
    * The feature id for the '<em><b>Generation Strategy</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__GENERATION_STRATEGY = 15;

   /**
    * The feature id for the '<em><b>Default Properties</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT__DEFAULT_PROPERTIES = 16;

   /**
    * The number of structural features of the the '<em>Artefact</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int ARTEFACT_FEATURE_COUNT = 17;

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.impl.MappingImpl <em>Mapping</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.impl.MappingImpl
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getMapping()
    * @generated
    */
   int MAPPING = 3;

   /**
    * The feature id for the '<em><b>Properties</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING__PROPERTIES = 0;

   /**
    * The feature id for the '<em><b>Artefact</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING__ARTEFACT = 1;

   /**
    * The feature id for the '<em><b>Sub Mappings</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING__SUB_MAPPINGS = 2;

   /**
    * The feature id for the '<em><b>Mapping Properties</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING__MAPPING_PROPERTIES = 3;

   /**
    * The number of structural features of the the '<em>Mapping</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING_FEATURE_COUNT = 4;

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.impl.PropertyImpl <em>Property</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.impl.PropertyImpl
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getProperty()
    * @generated
    */
   int PROPERTY = 4;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROPERTY__NAME = 0;

   /**
    * The feature id for the '<em><b>Value</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROPERTY__VALUE = 1;

   /**
    * The number of structural features of the the '<em>Property</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int PROPERTY_FEATURE_COUNT = 2;

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.impl.MetaModelElementImpl <em>Meta Model Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.impl.MetaModelElementImpl
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getMetaModelElement()
    * @generated
    */
   int META_MODEL_ELEMENT = 5;

   /**
    * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int META_MODEL_ELEMENT__MAPPINGS = ABSTRACT_MAPPING_CONTAINER__MAPPINGS;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int META_MODEL_ELEMENT__TYPE = ABSTRACT_MAPPING_CONTAINER_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the the '<em>Meta Model Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int META_MODEL_ELEMENT_FEATURE_COUNT = ABSTRACT_MAPPING_CONTAINER_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.WriterType <em>Writer Type</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.WriterType
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getWriterType()
    * @generated
    */
   int WRITER_TYPE = 7;


   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.NamespaceUsage <em>Namespace Usage</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.NamespaceUsage
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getNamespaceUsage()
    * @generated
    */
   int NAMESPACE_USAGE = 8;


   /**
    * The meta object id for the '{@link org.umlmda.generator.profile.MetaModelElementType <em>Meta Model Element Type</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.profile.MetaModelElementType
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getMetaModelElementType()
    * @generated
    */
   int META_MODEL_ELEMENT_TYPE = 9;

   /**
    * The meta object id for the '<em>Properties</em>' data type.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see java.util.Properties
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getProperties()
    * @generated
    */
   int PROPERTIES = 10;


   /**
    * The meta object id for the '<em>Model Element</em>' data type.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.model.uml.ModelElementBase
    * @see org.umlmda.generator.profile.impl.UmpPackageImpl#getModelElement()
    * @generated
    */
   int MODEL_ELEMENT = 11;


   /**
    * Returns the meta object for class '{@link org.umlmda.generator.profile.Profile <em>Profile</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Profile</em>'.
    * @see org.umlmda.generator.profile.Profile
    * @generated
    */
   EClass getProfile();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Profile#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see org.umlmda.generator.profile.Profile#getName()
    * @see #getProfile()
    * @generated
    */
   EAttribute getProfile_Name();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Profile#getDescription <em>Description</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Description</em>'.
    * @see org.umlmda.generator.profile.Profile#getDescription()
    * @see #getProfile()
    * @generated
    */
   EAttribute getProfile_Description();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Profile#getAdapterFactory <em>Adapter Factory</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Adapter Factory</em>'.
    * @see org.umlmda.generator.profile.Profile#getAdapterFactory()
    * @see #getProfile()
    * @generated
    */
   EAttribute getProfile_AdapterFactory();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Profile#getValidatorFactory <em>Validator Factory</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Validator Factory</em>'.
    * @see org.umlmda.generator.profile.Profile#getValidatorFactory()
    * @see #getProfile()
    * @generated
    */
   EAttribute getProfile_ValidatorFactory();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.Profile#getStereotypes <em>Stereotypes</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Stereotypes</em>'.
    * @see org.umlmda.generator.profile.Profile#getStereotypes()
    * @see #getProfile()
    * @generated
    */
   EReference getProfile_Stereotypes();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.Profile#getArtefacts <em>Artefacts</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Artefacts</em>'.
    * @see org.umlmda.generator.profile.Profile#getArtefacts()
    * @see #getProfile()
    * @generated
    */
   EReference getProfile_Artefacts();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.Profile#getDefaultProperties <em>Default Properties</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Default Properties</em>'.
    * @see org.umlmda.generator.profile.Profile#getDefaultProperties()
    * @see #getProfile()
    * @generated
    */
   EReference getProfile_DefaultProperties();

   /**
    * Returns the meta object for the reference list '{@link org.umlmda.generator.profile.Profile#getBasedOn <em>Based On</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Based On</em>'.
    * @see org.umlmda.generator.profile.Profile#getBasedOn()
    * @see #getProfile()
    * @generated
    */
   EReference getProfile_BasedOn();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.Profile#getMetaModelElements <em>Meta Model Elements</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Meta Model Elements</em>'.
    * @see org.umlmda.generator.profile.Profile#getMetaModelElements()
    * @see #getProfile()
    * @generated
    */
   EReference getProfile_MetaModelElements();

   /**
    * Returns the meta object for class '{@link org.umlmda.generator.profile.Stereotype <em>Stereotype</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Stereotype</em>'.
    * @see org.umlmda.generator.profile.Stereotype
    * @generated
    */
   EClass getStereotype();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Stereotype#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see org.umlmda.generator.profile.Stereotype#getName()
    * @see #getStereotype()
    * @generated
    */
   EAttribute getStereotype_Name();

   /**
    * Returns the meta object for class '{@link org.umlmda.generator.profile.Artefact <em>Artefact</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Artefact</em>'.
    * @see org.umlmda.generator.profile.Artefact
    * @generated
    */
   EClass getArtefact();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see org.umlmda.generator.profile.Artefact#getName()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Name();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getAlias <em>Alias</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Alias</em>'.
    * @see org.umlmda.generator.profile.Artefact#getAlias()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Alias();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getDescription <em>Description</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Description</em>'.
    * @see org.umlmda.generator.profile.Artefact#getDescription()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Description();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getFilename <em>Filename</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Filename</em>'.
    * @see org.umlmda.generator.profile.Artefact#getFilename()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Filename();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getFileExtension <em>File Extension</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>File Extension</em>'.
    * @see org.umlmda.generator.profile.Artefact#getFileExtension()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_FileExtension();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getPrefix <em>Prefix</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Prefix</em>'.
    * @see org.umlmda.generator.profile.Artefact#getPrefix()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Prefix();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getPostfix <em>Postfix</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Postfix</em>'.
    * @see org.umlmda.generator.profile.Artefact#getPostfix()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Postfix();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getUseNamespace <em>Use Namespace</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Use Namespace</em>'.
    * @see org.umlmda.generator.profile.Artefact#getUseNamespace()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_UseNamespace();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getNamespacePrefix <em>Namespace Prefix</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Namespace Prefix</em>'.
    * @see org.umlmda.generator.profile.Artefact#getNamespacePrefix()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_NamespacePrefix();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getNamespacePostfix <em>Namespace Postfix</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Namespace Postfix</em>'.
    * @see org.umlmda.generator.profile.Artefact#getNamespacePostfix()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_NamespacePostfix();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getReplacement <em>Replacement</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Replacement</em>'.
    * @see org.umlmda.generator.profile.Artefact#getReplacement()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Replacement();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getReplacementPattern <em>Replacement Pattern</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Replacement Pattern</em>'.
    * @see org.umlmda.generator.profile.Artefact#getReplacementPattern()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_ReplacementPattern();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getType <em>Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Type</em>'.
    * @see org.umlmda.generator.profile.Artefact#getType()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Type();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getWriter <em>Writer</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Writer</em>'.
    * @see org.umlmda.generator.profile.Artefact#getWriter()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Writer();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getProperties <em>Properties</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Properties</em>'.
    * @see org.umlmda.generator.profile.Artefact#getProperties()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_Properties();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Artefact#getGenerationStrategy <em>Generation Strategy</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Generation Strategy</em>'.
    * @see org.umlmda.generator.profile.Artefact#getGenerationStrategy()
    * @see #getArtefact()
    * @generated
    */
   EAttribute getArtefact_GenerationStrategy();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.Artefact#getDefaultProperties <em>Default Properties</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Default Properties</em>'.
    * @see org.umlmda.generator.profile.Artefact#getDefaultProperties()
    * @see #getArtefact()
    * @generated
    */
   EReference getArtefact_DefaultProperties();

   /**
    * Returns the meta object for class '{@link org.umlmda.generator.profile.Mapping <em>Mapping</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Mapping</em>'.
    * @see org.umlmda.generator.profile.Mapping
    * @generated
    */
   EClass getMapping();

   /**
    * Returns the meta object for the reference '{@link org.umlmda.generator.profile.Mapping#getArtefact <em>Artefact</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Artefact</em>'.
    * @see org.umlmda.generator.profile.Mapping#getArtefact()
    * @see #getMapping()
    * @generated
    */
   EReference getMapping_Artefact();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.Mapping#getSubMappings <em>Sub Mappings</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Sub Mappings</em>'.
    * @see org.umlmda.generator.profile.Mapping#getSubMappings()
    * @see #getMapping()
    * @generated
    */
   EReference getMapping_SubMappings();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.Mapping#getMappingProperties <em>Mapping Properties</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Mapping Properties</em>'.
    * @see org.umlmda.generator.profile.Mapping#getMappingProperties()
    * @see #getMapping()
    * @generated
    */
   EReference getMapping_MappingProperties();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Mapping#getProperties <em>Properties</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Properties</em>'.
    * @see org.umlmda.generator.profile.Mapping#getProperties()
    * @see #getMapping()
    * @generated
    */
   EAttribute getMapping_Properties();

   /**
    * Returns the meta object for class '{@link org.umlmda.generator.profile.Property <em>Property</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Property</em>'.
    * @see org.umlmda.generator.profile.Property
    * @generated
    */
   EClass getProperty();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Property#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see org.umlmda.generator.profile.Property#getName()
    * @see #getProperty()
    * @generated
    */
   EAttribute getProperty_Name();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.Property#getValue <em>Value</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Value</em>'.
    * @see org.umlmda.generator.profile.Property#getValue()
    * @see #getProperty()
    * @generated
    */
   EAttribute getProperty_Value();

   /**
    * Returns the meta object for class '{@link org.umlmda.generator.profile.MetaModelElement <em>Meta Model Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Meta Model Element</em>'.
    * @see org.umlmda.generator.profile.MetaModelElement
    * @generated
    */
   EClass getMetaModelElement();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.profile.MetaModelElement#getType <em>Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Type</em>'.
    * @see org.umlmda.generator.profile.MetaModelElement#getType()
    * @see #getMetaModelElement()
    * @generated
    */
   EAttribute getMetaModelElement_Type();

   /**
    * Returns the meta object for class '{@link org.umlmda.generator.profile.AbstractMappingContainer <em>Abstract Mapping Container</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Abstract Mapping Container</em>'.
    * @see org.umlmda.generator.profile.AbstractMappingContainer
    * @generated
    */
   EClass getAbstractMappingContainer();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.profile.AbstractMappingContainer#getMappings <em>Mappings</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Mappings</em>'.
    * @see org.umlmda.generator.profile.AbstractMappingContainer#getMappings()
    * @see #getAbstractMappingContainer()
    * @generated
    */
   EReference getAbstractMappingContainer_Mappings();

   /**
    * Returns the meta object for enum '{@link org.umlmda.generator.profile.WriterType <em>Writer Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Writer Type</em>'.
    * @see org.umlmda.generator.profile.WriterType
    * @generated
    */
   EEnum getWriterType();

   /**
    * Returns the meta object for enum '{@link org.umlmda.generator.profile.NamespaceUsage <em>Namespace Usage</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Namespace Usage</em>'.
    * @see org.umlmda.generator.profile.NamespaceUsage
    * @generated
    */
   EEnum getNamespaceUsage();

   /**
    * Returns the meta object for enum '{@link org.umlmda.generator.profile.MetaModelElementType <em>Meta Model Element Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>Meta Model Element Type</em>'.
    * @see org.umlmda.generator.profile.MetaModelElementType
    * @generated
    */
   EEnum getMetaModelElementType();

   /**
    * Returns the meta object for data type '{@link java.util.Properties <em>Properties</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for data type '<em>Properties</em>'.
    * @see java.util.Properties
    * @model instanceClass="java.util.Properties"
    * @generated
    */
   EDataType getProperties();

   /**
    * Returns the meta object for data type '{@link org.umlmda.model.uml.ModelElementBase <em>Model Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for data type '<em>Model Element</em>'.
    * @see org.umlmda.model.uml.ModelElementBase
    * @model instanceClass="org.umlmda.model.uml.ModelElementBase"
    * @generated
    */
   EDataType getModelElement();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   UmpFactory getUmpFactory();

} //UmpPackage
