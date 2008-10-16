/*
 *   $Header: /cvsroot/umlmda/runtime/org.umlmda.runtime.core/src/main/java/org/umlmda/runtime/lang/Enumeration.java,v 1.1 2008/03/20 22:42:18 moroff Exp $
 *   $Source: /cvsroot/umlmda/runtime/org.umlmda.runtime.core/src/main/java/org/umlmda/runtime/lang/Enumeration.java,v $
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
 * Created on 27.07.2006 (Dieter Moroff)
 */
package org.umlmda.runtime.lang;

import java.io.Serializable;

/**
 * Marking interface for enumeration classes. Because functions like
 * getValues() or fromValue() are static they can't be defined on
 * this interface.
 * @author Dieter Moroff (27.07.2006)
 */
public interface Enumeration extends Serializable {

   /**
    * Returns the qualified model name of the enumeration class
    * @return
    */
   public abstract String getQualifiedModelName();
}
