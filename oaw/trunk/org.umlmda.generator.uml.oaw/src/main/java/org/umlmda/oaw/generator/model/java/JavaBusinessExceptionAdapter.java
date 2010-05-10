/**
 * 
 */
package org.umlmda.oaw.generator.model.java;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;

/**
 * @author MOROFF
 */
public class JavaBusinessExceptionAdapter extends JavaModelClassAdapter implements JavaBusinessException
{
   private JavaModelClass superClass;

   /**
    * @param modelClassBase
    * @param model
    */
   public JavaBusinessExceptionAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   @Override
   public JavaModelClass getSuperClass() {
      superClass = (JavaModelClass) super.getSuperClass();

      if ( superClass == null ) {
         superClass = (JavaModelClass) getModel().find(Exception.class.getName());
      }
      return superClass;
   }

}
