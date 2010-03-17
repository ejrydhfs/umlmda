package org.umlmda.oaw.generator.util;

import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;

/**
 * Utility and convenience methods for {@link GeneratorModelElement} and other classes of the scope <i>org.umlmda.generator.model.uml</i>.
 */
public class GeneratorModelElementUtils
{

   /**
    * Returns the generated name for the model elements as defined by the given artefact name.
    */
   public static String getGeneratedName(GeneratorModelElement modelElement, String artefact) {
      GeneratorModel genModel = modelElement.getGeneratorModel();

      genModel.getContext().setCurrentModelElement(modelElement);
      genModel.getContext().setCurrentArtefact(genModel.getArtefact(artefact, modelElement));

      return modelElement.getGeneratedName();
   }

}
