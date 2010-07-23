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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelElement;

/**
 * Helper class for importing of model elements by registering, filtering duplicates and outputting the collected imports.
 * 
 * @author moroff
 */
public class JavaImportHelperImpl implements JavaImportHelper
{
   private static String               newLine           = System.getProperty("line.separator", "\n");
   private final GeneratorModelElement genElement;
   private final JavaModelMethod       genMethod;
   private final JavaModelClass        genClass;
   private final JavaModelPackage      genPackage;
   private Map<String, String>         registeredImports = new HashMap<String, String>();
   private Set<String>                 ambiguousImports  = new HashSet<String>();

   JavaImportHelperImpl(JavaModelMethod genMethod) {
      this.genElement = genMethod;
      this.genMethod = genMethod;
      this.genClass = (JavaModelClass) genMethod.getGeneratorClass();
      this.genPackage = (JavaModelPackage) genClass.getGeneratorPackage();
   }

   JavaImportHelperImpl(JavaModelPackage genPackage) {
      this.genElement = genPackage;
      this.genMethod = null;
      this.genClass = null;
      this.genPackage = genPackage;
   }

   JavaImportHelperImpl(JavaModelClass genClass) {
      this.genElement = genClass;
      this.genMethod = null;
      this.genClass = genClass;
      this.genPackage = (JavaModelPackage) genClass.getGeneratorPackage();
   }

