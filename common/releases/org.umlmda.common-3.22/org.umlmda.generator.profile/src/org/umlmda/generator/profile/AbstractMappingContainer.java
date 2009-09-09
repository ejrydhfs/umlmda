/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMappingContainer.java,v 1.1 2006/06/24 19:07:54 moroff Exp $
 */
package org.umlmda.generator.profile;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Mapping Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.umlmda.generator.profile.AbstractMappingContainer#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.umlmda.generator.profile.UmpPackage#getAbstractMappingContainer()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMappingContainer {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
    * The list contents are of type {@link org.umlmda.generator.profile.Mapping}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Mappings</em>' containment reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getAbstractMappingContainer_Mappings()
    * @model type="org.umlmda.generator.profile.Mapping" containment="true"
    * @generated
    */
   List getMappings();

} // AbstractMappingContainer
