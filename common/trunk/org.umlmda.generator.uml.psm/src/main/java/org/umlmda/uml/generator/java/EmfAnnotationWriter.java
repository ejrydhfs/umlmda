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
import org.umlmda.generator.model.uml.GeneratorAssociation;
import org.umlmda.generator.model.uml.GeneratorAttribute;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.util.FileUtils;
import org.umlmda.profile.ModelStereotype;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EmfAnnotationWriter extends DefaultAnnotationWriter implements AnnotationWriter {
   static private final AnnotationWriter emfInstance = new EmfAnnotationWriter();
   
   /**
    * 
    */
   public EmfAnnotationWriter() {
      super();
   }

   /**
    * @return Returns the instance.
    */
   public static AnnotationWriter getEmfInstance() {
      return emfInstance;
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorClass)
    */
   public String getAnnotation(GeneratorClass genClass) {
      StringBuffer buffer = new StringBuffer();
      
      if (genClass instanceof JavaModelClass) {
         JavaModelClass modelClass = (JavaModelClass) genClass;
         
         buffer.append("@model");
         if ( modelClass.isAbstract() ) {
            buffer.append(" abstract=\"true\"");
         }
         buffer.append(FileUtils.newLine);
      }
      
      return buffer.toString();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorAttribute)
    */
   public String getAnnotation(GeneratorAttribute genAttribute, String context) {
      StringBuffer buffer = new StringBuffer();

      if (context.equals(CONTEXT_GETTER) && genAttribute instanceof JavaModelAttribute) {
         JavaModelAttribute modelAttribute = (JavaModelAttribute) genAttribute;
         JavaModelClassifier classifier = (JavaModelClassifier) modelAttribute.getModelClassifier();
         
         buffer.append("@model");
         if ( StringUtils.isNotEmpty(modelAttribute.getInitialValue()) ) {
            buffer.append(" default=\""+modelAttribute.getInitialValue()+"\"");
         }
         if ( modelAttribute.hasStereotype(ModelStereotype.ATTRIBUTE_PKEY) ) {
            buffer.append(" id=\"true\"");
         }
         if ( modelAttribute.isMultivalue() ) {
            buffer.append(" type=\""+classifier.getJavaType()+"\" ordered=\"true\"");
         }
         if ( modelAttribute.isOptional() == false ) {
            buffer.append(" required=\"true\"");
         }
         if ( modelAttribute.isReadOnly() ) {
            buffer.append(" unsettable=\"true\"");
         }
         if ( modelAttribute.isDerived() ) {
            buffer.append(" transient=\"true\"");
         }
         
         buffer.append(FileUtils.newLine);
         
      }
      return buffer.toString();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorAssociation)
    */
   public String getAnnotation(GeneratorAssociation genAssociation, String context) {
      StringBuffer buffer = new StringBuffer();

      if (context.equals(CONTEXT_GETTER) && genAssociation instanceof JavaModelAssociation) {
         JavaModelAssociation modelAssocation = (JavaModelAssociation) genAssociation;
         JavaModelClass target = (JavaModelClass) modelAssocation.getTarget();
         
         buffer.append("@model");
         if ( modelAssocation.isComposition() ) {
            buffer.append(" containment=\"true\"");
         }
         if ( modelAssocation.isMultiple() ) {
            buffer.append(" many=\"true\" type=\""+target.getQualifiedName(JavaArtefacts.BUSINESS_OBJECT_INTERFACE)+"\"");
         }
         if ( modelAssocation.isOptional() == false ) {
            buffer.append(" required=\"true\"");
         }
         if ( modelAssocation.isReadOnly() ) {
            buffer.append(" unsettable=\"true\"");
         }
         if ( modelAssocation.isDerived() ) {
            buffer.append(" transient=\"true\"");
         }
         
         buffer.append(FileUtils.newLine);
         
      }
      
      return buffer.toString();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String getAnnotation(GeneratorMethod genMethod) {
      StringBuffer buffer = new StringBuffer();
      
      return buffer.toString();
   }

}
