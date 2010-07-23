/*
 * Created on 17.11.2005
 */
package org.umlmda.model.uml.validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelElement;

/**
 * @author MOROFF
 */
public class DefaultModelAttributeValidator implements ModelElementValidator
{
   final private boolean noTypesAllowed;

   /**
    * 
    */
   public DefaultModelAttributeValidator() {
      this(false);
   }

   /**
    * 
    */
   public DefaultModelAttributeValidator(boolean noTypesAllowed) {
      super();
      this.noTypesAllowed = noTypesAllowed;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#isAppropriateFor(java.lang.Class)
    */
   public boolean isAppropriateFor(Class modelElementType) {
      return ModelAttribute.class.isAssignableFrom(modelElementType);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.validate.ModelElementValidator#isAppropriateForStereotypes(java.util.Collection)
    */
   public boolean isAppropriateForStereotypes(Collection stereotypes) {
      return true;
   }

   /*
    * (non-Javadoc)
    * @see
    * org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public final List validate(ModelElement modelElement) {
      return validate((ModelAttribute) modelElement);
   }

   /*
    * (non-Javadoc)
    * @see
    * org.umlmda.generator.model.uml.validate.ModelElementValidator#validate(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public List validate(ModelAttribute modelAttribute) {
      List results = Collections.EMPTY_LIST;

      if ( noTypesAllowed == false && modelAttribute.getDataType() == null ) {
         if ( results == Collections.EMPTY_LIST ) {
            results = new ArrayList();
         }
         results.add(ValidationResult.createError("No type specified", modelAttribute));
      }
      return results;
   }

}
