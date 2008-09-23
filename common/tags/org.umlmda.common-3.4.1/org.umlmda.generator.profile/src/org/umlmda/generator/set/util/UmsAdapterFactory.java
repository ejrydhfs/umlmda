/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmsAdapterFactory.java,v 1.3 2005/11/08 08:06:52 moroff Exp $
 */
package org.umlmda.generator.set.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.umlmda.generator.set.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.set.UmsPackage
 * @generated
 */
public class UmsAdapterFactory extends AdapterFactoryImpl {
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
   protected static UmsPackage modelPackage;

   /**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UmsAdapterFactory() {
      if (modelPackage == null) {
         modelPackage = UmsPackage.eINSTANCE;
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
   protected UmsSwitch modelSwitch =
      new UmsSwitch() {
         public Object caseGenerationSet(GenerationSet object) {
            return createGenerationSetAdapter();
         }
         public Object caseGenerationProfile(GenerationProfile object) {
            return createGenerationProfileAdapter();
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
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.set.GenerationSet <em>Generation Set</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.set.GenerationSet
    * @generated
    */
   public Adapter createGenerationSetAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.umlmda.generator.set.GenerationProfile <em>Generation Profile</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.umlmda.generator.set.GenerationProfile
    * @generated
    */
   public Adapter createGenerationProfileAdapter() {
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

} //UmsAdapterFactory
