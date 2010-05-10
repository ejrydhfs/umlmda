/**
 * 
 */
package org.umlmda.oaw.generator.model.java;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;

/**
 * @author MOROFF
 */
public class JavaBusinessObjectAdapter extends JavaModelClassAdapter implements JavaBusinessObject
{

   /**
    * @param modelClassBase
    * @param model
    */
   public JavaBusinessObjectAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

}
