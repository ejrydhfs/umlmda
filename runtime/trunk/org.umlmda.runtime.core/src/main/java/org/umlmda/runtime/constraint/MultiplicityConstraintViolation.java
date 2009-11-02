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

/**
 * TODO Insert type javadoc
 * 
 * @author Dieter Moroff (20.02.2006)
 */
public class MultiplicityConstraintViolation extends ConstraintViolation
{
   private final String boundType;
   private final int    is;
   private final int    expected;

   /**
    * @param feature
    */
   public MultiplicityConstraintViolation(String feature, String boundType, int is, int expected) {
      super(feature);
      this.boundType = boundType;
      this.is = is;
      this.expected = expected;
   }

   /**
    * @return Returns the boundType.
    */
   private String getBoundType() {
      return boundType;
   }

   /**
    * @return Returns the expected.
    */
   private int getExpected() {
      return expected;
   }

   /**
    * @return Returns the is.
    */
   private int getIs() {
      return is;
   }

   public String toString() {
      return "MultiplicityConstraintViolation: " + getFeature() + " " + getBoundType() + " multiplicity is " + getIs()
            + ", expected " + getExpected();
   }
}
