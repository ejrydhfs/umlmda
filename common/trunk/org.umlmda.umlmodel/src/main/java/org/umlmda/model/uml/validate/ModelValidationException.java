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
 * Created by Dieter Moroff (02.05.2006)
 */
package org.umlmda.model.uml.validate;

import java.util.Iterator;
import java.util.List;

/**
 * Exception thrown, if model validation fails
 * 
 */
public class ModelValidationException extends Exception
{
   private final List validationResults;

   /**
    * 
    */
   public ModelValidationException(List validationResults) {
      super();
      this.validationResults = validationResults;
   }

   /**
    * @param message
    */
   public ModelValidationException(String message, List validationResults) {
      super(message);
      this.validationResults = validationResults;
   }

   public List getValidationResults() {
      return validationResults;
   }

   public String getMessage() {
      StringBuffer buffer = new StringBuffer(getClass().getName());

      buffer.append("\n");
      for ( Iterator ir = validationResults.iterator(); ir.hasNext(); ) {
         ValidationResult result = (ValidationResult) ir.next();

         buffer.append(result.toString());
         if ( ir.hasNext() ) {
            buffer.append("\n");
         }
      }
      return buffer.toString();
   }
}
