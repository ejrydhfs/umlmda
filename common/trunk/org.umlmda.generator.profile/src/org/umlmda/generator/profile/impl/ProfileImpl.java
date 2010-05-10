/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.MetaModelElement;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.profile.Property;
import org.umlmda.generator.profile.Stereotype;
import org.umlmda.generator.profile.UmpPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Profile</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getName <em>Name</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getAdapterFactory <em>Adapter Factory</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getValidatorFactory <em>Validator Factory</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getStereotypes <em>Stereotypes</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getArtefacts <em>Artefacts</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getDefaultProperties <em>Default Properties</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getBasedOn <em>Based On</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ProfileImpl#getMetaModelElements <em>Meta Model Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProfileImpl extends EObjectImpl implements Profile
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String    copyright                  = "www.umlmda.org";

   /**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getName()
    * @generated
    * @ordered
    */
   protected static final String NAME_EDEFAULT              = null;

   /**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getName()
    * @generated
    * @ordered
    */
   protected String              name                       = NAME_EDEFAULT;

   /**
    * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected static final String DESCRIPTION_EDEFAULT       = null;

   /**
    * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected String              description                = DESCRIPTION_EDEFAULT;

   /**
    * The default value of the '{@link #getAdapterFactory() <em>Adapter Factory</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getAdapterFactory()
    * @generated
    * @ordered
    */
   protected static final String ADAPTER_FACTORY_EDEFAULT   = null;

   /**
    * The cached value of the '{@link #getAdapterFactory() <em>Adapter Factory</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getAdapterFactory()
    * @generated
    * @ordered
    */
   protected String              adapterFactory             = ADAPTER_FACTORY_EDEFAULT;

   /**
    * The default value of the '{@link #getValidatorFactory() <em>Validator Factory</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getValidatorFactory()
    * @generated
    * @ordered
    */
   protected static final String VALIDATOR_FACTORY_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getValidatorFactory() <em>Validator Factory</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getValidatorFactory()
    * @generated
    * @ordered
    */
   protected String              validatorFactory           = VALIDATOR_FACTORY_EDEFAULT;

   /**
    * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' containment reference list. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getStereotypes()
    * @generated
    * @ordered
    */
   protected EList               stereotypes                = null;

   /**
    * The cached value of the '{@link #getArtefacts() <em>Artefacts</em>}' containment reference list. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getArtefacts()
    * @generated
    * @ordered
    */
   protected EList               artefacts                  = null;

   /**
    * The cached value of the '{@link #getDefaultProperties() <em>Default Properties</em>}' containment reference list. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getDefaultProperties()
    * @generated
    * @ordered
    */
   protected EList               defaultProperties          = null;

   /**
    * The cached value of the '{@link #getBasedOn() <em>Based On</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @see #getBasedOn()
    * @generated
    * @ordered
    */
   protected EList               basedOn                    = null;

   /**
    * The cached value of the '{@link #getMetaModelElements() <em>Meta Model Elements</em>}' containment reference list. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getMetaModelElements()
    * @generated
    * @ordered
    */
   protected EList               metaModelElements          = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected ProfileImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EClass eStaticClass() {
      return UmpPackage.eINSTANCE.getProfile();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getName() {
      return name;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setName(String newName) {
      String oldName = name;
      name = newName;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.PROFILE__NAME, oldName, name));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getDescription() {
      return description;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setDescription(String newDescription) {
      String oldDescription = description;
      description = newDescription;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.PROFILE__DESCRIPTION, oldDescription, description));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getAdapterFactory() {
      return adapterFactory;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setAdapterFactory(String newAdapterFactory) {
      String oldAdapterFactory = adapterFactory;
      adapterFactory = newAdapterFactory;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.PROFILE__ADAPTER_FACTORY, oldAdapterFactory,
               adapterFactory));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getValidatorFactory() {
      return validatorFactory;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setValidatorFactory(String newValidatorFactory) {
      String oldValidatorFactory = validatorFactory;
      validatorFactory = newValidatorFactory;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.PROFILE__VALIDATOR_FACTORY, oldValidatorFactory,
               validatorFactory));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getStereotypes() {
      if ( stereotypes == null ) {
         stereotypes = new EObjectContainmentEList(Stereotype.class, this, UmpPackage.PROFILE__STEREOTYPES);
      }
      return stereotypes;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getArtefacts() {
      if ( artefacts == null ) {
         artefacts = new EObjectContainmentEList(Artefact.class, this, UmpPackage.PROFILE__ARTEFACTS);
      }
      return artefacts;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getDefaultProperties() {
      if ( defaultProperties == null ) {
         defaultProperties = new EObjectContainmentEList(Property.class, this, UmpPackage.PROFILE__DEFAULT_PROPERTIES);
      }
      return defaultProperties;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getBasedOn() {
      if ( basedOn == null ) {
         basedOn = new EObjectResolvingEList(Profile.class, this, UmpPackage.PROFILE__BASED_ON);
      }
      return basedOn;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getMetaModelElements() {
      if ( metaModelElements == null ) {
         metaModelElements = new EObjectContainmentEList(MetaModelElement.class, this, UmpPackage.PROFILE__META_MODEL_ELEMENTS);
      }
      return metaModelElements;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
      if ( featureID >= 0 ) {
         switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
         case UmpPackage.PROFILE__STEREOTYPES:
            return ((InternalEList) getStereotypes()).basicRemove(otherEnd, msgs);
         case UmpPackage.PROFILE__ARTEFACTS:
            return ((InternalEList) getArtefacts()).basicRemove(otherEnd, msgs);
         case UmpPackage.PROFILE__DEFAULT_PROPERTIES:
            return ((InternalEList) getDefaultProperties()).basicRemove(otherEnd, msgs);
         case UmpPackage.PROFILE__META_MODEL_ELEMENTS:
            return ((InternalEList) getMetaModelElements()).basicRemove(otherEnd, msgs);
         default:
            return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
         }
      }
      return eBasicSetContainer(null, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Object eGet(EStructuralFeature eFeature, boolean resolve) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.PROFILE__NAME:
         return getName();
      case UmpPackage.PROFILE__DESCRIPTION:
         return getDescription();
      case UmpPackage.PROFILE__ADAPTER_FACTORY:
         return getAdapterFactory();
      case UmpPackage.PROFILE__VALIDATOR_FACTORY:
         return getValidatorFactory();
      case UmpPackage.PROFILE__STEREOTYPES:
         return getStereotypes();
      case UmpPackage.PROFILE__ARTEFACTS:
         return getArtefacts();
      case UmpPackage.PROFILE__DEFAULT_PROPERTIES:
         return getDefaultProperties();
      case UmpPackage.PROFILE__BASED_ON:
         return getBasedOn();
      case UmpPackage.PROFILE__META_MODEL_ELEMENTS:
         return getMetaModelElements();
      }
      return eDynamicGet(eFeature, resolve);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void eSet(EStructuralFeature eFeature, Object newValue) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.PROFILE__NAME:
         setName((String) newValue);
         return;
      case UmpPackage.PROFILE__DESCRIPTION:
         setDescription((String) newValue);
         return;
      case UmpPackage.PROFILE__ADAPTER_FACTORY:
         setAdapterFactory((String) newValue);
         return;
      case UmpPackage.PROFILE__VALIDATOR_FACTORY:
         setValidatorFactory((String) newValue);
         return;
      case UmpPackage.PROFILE__STEREOTYPES:
         getStereotypes().clear();
         getStereotypes().addAll((Collection) newValue);
         return;
      case UmpPackage.PROFILE__ARTEFACTS:
         getArtefacts().clear();
         getArtefacts().addAll((Collection) newValue);
         return;
      case UmpPackage.PROFILE__DEFAULT_PROPERTIES:
         getDefaultProperties().clear();
         getDefaultProperties().addAll((Collection) newValue);
         return;
      case UmpPackage.PROFILE__BASED_ON:
         getBasedOn().clear();
         getBasedOn().addAll((Collection) newValue);
         return;
      case UmpPackage.PROFILE__META_MODEL_ELEMENTS:
         getMetaModelElements().clear();
         getMetaModelElements().addAll((Collection) newValue);
         return;
      }
      eDynamicSet(eFeature, newValue);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void eUnset(EStructuralFeature eFeature) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.PROFILE__NAME:
         setName(NAME_EDEFAULT);
         return;
      case UmpPackage.PROFILE__DESCRIPTION:
         setDescription(DESCRIPTION_EDEFAULT);
         return;
      case UmpPackage.PROFILE__ADAPTER_FACTORY:
         setAdapterFactory(ADAPTER_FACTORY_EDEFAULT);
         return;
      case UmpPackage.PROFILE__VALIDATOR_FACTORY:
         setValidatorFactory(VALIDATOR_FACTORY_EDEFAULT);
         return;
      case UmpPackage.PROFILE__STEREOTYPES:
         getStereotypes().clear();
         return;
      case UmpPackage.PROFILE__ARTEFACTS:
         getArtefacts().clear();
         return;
      case UmpPackage.PROFILE__DEFAULT_PROPERTIES:
         getDefaultProperties().clear();
         return;
      case UmpPackage.PROFILE__BASED_ON:
         getBasedOn().clear();
         return;
      case UmpPackage.PROFILE__META_MODEL_ELEMENTS:
         getMetaModelElements().clear();
         return;
      }
      eDynamicUnset(eFeature);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public boolean eIsSet(EStructuralFeature eFeature) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.PROFILE__NAME:
         return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmpPackage.PROFILE__DESCRIPTION:
         return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case UmpPackage.PROFILE__ADAPTER_FACTORY:
         return ADAPTER_FACTORY_EDEFAULT == null ? adapterFactory != null : !ADAPTER_FACTORY_EDEFAULT.equals(adapterFactory);
      case UmpPackage.PROFILE__VALIDATOR_FACTORY:
         return VALIDATOR_FACTORY_EDEFAULT == null ? validatorFactory != null : !VALIDATOR_FACTORY_EDEFAULT
               .equals(validatorFactory);
      case UmpPackage.PROFILE__STEREOTYPES:
         return stereotypes != null && !stereotypes.isEmpty();
      case UmpPackage.PROFILE__ARTEFACTS:
         return artefacts != null && !artefacts.isEmpty();
      case UmpPackage.PROFILE__DEFAULT_PROPERTIES:
         return defaultProperties != null && !defaultProperties.isEmpty();
      case UmpPackage.PROFILE__BASED_ON:
         return basedOn != null && !basedOn.isEmpty();
      case UmpPackage.PROFILE__META_MODEL_ELEMENTS:
         return metaModelElements != null && !metaModelElements.isEmpty();
      }
      return eDynamicIsSet(eFeature);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String toString() {
      if ( eIsProxy() )
         return super.toString();

      StringBuffer result = new StringBuffer(super.toString());
      result.append(" (name: ");
      result.append(name);
      result.append(", description: ");
      result.append(description);
      result.append(", adapterFactory: ");
      result.append(adapterFactory);
      result.append(", validatorFactory: ");
      result.append(validatorFactory);
      result.append(')');
      return result.toString();
   }

} // ProfileImpl
