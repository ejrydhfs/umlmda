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
public interface IClassHelper {
   /**
    * @return
    */
   public ModelClass getModelClass();
   
   public GeneratorClass getGenClass();
   /**
    * @param class1
    */
   public void setModelClass(ModelClass class1);
   /**
    * Returns the qualified name of the given class. If the class is in the
    * same package the classname without package postfix will be returned.
    * If the class is in another package, the name with the ful qualified
    * package name is returned.
    * @deprecated Use GeneratorModelElement.getScopedName()
    */
   public String getType(ModelClassifier modelClassifier);
   /**
    * @param type
    * @return
    */
   public String getType(ModelDataType type);

   public String getType(ModelAttribute attribute);
   
   public String getClassName(ModelClassifier modelClassifier);
   
   public String getBaseClass(); 
   
   public String getNamespace(ModelClass modelClassifier);
   
   /**
    * Returns the namespace separator
    */
   public String getNamespaceSep();
   
   public String getInitializer(ModelAttribute attribute);
   
   public String getPackageName();
   
   public boolean isPrimitive(ModelDataType dataType);
}

//-------------------------------------------------------------------------
//$Log$
//Revision 1.1  2006/07/10 15:32:34  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.2  2005/10/27 10:52:45  moroff
//*** empty log message ***
//
//Revision 1.1  2005/10/26 13:03:37  moroff
//* Refactoring package names to org.umlmda
//* Generator configuration based on profiles and sets
//
//Revision 1.7  2005/10/20 21:19:51  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.6  2005/04/07 20:16:33  moroff
//* New isPrimitive()
//
//Revision 1.5  2005/03/13 17:09:49  moroff
//Avoid dependency c++ from idl writers
//
//Revision 1.4  2005/01/22 20:52:37  moroff
//New getPackageName()
//
//Revision 1.3  2004/12/08 22:15:24  moroff
//New getInitializer()
//
//Revision 1.2  2004/10/09 20:17:18  moroff
//New method getNamespace()
//
//Revision 1.1  2004/10/06 19:33:14  moroff
//* Target language specific signatures put in help-classes, delegating to these 
//   classes inside the writer classes
//
//-------------------------------------------------------------------------