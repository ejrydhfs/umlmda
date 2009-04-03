/**
 * 
 */
package org.umlmda.oaw.generator.model.java;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.uml.generator.java.JavaModelClassAdapter;

/**
 * @author MOROFF
 *
 */
public class JavaBusinessServiceAdapter extends JavaModelClassAdapter implements JavaBusinessService {

   /**
    * @param modelClassBase
    * @param model
    */
   public JavaBusinessServiceAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

}
