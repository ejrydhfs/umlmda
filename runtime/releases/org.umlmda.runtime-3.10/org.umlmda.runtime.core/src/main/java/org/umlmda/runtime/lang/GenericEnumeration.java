/*
 *   $Header: /cvsroot/umlmda/runtime/org.umlmda.runtime.core/src/main/java/org/umlmda/runtime/lang/GenericEnumeration.java,v 1.1 2008/03/20 22:42:18 moroff Exp $
 *   $Source: /cvsroot/umlmda/runtime/org.umlmda.runtime.core/src/main/java/org/umlmda/runtime/lang/GenericEnumeration.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2008/03/20 22:42:18 $
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
 * Created on 08.11.2007 (Dieter Moroff)
 */
package org.umlmda.runtime.lang;

/**
 * Interface for untypes access to enumeration values.
 * @author Dieter Moroff
 */
public interface GenericEnumeration extends Enumeration {

   /**
    * Returns the underlying value of the enumeration converted as String.
    */
   public String getValueAsString();

}
