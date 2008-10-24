/**
 * <copyright>
 * </copyright>
 *
 * $Id: NamespaceUsage.java,v 1.1 2005/11/08 08:06:52 moroff Exp $
 */
package org.umlmda.generator.profile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Namespace Usage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.umlmda.generator.profile.UmpPackage#getNamespaceUsage()
 * @model
 * @generated
 */
public final class NamespaceUsage extends AbstractEnumerator {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * The '<em><b>True</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #TRUE_LITERAL
    * @model name="true"
    * @generated
    * @ordered
    */
   public static final int TRUE = 0;

   /**
    * The '<em><b>Full Qualified</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #FULL_QUALIFIED_LITERAL
    * @model name="fullQualified"
    * @generated
    * @ordered
    */
   public static final int FULL_QUALIFIED = 1;

   /**
    * The '<em><b>Name Only</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #NAME_ONLY_LITERAL
    * @model name="nameOnly"
    * @generated
    * @ordered
    */
   public static final int NAME_ONLY = 2;

   /**
    * The '<em><b>False</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #FALSE_LITERAL
    * @model name="false"
    * @generated
    * @ordered
    */
   public static final int FALSE = 3;

   /**
    * The '<em><b>True</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * <!-- begin-model-doc -->
    * For compatibility only, equivalent with fullQualified.
    * <!-- end-model-doc -->
    * @see #TRUE
    * @generated
    * @ordered
    */
   public static final NamespaceUsage TRUE_LITERAL = new NamespaceUsage(TRUE, "true");

   /**
    * The '<em><b>Full Qualified</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * <!-- begin-model-doc -->
    * Use the full qualified name of the parent namespace to specify the outputfilepath.
    * <!-- end-model-doc -->
    * @see #FULL_QUALIFIED
    * @generated
    * @ordered
    */
   public static final NamespaceUsage FULL_QUALIFIED_LITERAL = new NamespaceUsage(FULL_QUALIFIED, "fullQualified");

   /**
    * The '<em><b>Name Only</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * <!-- begin-model-doc -->
    * Use the none qualified name of the parent namespace to specify the outputfilepath.
    * <!-- end-model-doc -->
    * @see #NAME_ONLY
    * @generated
    * @ordered
    */
   public static final NamespaceUsage NAME_ONLY_LITERAL = new NamespaceUsage(NAME_ONLY, "nameOnly");

   /**
    * The '<em><b>False</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * <!-- begin-model-doc -->
    * Do not use the name of the parent namespace to specify the outputfilepath.
    * <!-- end-model-doc -->
    * @see #FALSE
    * @generated
    * @ordered
    */
   public static final NamespaceUsage FALSE_LITERAL = new NamespaceUsage(FALSE, "false");

   /**
    * An array of all the '<em><b>Namespace Usage</b></em>' enumerators.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static final NamespaceUsage[] VALUES_ARRAY =
      new NamespaceUsage[] {
         TRUE_LITERAL,
         FULL_QUALIFIED_LITERAL,
         NAME_ONLY_LITERAL,
         FALSE_LITERAL,
      };

   /**
    * A public read-only list of all the '<em><b>Namespace Usage</b></em>' enumerators.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

   /**
    * Returns the '<em><b>Namespace Usage</b></em>' literal with the specified name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static NamespaceUsage get(String name) {
      for (int i = 0; i < VALUES_ARRAY.length; ++i) {
         NamespaceUsage result = VALUES_ARRAY[i];
         if (result.toString().equals(name)) {
            return result;
         }
      }
      return null;
   }

   /**
    * Returns the '<em><b>Namespace Usage</b></em>' literal with the specified value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static NamespaceUsage get(int value) {
      switch (value) {
         case TRUE: return TRUE_LITERAL;
         case FULL_QUALIFIED: return FULL_QUALIFIED_LITERAL;
         case NAME_ONLY: return NAME_ONLY_LITERAL;
         case FALSE: return FALSE_LITERAL;
      }
      return null;	
   }

   /**
    * Only this class can construct instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private NamespaceUsage(int value, String name) {
      super(value, name);
   }

} //NamespaceUsage
