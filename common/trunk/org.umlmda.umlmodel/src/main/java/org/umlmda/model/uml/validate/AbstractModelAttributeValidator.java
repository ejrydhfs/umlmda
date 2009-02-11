/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/validate/AbstractModelAttributeValidator.java,v 1.1 2006/05/04 15:16:30 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/validate/AbstractModelAttributeValidator.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/05/04 15:16:30 $
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
 * Created by Dieter Moroff (01.05.2006)
 */
package org.umlmda.model.uml.validate;

import java.util.Collection;
import java.util.List;

import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelElement;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (01.05.2006), last change $Date: 2006/05/04 15:16:30 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public abstract class AbstractModelAttributeValidator extends AbstractModelElementValidator {

   /**
    * 
    */
   public AbstractModelAttributeValidator() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#isAppropriateFor(java.lang.Class)
    */
   public final boolean isAppropriateFor(Class modelElementType) {
      return ModelAttribute.class.isAssignableFrom(modelElementType);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public final List validate(ModelElement modelElement) {
      return validateAttribute((ModelAttribute)modelElement);
   }
   
   protected abstract List validateAttribute(ModelAttribute attribute); 
   
}