   public void resetImports() {
      registeredImports = new HashMap<String, String>();
      ambiguousImports = new HashSet<String>();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaImportHelper#registerImport(java.lang.String)
    */
   public void registerImport(String artefactName) {

      if ( genClass != null )
         registerImport(artefactName, genClass);
      else
         registerImport(artefactName, genPackage);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaImportHelper#registerImport(java.lang.String,
    * org.umlmda.uml.generator.java.JavaModelPackage)
    */
   public void registerImport(String artefactName, JavaModelPackage genPackage) {
      String name = genPackage.getGeneratedName(artefactName);
      String currentArtefact = this.genPackage.getGeneratorModel().getContext().getCurrentArtefact().getName();

      if ( this.genPackage.getQualifiedName(currentArtefact).equals(genPackage.getQualifiedName(artefactName)) == false ) {
         registerImport(name, genPackage.getQualifiedPackageName(artefactName) + "." + name);
      }
   }

   public void registerImport(String artefactName, JavaModelClass genClass) {
      JavaModelPackage genPackage = (JavaModelPackage) genClass.getPackage();
      String currentArtefact = genPackage.getGeneratorModel().getContext().getCurrentArtefact().getName();
      String name = genClass.getGeneratedName(artefactName);

      if ( this.genClass != null ) {
         String qualifiedName = genClass.getQualifiedName(artefactName);

         if ( this.genPackage.getGeneratedName().equals(genPackage.getQualifiedName(artefactName)) == false
               && name.equals(this.genClass.getGeneratedName()) == false && ambiguousImports.contains(name) == false ) {
            registerImport(name, qualifiedName);
         }
      }
      else {
         String currentName = this.genPackage.getQualifiedPackageName(currentArtefact);
         String genName = genPackage.getQualifiedPackageName(artefactName);

         if ( currentName.equals(genName) == false ) {
            registerImport(name, genClass.getQualifiedName(artefactName));
         }
      }
   }

   /**
    * @param name
    *           Short name of the class to import.
    * @param qualifiedName
    *           Fully qualified name of the class to import.
    */
   private void registerImport(String name, String qualifiedName) {
      if ( getOwnName().equals(name) == false ) {
         // If the name is known for being ambigious or if another class with the same name has been registered,
         // remove the registered import and remember the ambiguity.
         if ( ambiguousImports.contains(name)
               || (registeredImports.containsKey(name) && !registeredImports.containsValue(qualifiedName)) ) {
            if ( ambiguousImports.add(name) ) {
               registeredImports.remove(name);
            }
         }
         else {
            registeredImports.put(name, qualifiedName);
         }
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClass#registerImport(java.util.Collection, java.lang.String)
    */
   public void registerImports(String artefactName, Collection importedClasses) {
      for ( Iterator ii = importedClasses.iterator(); ii.hasNext(); ) {
         ModelElement modelElement = (ModelElement) ii.next();
         registerImport(artefactName, modelElement);
      }
   }

   private void registerImport(String artefactName, ModelElement modelElement) {
      if ( modelElement instanceof JavaModelClass ) {
         JavaModelClass modelClass = (JavaModelClass) modelElement;

         registerImport(artefactName, modelClass);
      }
      else if ( modelElement instanceof JavaModelPackage ) {
         JavaModelPackage modelPackage = (JavaModelPackage) modelElement;

         registerImport(artefactName, modelPackage);
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaImportHelper#registerImports(java.lang.String, java.util.Collection,
    * java.lang.String)
    */
   public void registerImports(String artefactName, Collection importedClasses, String stereotype) {
      for ( Iterator ii = importedClasses.iterator(); ii.hasNext(); ) {
         ModelElement modelElement = (ModelElement) ii.next();

         if ( modelElement.hasStereotype(stereotype) ) {
            registerImport(artefactName, modelElement);
         }
      }
   }

   public String registeredImports() {
      String packageName = genPackage.getQualifiedPackageName(genPackage.getGeneratorModel().getArtefact().getName());
      List usedImports = new ArrayList();
      StringBuffer buffer = new StringBuffer();

      for ( Iterator ii = registeredImports.values().iterator(); ii.hasNext(); ) {
         String importValue = (String) ii.next();
         String importedPackage = importValue.substring(0, importValue.lastIndexOf("."));

         if ( importedPackage.equals(packageName) == false ) {
            usedImports.add(importValue);
         }
      }
      Collections.sort(usedImports);

      for ( Iterator ii = usedImports.iterator(); ii.hasNext(); ) {
         String importedClass = (String) ii.next();

         buffer.append("import ");
         buffer.append(importedClass);
         buffer.append(";");
         if ( ii.hasNext() )
            buffer.append(newLine);
      }
      return buffer.toString();
   }

   public String getScopedName(String artefactName, GeneratorClass genClass) {
      String name = genClass.getGeneratedName(artefactName);
      JavaModelPackage genPackage = (JavaModelPackage) ((ModelClass) genClass).getPackage();
      String packageName = this.genPackage.getQualifiedPackageName(this.genPackage.getGeneratorModel().getArtefact().getName());
      String genPackageName = genPackage.getQualifiedPackageName(artefactName);

      if ( packageName.equals(genPackageName) || (registeredImports.containsKey(name) && !ambiguousImports.contains(name)) ) {
         return name;
      }
      else {
         return genClass.getQualifiedName(artefactName);
      }
   }

   public String getScopedName(String artefactName, GeneratorPackage genPackage) {
      String name = genPackage.getGeneratedName(artefactName);
      String packageName = this.genPackage.getQualifiedPackageName(this.genPackage.getGeneratorModel().getArtefact().getName());
      String genPackageName = genPackage.getQualifiedName(artefactName);

      if ( packageName.equals(genPackageName) || (registeredImports.containsKey(name) && !ambiguousImports.contains(name)) ) {
         return genPackage.getGeneratedName(artefactName);
      }
      else {
         return genPackage.getQualifiedName(artefactName);
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaImportHelper#getScopedName(java.lang.String)
    */
   public String getScopedName(String artefactName) {
      if ( this.genClass != null ) {
         return getScopedName(artefactName, genClass);
      }
      else {
         return getScopedName(artefactName, genPackage);
      }
   }

   private String getOwnName() {
      if ( this.genClass != null ) {
         return genClass.getGeneratedName();
      }
      else {
         return genPackage.getGeneratedName();
      }

   }
}
