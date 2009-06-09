/**
 * <copyright>
 * </copyright>
 *
 * $Id: MetaModelElement.java,v 1.1 2006/06/24 19:07:54 moroff Exp $
 */
package org.umlmda.generator.profile;


import org.umlmda.model.uml.ModelElementBase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.umlmda.generator.profile.MetaModelElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.umlmda.generator.profile.UmpPackage#getMetaModelElement()
 * @model 
 * @generated
 */
public interface MetaModelElement extends AbstractMappingContainer{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String copyright = "www.umlmda.org";

   /**
    * Returns the value of the '<em><b>Type</b></em>' attribute.
    * The literals are from the enumeration {@link org.umlmda.generator.profile.MetaModelElementType}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Type</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Type</em>' attribute.
    * @see org.umlmda.generator.profile.MetaModelElementType
    * @see #setType(MetaModelElementType)
    * @see org.umlmda.generator.profile.UmpPackage#getMetaModelElement_Type()
    * @model 
    * @generated
    */
   MetaModelElementType getType();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.MetaModelElement#getType <em>Type</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Type</em>' attribute.
    * @see org.umlmda.generator.profile.MetaModelElementType
    * @see #getType()
    * @generated
    */
   void setType(MetaModelElementType value);

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @model parameters="org.umlmda.generator.profile.ModelElement"
    * @generated
    */
   boolean match(ModelElementBase modelElement);

} // MetaModelElement
