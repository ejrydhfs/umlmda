/*
 *  $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelPackageImpl.java,v 1.2 2006/04/13 23:04:37 moroff Exp $
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
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.utils.observer.ObservableList;

/**
 * Basic implementation of a model package.
 * 
 * @author Dieter Moroff (21.10.2005)
 */
public class ModelPackageImpl extends ModelElementImpl implements ModelPackageBase
{

   private ObservableList classes        = new ObservableList(new ArrayList());
   private ObservableList nestedPackages = new ObservableList(new ArrayList());

   /**
    * @param model
    * @param owner
    */
   public ModelPackageImpl(ModelBase model, ModelElementBase owner) {
      super(model, owner);
   }

   private void initObserver() {
      classes.addObserver(this);
      nestedPackages.addObserver(this);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.impl.ModelElementImpl#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      super.update(o, arg);
      if ( o == classes ) {
         notifyObservers(PROPERTY_CLASSES);
      } else if ( o == nestedPackages ) {
         notifyObservers(PROPERTY_PACKAGES);
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getClasses()
    */
   public List getClasses() {
      return classes;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getPackageBase()
    */
   public ModelPackageBase getPackageBase() {
      return (ModelPackageBase) getOwner();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelPackageBase#getNestedPackagesBase()
    */
   public List<? extends ModelPackageBase> getNestedPackagesBase() {
      return nestedPackages;
   }

}
