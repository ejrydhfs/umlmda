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

import java.util.Collection;
import java.util.List;

public class EqualityUtil {
   /**
    * Checks if two collections contains the identical elements (compared with
    * {@link Object#equals(Object)}).
    * 
    * @param one
    *           Set one
    * @param two
    *           Set two
    * @return <b>true</b> if both sets contains the same elements.
    */
   public static boolean equals(Collection<?> one, Collection<?> two) {
      if (one.size() == two.size()) {
         for (Object object : one) {
            if (two.contains(object) == false)
               return false;
         }
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Checks if two list contains the identical elements (compared with
    * {@link Object#equals(Object)} on the same position.
    * 
    * @param one
    *   List one
    * @param two
    *   List two
    * @return
    *   <b>true</b> if both lists contains identical elements on the same
    *   positions.
    */
   public static boolean equals(List<?> one, List<?> two) {
      if (one.size() == two.size()) {
         for (int i=0; i<one.size(); ++i) {
            if ( one.get(i).equals(two.get(i)) == false ) {
               return false;
            }
         }
         return true;
      }
      else {
         return false;
      }
   }
}
