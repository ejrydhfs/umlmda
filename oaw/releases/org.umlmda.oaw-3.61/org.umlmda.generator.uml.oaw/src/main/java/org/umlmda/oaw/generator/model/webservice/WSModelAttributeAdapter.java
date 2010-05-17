package org.umlmda.oaw.generator.model.webservice;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttributeBase;

public class WSModelAttributeAdapter extends org.umlmda.uml.generator.java.JavaModelAttributeAdapter implements WSModelAttribute
{

   public WSModelAttributeAdapter(ModelAttributeBase modelAttribute, Model model) {
      super(modelAttribute, model);
   }

}
