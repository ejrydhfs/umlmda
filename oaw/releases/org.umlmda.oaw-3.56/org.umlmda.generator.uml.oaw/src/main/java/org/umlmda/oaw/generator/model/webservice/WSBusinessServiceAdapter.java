/**
 * 
 */
package org.umlmda.oaw.generator.model.webservice;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;

/**
 * @author MOROFF
 *
 */
public class WSBusinessServiceAdapter extends WSModelClassAdapter implements WSBusinessService {

   /**
    * @param modelClassBase
    * @param model
    */
   public WSBusinessServiceAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

}
