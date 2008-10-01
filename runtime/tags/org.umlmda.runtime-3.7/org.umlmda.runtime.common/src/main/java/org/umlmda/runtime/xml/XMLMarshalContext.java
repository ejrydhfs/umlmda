/*
 * $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/xml/XMLMarshalContext.java,v 1.1 2008/03/25 13:04:02 moroff Exp $
 * $Source: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/xml/XMLMarshalContext.java,v $
 * $Revision: 1.1 $
 *  $State: Exp $
 *   $Name:  $
 *   $Date: 2008/03/25 13:04:02 $
 * $Locker:  $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created on 14.12.2005 (Dieter Moroff)
 */
package org.umlmda.runtime.xml;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Context for marshalling objects to a xml stream.
 * @author MOROFF
 */
public class XMLMarshalContext  {
   private final StringBuffer buffer;
   private int identLevel = 0;
   private int id = 0;
   private Map idMap = new HashMap();
   private static final String NEWLINE = System.getProperty("line.separator", "/n"); 
   
   /**
    * 
    */
   public XMLMarshalContext() {
      buffer = new StringBuffer();
      buffer.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
      buffer.append(NEWLINE);
   }
   
   /**
    * 
    */
   public XMLMarshalContext(StringBuffer buffer) {
      this.buffer = buffer;
   }
   
   private void incrementIdentLevel() {
      ++identLevel;
   }
   
   private void decrementIdentLevel() {
      --identLevel;
   }
   
   private void ident() {
      for ( int i = 0; i < identLevel; ++i ) {
         buffer.append("  ");
      }
   }
   
   /**
    * @param elementName
    */
   public void startElement(String elementName) {
      appendStartTag(elementName);
      buffer.append(NEWLINE);
      incrementIdentLevel();
   }

   /**
    * @param elementName
    */
   public void endElement(String elementName) {
      decrementIdentLevel();
      ident();
      appendEndTag(elementName);
   }
   
   /**
    * Starts a element start tag.
    * @param elementName
    * @return the id which was given for the element
    */
   public void startElement(String elementName, XMLSerializable object, boolean isRoot) {
      String idTag = getOrCreateIdTag(object);
      
      ident();
      buffer.append("<");
      buffer.append(elementName);
      buffer.append(" id=\"");
      buffer.append(idTag);
      buffer.append("\"");
      buffer.append(">");
      buffer.append(NEWLINE);
      incrementIdentLevel();
      if ( !isRoot ) {
         startElement(getObjectClass(object));
      }
   }

   /**
    * @param object
    * @return
    */
   private String getObjectClass(XMLSerializable object) {
      String className = object.getClass().getName();
      int index = className.lastIndexOf(".");
      
      if ( index > 0 ) {
         className = className.substring(index+1);
      }
      
      return className;
   }

   public void endElement(String elementName, XMLSerializable object, boolean isRoot) {
      if ( !isRoot ) {
         endElement(getObjectClass(object));
      }
      decrementIdentLevel();
      ident();
      appendEndTag(elementName);
   }

   
   /**
    * @param object
    * @return
    */
   private String getOrCreateIdTag(Object object) {
      String idTag = (String) idMap.get(object);
      
      if ( idTag == null ) {
         idTag = "ID"+Integer.toString(id++);
         idMap.put(object, idTag);
      }
      return idTag;
   }

   /**
    * Creates an element reference
    * @param elementName
    * @param object
    */
   public void elementRef(String elementName, XMLSerializable object) {
      String idTag = getOrCreateIdTag(object);

      ident();
      buffer.append("<");
      buffer.append(elementName);
      buffer.append(" refid=\"");
      buffer.append(idTag);
      buffer.append("\"");
      buffer.append("/>");
      buffer.append(NEWLINE);
   }
   
   /**
    * @param elementName
    */
   private void appendStartTag(String elementName) {
      ident();
      buffer.append("<");
      buffer.append(elementName);
      buffer.append(">");
   }

   /**
    * @param elementName
    */
   private void appendEndTag(String elementName) {
      buffer.append("</");
      buffer.append(elementName);
      buffer.append(">");
      buffer.append(NEWLINE);
   }

   public String toString() {
      return buffer.toString();
   }

   /**
    * @param string
    * @param id2
    */
   public void simpleElement(String elementName, String value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }

   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, int value) {
      appendStartTag(elementName);
      buffer.append(value);
      appendEndTag(elementName);
   }
   
   /**
    * @param string
    * @param value
    */
   public void simpleElement(String elementName, int[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, Integer value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, long value) {
      appendStartTag(elementName);
      buffer.append(value);
      appendEndTag(elementName);
   }
   
   /**
    * @param string
    * @param shortArrayAttr
    */
   public void simpleElement(String elementName, long[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, Long value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }

   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, java.math.BigDecimal value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, java.math.BigDecimal [] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, short value) {
      appendStartTag(elementName);
      buffer.append(value);
      appendEndTag(elementName);
   }
   
   /**
    * @param string
    * @param shortArrayAttr
    */
   public void simpleElement(String elementName, short[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, Short value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, byte[] value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, char value) {
      appendStartTag(elementName);
      buffer.append(value);
      appendEndTag(elementName);
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, Character value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }
   
   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, double value) {
      appendStartTag(elementName);
      buffer.append(value);
      appendEndTag(elementName);
   }
   
   /**
    * @param string
    * @param value
    */
   public void simpleElement(String elementName, double[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }

   /**
    * @param string
    * @param salary
    */
   public void simpleElement(String elementName, Double value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }

   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, float value) {
      appendStartTag(elementName);
      buffer.append(value);
      appendEndTag(elementName);
   }

   /**
    * @param string
    * @param value
    */
   public void simpleElement(String elementName, float[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }


   /**
    * @param string
    * @param salary
    */
   public void simpleElement(String elementName, Float value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }

   /**
    * @param string
    * @param nr
    */
   public void simpleElement(String elementName, boolean value) {
      appendStartTag(elementName);
      buffer.append(value);
      appendEndTag(elementName);
   }

   /**
    * @param string
    * @param shortArrayAttr
    */
   public void simpleElement(String elementName, boolean[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }
   
   /**
    * @param string
    * @param employee
    */
   public void simpleElement(String elementName, Boolean value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }

   /**
    * @param string
    * @param birthdate
    */
   public void simpleElement(String elementName, Date value) {
      if ( value != null ) {
         appendStartTag(elementName);
         buffer.append(value);
         appendEndTag(elementName);
      }
   }

   /**
    * @param string
    * @param value
    */
   public void simpleElement(String elementName, String[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }

   /**
    * @param string
    * @param validFrom
    */
   public void simpleElement(String string, XMLGregorianCalendar validFrom) {
      simpleElement(string, validFrom != null ? validFrom.toXMLFormat() : null);
   }

   /**
    * @param string
    * @param shortArrayAttr
    */
   public void simpleElement(String elementName, XMLGregorianCalendar[] value) {
      if ( value != null ) {
         for (int i = 0; i < value.length; i++) {
            simpleElement(elementName, value[i]);
         }
      }
   }
   


   
}
