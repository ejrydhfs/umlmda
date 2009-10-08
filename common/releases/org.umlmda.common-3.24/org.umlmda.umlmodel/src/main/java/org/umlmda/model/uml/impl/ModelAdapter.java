// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAdapter.java,v 1.7.2.1 2008/04/09 13:07:46 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelAdapter.java,v $
// $Revision: 1.7.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/04/09 13:07:46 $
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
// Created on Jun 7, 2005
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelDependencyBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelGeneralizationBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.ModelParameterBase;
import org.umlmda.model.uml.ModelVisitor;
import org.umlmda.model.uml.validate.ModelValidationException;
import org.umlmda.utils.observer.ObservableList;


/**
 * Platform independent adapter to uml model.
 *
 * @author vpussel
 * @author Dieter Moroff
 */
public class ModelAdapter extends ModelElementAdapter implements Model {
   protected Logger logger = Logger.getLogger(ModelAdapter.class);
   private final ModelBase srcModel; // the source model
   private final ModelAdapterFactory factory;
   private ObservableList packages = null;
   private ObservableList classes = null;
   private ObservableList datatypes = null;
   private Map elementMap = new HashMap();


	/**
	 * create an adapter model with recursive lazy creation of model elements
	 * @param factory
	 * @param srcModel
	 */
	public ModelAdapter(ModelAdapterFactory factory, ModelBase srcModel) {
		super(srcModel, null);
		this.srcModel = srcModel;
		this.factory = factory;
        if ( srcModel instanceof Observable ) {
           ((Observable)srcModel).addObserver(this);
        }
	}

      public void init() {
      }
   
      public ModelBase getSrcModel() {
         return srcModel;
      }
      
