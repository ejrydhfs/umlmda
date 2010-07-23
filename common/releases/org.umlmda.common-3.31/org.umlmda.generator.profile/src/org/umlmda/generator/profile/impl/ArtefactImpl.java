/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.util.Properties;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.NamespaceUsage;
import org.umlmda.generator.profile.Property;
import org.umlmda.generator.profile.UmpPackage;
import org.umlmda.generator.profile.WriterType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Artefact</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getName <em>Name</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getAlias <em>Alias</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getFilename <em>Filename</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getFileExtension <em>File Extension</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getPostfix <em>Postfix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getUseNamespace <em>Use Namespace</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getNamespacePrefix <em>Namespace Prefix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getNamespacePostfix <em>Namespace Postfix</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getReplacement <em>Replacement</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getReplacementPattern <em>Replacement Pattern</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getType <em>Type</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getWriter <em>Writer</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getProperties <em>Properties</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getGenerationStrategy <em>Generation Strategy</em>}</li>
 * <li>{@link org.umlmda.generator.profile.impl.ArtefactImpl#getDefaultProperties <em>Default Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ArtefactImpl extends EObjectImpl implements Artefact
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String            copyright                    = "www.umlmda.org";

   /**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getName()
    * @generated
    * @ordered
    */
   protected static final String         NAME_EDEFAULT                = null;

   /**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getName()
    * @generated
    * @ordered
    */
   protected String                      name                         = NAME_EDEFAULT;

   /**
    * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getAlias()
    * @generated
    * @ordered
    */
   protected static final String         ALIAS_EDEFAULT               = null;

   /**
    * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getAlias()
    * @generated
    * @ordered
    */
   protected String                      alias                        = ALIAS_EDEFAULT;

   /**
    * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected static final String         DESCRIPTION_EDEFAULT         = null;

   /**
    * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getDescription()
    * @generated
    * @ordered
    */
   protected String                      description                  = DESCRIPTION_EDEFAULT;

   /**
    * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getFilename()
    * @generated
    * @ordered
    */
   protected static final String         FILENAME_EDEFAULT            = null;

   /**
    * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getFilename()
    * @generated
    * @ordered
    */
   protected String                      filename                     = FILENAME_EDEFAULT;

   /**
    * The default value of the '{@link #getFileExtension() <em>File Extension</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getFileExtension()
    * @generated
    * @ordered
    */
   protected static final String         FILE_EXTENSION_EDEFAULT      = null;

   /**
    * The cached value of the '{@link #getFileExtension() <em>File Extension</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getFileExtension()
    * @generated
    * @ordered
    */
   protected String                      fileExtension                = FILE_EXTENSION_EDEFAULT;

   /**
    * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getPrefix()
    * @generated
    * @ordered
    */
   protected static final String         PREFIX_EDEFAULT              = null;

   /**
    * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getPrefix()
    * @generated
    * @ordered
    */
   protected String                      prefix                       = PREFIX_EDEFAULT;

   /**
    * The default value of the '{@link #getPostfix() <em>Postfix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getPostfix()
    * @generated
    * @ordered
    */
   protected static final String         POSTFIX_EDEFAULT             = null;

   /**
    * The cached value of the '{@link #getPostfix() <em>Postfix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getPostfix()
    * @generated
    * @ordered
    */
   protected String                      postfix                      = POSTFIX_EDEFAULT;

   /**
    * The default value of the '{@link #getUseNamespace() <em>Use Namespace</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getUseNamespace()
    * @generated
    * @ordered
    */
   protected static final NamespaceUsage USE_NAMESPACE_EDEFAULT       = NamespaceUsage.TRUE_LITERAL;

   /**
    * The cached value of the '{@link #getUseNamespace() <em>Use Namespace</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getUseNamespace()
    * @generated
    * @ordered
    */
   protected NamespaceUsage              useNamespace                 = USE_NAMESPACE_EDEFAULT;

   /**
    * The default value of the '{@link #getNamespacePrefix() <em>Namespace Prefix</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getNamespacePrefix()
    * @generated
    * @ordered
    */
   protected static final String         NAMESPACE_PREFIX_EDEFAULT    = null;

   /**
    * The cached value of the '{@link #getNamespacePrefix() <em>Namespace Prefix</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getNamespacePrefix()
    * @generated
    * @ordered
    */
   protected String                      namespacePrefix              = NAMESPACE_PREFIX_EDEFAULT;

   /**
    * The default value of the '{@link #getNamespacePostfix() <em>Namespace Postfix</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getNamespacePostfix()
    * @generated
    * @ordered
    */
   protected static final String         NAMESPACE_POSTFIX_EDEFAULT   = null;

   /**
    * The cached value of the '{@link #getNamespacePostfix() <em>Namespace Postfix</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getNamespacePostfix()
    * @generated
    * @ordered
    */
   protected String                      namespacePostfix             = NAMESPACE_POSTFIX_EDEFAULT;

   /**
    * The default value of the '{@link #getReplacement() <em>Replacement</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getReplacement()
    * @generated
    * @ordered
    */
   protected static final String         REPLACEMENT_EDEFAULT         = null;

   /**
    * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' attribute. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @see #getReplacement()
    * @generated
    * @ordered
    */
   protected String                      replacement                  = REPLACEMENT_EDEFAULT;

   /**
    * The default value of the '{@link #getReplacementPattern() <em>Replacement Pattern</em>}' attribute. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getReplacementPattern()
    * @generated
    * @ordered
    */
   protected static final String         REPLACEMENT_PATTERN_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getReplacementPattern() <em>Replacement Pattern</em>}' attribute. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getReplacementPattern()
    * @generated
    * @ordered
    */
   protected String                      replacementPattern           = REPLACEMENT_PATTERN_EDEFAULT;

   /**
    * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getType()
    * @generated
    * @ordered
    */
   protected static final WriterType     TYPE_EDEFAULT                = WriterType.JOSTRACA_LITERAL;

   /**
    * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getType()
    * @generated
    * @ordered
    */
   protected WriterType                  type                         = TYPE_EDEFAULT;

   /**
    * The default value of the '{@link #getWriter() <em>Writer</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getWriter()
    * @generated
    * @ordered
    */
   protected static final String         WRITER_EDEFAULT              = null;

   /**
    * The cached value of the '{@link #getWriter() <em>Writer</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getWriter()
    * @generated
    * @ordered
    */
   protected String                      writer                       = WRITER_EDEFAULT;

   /**
    * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @see #getProperties()
    * @generated
    * @ordered
    */
   protected static final Properties     PROPERTIES_EDEFAULT          = null;

   /**
    * The default value of the '{@link #getGenerationStrategy() <em>Generation Strategy</em>}' attribute. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getGenerationStrategy()
    * @generated
    * @ordered
    */
   protected static final String         GENERATION_STRATEGY_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getGenerationStrategy() <em>Generation Strategy</em>}' attribute. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getGenerationStrategy()
    * @generated
    * @ordered
    */
   protected String                      generationStrategy           = GENERATION_STRATEGY_EDEFAULT;

   /**
    * The cached value of the '{@link #getDefaultProperties() <em>Default Properties</em>}' containment reference list. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #getDefaultProperties()
    * @generated
    * @ordered
    */
   protected EList                       defaultProperties            = null;

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected ArtefactImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EClass eStaticClass() {
      return UmpPackage.eINSTANCE.getArtefact();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getName() {
      return name;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setName(String newName) {
      String oldName = name;
      name = newName;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__NAME, oldName, name));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getAlias() {
      return alias;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setAlias(String newAlias) {
      String oldAlias = alias;
      alias = newAlias;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__ALIAS, oldAlias, alias));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getDescription() {
      return description;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setDescription(String newDescription) {
      String oldDescription = description;
      description = newDescription;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__DESCRIPTION, oldDescription, description));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getFilename() {
      return filename;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setFilename(String newFilename) {
      String oldFilename = filename;
      filename = newFilename;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__FILENAME, oldFilename, filename));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getFileExtension() {
      return fileExtension;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setFileExtension(String newFileExtension) {
      String oldFileExtension = fileExtension;
      fileExtension = newFileExtension;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__FILE_EXTENSION, oldFileExtension,
               fileExtension));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getPrefix() {
      return prefix;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setPrefix(String newPrefix) {
      String oldPrefix = prefix;
      prefix = newPrefix;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__PREFIX, oldPrefix, prefix));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getPostfix() {
      return postfix;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setPostfix(String newPostfix) {
      String oldPostfix = postfix;
      postfix = newPostfix;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__POSTFIX, oldPostfix, postfix));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public NamespaceUsage getUseNamespace() {
      return useNamespace;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setUseNamespace(NamespaceUsage newUseNamespace) {
      NamespaceUsage oldUseNamespace = useNamespace;
      useNamespace = newUseNamespace == null ? USE_NAMESPACE_EDEFAULT : newUseNamespace;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__USE_NAMESPACE, oldUseNamespace, useNamespace));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getNamespacePrefix() {
      return namespacePrefix;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setNamespacePrefix(String newNamespacePrefix) {
      String oldNamespacePrefix = namespacePrefix;
      namespacePrefix = newNamespacePrefix;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__NAMESPACE_PREFIX, oldNamespacePrefix,
               namespacePrefix));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getNamespacePostfix() {
      return namespacePostfix;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setNamespacePostfix(String newNamespacePostfix) {
      String oldNamespacePostfix = namespacePostfix;
      namespacePostfix = newNamespacePostfix;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__NAMESPACE_POSTFIX, oldNamespacePostfix,
               namespacePostfix));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getReplacement() {
      return replacement;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setReplacement(String newReplacement) {
      String oldReplacement = replacement;
      replacement = newReplacement;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__REPLACEMENT, oldReplacement, replacement));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getReplacementPattern() {
      return replacementPattern;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setReplacementPattern(String newReplacementPattern) {
      String oldReplacementPattern = replacementPattern;
      replacementPattern = newReplacementPattern;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__REPLACEMENT_PATTERN, oldReplacementPattern,
               replacementPattern));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public WriterType getType() {
      return type;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setType(WriterType newType) {
      WriterType oldType = type;
      type = newType == null ? TYPE_EDEFAULT : newType;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__TYPE, oldType, type));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getWriter() {
      return writer;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setWriter(String newWriter) {
      String oldWriter = writer;
      writer = newWriter;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__WRITER, oldWriter, writer));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated NOT
    */
   public Properties getProperties() {
      Properties properties = new Properties();

      for ( Iterator ip = getDefaultProperties().iterator(); ip.hasNext(); ) {
         Property property = (Property) ip.next();

         properties.put(property.getName(), property.getValue());
      }
      return properties;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String getGenerationStrategy() {
      return generationStrategy;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setGenerationStrategy(String newGenerationStrategy) {
      String oldGenerationStrategy = generationStrategy;
      generationStrategy = newGenerationStrategy;
      if ( eNotificationRequired() )
         eNotify(new ENotificationImpl(this, Notification.SET, UmpPackage.ARTEFACT__GENERATION_STRATEGY, oldGenerationStrategy,
               generationStrategy));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public List getDefaultProperties() {
      if ( defaultProperties == null ) {
         defaultProperties = new EObjectContainmentEList(Property.class, this, UmpPackage.ARTEFACT__DEFAULT_PROPERTIES);
      }
      return defaultProperties;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
      if ( featureID >= 0 ) {
         switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
         case UmpPackage.ARTEFACT__DEFAULT_PROPERTIES:
            return ((InternalEList) getDefaultProperties()).basicRemove(otherEnd, msgs);
         default:
            return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
         }
      }
      return eBasicSetContainer(null, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Object eGet(EStructuralFeature eFeature, boolean resolve) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.ARTEFACT__NAME:
         return getName();
      case UmpPackage.ARTEFACT__ALIAS:
         return getAlias();
      case UmpPackage.ARTEFACT__DESCRIPTION:
         return getDescription();
      case UmpPackage.ARTEFACT__FILENAME:
         return getFilename();
      case UmpPackage.ARTEFACT__FILE_EXTENSION:
         return getFileExtension();
      case UmpPackage.ARTEFACT__PREFIX:
         return getPrefix();
      case UmpPackage.ARTEFACT__POSTFIX:
         return getPostfix();
      case UmpPackage.ARTEFACT__USE_NAMESPACE:
         return getUseNamespace();
      case UmpPackage.ARTEFACT__NAMESPACE_PREFIX:
         return getNamespacePrefix();
      case UmpPackage.ARTEFACT__NAMESPACE_POSTFIX:
         return getNamespacePostfix();
      case UmpPackage.ARTEFACT__REPLACEMENT:
         return getReplacement();
      case UmpPackage.ARTEFACT__REPLACEMENT_PATTERN:
         return getReplacementPattern();
      case UmpPackage.ARTEFACT__TYPE:
         return getType();
      case UmpPackage.ARTEFACT__WRITER:
         return getWriter();
      case UmpPackage.ARTEFACT__PROPERTIES:
         return getProperties();
      case UmpPackage.ARTEFACT__GENERATION_STRATEGY:
         return getGenerationStrategy();
      case UmpPackage.ARTEFACT__DEFAULT_PROPERTIES:
         return getDefaultProperties();
      }
      return eDynamicGet(eFeature, resolve);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void eSet(EStructuralFeature eFeature, Object newValue) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.ARTEFACT__NAME:
         setName((String) newValue);
         return;
      case UmpPackage.ARTEFACT__ALIAS:
         setAlias((String) newValue);
         return;
      case UmpPackage.ARTEFACT__DESCRIPTION:
         setDescription((String) newValue);
         return;
      case UmpPackage.ARTEFACT__FILENAME:
         setFilename((String) newValue);
         return;
      case UmpPackage.ARTEFACT__FILE_EXTENSION:
         setFileExtension((String) newValue);
         return;
      case UmpPackage.ARTEFACT__PREFIX:
         setPrefix((String) newValue);
         return;
      case UmpPackage.ARTEFACT__POSTFIX:
         setPostfix((String) newValue);
         return;
      case UmpPackage.ARTEFACT__USE_NAMESPACE:
         setUseNamespace((NamespaceUsage) newValue);
         return;
      case UmpPackage.ARTEFACT__NAMESPACE_PREFIX:
         setNamespacePrefix((String) newValue);
         return;
      case UmpPackage.ARTEFACT__NAMESPACE_POSTFIX:
         setNamespacePostfix((String) newValue);
         return;
      case UmpPackage.ARTEFACT__REPLACEMENT:
         setReplacement((String) newValue);
         return;
      case UmpPackage.ARTEFACT__REPLACEMENT_PATTERN:
         setReplacementPattern((String) newValue);
         return;
      case UmpPackage.ARTEFACT__TYPE:
         setType((WriterType) newValue);
         return;
      case UmpPackage.ARTEFACT__WRITER:
         setWriter((String) newValue);
         return;
      case UmpPackage.ARTEFACT__GENERATION_STRATEGY:
         setGenerationStrategy((String) newValue);
         return;
      case UmpPackage.ARTEFACT__DEFAULT_PROPERTIES:
         getDefaultProperties().clear();
         getDefaultProperties().addAll((Collection) newValue);
         return;
      }
      eDynamicSet(eFeature, newValue);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void eUnset(EStructuralFeature eFeature) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.ARTEFACT__NAME:
         setName(NAME_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__ALIAS:
         setAlias(ALIAS_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__DESCRIPTION:
         setDescription(DESCRIPTION_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__FILENAME:
         setFilename(FILENAME_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__FILE_EXTENSION:
         setFileExtension(FILE_EXTENSION_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__PREFIX:
         setPrefix(PREFIX_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__POSTFIX:
         setPostfix(POSTFIX_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__USE_NAMESPACE:
         setUseNamespace(USE_NAMESPACE_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__NAMESPACE_PREFIX:
         setNamespacePrefix(NAMESPACE_PREFIX_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__NAMESPACE_POSTFIX:
         setNamespacePostfix(NAMESPACE_POSTFIX_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__REPLACEMENT:
         setReplacement(REPLACEMENT_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__REPLACEMENT_PATTERN:
         setReplacementPattern(REPLACEMENT_PATTERN_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__TYPE:
         setType(TYPE_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__WRITER:
         setWriter(WRITER_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__GENERATION_STRATEGY:
         setGenerationStrategy(GENERATION_STRATEGY_EDEFAULT);
         return;
      case UmpPackage.ARTEFACT__DEFAULT_PROPERTIES:
         getDefaultProperties().clear();
         return;
      }
      eDynamicUnset(eFeature);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public boolean eIsSet(EStructuralFeature eFeature) {
      switch (eDerivedStructuralFeatureID(eFeature)) {
      case UmpPackage.ARTEFACT__NAME:
         return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmpPackage.ARTEFACT__ALIAS:
         return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
      case UmpPackage.ARTEFACT__DESCRIPTION:
         return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case UmpPackage.ARTEFACT__FILENAME:
         return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
      case UmpPackage.ARTEFACT__FILE_EXTENSION:
         return FILE_EXTENSION_EDEFAULT == null ? fileExtension != null : !FILE_EXTENSION_EDEFAULT.equals(fileExtension);
      case UmpPackage.ARTEFACT__PREFIX:
         return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
      case UmpPackage.ARTEFACT__POSTFIX:
         return POSTFIX_EDEFAULT == null ? postfix != null : !POSTFIX_EDEFAULT.equals(postfix);
      case UmpPackage.ARTEFACT__USE_NAMESPACE:
         return useNamespace != USE_NAMESPACE_EDEFAULT;
      case UmpPackage.ARTEFACT__NAMESPACE_PREFIX:
         return NAMESPACE_PREFIX_EDEFAULT == null ? namespacePrefix != null : !NAMESPACE_PREFIX_EDEFAULT.equals(namespacePrefix);
      case UmpPackage.ARTEFACT__NAMESPACE_POSTFIX:
         return NAMESPACE_POSTFIX_EDEFAULT == null ? namespacePostfix != null : !NAMESPACE_POSTFIX_EDEFAULT
               .equals(namespacePostfix);
      case UmpPackage.ARTEFACT__REPLACEMENT:
         return REPLACEMENT_EDEFAULT == null ? replacement != null : !REPLACEMENT_EDEFAULT.equals(replacement);
      case UmpPackage.ARTEFACT__REPLACEMENT_PATTERN:
         return REPLACEMENT_PATTERN_EDEFAULT == null ? replacementPattern != null : !REPLACEMENT_PATTERN_EDEFAULT
               .equals(replacementPattern);
      case UmpPackage.ARTEFACT__TYPE:
         return type != TYPE_EDEFAULT;
      case UmpPackage.ARTEFACT__WRITER:
         return WRITER_EDEFAULT == null ? writer != null : !WRITER_EDEFAULT.equals(writer);
      case UmpPackage.ARTEFACT__PROPERTIES:
         return PROPERTIES_EDEFAULT == null ? getProperties() != null : !PROPERTIES_EDEFAULT.equals(getProperties());
      case UmpPackage.ARTEFACT__GENERATION_STRATEGY:
         return GENERATION_STRATEGY_EDEFAULT == null ? generationStrategy != null : !GENERATION_STRATEGY_EDEFAULT
               .equals(generationStrategy);
      case UmpPackage.ARTEFACT__DEFAULT_PROPERTIES:
         return defaultProperties != null && !defaultProperties.isEmpty();
      }
      return eDynamicIsSet(eFeature);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public String toString() {
      if ( eIsProxy() )
         return super.toString();

      StringBuffer result = new StringBuffer(super.toString());
      result.append(" (name: ");
      result.append(name);
      result.append(", alias: ");
      result.append(alias);
      result.append(", description: ");
      result.append(description);
      result.append(", filename: ");
      result.append(filename);
      result.append(", fileExtension: ");
      result.append(fileExtension);
      result.append(", prefix: ");
      result.append(prefix);
      result.append(", postfix: ");
      result.append(postfix);
      result.append(", useNamespace: ");
      result.append(useNamespace);
      result.append(", namespacePrefix: ");
      result.append(namespacePrefix);
      result.append(", namespacePostfix: ");
      result.append(namespacePostfix);
      result.append(", replacement: ");
      result.append(replacement);
      result.append(", replacementPattern: ");
      result.append(replacementPattern);
      result.append(", type: ");
      result.append(type);
      result.append(", writer: ");
      result.append(writer);
      result.append(", generationStrategy: ");
      result.append(generationStrategy);
      result.append(')');
      return result.toString();
   }

} // ArtefactImpl
