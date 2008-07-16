// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/j2ee/AbstractBeanWriter.java,v 1.2 2005/10/28 16:29:47 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/j2ee/AbstractBeanWriter.java,v $
// $Revision: 1.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2005/10/28 16:29:47 $
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
package org.umlmda.uml.generator.j2ee;

import org.umlmda.uml.generator.java.JavaMethodHelper;




/**
 * Base for writers generating the EJB-bean class
 * @author moroff
 */
public abstract class AbstractBeanWriter extends AbstractJ2EEInterfaceWriter {

   public AbstractBeanWriter() {
      super();
//      setClassHelper(new AbstractInterfaceWriter.JavaClassHelper() {
//         /* (non-Javadoc)
//          * @see net.sourceforge.umlmda.generator.IClassHelper#getPackageName()
//          */
//         public String getPackageName() {
//            return AbstractBeanWriter.this.getPackageName();
//         }
//         
//      });
      setMethodHelper(new JavaMethodHelper(getClassHelper()));
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getClassName()
    */
//   public String getClassName() {
//      return modelClass.getName() + "Bean";
//   }
   
   public String getBusinessClass() {
      return super.getClassName();
   }

}
