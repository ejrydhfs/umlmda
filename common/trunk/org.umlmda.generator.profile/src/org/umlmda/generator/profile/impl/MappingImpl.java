/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.util.Properties;

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
import org.umlmda.generator.profile.AbstractMappingContainer;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.Property;
import org.umlmda.generator.profile.Stereotype;
import org.umlmda.generator.profile.UmpPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Mapping</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.impl.MappingImpl#getProperties <em>Properties</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.MappingImpl#getArtefact <em>Artefact</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.MappingImpl#getSubMappings <em>Sub Mappings</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.MappingImpl#getMappingProperties <em>Mapping Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MappingImpl extends EObjectImpl implements Mapping
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String        copyright           = "www.umlmda.org";

   /**
    * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @see #getProperties()
    * @generated
    * @ordered
    */
   protected static final Properties PROPERTIES_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getArtefact() <em>Artefact</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getArtefact()
    * @generated
    * @ordered
    */
   protected Artefact                artefact            = null;

   /**
    * The cached value of the '{@link #getSubMappings() <em>Sub Mappings</em>}' containment reference list. <!-- begin-user-doc
    * --> <!-- end-user-doc -->
    * 
    * @see #getSubMappings()
    * @generated
    * @ordered
    */
   protected EList                   subMappings         = null;

   /**
    * The cached value of the '{@link #getMappingProperties() <em>Mapping Properties</em>}' containment reference list. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getMappingProperties()
    * @generated
    * @ordered
    */
   protected EList                   mappingProperties   = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected MappingImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EClass eStaticClass() {
      return UmpPackage.eINSTANCE.getMapping();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Artefact getArtefact() {
      if ( artefact != null && ((EObject) artefact).eIsProxy() ) {
         Artefact oldArtefact = artefact;
         artefact = (Artefact) eResolveProxy((InternalEObject) artefact);
         if ( artefact != oldArtefact ) {
            if ( eNotificationRequired() )
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmpPackage.MAPPING__ARTEFACT, oldArtefact, artefact));
         }
      }
      return artefact;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Artefact basicGetArtefact() {
      return artefact;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setArtefact(Artefact newArtefact) {
      Artefact oldArtefact = artefact;
      artefact = newArtefact;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.MAPPING__ARTEFACT, oldArtefact, artefact));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getSubMappings() {
      if ( subMappings == null ) {
         subMappings = new EObjectContainmentEList(AbstractMappingContainer.class, this, UmpPackage.MAPPING__SUB_MAPPINGS);
      }
      return subMappings;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getMappingProperties() {
      if ( mappingProperties == null ) {
         mappingProperties = new EObjectContainmentEList(Property.class, this, UmpPackage.MAPPING__MAPPING_PROPERTIES);
      }
      return mappingProperties;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated NOT
    */
   public Properties getProperties() {
      Properties properties = new Properties();

      if ( getArtefact() != null ) {
         properties.putAll(getArtefact().getProperties());
      }

      for ( Iterator ip = getMappingProperties().iterator(); ip.hasNext(); ) {
         Property property = (Property) ip.next();

         properties.put(property.getName(), property.getValue());
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
         case UmpPackage.MAPPING__SUB_MAPPINGS:
            return ((InternalEList) getSubMappings()).basicRemove(otherEnd, msgs);
         case UmpPackage.MAPPING__MAPPING_PROPERTIES:
            return ((InternalEList) getMappingProperties()).basicRemove(otherEnd, msgs);
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
      case UmpPackage.MAPPING__PROPERTIES:
         return getProperties();
      case UmpPackage.MAPPING__ARTEFACT:
         if ( resolve )
            return getArtefact();
         return basicGetArtefact();
      case UmpPackage.MAPPING__SUB_MAPPINGS:
         return getSubMappings();
      case UmpPackage.MAPPING__MAPPING_PROPERTIES:
         return getMappingProperties();
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
      case UmpPackage.MAPPING__ARTEFACT:
         setArtefact((Artefact) newValue);
         return;
      case UmpPackage.MAPPING__SUB_MAPPINGS:
         getSubMappings().clear();
         getSubMappings().addAll((Collection) newValue);
         return;
      case UmpPackage.MAPPING__MAPPING_PROPERTIES:
         getMappingProperties().clear();
         getMappingProperties().addAll((Collection) newValue);
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
      case UmpPackage.MAPPING__ARTEFACT:
         setArtefact((Artefact) null);
         return;
      case UmpPackage.MAPPING__SUB_MAPPINGS:
         getSubMappings().clear();
         return;
      case UmpPackage.MAPPING__MAPPING_PROPERTIES:
         getMappingProperties().clear();
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
      case UmpPackage.MAPPING__PROPERTIES:
         return PROPERTIES_EDEFAULT == null ? getProperties() != null : !PROPERTIES_EDEFAULT.equals(getProperties());
      case UmpPackage.MAPPING__ARTEFACT:
         return artefact != null;
      case UmpPackage.MAPPING__SUB_MAPPINGS:
         return subMappings != null && !subMappings.isEmpty();
      case UmpPackage.MAPPING__MAPPING_PROPERTIES:
         return mappingProperties != null && !mappingProperties.isEmpty();
      }
      return eDynamicIsSet(eFeature);
   }

} // MappingImpl
