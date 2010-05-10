/*
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
 * Created by Dieter Moroff (04.05.2006)
 */
package org.umlmda.model.uml.internal.utils;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.attributes.Multiplicity;

/**
 * TODO Insert type javadoc
 * 
 */
public class ModelBaseUtils
{

   /**
    * 
    */
   public ModelBaseUtils() {
      super();
      // TODO Auto-generated constructor stub
   }

   public static Multiplicity getMultiplicityByStereotype(ModelAttributeBase attribute) {
      Multiplicity multiplicity = null;
      Pattern multiplicityPattern = Pattern.compile("([0-9]+)..([0-9n*]+)");
      for ( Iterator is = attribute.getStereotypes().iterator(); is.hasNext(); ) {
         String stereotype = (String) is.next();
         Matcher matcher = multiplicityPattern.matcher(stereotype);

         if ( matcher.matches() ) {
            String lowerRange = matcher.group(1);
            String upperRange = matcher.group(2);
            int lower = 0;
            int upper = 1;

            if ( upperRange.equals("n") || upperRange.equals("*") ) {
               upper = Multiplicity.UNBOUND;
            }
            else {
               upper = Integer.parseInt(upperRange);
            }

            lower = Integer.parseInt(lowerRange);
            multiplicity = new Multiplicity(lower, upper);
            break;
         }
      }
      if ( multiplicity == null ) {
         multiplicity = new Multiplicity(1, 1);
      }
      return multiplicity;
   }

}
