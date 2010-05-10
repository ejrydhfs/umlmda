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
 *  Created on 08.08.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.utils.observer.ObservableList;

/**
 * Basic implementation of a method
 * 
 * @author Dieter Moroff (08.08.2005)
 */
public class ModelMethodImpl extends ModelElementImpl implements ModelMethodBase
{

   private ObservableList      parameters     = new ObservableList(new ArrayList());
   private ObservableList      exceptions     = new ObservableList(new ArrayList());
   private ModelClassifierBase returnTypeBase = null;

   /**
    * @param model
    * @param owner
    */
   public ModelMethodImpl(ModelBase model, ModelElementBase owner) {
      super(model, owner);
      initObserver();
   }

   private void initObserver() {
      parameters.addObserver(this);
      exceptions.addObserver(this);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      super.update(o, arg);
      if ( o == parameters ) {
         notifyObservers(PROPERTY_PARAMETERS);
      }
      else if ( o == exceptions ) {
         notifyObservers(PROPERTY_EXCEPTIONS);
      }
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethodBase#getParameters()
    */
   public List getParameters() {
      return parameters;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethodBase#getExceptions()
    */
   public List getExceptions() {
      return exceptions;
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethodBase#getReturnTypeBase()
    */
   public ModelClassifierBase getReturnTypeBase() {
      return returnTypeBase;
   }

   public void setReturnTypeBase(ModelClassifierBase returnTypeBase) {
      this.returnTypeBase = returnTypeBase;
      setChanged();
      notifyObservers(PROPERTY_RETURN_TYPE_BASE);
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelMethodBase#getOwningClass()
    */
   public ModelClassBase getOwningClass() {
      return (ModelClassBase) getOwnerBase();
   }

}
