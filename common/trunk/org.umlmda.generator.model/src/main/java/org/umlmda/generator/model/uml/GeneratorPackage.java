//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\GeneratorModelPackage.java

package org.umlmda.generator.model.uml;



public interface GeneratorPackage extends GeneratorModelElement 
{

   /**
    * @param artefactName
    * @return
    */
   public String getGeneratedName(String artefactName);
   
   /**
    * Returns the generated name of the current package
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
    * Returns the qualified name of the package for the given artefact.
    */
   public String getQualifiedPackageName(String artefactType);
   
   /**
    * @param artefactType
    * @return String
    * @roseuid 434A799D005E
    */
   public String getQualifiedName(String artefactType);
   
   /**
    * @param artefactType
    * @param modelPackage
    * @return String
    * @roseuid 434A799D0068
    */
   public String getQualifiedName(String artefactType, GeneratorPackage modelPackage);
}
