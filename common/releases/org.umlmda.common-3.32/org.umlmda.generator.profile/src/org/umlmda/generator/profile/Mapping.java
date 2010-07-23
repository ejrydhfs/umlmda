/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile;

import java.util.List;

import java.util.Properties;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Mapping</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.Mapping#getProperties <em>Properties</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Mapping#getArtefact <em>Artefact</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Mapping#getSubMappings <em>Sub Mappings</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Mapping#getMappingProperties <em>Mapping Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.umlmda.generator.profile.UmpPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * Returns the value of the '<em><b>Artefact</b></em>' reference. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Artefact</em>' reference isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Artefact</em>' reference.
    * @see #setArtefact(Artefact)
    * @see org.umlmda.generator.profile.UmpPackage#getMapping_Artefact()
    * @model required="true"
    * @generated
    */
   Artefact getArtefact();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Mapping#getArtefact <em>Artefact</em>}' reference. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Artefact</em>' reference.
    * @see #getArtefact()
    * @generated
    */
   void setArtefact(Artefact value);

   /**
    * Returns the value of the '<em><b>Sub Mappings</b></em>' containment reference list. The list contents are of type
    * {@link org.umlmda.generator.profile.AbstractMappingContainer}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Sub Mappings</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Sub Mappings</em>' containment reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getMapping_SubMappings()
    * @model type="org.umlmda.generator.profile.AbstractMappingContainer" containment="true"
    * @generated
    */
   List getSubMappings();

   /**
    * Returns the value of the '<em><b>Mapping Properties</b></em>' containment reference list. The list contents are of type
    * {@link org.umlmda.generator.profile.Property}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Mapping Properties</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Mapping Properties</em>' containment reference list.
    * @see org.umlmda.generator.profile.UmpPackage#getMapping_MappingProperties()
    * @model type="org.umlmda.generator.profile.Property" containment="true"
    * @generated
    */
   List getMappingProperties();

   /**
    * Returns the value of the '<em><b>Properties</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Properties</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc --> <!-- begin-model-doc --> Standard property access, contains mappingProperties and defaultProperties of
    * the artefact. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>Properties</em>' attribute.
    * @see org.umlmda.generator.profile.UmpPackage#getMapping_Properties()
    * @model dataType="org.umlmda.generator.profile.Properties" transient="true" changeable="false" volatile="true"
    * @generated
    */
   Properties getProperties();

} // Mapping
