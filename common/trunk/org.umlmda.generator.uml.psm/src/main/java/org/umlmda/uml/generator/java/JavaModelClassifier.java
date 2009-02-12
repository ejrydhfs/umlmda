/*
 * Created on 15.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.model.uml.ModelClassifier;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface JavaModelClassifier extends JavaModelElement, ModelClassifier, GeneratorModelElement {

   /**
    * Returns the type of a java classifier
    */
   String getType(String artefact);
   
   /**
    * Returns the java type in the current generator context
    * @return
    */
   String getJavaType();
}
