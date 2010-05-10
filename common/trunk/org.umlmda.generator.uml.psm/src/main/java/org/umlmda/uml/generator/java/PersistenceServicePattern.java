/*
 * Created on 08.11.2005
 */
package org.umlmda.uml.generator.java;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.impl.ModelDataTypeImpl;
import org.umlmda.model.uml.impl.ModelMethodImpl;
import org.umlmda.model.uml.impl.ModelParameterAdapter;
import org.umlmda.model.uml.impl.ModelParameterImpl;
import org.umlmda.model.uml.pattern.ModelPattern;
import org.umlmda.profile.ModelStereotype;

/**
 * Pattern replacing the <<PersistenceService>> with a <<BusinessService>> with the same interface.
 * 
 * @author MOROFF
 */
public class PersistenceServicePattern implements ModelPattern
{

   /**
    * @param modelClass
    */
   public PersistenceServicePattern() {
      super();
   }

   public boolean isPatternFor(ModelElement modelElement) {
      return modelElement.hasStereotype(ModelStereotype.PERSISTENCE_SERVICE);
   }

   public boolean isPatternFor(Class modelElementClass) {
      return ModelClass.class.isAssignableFrom(modelElementClass);
   }

   public ModelElement apply(ModelElement modelElement) {
      ModelClass modelClass = (ModelClass) modelElement;

      // Replace stereotype
      modelClass.removeStereotype(ModelStereotype.PERSISTENCE_SERVICE);
      modelClass.getStereotypes().add(ModelStereotype.BUSINESS_SERVICE);

      // Create methods
      addBooleanMethod(modelClass, "isContainerManaged");

      // Add methods for every association
      for ( Iterator ia = modelClass.getAssociations().iterator(); ia.hasNext(); ) {
         ModelAssociation association = (ModelAssociation) ia.next();

         addKeyMethod(modelClass, association, "readByPKey", "Supports");
         addKeyMethod(modelClass, association, "deleteByPKey", "Required");
         addMethod(modelClass, association, "insert", "toInsert");
         addMethod(modelClass, association, "update", "toUpdate");
         addMethod(modelClass, association, "delete", "toDelete");
         addMethod(modelClass, association, "save", "toSave");
      }

      // Remove assocations
      modelClass.getAssociations().clear();
      return modelClass;
   }

   /**
    * @param association
    * @param transactionType
    */
   private static void addKeyMethod(ModelClass modelClass, ModelAssociation association, String name, String transactionType) {
      Model model = modelClass.getModel();
      ModelMethodImpl readImpl = new ModelMethodImpl(model, modelClass);
      ModelClass type = (ModelClass) association.getTarget();

      readImpl.setName(name + StringUtils.capitalize(association.getName()));
      readImpl.setReturnTypeBase((ModelClassifierBase) type.getBase());
      readImpl.getTaggedValues().put("transactionType", transactionType);

      for ( Iterator iter = type.getKeyAttributes().iterator(); iter.hasNext(); ) {
         ModelAttribute attribute = (ModelAttribute) iter.next();
         ModelParameterImpl param = new ModelParameterImpl(model, readImpl);

         param.setName(attribute.getName());
         param.setTypeBase(attribute.getDataTypeBase());
         readImpl.getParameters().add(param);
      }
      modelClass.getMethods().add(model.getModelMethod(readImpl));
   }

   /**
    * @param association
    */
   private static void addMethod(ModelClass modelClass, ModelAssociation association, String name, String parameterName) {
      Model model = modelClass.getModel();
      ModelMethodImpl insert = new ModelMethodImpl(model, modelClass);
      ModelParameterImpl parameter = new ModelParameterImpl(model, insert);

      insert.setName(name + StringUtils.capitalize(association.getName()));
      parameter.setName(parameterName);
      parameter.setTypeBase(association.getTarget());
      insert.getParameters().add(new ModelParameterAdapter(parameter, model));
      modelClass.getMethods().add(model.getModelMethod(insert));
   }

   /**
    * @param association
    */
   private static void addBooleanMethod(ModelClass modelClass, String name) {
      Model model = modelClass.getModel();
      ModelMethodImpl insert = new ModelMethodImpl(model, modelClass);

      insert.setName(name);
      insert.setReturnTypeBase(new ModelDataTypeImpl(model, model, "boolean"));
      modelClass.getMethods().add(model.getModelMethod(insert));
   }

}
