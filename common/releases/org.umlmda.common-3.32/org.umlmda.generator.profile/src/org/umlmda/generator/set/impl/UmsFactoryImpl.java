/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.set.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.umlmda.generator.set.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmsFactoryImpl extends EFactoryImpl implements UmsFactory
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * Creates and instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public UmsFactoryImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EObject create(EClass eClass) {
      switch (eClass.getClassifierID()) {
      case UmsPackage.GENERATION_SET:
         return (EObject) createGenerationSet();
      case UmsPackage.GENERATION_PROFILE:
         return (EObject) createGenerationProfile();
      default:
         throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public GenerationSet createGenerationSet() {
      GenerationSetImpl generationSet = new GenerationSetImpl();
      return generationSet;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public GenerationProfile createGenerationProfile() {
      GenerationProfileImpl generationProfile = new GenerationProfileImpl();
      return generationProfile;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public UmsPackage getUmsPackage() {
      return (UmsPackage) getEPackage();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @deprecated
    * @generated
    */
   public static UmsPackage getPackage() {
      return UmsPackage.eINSTANCE;
   }

} // UmsFactoryImpl
