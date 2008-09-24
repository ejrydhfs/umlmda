// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractEmbeddedAssocationWriter.java,v 1.3 2006/07/10 15:29:47 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractEmbeddedAssocationWriter.java,v $
// $Revision: 1.3 $
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
// Created on:      26.04.2005
package org.umlmda.generator;

import java.util.Collection;
import java.util.Collections;

import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractEmbeddedAssocationWriter extends AbstractEmbeddedWriter  {
   protected ModelAssociation modelAssociation;
   private IClassHelper classHelper = null;
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getClassName(org.umlmda.model.uml.ModelClassifier)
    */
   public String getClassName(ModelClassifier modelClassifier) {
      return modelClassifier.getName();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getPackageName()
    */
   public String getPackageName() {
      return modelAssociation.getName();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getReferencedTypes()
    */
   public Collection getReferencedTypes() {
      return Collections.EMPTY_LIST;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getType(org.umlmda.model.uml.ModelAttribute)
    */
   final public String getType(ModelAttribute attribute) {
      return classHelper.getType(attribute);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getType(org.umlmda.model.uml.ModelClassifier)
    */
   final public String getType(ModelClassifier modelClassifier) {
      return classHelper.getType(modelClassifier);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getType(org.umlmda.model.uml.ModelDataType)
    */
   final public String getType(ModelDataType type) {
      return getType((ModelClassifier)type);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractWriter#setModelElement(org.umlmda.model.uml.ModelElement)
    */
   public void setModelElement(Object element) {
      super.setModelElement(element);
      if ( element instanceof ModelAssociation ) {
         setModelAssociation((ModelAssociation)element);
      }
   }

   public void setModelAssociation(ModelAssociation association) {
      modelAssociation = association;
   }
   
   /**
    * @return
    */
   public IClassHelper getClassHelper() {
      return classHelper;
   }

   /**
    * @param helper
    */
   public void setClassHelper(IClassHelper helper) {
      classHelper = helper;
      if ( classHelper != null && modelAssociation != null )
         classHelper.setModelClass(modelAssociation.getTarget());
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getBaseClass()
    */
   final public String getBaseClass() {
      return classHelper.getBaseClass();
   }

}


//-------------------------------------------------------------------------
//$Log: AbstractEmbeddedAssocationWriter.java,v $
//Revision 1.3  2006/07/10 15:29:47  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.2  2005/10/27 10:52:45  moroff
//*** empty log message ***
//
//Revision 1.1  2005/10/26 13:03:37  moroff
//* Refactoring package names to org.umlmda
//* Generator configuration based on profiles and sets
//
//Revision 1.3  2005/05/14 10:35:04  moroff
//Removed unused imports
//
//Revision 1.2  2005/05/07 19:52:38  moroff
//Model is object not ModelElement any more
//
//Revision 1.1  2005/04/28 08:05:20  moroff
//*** empty log message ***
//
//Revision 1.2  2005/04/07 20:17:43  moroff
//New getPackageName()
//
//Revision 1.1  2005/03/13 17:02:53  moroff
//Avoid dependency c++ from idl writers
//
//Revision 1.3  2005/03/10 21:21:56  moroff
//Bugfix #1146208: mapping IDL types
//
//Revision 1.2  2004/12/08 22:10:07  moroff
//Handle model attributes without types (from analysis models)
//
//Revision 1.1  2004/10/06 19:41:05  moroff
//* Supporting CORBA (IDL) writers
//
//-------------------------------------------------------------------------