package org.umlmda.oaw.generator.model.java;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttributeBase;

public class JavaModelAttributeAdapter extends org.umlmda.uml.generator.java.JavaModelAttributeAdapter implements
      JavaModelAttribute
{

   public JavaModelAttributeAdapter(ModelAttributeBase modelAttribute, Model model) {
      super(modelAttribute, model);
   }

}
