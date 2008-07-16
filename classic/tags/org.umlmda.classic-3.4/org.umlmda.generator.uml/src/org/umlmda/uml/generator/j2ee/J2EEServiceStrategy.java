/*
 *   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/j2ee/J2EEServiceStrategy.java,v 1.1 2007/04/12 07:08:21 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/j2ee/J2EEServiceStrategy.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2007/04/12 07:08:21 $
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
 * Created on 31.03.2007 (Dieter Moroff)
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.generator.GenerationStrategy;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.profile.ModelStereotype;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class J2EEServiceStrategy implements GenerationStrategy {

   /* (non-Javadoc)
    * @see org.umlmda.generator.GenerationStrategy#skipGeneration(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public boolean skipGeneration(GeneratorModelElement modelElement) {
      if (modelElement instanceof ModelPackage) {
         ModelPackage modelPackage = (ModelPackage) modelElement;
         
         return modelPackage.getClasses(ModelStereotype.BUSINESS_SERVICE).size() == 0;
      }
      else
         return true;
   }

}
