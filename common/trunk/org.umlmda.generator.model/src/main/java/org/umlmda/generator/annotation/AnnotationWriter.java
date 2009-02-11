/*
 * Created on 28.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.generator.annotation;

import org.umlmda.generator.model.uml.GeneratorAssociation;
import org.umlmda.generator.model.uml.GeneratorAttribute;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorModelElement;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface AnnotationWriter {
   public final static String CONTEXT_GETTER = "getter";
   public final static String CONTEXT_SETTER = "setter";
   
   /**
    * Add annotation on class level
    * @param genClass
    * @return
    */
   String getAnnotation(GeneratorClass genClass);

   String getAnnotation(GeneratorAttribute genAttribute, String context);
   
   String getAnnotation(GeneratorAssociation genAssociation, String context);
   
   String getAnnotation(GeneratorMethod genMethod);

   String getAnnotation(GeneratorModelElement genElement, String context);
}
