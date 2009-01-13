/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassMultipleInheritanceVisitor.java,v 1.1 2007/04/12 06:45:54 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassMultipleInheritanceVisitor.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2007/04/12 06:45:54 $
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
 * Created by Dieter Moroff (12.04.2006)
 */
package org.umlmda.uml.generator.webservices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelGeneralizationBase;
import org.umlmda.model.uml.impl.ModelAttributeImpl;
import org.umlmda.model.uml.impl.ModelClassImpl;
import org.umlmda.profile.ModelStereotype;

/**
 * Creates web service classes 
 * @author Dieter Moroff (12.04.2006), last change $Date: 2007/04/12 06:45:54 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public class WSPSMClassMultipleInheritanceVisitor extends DefaultModelVisitor {

   /**
    * 
    */
   public WSPSMClassMultipleInheritanceVisitor() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelClass)
    */
   public boolean visit(ModelClass modelClass) {
      super.visit(modelClass);
      
      WSModelClass wsClass = (WSModelClass) modelClass;
      WSModel wsModel = (WSModel) wsClass.getModel();

      if (wsClass.hasStereotype(WSStereotypes.WEB_SERVICE_OBJECT) && wsClass.getGeneralizations().size() > 1 ) {
         ModelClassImpl wsClassImpl = (ModelClassImpl) wsClass.getBase();
         List generalizations = ((ModelClassBase)wsClass.getBase()).getGeneralizations();
         
         // Copy attributes and associations from class, remove generalization
         for (Iterator igen = generalizations.iterator(); igen.hasNext();) {
            ModelGeneralizationBase	generalizationBase = (ModelGeneralizationBase) igen.next();
            ModelGeneralization generalization = wsModel.getModelGeneralization(generalizationBase);
            
            if ( generalization.hasStereotype(ModelStereotype.EXTENDS) == false ) {
//               List inheritedAttr = new ArrayList(wsClass.getImplementedAttributes());
//               
//               inheritedAttr.removeAll(wsClass.getDeclaredAttributes());
//               
//               for (Iterator ia = inheritedAttr.iterator(); ia.hasNext();) {
//                  ModelAttribute attribute = (ModelAttribute) ia.next();
//                  ModelAttributeImpl wsAttributeImpl = new ModelAttributeImpl(wsModel, wsClassImpl, attribute);
//                  ModelClassifier attrClassifer = (ModelClassifier) wsModel.find(attribute.getModelClassifier().getQualifiedName());
//                  
//                  if ( attribute.isPrimitiveType() == false ) {
//                     wsAttributeImpl.setModelClassBase((ModelClassBase) attrClassifer.getBase());
//                  }
//                  else {
//                     wsAttributeImpl.setDataTypeBase((ModelDataTypeBase) attrClassifer.getBase());
//                  }
//                  wsClassImpl.getAttributes().add(wsAttributeImpl);
//               }
               igen.remove();
            }
         }
      }
      return true;
   }
   
}
