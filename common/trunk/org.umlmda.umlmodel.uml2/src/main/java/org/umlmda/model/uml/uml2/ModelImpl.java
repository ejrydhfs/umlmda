 // jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelImpl.java,v 1.3.2.3.2.1 2008/03/11 16:18:34 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelImpl.java,v $
// $Revision: 1.3.2.3.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/03/11 16:18:34 $
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

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelPackageBase;

/**
 * @author MOROFF
 */
public class ModelImpl extends ModelElementImpl implements ModelBase {
	private final Model model;
//	private final ModelClassBase javaLangObject = new ModelClassImpl(this, null);
	private Hashtable classes;
   /**
    * Classes owned by this model
    */
   private Set modelClasses = new HashSet();
   private Set modelPackages = new HashSet();
   private Map modelReferences = new IdentityHashMap();
   private Hashtable dataTypes;
   private Hashtable packages;
	
	public ModelImpl(Model model) {
		super(null, model);
		this.model = model;
      init();
	}
	
   public Collection getPackages() {
      if ( packages == null ) {
         getClasses();
      }
      return modelPackages;
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

         // Modellklassen erzeugen
			addClasses(modelClasses, classes, dataTypes, modelPackages, packages, this, modelReferences, model);
		}
		return modelClasses;
	}

	private static void addClasses(Set modelClasses, Hashtable classes, Hashtable dataTypes, Set modelPackages, Hashtable packages, ModelImpl model, Map modelReferences, Namespace namespace) {	
		Collection elements = namespace.getOwnedElements();
		for (Iterator ie = elements.iterator(); ie.hasNext();) {
			Object element = (Object) ie.next();
			
         if (element instanceof Stereotype ) {
            
         }
		 else if (element instanceof Class) { 
            ModelClassBase modelClass = new ModelClassImpl(model, (Class)element); 
				classes.put(element, modelClass);
            
            if ( ((Element)element).getModel() == model.model ) {
               modelClasses.add(modelClass);
            }
            else {
               if ( logger.isDebugEnabled() )
                  logger.debug(element.toString()+" not from model");
            }
         }
         else if ( element instanceof PrimitiveType )
            dataTypes.put(element, new ModelDataTypeImpl(model, (PrimitiveType)element));
         else if ( element instanceof Enumeration ) {
            
         }
         else if ( element instanceof DataType ) {
            dataTypes.put(element, new ModelDataTypeImpl(model, (DataType)element));
         }
		 else if ( element instanceof Package ) {
            Package umlPackage = (Package) element;
            ModelPackageBase modelPackage = new ModelPackageImpl(model, umlPackage);
            
            packages.put(element, new ModelPackageImpl(model, umlPackage));
            if ( umlPackage.getModel() == model.model ) {
               modelPackages.add(modelPackage);
            }
            else {
               if ( logger.isDebugEnabled() )
                  logger.debug(element.toString()+" not from model");
            }
			addClasses(modelClasses, classes, dataTypes, modelPackages, packages, model, modelReferences, umlPackage);
         }
         else if ( element instanceof PackageImport ) {
            PackageImport packageImport = (PackageImport) element;
            Package umlPackage = packageImport.getImportedPackage();
            Model referenceModel = umlPackage.getModel();
            ModelImpl referencedModelImpl = (ModelImpl) model.findModel(referenceModel);

            if ( referencedModelImpl == null ) {
               referencedModelImpl = new ModelImpl(referenceModel);
               
               modelReferences.put(referenceModel, referencedModelImpl);
            }
            if ( umlPackage != null ) {
               addClasses(modelClasses, classes, dataTypes, modelPackages, packages, referencedModelImpl, modelReferences, umlPackage);
               if ( logger.isDebugEnabled() )
                  logger.debug("packageImport of "+umlPackage.getQualifiedName()+" loaded");
            }
            else {
               logger.warn("packageImport "+packageImport.toString()+" not loaded");
            }
         }
         else if (element instanceof ProfileApplication) {
            // Nothing to do for ProfileApplication
         }
         else if (element instanceof Comment) {
            // Nothing to do for Comment
         }
         else {
            if ( logger.isDebugEnabled() )
               logger.debug(element.getClass());
         }
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
	ModelClassImpl findClass(Class modelClass) {
      ModelClassImpl modelClassImpl = (ModelClassImpl) classes.get(modelClass);
      
      if ( modelClassImpl == null ) {
         if ( modelClass.getModel() != this.model ) {
            // Add classes from referenced model
            addClasses(modelClasses, classes, dataTypes, modelPackages, packages, this, modelReferences, modelClass.getModel());

            // Try again
            modelClassImpl = (ModelClassImpl) classes.get(modelClass);
         }
      }
		return modelClassImpl;
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
      else if ( classifier instanceof Class )
         return findClass((Class)classifier);   
      else
         return null;   
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
      
   public void init() {
      // init classes
      getClasses();
      
      // init associations to ensure reverse assocations
      for (Iterator ic = classes.values().iterator(); ic.hasNext();) {
         ModelClassBase modelClass = null;
         
         // resolving assications may change the classes hashset, if happened
         // restart the iterator
         try {
            modelClass = (ModelClassBase) ic.next(); 
         }
         catch ( ConcurrentModificationException e ) {
            ic = classes.values().iterator();
            modelClass = (ModelClassBase) ic.next(); 
         }
         
         modelClass.getAssociations();
      }
   }

   public ModelBase findModel(Model model) {
      ModelBase referencedModelBase = (ModelBase) modelReferences.get(model);
      
      // Add none existiering model
      if ( referencedModelBase == null ) {
         referencedModelBase = new ModelImpl(model);
         modelReferences.put(model, referencedModelBase);
         
         if ( logger.isDebugEnabled())
            logger.debug("loaded model "+model.getName()+" ("+model.eResource().getURI().toFileString()+") into model "+getName());
      }
      return referencedModelBase;
   }
}
