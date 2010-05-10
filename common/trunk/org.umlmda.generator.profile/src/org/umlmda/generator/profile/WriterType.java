/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Writer Type</b></em>', and utility methods
 * for working with them. <!-- end-user-doc -->
 * 
 * @see org.umlmda.generator.profile.UmpPackage#getWriterType()
 * @model
 * @generated
 */
public final class WriterType extends AbstractEnumerator
{
   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final String        copyright           = "www.umlmda.org";

   /**
    * The '<em><b>Jostraca</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #JOSTRACA_LITERAL
    * @model name="Jostraca"
    * @generated
    * @ordered
    */
   public static final int           JOSTRACA            = 0;

   /**
    * The '<em><b>Jet</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #JET_LITERAL
    * @model name="Jet"
    * @generated
    * @ordered
    */
   public static final int           JET                 = 1;

   /**
    * The '<em><b>Velocity</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #VELOCITY_LITERAL
    * @model name="Velocity"
    * @generated
    * @ordered
    */
   public static final int           VELOCITY            = 2;

   /**
    * The '<em><b>Free Marker</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #FREE_MARKER_LITERAL
    * @model name="FreeMarker"
    * @generated
    * @ordered
    */
   public static final int           FREE_MARKER         = 3;

   /**
    * The '<em><b>None</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #NONE_LITERAL
    * @model name="None"
    * @generated
    * @ordered
    */
   public static final int           NONE                = 4;

   /**
    * The '<em><b>Expand</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @see #EXPAND_LITERAL
    * @model name="Expand"
    * @generated
    * @ordered
    */
   public static final int           EXPAND              = 5;

   /**
    * The '<em><b>Jostraca</b></em>' literal object. <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Jostraca</b></em>' literal object isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc --> <!-- begin-model-doc -->
    * 
    * @link http://www.jostraca.org <!-- end-model-doc -->
    * @see #JOSTRACA
    * @generated
    * @ordered
    */
   public static final WriterType    JOSTRACA_LITERAL    = new WriterType(JOSTRACA, "Jostraca");

   /**
    * The '<em><b>Jet</b></em>' literal object. <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Jet</b></em>' literal object isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc --> <!-- begin-model-doc --> EMF Jet (Java Emitter Template) <!-- end-model-doc -->
    * 
    * @see #JET
    * @generated
    * @ordered
    */
   public static final WriterType    JET_LITERAL         = new WriterType(JET, "Jet");

   /**
    * The '<em><b>Velocity</b></em>' literal object. <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Velocity</b></em>' literal object isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc --> <!-- begin-model-doc -->
    * 
    * @link http://jakarta.apache.org/velocity <!-- end-model-doc -->
    * @see #VELOCITY
    * @generated
    * @ordered
    */
   public static final WriterType    VELOCITY_LITERAL    = new WriterType(VELOCITY, "Velocity");

   /**
    * The '<em><b>Free Marker</b></em>' literal object. <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Free Marker</b></em>' literal object isn't clear, there really should be more of a description
    * here...
    * </p>
    * <!-- end-user-doc --> <!-- begin-model-doc -->
    * 
    * @link http://www.freemarker.org <!-- end-model-doc -->
    * @see #FREE_MARKER
    * @generated
    * @ordered
    */
   public static final WriterType    FREE_MARKER_LITERAL = new WriterType(FREE_MARKER, "FreeMarker");

   /**
    * The '<em><b>None</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Specifies
    * that no writer is used for the artefact. It should not appear in any mapping. May be used to reference non generated
    * artefacts of a model element in writers. For example to reference the sources generaed by WSDL2Java. <!-- end-model-doc -->
    * 
    * @see #NONE
    * @generated
    * @ordered
    */
   public static final WriterType    NONE_LITERAL        = new WriterType(NONE, "None");

   /**
    * The '<em><b>Expand</b></em>' literal object. <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Expand</b></em>' literal object isn't clear, there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @see #EXPAND
    * @generated
    * @ordered
    */
   public static final WriterType    EXPAND_LITERAL      = new WriterType(EXPAND, "Expand");

   /**
    * An array of all the '<em><b>Writer Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private static final WriterType[] VALUES_ARRAY        = new WriterType[] { JOSTRACA_LITERAL, JET_LITERAL, VELOCITY_LITERAL,
         FREE_MARKER_LITERAL, NONE_LITERAL, EXPAND_LITERAL, };

   /**
    * A public read-only list of all the '<em><b>Writer Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static final List          VALUES              = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

   /**
    * Returns the '<em><b>Writer Type</b></em>' literal with the specified name. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static WriterType get(String name) {
      for ( int i = 0; i < VALUES_ARRAY.length; ++i ) {
         WriterType result = VALUES_ARRAY[i];
         if ( result.toString().equals(name) ) {
            return result;
         }
      }
      return null;
   }

   /**
    * Returns the '<em><b>Writer Type</b></em>' literal with the specified value. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public static WriterType get(int value) {
      switch (value) {
      case JOSTRACA:
         return JOSTRACA_LITERAL;
      case JET:
         return JET_LITERAL;
      case VELOCITY:
         return VELOCITY_LITERAL;
      case FREE_MARKER:
         return FREE_MARKER_LITERAL;
      case NONE:
         return NONE_LITERAL;
      case EXPAND:
         return EXPAND_LITERAL;
      }
      return null;
   }

   /**
    * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private WriterType(int value, String name) {
      super(value, name);
   }

} // WriterType
