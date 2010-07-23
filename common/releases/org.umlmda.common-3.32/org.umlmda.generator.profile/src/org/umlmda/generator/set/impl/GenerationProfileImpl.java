/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.set.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.umlmda.generator.profile.Profile;

import org.umlmda.generator.profile.Property;

import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.UmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Generation Profile</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.umlmda.generator.set.impl.GenerationProfileImpl#getDestination <em>Destination</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationProfileImpl#getPackagePrefix <em>Package Prefix</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationProfileImpl#isActive <em>Active</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationProfileImpl#getProfile <em>Profile</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationProfileImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GenerationProfileImpl extends EObjectImpl implements GenerationProfile
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String     copyright               = "www.umlmda.org";

   /**
    * The default value of the '{@link #getDestination() <em>Destination</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDestination()
    * @generated
    * @ordered
    */
   protected static final String  DESTINATION_EDEFAULT    = null;

   /**
    * The cached value of the '{@link #getDestination() <em>Destination</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDestination()
    * @generated
    * @ordered
    */
   protected String               destination             = DESTINATION_EDEFAULT;

   /**
    * The default value of the '{@link #getPackagePrefix() <em>Package Prefix</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getPackagePrefix()
    * @generated
    * @ordered
    */
   protected static final String  PACKAGE_PREFIX_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getPackagePrefix() <em>Package Prefix</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getPackagePrefix()
    * @generated
    * @ordered
    */
   protected String               packagePrefix           = PACKAGE_PREFIX_EDEFAULT;

   /**
    * The default value of the '{@link #isActive() <em>Active</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #isActive()
    * @generated
    * @ordered
    */
   protected static final boolean ACTIVE_EDEFAULT         = true;

   /**
    * The cached value of the '{@link #isActive() <em>Active</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #isActive()
    * @generated
    * @ordered
    */
   protected boolean              active                  = ACTIVE_EDEFAULT;

   /**
    * The cached value of the '{@link #getProfile() <em>Profile</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getProfile()
    * @generated
    * @ordered
    */
   protected Profile              profile                 = null;

   /**
    * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getProperties()
    * @generated
    * @ordered
    */
   protected EList                properties              = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected GenerationProfileImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EClass eStaticClass() {
      return UmsPackage.eINSTANCE.getGenerationProfile();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getDestination() {
      return destination;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setDestination(String newDestination) {
      String oldDestination = destination;
      destination = newDestination;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_PROFILE__DESTINATION, oldDestination,
               destination));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getPackagePrefix() {
      return packagePrefix;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setPackagePrefix(String newPackagePrefix) {
      String oldPackagePrefix = packagePrefix;
      packagePrefix = newPackagePrefix;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_PROFILE__PACKAGE_PREFIX, oldPackagePrefix,
               packagePrefix));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public boolean isActive() {
      return active;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setActive(boolean newActive) {
      boolean oldActive = active;
      active = newActive;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_PROFILE__ACTIVE, oldActive, active));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Profile getProfile() {
      if ( profile != null && ((EObject) profile).eIsProxy() ) {
         Profile oldProfile = profile;
         profile = (Profile) eResolveProxy((InternalEObject) profile);
         if ( profile != oldProfile ) {
            if ( eNotificationRequired() )
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmsPackage.GENERATION_PROFILE__PROFILE, oldProfile,
                     profile));
         }
      }
      return profile;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Profile basicGetProfile() {
      return profile;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setProfile(Profile newProfile) {
      Profile oldProfile = profile;
      profile = newProfile;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_PROFILE__PROFILE, oldProfile, profile));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getProperties() {
      if ( properties == null ) {
         properties = new EObjectContainmentEList(Property.class, this, UmsPackage.GENERATION_PROFILE__PROPERTIES);
      }
      return properties;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
      if ( featureID >= 0 ) {
         switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
         case UmsPackage.GENERATION_PROFILE__PROPERTIES:
            return ((InternalEList) getProperties()).basicRemove(otherEnd, msgs);
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
      case UmsPackage.GENERATION_PROFILE__DESTINATION:
         return getDestination();
      case UmsPackage.GENERATION_PROFILE__PACKAGE_PREFIX:
         return getPackagePrefix();
      case UmsPackage.GENERATION_PROFILE__ACTIVE:
         return isActive() ? Boolean.TRUE : Boolean.FALSE;
      case UmsPackage.GENERATION_PROFILE__PROFILE:
         if ( resolve )
            return getProfile();
         return basicGetProfile();
      case UmsPackage.GENERATION_PROFILE__PROPERTIES:
         return getProperties();
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
      case UmsPackage.GENERATION_PROFILE__DESTINATION:
         setDestination((String) newValue);
         return;
      case UmsPackage.GENERATION_PROFILE__PACKAGE_PREFIX:
         setPackagePrefix((String) newValue);
         return;
      case UmsPackage.GENERATION_PROFILE__ACTIVE:
         setActive(((Boolean) newValue).booleanValue());
         return;
      case UmsPackage.GENERATION_PROFILE__PROFILE:
         setProfile((Profile) newValue);
         return;
      case UmsPackage.GENERATION_PROFILE__PROPERTIES:
         getProperties().clear();
         getProperties().addAll((Collection) newValue);
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
      case UmsPackage.GENERATION_PROFILE__DESTINATION:
         setDestination(DESTINATION_EDEFAULT);
         return;
      case UmsPackage.GENERATION_PROFILE__PACKAGE_PREFIX:
         setPackagePrefix(PACKAGE_PREFIX_EDEFAULT);
         return;
      case UmsPackage.GENERATION_PROFILE__ACTIVE:
         setActive(ACTIVE_EDEFAULT);
         return;
      case UmsPackage.GENERATION_PROFILE__PROFILE:
         setProfile((Profile) null);
         return;
      case UmsPackage.GENERATION_PROFILE__PROPERTIES:
         getProperties().clear();
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
      case UmsPackage.GENERATION_PROFILE__DESTINATION:
         return DESTINATION_EDEFAULT == null ? destination != null : !DESTINATION_EDEFAULT.equals(destination);
      case UmsPackage.GENERATION_PROFILE__PACKAGE_PREFIX:
         return PACKAGE_PREFIX_EDEFAULT == null ? packagePrefix != null : !PACKAGE_PREFIX_EDEFAULT.equals(packagePrefix);
      case UmsPackage.GENERATION_PROFILE__ACTIVE:
         return active != ACTIVE_EDEFAULT;
      case UmsPackage.GENERATION_PROFILE__PROFILE:
         return profile != null;
      case UmsPackage.GENERATION_PROFILE__PROPERTIES:
         return properties != null && !properties.isEmpty();
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
      result.append(" (destination: ");
      result.append(destination);
      result.append(", packagePrefix: ");
      result.append(packagePrefix);
      result.append(", active: ");
      result.append(active);
      result.append(')');
      return result.toString();
   }

} // GenerationProfileImpl
