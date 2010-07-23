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
// Created on Jun 7, 2005
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelDependencyBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelElementBase;

/**
 * platform independent adapter to MOF model element. extend for specific platform to override the following properties: tagged
 * values, stereotypes, name, documentation, qualified name, owner
 * 
 * @author vpussel
 */
public class ModelElementAdapter extends Observable implements ModelElement, Observer
{

   protected final Model          adaptedModel;                                              // the adapter model used for lazy
   // creation

   // model relations
   private final ModelElementBase modelElement;                                              // reference to source model
   // element

   private final static Logger    logger       = Logger.getLogger(ModelElementAdapter.class);

   private ModelElement           owner        = null;

   private Set                    stereotypes  = null;

   private Collection             dependencies = null;

   private String                 constraints  = null;

   /**
    * create adapter from ModelElement
    */
   public ModelElementAdapter(ModelElementBase modelElement, Model adaptedModel) {
      if ( adaptedModel == null && this instanceof Model )
         this.adaptedModel = (Model) this;
      else
         this.adaptedModel = adaptedModel;
      this.modelElement = modelElement;

      if ( modelElement instanceof Observable ) {
         Observable observableModelElement = (Observable) modelElement;

         observableModelElement.addObserver(this);
      }
   }

   public final void detach() {
      if ( modelElement instanceof Observable ) {
         Observable observableModelElement = (Observable) modelElement;

         observableModelElement.deleteObserver(this);
      }
   }

   /**
    * Reset cached information
    * 
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      if ( PROPERTY_STEREOTYPES.equals(arg) ) {
         stereotypes.clear();
         stereotypes = null;
      }
      else if ( PROPERTY_DEPENDENCIES.equals(arg) ) {
         dependencies.clear();
         dependencies = null;
      }
      else if ( PROPERTY_CONSTRAINTS.equals(arg) ) {
         constraints = null;
      }
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getModel()
    */
   public final Model getModel() {
      return adaptedModel;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getModel()
    */
   public final ModelBase getModelBase() {
      return getModel();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getTaggedValues()
    */
   public Properties getTaggedValues() {
      return modelElement.getTaggedValues();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotype()
    */
   public String getStereotype() {
      Collection stereotypes = getStereotypes();

      if ( stereotypes.size() > 1 ) {
         throw new RuntimeException("More than one stereotype applied");
      }
      else if ( stereotypes.size() == 0 ) {
         return StringUtils.EMPTY;
      }
      else {
         return (String) stereotypes.iterator().next();
      }
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotypes()
    */
   public Collection getStereotypes() {
      if ( stereotypes == null ) {
         stereotypes = new HashSet(modelElement.getStereotypes());
      }
      return stereotypes;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#hasStereotype(java.lang.String)
    */
   public boolean hasStereotype(String stereotype) {
      return getStereotypes().contains(stereotype);
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#removeStereotype(java.lang.String)
    */
   public void removeStereotype(String stereotype) {
      getStereotypes().remove(stereotype);
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getName()
    */
   public String getName() {
      return modelElement.getName();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getDocumentation()
    */
   public String getDocumentation() {
      return modelElement.getDocumentation();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getQualifiedName()
    */
   public String getQualifiedName() {
      ModelElement owner = (ModelElement) getOwner();

      if ( owner != null && !(owner instanceof ModelBase) && owner.getName().equals("Logical View") == false )
         return owner.getQualifiedName() + "." + getName();
      else
         return getName();
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Comparable#compareTo(java.lang.Object)
    */
   public int compareTo(Object modelElement) {
      return getQualifiedName().compareTo(((ModelElement) modelElement).getQualifiedName());
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getOwner()
    */
   public ModelElement getOwner() {
      if ( owner == null ) {
         ModelElementBase ownerBase = modelElement.getOwnerBase();
         if ( ownerBase == adaptedModel ) {
            owner = adaptedModel;
         }
         else {
            owner = adaptedModel.getModelElement(ownerBase);

            // if ( owner == null ) {
            // logger.warn("Count not get owner of element "+getName());
            // }
         }
      }
      return owner;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElementBase#getOwnerBase()
    */
   public ModelElementBase getOwnerBase() {
      return getOwner();
   }

   /**
    * @deprecated use getQualifiedName()
    */
   public String toString() {
      return getQualifiedName();
   }

   public boolean equals(Object obj) {
      if ( obj instanceof ModelElement ) {
         ModelElement modelElement = (ModelElement) obj;

         return getQualifiedName().equals(modelElement.getQualifiedName());
      }
      else if ( obj instanceof ModelElementBase ) {
         ModelElementBase modelElementBase = (ModelElementBase) obj;
         ModelElement modelElement = adaptedModel.getModelElement(modelElementBase);

         return this.equals(modelElement);
      }
      else
         return false;
   }

   public int hashCode() {
      return toString().hashCode();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getDependency()
    */
   public Collection getDependencies() {
      if ( dependencies == null ) {
         dependencies = new ArrayList(modelElement.getDependencies().size());
         for ( Iterator id = modelElement.getDependencies().iterator(); id.hasNext(); ) {
            ModelDependencyBase dependencyBase = (ModelDependencyBase) id.next();

            dependencies.add(getModel().getModelDependency(dependencyBase));
         }
      }
      return dependencies;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getBase()
    */
   public final ModelElementBase getBase() {
      if ( modelElement instanceof ModelElement )
         return ((ModelElement) modelElement).getBase();
      else
         return modelElement;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty()
    */
   public String getStereotypeProperty(String name) {
      return modelElement.getStereotypeProperty(name);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String)
    */
   public String getStereotypeProperty(String name, String defaultValue) {
      return modelElement.getStereotypeProperty(name, defaultValue);
   }

   /**
    * @param clientElement
    * @param dependencyStereotype
    * @param supplierElement
    * @param model
    */
   static public void addDependency(ModelElement clientElement, String dependencyStereotype, ModelElementBase supplierElement,
         Model model) {
      ModelDependencyImpl dependency = new ModelDependencyImpl(model, supplierElement);

      dependency.getStereotypes().add(dependencyStereotype);
      dependency.getSuppliers().add(supplierElement);
      dependency.getClients().add(clientElement.getBase());
      supplierElement.getDependencies().add(dependency);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getModelUId()
    */
   public final String getModelUId() {
      return modelElement.getModelUId();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getConstraints()
    */
   public String getConstraints() {
      if ( constraints == null ) {
         constraints = modelElement.getConstraints();

         if ( constraints == null ) {
            constraints = StringUtils.EMPTY;
         }
      }
      return constraints;
   }

}
