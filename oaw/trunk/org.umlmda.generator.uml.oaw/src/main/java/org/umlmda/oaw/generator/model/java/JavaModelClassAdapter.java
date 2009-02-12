/**
 * 
 */
package org.umlmda.oaw.generator.model.java;

import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.uml.generator.java.JavaModelAssociation;
import org.umlmda.uml.generator.java.JavaModelAttribute;
import org.umlmda.uml.generator.java.JavaModelMethod;

/**
 * @author MOROFF
 * 
 */
public class JavaModelClassAdapter extends org.umlmda.uml.generator.java.JavaModelClassAdapter implements
      JavaModelClass {

   /**
    * @param modelClassBase
    * @param model
    */
   public JavaModelClassAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   @SuppressWarnings("unchecked")
   public List<JavaModelAttribute> getJavaAttributes() {
      return getAttributes();
   }

   @SuppressWarnings("unchecked")
   public List<JavaModelAttribute> getJavaConstants() {
      return getConstants();
   }

   @SuppressWarnings("unchecked")
   public List<JavaModelAssociation> getJavaAssociations() {
      return getAssociations();
   }

   @SuppressWarnings("unchecked")
   public List<JavaModelMethod> getJavaMethods() {
      return getMethods();
   }

}
