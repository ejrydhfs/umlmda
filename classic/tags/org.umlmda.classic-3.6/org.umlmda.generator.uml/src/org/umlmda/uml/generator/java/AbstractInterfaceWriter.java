// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/AbstractInterfaceWriter.java,v 1.2 2005/10/27 19:01:18 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/AbstractInterfaceWriter.java,v $
// $Revision: 1.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2005/10/27 19:01:18 $
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
// Created on:      21.08.2003
package org.umlmda.uml.generator.java;

import org.umlmda.generator.AbstractClassWriter;

import org.umlmda.model.uml.ModelClassifier;



/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class AbstractInterfaceWriter extends AbstractJavaClassWriter {
   public static class JavaClassHelper extends org.umlmda.uml.generator.java.JavaClassHelper { 
      public String getClassName(ModelClassifier classifier) {
         if ( classifier.hasStereotype("BusinessObject") || classifier.hasStereotype("BusinessService"))
            return "I"+super.getClassName(classifier);
         else
            return super.getClassName(classifier);   
      }
   }
   
   public AbstractInterfaceWriter() {
      super(new AbstractInterfaceWriter.JavaClassHelper());
   }

   public String getBusinessInterface() {
      return getClassName();
   }
}
