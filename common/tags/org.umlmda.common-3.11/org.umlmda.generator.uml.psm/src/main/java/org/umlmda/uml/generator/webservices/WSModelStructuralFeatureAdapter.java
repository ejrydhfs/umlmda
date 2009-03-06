/*
 * Created on 13.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelStructuralFeatureBase;
import org.umlmda.model.uml.impl.ModelStructuralFeatureAdapter;
import org.umlmda.profile.ModelStereotype;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class WSModelStructuralFeatureAdapter extends ModelStructuralFeatureAdapter implements WSModelStructuralFeature {

   /**
    * @param modelStructuralFeature
    * @param model
    */
   public WSModelStructuralFeatureAdapter(ModelStructuralFeatureBase modelStructuralFeature, Model model) {
      super(modelStructuralFeature, model);
   }

   /* (non-Javadoc)
    * @see WSModelStructuralFeature#matchDirection(java.lang.String)
    */
   public boolean matchDirection(String direction) {
      if ( direction.equals(ModelStereotype.DIRECTION_IN) ) {
         return hasStereotype(ModelStereotype.DIRECTION_OUT) == false;
      }
      else if ( direction.equals(ModelStereotype.DIRECTION_OUT) ) {
         return hasStereotype(ModelStereotype.DIRECTION_IN) == false;
      }
      else
         return true;
   }

   
}
