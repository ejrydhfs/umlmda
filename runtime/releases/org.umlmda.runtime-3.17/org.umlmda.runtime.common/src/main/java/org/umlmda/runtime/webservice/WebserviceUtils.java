/*
 *  $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/webservice/WebserviceUtils.java,v 1.1 2008/03/25 13:04:01 moroff Exp $
 *  Copyright (C) 2003, 2004 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://umlmda.sf.net)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on Apr 1, 2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.runtime.webservice;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Utility to convert datatype values from or to axis webservice representations.
 * 
 * @author Dieter Moroff
 */
public class WebserviceUtils
{
   private final static DatatypeFactory datatypeFactory = newDatatypeFactory();
   private final static BigDecimal      DECIMAL_ZERO    = new BigDecimal(0.0);

   private static DatatypeFactory newDatatypeFactory() {
      try {
         return DatatypeFactory.newInstance();
      }
      catch (DatatypeConfigurationException e) {
         throw new RuntimeException(e);
      }
   }

   public static Double convertToWs(double value) {
      return new Double(value);
   }

   public static Double[] convertToWs(double value[]) {
      if ( value != null ) {
         Double retValue[] = new Double[value.length];
         for ( int i = 0; i < value.length; i++ ) {
            retValue[i] = new Double(value[i]);
         }
         return retValue;
      }
      else {
         return null;
      }
   }

   public static Float convertToWs(float value) {
      return new Float(value);
   }

   public static Boolean convertToWs(boolean value) {
      return new Boolean(value);
   }

   public static Short convertToWs(short value) {
      return new Short(value);
   }

   public static Integer convertToWs(int value) {
      return new Integer(value);
   }

   public static Long convertToWs(long value) {
      return new Long(value);
   }

   public static Integer[] convertToWs(int value[]) {
      if ( value != null ) {
         Integer retValue[] = new Integer[value.length];
         for ( int i = 0; i < value.length; i++ ) {
            retValue[i] = new Integer(value[i]);
         }
         return retValue;
      }
      else {
         return null;
      }
   }

   public static Long[] convertToWs(long value[]) {
      if ( value != null ) {
         Long retValue[] = new Long[value.length];
         for ( int i = 0; i < value.length; i++ ) {
            retValue[i] = new Long(value[i]);
         }
         return retValue;
      }
      else {
         return null;
      }
   }

   public static Calendar convertToWs(Date date) {
      if ( date != null ) {
         Calendar cal = new GregorianCalendar();

         cal.setTime(date);
         return cal;
      }
      else {
         return null;
      }
   }

   public static Calendar convertToWs(XMLGregorianCalendar cal) {
      if ( cal != null ) {
         return cal.toGregorianCalendar();
      }
      else {
         return null;
      }
   }

   // Conversion from webservice interfaces to business interfaces
   public static int[] convertFromWs(Integer[] value) {
      if ( value != null ) {
         int retValue[] = new int[value.length];

         for ( int i = 0; i < value.length; i++ ) {
            retValue[i] = value[i].intValue();
         }
         return retValue;
      }
      else {
         return null;
      }
   }

   public static long[] convertFromWs(Long[] value) {
      if ( value != null ) {
         long retValue[] = new long[value.length];

         for ( int i = 0; i < value.length; i++ ) {
            retValue[i] = value[i].longValue();
         }
         return retValue;
      }
      else {
         return null;
      }
   }

   public static double[] convertFromWs(Double[] value) {
      if ( value != null ) {
         double retValue[] = new double[value.length];

         for ( int i = 0; i < value.length; i++ ) {
            retValue[i] = value[i].doubleValue();
         }
         return retValue;
      }
      else {
         return null;
      }
   }

   public static Date convertFromWs(Calendar value) {
      if ( value != null )
         return value.getTime();
      else
         return null;
   }

   /**
    * Convert @link java.util.Calendar to @link javax.xml.datatype.XMLGregorianCalendar.
    */
   public static XMLGregorianCalendar convertCalendarToXMLGregorianCalendar(Calendar calendar) {
      return convertCalendarToXMLGregorianCalendar(calendar, true, false);
   }

   /**
    * @param calendar
    * @param setTime
    *           <code>true</code> to set date and time, <code>false</code> to set date only.
    */
   public static XMLGregorianCalendar convertCalendarToXMLGregorianCalendar(Calendar calendar, boolean setTime) {
      return convertCalendarToXMLGregorianCalendar(calendar, setTime, false);
   }

   /**
    * @param cal
    * @param setTime
    *           <code>true</code> to set date and time, <code>false</code> to set date only.
    */
   public static XMLGregorianCalendar convertCalendarToXMLGregorianCalendar(Calendar calendar, boolean setTime,
         boolean setTimezone) {
      if ( calendar == null )
         return null;
      else {
         XMLGregorianCalendar xmlCalendar = datatypeFactory.newXMLGregorianCalendar((GregorianCalendar) calendar);

         if ( !setTime )
            resetTime(xmlCalendar);
         if ( !setTimezone )
            resetTimezone(xmlCalendar);
         return xmlCalendar;
      }
   }

   /**
    * Convert
    * 
    * @link java.util.Date to
    * @link javax.xml.datatype.XMLGregorianCalendar.
    */
   public static XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) {
      return convertDateToXMLGregorianCalendar(date, true, false);
   }

   /**
    * @param date
    * @param setTime
    *           <code>true</code> to set date and time, <code>false</code> to set date only.
    */
   public static XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date, boolean setTime) {
      return convertDateToXMLGregorianCalendar(date, setTime, false);
   }

   /**
    * @param date
    * @param setTime
    *           <code>true</code> to set date and time, <code>false</code> to set date only.
    */
   public static XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date, boolean setTime, boolean setTimezone) {
      if ( date == null )
         return null;
      else {
         GregorianCalendar cal = new GregorianCalendar();
         cal.setTime(date);

         XMLGregorianCalendar xmlCalendar = datatypeFactory.newXMLGregorianCalendar(cal);

         if ( !setTime )
            resetTime(xmlCalendar);
         if ( !setTimezone )
            resetTimezone(xmlCalendar);
         return xmlCalendar;
      }
   }

   /**
    * Convert @link javax.xml.datatype.XMLGregorianCalendar to @link java.util.Calendar
    */
   public static Calendar convertXMLGregorianCalendarToCalendar(XMLGregorianCalendar calendar) {
      if ( calendar == null )
         return null;
      else
         return calendar.toGregorianCalendar();
   }

   /**
    * Convert @link javax.xml.datatype.XMLGregorianCalendar to @link java.util.Date
    */
   public static Date convertXMLGregorianCalendarToDate(XMLGregorianCalendar calendar) {
      if ( calendar == null )
         return null;
      else
         return calendar.toGregorianCalendar().getTime();
   }

   private static XMLGregorianCalendar resetTime(XMLGregorianCalendar calendar) {
      if ( calendar != null ) {
         calendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
         calendar.setSecond(DatatypeConstants.FIELD_UNDEFINED);
         calendar.setMinute(DatatypeConstants.FIELD_UNDEFINED);
         calendar.setHour(DatatypeConstants.FIELD_UNDEFINED);
         resetTimezone(calendar);
      }
      return calendar;
   }

   private static XMLGregorianCalendar resetTimezone(XMLGregorianCalendar calendar) {
      if ( calendar != null ) {
         calendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
      }
      return calendar;
   }

}
