/*
 *   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/DelegationGenerationStrategy.java,v 1.2 2007/04/12 06:48:21 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/DelegationGenerationStrategy.java,v $
 * $Revision: 1.2 $
 *     $Name:  $
 *     $Date: 2007/04/12 06:48:21 $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created on 02.03.2007 (Dieter Moroff)
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.GenerationStrategy;
import org.umlmda.generator.model.uml.GeneratorModelElement;

/**
 * Strategy to decide if a delagation interface for none generatable code is
 * required
 * @author Dieter Moroff 
 */
public class DelegationGenerationStrategy implements GenerationStrategy {

   /**
    * 
    */
   public DelegationGenerationStrategy() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.GenerationStrategy#skipGeneration(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public boolean skipGeneration(GeneratorModelElement modelElement) {
      if ( modelElement instanceof JavaModelClass ) {
         JavaModelClass modelClass = (JavaModelClass) modelElement;
         
         return modelClass.isDelegationInterfaceNeeded() == false;
      }
      else {
         return true;
      }
   }

}
