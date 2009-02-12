/*
 * Created on 17.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator;

import org.umlmda.model.uml.validate.ModelValidator;
import org.umlmda.model.uml.validate.ModelValidatorFactory;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StandardModelValidatorFactory implements ModelValidatorFactory {

   /**
    * 
    */
   public StandardModelValidatorFactory() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.validate.ModelValidatorFactory#registerValidators(org.umlmda.model.uml.validate.ModelValidator)
    */
   public void registerValidators(ModelValidator modelValidator) {
      modelValidator.register(new StandardModelAttributeValidator());
      modelValidator.register(new StandardModelClassValidator());
      modelValidator.register(new StandardModelMethodValidator());
      modelValidator.register(new StandardModelParameterValidator());
   }

}
