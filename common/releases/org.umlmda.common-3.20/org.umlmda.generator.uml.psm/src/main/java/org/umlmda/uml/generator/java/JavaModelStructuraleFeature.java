/*
 * Created on 15.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelStructuralFeature;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface JavaModelStructuraleFeature extends ModelStructuralFeature, JavaModelElement {

   /**
    * Returns the name of a java get method for the structural feature
    */
   String getGetter();

   /**
    * Returns the name of a java set method for the structural feature
    */
   String getSetter();
 
   /**
    * Returns the java datatype for the structural feature assuming   
    */
   String getType();

   /**
    * Returns the java datatype for the structural feature  
    */
   String getType(String artefact);

   /**
    * Returns the method called for bound properties.
    */
   public ModelMethod getPostSetMethod();

   /**
    * Checks if a bound property exists
    */
   public boolean isBound();

   /**
    * @return
    */
   JavaModelClass getOwningJavaClass();
}
