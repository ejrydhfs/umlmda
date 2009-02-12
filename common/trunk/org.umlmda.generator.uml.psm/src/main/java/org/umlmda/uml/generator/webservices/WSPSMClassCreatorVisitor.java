/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassCreatorVisitor.java,v 1.4 2007/07/16 07:43:21 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassCreatorVisitor.java,v $
 * $Revision: 1.4 $
 *     $Name:  $
 *     $Date: 2007/07/16 07:43:21 $
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

import java.util.Iterator;

import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.impl.ModelAssociationImpl;
import org.umlmda.model.uml.impl.ModelAttributeImpl;
import org.umlmda.model.uml.impl.ModelClassImpl;
import org.umlmda.model.uml.impl.ModelElementAdapter;
import org.umlmda.model.uml.impl.ModelGeneralizationImpl;
import org.umlmda.model.uml.impl.ModelMethodImpl;
import org.umlmda.model.uml.impl.ModelParameterImpl;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.PIMStereotypes;
import org.umlmda.uml.generator.java.JavaModelClass;

/**
 * Creates web service classes 
 * @author Dieter Moroff (12.04.2006), last change $Date: 2007/07/16 07:43:21 $ $Name:  $
 * @version $Revision: 1.4 $
 */
public class WSPSMClassCreatorVisitor extends DefaultModelVisitor {

