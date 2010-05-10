// UMLMDA, GeneratorBase-API
//  
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
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelDataType;

/**
 * This helperclass for generating class signatures. This base implementation return a java method signature. It can be derived to
 * generate c++ or idl class signatures.
 * 
 * @author Dieter Moroff
 */
public class JavaClassHelper extends AbstractClassHelper
{
   /**
    * 
    */
   public JavaClassHelper() {
      super();
   }

   public String getType(ModelAttribute attribute) {
      return ((JavaModelAttribute) attribute).getJavaType();
   }

   public String getInitializer(ModelAttribute attribute) {
      if ( attribute.isOptional() || attribute.isMultivalue() ) {
         return "null";
      }
      else {
         return super.getInitializer(attribute);
      }
   }

   /**
    * @param type
    * @return
    */
   public String getType(ModelDataType type) {
      if ( type != null ) {
         return ((JavaModelDataType) type).getJavaType();
      }
      else {
         return "void";
      }
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassHelper#getNamespaceSep()
    */
   public String getNamespaceSep() {
      return ".";
   }

}