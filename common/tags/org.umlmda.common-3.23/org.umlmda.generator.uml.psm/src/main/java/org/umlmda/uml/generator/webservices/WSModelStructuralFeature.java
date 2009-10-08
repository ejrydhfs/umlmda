/*
 * Created on 13.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.model.uml.ModelStructuralFeature;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModelStructuralFeature extends ModelStructuralFeature {

   /**
    * Checks if the attribute matches the given direction.
    * @param direction can be <b>In</b> or <b>Out</b>.
    */
   public boolean matchDirection(String direction);

   /**
    * Returns the nillable-Tag depending on the multiplicity of the attribute.
    */
   public String getNillableTag();
   
   /**
    * Returns the minOccurs-Tag depending on the multiplicity of the attribute.
    */
   public String getMinOccursTag();

   /**
    * Returns the minOccurs-Tag depending on the multiplicity of the attribute.
    */
   public String getMaxOccursTag();
   
}
