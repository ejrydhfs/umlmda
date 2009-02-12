// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelImpl.java,v 1.6 2006/11/23 13:38:24 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelImpl.java,v $
// $Revision: 1.6 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/11/23 13:38:24 $
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
package org.umlmda.model.uml.nsuml;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackageBase;

import ru.novosoft.uml.behavior.common_behavior.MSignal;
import ru.novosoft.uml.foundation.core.MAssociation;
import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MDataType;
import ru.novosoft.uml.foundation.core.MDataTypeImpl;
import ru.novosoft.uml.foundation.core.MDependency;
import ru.novosoft.uml.foundation.core.MGeneralization;
import ru.novosoft.uml.foundation.core.MInterface;
import ru.novosoft.uml.foundation.core.MNamespace;
import ru.novosoft.uml.foundation.core.MOperation;
import ru.novosoft.uml.foundation.extension_mechanisms.MStereotype;
import ru.novosoft.uml.model_management.MModel;
import ru.novosoft.uml.model_management.MPackage;

/**
 * @author MOROFF
 */
public class ModelImpl extends ModelElementImpl implements ModelBase {
	private final MModel mmodel;
//	private final ModelClassBase javaLangObject = new ModelClassImpl(this, null);
	private Hashtable classes;
   private Hashtable dataTypes;
   private Hashtable packages;
	
	public ModelImpl(MModel mmodel) {
		super(null, mmodel); // passing this in ctor is not allowed
		this.mmodel = mmodel;
      
	}
	
	/**
	 * overload ModelElementImpl.getModel() which would return null for ModelImpl
	 */
	public ModelBase getModel() {
		return this;
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

         // Primitive Datentypen erzeugen
         addPrimitive(ModelDataType.BINARY);
         addPrimitive(ModelDataType.BOOLEAN);
         addPrimitive(ModelDataType.CHAR);
         addPrimitive(ModelDataType.DATE);
         addPrimitive(ModelDataType.DATE_TIME);
         addPrimitive(ModelDataType.DECIMAL);
         addPrimitive(ModelDataType.DOUBLE);
         addPrimitive(ModelDataType.FLOAT);
         addPrimitive(ModelDataType.INT);
         addPrimitive(ModelDataType.LONG);
         addPrimitive(ModelDataType.SHORT);
         addPrimitive(ModelDataType.STRING);
         addPrimitive(ModelDataType.TIMESTAMP);
         addPrimitive(ModelDataType.VOID);
         
         // Modellklassen erzeugen
			addClasses(classes, dataTypes, packages, this, mmodel);
		}
		return classes.values();
	}

   private void addPrimitive(String name) {
      MDataType dataType = new MDataTypeImpl();
      dataType.setName(name);
      dataType.setNamespace(mmodel);
      dataTypes.put(dataType, new ModelDataTypeImpl(this, dataType));
   }
	
	private static void addClasses(Hashtable classes, Hashtable dataTypes, Hashtable packages, ModelImpl model, MNamespace namespace) {	
		Collection elements = namespace.getOwnedElements();
		for (Iterator ie = elements.iterator(); ie.hasNext();) {
			Object element = (Object) ie.next();
			
         // Ignored stuff
         if ( element instanceof MStereotype ) {
         }
         else if ( element instanceof MGeneralization ) {
         }
         else if ( element instanceof MAssociation ) {
         }
         else if ( element instanceof MSignal ) {
         }
         else if ( element instanceof MConstraint ) {
         }
		 else if ( element instanceof MDependency ) {
		 }
         // Processed stuff
		 else if (element instanceof MClass) 
			classes.put(element, new ModelClassImpl(model, (MClass)element));
         else if (element instanceof MInterface) 
            throw new RuntimeException("Modeltype interface not supported, ref="+((MInterface)element).getName());
         else if ( element instanceof MDataType )
            dataTypes.put(element, new ModelDataTypeImpl(model, (MDataType)element));   
		 else if ( element instanceof MPackage ) {
            packages.put(element, new ModelPackageImpl(model, (MPackage)element));
			addClasses(classes, dataTypes, packages, model, (MNamespace) element);
         }
         else
            System.err.println("Unknown modeltype type="+element.getClass()+", ref="+element.toString());
		}	
	}


//	/**
//	 * @return
//	 */
//	public ModelClassBase getJavaLangObject() {
//		return javaLangObject;
//	}

	/**
	 * @param class1
	 * @return
	 */
	ModelClassImpl findClass(MClass modelClass) {
		return (ModelClassImpl) classes.get(modelClass);
	}
	
   ModelDataTypeBase findDataType(MDataType dataType) {
      return (ModelDataTypeBase) dataTypes.get(dataType);
   }

   /**
    * @param classifier
    * @return
    */
   public ModelClassifierBase findClassifier(MClassifier classifier) {
      if ( classifier instanceof MDataType )
         return findDataType((MDataType)classifier);
      else if ( classifier instanceof MSignal ) 
         return findClass(classifier.getNamespace(), classifier.getName());   
      else
         return findClass((MClass)classifier);   
   }

   /**
    * @param namespace
    * @param string
    * @return
    */
   private ModelClassifierImpl findClass(MNamespace namespace, String className) {
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
   public ModelPackageBase findPackage(MNamespace namespace) {
      return (ModelPackageBase)packages.get(namespace);
   }

   /**
    * @param operation
    * @return
    */
   public ModelElementBase findMethod(MClass clazz, MOperation operation) {
      ModelClassBase modelClass = (ModelClassBase) findClassifier(clazz);
      
      for (Iterator im = modelClass.getMethods().iterator(); im.hasNext();) {
         ModelMethodBase methodBase = (ModelMethodBase) im.next();
         
         if ( methodBase.getName().equals(operation.getName()) ) {
            return methodBase;
         }
      }
      return null;
   }
   
}
