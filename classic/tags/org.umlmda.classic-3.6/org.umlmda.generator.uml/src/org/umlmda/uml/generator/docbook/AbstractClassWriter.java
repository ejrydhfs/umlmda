/*
 * Created on Nov 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.umlmda.uml.generator.docbook;

import org.umlmda.generator.AbstractEmbeddedClassWriter;
import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.uml.generator.java.JavaMethodHelper;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelElement;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractClassWriter extends AbstractEmbeddedClassWriter {

   public String getDocumentation(ModelElement element) {
      return Utils.getDocParagraphs(element);
   }
   
   public AbstractClassWriter() {
      super();
      setClassHelper(new AbstractClassHelper() {

         public String getType(ModelDataType type) {
            return type.getName();
         }

         public String getType(ModelClassifier type) {
            if ( type instanceof ModelClass ) {
               return "<link linkend=\""+type.getQualifiedName()+"\">"+super.getType(type)+"</link>";
            }
            else {
               return type.getName();
            }
         }
         
         public String getNamespaceSep() {
            return ".";
         }
         
      });
      setMethodHelper(new JavaMethodHelper(getClassHelper()));
   }
}
