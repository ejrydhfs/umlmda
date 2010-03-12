/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassHierarchyCreatorVisitor.java,v 1.4 2007/07/31 13:05:34 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassHierarchyCreatorVisitor.java,v $
 * $Revision: 1.4 $
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

import java.beans.Introspector;
import java.util.Iterator;

import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.impl.ModelAssociationImpl;
import org.umlmda.model.uml.impl.ModelAttributeImpl;
import org.umlmda.model.uml.impl.ModelClassImpl;
import org.umlmda.model.uml.impl.ModelElementAdapter;
import org.umlmda.model.uml.impl.ModelMethodImpl;
import org.umlmda.model.uml.impl.ModelParameterImpl;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.PIMStereotypes;

/**
 * Creates web service dto hierarchie for polymorphic associations,
 * parameters and return types. 
 * @author Dieter Moroff (13.04.2006), last change $Date: 2007/07/31 13:05:34 $ $Name:  $
 * @version $Revision: 1.4 $
 */
public class WSPSMClassReferenceCreatorVisitor extends DefaultModelVisitor {
   
   public static final String REFERENCE_POSTFIX = "Reference";
   
   /**
    * 
    */
   public WSPSMClassReferenceCreatorVisitor() {
      super();
   }
   
   /**
    * @param classifier
    * @return
    */
   protected ModelClassBase createOrFindWsDtoReference(Model model, ModelClassifierBase classifier) {
      ModelClassBase classReference = null;
      
      if (  classifier instanceof ModelClassBase ) {
         ModelClass modelClass = model.getModelClass((ModelClassBase) classifier);
         
         if ( modelClass.hasStereotype(WSStereotypes.WEB_SERVICE_DTO) ) {
            classReference = createOrFindWsDtoReference(modelClass);
         }
      }
      return classReference;
   }

   @Override
   public boolean visit(ModelAssociation association) {
      
      super.visit(association);
      ModelClass source = association.getSource();
      ModelAssociationBase associationBase = (ModelAssociationBase) association.getBase();
      
      if ( source.hasStereotype(WSStereotypes.WEB_SERVICE_DTO_REFERENCE) == false && association.isComposition() == false && associationBase instanceof ModelAssociationImpl) {
         ModelAssociationImpl associationImpl = (ModelAssociationImpl) association.getBase();
         ModelClassBase targetReference = createOrFindWsDtoReference(association.getModel(), associationImpl.getTargetBase());
         
         if (targetReference != null) {
            associationImpl.setTargetBase(targetReference);
         }     
      }      
      return true;
   }
   
   
   /**
    * If not existing creates a reference class with an assocation on every none abstract 
    * subclass of the given modelclass
    * @param modelClass
    * @param postFix
    * @return
    */
   private ModelClassBase createOrFindWsDtoReference(ModelClass modelClass) {
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackage();
      WSModel model = (WSModel) modelPackage.getModel();
      String name = modelClass.getName() + REFERENCE_POSTFIX;
      String qualifiedName = modelPackage.getWsPackage().getQualifiedName() + "." + name;
      ModelClass wsClass = (ModelClass) model.find(qualifiedName);
      
      if ( wsClass != null ) {
         return (ModelClassBase) wsClass.getBase();
      }
      else {
         ModelClassImpl wsClassImpl = new ModelClassImpl(model, modelPackage.getWsPackage());

         wsClassImpl.setName(name);
         wsClassImpl.setAbstract(false);
         wsClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_DTO_REFERENCE);
         wsClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_OBJECT);
         for ( Iterator iterator = ((WSModelClass)modelClass).getPIMClass().getAttributes().iterator(); iterator.hasNext(); ) {
            ModelAttribute attr = (ModelAttribute) iterator.next();

            if ( attr.hasStereotype("Id")) {
               ModelAttributeImpl wsAttributeImpl = new ModelAttributeImpl(model, wsClassImpl, attr);
               
               wsClassImpl.getAttributes().add(wsAttributeImpl);
            }
         }
         
         ModelElementAdapter.addDependency(((WSModelClass)modelClass).getPIMClass(), PIMStereotypes.PIM_OBJECT, wsClassImpl, model);
         
         wsClass = model.getModelClass(wsClassImpl);
         modelPackage.getWsPackage().getClasses().add(wsClass);
         model.getClasses().add(wsClass);

         return wsClassImpl;
      }
   }

   
}
