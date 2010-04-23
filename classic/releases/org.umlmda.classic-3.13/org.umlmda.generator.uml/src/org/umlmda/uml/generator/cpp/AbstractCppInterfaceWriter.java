/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/AbstractCppInterfaceWriter.java,v 1.2 2005/10/27 19:04:41 moroff Exp $
 *  Copyright (C) 2003, 2004 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://umlmda.sf.net)
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
 *  Created on Oct 1, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.cpp;

import java.util.Set;


import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;

/**
 * @author moroff
 */
public abstract class AbstractCppInterfaceWriter extends AbstractCppClassWriter {

   public static class CppClassHelper extends org.umlmda.uml.generator.cpp.CppClassHelper {
      public String getClassName(ModelClassifier classifier) {
         if ( classifier.hasStereotype("BusinessObject") || classifier.hasStereotype("BusinessService"))
            return "I"+classifier.getName();
         else
            return classifier.getName();   
      }
      
   }
   
   public AbstractCppInterfaceWriter() {
      super();
      setClassHelper(new AbstractCppInterfaceWriter.CppClassHelper());
      setMethodHelper(new CppMethodHelper(getClassHelper(), false));
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractWriter#getFileExt()
    */
   public String getFileExt() {
      return ".cpp";
   }

   protected void addReferencedType(Set referencedTypes, ModelClassifier modelClassifier) {
      if (modelClassifier instanceof ModelClass) {
         ModelClass modelClass = (ModelClass) modelClassifier;

         referencedTypes.add(modelClass);
      }
   }



}
