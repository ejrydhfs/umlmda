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
package org.umlmda.model.uml.mdr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import org.omg.uml.foundation.core.ModelElement;
import org.omg.uml.foundation.core.Namespace;
import org.omg.uml.foundation.core.UmlClass;
import org.omg.uml.modelmanagement.Model;
import org.omg.uml.modelmanagement.UmlPackage;
import org.umlmda.model.uml.ModelConstants;
import org.umlmda.model.uml.ModelPackageBase;


/**
 * Wraps a package from a UML model
 * @author Dieter Moroff
 */
public class ModelPackageImpl extends ModelElementImpl implements ModelConstants, ModelPackageBase {
	private final UmlPackage modelPackage;
   private Collection referencedPackages = null;
   private List classes = null;
	private String name;
	
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
		if (namespace instanceof UmlPackage && !(namespace instanceof Model) ) 
			modelPackage = (UmlPackage) namespace;
		else
			modelPackage = null;
	}

	/**
	 * @return Full
	 */
	public String getQualifiedName() {
		if ( name == null ) {
			if ( modelPackage != null  ) 
				name = getName(modelPackage);
			else
				name = EMPTY;
		}
		return name;	
	}
	
	private static String getName(Namespace namespace) {
		if ( namespace.getNamespace() != null && !(namespace.getNamespace() instanceof Model) )
			return getName(namespace.getNamespace()) + PACKAGE_SEPARATOR + namespace.getName();	
		else
			return namespace.getName();
	}

   /**
    * 
    */
   public List getClasses() {
      if ( classes == null ) {
         classes = new ArrayList();
         
         for (Iterator iter = modelPackage.getOwnedElement().iterator(); iter.hasNext();) {
            ModelElement element = (ModelElement) iter.next();
   
            if (element instanceof UmlClass) {
               ModelClassImpl newModelClass = model.findClass((UmlClass)element);
               classes.add(model.findClass((UmlClass)element));
            }      
         }      
      }
      
      return classes;
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelPackage#getPackage()
    */
   public ModelPackageBase getPackageBase() {
      if ( modelPackage.getNamespace() instanceof UmlPackage )
         return model.findPackage(modelPackage.getNamespace());
      else
         return null;
   }
}
