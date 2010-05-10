/*
 * Created on 28.11.2005
 */
package org.umlmda.generator.annotation;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorAssociation;
import org.umlmda.generator.model.uml.GeneratorAttribute;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorModelElement;

/**
 * @author MOROFF
 */
public class DefaultAnnotationWriter implements AnnotationWriter
{
   static private DefaultAnnotationWriter instance = new DefaultAnnotationWriter();

   /**
    * 
    */
   public DefaultAnnotationWriter() {
      super();
   }

   /**
    * @return Returns the instance.
    */
   public static DefaultAnnotationWriter getInstance() {
      return instance;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorClass)
    */
   public String getAnnotation(GeneratorClass genClass) {
      return StringUtils.EMPTY;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorAttribute,
    * java.lang.String)
    */
   public String getAnnotation(GeneratorAttribute genAttribute, String context) {
      return StringUtils.EMPTY;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorAssociation,
    * java.lang.String)
    */
   public String getAnnotation(GeneratorAssociation genAssociation, String context) {
      return StringUtils.EMPTY;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String getAnnotation(GeneratorMethod genMethod) {
      return StringUtils.EMPTY;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.annotation.AnnotationWriter#getAnnotation(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public final String getAnnotation(GeneratorModelElement genElement, String context) {
      if ( genElement instanceof GeneratorClass ) {
         return getAnnotation((GeneratorClass) genElement);
      }
      else if ( genElement instanceof GeneratorAssociation ) {
         return getAnnotation((GeneratorAssociation) genElement, context);
      }
      else if ( genElement instanceof GeneratorAttribute ) {
         return getAnnotation((GeneratorAttribute) genElement, context);
      }
      else if ( genElement instanceof GeneratorMethod ) {
         return getAnnotation((GeneratorMethod) genElement);
      }
      else {
         return StringUtils.EMPTY;
      }
   }

}
