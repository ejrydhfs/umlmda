/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile;

import java.util.List;

import java.util.Properties;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Artefact</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.Artefact#getName <em>Name</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getAlias <em>Alias</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getDescription <em>Description</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getFilename <em>Filename</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getFileExtension <em>File Extension</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getPostfix <em>Postfix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getUseNamespace <em>Use Namespace</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getNamespacePrefix <em>Namespace Prefix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getNamespacePostfix <em>Namespace Postfix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getReplacement <em>Replacement</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getReplacementPattern <em>Replacement Pattern</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getType <em>Type</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getWriter <em>Writer</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getProperties <em>Properties</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getGenerationStrategy <em>Generation Strategy</em>}</li>
 * <li>{@link org.umlmda.generator.profile.Artefact#getDefaultProperties <em>Default Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.umlmda.generator.profile.UmpPackage#getArtefact()
 * @model
 * @generated
 */
public interface Artefact
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
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Name()
    * @model
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getName <em>Name</em>}' attribute. <!-- begin-user-doc
    * --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
   void setName(String value);

   /**
    * Returns the value of the '<em><b>Alias</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Alias</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Alias</em>' attribute.
    * @see #setAlias(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Alias()
    * @model
    * @generated
    */
   String getAlias();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getAlias <em>Alias</em>}' attribute. <!-- begin-user-doc
    * --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Alias</em>' attribute.
    * @see #getAlias()
    * @generated
    */
   void setAlias(String value);

   /**
    * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Description</em>' attribute.
    * @see #setDescription(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Description()
    * @model
    * @generated
    */
   String getDescription();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getDescription <em>Description</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Description</em>' attribute.
    * @see #getDescription()
    * @generated
    */
   void setDescription(String value);

   /**
    * Returns the value of the '<em><b>Filename</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
    * begin-model-doc --> If filled, name of the generated file regardless of the model element name. Prefix, postfix and
    * replacement patterns are ignored. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>Filename</em>' attribute.
    * @see #setFilename(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Filename()
    * @model
    * @generated
    */
   String getFilename();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getFilename <em>Filename</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Filename</em>' attribute.
    * @see #getFilename()
    * @generated
    */
   void setFilename(String value);

   /**
    * Returns the value of the '<em><b>File Extension</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
    * begin-model-doc --> Name of the file extension, without an extension seperator. Not all writers (for example java writers)
    * support to change the file extension. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>File Extension</em>' attribute.
    * @see #setFileExtension(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_FileExtension()
    * @model
    * @generated
    */
   String getFileExtension();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getFileExtension <em>File Extension</em>}' attribute.
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>File Extension</em>' attribute.
    * @see #getFileExtension()
    * @generated
    */
   void setFileExtension(String value);

   /**
    * Returns the value of the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Prefix</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Prefix</em>' attribute.
    * @see #setPrefix(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Prefix()
    * @model
    * @generated
    */
   String getPrefix();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getPrefix <em>Prefix</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Prefix</em>' attribute.
    * @see #getPrefix()
    * @generated
    */
   void setPrefix(String value);

   /**
    * Returns the value of the '<em><b>Postfix</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Postfix</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Postfix</em>' attribute.
    * @see #setPostfix(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Postfix()
    * @model
    * @generated
    */
   String getPostfix();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getPostfix <em>Postfix</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Postfix</em>' attribute.
    * @see #getPostfix()
    * @generated
    */
   void setPostfix(String value);

   /**
    * Returns the value of the '<em><b>Use Namespace</b></em>' attribute. The default value is <code>"true"</code>. The literals
    * are from the enumeration {@link org.umlmda.generator.profile.NamespaceUsage}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Use Namespace</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Use Namespace</em>' attribute.
    * @see org.umlmda.generator.profile.NamespaceUsage
    * @see #setUseNamespace(NamespaceUsage)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_UseNamespace()
    * @model default="true"
    * @generated
    */
   NamespaceUsage getUseNamespace();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getUseNamespace <em>Use Namespace</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Use Namespace</em>' attribute.
    * @see org.umlmda.generator.profile.NamespaceUsage
    * @see #getUseNamespace()
    * @generated
    */
   void setUseNamespace(NamespaceUsage value);

   /**
    * Returns the value of the '<em><b>Namespace Prefix</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Namespace Prefix</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Namespace Prefix</em>' attribute.
    * @see #setNamespacePrefix(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_NamespacePrefix()
    * @model
    * @generated
    */
   String getNamespacePrefix();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getNamespacePrefix <em>Namespace Prefix</em>}'
    * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Namespace Prefix</em>' attribute.
    * @see #getNamespacePrefix()
    * @generated
    */
   void setNamespacePrefix(String value);

   /**
    * Returns the value of the '<em><b>Namespace Postfix</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Namespace Postfix</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Namespace Postfix</em>' attribute.
    * @see #setNamespacePostfix(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_NamespacePostfix()
    * @model
    * @generated
    */
   String getNamespacePostfix();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getNamespacePostfix <em>Namespace Postfix</em>}'
    * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Namespace Postfix</em>' attribute.
    * @see #getNamespacePostfix()
    * @generated
    */
   void setNamespacePostfix(String value);

   /**
    * Returns the value of the '<em><b>Replacement</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Replacement</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Replacement</em>' attribute.
    * @see #setReplacement(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Replacement()
    * @model
    * @generated
    */
   String getReplacement();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getReplacement <em>Replacement</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Replacement</em>' attribute.
    * @see #getReplacement()
    * @generated
    */
   void setReplacement(String value);

   /**
    * Returns the value of the '<em><b>Replacement Pattern</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Replacement Pattern</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Replacement Pattern</em>' attribute.
    * @see #setReplacementPattern(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_ReplacementPattern()
    * @model
    * @generated
    */
   String getReplacementPattern();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getReplacementPattern <em>Replacement Pattern</em>}'
    * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Replacement Pattern</em>' attribute.
    * @see #getReplacementPattern()
    * @generated
    */
   void setReplacementPattern(String value);

   /**
    * Returns the value of the '<em><b>Type</b></em>' attribute. The default value is <code>"Jostraca"</code>. The literals are
    * from the enumeration {@link org.umlmda.generator.profile.WriterType}. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Type</em>' attribute.
    * @see org.umlmda.generator.profile.WriterType
    * @see #setType(WriterType)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Type()
    * @model default="Jostraca"
    * @generated
    */
   WriterType getType();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getType <em>Type</em>}' attribute. <!-- begin-user-doc
    * --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Type</em>' attribute.
    * @see org.umlmda.generator.profile.WriterType
    * @see #getType()
    * @generated
    */
   void setType(WriterType value);

   /**
    * Returns the value of the '<em><b>Writer</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
    * begin-model-doc --> Dependant on the type of the writer it is a ful qualified class implementing the writer or a template
    * file. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>Writer</em>' attribute.
    * @see #setWriter(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Writer()
    * @model
    * @generated
    */
   String getWriter();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getWriter <em>Writer</em>}' attribute. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Writer</em>' attribute.
    * @see #getWriter()
    * @generated
    */
   void setWriter(String value);

   /**
    * Returns the value of the '<em><b>Properties</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Properties</em>' attribute isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc --> <!-- begin-model-doc --> Standard property access. <!-- end-model-doc -->
    * 
    * @return the value of the '<em>Properties</em>' attribute.
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_Properties()
    * @model dataType="org.umlmda.generator.profile.Properties" transient="true" changeable="false" volatile="true"
    * @generated
    */
   Properties getProperties();

   /**
    * Returns the value of the '<em><b>Generation Strategy</b></em>' attribute. <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Generation Strategy</em>' attribute isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Generation Strategy</em>' attribute.
    * @see #setGenerationStrategy(String)
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_GenerationStrategy()
    * @model
    * @generated
    */
   String getGenerationStrategy();

   /**
    * Sets the value of the '{@link org.umlmda.generator.profile.Artefact#getGenerationStrategy <em>Generation Strategy</em>}'
    * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Generation Strategy</em>' attribute.
    * @see #getGenerationStrategy()
    * @generated
    */
   void setGenerationStrategy(String value);

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
    * @see org.umlmda.generator.profile.UmpPackage#getArtefact_DefaultProperties()
    * @model type="org.umlmda.generator.profile.Property" containment="true"
    * @generated
    */
   List getDefaultProperties();

} // Artefact
