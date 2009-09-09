/*
 *  $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/j2ee/J2EEModelPackageAdapter.java,v 1.2 2006/10/23 09:32:48 moroff Exp $
 *  Copyright (C) 2003, 2004 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://umlmda.sf.net)
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
package org.umlmda.uml.generator.j2ee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.profile.ModelTaggedValues;

import org.umlmda.uml.generator.java.JavaModelPackageAdapter;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class J2EEModelPackageAdapter extends JavaModelPackageAdapter implements J2EEModelPackage {
   private List classes = null;
   
   /**
    * @param modelPackage
    * @param modelAdapter
    */
   public J2EEModelPackageAdapter(ModelPackageBase modelPackage, Model modelAdapter) {
      super(modelPackage, modelAdapter);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.j2ee.J2EEModelPackage#getComponent()
    */
   public String getComponent() {
      return getTaggedValues().getProperty(ModelTaggedValues.EBJ_COMPONENT, getName()+"/");
   }

   public String getModuleName() {
      return getTaggedValues().getProperty(ModelTaggedValues.EBJ_COMPONENT, getName());
   }

   /**
    * Returns a list of transactiontypes (string) used in the business component
    */
   public List getTransactionTypes() {
      Set transactionTypeSet = new HashSet();

      for (Iterator ibs = getClasses().iterator(); ibs.hasNext();) {
         ModelClass modelClass = (ModelClass) ibs.next();
         
         if ( modelClass.hasStereotype(ModelStereotype.BUSINESS_SERVICE) ) {
            for (Iterator im = modelClass.getMethods(true).iterator(); im.hasNext();) {
               ModelMethod method = (ModelMethod) im.next();
               String transactionType = method.getStereotypeProperty("transactionType", "Required");
               
               transactionTypeSet.add(transactionType);
            }
         }
      }
      List transactionTypes = new ArrayList(transactionTypeSet);
      Collections.sort(transactionTypes);
      return transactionTypes;
   }
   
   /**
    * Returns a list of methods for the given transaction type of the given model class
    * @param modelClass
    * @param transactionType
    */
   public List getMethods(ModelClass modelClass, String transactionType) {
      List methods = new ArrayList();

      if ( modelClass.hasStereotype(ModelStereotype.BUSINESS_SERVICE) ) {
         for (Iterator im = modelClass.getMethods(true).iterator(); im.hasNext();) {
            ModelMethod method = (ModelMethod) im.next();
            String type = method.getStereotypeProperty("transactionType", "Required");
            
            if ( type.equals(transactionType) ) {
               methods.add(method);
            }
         }
      }
      
      return methods;
   }
   
}
