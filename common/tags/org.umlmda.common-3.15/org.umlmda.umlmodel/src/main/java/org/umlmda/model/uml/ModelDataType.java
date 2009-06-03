// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelDataType.java,v 1.5 2006/05/04 15:16:30 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelDataType.java,v $
// $Revision: 1.5 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/05/04 15:16:30 $
//   $Locker:  $
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
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface ModelDataType extends ModelDataTypeBase, ModelClassifier, ModelVisitable {
   public static final String INT = "int";
   public static final String LONG = "long";
   public static final String SHORT = "short";
   public static final String FLOAT = "float";
   public static final String DOUBLE = "double";
   public static final String DECIMAL = "decimal";
   public static final String CHAR = "char";
   public static final String STRING = "string";
   public static final String DATE = "date";
   public static final String DATE_TIME = "dateTime";
   public static final String TIMESTAMP = "timestamp";
   public static final String BOOLEAN = "boolean";
   public static final String BINARY = "binary";
   public static final String VOID = "void";
      
   /**
    * Stategy pattern to get the plattform type.
    * @author Dieter Moroff (16.04.2006), last change $Date: 2006/05/04 15:16:30 $ $Name:  $
    * @version $Revision: 1.5 $
    */
   public interface TypeMappingStrategy {
      
      /**
       * Gets the platform datatype for a given datatype 
       * @param dataType the datatype to be converted
       * @param optional the datatype supports null values (is optional)
       * @param multivalue the datetype supports multiple values
       * @return plattform datatype
       */
      String getPSMType(ModelDataType dataType, boolean optional, boolean multivalue);
   }
}