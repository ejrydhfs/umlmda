/*
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
 * Created on 12.05.2009 (Dieter Moroff)
 */
package org.umlmda.runtime.lang;

/**
 * Interface for classes to equality the identity of all properties.
 * 
 * @author Dieter Moroff (12.05.2009)
 */
public interface EqualityCheckable
{

   /**
    * Checks if all properties (attributes and none composite associations) are equals. In contrast to
    * {@link Object#equals(Object)}, which checks the identity of instances. If the object has an identity (for example a domain
    * model entity has a so called domain key) the equals method checks only the domain key properties.
    * 
    * @param other
    *           Instance to compare with
    * @return <b>true</b> is all properties of the class instance are equals.
    */
   boolean arePropertiesEqual(Object other);
}
