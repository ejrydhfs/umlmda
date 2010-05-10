/**
 * 
 */
package org.umlmda.oaw.generator.model.java;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.profile.ModelStereotype;

/**
 * @author MOROFF
 */
public class JavaModelAdapterFactory extends org.umlmda.uml.generator.java.JavaModelAdapterFactory
{

   /**
    * 
    */
   public JavaModelAdapterFactory() {
   }

   @Override
   public ModelPackage createModelPackage(ModelPackageBase modelPackage, Model destModel) {
      if ( modelPackage.getStereotypes().contains(ModelStereotype.BUSINESS_COMPONENT) ) {
         return new JavaBusinessComponentAdapter(modelPackage, destModel);
      }
      else {
         return new JavaModelPackageAdapter(modelPackage, destModel);

      }
   }

   /**
    * Creates a modelclass depending on the class's stereotype
    * 
    * @see org.umlmda.uml.generator.java.JavaModelAdapterFactory#createModelClass(org.umlmda.model.uml.ModelClassBase,
    *      org.umlmda.model.uml.Model)
    */
   public ModelClass createModelClass(ModelClassBase modelClassBase, Model destModel) {
      if ( modelClassBase.getStereotypes().contains(ModelStereotype.BUSINESS_OBJECT) ) {
         return new JavaBusinessObjectAdapter(modelClassBase, destModel);
      }
      else if ( modelClassBase.getStereotypes().contains(ModelStereotype.BUSINESS_SERVICE) ) {
         return new JavaBusinessServiceAdapter(modelClassBase, destModel);
      }
      else if ( modelClassBase.getStereotypes().contains(ModelStereotype.BUSINESS_EXCEPTION) ) {
         return new JavaBusinessExceptionAdapter(modelClassBase, destModel);
      }
      else if ( modelClassBase.getStereotypes().contains(ModelStereotype.ENUMERATION) ) {
         return new JavaEnumerationAdapter(modelClassBase, destModel);
      }
      else
         return new JavaModelClassAdapter(modelClassBase, destModel);
   }

   @Override
   public ModelAttribute createModelAttribute(ModelAttributeBase modelAttribute, Model destModel) {
      return new JavaModelAttributeAdapter(modelAttribute, destModel);
   }

}
