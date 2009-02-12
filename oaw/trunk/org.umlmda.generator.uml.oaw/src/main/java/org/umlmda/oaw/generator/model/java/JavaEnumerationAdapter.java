/**
 * 
 */
package org.umlmda.oaw.generator.model.java;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.uml.generator.java.JavaModelAttribute;

/**
 * @author MOROFF
 *
 */
public class JavaEnumerationAdapter extends JavaModelClassAdapter implements JavaEnumeration {

   /**
    * @param modelClassBase
    * @param model
    */
   public JavaEnumerationAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

   public String getJavaValueType() {
      return ((JavaModelAttribute)getAttributes().get(0)).getJavaType();
   }

   public boolean isValuePrimitive() {
      return ((JavaModelAttribute)getAttributes().get(0)).isJavaPrimitiveType();
   }

}
