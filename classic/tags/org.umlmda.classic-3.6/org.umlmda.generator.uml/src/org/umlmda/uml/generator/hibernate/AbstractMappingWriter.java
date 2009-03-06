/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/hibernate/AbstractMappingWriter.java,v 1.3 2006/07/10 15:37:13 moroff Exp $
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
 *  Created on Dec 9, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.hibernate;

import org.umlmda.generator.AbstractClassWriter;
import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.generator.model.util.DefaultMethodHelper;
import org.umlmda.uml.generator.sql.AbstractDDLWriter;

import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;

/**
 * Baseclass for writer generating hibernate mappings
 * @author moroff
 */
public abstract class AbstractMappingWriter extends AbstractClassWriter {
   public static class ClassHelper extends AbstractClassHelper {
      public String getType(ModelClassifier modelClassifier) {
         if ( modelClassifier instanceof ModelDataType ) {
            return getType((ModelDataType)modelClassifier);
         }
         else {
            return modelClassifier.getQualifiedName();
         }
      }

      public String getType(ModelDataType type) {
         if ( type.getName().equals("int"))
            return "integer";
         else if ( type.getName().equals("char"))
            return "character";
         else
            return type.getName();
      }

      public String getNamespaceSep() {
         return ".";
      }
      
   }
   public AbstractMappingWriter() {
      super(new ClassHelper(), new DefaultMethodHelper());
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractParentWriter#getFileExt()
    */
   public String getFileExt() {
      return ".hbm";
   }

   public static String getDbName(ModelAttribute attribute) {
      return AbstractDDLWriter.getDbName(attribute);
   }

   public String isNullable(ModelAttribute attribute) {
      //@@@TODO Implement from multiplicity-stereotype
      return "true";
   }
}
