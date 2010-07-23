//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\GeneratorContext.java

package org.umlmda.generator.model.uml;

import org.umlmda.generator.profile.Artefact;

/**
 * The context holds information about the current generated model element and artefact to simplify the writers.
 */
public interface GeneratorContext
{
   String CONTEXT_DEFAULT = "default";
   String CONTEXT_SETTER  = "setter";
   String CONTEXT_GETTER  = "getter";

   GeneratorModelElement getCurrentModelElement();

   void setCurrentModelElement(GeneratorModelElement currentModelElement);

   Artefact getCurrentArtefact();

   void setCurrentArtefact(Artefact currentGeneratorArtefact);

}
