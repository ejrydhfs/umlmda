// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/IClassWriter.java,v 1.3 2006/07/10 15:29:47 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/IClassWriter.java,v $
// $Revision: 1.3 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/07/10 15:29:47 $
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
// Created on:      06.10.2004
package org.umlmda.generator;

import java.util.Collection;

import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelMethod;

/**
 * Common interface of all writers operating on model classes 
 * @author moroff
 */
public interface IClassWriter {
   /**
    * return the name of the class for which the writer is generated 
    * @see IClassWriter#getClassName(ModelClassifier)
    */
   public abstract String getClassName();

   /**
    * Returns the fully qualified name of the package
    */
   public abstract String getPackageName();

   /**
    * return the name of given modelclassifier in context of the writer 
    * @return String
    */
   public abstract String getClassName(ModelClassifier modelClassifier);
   
   /**
    * Sets the modelclass of the writer
    */
   public abstract void setModelClass(ModelClass modelClass);
   
   /**
    * Returns a collection with all reference types which are used by the
    * writers model-class.
    */
   public abstract Collection getReferencedTypes();
   
   /**
    * Returns the qualified name of the given class. If the class is in the
    * same package the classname without package postfix will be returned.
    * If the class is in another package, the name with the ful qualified
    * package name is returned.
    */
   public abstract String getType(ModelClassifier modelClassifier);
   
   /**
    * @param type
    * @return
    */
   public abstract String getType(ModelDataType type);
   
   public abstract String getType(ModelAttribute attribute);
   
   public String getMethodSignature(ModelMethod method);
   
   public IMethodHelper getMethodHelper();
   public void setMethodHelper(IMethodHelper helper);
   
   public IClassHelper getClassHelper();
   public void setClassHelper(IClassHelper helper);

   public String getBaseClass();
}

//-------------------------------------------------------------------------
//$Log: IClassWriter.java,v $
//Revision 1.3  2006/07/10 15:29:47  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.2  2005/10/27 10:52:45  moroff
//*** empty log message ***
//
//Revision 1.1  2005/10/26 13:03:37  moroff
//* Refactoring package names to org.umlmda
//* Generator configuration based on profiles and sets
//
//Revision 1.2  2005/04/07 20:17:08  moroff
//New getPackageName()
//
//Revision 1.1  2004/10/06 19:57:12  moroff
//*** empty log message ***
//
//-------------------------------------------------------------------------