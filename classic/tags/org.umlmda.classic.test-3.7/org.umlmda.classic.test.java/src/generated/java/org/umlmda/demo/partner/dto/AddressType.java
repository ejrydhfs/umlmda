//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Enumeration.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Enumeration.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.partner.dto;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.umlmda.runtime.lang.IntEnumeration;

/**
 * Typesafe enumeration for AddressType. 
 */
public class AddressType implements IntEnumeration {

   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo

   // Qualified model name
   public static final String QUALIFIED_MODEL_NAME = "org.umlmda.demo.partner.AddressType";
   
   /**
    * 
    */
   public static final AddressType PRIVATE = new AddressType(1);
   /**
    * 
    */
   public static final AddressType BUSINESS = new AddressType(2);
   /**
    * 
    */
   public static final AddressType HOLIDAY = new AddressType(3);
   private final int value;
   private final static List values = new ArrayList();
   
   static {
      values.add(PRIVATE);
      values.add(BUSINESS);
      values.add(HOLIDAY);
   }
   
   /**
    * Never called from outside
    */
   private AddressType(int value) {
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
      if ( this.equals(PRIVATE) ) {
         return 1+" (PRIVATE)";
      }
      else if ( this.equals(BUSINESS) ) {
         return 2+" (BUSINESS)";
      }
      else if ( this.equals(HOLIDAY) ) {
         return 3+" (HOLIDAY)";
      }
      else {
         return "N/A";
      }
   }

   /**
    * Gets the internal value
    * @return the internal value of the literal type
    */
   public int getValue() {
      return value;
   }
   
   /**
    * Gets the internal value as String
    * @return the internal value of the literal type as string
    */
   public String getValueAsString() {
      return Integer.toString(value);
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
   public static AddressType fromValue(int value) {
      for (Iterator iv = values.iterator(); iv.hasNext();) {
         AddressType literal = (AddressType) iv.next();

         if ( literal.getValue() == value ) {
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
      if (object instanceof AddressType) {
         AddressType other = (AddressType) object;
         result = other.getValue() == value;
      }
      return result;
   }
   
   /** 
    * calculate hash code of value in enumeration
    */
   public int hashCode() {
      return value;
   } 
   
   /**
    * Returns the qualified model name of the enumeration class
    */
   public String getQualifiedModelName() {
      return QUALIFIED_MODEL_NAME;
   }
         
}
