/*
 * Created on 15.12.2005
 */
package org.umlmda.uml.generator.java;

import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelStructuralFeature;

/**
 * @author MOROFF
 */
public interface JavaModelStructuraleFeature extends ModelStructuralFeature, JavaModelElement
{

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
   ModelMethod getPostSetMethod();

   /**
    * Checks if a bound property exists
    */
   boolean isBound();

   /**
    * @return
    */
   JavaModelClass getOwningJavaClass();
}