      public void update(Observable o, Object arg) {
         if ( PROPERTY_CLASSES.equals(arg) && classes != null && arg != classes ) {
            classes.deleteObserver(this);
            classes.clear();
            classes = null;
         }
         else if ( PROPERTY_PACKAGES.equals(arg) && packages != null  && arg != packages) {
            packages.deleteObserver(this);
            packages.clear();
            packages = null;
         }
         else if ( PROPERTY_DATATYPES.equals(arg) && datatypes != null  && arg != datatypes) {
            datatypes.deleteObserver(this);
            datatypes.clear();
            datatypes = null;
         }
         else if ( o == packages ){
            notifyObservers(PROPERTY_PACKAGES);
         }
         else if ( o == classes ) {
            notifyObservers(PROPERTY_CLASSES);
         }
      }
	
	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.Model#getPackages()
	 */
	public Collection getPackages() {
		if (packages == null) {

			packages = new ObservableList(new ArrayList());
            packages.addObserver(this);
			for (Iterator iter = srcModel.getPackages().iterator(); iter.hasNext();) {
				ModelPackageBase pkg = (ModelPackageBase) iter.next();
				// lazy creation of adapters to model package
				ModelElement elem = getModelElement(pkg);
				packages.add( elem);
			}
			Collections.sort(packages);
		}
		return packages;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.Model#getPackages()
	 */
	public Collection getDatatypes() {
		if (datatypes == null) {

			datatypes = new ObservableList(new ArrayList());
            datatypes.addObserver(this);
			for (Iterator iter = srcModel.getDatatypes().iterator(); iter.hasNext();) {
				ModelDataTypeBase dataTypeBase = (ModelDataTypeBase) iter.next();
				ModelDataType dataType = getModelDataType(dataTypeBase);
				
				datatypes.add(dataType);
			}
			Collections.sort(datatypes);
		}
		return datatypes;
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.Model#getClasses()
	 */
	public Collection getClasses() {
		
		if (classes == null) {

			// read packages first
			getPackages();
			classes = new ObservableList(new ArrayList());
            classes.addObserver(this);
			for (Iterator iter = srcModel.getClasses().iterator(); iter.hasNext();) {
				ModelClassBase cls = (ModelClassBase) iter.next();

				// lazy creation of adapters to model classes
				ModelElement elem = getModelElement(cls);
				classes.add(elem);
			}
			Collections.sort(classes);
		}
		return classes;
	}

   public ModelElement getOwner() {
      return null;
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.Model#find(java.lang.String)
    */
   public ModelElement find(String string) {
      String name = StringUtils.replace(string, "::", ".");
      for (Iterator iter = getClasses().iterator(); iter.hasNext();) {
         ModelClassBase modelClassBase = (ModelClassBase) iter.next();
         ModelClass modelClass = getModelClass(modelClassBase);
         
         if ( modelClass.getQualifiedName().equals(name) )
            return modelClass;
      }
      for (Iterator iter = getPackages().iterator(); iter.hasNext();) {
         ModelPackageBase modelPackageBase = (ModelPackageBase) iter.next();
         ModelPackage modelPackage = getModelPackage(modelPackageBase);
         
         if ( modelPackage.getQualifiedName().equals(string) )
            return modelPackage;
      }
      for (Iterator iter = getDatatypes().iterator(); iter.hasNext();) {
         ModelDataTypeBase modelDataTypeBase = (ModelDataTypeBase) iter.next();
         ModelDataType modelDataType = getModelDataType(modelDataTypeBase);
         
         if ( modelDataType.getQualifiedName().equals(string) )
            return modelDataType;
      }
      
      return null;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.Model#getModelElement(org.umlmda.model.uml.ModelElementBase)
    */
	public final ModelElement getModelElement( ModelElementBase modelElement) {
		
		if (modelElement == null) {
			return null;
		}
		// lookup element in element map
		ModelElement result = (ModelElement)elementMap.get(modelElement.getModelUId());
		if (result != null) {
			return result;
		}

		if (modelElement instanceof ModelAssociationBase) {
			result = factory.createModelAssociation( (ModelAssociationBase)modelElement, this);
		} else if (modelElement instanceof ModelAttributeBase) {
			result = factory.createModelAttribute( (ModelAttributeBase)modelElement, this);
		} else if (modelElement instanceof ModelClassBase) {
			result = factory.createModelClass( (ModelClassBase)modelElement, this);
		} else if (modelElement instanceof ModelDataTypeBase) {
			result = factory.createModelDataType( (ModelDataTypeBase)modelElement, this);
		} else if (modelElement instanceof ModelMethodBase) {
			result = factory.createModelMethod( (ModelMethodBase)modelElement, this);
		} else if (modelElement instanceof ModelPackageBase) {
			result = factory.createModelPackage( (ModelPackageBase)modelElement, this);
		} else if (modelElement instanceof ModelParameterBase) {
			result = factory.createModelParameter( (ModelParameterBase)modelElement, this);
        } else if (modelElement instanceof ModelDependencyBase) {
           result = factory.createModelDependency( (ModelDependencyBase)modelElement, this);
        } else if (modelElement instanceof ModelGeneralizationBase) {
           result = factory.createModelGeneralization( (ModelGeneralizationBase)modelElement, this);
        } else if (modelElement instanceof ModelBase) {
            try {
               result = factory.createModel( (ModelBase)modelElement);
            } catch (ModelValidationException e) {
               throw new RuntimeException(e);
            }
		} else {
			throw new RuntimeException("unknown type for model element: " + modelElement.getClass().getName());
		}

		// store the new result element in map
		ModelElement oldElement = (ModelElement) elementMap.put(modelElement.getModelUId(), result);
		if ( oldElement != null ) {
		   throw new RuntimeException("Model inconsistent, elements with same unique id exists ("+result.getQualifiedName()+", "+oldElement.getQualifiedName()+")" );
		}
		return result;
	}

	public final ModelAssociation getModelAssociation( ModelAssociationBase modelAssociation) {
		return (ModelAssociation) getModelElement( modelAssociation);
	}

	public final ModelAttribute getModelAttribute( ModelAttributeBase modelAttribute) {
		return (ModelAttribute) getModelElement( modelAttribute);
	}

	public final ModelClass getModelClass( ModelClassBase modelClass) {
		return (ModelClass)getModelElement( modelClass);
	}

	public final ModelClassifier getModelClassifier( ModelClassifierBase modelClassifier) {
		return (ModelClassifier) getModelElement( modelClassifier);
	}

	public final ModelDataType getModelDataType( ModelDataTypeBase modelDataType) {
		return (ModelDataType) getModelElement( modelDataType);
	}

	public final ModelMethod getModelMethod( ModelMethodBase modelMethod) {
		return (ModelMethod) getModelElement( modelMethod);
	}

	public final ModelPackage getModelPackage( ModelPackageBase modelPackage) {
		return (ModelPackage) getModelElement( modelPackage);
	}

	public final ModelParameter getModelParameter( ModelParameterBase modelParameter) {
		return (ModelParameter) getModelElement( modelParameter);
	}
   
   public ModelDependency getModelDependency(ModelDependencyBase dependencyBase) {
      return (ModelDependency) getModelElement(dependencyBase);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.Model#getModelGeneralization(org.umlmda.model.uml.ModelGeneralizationBase)
    */
   public ModelGeneralization getModelGeneralization(ModelGeneralizationBase generalizationBase) {
      return (ModelGeneralization)getModelElement(generalizationBase);
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.Model#getModelAdapterFactory()
    */
   public ModelAdapterFactory getModelAdapterFactory() {
      return factory;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

   public ModelClass findClassByName(String classname) {
	   return (ModelClass) getModelElement(srcModel.findClassByName(classname));
   }

}
