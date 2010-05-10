/*
 * Created on 15.12.2005
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.model.uml.ModelClassifier;

/**
 * @author MOROFF
 */
public interface JavaModelClassifier extends JavaModelElement, ModelClassifier, GeneratorModelElement
{

   /**
    * Returns the type of a java classifier
    */
   String getType(String artefact);

   /**
    * Returns the java type in the current generator context
    * 
    * @return
    */
   String getJavaType();
}
