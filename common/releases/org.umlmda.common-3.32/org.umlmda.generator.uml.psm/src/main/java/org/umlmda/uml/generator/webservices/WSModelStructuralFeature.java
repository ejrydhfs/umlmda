/*
 * Created on 13.12.2005
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.model.uml.ModelStructuralFeature;

/**
 * @author MOROFF
 */
public interface WSModelStructuralFeature extends ModelStructuralFeature
{

   /**
    * Checks if the attribute matches the given direction.
    * 
    * @param direction
    *           can be <b>In</b> or <b>Out</b>.
    */
   boolean matchDirection(String direction);

   /**
    * Returns the nillable-Tag depending on the multiplicity of the attribute.
    */
   String getNillableTag();

   /**
    * Returns the minOccurs-Tag depending on the multiplicity of the attribute.
    */
   String getMinOccursTag();

   /**
    * Returns the minOccurs-Tag depending on the multiplicity of the attribute.
    */
   String getMaxOccursTag();

}
