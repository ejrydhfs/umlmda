package org.umlmda.uml.generator.webservices.schema;

import java.util.Iterator;

import org.umlmda.generator.profile.Stereotype;
import org.umlmda.generator.profile.impl.StereotypeImpl;
import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
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
import org.umlmda.uml.generator.webservices.WSModel;
import org.umlmda.uml.generator.webservices.WSModelClass;
import org.umlmda.uml.generator.webservices.WSModelClassAdapter;
import org.umlmda.uml.generator.webservices.WSModelPackage;
import org.umlmda.uml.generator.webservices.WSPSMClassCreatorVisitor;
import org.umlmda.uml.generator.webservices.WSStereotypes;

/**
 * Creates web service classes
 * 
 */
public class WSSchemaPSMClassCreatorVisitor extends WSPSMClassCreatorVisitor
{

   /**
    * 
    */
   public WSSchemaPSMClassCreatorVisitor() {
      super();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelClass)
    */
   public boolean visit(ModelPackage modelPackage) {
      super.visit(modelPackage);

      for ( Iterator iterator = modelPackage.getClasses().iterator(); iterator.hasNext(); ) {
         ModelClass boClass = (ModelClass) iterator.next();

         boClass.accept(this);
      }
      return true;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitor#visit(org.umlmda.model.uml.ModelClass)
    */
   public boolean visit(ModelClass modelClass) {
      if ( logger.isDebugEnabled() ) {
         logger.debug("visiting modelClass " + modelClass.getQualifiedName());
      }

      WSModelClass wsClass = (WSModelClass) modelClass;

      if ( wsClass.hasStereotype(ModelStereotype.BUSINESS_OBJECT) ) {

         createOrFindWsDTO(wsClass, WSStereotypes.WEB_SERVICE_DTO, "", null);
      }

      else if ( wsClass.hasStereotype(ModelStereotype.BUSINESS_SERVICE) ) {
         createOrFindWsService(wsClass);
      }

      else if ( wsClass.hasStereotype(ModelStereotype.ENUMERATION) ) {
         createOrFindWsEnumeration(wsClass);
      }

      else if ( wsClass.hasStereotype(ModelStereotype.BUSINESS_EXCEPTION) ) {
         createOrFindWsDTO(wsClass, WSStereotypes.WEB_SERVICE_EXCEPTION, "", null);
      }

      else {
         if ( !(wsClass.hasStereotype(WSStereotypes.WEB_SERVICE) || wsClass.hasStereotype(WSStereotypes.WEB_SERVICE_DTO)
               || wsClass.hasStereotype(WSStereotypes.WEB_SERVICE_OBJECT)
               || wsClass.hasStereotype(WSStereotypes.WEB_SERVICE_ENUMERATION) || wsClass
               .hasStereotype(WSStereotypes.WEB_SERVICE_EXCEPTION)) )
            logger.info("model object " + modelClass.getName() + " ignored Stereotypes: " + logStereotypes(modelClass));
      }
      return true;
   }

   private String logStereotypes(ModelClass modelClass) {
      StringBuffer stereoTypes = new StringBuffer();

      for ( Iterator iterator = modelClass.getStereotypes().iterator(); iterator.hasNext(); ) {
         stereoTypes.append(iterator.next().toString());
         stereoTypes.append(";");

      }

      return stereoTypes.toString();
   }

   protected ModelClass createOrFindWsInDTO(ModelClass modelClass) {
      return createOrFindWsDTO(modelClass, WSStereotypes.WEB_SERVICE_OBJECT, "", null);
   }

   protected ModelClass createOrFindWsOutDTO(ModelClass modelClass) {
      return createOrFindWsDTO(modelClass, WSStereotypes.WEB_SERVICE_OBJECT, "", null);
   }

   /**
    * @param modelClass
    * @param stereotype
    *           TODO
    * @param postFix
    * @param excludeFeatureStereotype
    */
   protected ModelClass createOrFindWsDTO(ModelClass modelClass, String stereotype, String postFix,
         String excludeFeatureStereotype) {
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackage();
      WSModel model = (WSModel) modelPackage.getModel();
      ModelClassBase wsClassImpl = createOrFindWsClassImpl(modelClass, postFix, excludeFeatureStereotype,
            WSStereotypes.WEB_SERVICE_DTO, PIMStereotypes.PIM_OBJECT);
      JavaModelClass javaModelClass = (JavaModelClass) modelClass;

      // modelPackage.accept(this);

      // If already an adapter, all work is done
      if ( wsClassImpl instanceof ModelClass ) {
         return (ModelClass) wsClassImpl;
      }

      else {
         logger.info("creating ws dto class for model object " + modelClass.getName());
         ModelClass wsClass = createWsClassAdapter(model, wsClassImpl);

         wsClassImpl.getStereotypes().add(stereotype);
         wsClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_OBJECT);

         // Handle attributes
         for ( Iterator iattr = javaModelClass.getImplementedAttributes().iterator(); iattr.hasNext(); ) {
            ModelAttribute attribute = (ModelAttribute) iattr.next();

            if ( attribute.isDerived() )
               continue;

            if ( excludeFeatureStereotype == null || attribute.hasStereotype(excludeFeatureStereotype) == false ) {
               ModelAttributeImpl wsAttributeImpl = new ModelAttributeImpl(model, wsClassImpl, attribute);

               if ( attribute.isPrimitiveType() == false ) {
                  if ( attribute.getModelClass() == null ) {
                     logger.error(attribute.getQualifiedName());
                  }
                  if ( attribute.getModelClass().hasStereotype(ModelStereotype.ENUMERATION) ) {
                     wsAttributeImpl.setModelClassBase((ModelClassBase) createOrFindWsEnumeration(
                           (ModelClass) attribute.getModelClassBase()).getBase());
                  }
                  else {
                     wsAttributeImpl.setModelClassBase((ModelClassBase) createOrFindWsDTO(
                           (ModelClass) attribute.getModelClassBase(), stereotype, postFix, excludeFeatureStereotype).getBase());
                  }
               }
               wsClassImpl.getAttributes().add(wsAttributeImpl);
            }
         }

         // Handle associations
         for ( Iterator iassoc = javaModelClass.getImplementedAssociations().iterator(); iassoc.hasNext(); ) {
            ModelAssociation association = (ModelAssociation) iassoc.next();

            if ( association.isDerived() )
               continue;

            if ( excludeFeatureStereotype == null || association.hasStereotype(excludeFeatureStereotype) == false ) {
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

               wsTargetClass = createOrFindAssociationTargetClass(postFix, targetClass);

               wsTargetClassBase = (ModelClassBase) wsTargetClass.getBase();
               wsAssociationImpl.setTargetBase(wsTargetClassBase);
               // TODO check if reverse have to be set
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
    * Refactored from createOrFindWsDTO to override it in WSSchemaPSMClassVisitor
    * 
    * @param postFix
    * @param targetClass
    * @return
    */
   protected WSModelClass createOrFindAssociationTargetClass(String postFix, WSModelClass targetClass) {
      return (WSModelClass) createOrFindWsDTO(targetClass, WSStereotypes.WEB_SERVICE_DTO, "", null);
   }

}
