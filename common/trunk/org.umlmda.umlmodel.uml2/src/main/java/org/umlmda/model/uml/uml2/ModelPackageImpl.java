// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelPackageImpl.java,v 1.1.2.1 2006/11/20 10:47:08 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelPackageImpl.java,v $
// $Revision: 1.1.2.1 $
//    $State: Exp $
//     $Name: oAW $
//     $Date: 2006/11/20 10:47:08 $
//   $Locker:  $
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
package org.umlmda.model.uml.uml2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.umlmda.model.uml.ModelConstants;
import org.umlmda.model.uml.ModelPackageBase;

/**
 * Wraps a package from a UML model
 * 
 * @author Dieter Moroff
 */
public class ModelPackageImpl extends ModelElementImpl implements ModelConstants, ModelPackageBase
{
   private final Package        modelPackage;
   // private Collection referencedPackages = null;
   private List<ModelClassImpl> classes = null;
   @SuppressWarnings("unused")
   private String               name;

   /**
    * 
    */
   ModelPackageImpl() {
      super(null, null);
      this.modelPackage = null;
      this.name = Object.class.getPackage().getName();
   }

   /**
    * @param namespace
    */
   public ModelPackageImpl(ModelImpl model, Namespace namespace) {
      super(model, namespace);
      if ( namespace instanceof Package && !(namespace instanceof Model) )
         modelPackage = (Package) namespace;
      else
         modelPackage = null;
   }

   /**
    * 
    */
   public List<ModelClassImpl> getClasses() {
      if ( classes == null ) {
         classes = new ArrayList<ModelClassImpl>();

         for ( Element element : modelPackage.getOwnedElements() ) {
            if ( element instanceof Class ) {
               classes.add(model.findClass((Class) element));
            }
         }
      }

      return classes;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackage#getPackage()
    */
   public ModelPackageBase getPackageBase() {
      if ( modelPackage.getNamespace() instanceof Package )
         return model.findPackage(modelPackage.getNamespace());
      else
         return null;
   }

}
