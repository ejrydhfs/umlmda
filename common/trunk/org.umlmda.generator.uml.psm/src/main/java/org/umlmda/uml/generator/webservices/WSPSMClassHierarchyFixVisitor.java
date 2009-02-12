/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassHierarchyFixVisitor.java,v 1.1 2007/07/31 13:05:34 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassHierarchyFixVisitor.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2007/07/31 13:05:34 $
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
 * Created by Dieter Moroff (13.04.2006)
 */
package org.umlmda.uml.generator.webservices;

import java.util.Iterator;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;

/**
 * Fix web service dto hierarchie for polymorphic associations,
 * parameters and return types to avoid class cast exceptions.
 * @author Dieter Moroff (13.04.2006), last change $Date: 2007/07/31 13:05:34 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public class WSPSMClassHierarchyFixVisitor extends WSPSMClassHierarchyCreatorVisitor {
   
   /**
    * 
    */
   public WSPSMClassHierarchyFixVisitor() {
      super();
   }

   /**
    * @param classifier
    * @return
    */
   protected ModelClassBase createOrFindWsDtoHierarchie(Model model, ModelClassifierBase classifier) {
      ModelClassBase classHierary = null;
      
      if ( classifier instanceof ModelClassBase ) {
         ModelClass modelClass = model.getModelClass((ModelClassBase) classifier);
         
         if ( modelClass.hasStereotype(WSStereotypes.WEB_SERVICE_DTO) ) {
            return getBaseClassHierarchy(modelClass);
         }
      }
      return classHierary;
   }
   
   
   /**
    * @param modelClass
    * @return
    */
   private ModelClassBase getBaseClassHierarchy(ModelClass modelClass) {
      ModelClassBase baseClassHierarchy;
      
      for (Iterator isc = modelClass.getSuperClasses().iterator(); isc.hasNext();) {
         ModelClass superClass = (ModelClass) isc.next();
         WSModelPackage modelPackage = (WSModelPackage) superClass.getPackage();
         WSModel model = (WSModel) modelPackage.getModel();
         String name = superClass.getName() + HIERARCHY_POSTFIX;
         String qualifiedName = modelPackage.getWsPackage().getQualifiedName() + "." + name;
         ModelClass wsClass = (ModelClass) model.find(qualifiedName);
         
         if ( wsClass != null ) {
            return wsClass;
         }
      }
      return null;
   }   
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSPSMClassHierarchyCreatorVisitor#visit(org.umlmda.model.uml.ModelParameter)
    */
   public boolean visit(ModelParameter parameter) {
      return false;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSPSMClassHierarchyCreatorVisitor#visit(org.umlmda.model.uml.ModelMethod)
    */
   public boolean visit(ModelMethod method) {
      return false;
   }
}
