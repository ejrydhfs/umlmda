/*
 * Created on 28.11.2005
 */
package org.umlmda.generator.annotation;

import org.umlmda.generator.model.uml.GeneratorAssociation;
import org.umlmda.generator.model.uml.GeneratorAttribute;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorModelElement;

/**
 * @author MOROFF
 */
public interface AnnotationWriter
{
   String CONTEXT_GETTER = "getter";
   String CONTEXT_SETTER = "setter";

   /**
    * Add annotation on class level
    * 
    * @param genClass
    * @return
    */
   String getAnnotation(GeneratorClass genClass);

   String getAnnotation(GeneratorAttribute genAttribute, String context);

   String getAnnotation(GeneratorAssociation genAssociation, String context);

   String getAnnotation(GeneratorMethod genMethod);

   String getAnnotation(GeneratorModelElement genElement, String context);
}
