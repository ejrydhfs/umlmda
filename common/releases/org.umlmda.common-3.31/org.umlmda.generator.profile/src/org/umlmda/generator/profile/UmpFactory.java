/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.umlmda.generator.profile.UmpPackage
 * @generated
 */
public interface UmpFactory extends EFactory
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   String     copyright = "www.umlmda.org";

   /**
    * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   UmpFactory eINSTANCE = new org.umlmda.generator.profile.impl.UmpFactoryImpl();

   /**
    * Returns a new object of class '<em>Profile</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Profile</em>'.
    * @generated
    */
   Profile createProfile();

   /**
    * Returns a new object of class '<em>Stereotype</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Stereotype</em>'.
    * @generated
    */
   Stereotype createStereotype();

   /**
    * Returns a new object of class '<em>Artefact</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Artefact</em>'.
    * @generated
    */
   Artefact createArtefact();

   /**
    * Returns a new object of class '<em>Mapping</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Mapping</em>'.
    * @generated
    */
   Mapping createMapping();

   /**
    * Returns a new object of class '<em>Property</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Property</em>'.
    * @generated
    */
   Property createProperty();

   /**
    * Returns a new object of class '<em>Meta Model Element</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @return a new object of class '<em>Meta Model Element</em>'.
    * @generated
    */
   MetaModelElement createMetaModelElement();

   /**
    * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @return the package supported by this factory.
    * @generated
    */
   UmpPackage getUmpPackage();

} // UmpFactory
