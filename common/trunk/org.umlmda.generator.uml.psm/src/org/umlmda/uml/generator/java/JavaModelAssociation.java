/*
 * Created on 28.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorAssociation;
import org.umlmda.model.uml.ModelAssociation;

/**
 * @author MOROFF
 */
public interface JavaModelAssociation extends JavaModelStructuraleFeature, ModelAssociation, GeneratorAssociation {

   /**
    * Returns the interface type for the assocation
    */
   String getInterfaceType();
   
   /**
    * Returns the implementation type for the assocation
    */
   String getImplementationType();
   
   /**
    * Returns the implementation interface type for the assocation
    */
   public String getImplementationInterfaceType();
   
}
