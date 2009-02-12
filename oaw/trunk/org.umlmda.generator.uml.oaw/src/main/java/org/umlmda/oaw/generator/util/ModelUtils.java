package org.umlmda.oaw.generator.util;

import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;

public class ModelUtils {

   public static String getGeneratedName(GeneratorModelElement modelElement, String artefact) {
      GeneratorModel genModel = modelElement.getGeneratorModel();
      
      genModel.getContext().setCurrentModelElement(modelElement);
      genModel.getContext().setCurrentArtefact(genModel.getArtefact(artefact, modelElement));
      
      return modelElement.getGeneratedName();
   }

}
