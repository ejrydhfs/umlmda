/*
 *  $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelAdapter.java,v 1.4 2007/07/31 13:05:34 moroff Exp $
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
 *  Created on 19.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.webservices;

import java.util.Calendar;

import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.utils.ModelVisitableIterator;

import org.umlmda.uml.generator.java.JavaModelAdapter;


public class WSModelAdapter extends JavaModelAdapter implements WSModel {

   private String dateMapping = null;
   private boolean init = false;
   
   public WSModelAdapter(ModelAdapterFactory factory, ModelBase srcModel) {
      super(factory, srcModel);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModel#isSoapWrapping()
    */
   public boolean isSoapWrapping() {
      return Boolean.valueOf(getProperties().getProperty(WSModel.PROPERTY_SOAP_WRAPPING, WSModel.PROPERTY_SOAP_WRAPPING_DEFAULT)).booleanValue();
   }

   public void init() {
      super.init();
      wsInit();
   }

   /**
    * 
    */
   protected void wsInit() {
      if ( !init ) {
         ModelVisitableIterator modelIterator;
         
         this.init = true;
         
         // Create web service classes
         modelIterator = new ModelVisitableIterator(new WSPSMClassCreatorVisitor());
         modelIterator.iterate(this);

         // Create hierarchy classes for polymorphic types
         modelIterator = new ModelVisitableIterator(new WSPSMClassHierarchyCreatorVisitor());
         modelIterator.iterate(this);

         // Create hierarchy classes for polymorphic types
         modelIterator = new ModelVisitableIterator(new WSPSMClassHierarchyFixVisitor());
         modelIterator.iterate(this);

         // Handle multiple inheritance
         modelIterator = new ModelVisitableIterator(new WSPSMClassMultipleInheritanceVisitor());
         modelIterator.iterate(this);
         
         if ( isSoapWrapping() ) {
            modelIterator = new ModelVisitableIterator(new WSPSMRequestReponseCreateVisitor());
            modelIterator.iterate(this);
         }
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModel#getDateMapping()
    */
   public String getDateMapping() {
      if ( dateMapping == null ) {
         dateMapping = getProperties().getProperty("DateMapping", Calendar.class.getName());
      }
      return dateMapping;
   }
   
}
