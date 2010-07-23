/*
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
 * Created by Dieter Moroff (02.05.2006)
 */
package org.umlmda.model.uml.validate;

import java.util.Collection;
import java.util.List;

import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelMethod;

/**
 * TODO Insert type javadoc
 * 
 */
public abstract class AbstractModelMethodValidator extends AbstractModelElementValidator
{

   /**
    * 
    */
   public AbstractModelMethodValidator() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.validate.ModelElementValidator#isAppropriateFor(java.lang.Class)
    */
   public final boolean isAppropriateFor(Class modelElementType) {
      return ModelMethod.class.isAssignableFrom(modelElementType);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.validate.ModelElementValidator#validate(org.umlmda.model.uml.ModelElement)
    */
   public final List validate(ModelElement modelElement) {
      return validateMethod((ModelMethod) modelElement);
   }

   /**
    * @param method
    * @return
    */
   protected abstract List validateMethod(ModelMethod method);

}
