//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\GeneratorModel.java

package org.umlmda.generator.model.uml;

import java.util.Properties;
import java.util.Set;

import org.umlmda.generator.logging.LoggingWriter;
import org.umlmda.generator.model.util.CodeEmitter;
import org.umlmda.generator.model.util.RcsHelper;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;


public interface GeneratorModel  
{
   /**
    * Returns the currently used generation set
    */
   public GenerationSet getGenerationSet();

   /**
    * Sets the currently used generation set
    */
   public void setGenerationSet(GenerationSet generationSet);
   
   public GenerationProfile getProfile();

   public void setProfile(GenerationProfile generationProfile);

   public GeneratorContext getContext();

   /**
    * Returns a new code emitter to write code sniplets without templates
    */
   public CodeEmitter createEmitter();
   
   public RcsHelper getRcsHelper();
   
   /**
    * Returns the currently used artefact
    * @return
    */
   public Artefact getArtefact();
   
   /**
    * Returns a collection with all artefacts with have a mapping for the given stereotype
    * @param stereotype
    * @return Set of @link org.umlmda.generator.profile.Artefact
    */
   public Set getArtefacts(String stereotype);
   
   /** 
    * Returns the properties defined on the generation profile or the profile.
    * @return
    */
   public Properties getProperties();
   
   /**
    * Returns a set of model elements to be generated
    * @return Set of @link org.umlmda.uml.generator.GeneratorModelElement to be generated
    */
   public Set getModelElements();

   /**
    * Returns a artefact in the profile or any based on profiles fitting for the given model element 
    * @param artefactName
    * @return
    */
   public Artefact getArtefact(String artefactName, GeneratorModelElement genElement);
   
   public LoggingWriter getLoggingWriter();
   
}