   /**
    * 
    */
   public WSPSMClassCreatorVisitor() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelClass)
    */
   public boolean visit(ModelClass modelClass) {
      super.visit(modelClass);
      
      WSModelClass wsClass = (WSModelClass) modelClass;

      if (wsClass.hasStereotype(ModelStereotype.BUSINESS_OBJECT)) {
         if (wsClass.isOptimized()) {
            createOrFindWsDTO(wsClass, WSStereotypes.WEB_SERVICE_DTO, "In", ModelStereotype.DIRECTION_OUT);
            createOrFindWsDTO(wsClass, WSStereotypes.WEB_SERVICE_DTO, "Out", ModelStereotype.DIRECTION_IN);
         }
         else {
            createOrFindWsDTO(wsClass, WSStereotypes.WEB_SERVICE_DTO, "", null);
         }
      }
      
      else if (wsClass.hasStereotype(ModelStereotype.BUSINESS_SERVICE)) {
         createOrFindWsService(wsClass);
      }

      else if (wsClass.hasStereotype(ModelStereotype.ENUMERATION)) {
         createOrFindWsEnumeration(wsClass);
      }
      
      else if (wsClass.hasStereotype(ModelStereotype.BUSINESS_EXCEPTION)) {
         createOrFindWsDTO(wsClass, WSStereotypes.WEB_SERVICE_EXCEPTION, "", null);
      }
      return true;
   }

   /**
    * @param modelClass
    * @param postFix
    * @param excludeStereotype
    */
   private ModelClass createOrFindWsService(ModelClass modelClass) {
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackage();
      WSModel model = (WSModel) modelPackage.getModel();
      ModelClassBase wsClassImpl = createOrFindWsClassImpl(modelClass, "", null, WSStereotypes.WEB_SERVICE, PIMStereotypes.PIM_SERVICE);

    if ( wsClassImpl instanceof ModelClass ) {
       return (ModelClass) wsClassImpl;
    }
    else {
       ModelClass wsClass = createWsClassAdapter(model, wsClassImpl);
       
         // Handle methods
         for (Iterator im = modelClass.getMethods().iterator(); im.hasNext();) {
            ModelMethod method = (ModelMethod) im.next();
            ModelMethodImpl wsMethodImpl = new ModelMethodImpl(model, wsClassImpl);

            wsMethodImpl.setName(method.getName());
            wsMethodImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_METHOD);
            if (method.getReturnType() instanceof ModelClass) {
               ModelClass returnClass = (ModelClass) method.getReturnType();
               ModelClass wsReturnClass = createOrFindWsOutDTO(returnClass);
               ModelClassBase wsReturnClassImpl = (ModelClassBase)wsReturnClass.getBase();

               wsMethodImpl.setReturnTypeBase(wsReturnClassImpl);
            }
            else {
               wsMethodImpl.setReturnTypeBase(method.getReturnTypeBase());
            }

            // Handle parameters
            for (Iterator ip = method.getParameters().iterator(); ip.hasNext();) {
               ModelParameter parameter = (ModelParameter) ip.next();
               ModelParameterImpl wsParameterImpl = new ModelParameterImpl(model, wsMethodImpl);

               wsParameterImpl.setName(parameter.getName());
               if (parameter.getTypeBase() instanceof ModelClass) {
                  ModelClass parameterClass = (ModelClass) parameter.getTypeBase();

                  wsParameterImpl.setTypeBase(createOrFindWsInDTO(parameterClass));
               }
               else {
                  wsParameterImpl.setTypeBase(parameter.getTypeBase());
               }

               wsMethodImpl.getParameters().add(wsParameterImpl);
            }

            for (Iterator ie = method.getExceptions().iterator(); ie.hasNext();) {
               WSModelClass exceptionClass = (WSModelClass) ie.next();
               
               wsMethodImpl.getExceptions().add(createOrFindWsDTO(exceptionClass, WSStereotypes.WEB_SERVICE_EXCEPTION, "", null).getBase());
            }

            ModelElementAdapter.addDependency(method, PIMStereotypes.PIM_METHOD, wsMethodImpl, model);
            wsClassImpl.getMethods().add(wsMethodImpl);
         }

         return wsClass;
      }
   }
   
   private ModelClass createOrFindWsInDTO(ModelClass modelClass) {
      if ( ((WSModelClass)modelClass).isOptimized() ) {
         return createOrFindWsDTO(modelClass, WSStereotypes.WEB_SERVICE_OBJECT, "In", ModelStereotype.DIRECTION_OUT);
      }
      else {
         return createOrFindWsDTO(modelClass, WSStereotypes.WEB_SERVICE_OBJECT, "", null);
      }
   }
   
   private ModelClass createOrFindWsOutDTO(ModelClass modelClass) {
      if ( ((WSModelClass)modelClass).isOptimized() ) {
         return createOrFindWsDTO(modelClass, WSStereotypes.WEB_SERVICE_OBJECT, "Out", ModelStereotype.DIRECTION_IN);
      }
      else {
         return createOrFindWsDTO(modelClass, WSStereotypes.WEB_SERVICE_OBJECT, "", null);
      }
   }
   
   /**
    * @param modelClass
    * @param stereotype TODO
    * @param postFix
    * @param excludeFeatureStereotype
    */
   private ModelClass createOrFindWsDTO(ModelClass modelClass, String stereotype, String postFix, String excludeFeatureStereotype) {
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackage();
      WSModel model = (WSModel) modelPackage.getModel();
      ModelClassBase wsClassImpl = createOrFindWsClassImpl(modelClass, postFix, excludeFeatureStereotype, WSStereotypes.WEB_SERVICE_DTO, PIMStereotypes.PIM_OBJECT);
      JavaModelClass javaModelClass = (JavaModelClass) modelClass;

      // If already an adapter, all work is done 
      if ( wsClassImpl instanceof ModelClass ) {
         return (ModelClass) wsClassImpl;
      }
      
      else {
         ModelClass wsClass = createWsClassAdapter(model, wsClassImpl);
         
         wsClassImpl.getStereotypes().add(stereotype);
         wsClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_OBJECT);
         
         // Handle attributes
         for (Iterator iattr = javaModelClass.getImplementedAttributes().iterator(); iattr.hasNext();) {
            ModelAttribute attribute = (ModelAttribute) iattr.next();

            if ( attribute.isDerived() )
               continue;
            
            if (excludeFeatureStereotype == null || attribute.hasStereotype(excludeFeatureStereotype) == false) {
               ModelAttributeImpl wsAttributeImpl = new ModelAttributeImpl(model, wsClassImpl, attribute);
               
               if ( attribute.isPrimitiveType() == false ) {
                  if ( attribute.getModelClass().hasStereotype(ModelStereotype.ENUMERATION) ) {
                     wsAttributeImpl.setModelClassBase((ModelClassBase) createOrFindWsEnumeration((ModelClass)attribute.getModelClassBase()).getBase());
                  }
                  else {
                     wsAttributeImpl.setModelClassBase((ModelClassBase) createOrFindWsDTO((ModelClass)attribute.getModelClassBase(), stereotype, postFix, excludeFeatureStereotype).getBase());
                  }
               }
               wsClassImpl.getAttributes().add(wsAttributeImpl);
            }
         }

         // Handle associations
         for (Iterator iassoc = javaModelClass.getImplementedAssociations().iterator(); iassoc.hasNext();) {
            ModelAssociation association = (ModelAssociation) iassoc.next();

            if ( association.isDerived() )
               continue;
            
            if (excludeFeatureStereotype == null || association.hasStereotype(excludeFeatureStereotype) == false) {
               ModelAssociationImpl wsAssociationImpl = new ModelAssociationImpl(model, wsClassImpl);

               wsAssociationImpl.setAggregation(association.isAggregation());
               wsAssociationImpl.setComposition(association.isComposition());
               wsAssociationImpl.setDerived(association.isDerived());
               wsAssociationImpl.setDocumentation(association.getDocumentation());
               wsAssociationImpl.setMultiplicity(association.getMultiplicity());
               wsAssociationImpl.setName(association.getName());
               wsAssociationImpl.setNavigatableToSource(association.isNavigatableToSource());
               wsAssociationImpl.setNavigatableToTarget(association.isNavigatableToTarget());
               wsAssociationImpl.setSourceBase(wsClassImpl);
               
               WSModelClass targetClass = (WSModelClass) association.getTarget();
               WSModelClass wsTargetClass;
               ModelClassBase wsTargetClassBase;
               
               if (targetClass.isOptimized() && "In".equals(postFix)) {
                  wsTargetClass = (WSModelClass) createOrFindWsInDTO(targetClass);
               }
               else if (targetClass.isOptimized() && "Out".equals(postFix)) {
                  wsTargetClass = (WSModelClass) createOrFindWsOutDTO(targetClass);
               }
               else {
                  wsTargetClass = (WSModelClass) createOrFindWsDTO(targetClass, WSStereotypes.WEB_SERVICE_DTO, "", null);
               }

               wsTargetClassBase = (ModelClassBase) wsTargetClass.getBase();
               wsAssociationImpl.setTargetBase(wsTargetClassBase);
               //TODO check if reverse have to be set
               wsAssociationImpl.setReverseBase(wsAssociationImpl.createReverse());

               wsClassImpl.getAssociations().add(wsAssociationImpl);
               wsClassImpl.getAllAssociations().add(wsAssociationImpl);
               wsTargetClassBase.getAllAssociations().add(wsAssociationImpl.getReverseBase());
            }
         }

         return wsClass;
      }
   }
   
   /**
    * @param modelClass
    * @param postFix
    * @param excludeStereotype
    * @param stereotype
    * @param dependencyStereotype
    * @return
    */
   private ModelClassBase createOrFindWsClassImpl(ModelClass modelClass, String postFix, String excludeStereotype, String stereotype, String dependencyStereotype) {
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackage();
      WSModel model = (WSModel) modelPackage.getModel();
      String name = modelClass.getName() + postFix;
      String qualifiedName = modelPackage.getWsPackage().getQualifiedName() + "." + name;
      ModelClass wsClass = (ModelClass) model.find(qualifiedName);
      WSModelPackage wsModelPackage = (WSModelPackage) modelClass.getPackage();
      
      if ( wsClass != null ) {
         return wsClass;
      }
      else {
         ModelClassImpl wsClassImpl = new ModelClassImpl(model, wsModelPackage.getWsPackage(), modelClass);

         wsClassImpl.setName(name);
         wsClassImpl.getStereotypes().add(stereotype);

         ModelElementAdapter.addDependency(modelClass, dependencyStereotype, wsClassImpl, model);

         // Handle super classes
         for (Iterator isc = modelClass.getGeneralizations().iterator(); isc.hasNext();) {
            ModelGeneralization generalization = (ModelGeneralization) isc.next();
            WSModelClass superClass = (WSModelClass) generalization.getGeneral();
            ModelGeneralizationImpl generalizationImpl;
            
//            if ( modelClass.getGeneralizations().size() == 1 || generalization.hasStereotype(ModelStereotype.EXTENDS) ) {
//               WSModelClass superClass = (WSModelClass) generalization.getGeneral();
//               WSModelPackageAdapter superClassPackage = (WSModelPackageAdapter) superClass.getPackage();
//
               if (superClass.isOptimized()) {
                  ModelClass optSuperClass = (ModelClass) model.find(superClass.getQualifiedName() + postFix);

                  if (optSuperClass == null) {

                     optSuperClass = createOrFindWsDTO(superClass, WSStereotypes.WEB_SERVICE_OBJECT, postFix,
                           excludeStereotype);
                  }
                  generalizationImpl = new ModelGeneralizationImpl(model, optSuperClass, wsClassImpl);
               }
               else {
                  ModelClass wsSuperClass = null;

                  if (superClass.hasStereotype(ModelStereotype.BUSINESS_EXCEPTION)) {
                     wsSuperClass = createOrFindWsDTO(superClass, WSStereotypes.WEB_SERVICE_EXCEPTION, "", null);
                  }
                  else {
                     
                     wsSuperClass = createOrFindWsDTO(superClass, WSStereotypes.WEB_SERVICE_OBJECT, "", null);
                  }
                  generalizationImpl = new ModelGeneralizationImpl(model, wsSuperClass, wsClassImpl);
               }
               generalizationImpl.getStereotypes().addAll(generalization.getStereotypes());
               wsClassImpl.getGeneralizations().add(generalizationImpl);
            }
//         }
         return wsClassImpl;
      }
   }
   
   /**
    * @param modelClass
    * @param postFix
    * @param excludeStereotype
    */
   private ModelClass createOrFindWsEnumeration(ModelClass modelClass) {
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackage();
      WSModel model = (WSModel) modelPackage.getModel();
      ModelClassBase wsClassImpl = createOrFindWsClassImpl(modelClass, "", null, WSStereotypes.WEB_SERVICE_ENUMERATION, PIMStereotypes.PIM_OBJECT);

      // If already an adapter, all work is done 
      if ( wsClassImpl instanceof ModelClass ) {
         return (ModelClass) wsClassImpl;
      }
      
      else {
         ModelClass wsClass = createWsClassAdapter(model, wsClassImpl);
         
         // Handle attributes
         for (Iterator iattr = modelClass.getAttributes().iterator(); iattr.hasNext();) {
            ModelAttribute attribute = (ModelAttribute) iattr.next();
            ModelAttributeImpl wsModelAttribute = new ModelAttributeImpl(model, wsClassImpl, attribute);

            wsClassImpl.getAttributes().add(wsModelAttribute);
         }

         return wsClass;
      }
   }
   
   /**
    * @param wsClassBase
    * @return
    */
   public static ModelClass createWsClassAdapter(Model model, ModelClassBase wsClassBase) {
      if ( wsClassBase instanceof WSModelClassAdapter ) {
         return (ModelClass) wsClassBase;
      }
      else {
         ModelClass wsClass = model.getModelClass(wsClassBase);
         WSModelPackage modelPackage = (WSModelPackage) wsClass.getPackage();
         modelPackage.getClasses().add(wsClass);
         model.getClasses().add(wsClass);
         return wsClass;
      }
   }
   
}
