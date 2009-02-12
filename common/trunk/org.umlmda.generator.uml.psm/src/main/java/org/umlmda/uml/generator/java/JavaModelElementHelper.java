/*
 * Created on 28.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.annotation.AnnotationWriter;
import org.umlmda.generator.annotation.DefaultAnnotationWriter;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.util.FileUtils;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JavaModelElementHelper  {
   private final JavaModelElement modelElement;

   /**
    * @param modelElement
    * @param adaptedModel
    */
   public JavaModelElementHelper(JavaModelElement modelElement) {
      this.modelElement = modelElement;
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getDocumentation()
    */
   public String getDocumentation(String context) {
      String documentation = modelElement.getDocumentation();
      StringBuffer buffer = new StringBuffer();
      String annotation = getAnnotationWriter().getAnnotation(modelElement, context);
 
      documentation = StringUtils.replace(documentation, "<", "&lt;");
      documentation = StringUtils.replace(documentation, ">", "&gt;");
      if ( documentation != null ) {
         buffer.append(documentation);
      }
      if ( StringUtils.isNotEmpty(annotation) ) {
         buffer.append(FileUtils.newLine);
         if ( this instanceof GeneratorClass ) {
            buffer.append(" * ");
         }
         else {
            buffer.append("    * ");
         }
         buffer.append(annotation);
      }
      
      return buffer.toString();
   }
   
   private AnnotationWriter getAnnotationWriter() {
      AnnotationWriter writer = DefaultAnnotationWriter.getInstance();
      
      String emfAnnotations = modelElement.getGeneratorModel().getArtefact().getProperties().getProperty("EmfAnnotation", "false");
      
      if ( Boolean.valueOf(emfAnnotations).booleanValue() ) {
         writer = EmfAnnotationWriter.getEmfInstance();
      }
      
      return writer;
   }
   
}
