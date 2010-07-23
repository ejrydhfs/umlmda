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

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;


import org.omg.uml.behavioralelements.commonbehavior.Signal;
import org.omg.uml.foundation.core.Classifier;
import org.omg.uml.foundation.core.DataType;
import org.omg.uml.foundation.core.Namespace;
import org.omg.uml.foundation.core.UmlClass;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelPackageBase;


/**
 * @author MOROFF
 */
public class ModelImpl extends ModelElementImpl implements ModelBase {
	private final org.omg.uml.modelmanagement.Model model;
	private static final ModelClassBase javaLangObject = new ModelClassImpl();
	private Hashtable classes;
    private Hashtable dataTypes;
    private Hashtable packages;
	
	public ModelImpl(org.omg.uml.modelmanagement.Model model) {
		super(null, model);
		this.model = model;
	}
	
   public Collection getPackages() {
      if ( packages == null ) {
         getClasses();
      }
      return packages.values();
   }

   public Collection getDatatypes() {
      if ( dataTypes == null ) {
         getClasses();
      }
      return dataTypes.values();
   }
   
	public Collection getClasses() {
		if ( classes == null ) {
			classes = new Hashtable();
         dataTypes = new Hashtable();
         packages = new Hashtable();

//         // Primitive Datentypen erzeugen
//         addPrimitive("void");
//         addPrimitive("int");
//         addPrimitive("short");
//         addPrimitive("long");
//         addPrimitive("double");
//         addPrimitive("float");
//         addPrimitive("char");
//         addPrimitive("byte");
//         addPrimitive("boolean");
//         
         // Modellklassen erzeugen
			addClasses(classes, dataTypes, packages, this, model);
		}
		return classes.values();
	}

//   private void addPrimitive(String name) {
//      Classifier classifier = new DataTypeImpl();
//      classifier.setName(name);
//      classifier.setNamespace(model);
//      classes.put(classifier, new ModelClassImpl(this, classifier));
//   }
	
	private static void addClasses(Hashtable classes, Hashtable dataTypes, Hashtable packages, ModelImpl model,
         Namespace namespace) {
      Collection elements = namespace.getOwnedElement();
      for (Iterator ie = elements.iterator(); ie.hasNext();) {
         Object element = (Object) ie.next();

         if (element instanceof UmlClass)
            classes.put(element, new ModelClassImpl(model, (UmlClass) element));
         else if (element instanceof DataType)
            dataTypes.put(element, new ModelDataTypeImpl(model, (DataType) element));
         else if (element instanceof Namespace) {
            packages.put(element, new ModelPackageImpl(model, (Namespace) element));
            addClasses(classes, dataTypes, packages, model, (Namespace) element);
         }
      }
   }


	/**
	 * @return
	 */
	public static ModelClassBase getJavaLangObject() {
		return javaLangObject;
	}

	/**
	 * @param class1
	 * @return
	 */
	ModelClassImpl findClass(UmlClass modelClass) {
		return (ModelClassImpl) classes.get(modelClass);
	}
	
   ModelDataTypeBase findDataType(DataType dataType) {
      return (ModelDataTypeBase) dataTypes.get(dataType);
   }

   /**
    * @param classifier
    * @return
    */
   public ModelClassifierBase findClassifier(Classifier classifier) {
      if ( classifier instanceof DataType )
         return findDataType((DataType)classifier);
      else if ( classifier instanceof Signal ) 
         return findClass(classifier.getNamespace(), classifier.getName());   
      else
         return findClass((UmlClass)classifier);   
   }

   /**
    * @param namespace
    * @param string
    * @return
    */
   private ModelClassifierImpl findClass(Namespace namespace, String className) {
      ModelPackageBase modelPackage = findPackage(namespace);
      for (Iterator iter = classes.values().iterator(); iter.hasNext();) {
         ModelClassImpl modelClass = (ModelClassImpl) iter.next();
         
         if ( modelClass.getPackageBase() == modelPackage  &&  modelClass.getName().equals(className))
            return modelClass;
      }
      return null;
   }

   /**
    * @param namespace
    * @return
    */
   public ModelPackageBase findPackage(Namespace namespace) {
      return (ModelPackageBase)packages.get(namespace);
   }
   
   
}
