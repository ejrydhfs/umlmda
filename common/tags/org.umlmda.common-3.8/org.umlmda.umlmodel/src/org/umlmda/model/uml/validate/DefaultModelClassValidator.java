/*
 * Created on 17.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml.validate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelElement;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DefaultModelClassValidator implements ModelElementValidator {

   /**
    * 
    */
   public DefaultModelClassValidator() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#isAppropriateFor(java.lang.Class)
    */
   public boolean isAppropriateFor(Class modelElementType) {
      return modelElementType.isAssignableFrom(ModelClass.class);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#isAppropriateForStereotypes(java.util.Collection)
    */
   public boolean isAppropriateForStereotypes(Collection stereotypes) {
      return true;
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public final List validate(ModelElement modelElement) {
      return validate((ModelClass)modelElement);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public List validate(ModelClass modelClass) {
      return Collections.EMPTY_LIST;
   }
   
}
