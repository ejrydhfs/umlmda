/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/emf/EMFModelAdapter.java,v 1.1 2007/01/03 21:15:54 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/emf/EMFModelAdapter.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2007/01/03 21:15:54 $
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
 * Created on 04.12.2006 (Dieter Moroff)
 */
package org.umlmda.uml.generator.emf;

import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.utils.ModelVisitableIterator;
import org.umlmda.uml.generator.webservices.WSModelAdapter;
import org.umlmda.uml.generator.webservices.WSPSMClassCreatorVisitor;
import org.umlmda.uml.generator.webservices.WSPSMRequestReponseCreateVisitor;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EMFModelAdapter extends WSModelAdapter {

   private boolean init = false;

   /**
    * @param factory
    * @param srcModel
    */
   public EMFModelAdapter(ModelAdapterFactory factory, ModelBase srcModel) {
      super(factory, srcModel);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModel#isSoapWrapping()
    */
   public boolean isSoapWrapping() {
      return true;
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

//         // Create hierarchy classes for polymorphic types
//         modelIterator = new ModelVisitableIterator(new WSPSMClassHierarchyCreatorVisitor());
//         modelIterator.iterate(this);
         
         modelIterator = new ModelVisitableIterator(new EMFPSMTestCreateVisitor());
         modelIterator.iterate(this);
      }
   }
   
   
}
