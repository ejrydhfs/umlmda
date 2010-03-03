/**
 * 
 */
package org.umlmda.oaw.generator.model.webservice;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.webservices.WSStereotypes;

/**
 * @author MOROFF
 *
 */
public class WSModelAdapterFactory extends org.umlmda.uml.generator.webservices.WSModelAdapterFactory {

   /**
    * 
    */
   public WSModelAdapterFactory() {
   }

   @Override
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model destModel) {
      if ( modelPackage.getStereotypes().contains(ModelStereotype.BUSINESS_COMPONENT)) {
         return new WSBusinessComponentAdapter(modelPackage, destModel);
      }
      else {
         return new WSModelPackageAdapter(modelPackage, destModel);
         
      }
   }

   /**
    * Creates a modelclass depending on the class's stereotype
    * @see org.umlmda.uml.generator.java.JavaModelAdapterFactory#createModelClass(org.umlmda.model.uml.ModelClassBase, org.umlmda.model.uml.Model)
    */
   public ModelClass createModelClass(ModelClassBase modelClassBase, Model destModel) {
      if ( modelClassBase.getStereotypes().contains(ModelStereotype.BUSINESS_OBJECT)
        || modelClassBase.getStereotypes().contains(WSStereotypes.WEB_SERVICE_DTO)
        || modelClassBase.getStereotypes().contains(WSStereotypes.WEB_SERVICE_DTO_HIERARCHY)) {
         return new WSBusinessObjectAdapter(modelClassBase, destModel);
      }
      else if ( modelClassBase.getStereotypes().contains(ModelStereotype.BUSINESS_SERVICE) 
             || modelClassBase.getStereotypes().contains(WSStereotypes.WEB_SERVICE)) {
         return new WSBusinessServiceAdapter(modelClassBase, destModel);
      }
      else if ( modelClassBase.getStereotypes().contains(ModelStereotype.BUSINESS_EXCEPTION)
             || modelClassBase.getStereotypes().contains(WSStereotypes.WEB_SERVICE_EXCEPTION)) {
         return new WSBusinessExceptionAdapter(modelClassBase, destModel);
      }
      else if ( modelClassBase.getStereotypes().contains(ModelStereotype.ENUMERATION)
             || modelClassBase.getStereotypes().contains(WSStereotypes.WEB_SERVICE_ENUMERATION)) {
         return new WSEnumerationAdapter(modelClassBase, destModel);
      }
      else {   
         return new WSModelClassAdapter(modelClassBase, destModel);
      }
   }

   @Override
   public ModelAttribute createModelAttribute(ModelAttributeBase modelAttribute, Model destModel) {
      return new WSModelAttributeAdapter(modelAttribute, destModel);
   }

   
}
