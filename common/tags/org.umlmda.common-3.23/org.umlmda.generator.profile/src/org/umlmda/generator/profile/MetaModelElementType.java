/**
 * <copyright>
 * </copyright>
 *
 * $Id: MetaModelElementType.java,v 1.1 2006/06/24 19:07:54 moroff Exp $
 */
package org.umlmda.generator.profile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Meta Model Element Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.profile.UmpPackage#getMetaModelElementType()
 * @model
 * @generated
 */
public final class MetaModelElementType extends AbstractEnumerator {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * The '<em><b>Model</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #MODEL_LITERAL
    * @model name="Model"
    * @generated
    * @ordered
    */
   public static final int MODEL = 0;

   /**
    * The '<em><b>Package</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #PACKAGE_LITERAL
    * @model name="Package"
    * @generated
    * @ordered
    */
   public static final int PACKAGE = 1;

   /**
    * The '<em><b>Class</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #CLASS_LITERAL
    * @model name="Class"
    * @generated
    * @ordered
    */
   public static final int CLASS = 2;

   /**
    * The '<em><b>Model</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Model</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @see #MODEL
    * @generated
    * @ordered
    */
   public static final MetaModelElementType MODEL_LITERAL = new MetaModelElementType(MODEL, "Model");

   /**
    * The '<em><b>Package</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Package</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @see #PACKAGE
    * @generated
    * @ordered
    */
   public static final MetaModelElementType PACKAGE_LITERAL = new MetaModelElementType(PACKAGE, "Package");

   /**
    * The '<em><b>Class</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Class</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @see #CLASS
    * @generated
    * @ordered
    */
   public static final MetaModelElementType CLASS_LITERAL = new MetaModelElementType(CLASS, "Class");

   /**
    * An array of all the '<em><b>Meta Model Element Type</b></em>' enumerators.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static final MetaModelElementType[] VALUES_ARRAY =
      new MetaModelElementType[] {
         MODEL_LITERAL,
         PACKAGE_LITERAL,
         CLASS_LITERAL,
      };

   /**
    * A public read-only list of all the '<em><b>Meta Model Element Type</b></em>' enumerators.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

   /**
    * Returns the '<em><b>Meta Model Element Type</b></em>' literal with the specified name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static MetaModelElementType get(String name) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
         MetaModelElementType result = VALUES_ARRAY[i];
         if (result.toString().equals(name)) {
            return result;
         }
      }
      return null;
   }

   /**
    * Returns the '<em><b>Meta Model Element Type</b></em>' literal with the specified value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static MetaModelElementType get(int value) {
      switch (value) {
         case MODEL: return MODEL_LITERAL;
         case PACKAGE: return PACKAGE_LITERAL;
         case CLASS: return CLASS_LITERAL;
      }
      return null;	
   }

   /**
    * Only this class can construct instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private MetaModelElementType(int value, String name) {
      super(value, name);
   }

} //MetaModelElementType
