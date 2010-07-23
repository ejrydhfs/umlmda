/*
 * Created on 17.11.2005
 */
package org.umlmda.model.uml.validate;

import java.util.Collection;
import java.util.List;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelElement;

/**
 * @author MOROFF
 */
public abstract class AbstractModelClassValidator extends AbstractModelElementValidator
{

   /**
    * 
    */
   public AbstractModelClassValidator() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#isAppropriateFor(java.lang.Class)
    */
   public final boolean isAppropriateFor(Class modelElementType) {
      return modelElementType.isAssignableFrom(ModelClass.class);
   }

   /*
    * (non-Javadoc)
    * @see
    * org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public final List validate(ModelElement modelElement) {
      return validate((ModelClass) modelElement);
   }

   /*
    * (non-Javadoc)
    * @see
    * org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public abstract List validateClass(ModelClass modelClass);

}
