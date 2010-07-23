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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;
import org.umlmda.generator.set.UmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Generation Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.umlmda.generator.set.impl.GenerationSetImpl#getName <em>Name</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationSetImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationSetImpl#isExclusive <em>Exclusive</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationSetImpl#getTarget <em>Target</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationSetImpl#getModel <em>Model</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationSetImpl#getGenerationProfile <em>Generation Profile</em>}</li>
 * <li>{@link org.umlmda.generator.set.impl.GenerationSetImpl#getReferencedSets <em>Referenced Sets</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GenerationSetImpl extends EObjectImpl implements GenerationSet
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String     copyright            = "www.umlmda.org";

   /**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getName()
    * @generated
    * @ordered
    */
   protected static final String  NAME_EDEFAULT        = null;

   /**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getName()
    * @generated
    * @ordered
    */
   protected String               name                 = NAME_EDEFAULT;

   /**
    * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected static final String  DESCRIPTION_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected String               description          = DESCRIPTION_EDEFAULT;

   /**
    * The default value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @see #isExclusive()
    * @generated
    * @ordered
    */
   protected static final boolean EXCLUSIVE_EDEFAULT   = true;

   /**
    * The cached value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #isExclusive()
    * @generated
    * @ordered
    */
   protected boolean              exclusive            = EXCLUSIVE_EDEFAULT;

   /**
    * The default value of the '{@link #getTarget() <em>Target</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getTarget()
    * @generated
    * @ordered
    */
   protected static final String  TARGET_EDEFAULT      = null;

   /**
    * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getTarget()
    * @generated
    * @ordered
    */
   protected String               target               = TARGET_EDEFAULT;

   /**
    * The default value of the '{@link #getModel() <em>Model</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getModel()
    * @generated
    * @ordered
    */
   protected static final String  MODEL_EDEFAULT       = null;

   /**
    * The cached value of the '{@link #getModel() <em>Model</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getModel()
    * @generated
    * @ordered
    */
   protected String               model                = MODEL_EDEFAULT;

   /**
    * The cached value of the '{@link #getGenerationProfile() <em>Generation Profile</em>}' containment reference list. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getGenerationProfile()
    * @generated
    * @ordered
    */
   protected EList                generationProfile    = null;

   /**
    * The cached value of the '{@link #getReferencedSets() <em>Referenced Sets</em>}' reference list. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getReferencedSets()
    * @generated
    * @ordered
    */
   protected EList                referencedSets       = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected GenerationSetImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EClass eStaticClass() {
      return UmsPackage.eINSTANCE.getGenerationSet();
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
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_SET__NAME, oldName, name));
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
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_SET__DESCRIPTION, oldDescription,
               description));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public boolean isExclusive() {
      return exclusive;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setExclusive(boolean newExclusive) {
      boolean oldExclusive = exclusive;
      exclusive = newExclusive;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_SET__EXCLUSIVE, oldExclusive, exclusive));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getTarget() {
      return target;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setTarget(String newTarget) {
      String oldTarget = target;
      target = newTarget;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_SET__TARGET, oldTarget, target));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getModel() {
      return model;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setModel(String newModel) {
      String oldModel = model;
      model = newModel;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmsPackage.GENERATION_SET__MODEL, oldModel, model));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getGenerationProfile() {
      if ( generationProfile == null ) {
         generationProfile = new EObjectContainmentEList(GenerationProfile.class, this,
               UmsPackage.GENERATION_SET__GENERATION_PROFILE);
      }
      return generationProfile;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getReferencedSets() {
      if ( referencedSets == null ) {
         referencedSets = new EObjectResolvingEList(GenerationSet.class, this, UmsPackage.GENERATION_SET__REFERENCED_SETS);
      }
      return referencedSets;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
      if ( featureID >= 0 ) {
         switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
         case UmsPackage.GENERATION_SET__GENERATION_PROFILE:
            return ((InternalEList) getGenerationProfile()).basicRemove(otherEnd, msgs);
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
      case UmsPackage.GENERATION_SET__NAME:
         return getName();
      case UmsPackage.GENERATION_SET__DESCRIPTION:
         return getDescription();
      case UmsPackage.GENERATION_SET__EXCLUSIVE:
         return isExclusive() ? Boolean.TRUE : Boolean.FALSE;
      case UmsPackage.GENERATION_SET__TARGET:
         return getTarget();
      case UmsPackage.GENERATION_SET__MODEL:
         return getModel();
      case UmsPackage.GENERATION_SET__GENERATION_PROFILE:
         return getGenerationProfile();
      case UmsPackage.GENERATION_SET__REFERENCED_SETS:
         return getReferencedSets();
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
      case UmsPackage.GENERATION_SET__NAME:
         setName((String) newValue);
         return;
      case UmsPackage.GENERATION_SET__DESCRIPTION:
         setDescription((String) newValue);
         return;
      case UmsPackage.GENERATION_SET__EXCLUSIVE:
         setExclusive(((Boolean) newValue).booleanValue());
         return;
      case UmsPackage.GENERATION_SET__TARGET:
         setTarget((String) newValue);
         return;
      case UmsPackage.GENERATION_SET__MODEL:
         setModel((String) newValue);
         return;
      case UmsPackage.GENERATION_SET__GENERATION_PROFILE:
         getGenerationProfile().clear();
         getGenerationProfile().addAll((Collection) newValue);
         return;
      case UmsPackage.GENERATION_SET__REFERENCED_SETS:
         getReferencedSets().clear();
         getReferencedSets().addAll((Collection) newValue);
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
      case UmsPackage.GENERATION_SET__NAME:
         setName(NAME_EDEFAULT);
         return;
      case UmsPackage.GENERATION_SET__DESCRIPTION:
         setDescription(DESCRIPTION_EDEFAULT);
         return;
      case UmsPackage.GENERATION_SET__EXCLUSIVE:
         setExclusive(EXCLUSIVE_EDEFAULT);
         return;
      case UmsPackage.GENERATION_SET__TARGET:
         setTarget(TARGET_EDEFAULT);
         return;
      case UmsPackage.GENERATION_SET__MODEL:
         setModel(MODEL_EDEFAULT);
         return;
      case UmsPackage.GENERATION_SET__GENERATION_PROFILE:
         getGenerationProfile().clear();
         return;
      case UmsPackage.GENERATION_SET__REFERENCED_SETS:
         getReferencedSets().clear();
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
      case UmsPackage.GENERATION_SET__NAME:
         return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmsPackage.GENERATION_SET__DESCRIPTION:
         return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case UmsPackage.GENERATION_SET__EXCLUSIVE:
         return exclusive != EXCLUSIVE_EDEFAULT;
      case UmsPackage.GENERATION_SET__TARGET:
         return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
      case UmsPackage.GENERATION_SET__MODEL:
         return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
      case UmsPackage.GENERATION_SET__GENERATION_PROFILE:
         return generationProfile != null && !generationProfile.isEmpty();
      case UmsPackage.GENERATION_SET__REFERENCED_SETS:
         return referencedSets != null && !referencedSets.isEmpty();
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
      result.append(", exclusive: ");
      result.append(exclusive);
      result.append(", target: ");
      result.append(target);
      result.append(", model: ");
      result.append(model);
      result.append(')');
      return result.toString();
   }

} // GenerationSetImpl
