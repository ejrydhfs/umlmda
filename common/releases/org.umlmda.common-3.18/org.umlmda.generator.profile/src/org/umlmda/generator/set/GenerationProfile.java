/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenerationProfile.java,v 1.5 2005/11/08 08:06:52 moroff Exp $
 */
package org.umlmda.generator.set;

import java.util.List;

import org.umlmda.generator.profile.Profile;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generation Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.umlmda.generator.set.GenerationProfile#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.umlmda.generator.set.GenerationProfile#getPackagePrefix <em>Package Prefix</em>}</li>
 *   <li>{@link org.umlmda.generator.set.GenerationProfile#isActive <em>Active</em>}</li>
 *   <li>{@link org.umlmda.generator.set.GenerationProfile#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.umlmda.generator.set.GenerationProfile#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.umlmda.generator.set.UmsPackage#getGenerationProfile()
 * @model 
 * @generated
 */
public interface GenerationProfile {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * Returns the value of the '<em><b>Destination</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Destination</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Destination</em>' attribute.
    * @see #setDestination(String)
    * @see org.umlmda.generator.set.UmsPackage#getGenerationProfile_Destination()
    * @model 
    * @generated
    */
   String getDestination();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationProfile#getDestination <em>Destination</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Destination</em>' attribute.
    * @see #getDestination()
    * @generated
    */
   void setDestination(String value);

   /**
    * Returns the value of the '<em><b>Package Prefix</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Package Prefix</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Package Prefix</em>' attribute.
    * @see #setPackagePrefix(String)
    * @see org.umlmda.generator.set.UmsPackage#getGenerationProfile_PackagePrefix()
    * @model 
    * @generated
    */
   String getPackagePrefix();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationProfile#getPackagePrefix <em>Package Prefix</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Package Prefix</em>' attribute.
    * @see #getPackagePrefix()
    * @generated
    */
   void setPackagePrefix(String value);

   /**
    * Returns the value of the '<em><b>Active</b></em>' attribute.
    * The default value is <code>"true"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Active</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Active</em>' attribute.
    * @see #setActive(boolean)
    * @see org.umlmda.generator.set.UmsPackage#getGenerationProfile_Active()
    * @model default="true"
    * @generated
    */
   boolean isActive();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationProfile#isActive <em>Active</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Active</em>' attribute.
    * @see #isActive()
    * @generated
    */
   void setActive(boolean value);

   /**
    * Returns the value of the '<em><b>Profile</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Profile</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Profile</em>' reference.
    * @see #setProfile(Profile)
    * @see org.umlmda.generator.set.UmsPackage#getGenerationProfile_Profile()
    * @model required="true"
    * @generated
    */
   Profile getProfile();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationProfile#getProfile <em>Profile</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Profile</em>' reference.
    * @see #getProfile()
    * @generated
    */
   void setProfile(Profile value);

   /**
    * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
    * The list contents are of type {@link org.umlmda.generator.profile.Property}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Properties</em>' containment reference list.
    * @see org.umlmda.generator.set.UmsPackage#getGenerationProfile_Properties()
    * @model type="org.umlmda.generator.profile.Property" containment="true"
    * @generated
    */
   List getProperties();

} // GenerationProfile
