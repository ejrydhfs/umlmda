// jUMLMDA, GeneratorBase-API
//  
//   $Header$
//   $Source$
// $Revision$
//    $State$
//     $Name$
//     $Date$
//   $Locker$
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
// 
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// Created on:      06.10.2004
package org.umlmda.generator.model.util;

import org.umlmda.profile.ModelStereotype;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractClassHelper implements IClassHelper {

   private ModelClass modelClass;

   /**
    * @return
    */
   public ModelClass getModelClass() {
      return modelClass;
   }

   public GeneratorClass getGenClass() {
      return (GeneratorClass) modelClass;
   }
   
   /**
    * @param class1
    */
   public void setModelClass(ModelClass class1) {
      modelClass = class1;
   }

   public String getType(ModelAttribute attribute) {
      return getType(attribute.getModelClassifier());
   }

   public String getClassName(ModelClassifier modelClassifier) {
      return modelClassifier.getName();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getBaseClass()
    */
   public String getBaseClass() {
      if ( modelClass.getSuperClass() != null ) {
         return getType(modelClass.getSuperClass());
      }
      else {
         return StringUtil.EMPTY;
      }
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getInitializer(org.umlmda.model.uml.ModelAttribute)
    */
   public String getInitializer(ModelAttribute attribute) {
      String initialValue = attribute.getInitialValue();
      
     if ( attribute.isPrimitiveType() && attribute.isOptional()){
        String type = attribute.getDataType().getName();
           return initialValue;
     }
     else if ( attribute.isPrimitiveType() && !(attribute.isOptional())){
         String type = attribute.getDataType().getName();
         if ( type.equals(ModelDataType.STRING) ) {
            return "\"" + initialValue + "\"";
         }
         else if ( type.equals(ModelDataType.CHAR) && !StringUtil.isEmpty(initialValue)) {
            return "'" + initialValue + "'";
         }
         else if ( type.equals(ModelDataType.CHAR) && StringUtil.isEmpty(initialValue)) {
            return "0";
         }
         else if ( type.equals(ModelDataType.INT) && StringUtil.isEmpty(initialValue) ) {
            return "0";
         }
         else if ( type.equals(ModelDataType.SHORT) && StringUtil.isEmpty(initialValue) ) {
            return "0";
         }
         else if ( type.equals(ModelDataType.LONG) && StringUtil.isEmpty(initialValue) ) {
            return "0";
         }
         else if ( type.equals(ModelDataType.FLOAT) && StringUtil.isEmpty(initialValue) ) {
            return "0.0f";
         }
         else if ( type.equals(ModelDataType.DOUBLE) && StringUtil.isEmpty(initialValue) ) {
            return "0.0";
         }
         else
            return initialValue;
      }
      else
         return null;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getPackageName()
    */
   public String getPackageName() {
      return modelClass.getPackage().getQualifiedName();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespace()
    */
   public String getNamespace(ModelClass modelClass) {
      if ( modelClass.getPackage() != null )
         return modelClass.getPackage().getQualifiedName();
      else   
         return StringUtil.EMPTY;
   }

   /**
    * Returns the qualified name of the given class. If the class is in the
    * same package the classname without package postfix will be returned.
    * If the class is in another package, the name with the ful qualified
    * package name is returned.
    */
   public String getType(ModelClassifier modelClassifier) {
      if (modelClassifier instanceof ModelClass) {
         ModelClass modelClass = (ModelClass) modelClassifier;

         if ( modelClass.getPackage().getQualifiedName().equals(getPackageName()) ) {
            return getClassName(modelClass);         
         }
         else
            return getNamespace(modelClass)+getNamespaceSep()+getClassName(modelClass);         
      }
      else
         return getType((ModelDataType)modelClassifier);         
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#isPrimitive(org.umlmda.model.uml.ModelDataType)
    */
   public boolean isPrimitive(ModelDataType dataType) {
      String dataTypeName = dataType.getName();
      if ( dataTypeName.equals(ModelDataType.INT) 
      ||   dataTypeName.equals(ModelDataType.CHAR) 
      ||   dataTypeName.equals(ModelDataType.FLOAT) 
      ||   dataTypeName.equals(ModelDataType.DOUBLE) 
      ||   dataTypeName.equals(ModelDataType.LONG)
      ||   dataTypeName.equals(ModelDataType.SHORT)
      ||   dataTypeName.equals(ModelDataType.BOOLEAN) ) {
         return true;
      }
      else if ( dataTypeName.equals(ModelDataType.DECIMAL) 
      ||   dataTypeName.equals(ModelDataType.STRING)
      ||   dataTypeName.equals(ModelDataType.DATE)
      ||   dataTypeName.equals(ModelDataType.TIMESTAMP)
      ) {
         return false;
      }
      else {
         throw new IllegalArgumentException("Invalid datatype "+dataTypeName);
      }
   }
   
}


//-------------------------------------------------------------------------
//$Log$
//Revision 1.2  2006/10/29 10:49:54  moroff
//Fixed compilation problems with attributes with the type float
//
//Revision 1.1  2006/07/10 15:32:34  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.4  2006/06/26 20:33:39  moroff
//Refactoring, Generator independent stuff now in project org.umlmda.generator.model
//
//Revision 1.3  2006/02/15 20:18:10  moroff
//Multiplity by model and stereotype
//
//Revision 1.2  2005/10/27 10:50:45  moroff
//net.sourceforge.umlmda -> org.umlmda
//
//Revision 1.1  2005/10/26 13:03:37  moroff
//* Refactoring package names to org.umlmda
//* Generator configuration based on profiles and sets
//
//Revision 1.10  2005/10/20 21:19:51  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.9  2005/06/24 13:43:15  vpussel
//support data type "dateTime"
//
//Revision 1.8  2005/06/22 11:39:22  moroff
//* getStereotype() is deprecated
//* avoid using ModelElement.getStereotype()
//
//Revision 1.7  2005/06/09 13:00:51  moroff
//getName() in ModelPackage returns unqualified name, getBaseName() removed.
//
//Revision 1.6  2005/05/25 11:18:34  tkacr
//handling optional attributes
//
//Revision 1.5  2005/04/07 20:15:06  moroff
//* New isPrimitive()
//* Using constants
//
//Revision 1.4  2005/03/13 17:01:29  moroff
//Bugfix #1159669: IDL generator crash when associating class from rose unit
//
//Revision 1.3  2005/01/22 20:52:37  moroff
//New getPackageName()
//
//Revision 1.2  2004/12/08 22:06:01  moroff
//Implementation for getInitializer()
//
//Revision 1.1  2004/10/06 19:33:14  moroff
//* Target language specific signatures put in help-classes, delegating to these 
//   classes inside the writer classes
//
//-------------------------------------------------------------------------