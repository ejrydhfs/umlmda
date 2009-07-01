/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmpFactoryImpl.java,v 1.7 2006/06/24 19:07:54 moroff Exp $
 */
package org.umlmda.generator.profile.impl;

import java.util.Properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.umlmda.generator.profile.*;

import org.umlmda.model.uml.ModelElementBase;

import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.profile.Property;
import org.umlmda.generator.profile.Stereotype;
import org.umlmda.generator.profile.UmpFactory;
import org.umlmda.generator.profile.UmpPackage;
import org.umlmda.generator.profile.WriterType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmpFactoryImpl extends EFactoryImpl implements UmpFactory {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * Creates and instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UmpFactoryImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EObject create(EClass eClass) {
      switch (eClass.getClassifierID()) {
         case UmpPackage.PROFILE: return (EObject)createProfile();
         case UmpPackage.STEREOTYPE: return (EObject)createStereotype();
         case UmpPackage.ARTEFACT: return (EObject)createArtefact();
         case UmpPackage.MAPPING: return (EObject)createMapping();
         case UmpPackage.PROPERTY: return (EObject)createProperty();
         case UmpPackage.META_MODEL_ELEMENT: return (EObject)createMetaModelElement();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Object createFromString(EDataType eDataType, String initialValue) {
      switch (eDataType.getClassifierID()) {
         case UmpPackage.WRITER_TYPE: {
            WriterType result = WriterType.get(initialValue);
            if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
            return result;
         }
         case UmpPackage.NAMESPACE_USAGE: {
            NamespaceUsage result = NamespaceUsage.get(initialValue);
            if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
            return result;
         }
         case UmpPackage.META_MODEL_ELEMENT_TYPE: {
            MetaModelElementType result = MetaModelElementType.get(initialValue);
            if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
            return result;
         }
         case UmpPackage.PROPERTIES:
            return createPropertiesFromString(eDataType, initialValue);
         case UmpPackage.MODEL_ELEMENT:
            return createModelElementFromString(eDataType, initialValue);
         default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String convertToString(EDataType eDataType, Object instanceValue) {
      switch (eDataType.getClassifierID()) {
         case UmpPackage.WRITER_TYPE:
            return instanceValue == null ? null : instanceValue.toString();
         case UmpPackage.NAMESPACE_USAGE:
            return instanceValue == null ? null : instanceValue.toString();
         case UmpPackage.META_MODEL_ELEMENT_TYPE:
            return instanceValue == null ? null : instanceValue.toString();
         case UmpPackage.PROPERTIES:
            return convertPropertiesToString(eDataType, instanceValue);
         case UmpPackage.MODEL_ELEMENT:
            return convertModelElementToString(eDataType, instanceValue);
         default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Profile createProfile() {
      ProfileImpl profile = new ProfileImpl();
      return profile;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Stereotype createStereotype() {
      StereotypeImpl stereotype = new StereotypeImpl();
      return stereotype;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Artefact createArtefact() {
      ArtefactImpl artefact = new ArtefactImpl();
      return artefact;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Mapping createMapping() {
      MappingImpl mapping = new MappingImpl();
      return mapping;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Property createProperty() {
      PropertyImpl property = new PropertyImpl();
      return property;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public MetaModelElement createMetaModelElement() {
      MetaModelElementImpl metaModelElement = new MetaModelElementImpl();
      return metaModelElement;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Properties createPropertiesFromString(EDataType eDataType, String initialValue) {
      return (Properties)super.createFromString(eDataType, initialValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String convertPropertiesToString(EDataType eDataType, Object instanceValue) {
      return super.convertToString(eDataType, instanceValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ModelElementBase createModelElementFromString(EDataType eDataType, String initialValue) {
      return (ModelElementBase)super.createFromString(eDataType, initialValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String convertModelElementToString(EDataType eDataType, Object instanceValue) {
      return super.convertToString(eDataType, instanceValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UmpPackage getUmpPackage() {
      return (UmpPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   public static UmpPackage getPackage() {
      return UmpPackage.eINSTANCE;
   }

} //UmpFactoryImpl
