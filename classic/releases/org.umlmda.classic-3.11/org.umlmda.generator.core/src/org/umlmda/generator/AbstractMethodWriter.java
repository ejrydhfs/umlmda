// UMLMDA, GeneratorBase-API
//
// $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractMethodWriter.java,v 1.3 2006/07/10 15:29:47 moroff Exp $
// $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractMethodWriter.java,v $
// $Revision: 1.3 $
// $State: Exp $
//  $Name:  $
//  $Date: 2006/07/10 15:29:47 $
// $Locker:  $
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
// Created on:      03.11.2005
package org.umlmda.generator;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;

/**
 * Abstract writer base class for model methods
 * @author MOROFF
 */
public abstract class AbstractMethodWriter extends AbstractModelElementWriter {
   GeneratorMethod genMethod = null;
   
   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractMethodWriter(IClassHelper classHelper, IMethodHelper methodHelper) {
      super(classHelper, methodHelper);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractParentWriter#getBaseName()
    */
   public String getBaseName() {
      return genMethod.getGeneratedName();
   }


   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractWriter#setModelElement(java.lang.Object)
    */
   public void setModelElement(Object element) {
      if ( element instanceof GeneratorMethod ) {
         super.setModelElement(element);
         setGenMethod((GeneratorMethod) element);
      }
      else {
         throw new RuntimeException("Element must be instanceof "+GeneratorMethod.class+", "+element.getClass()+" is invalid");
      }
   }
   /**
    * @return Returns the genMethod.
    */
   public GeneratorMethod getGenMethod() {
      return genMethod;
   }
   
   /**
    * @param genMethod The genMethod to set.
    */
   public void setGenMethod(GeneratorMethod genMethod) {
      this.genMethod = genMethod;
   }
   
   
   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractModelElementWriter#getGenPackage()
    */
   public GeneratorPackage getGenPackage() {
      String artefact = genMethod.getGeneratorModel().getContext().getCurrentArtefact().getName();
      GeneratorClass genClass = getGenMethod().getGeneratorClass();
      GeneratorPackage genPackage = genClass.getGeneratorPackage();
      
      return genPackage;
   }
      
}
