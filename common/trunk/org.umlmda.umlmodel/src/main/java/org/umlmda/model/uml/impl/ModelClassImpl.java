/*
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on 21.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.utils.observer.ObservableList;

/**
 * Basic implementation of the model class.
 * 
 * @author Dieter Moroff (21.10.2005)
 */
public class ModelClassImpl extends ModelElementImpl implements ModelClassBase
{
   private ObservableList attributes      = new ObservableList(new ArrayList());
   private ObservableList constants       = new ObservableList(new ArrayList());
   private ObservableList methods         = new ObservableList(new ArrayList());
   private ObservableList generalizations = new ObservableList(new ArrayList());
   private boolean        isAbstract      = false;
   private ObservableList allAssociations = new ObservableList(new ArrayList());
   private ObservableList associations    = new ObservableList(new ArrayList());

   /**
    * @param model
    * @param owner
    */
   public ModelClassImpl(ModelBase model, ModelPackageBase owner) {
      super(model, owner);
      initObserver();
   }

   /**
    * @param model
    * @param owner
    */
   public ModelClassImpl(ModelBase model, ModelPackageBase owner, ModelClassBase source) {
      super(model, owner, source);
      setAbstract(source.isAbstract());
      initObserver();
   }

   private void initObserver() {
      attributes.addObserver(this);
      constants.addObserver(this);
      methods.addObserver(this);
      generalizations.addObserver(this);
      allAssociations.addObserver(this);
      associations.addObserver(this);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      super.update(o, arg);
      if ( o == attributes ) {
         notifyObservers(PROPERTY_ATTRIBUTES);
      }
      else if ( o == constants ) {
         notifyObservers(PROPERTY_CONSTANTS);
      }
      else if ( o == methods ) {
         notifyObservers(PROPERTY_METHODS);
      }
      else if ( o == generalizations ) {
         notifyObservers(PROPERTY_GENERALIZATIONS);
      }
      else if ( o == allAssociations ) {
         notifyObservers(PROPERTY_ALL_ASSOCIATIONS);
      }
      else if ( o == associations ) {
         notifyObservers(PROPERTY_ASSOCIATIONS);
      }
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#getPackageBase()
    */
   public ModelPackageBase getPackageBase() {
      return (ModelPackageBase) getOwnerBase();
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#getAttributes()
    */
   public List getAttributes() {
      return attributes;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#getConstants()
    */
   public List getConstants() {
      return constants;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#getMethods()
    */
   public List getMethods() {
      return methods;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#getSuperClasses()
    */
   public List getGeneralizations() {
      return generalizations;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#getAssociations()
    */
   public List getAssociations() {
      return associations;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#getAllAssociations()
    */
   public List getAllAssociations() {
      return allAssociations;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelClassBase#isAbstract()
    */
   public boolean isAbstract() {
      return isAbstract;
   }

   public void setAbstract(boolean isAbstract) {
      this.isAbstract = isAbstract;
      notifyObservers("abstract");
   }
}
