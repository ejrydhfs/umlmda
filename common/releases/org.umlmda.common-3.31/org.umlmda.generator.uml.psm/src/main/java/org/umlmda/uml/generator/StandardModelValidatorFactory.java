/*
 * Created on 17.11.2005
 */
package org.umlmda.uml.generator;

import org.umlmda.model.uml.validate.ModelValidator;
import org.umlmda.model.uml.validate.ModelValidatorFactory;

/**
 * @author MOROFF
 */
public class StandardModelValidatorFactory implements ModelValidatorFactory
{

   /**
    * 
    */
   public StandardModelValidatorFactory() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.validate.ModelValidatorFactory#registerValidators(org.umlmda.model.uml.validate.ModelValidator)
    */
   public void registerValidators(ModelValidator modelValidator) {
      modelValidator.register(new StandardModelAttributeValidator());
      modelValidator.register(new StandardModelClassValidator());
      modelValidator.register(new StandardModelMethodValidator());
      modelValidator.register(new StandardModelParameterValidator());
   }

}
