// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/AbstractCppNamespaceWriter.java,v 1.4 2006/07/10 15:37:15 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/AbstractCppNamespaceWriter.java,v $
// $Revision: 1.4 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/07/10 15:37:15 $
//   $Locker:  $
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
// Created on:      23.07.2003
package org.umlmda.uml.generator.cpp;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.AbstractPackageWriter;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.profile.ModelTaggedValues;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelPackage;


/**
 * Basisklasse für alle KlassenWriter
 *
 * @author moroff (06.02.2003)
 */
public abstract class AbstractCppNamespaceWriter extends AbstractPackageWriter
{
   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractCppNamespaceWriter() {
      super(new CppClassHelper(), new CppMethodHelper(null, false));
   }

   private String namespaceName;
   
//   /**
//    * Methode muss überladen werden, um den Dateinamen ohne Endung zu liefern
//    * @return String
//    */
//   public String getBaseName() {
//      return getClassName();
//   }

   /**
    * Setzt das (Teil-)Modell, für das generiert werden soll
    */
   public void setModelPackage(ModelPackage modelPackage) {
      super.setModelPackage(modelPackage);
      namespaceName = modelPackage.getTaggedValues().getProperty(ModelTaggedValues.CPP_NAMESPACE, "");
   }
   
   protected void addReferencedType(Set referencedTypes, ModelClassifier modelClassifier) {
      if (modelClassifier instanceof ModelClass) {
         ModelClass modelClass = (ModelClass) modelClassifier;

         referencedTypes.add(modelClass);
      }
   }

   
//   /**
//       * Returns the qualified name of the given class. If the class is in the
//       * same package the classname without package postfix will be returned.
//       * If the class is in another package, the name with the ful qualified
//       * package name is returned.
//       */
//   public String getType(ModelClassifier modelClassifier) {
//         if (modelClassifier instanceof ModelClass) {
//            ModelClass modelClass = (ModelClass) modelClassifier;
//            
//            if ( modelPackage == modelClass.getPackage()) {
//               return "I"+modelClassifier.getName();         
//            }
//            else
//               return modelClass.getPackage().getName()+"."+getClassName(modelClassifier);         
//         }
//         else
//            return getType((ModelDataType)modelClassifier);         
//   }
//
//   /**
//       * @param type
//       * @return
//       */
//   public String getType(ModelDataType type) {
//      if ( type.getName().equals("string") )
//         return "String";
//      else if ( type.getName().equals("date") )
//         return "java.util.Date";
//      else if ( type.getName().equals("timestamp") )
//         return "java.util.Date";
//      else
//         return type.getName();
//   }
//
//   public String getType(ModelAttribute attribute) {
//      if ( attribute.isPrimitiveType() ) {
//         return getType(attribute.getDataType());
//      }
//      else {
//         return getType(attribute.getModelClass());
//      }
//   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractWriter#setModelElement(net.sourceforge.umlmda.xmi.uml.ModelElement)
    */
   public void setModelElement(Object element) {
      super.setModelElement(element);
      if ( element instanceof ModelPackage ) {
         setModelPackage((ModelPackage)element);
      }
   }

   /**
    * @return
    */
   public String getNamespaceName() {
      return namespaceName;
   }

   protected String startIncludeGuard() {
      StringBuffer buffer = new StringBuffer(1024);
      
      buffer.append("#ifndef __INCLUDED_");
      buffer.append(getBaseName().toUpperCase());
      buffer.append("_H\r\n");
      buffer.append("#define __INCLUDED_");
      buffer.append(getBaseName().toUpperCase());
      buffer.append("_H\r\n");
      return buffer.toString();
   }

   protected String endIncludeGuard() {
      return "#endif // __INCLUDED_... ";
   }

}

// -------------------------------------------------------------------------
// $Log: AbstractCppNamespaceWriter.java,v $
// Revision 1.4  2006/07/10 15:37:15  moroff
// Refactoring base functionality to org.umlmda.generator.model
//
// Revision 1.3  2005/10/28 16:29:48  moroff
// Finished 2.0 refactorings
//
// Revision 1.2  2005/10/27 19:04:41  moroff
// net.sourceforge.umlmda renamed to org.umlmda
//
// Revision 1.1  2005/10/20 21:20:29  moroff
// More refactoring, make java templates more flexible.
//
// Revision 1.7  2005/09/29 14:55:16  vpussel
// use tagged values from umlmda profile
//
// Revision 1.6  2005/06/09 11:24:57  moroff
// Bugfix #1187212: C++ factories now prefixed with CPPNamespace
//
// Revision 1.5  2005/05/14 10:35:04  moroff
// Removed unused imports
//
// Revision 1.4  2005/05/07 19:52:51  moroff
// Model is object not ModelElement any more
//
// Revision 1.3  2004/12/08 22:07:29  moroff
// Remove unused imports
//
// Revision 1.2  2004/10/09 20:31:40  moroff
// * Includeguard functions
//
// Revision 1.1  2004/10/06 19:42:22  moroff
// * Supporting writers on ModelPackage elements
//
// Revision 1.1  2004/10/03 13:13:09  greinhar
// * Moved from UML-Generator
// * Extended for C++ Generation
//
// Revision 1.3  2003/11/03 09:22:26  moroff
// Added associations and methods
//
// Revision 1.2  2003/08/06 21:15:26  moroff
// Import der Attribute Typen
//
// Revision 1.1  2003/07/22 21:15:23  moroff
// Initial import
//
// -------------------------------------------------------------------------
