/*
 *   $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/constraint/ConstraintViolation.java,v 1.1 2008/03/25 09:54:05 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/constraint/ConstraintViolation.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2008/03/25 09:54:05 $
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
 * Created by Dieter Moroff (20.02.2006)
 */
package org.umlmda.runtime.constraint;

/**
 * Baseclass for constraint violations
 * @author Dieter Moroff (20.02.2006), last change $Date: 2008/03/25 09:54:05 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public class ConstraintViolation {
   private final String feature;
   
   /**
    * 
    */
   public ConstraintViolation(String feature) {
      super();
      this.feature = feature;
   }

   /**
    * @return Returns the feature.
    */
   public String getFeature() {
      return feature;
   }
}
