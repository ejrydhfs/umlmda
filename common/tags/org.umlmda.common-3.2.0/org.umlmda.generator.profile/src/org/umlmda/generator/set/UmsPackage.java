/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmsPackage.java,v 1.6 2006/02/08 12:20:31 moroff Exp $
 */
package org.umlmda.generator.set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.umlmda.generator.set.UmsFactory
 * @generated
 */
public interface UmsPackage extends EPackage{
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
   String eNAME = "set";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "http:///org/umlmda/generator/set.ecore";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "org.umlmda.generator.set";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   UmsPackage eINSTANCE = org.umlmda.generator.set.impl.UmsPackageImpl.init();

   /**
    * The meta object id for the '{@link org.umlmda.generator.set.impl.GenerationSetImpl <em>Generation Set</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.set.impl.GenerationSetImpl
    * @see org.umlmda.generator.set.impl.UmsPackageImpl#getGenerationSet()
    * @generated
    */
   int GENERATION_SET = 0;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET__NAME = 0;

   /**
    * The feature id for the '<em><b>Description</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET__DESCRIPTION = 1;

   /**
    * The feature id for the '<em><b>Exclusive</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET__EXCLUSIVE = 2;

   /**
    * The feature id for the '<em><b>Target</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET__TARGET = 3;

   /**
    * The feature id for the '<em><b>Model</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET__MODEL = 4;

   /**
    * The feature id for the '<em><b>Generation Profile</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET__GENERATION_PROFILE = 5;

   /**
    * The feature id for the '<em><b>Referenced Sets</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET__REFERENCED_SETS = 6;

   /**
    * The number of structural features of the the '<em>Generation Set</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_SET_FEATURE_COUNT = 7;

   /**
    * The meta object id for the '{@link org.umlmda.generator.set.impl.GenerationProfileImpl <em>Generation Profile</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.umlmda.generator.set.impl.GenerationProfileImpl
    * @see org.umlmda.generator.set.impl.UmsPackageImpl#getGenerationProfile()
    * @generated
    */
   int GENERATION_PROFILE = 1;

   /**
    * The feature id for the '<em><b>Destination</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_PROFILE__DESTINATION = 0;

   /**
    * The feature id for the '<em><b>Package Prefix</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_PROFILE__PACKAGE_PREFIX = 1;

   /**
    * The feature id for the '<em><b>Active</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_PROFILE__ACTIVE = 2;

   /**
    * The feature id for the '<em><b>Profile</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_PROFILE__PROFILE = 3;

   /**
    * The feature id for the '<em><b>Properties</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_PROFILE__PROPERTIES = 4;

   /**
    * The number of structural features of the the '<em>Generation Profile</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GENERATION_PROFILE_FEATURE_COUNT = 5;


   /**
    * Returns the meta object for class '{@link org.umlmda.generator.set.GenerationSet <em>Generation Set</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Generation Set</em>'.
    * @see org.umlmda.generator.set.GenerationSet
    * @generated
    */
   EClass getGenerationSet();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationSet#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see org.umlmda.generator.set.GenerationSet#getName()
    * @see #getGenerationSet()
    * @generated
    */
   EAttribute getGenerationSet_Name();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationSet#getDescription <em>Description</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Description</em>'.
    * @see org.umlmda.generator.set.GenerationSet#getDescription()
    * @see #getGenerationSet()
    * @generated
    */
   EAttribute getGenerationSet_Description();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationSet#isExclusive <em>Exclusive</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Exclusive</em>'.
    * @see org.umlmda.generator.set.GenerationSet#isExclusive()
    * @see #getGenerationSet()
    * @generated
    */
   EAttribute getGenerationSet_Exclusive();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationSet#getTarget <em>Target</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Target</em>'.
    * @see org.umlmda.generator.set.GenerationSet#getTarget()
    * @see #getGenerationSet()
    * @generated
    */
   EAttribute getGenerationSet_Target();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationSet#getModel <em>Model</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Model</em>'.
    * @see org.umlmda.generator.set.GenerationSet#getModel()
    * @see #getGenerationSet()
    * @generated
    */
   EAttribute getGenerationSet_Model();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.set.GenerationSet#getGenerationProfile <em>Generation Profile</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Generation Profile</em>'.
    * @see org.umlmda.generator.set.GenerationSet#getGenerationProfile()
    * @see #getGenerationSet()
    * @generated
    */
   EReference getGenerationSet_GenerationProfile();

   /**
    * Returns the meta object for the reference list '{@link org.umlmda.generator.set.GenerationSet#getReferencedSets <em>Referenced Sets</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Referenced Sets</em>'.
    * @see org.umlmda.generator.set.GenerationSet#getReferencedSets()
    * @see #getGenerationSet()
    * @generated
    */
   EReference getGenerationSet_ReferencedSets();

   /**
    * Returns the meta object for class '{@link org.umlmda.generator.set.GenerationProfile <em>Generation Profile</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Generation Profile</em>'.
    * @see org.umlmda.generator.set.GenerationProfile
    * @generated
    */
   EClass getGenerationProfile();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationProfile#getDestination <em>Destination</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Destination</em>'.
    * @see org.umlmda.generator.set.GenerationProfile#getDestination()
    * @see #getGenerationProfile()
    * @generated
    */
   EAttribute getGenerationProfile_Destination();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationProfile#getPackagePrefix <em>Package Prefix</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Package Prefix</em>'.
    * @see org.umlmda.generator.set.GenerationProfile#getPackagePrefix()
    * @see #getGenerationProfile()
    * @generated
    */
   EAttribute getGenerationProfile_PackagePrefix();

   /**
    * Returns the meta object for the attribute '{@link org.umlmda.generator.set.GenerationProfile#isActive <em>Active</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Active</em>'.
    * @see org.umlmda.generator.set.GenerationProfile#isActive()
    * @see #getGenerationProfile()
    * @generated
    */
   EAttribute getGenerationProfile_Active();

   /**
    * Returns the meta object for the reference '{@link org.umlmda.generator.set.GenerationProfile#getProfile <em>Profile</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Profile</em>'.
    * @see org.umlmda.generator.set.GenerationProfile#getProfile()
    * @see #getGenerationProfile()
    * @generated
    */
   EReference getGenerationProfile_Profile();

   /**
    * Returns the meta object for the containment reference list '{@link org.umlmda.generator.set.GenerationProfile#getProperties <em>Properties</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Properties</em>'.
    * @see org.umlmda.generator.set.GenerationProfile#getProperties()
    * @see #getGenerationProfile()
    * @generated
    */
   EReference getGenerationProfile_Properties();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   UmsFactory getUmsFactory();

} //UmsPackage
