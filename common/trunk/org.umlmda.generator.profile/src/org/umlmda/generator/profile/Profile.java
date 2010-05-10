/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile;

import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Profile</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.Profile#getName <em>Name</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getDescription <em>Description</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getAdapterFactory <em>Adapter Factory</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getValidatorFactory <em>Validator Factory</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getStereotypes <em>Stereotypes</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getArtefacts <em>Artefacts</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getDefaultProperties <em>Default Properties</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getBasedOn <em>Based On</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Profile#getMetaModelElements <em>Meta Model Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.umlmda.generator.profile.UmpPackage#getProfile()
 * @model
 * @generated
 */
public interface Profile
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Name</em>' attribute.
    * @see #setName(String)
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_Name()
    * @model id="true"
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Profile#getName <em>Name</em>}' attribute. <!-- begin-user-doc
    * --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
   void setName(String value);

   /**
    * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Description</em>' attribute.
    * @see #setDescription(String)
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_Description()
    * @model
    * @generated
    */
   String getDescription();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Profile#getDescription <em>Description</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Description</em>' attribute.
    * @see #getDescription()
    * @generated
    */
   void setDescription(String value);

   /**
    * Returns the value of the '<em><b>Adapter Factory</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Adapter Factory</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Adapter Factory</em>' attribute.
    * @see #setAdapterFactory(String)
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_AdapterFactory()
    * @model
    * @generated
    */
   String getAdapterFactory();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Profile#getAdapterFactory <em>Adapter Factory</em>}' attribute.
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Adapter Factory</em>' attribute.
    * @see #getAdapterFactory()
    * @generated
    */
   void setAdapterFactory(String value);

   /**
    * Returns the value of the '<em><b>Validator Factory</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Validator Factory</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Validator Factory</em>' attribute.
    * @see #setValidatorFactory(String)
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_ValidatorFactory()
    * @model
    * @generated
    */
   String getValidatorFactory();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Profile#getValidatorFactory <em>Validator Factory</em>}'
    * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Validator Factory</em>' attribute.
    * @see #getValidatorFactory()
    * @generated
    */
   void setValidatorFactory(String value);

   /**
    * Returns the value of the '<em><b>Stereotypes</b></em>' containment reference list. The list contents are of type
    * {@link org.umlmda.generator.profile.Stereotype}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Stereotypes</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Stereotypes</em>' containment reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_Stereotypes()
    * @model type="org.umlmda.generator.profile.Stereotype" containment="true"
    * @generated
    */
   List getStereotypes();

   /**
    * Returns the value of the '<em><b>Artefacts</b></em>' containment reference list. The list contents are of type
    * {@link org.umlmda.generator.profile.Artefact}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Artefacts</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Artefacts</em>' containment reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_Artefacts()
    * @model type="org.umlmda.generator.profile.Artefact" containment="true" required="true"
    * @generated
    */
   List getArtefacts();

   /**
    * Returns the value of the '<em><b>Default Properties</b></em>' containment reference list. The list contents are of type
    * {@link org.umlmda.generator.profile.Property}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Default Properties</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Default Properties</em>' containment reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_DefaultProperties()
    * @model type="org.umlmda.generator.profile.Property" containment="true"
    * @generated
    */
   List getDefaultProperties();

   /**
    * Returns the value of the '<em><b>Based On</b></em>' reference list. The list contents are of type
    * {@link org.umlmda.generator.profile.Profile}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Based On</em>' reference list isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Based On</em>' reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_BasedOn()
    * @model type="org.umlmda.generator.profile.Profile"
    * @generated
    */
   List getBasedOn();

   /**
    * Returns the value of the '<em><b>Meta Model Elements</b></em>' containment reference list. The list contents are of type
    * {@link org.umlmda.generator.profile.MetaModelElement}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Meta Model Elements</em>' containment reference list isn't clear, there really should be more of
    * a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Meta Model Elements</em>' containment reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getProfile_MetaModelElements()
    * @model type="org.umlmda.generator.profile.MetaModelElement" containment="true"
    * @generated
    */
   List getMetaModelElements();

} // Profile
