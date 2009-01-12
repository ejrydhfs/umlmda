/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmpSwitch.java,v 1.5 2006/06/24 19:07:55 moroff Exp $
 */
package org.umlmda.generator.profile.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.umlmda.generator.profile.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.profile.UmpPackage
 * @generated
 */
public class UmpSwitch {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * The cached model package
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static UmpPackage modelPackage;

   /**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UmpSwitch() {
      if (modelPackage == null) {
         modelPackage = UmpPackage.eINSTANCE;
      }
   }

   /**
    * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the first non-null result returned by a <code>caseXXX</code> call.
    * @generated
    */
   public Object doSwitch(EObject theEObject) {
      return doSwitch(theEObject.eClass(), theEObject);
   }

   /**
    * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the first non-null result returned by a <code>caseXXX</code> call.
    * @generated
    */
   protected Object doSwitch(EClass theEClass, EObject theEObject) {
      if (theEClass.eContainer() == modelPackage) {
         return doSwitch(theEClass.getClassifierID(), theEObject);
      }
      else {
         List eSuperTypes = theEClass.getESuperTypes();
         return
            eSuperTypes.isEmpty() ?
               defaultCase(theEObject) :
               doSwitch((EClass)eSuperTypes.get(0), theEObject);
      }
   }

   /**
    * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the first non-null result returned by a <code>caseXXX</code> call.
    * @generated
    */
   protected Object doSwitch(int classifierID, EObject theEObject) {
      switch (classifierID) {
         case UmpPackage.PROFILE: {
            Profile profile = (Profile)theEObject;
            Object result = caseProfile(profile);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case UmpPackage.STEREOTYPE: {
            Stereotype stereotype = (Stereotype)theEObject;
            Object result = caseStereotype(stereotype);
            if (result == null) result = caseAbstractMappingContainer(stereotype);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case UmpPackage.ARTEFACT: {
            Artefact artefact = (Artefact)theEObject;
            Object result = caseArtefact(artefact);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case UmpPackage.MAPPING: {
            Mapping mapping = (Mapping)theEObject;
            Object result = caseMapping(mapping);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case UmpPackage.PROPERTY: {
            Property property = (Property)theEObject;
            Object result = caseProperty(property);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case UmpPackage.META_MODEL_ELEMENT: {
            MetaModelElement metaModelElement = (MetaModelElement)theEObject;
            Object result = caseMetaModelElement(metaModelElement);
            if (result == null) result = caseAbstractMappingContainer(metaModelElement);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         default: return defaultCase(theEObject);
      }
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>Profile</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>Profile</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public Object caseProfile(Profile object) {
      return null;
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>Stereotype</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>Stereotype</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public Object caseStereotype(Stereotype object) {
      return null;
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>Artefact</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>Artefact</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public Object caseArtefact(Artefact object) {
      return null;
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>Mapping</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>Mapping</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public Object caseMapping(Mapping object) {
      return null;
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>Property</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>Property</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public Object caseProperty(Property object) {
      return null;
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>Meta Model Element</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>Meta Model Element</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public Object caseMetaModelElement(MetaModelElement object) {
      return null;
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>Abstract Mapping Container</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>Abstract Mapping Container</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public Object caseAbstractMappingContainer(AbstractMappingContainer object) {
      return null;
   }

   /**
    * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch, but this is the last case anyway.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject)
    * @generated
    */
   public Object defaultCase(EObject object) {
      return null;
   }

} //UmpSwitch
