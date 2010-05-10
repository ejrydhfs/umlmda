/*
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
 *  Created on 21.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.model.uml.ModelMethod;

/**
 * @author MOROFF
 */
public interface JavaModelMethod extends JavaModelElement, ModelMethod, GeneratorMethod
{

   /**
    * Returns a synchronous method for an asynchronous method
    * 
    * @return
    */
   JavaModelMethod getSyncMethod();

   /**
    * 
    */
   void resetImports();

   /**
    * @param business_service_interface
    */
   void registerImport(String artefactName);

   /**
    * @param business_service_interface
    */
   void registerImport(String artefactName, JavaModelClass genClass);

   /**
    * 
    */
   String registeredImports();

   /**
    * @param business_object_interface
    * @param type
    * @return
    */
   String getScopedName(String artefactName, JavaModelClass type);

   /**
    * Returns the java logging code to the methods parameters
    */
   String logParameters(int level, int identLevel);

   /**
    * Returns the java code at method entry
    */
   String traceEntry(int identLevel);

   /**
    * Returns the java data type of the return type of the method
    */
   String getJavaType();

}
