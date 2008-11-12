// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractClassWriter.java,v 1.5.2.1 2008/01/21 14:57:27 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractClassWriter.java,v $
// $Revision: 1.5.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/01/21 14:57:27 $
//   $Locker:  $
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
// 
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// Created on:      23.07.2003
package org.umlmda.generator;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;


/**
 * Base class for all writers using classes as model elements
 * @author moroff
 */
public abstract class AbstractClassWriter extends AbstractModelElementWriter implements IClassWriter
{
   private String className;
   protected String baseClass;
   private ModelClass modelClass = null;
   private boolean persistable = false;
   private GeneratorClass genClass = null;
   private GeneratorPackage genPackage = null;
    
   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractClassWriter(IClassHelper classHelper, IMethodHelper methodHelper) {
      super(classHelper, methodHelper);
   }

   /**
    * Methode muss überladen werden, um den Dateinamen ohne Endung zu liefern
    * @return String
    */
   public final String getBaseName() {
      return getGenClass().getGeneratedName();
   }

   /**
    * Liefert den Klassenname der zu generierenden Klasse
    * @return String
    */
   public String getClassName() {
      return getClassName(modelClass);
   }

   public final String getClassName(ModelClassifier modelClassifier) {
      return getClassHelper().getClassName(modelClassifier);
   }

   /**
    * @return liefert das (Teil-)Modell, für das generiert werden soll
    */
   public ModelClass getModelClass() {
   	return modelClass;
   }
   
   /**
    * Setzt das (Teil-)Modell, für das generiert werden soll
    */
   public void setModelClass(ModelClass modelClass) {
      this.modelClass = modelClass;
      this.className = modelClass.getName();
      this.persistable = modelClass.getKeyAttributes().size() > 0;
      setUserSectionPrefix(className);
      if ( modelClass.getSuperClass() != null )
         baseClass = modelClass.getSuperClass().getQualifiedName();
      else
         baseClass = null;  
      getClassHelper().setModelClass(modelClass);   
      if ( modelClass instanceof GeneratorClass ) {
         genClass = (GeneratorClass) modelClass;
         genPackage = genClass.getGeneratorPackage();
      }
   }

   
   /**
    * Returns a collection with all reference types
    * @return
    */
   public Collection getReferencedTypes() {
      Collection referencedTypes = modelClass.getReferencedTypes(); 
      return referencedTypes;
   }

   protected void addReferencedType(Set referencedTypes, ModelClassifier modelClassifier) {
      if (modelClassifier instanceof ModelClass) {
         ModelClass modelClass = (ModelClass) modelClassifier;

         if ( modelClass.getPackage() != this.modelClass.getPackage() )
            referencedTypes.add(modelClass);
      }
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractWriter#setModelElement(org.umlmda.model.uml.ModelElement)
    */
   public void setModelElement(Object element) {
      super.setModelElement(element);
      if ( element instanceof ModelClass ) {
         setModelClass((ModelClass)element);
      }
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getBaseClass()
    */
   public String getBaseClass() {
      return getClassHelper().getBaseClass();
   }

   public String getNamespace(ModelClass modelClass) {
      return getClassHelper().getNamespace(modelClass);
   }
   
   public String getInitializer(ModelAttribute modelAttribute) {
      return getClassHelper().getInitializer(modelAttribute);
   }

   /**
    * @deprecated used ModelClass.getKeyAttributes()
    */
   public List getKeyAttributes() {
      return modelClass.getKeyAttributes();
   }

   /**
    * @return Returns the persistable.
    */
   public boolean isPersistable() {
      return persistable;
   }
   
   /**
    * Check whether the datatype is a primitiv in the target language
    */
   public final boolean isPrimitive(ModelDataType dataType) {
      return getClassHelper().isPrimitive(dataType);
   }
   
   public GeneratorClass getGenClass() {
      return genClass;
   }
   
   public void setGenClass(GeneratorClass genClass) {
      this.genClass = genClass;
   }
   
   public GeneratorPackage getGenPackage() {
      return genPackage;
   }
   
   public void setGenPackage(GeneratorPackage genPackage) {
      this.genPackage = genPackage;
   }
}

// -------------------------------------------------------------------------
// $Log: AbstractClassWriter.java,v $
// Revision 1.5.2.1  2008/01/21 14:57:27  moroff
// UMLMDA 3.x/RSM 7.x/PDEBuild
//
// Revision 1.6  2007/04/04 21:15:49  moroff
// Avoid usage of deprecated methods
//
// Revision 1.5  2006/07/10 15:29:47  moroff
// Refactoring base functionality to org.umlmda.generator.model
//
// Revision 1.4  2005/11/08 08:07:07  moroff
// Controling output location with artefacts, improved namespace usage.
//
// Revision 1.3  2005/10/28 16:32:20  moroff
// Finished 2.0 refactorings
//
// Revision 1.2  2005/10/27 10:51:01  moroff
// net.sourceforge.umlmda -> org.umlmda
//
// Revision 1.1  2005/10/26 13:03:37  moroff
// * Refactoring package names to org.umlmda
// * Generator configuration based on profiles and sets
//
// Revision 1.13  2005/10/20 21:19:51  moroff
// More refactoring, make java templates more flexible.
//
// Revision 1.12  2005/10/19 14:56:11  moroff
// Refactoring, more flexible artefact configuration.
//
// Revision 1.11  2005/09/29 09:26:58  vpussel
// protected attribute modelClass now private. Accessor added
//
// Revision 1.10  2005/06/09 13:00:50  moroff
// getName() in ModelPackage returns unqualified name, getBaseName() removed.
//
// Revision 1.9  2005/05/25 11:34:01  tkacr
// No automatic inheritance from parent key attributes
//
// Revision 1.8  2005/05/07 19:53:10  moroff
// Model is object not ModelElement any more
//
// Revision 1.7  2005/04/07 20:18:21  moroff
// * New isPrimitive()
//
// Revision 1.6  2005/01/22 20:56:21  moroff
// Use getPackageName to compare whether generated class and used class are in the same package.
//
// Revision 1.5  2004/12/15 18:55:56  moroff
// Supporting persistence modelling
//
// Revision 1.4  2004/12/08 22:08:11  moroff
// Implementation for getInitializer()
//
// Revision 1.3  2004/10/09 20:29:57  moroff
// * Removed stuff which is located in a CLassHelper
// * Made function final which delegate to the ClassHelper
// * New getNameSpace()
//
// Revision 1.2  2004/10/06 19:52:46  moroff
// * Target language specific signatures put in help-classes, delegating to these 
//    classes inside the writer classes
//
// Revision 1.1  2004/10/03 13:13:09  greinhar
// * Moved from UML-Generator
// * Extended for C++ Generation
//
// Revision 1.3  2003/11/03 09:22:26  moroff
// Added associations and methods
//
// Revision 1.2  2003/08/06 21:15:26  moroff
// Import der Attribute Typen
//
// Revision 1.1  2003/07/22 21:15:23  moroff
// Initial import
//
// -------------------------------------------------------------------------
