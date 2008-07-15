/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/sql/AbstractDDLWriter.java,v 1.5 2006/07/10 15:37:09 moroff Exp $
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
package org.umlmda.uml.generator.sql;

import java.util.Collection;
import java.util.Iterator;

import org.umlmda.generator.AbstractClassWriter;
import org.umlmda.generator.model.util.AbstractClassHelper;
import org.umlmda.generator.model.util.DefaultMethodHelper;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.profile.ModelTaggedValues;

import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;

/**
 * Baseclass for writer generating hibernate mappings
 * @author moroff
 */
public abstract class AbstractDDLWriter extends AbstractClassWriter {
   private static class ClassHelper extends AbstractClassHelper {
      public String getType(ModelClassifier modelClassifier) {
         if ( modelClassifier instanceof ModelDataType ) {
            return getType((ModelDataType)modelClassifier);
         }
         else {
            return modelClassifier.getQualifiedName();
         }
      }

      public String getType(ModelDataType type) {
         if ( type.getName().equals(ModelDataType.INT))
            return "INTEGER";
         else if ( type.getName().equals(ModelDataType.LONG))
            return "INTEGER";
         else if ( type.getName().equals(ModelDataType.SHORT))
            return "SMALLINT";
         else if ( type.getName().equals(ModelDataType.CHAR))
            return "CHAR(1)";
         else if ( type.getName().equals(ModelDataType.FLOAT))
            return "FLOAT";
         else if ( type.getName().equals(ModelDataType.DOUBLE))
            return "DOUBLE PRECISION";
         else if ( type.getName().equals(ModelDataType.DECIMAL))
            return "DOUBLE PRECISION";
         else if ( type.getName().equals(ModelDataType.STRING))
            return "CHARACTER VARYING";
         else if ( type.getName().equals(ModelDataType.DATE))
            return "DATE";
         else if ( type.getName().equals(ModelDataType.BOOLEAN))
            return "CHAR(5)";
         else
            return type.getName();
      }

      public String getNamespaceSep() {
         return ".";
      }
      
   };
   public AbstractDDLWriter() {
      super(new ClassHelper(), new DefaultMethodHelper());
   }
   
   public String getDbName() {
      return getDbName(getModelClass());
   }

   public static String getDbName(ModelClass clazz) {
      return clazz.getTaggedValues().getProperty(ModelTaggedValues.DB_TABLE, StringUtil.toUpperCaseIdentifier(clazz.getName().toUpperCase()));
   }

   public static String getDbName(ModelAttribute attribute) {
      return attribute.getTaggedValues().getProperty(ModelTaggedValues.DB_COLUMN, StringUtil.toUpperCaseIdentifier(attribute.getName()).toUpperCase());
   }

   public String getDbColLength(ModelAttribute attribute) {
      String length = "";
      
      if ( attribute.getModelClassifier().getName().equals("string")) {
         int defaultLength = Integer.parseInt(attribute.getTaggedValues().getProperty(ModelTaggedValues.DB_COL_LENGTH, "200"));

         return "("+defaultLength+")";
      }
      return length;
   }
   public String isNullable(ModelAttribute attribute) {
      //@@@TODO Implement from multiplicity-stereotype
      return "true";
   }
   
   public Collection getAttributes(ModelClass modelClass) {
      String mapping = modelClass.getTaggedValues().getProperty(ModelTaggedValues.DB_MAPPING, "ConcreteClass");
      Collection attributes = null;
      if ( mapping.equals("SubClass") ) {
         attributes = modelClass.getAttributes(false);
      }
      else if ( mapping.equals("ConcreteClass") ) {
         attributes = modelClass.getAttributes(true);
      }
      else {
         attributes = modelClass.getAttributes(true);

         for ( Iterator is = modelClass.getAllSubClasses().iterator(); is.hasNext(); ) {
           ModelClass subClass = (ModelClass)is.next();
           
           attributes.addAll(subClass.getAttributes(false));
         }      
      }
      return attributes;
   }
}
