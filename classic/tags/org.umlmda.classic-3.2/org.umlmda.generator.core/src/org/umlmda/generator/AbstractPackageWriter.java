// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractPackageWriter.java,v 1.7 2006/07/10 15:29:47 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractPackageWriter.java,v $
// $Revision: 1.7 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/07/10 15:29:47 $
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

import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelPackage;


/**
 * Basisklasse für alle KlassenWriter
 *
 * @author moroff (06.02.2003)
 */
public abstract class AbstractPackageWriter extends AbstractModelElementWriter
{
   private Collection referencedPackages = null;
   private ModelPackage modelPackage = null;
   private GeneratorPackage genPackage = null;
   
   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractPackageWriter(IClassHelper classHelper, IMethodHelper methodHelper) {
      super(classHelper, methodHelper);
   }

   /**
    * Setzt das (Teil-)Modell, für das generiert werden soll
    */
   public void setModelPackage(ModelPackage modelPackage) {
      this.modelPackage = modelPackage;
      this.genPackage = (GeneratorPackage) modelPackage;
      setUserSectionPrefix(modelPackage.getQualifiedName());
      if ( modelPackage.getClasses().size() > 0 )
         getClassHelper().setModelClass((ModelClass) modelPackage.getClasses().get(0));
   }

	/**
	 * @return the model package for which the writer was called
	 */
   public ModelPackage getModelPackage() {
		return modelPackage;
	}

   public GeneratorPackage getGenPackage() {
      return genPackage;
   }
   
   /**
    * Returns a collection of all packages on with the writers package depends 
    */
   public Collection getReferencedPackages() {
      return modelPackage.getReferencedPackages();
   }

   public String getBaseName() {
      return getGenPackage().getGeneratedName();
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractWriter#setModelElement(org.umlmda.model.uml.ModelElement)
    */
   public void setModelElement(Object element) {
      super.setModelElement(element);
      if ( element instanceof ModelPackage ) {
         setModelPackage((ModelPackage)element);
      }
   }

}

// -------------------------------------------------------------------------
// $Log: AbstractPackageWriter.java,v $
// Revision 1.7  2006/07/10 15:29:47  moroff
// Refactoring base functionality to org.umlmda.generator.model
//
// Revision 1.6  2005/11/08 08:07:07  moroff
// Controling output location with artefacts, improved namespace usage.
//
// Revision 1.5  2005/11/03 21:16:40  moroff
// Support for model method based writers
//
// Revision 1.4  2005/10/28 16:32:20  moroff
// Finished 2.0 refactorings
//
// Revision 1.3  2005/10/27 20:20:33  moroff
// Use Pattern for namespace
//
// Revision 1.2  2005/10/27 10:52:45  moroff
// *** empty log message ***
//
// Revision 1.1  2005/10/26 13:03:37  moroff
// * Refactoring package names to org.umlmda
// * Generator configuration based on profiles and sets
//
// Revision 1.10  2005/10/20 21:19:51  moroff
// More refactoring, make java templates more flexible.
//
// Revision 1.9  2005/10/17 12:53:51  vpussel
// moved to ModelPackage: getReferencedTypes()
//
// Revision 1.8  2005/09/29 09:29:22  vpussel
// protected attribute modelClass now private. Accessor added
//
// Revision 1.7  2005/08/08 10:28:27  moroff
// Use getPackageName() to get the current generated package name
//
// Revision 1.6  2005/06/14 15:24:38  vpussel
// new: getModelPackage()
//
// Revision 1.5  2005/06/09 13:00:51  moroff
// getName() in ModelPackage returns unqualified name, getBaseName() removed.
//
// Revision 1.4  2005/05/07 19:51:37  moroff
// Model is object not ModelElement any more
//
// Revision 1.3  2004/12/15 18:55:56  moroff
// Supporting persistence modelling
//
// Revision 1.2  2004/12/08 22:10:35  moroff
// Remove unused imports
//
// Revision 1.1  2004/10/06 19:45:16  moroff
// * Supporting writers on ModelPackage elements
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
