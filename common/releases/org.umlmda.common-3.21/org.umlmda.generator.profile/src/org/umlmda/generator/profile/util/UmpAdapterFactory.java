/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmpAdapterFactory.java,v 1.5 2006/06/24 19:07:55 moroff Exp $
 */
package org.umlmda.generator.profile.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.umlmda.generator.profile.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.profile.UmpPackage
 * @generated
 */
public class UmpAdapterFactory extends AdapterFactoryImpl {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * The cached model package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static UmpPackage modelPackage;

   /**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UmpAdapterFactory() {
      if (modelPackage == null) {
         modelPackage = UmpPackage.eINSTANCE;
      }
   }

   /**
    * Returns whether this factory is applicable for the type of the object.
    * <!-- begin-user-doc -->
    * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
    * <!-- end-user-doc -->
    * @return whether this factory is applicable for the type of the object.
    * @generated
    */
   public boolean isFactoryForType(Object object) {
      if (object == modelPackage) {
         return true;
      }
      if (object instanceof EObject) {
         return ((EObject)object).eClass().getEPackage() == modelPackage;
      }
      return false;
   }

   /**
    * The switch the delegates to the <code>createXXX</code> methods.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected UmpSwitch modelSwitch =
      new UmpSwitch() {
         public Object caseProfile(Profile object) {
            return createProfileAdapter();
         }
         public Object caseStereotype(Stereotype object) {
            return createStereotypeAdapter();
         }
         public Object caseArtefact(Artefact object) {
            return createArtefactAdapter();
         }
         public Object caseMapping(Mapping object) {
            return createMappingAdapter();
         }
         public Object caseProperty(Property object) {
            return createPropertyAdapter();
         }
         public Object caseMetaModelElement(MetaModelElement object) {
            return createMetaModelElementAdapter();
         }
         public Object caseAbstractMappingContainer(AbstractMappingContainer object) {
            return createAbstractMappingContainerAdapter();
         }
         public Object defaultCase(EObject object) {
            return createEObjectAdapter();
         }
      };

   /**
    * Creates an adapter for the <code>target</code>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param target the object to adapt.
    * @return the adapter for the <code>target</code>.
    * @generated
    */
   public Adapter createAdapter(Notifier target) {
      return (Adapter)modelSwitch.doSwitch((EObject)target);
   }


   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.profile.Profile <em>Profile</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.profile.Profile
    * @generated
    */
   public Adapter createProfileAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.profile.Stereotype <em>Stereotype</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.profile.Stereotype
    * @generated
    */
   public Adapter createStereotypeAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.profile.Artefact <em>Artefact</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.profile.Artefact
    * @generated
    */
   public Adapter createArtefactAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.profile.Mapping <em>Mapping</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.profile.Mapping
    * @generated
    */
   public Adapter createMappingAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.profile.Property <em>Property</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.profile.Property
    * @generated
    */
   public Adapter createPropertyAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.profile.MetaModelElement <em>Meta Model Element</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.profile.MetaModelElement
    * @generated
    */
   public Adapter createMetaModelElementAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.profile.AbstractMappingContainer <em>Abstract Mapping Container</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.profile.AbstractMappingContainer
    * @generated
    */
   public Adapter createAbstractMappingContainerAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for the default case.
    * <!-- begin-user-doc -->
    * This default implementation returns null.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @generated
    */
   public Adapter createEObjectAdapter() {
      return null;
   }

} //UmpAdapterFactory
