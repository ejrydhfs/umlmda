/**
 * <copyright>
 * </copyright>
 *
 * $Id: StereotypeImpl.java,v 1.4 2006/06/24 19:07:54 moroff Exp $
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
import org.eclipse.emf.ecore.util.InternalEList;
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.Stereotype;
import org.umlmda.generator.profile.UmpPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.umlmda.generator.profile.impl.StereotypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeImpl extends AbstractMappingContainerImpl implements Stereotype {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected static final String NAME_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected String name = NAME_EDEFAULT;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected StereotypeImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected EClass eStaticClass() {
      return UmpPackage.eINSTANCE.getStereotype();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getName() {
      return name;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setName(String newName) {
      String oldName = name;
      name = newName;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.STEREOTYPE__NAME, oldName, name));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
      if (featureID >= 0) {
         switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
            case UmpPackage.STEREOTYPE__MAPPINGS:
               return ((InternalEList)getMappings()).basicRemove(otherEnd, msgs);
            default:
               return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
         }
      }
      return eBasicSetContainer(null, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Object eGet(EStructuralFeature eFeature, boolean resolve) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
         case UmpPackage.STEREOTYPE__MAPPINGS:
            return getMappings();
         case UmpPackage.STEREOTYPE__NAME:
            return getName();
      }
      return eDynamicGet(eFeature, resolve);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void eSet(EStructuralFeature eFeature, Object newValue) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
         case UmpPackage.STEREOTYPE__MAPPINGS:
            getMappings().clear();
            getMappings().addAll((Collection)newValue);
            return;
         case UmpPackage.STEREOTYPE__NAME:
            setName((String)newValue);
            return;
      }
      eDynamicSet(eFeature, newValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void eUnset(EStructuralFeature eFeature) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
         case UmpPackage.STEREOTYPE__MAPPINGS:
            getMappings().clear();
            return;
         case UmpPackage.STEREOTYPE__NAME:
            setName(NAME_EDEFAULT);
            return;
      }
      eDynamicUnset(eFeature);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean eIsSet(EStructuralFeature eFeature) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
         case UmpPackage.STEREOTYPE__MAPPINGS:
            return mappings != null && !mappings.isEmpty();
         case UmpPackage.STEREOTYPE__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      }
      return eDynamicIsSet(eFeature);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String toString() {
      if (eIsProxy()) return super.toString();

      StringBuffer result = new StringBuffer(super.toString());
      result.append(" (name: ");
      result.append(name);
      result.append(')');
      return result.toString();
   }

} //StereotypeImpl
