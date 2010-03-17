/**
 * 
 */
package org.umlmda.oaw.generator.model.webservice;

import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.uml.generator.webservices.WSModelAssociation;
import org.umlmda.uml.generator.webservices.WSModelMethod;

/**
 * @author MOROFF
 * 
 */
public class WSModelClassAdapter extends org.umlmda.uml.generator.webservices.WSModelClassAdapter implements
      WSModelClass {

   /**
    * @param modelClassBase
    * @param model
    */
   public WSModelClassAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   @SuppressWarnings("unchecked")
   public List<WSModelAttribute> getJavaAttributes() {
      return getAttributes();
   }

   @SuppressWarnings("unchecked")
   public List<WSModelAttribute> getJavaConstants() {
      return getConstants();
   }

   @SuppressWarnings("unchecked")
   public List<WSModelAssociation> getJavaAssociations() {
      return getAssociations();
   }

   @SuppressWarnings("unchecked")
   public List<WSModelMethod> getJavaMethods() {
      return getMethods();
   }

}
