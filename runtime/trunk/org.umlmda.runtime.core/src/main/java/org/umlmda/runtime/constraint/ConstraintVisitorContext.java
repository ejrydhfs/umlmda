/*
 *   $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/constraint/ConstraintVisitorContext.java,v 1.1 2008/03/25 09:54:05 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/constraint/ConstraintVisitorContext.java,v $
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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.umlmda.runtime.visitor.VisitorContext;

/**
 * iterator that checks for constraint violations.
 * 
 * @author Dieter Moroff (20.02.2006)
 */
public class ConstraintVisitorContext implements VisitorContext {
   private int objectLevel = 0;
   private List<ConstraintViolation> violations = new LinkedList<ConstraintViolation>();
   
   /**
    * 
    */
   public ConstraintVisitorContext() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.VisitorContext#getObjectLevel()
    */
   public int getObjectLevel() {
      return objectLevel;
   }

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.VisitorContext#setObjectLevel(int)
    */
   public void setObjectLevel(int objectLevel) {
      this.objectLevel = objectLevel;
   }

   /**
    * @return Returns the violations.
    */
   public List<ConstraintViolation> getViolations() {
      return violations;
   }
   
   public void checkMultiplicityContraint(String feature, int lower, int upper, Collection<?> collection) {
      if ( lower > collection.size() ) {
         violations.add(new MultiplicityConstraintViolation(feature, "lower", collection.size(), lower));
      }
      
      if ( upper != -1 && upper < collection.size() ) {
         violations.add(new MultiplicityConstraintViolation(feature, "upper", collection.size(), upper));
      }
   }

   public void checkMultiplicityContraint(String feature, int lower, int upper, Object value) {
      if ( lower > 0 && value == null ) {
         violations.add(new MultiplicityConstraintViolation(feature, "lower", 0, lower));
      }
      
      if ( value != null ) {
	      if ( value instanceof Object[] ) {
	         Object array[] = (Object[]) value;
	         int length = array.length;
	         
	         if ( lower > length ) {
	            violations.add(new MultiplicityConstraintViolation(feature, "lower", length, lower));
	         }
	         if ( upper != -1 && upper < length ) {
	            violations.add(new MultiplicityConstraintViolation(feature, "upper", length, upper));
	         }
	      }
      }
   }
   
}
