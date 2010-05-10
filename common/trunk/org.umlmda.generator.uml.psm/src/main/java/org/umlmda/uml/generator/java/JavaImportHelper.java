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
 *  Created on 20.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.Collection;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorPackage;

/**
 * @author moroff
 */
public interface JavaImportHelper
{

   /**
    * 
    */
   void resetImports();

   /**
    * Register an artefact of the current model element (class or package) as import
    * 
    * @param business_factory
    */
   void registerImport(String artefactName);

   void registerImport(String artefactName, JavaModelClass genClass);

   void registerImport(String artefactName, JavaModelPackage genClass);

   /**
    * Register all classes in collection as import
    * 
    * @param business_interface
    * @param classes
    */
   void registerImports(String business_interface, Collection classes);

   /**
    * Register all classes in collection which have the given stereotype as import
    * 
    * @param business_interface
    * @param classes
    */
   void registerImports(String business_interface, Collection classes, String stereotype);

   /**
    * @return
    */
   String registeredImports();

   /**
    * @param business_interface
    * @param genClass
    * @return
    */
   String getScopedName(String artefactName);

   /**
    * @param business_interface
    * @param genClass
    * @return
    */
   String getScopedName(String artefactName, GeneratorClass genClass);

   /**
    * @param business_interface
    * @param genClass
    * @return
    */
   String getScopedName(String artefactName, GeneratorPackage genPackage);

}
