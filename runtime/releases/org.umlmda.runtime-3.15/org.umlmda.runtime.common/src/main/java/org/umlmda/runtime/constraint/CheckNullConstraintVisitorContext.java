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
 * Created by Dieter Moroff (20.02.2006)
 */
package org.umlmda.runtime.constraint;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.umlmda.runtime.constraint.ConstraintViolation;
import org.umlmda.runtime.constraint.ConstraintVisitorContext;
import org.umlmda.runtime.constraint.MultiplicityConstraintViolation;

/**
 * Checked zusätzlich die String Attribute, sind haben diese mindestens eine zu 1 Kardinalität,
 * darf der String nicht leer sein. (Das ist die default Belegung beim UMLMDA Generator,
 * weswegen dann alle Strings als belegt erkannt werden)  
 * @author eisenmann
 */
public class CheckNullConstraintVisitorContext extends ConstraintVisitorContext
{
   
      /**
       * Checked zusätzlich die String Attribute, sind haben diese mindestens eine zu 1 Kardinalit�t,
       * darf der String nicht leer sein. (Das ist die default Belegung beim UMLMDA Generator,
       * weswegen dann alle Strings als belegt erkannt werden)  
       */
      public void checkMultiplicityContraint(String feature, int lower, int upper, Object value){
         if(lower > 0) {
            List<ConstraintViolation> violations = getViolations();
            if(value == null) {
               violations.add(new MultiplicityConstraintViolation(feature, "lower", 0, lower));
               return;
            }
            if(value instanceof String) {
               if(StringUtils.isBlank((String) value)) {
                  violations.add(new MultiplicityConstraintViolation(feature, "lower", 0, lower));
                  return;
               }
            }
         }
         super.checkMultiplicityContraint(feature, lower, upper, value);
      }
   
}
