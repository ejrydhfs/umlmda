/**
 * 
 */
package org.umlmda.oaw.generator.model.webservice;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;

/**
 * @author MOROFF
 */
public class WSBusinessExceptionAdapter extends WSModelClassAdapter implements WSBusinessException
{
   private WSModelClass superClass;

   /**
    * @param modelClassBase
    * @param model
    */
   public WSBusinessExceptionAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   @Override
   public WSModelClass getSuperClass() {
      superClass = (WSModelClass) super.getSuperClass();

      if ( superClass == null ) {
         superClass = (WSModelClass) getModel().find(Exception.class.getName());
      }
      return superClass;
   }

}
