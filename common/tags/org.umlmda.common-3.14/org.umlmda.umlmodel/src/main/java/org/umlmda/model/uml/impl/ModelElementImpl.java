/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelElementImpl.java,v 1.6 2006/06/24 18:50:21 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelElementImpl.java,v $
 * $Revision: 1.6 $
 *     $Name:  $
 *     $Date: 2006/06/24 18:50:21 $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (08.08.2005)
 */
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.utils.observer.ObservableList;


/**
 * Simple implementation of a model element
 * 
 * @author Dieter Moroff (08.08.2005)
 */
public class ModelElementImpl extends Observable implements ModelElementBase, Observer {
   private final ModelBase model;
   private final ModelElementBase owner;
   private Properties taggedValues = new Properties();
   private ObservableList stereotypes = new ObservableList(new ArrayList());
   private ObservableList dependencies = new ObservableList(new ArrayList());
   private String name = null;
   private String documentation = null;
   private final String modelUID;
   private String constraints = null;

   /**
    * 
    */
   public ModelElementImpl(ModelBase model, ModelElementBase owner) {
      super();
      this.model = model;
      this.owner = owner;
      this.modelUID = createUUID();
   }

   /**
    * @param model2
    * @param owner2
    * @param source
    */
   public ModelElementImpl(ModelBase model, ModelElementBase owner, ModelElementBase source) {
      this(model, owner);
      setDocumentation(source.getDocumentation());
      setName(source.getName());
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getTaggedValues()
    */
   public Properties getTaggedValues() {
      return taggedValues;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotypes()
    */
   public Collection getStereotypes() {
      return stereotypes;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getName()
    */
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
      notifyObservers(PROPERTY_NAME);
   }
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getDocumentation()
    */
   public String getDocumentation() {
      return documentation;
   }

   public void setDocumentation(String documentation) {
      this.documentation = documentation;
      notifyObservers(PROPERTY_DOCUMENTATION);
   }
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getOwner()
    */
   public ModelElementBase getOwner() {
      return owner;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElementBase#getOwnerBase()
    */
   public ModelElementBase getOwnerBase() {
      return getOwner();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getModel()
    */
   public ModelBase getModelBase() {
      return model;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getDependencies()
    */
   public Collection getDependencies() {
      return dependencies;
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      if ( o == stereotypes ) {
         notifyObservers(PROPERTY_STEREOTYPES);
      }
      else if ( o == dependencies ) {
         notifyObservers(PROPERTY_DEPENDENCIES);
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty()
    */
   public String getStereotypeProperty(String name) {
      return taggedValues.getProperty(name);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String)
    */
   public String getStereotypeProperty(String name, String defaultValue) {
      return taggedValues.getProperty(name, defaultValue);
   }

   public void notifyObservers() {
      setChanged();
      super.notifyObservers();
   }
   public void notifyObservers(Object arg) {
      setChanged();
      super.notifyObservers(arg);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getModelUId()
    */
   public String getModelUId() {
      return modelUID;
   }
 
   private static long sequence = 0L;

   public static synchronized String createUUID() {
      ++sequence;
      return "UMLMDA-UUID-"+Long.toHexString(sequence);
   }
   
   /**
    * @return Returns the constraints.
    */
   public String getConstraints() {
      return constraints;
   }
   
   /**
    * @param constraints The constraints to set.
    */
   public void setConstraints(String constraints) {
      this.constraints = constraints;
      notifyObservers(PROPERTY_CONSTRAINTS);
   }
   
}
