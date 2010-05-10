/*
 * Created on 28.11.2005
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorAssociation;
import org.umlmda.model.uml.ModelAssociation;

/**
 * @author MOROFF
 */
public interface JavaModelAssociation extends JavaModelStructuraleFeature, ModelAssociation, GeneratorAssociation
{

   /**
    * Returns the interface type for the assocation
    */
   String getInterfaceType();

   String getCollectionInterfaceType();

   /**
    * Returns the implementation type for the assocation
    */
   String getImplementationType();

   String getCollectionImplementationType();

   /**
    * Returns the implementation interface type for the assocation
    */
   String getImplementationInterfaceType();

}
