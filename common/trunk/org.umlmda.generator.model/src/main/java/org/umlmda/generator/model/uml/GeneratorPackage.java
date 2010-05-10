//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\GeneratorModelPackage.java

package org.umlmda.generator.model.uml;

public interface GeneratorPackage extends GeneratorModelElement
{

   /**
    * @param artefactName
    * @return
    */
   String getGeneratedName(String artefactName);

   /**
    * Returns the generated name of the current package and current generated artefact
    * 
    * @return
    */
   String getGeneratedName();

   /**
    * Returns the path the model should be generated into
    * 
    * @return
    */
   String getGeneratedPath();

   /**
    * Returns the qualified name of the package for the given artefact.
    */
   String getQualifiedPackageName(String artefactType);

   /**
    * @param artefactType
    * @return String
    * @roseuid 434A799D005E
    */
   String getQualifiedName(String artefactType);

   /**
    * @param artefactType
    * @param modelPackage
    * @return String
    * @roseuid 434A799D0068
    */
   String getQualifiedName(String artefactType, GeneratorPackage modelPackage);
}
