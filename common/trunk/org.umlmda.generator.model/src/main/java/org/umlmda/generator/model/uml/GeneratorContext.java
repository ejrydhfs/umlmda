//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\GeneratorContext.java

package org.umlmda.generator.model.uml;

import org.umlmda.generator.profile.Artefact;


/**
 * The context holds information about the current generated model element and 
 * artefact to simplify the writers.
 */
public interface GeneratorContext 
{
   public final static String CONTEXT_DEFAULT = "default";
   public final static String CONTEXT_SETTER  = "setter";
   public final static String CONTEXT_GETTER  = "getter";
   
   public GeneratorModelElement getCurrentModelElement();

   public void setCurrentModelElement(GeneratorModelElement currentModelElement);
   
   public Artefact getCurrentArtefact();
   
   public void setCurrentArtefact(Artefact currentGeneratorArtefact);
   
}
