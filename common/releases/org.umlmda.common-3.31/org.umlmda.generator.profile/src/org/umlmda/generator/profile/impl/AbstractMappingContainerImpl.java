/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.umlmda.generator.profile.AbstractMappingContainer;
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.UmpPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Mapping Container</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.impl.AbstractMappingContainerImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractMappingContainerImpl extends EObjectImpl implements AbstractMappingContainer
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getMappings()
    * @generated
    * @ordered
    */
   protected EList            mappings  = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected AbstractMappingContainerImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EClass eStaticClass() {
      return UmpPackage.eINSTANCE.getAbstractMappingContainer();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getMappings() {
      if ( mappings == null ) {
         mappings = new EObjectContainmentEList(Mapping.class, this, UmpPackage.ABSTRACT_MAPPING_CONTAINER__MAPPINGS);
      }
      return mappings;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
      if ( featureID >= 0 ) {
         switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
         case UmpPackage.ABSTRACT_MAPPING_CONTAINER__MAPPINGS:
            return ((InternalEList) getMappings()).basicRemove(otherEnd, msgs);
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
      case UmpPackage.ABSTRACT_MAPPING_CONTAINER__MAPPINGS:
         return getMappings();
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
      case UmpPackage.ABSTRACT_MAPPING_CONTAINER__MAPPINGS:
         getMappings().clear();
         getMappings().addAll((Collection) newValue);
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
      case UmpPackage.ABSTRACT_MAPPING_CONTAINER__MAPPINGS:
         getMappings().clear();
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
      case UmpPackage.ABSTRACT_MAPPING_CONTAINER__MAPPINGS:
         return mappings != null && !mappings.isEmpty();
      }
      return eDynamicIsSet(eFeature);
   }

} // AbstractMappingContainerImpl
