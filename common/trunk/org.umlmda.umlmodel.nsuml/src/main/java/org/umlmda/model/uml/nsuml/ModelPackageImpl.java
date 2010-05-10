// UMLMDA, UMLModel-API
// 
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
package org.umlmda.model.uml.nsuml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.ModelConstants;
import org.umlmda.model.uml.ModelPackageBase;

import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MElement;
import ru.novosoft.uml.foundation.core.MNamespace;
import ru.novosoft.uml.model_management.MModel;
import ru.novosoft.uml.model_management.MPackage;

/**
 * Wraps a package from a UML model
 * 
 * @author Dieter Moroff
 */
public class ModelPackageImpl extends ModelElementImpl implements ModelConstants, ModelPackageBase
{
   private final MPackage modelPackage;
   private List           classes        = null;
   private List           nestedPackages = null;
   private String         name;

   /**
    * @param namespace
    */
   public ModelPackageImpl(ModelImpl model, MNamespace namespace) {
      super(model, namespace);
      if ( namespace instanceof MPackage && !(namespace instanceof MModel) )
         modelPackage = (MPackage) namespace;
      else
         modelPackage = null;
   }

   /**
    * Must be overwritten to remove pseudo packages from rational rose
    * 
    * @return Full
    */
   public String getQualifiedName() {
      if ( name == null ) {
         if ( modelPackage != null )
            name = getName(modelPackage);
         else
            name = EMPTY;
      }
      return name;
   }

   private static String getName(MNamespace namespace) {
      if ( namespace.getNamespace() != null && !(namespace.getNamespace() instanceof MModel)
            && !(namespace.getNamespace().getName().equals("Logical View")) )
         return getName(namespace.getNamespace()) + PACKAGE_SEPARATOR + namespace.getName();
      else
         return namespace.getName();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getClasses()
    */
   public List getClasses() {
      if ( classes == null ) {
         classes = new ArrayList();

         for ( Iterator iter = modelPackage.getOwnedElements().iterator(); iter.hasNext(); ) {
            MElement element = (MElement) iter.next();

            if ( element instanceof MClass ) {
               classes.add(model.findClass((MClass) element));
            }
         }
      }

      return classes;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getPackageBase()
    */
   public ModelPackageBase getPackageBase() {
      if ( modelPackage.getNamespace() instanceof MPackage )
         return model.findPackage(modelPackage.getNamespace());
      else
         return null;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getNestedPackagesBase()
    */
   public List<? extends ModelPackageBase> getNestedPackagesBase() {
      if ( nestedPackages == null ) {
         nestedPackages = new ArrayList();

         for ( Iterator iter = modelPackage.getOwnedElements().iterator(); iter.hasNext(); ) {
            MElement element = (MElement) iter.next();

            if ( element instanceof MPackage ) {
               nestedPackages.add(model.findPackage((MPackage) element));
            }
         }
      }
      return nestedPackages;
   }

}
