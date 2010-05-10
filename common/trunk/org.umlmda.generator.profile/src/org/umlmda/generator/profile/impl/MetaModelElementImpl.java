/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.InternalEList;

import org.umlmda.generator.profile.MetaModelElement;
import org.umlmda.generator.profile.MetaModelElementType;
import org.umlmda.generator.profile.UmpPackage;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelPackageBase;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Meta Model Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.impl.MetaModelElementImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MetaModelElementImpl extends AbstractMappingContainerImpl implements MetaModelElement
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String                  copyright     = "www.umlmda.org";

   /**
    * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getType()
    * @generated
    * @ordered
    */
   protected static final MetaModelElementType TYPE_EDEFAULT = MetaModelElementType.MODEL_LITERAL;

   /**
    * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getType()
    * @generated
    * @ordered
    */
   protected MetaModelElementType              type          = TYPE_EDEFAULT;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected MetaModelElementImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EClass eStaticClass() {
      return UmpPackage.eINSTANCE.getMetaModelElement();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public MetaModelElementType getType() {
      return type;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setType(MetaModelElementType newType) {
      MetaModelElementType oldType = type;
      type = newType == null ? TYPE_EDEFAULT : newType;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.META_MODEL_ELEMENT__TYPE, oldType, type));
   }

   /**
    * <!-- begin-user-doc --> Checks if the given modelelement type maps the given type <!-- end-user-doc -->
    * 
    * @generated NOT
    */
   public boolean match(ModelElementBase modelElement) {
      if ( getType().getValue() == MetaModelElementType.CLASS && modelElement instanceof ModelClassBase )
         return true;
      else if ( getType().getValue() == MetaModelElementType.PACKAGE && modelElement instanceof ModelPackageBase )
         return true;
      else if ( getType().getValue() == MetaModelElementType.MODEL && modelElement instanceof ModelBase )
         return true;
      else
         return false;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
      if ( featureID >= 0 ) {
         switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
         case UmpPackage.META_MODEL_ELEMENT__MAPPINGS:
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
      case UmpPackage.META_MODEL_ELEMENT__MAPPINGS:
         return getMappings();
      case UmpPackage.META_MODEL_ELEMENT__TYPE:
         return getType();
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
      case UmpPackage.META_MODEL_ELEMENT__MAPPINGS:
         getMappings().clear();
         getMappings().addAll((Collection) newValue);
         return;
      case UmpPackage.META_MODEL_ELEMENT__TYPE:
         setType((MetaModelElementType) newValue);
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
      case UmpPackage.META_MODEL_ELEMENT__MAPPINGS:
         getMappings().clear();
         return;
      case UmpPackage.META_MODEL_ELEMENT__TYPE:
         setType(TYPE_EDEFAULT);
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
      case UmpPackage.META_MODEL_ELEMENT__MAPPINGS:
         return mappings != null && !mappings.isEmpty();
      case UmpPackage.META_MODEL_ELEMENT__TYPE:
         return type != TYPE_EDEFAULT;
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
      result.append(" (type: ");
      result.append(type);
      result.append(')');
      return result.toString();
   }

} // MetaModelElementImpl
