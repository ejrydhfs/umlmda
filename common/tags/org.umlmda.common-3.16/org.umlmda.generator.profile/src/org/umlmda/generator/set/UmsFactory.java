/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmsFactory.java,v 1.3 2005/11/08 08:06:52 moroff Exp $
 */
package org.umlmda.generator.set;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.set.UmsPackage
 * @generated
 */
public interface UmsFactory extends EFactory{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   UmsFactory eINSTANCE = new org.umlmda.generator.set.impl.UmsFactoryImpl();

   /**
    * Returns a new object of class '<em>Generation Set</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Generation Set</em>'.
    * @generated
    */
   GenerationSet createGenerationSet();

   /**
    * Returns a new object of class '<em>Generation Profile</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Generation Profile</em>'.
    * @generated
    */
   GenerationProfile createGenerationProfile();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   UmsPackage getUmsPackage();

} //UmsFactory
