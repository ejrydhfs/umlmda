/*
 * Created on 28.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.impl.ModelAssociationAdapter;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JavaModelAssociationAdapter extends ModelAssociationAdapter implements JavaModelAssociation {
   private final JavaModelElementHelper delegate;
   private final boolean genericSupport;
   
   /**
    * @param modelAssociation
    * @param model
    */
   public JavaModelAssociationAdapter(ModelAssociationBase modelAssociation, Model model) {
      super(modelAssociation, model);
      delegate = new JavaModelElementHelper(this);
      genericSupport = Boolean.parseBoolean(((GeneratorModel)model).getProperties().getProperty("genericSupport", "true"));
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getReplacementName()
    */
   public String getReplacementName() {
      return getOwningClassBase().getName()+"."+getName();
   }

   public String getDocumentation(String context) {
      return delegate.getDocumentation(context);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratedName()
    */
   public String getGeneratedName() {
      return getName();
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getGetter()
    */
   public String getGetter() {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append("get");
      buffer.append(StringUtils.capitalize(getName()));
      return buffer.toString();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getSetter()
    */
   public String getSetter() {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append("set");
      buffer.append(StringUtils.capitalize(getName()));
      return buffer.toString();
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getType()
    */
   public String getType() {
      return getType(JavaArtefacts.BUSINESS_OBJECT_INTERFACE);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelAttribute#getType()
    */
   public String getType(String artefact) {
      if ( isMultiple() ) {
         if ( genericSupport ) {
            return Collection.class.getName() + "<" + getTargetType(artefact) + ">";
         }
         else {
            return Collection.class.getName();
         }
      }
      else {
         return getTargetType(artefact);
      }
   }

   public String getTargetType(String artefact) {
      String type;
      GeneratorModelElement element = getGeneratorModel().getContext().getCurrentModelElement();
      
      if ( element instanceof GeneratorClass ) {
         GeneratorClass genClass = (GeneratorClass) element;
         
         type = genClass.getScopedName(artefact, (JavaModelClass)getTarget());
      }
      else {
         type = ((JavaModelClass)getTarget()).getScopedName(artefact);
      }

      return type;
   }

   public void setAsCurrentArtefact(String artefact) {
      getGeneratorModel().getContext().setCurrentModelElement(this);
      getGeneratorModel().getContext().setCurrentArtefact(getGeneratorModel().getArtefact(artefact, this));
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelAssociation#getInterfaceType()
    */
   public String getInterfaceType() {
      String targetType = ((JavaModelClass)getTarget()).getJavaType();

      if ( isMultiple() ) {
         if (genericSupport) {
            if (isUnique()) {
               return Set.class.getName() + "<" + targetType + ">";
            }
            else if (isOrdered()) {
               return List.class.getName() + "<" + targetType + ">";
            }
            else {
               return Collection.class.getName() + "<" + targetType + ">";
            }
         }
         else {
            if (isUnique()) {
               return Set.class.getName();
            }
            else if (isOrdered()) {
               return List.class.getName();
            }
            else {
               return Collection.class.getName();
            }
            
         }
      }
      else {
         return targetType;
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelAssociation#getImplementationType()
    */
   public String getImplementationType() {
      JavaModelClass target = (JavaModelClass) getTarget();
      String targetType = target.getScopedName(JavaArtefacts.BUSINESS_OBJECT);
      
      if ( isMultiple() ) {
         if (genericSupport) {
            String targetInterfaceType = target.getScopedName(JavaArtefacts.BUSINESS_OBJECT_INTERFACE);

            if (isUnique() && !isOrdered()) {
               return HashSet.class.getName() + "<" + targetInterfaceType + ">";
            }
            else if (isUnique() && isOrdered()) {
               return LinkedHashSet.class.getName() + "<" + targetInterfaceType + ">";
            }
            else {
               return ArrayList.class.getName() + "<" + targetInterfaceType + ">";
            }
         }
         else {
            if (isUnique() && !isOrdered()) {
               return HashSet.class.getName();
            }
            else if (isUnique() && isOrdered()) {
               return LinkedHashSet.class.getName();
            }
            else {
               return ArrayList.class.getName();
            }
         }
      }
      else {
         return targetType;
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getPostSetMethod()
    */
   public ModelMethod getPostSetMethod() {
      return JavaModelAttributeAdapter.getPostSetMethodStatic(this);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#isBound()
    */
   public boolean isBound() {
      return JavaModelAttributeAdapter.isBound(this);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelStructuraleFeature#getOwningJavaClass()
    */
   public JavaModelClass getOwningJavaClass() {
      return (JavaModelClass) getOwner();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorStructuralFeature#getFeatureConstant()
    */
   public String getFeatureIdentifier() {
      return getUpperCaseIdentifier();
   }
   
   public String getUpperCaseIdentifier() {
      return StringUtil.toUpperCaseIdentifier(getName());
   }
}
