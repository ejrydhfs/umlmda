/**
 * 
 */
package org.umlmda.oaw.generator.model.webservice;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;

/**
 * @author MOROFF
 */
public class WSBusinessObjectAdapter extends WSModelClassAdapter implements WSBusinessObject
{

   /**
    * @param modelClassBase
    * @param model
    */
   public WSBusinessObjectAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

}
