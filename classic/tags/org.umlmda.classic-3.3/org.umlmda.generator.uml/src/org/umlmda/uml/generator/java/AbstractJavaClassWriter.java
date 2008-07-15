/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/AbstractJavaClassWriter.java,v 1.5 2007/04/12 06:47:35 moroff Exp $
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on 20.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.AbstractClassWriter;
import org.umlmda.generator.annotation.AnnotationWriter;
import org.umlmda.generator.annotation.DefaultAnnotationWriter;
import org.umlmda.generator.model.uml.GeneratorModelElement;

/**
 * Baseclass for all Jostaca base writer generate java code
 * @author moroff
 */
public abstract class AbstractJavaClassWriter extends AbstractClassWriter {
   public static final String NONE_GENERATED_CODE_STRATEGY = "NoneGeneratedCodeStrategy";
   public static final String NONE_GENERATED_CODE_STRATEGY_USER_SECTION = "UserSection";
   public static final String NONE_GENERATED_CODE_STRATEGY_DELEGATE = "Delegate";
   public static final String NONE_GENERATED_CODE_STRATEGY_ABSTRACT_CLASS = "AbstractClass";
   
   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractParentWriter#getFileExt()
    */
   public String getFileExt() {
      return ".java";
   }
   /**
    * 
    */
   public AbstractJavaClassWriter() {
      super(new JavaClassHelper(), new JavaMethodHelper(null));
   }

   /**
    * 
    */
   public AbstractJavaClassWriter(JavaClassHelper classHelper) {
      super(classHelper, new JavaMethodHelper(classHelper));
   }
   
   public AnnotationWriter getAnnotationWriter() {
      AnnotationWriter writer = DefaultAnnotationWriter.getInstance();
      
      if ( getModelElement() instanceof GeneratorModelElement ) {
         GeneratorModelElement genElement = (GeneratorModelElement) getModelElement();
         String emfAnnotations = genElement.getGeneratorModel().getArtefact().getProperties().getProperty("EmfAnnotation", "false");
         
         if ( Boolean.valueOf(emfAnnotations).booleanValue() ) {
            writer = EmfAnnotationWriter.getEmfInstance();
         }
      }
      
      return writer;
   }
}
