/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.set;

import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Generation Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.umlmda.generator.set.GenerationSet#getName <em>Name</em>}</li>
 * <li>{@link org.umlmda.generator.set.GenerationSet#getDescription <em>Description</em>}</li>
 * <li>{@link org.umlmda.generator.set.GenerationSet#isExclusive <em>Exclusive</em>}</li>
 * <li>{@link org.umlmda.generator.set.GenerationSet#getTarget <em>Target</em>}</li>
 * <li>{@link org.umlmda.generator.set.GenerationSet#getModel <em>Model</em>}</li>
 * <li>{@link org.umlmda.generator.set.GenerationSet#getGenerationProfile <em>Generation Profile</em>}</li>
 * <li>{@link org.umlmda.generator.set.GenerationSet#getReferencedSets <em>Referenced Sets</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.umlmda.generator.set.UmsPackage#getGenerationSet()
 * @model
 * @generated
 */
public interface GenerationSet
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
    * @see org.umlmda.generator.set.UmsPackage#getGenerationSet_Name()
    * @model id="true"
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationSet#getName <em>Name</em>}' attribute. <!-- begin-user-doc
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
    * @see org.umlmda.generator.set.UmsPackage#getGenerationSet_Description()
    * @model
    * @generated
    */
   String getDescription();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationSet#getDescription <em>Description</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Description</em>' attribute.
    * @see #getDescription()
    * @generated
    */
   void setDescription(String value);

   /**
    * Returns the value of the '<em><b>Exclusive</b></em>' attribute. The default value is <code>"true"</code>. <!--
    * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> On exclusive models, the target and model used for
    * generation is written into the generationSet. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>Exclusive</em>' attribute.
    * @see #setExclusive(boolean)
    * @see org.umlmda.generator.set.UmsPackage#getGenerationSet_Exclusive()
    * @model default="true"
    * @generated
    */
   boolean isExclusive();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationSet#isExclusive <em>Exclusive</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Exclusive</em>' attribute.
    * @see #isExclusive()
    * @generated
    */
   void setExclusive(boolean value);

   /**
    * Returns the value of the '<em><b>Target</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
    * begin-model-doc --> Target of the generation, only filled on none exclusive sets. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>Target</em>' attribute.
    * @see #setTarget(String)
    * @see org.umlmda.generator.set.UmsPackage#getGenerationSet_Target()
    * @model
    * @generated
    */
   String getTarget();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationSet#getTarget <em>Target</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Target</em>' attribute.
    * @see #getTarget()
    * @generated
    */
   void setTarget(String value);

   /**
    * Returns the value of the '<em><b>Model</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
    * begin-model-doc --> Model source for the generation, only filled on none exclusive sets. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>Model</em>' attribute.
    * @see #setModel(String)
    * @see org.umlmda.generator.set.UmsPackage#getGenerationSet_Model()
    * @model
    * @generated
    */
   String getModel();

   /**
    * Sets the value of the '{@link org.umlmda.generator.set.GenerationSet#getModel <em>Model</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Model</em>' attribute.
    * @see #getModel()
    * @generated
    */
   void setModel(String value);

   /**
    * Returns the value of the '<em><b>Generation Profile</b></em>' containment reference list. The list contents are of type
    * {@link org.umlmda.generator.set.GenerationProfile}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Generation Profile</em>' containment reference list isn't clear, there really should be more of a
    * description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Generation Profile</em>' containment reference list.
    * @see org.umlmda.generator.set.UmsPackage#getGenerationSet_GenerationProfile()
    * @model type="org.umlmda.generator.set.GenerationProfile" containment="true" required="true"
    * @generated
    */
   List getGenerationProfile();

   /**
    * Returns the value of the '<em><b>Referenced Sets</b></em>' reference list. The list contents are of type
    * {@link org.umlmda.generator.set.GenerationSet}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Referenced Sets</em>' reference list isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Referenced Sets</em>' reference list.
    * @see org.umlmda.generator.set.UmsPackage#getGenerationSet_ReferencedSets()
    * @model type="org.umlmda.generator.set.GenerationSet"
    * @generated
    */
   List getReferencedSets();

} // GenerationSet
