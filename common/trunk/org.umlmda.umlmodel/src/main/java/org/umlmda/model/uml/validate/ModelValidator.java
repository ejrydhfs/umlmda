/*
 * Created on 17.11.2005
 */
package org.umlmda.model.uml.validate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.utils.ModelIterator;

/**
 * @author MOROFF
 */
public class ModelValidator
{
   List validators = new ArrayList();

   /**
    * 
    */
   public ModelValidator() {
      super();
   }

   public void register(ModelElementValidator validator) {
      validators.add(validator);
   }

   public List validate(Model model) {
      final List results = new ArrayList();

      new ModelIterator(new ModelIterator.Action() {

         public void process(ModelElement modelElement) {
            validateElement(results, modelElement);

         }
      }).iterate(model);

      return results;
   }

   private void validateElement(List results, ModelElement element) {
      for ( Iterator iv = validators.iterator(); iv.hasNext(); ) {
         ModelElementValidator validator = (ModelElementValidator) iv.next();

         if ( validator.isAppropriateFor(element.getClass()) && validator.isAppropriateForStereotypes(element.getStereotypes()) ) {
            List result = validator.validate(element);

            results.addAll(result);
         }
      }
   }
}
