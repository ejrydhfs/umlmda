/**
 * <copyright>
 * </copyright>
 *
 * $Id: Stereotype.java,v 1.4 2006/06/24 19:07:54 moroff Exp $
 */
package org.umlmda.generator.profile;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.umlmda.generator.profile.Stereotype#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.umlmda.generator.profile.UmpPackage#getStereotype()
 * @model 
 * @generated
 */
public interface Stereotype extends AbstractMappingContainer {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * Returns the value of the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Name</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Name</em>' attribute.
    * @see #setName(String)
    * @see org.umlmda.generator.profile.UmpPackage#getStereotype_Name()
    * @model 
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Stereotype#getName <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
   void setName(String value);

} // Stereotype
