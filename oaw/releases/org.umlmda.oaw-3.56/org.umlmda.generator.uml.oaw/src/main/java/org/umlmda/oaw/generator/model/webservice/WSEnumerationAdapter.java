/**
 * 
 */
package org.umlmda.oaw.generator.model.webservice;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.uml.generator.java.JavaModelAttribute;

/**
 * @author MOROFF
 *
 */
public class WSEnumerationAdapter extends WSModelClassAdapter implements WSEnumeration {

   /**
    * @param modelClassBase
    * @param model
    */
   public WSEnumerationAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   public String getJavaValueType() {
      return ((JavaModelAttribute)getAttributes().get(0)).getJavaType();
   }

   public boolean isValuePrimitive() {
      return ((JavaModelAttribute)getAttributes().get(0)).isJavaPrimitiveType();
   }

}
