//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Enumeration.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Enumeration.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.common.dto;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.umlmda.runtime.lang.StringEnumeration;

/**
 * Typesafe enumeration for Sex. 
 */
public class Sex implements StringEnumeration {

   // Version information from BusinessComponent org.umlmda.demo.common
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo

   // Qualified model name
   public static final String QUALIFIED_MODEL_NAME = "org.umlmda.demo.common.Sex";
   
   /**
    * 
    */
   public static final Sex MALE = new Sex("M");
   /**
    * 
    */
   public static final Sex FEMALE = new Sex("F");
   private final String value;
   private final static List values = new ArrayList();
   
   static {
      values.add(MALE);
      values.add(FEMALE);
   }
   
   /**
    * Never called from outside
    */
   private Sex(String value) {
      super();
      this.value = value;
   }

   /* 
    * List containing all enumeration literals
    */
   public static List values() {
      return new ArrayList(values);
   }

   /**
    * Diagnostics
    */
   public String toString() {
      if ( this.equals(MALE) ) {
         return "M"+" (MALE)";
      }
      else if ( this.equals(FEMALE) ) {
         return "F"+" (FEMALE)";
      }
      else {
         return "N/A";
      }
   }

   /**
    * Gets the internal value
    * @return the internal value of the literal type
    */
   public String getValue() {
      return value;
   }
   
   /**
    * Gets the internal value as String
    * @return the internal value of the literal type as string
    */
   public String getValueAsString() {
      return value;
   }
   
   /**
    * Correct handling of singletons in deserialization
    */ 
   private Object readResolve() throws ObjectStreamException { 
      return fromValue(value); 
   }
   
   /**
    * Creates an enumeration instance from the value
    * @param value of the literal type to be converted to an enumeration instance
    * @return the enumeration instance
    */
   public static Sex fromValue(String value) {
      for (Iterator iv = values.iterator(); iv.hasNext();) {
         Sex literal = (Sex) iv.next();

         if ( literal.getValue().equals(value) ) {
            return literal;
         }
      }
      
      throw new IllegalArgumentException(""+value);
   }
   
   /**
    * test for equality of values in enumeration
    */
   public boolean equals( Object object) {
      boolean result = false;
      if (object instanceof Sex) {
         Sex other = (Sex) object;
         result = other.getValue().equals(value);
      }
      return result;
   }
   
   /** 
    * calculate hash code of value in enumeration
    */
   public int hashCode() {
      return value.hashCode();
   } 
   
   /**
    * Returns the qualified model name of the enumeration class
    */
   public String getQualifiedModelName() {
      return QUALIFIED_MODEL_NAME;
   }
         
}
