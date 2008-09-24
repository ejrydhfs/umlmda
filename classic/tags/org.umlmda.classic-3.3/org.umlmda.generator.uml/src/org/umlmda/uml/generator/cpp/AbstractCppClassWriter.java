/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/cpp/AbstractCppClassWriter.java,v 1.4 2006/06/26 20:37:26 moroff Exp $
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

import org.umlmda.generator.AbstractClassWriter;
import org.umlmda.generator.model.util.StringUtil;

import org.umlmda.model.uml.ModelClass;

/**
 * @author moroff
 */
public abstract class AbstractCppClassWriter extends AbstractClassWriter {

   public AbstractCppClassWriter() {
      super(new CppClassHelper(), new CppMethodHelper(null, false));
   }
   
   protected String guardedInclude(String prefix, String filename) {
      StringBuffer buffer = new StringBuffer(1024);
      buffer.append("#ifndef _");
      buffer.append(prefix.toUpperCase());
      buffer.append(filename.toUpperCase());
      buffer.append("_H\r\n");
      buffer.append("#include <");
      buffer.append(prefix);
      buffer.append(filename);
      buffer.append(".h>\r\n#endif");
      return buffer.toString();      
   }

   protected String startIncludeGuard() {
      StringBuffer buffer = new StringBuffer(1024);
      
      buffer.append("#ifndef _");
      buffer.append(getBaseName().toUpperCase());
      buffer.append("_H\r\n");
      buffer.append("#define _");
      buffer.append(getBaseName().toUpperCase());
      buffer.append("_H\r\n");
      return buffer.toString();
   }

   protected String endIncludeGuard() {
      return "#endif // __INCLUDED_... ";
   }

   public boolean generateAttributeCtor() {
      return getModelClass().hasStereotype("BusinessException");
   }
   
   protected String getQualifiedName(ModelClass modelClass) {
      String nameSpace = getNamespace(modelClass);
      
      if ( modelClass.getPackage() == getModelClass().getPackage() || StringUtil.isEmpty(nameSpace)) {
         return modelClass.getName();
      }
      else {   
         return nameSpace + "::" + modelClass.getName();
      }
   }
}
