/*
 * Created on 28.11.2005
 */
package org.umlmda.uml.generator.java;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.impl.ModelAttributeAdapter;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.util.ArtefactUtils;

/**
 * @author MOROFF
 */
public class JavaModelAttributeAdapter extends ModelAttributeAdapter implements JavaModelAttribute
{
   private final JavaModelElementHelper delegate;

   /**
    * @param modelAttribute
    * @param model
    */
   public JavaModelAttributeAdapter(ModelAttributeBase modelAttribute, Model model) {
      super(modelAttribute, model);
      delegate = new JavaModelElementHelper(this);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getReplacementName()
    */
   public String getReplacementName() {
      return getOwningClass().getName() + "." + getName();
   }

   public String getDocumentation(String context) {
      return delegate.getDocumentation(context);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratedName()
    */
   public String getGeneratedName() {
      return getName();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getGetter()
    */
   public String getGetter() {
      if ( isMultivalue() == false && isOptional() == false && getDataType() != null
            && ModelDataType.BOOLEAN.equals(getDataType().getName()) ) {
         return "is" + StringUtils.capitalize(getName());
      }
      else {
         return "get" + StringUtils.capitalize(getName());
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getSetter()
    */
   public String getSetter() {
      return "set" + StringUtils.capitalize(getName());
   }

   /*
    * (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getType()
    */
   public String getType() {
      return getType(JavaArtefacts.BUSINESS_OBJECT_INTERFACE);
   }

   public String getType(String artefact) {
      return getType(artefact, (ModelDataType.TypeMappingStrategy) null);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelAttribute#getJavaType()
    */
   public String getJavaType() {
      return getType(JavaArtefacts.BUSINESS_OBJECT_INTERFACE, (ModelDataType.TypeMappingStrategy) null);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getType(java.lang.String)
    */
   protected String getType(String artefact, ModelDataType.TypeMappingStrategy typeMappingStrategy) {
      JavaModelClassifier classifier = (JavaModelClassifier) getModelClassifier();
      String type;

      if ( classifier instanceof ModelDataType ) {
         JavaModelDataType javaDataType = (JavaModelDataType) classifier;

         if ( typeMappingStrategy == null ) {
            typeMappingStrategy = javaDataType.getJavaTypeMappingStrategy();
         }
         type = typeMappingStrategy.getPSMType(javaDataType, isOptional(), isMultivalue());
         return type;
      }
      else {
         JavaModelClass attrClass = (JavaModelClass) classifier;

         return attrClass.getJavaType();
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isPrimitiveType()
    */
   public boolean isJavaPrimitiveType() {
      if ( isOptional() || isMultivalue() ) {
         return false;
      }
      else if ( getDataType() == null ) {
         return false;
      }
      else {
         return ((JavaModelDataType) getDataType()).isJavaPrimitiveType();
      }
   }

   public void setAsCurrentArtefact(String artefact) {
      if ( getGeneratorModel().getContext() != null ) {
         getGeneratorModel().getContext().setCurrentModelElement(this);
         getGeneratorModel().getContext().setCurrentArtefact(getGeneratorModel().getArtefact(artefact, this));
      }
   }

   public boolean isBound() {
      return isBound(this);
   }

   static boolean isBound(JavaModelStructuraleFeature feature) {
      GeneratorModel genModel = feature.getGeneratorModel();
      boolean propertyChangeSupport = Boolean.valueOf(
            genModel.getArtefact().getProperties().getProperty("PropertyChangeSupport", "false")).booleanValue();

      if ( propertyChangeSupport )
         return true;
      else
         return feature.hasStereotype(ModelStereotype.BOUND);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelAttribute#getBoundModelMethod()
    */
   public ModelMethod getPostSetMethod() {
      return getPostSetMethodStatic(this);
   }

   static ModelMethod getPostSetMethodStatic(JavaModelStructuraleFeature feature) {
      JavaModelClass owner = feature.getOwningJavaClass();
      String postSetMethod = "post" + StringUtil.firstToUpperCase(feature.getName()) + "Set";

      for ( Iterator im = owner.getMethods().iterator(); im.hasNext(); ) {
         ModelMethod method = (ModelMethod) im.next();

         if ( method.getName().equals(postSetMethod) ) {
            return method;
         }
      }
      return null;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getOwningJavaClass()
    */
   public JavaModelClass getOwningJavaClass() {
      return (JavaModelClass) getOwner();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorAttribute#getFeatureConstant()
    */
   public String getFeatureIdentifier() {
      return getUpperCaseIdentifier();
   }

   public String getUpperCaseIdentifier() {
      return StringUtil.toUpperCaseIdentifier(getName());
   }

}
