//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\GeneratorModelClass.java

package org.umlmda.generator.model.uml;




/**
 * Interface for a model class using in a generator.
 */
public interface GeneratorClass extends GeneratorClassifier 
{
   /**
    * Returns the name of the current class
    * @return
    */
   public String getName();
   
   /**
    * Returns the generated name of the current class
    * and current generated artefact
    * @return
    */
   public String getGeneratedName();
   
   /**
    * Returns the path the model should be generated into
    * @return
    */
   public String getGeneratedPath();
   
   
   /**
    * Returns the generated name of the current class
    * and the given artefact
    * @param string
    * @return
    */
   public String getGeneratedName(String artefactType);
   
   /**
    * @param artefactType
    * @return String
    * @roseuid 4346597300A3
    */
   public String getQualifiedName(String artefactName);
   
   /**
    * @param artefactType
    * @param modelClass
    * @return String
    * @roseuid 43465A200205
    */
   public String getQualifiedName(String artefactName, GeneratorClass modelClass);

   /**
    * @param ws_request
    * @param method
    * @return
    */
   public String getQualifiedName(String artefactName, GeneratorMethod method);
   
   /**
    * @return
    */
   public GeneratorPackage getGeneratorPackage();

   /**
    * Returns a name qualified or non qualifed in the context of the current class
    * for the given artefact
    * @param string
    * @return
    */
   public String getScopedName(String artefactName);

   /**
    * Returns a name qualified or non qualifed in the context of the current class
    * for the given artefact
    * @param string
    * @return
    */
   public String getScopedName(String artefactName, GeneratorClass genClass);

   /**
    * @param business_object_factory_impl
    * @param modelPackage
    * @return
    */
   String getScopedName(String artefactName, GeneratorPackage modelPackage);


}
