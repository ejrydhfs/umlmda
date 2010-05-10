// UMLMDA, GeneratorBase-API
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
 */
public interface IClassHelper
{
   /**
    * @return
    */
   ModelClass getModelClass();

   GeneratorClass getGenClass();

   /**
    * @param class1
    */
   void setModelClass(ModelClass class1);

   /**
    * Returns the qualified name of the given class. If the class is in the same package the classname without package postfix
    * will be returned. If the class is in another package, the name with the ful qualified package name is returned.
    * 
    * @deprecated Use GeneratorModelElement.getScopedName()
    */
   String getType(ModelClassifier modelClassifier);

   /**
    * @param type
    * @return
    */
   String getType(ModelDataType type);

   String getType(ModelAttribute attribute);

   String getClassName(ModelClassifier modelClassifier);

   String getBaseClass();

   String getNamespace(ModelClass modelClassifier);

   /**
    * Returns the namespace separator
    */
   String getNamespaceSep();

   String getInitializer(ModelAttribute attribute);

   String getPackageName();

   boolean isPrimitive(ModelDataType dataType);
}