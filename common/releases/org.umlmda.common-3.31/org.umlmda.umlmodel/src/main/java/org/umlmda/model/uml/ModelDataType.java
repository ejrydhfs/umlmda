// UMLMDA, UMLModel-API
// 
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
//  Created on Nov 9, 2004
package org.umlmda.model.uml;

/**
 * @author moroff
 */
public interface ModelDataType extends ModelDataTypeBase, ModelClassifier, ModelVisitable
{
   String INT       = "int";
   String LONG      = "long";
   String SHORT     = "short";
   String FLOAT     = "float";
   String DOUBLE    = "double";
   String DECIMAL   = "decimal";
   String CHAR      = "char";
   String STRING    = "string";
   String DATE      = "date";
   String DATE_TIME = "dateTime";
   String TIMESTAMP = "timestamp";
   String BOOLEAN   = "boolean";
   String BINARY    = "binary";
   String VOID      = "void";

   /**
    * Stategy pattern to get the plattform type.
    * 
    */
   public interface TypeMappingStrategy
   {

      /**
       * Gets the platform datatype for a given datatype
       * 
       * @param dataType
       *           the datatype to be converted
       * @param optional
       *           the datatype supports null values (is optional)
       * @param multivalue
       *           the datetype supports multiple values
       * @return plattform datatype
       */
      String getPSMType(ModelDataType dataType, boolean optional, boolean multivalue);
   }
}