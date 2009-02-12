/*
 * Created on 29.06.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorClassifier;
import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.impl.ModelMethodAdapter;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DefaultModelMethodAdapter extends ModelMethodAdapter implements GeneratorMethod {

   /**
    * @param modelMethod
    * @param model
    */
   public DefaultModelMethodAdapter(ModelMethodBase modelMethod, Model model) {
      super(modelMethod, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratedName()
    */
   public String getGeneratedName() {
      return getName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorMethod#getGeneratedName(java.lang.String)
    */
   public String getGeneratedName(String artefactName) {
      return getName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorMethod#getGeneratorClass()
    */
   public GeneratorClass getGeneratorClass() {
      return (GeneratorClass) getOwningClass();
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
      return getName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getDocumentation(java.lang.String)
    */
   public String getDocumentation(String context) {
      return getDocumentation();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#setAsCurrentArtefact(java.lang.String)
    */
   public void setAsCurrentArtefact(String artefact) {
      getGeneratorModel().getContext().setCurrentModelElement(this);
      getGeneratorModel().getContext().setCurrentArtefact(getGeneratorModel().getArtefact(artefact, this));
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorMethod#getSignature()
    */
   public String getSignature() {
      StringBuffer signature = new StringBuffer(1024);

      signature.append(((GeneratorClassifier)getReturnType()).getPsmType());
      signature.append(" ");
      //TODO Check for Class or instance scope in feature
      signature.append(getClassScopeSignature());
      signature.append(getGeneratedName());
      signature.append(" (");
      for (Iterator ip = getParameters().iterator(); ip.hasNext();) {
         ModelParameter	parameter = (ModelParameter) ip.next();

         signature.append(((GeneratorClassifier)parameter.getType()).getPsmType());
         signature.append(" ");
         signature.append(parameter.getName());
         
         if ( ip.hasNext() ) {
            signature.append(", ");
         }
      }
      signature.append(")");
      signature.append(getExceptionSignature());      
      return signature.toString();
   }

   /**
    * @param method
    * @return
    */
   protected String getExceptionSignature() {
      String platformExceptions = getPsmExceptions();
      
      if ( getExceptions().size() > 0 || !StringUtils.isEmpty(platformExceptions) ) {
         StringBuffer signature = new StringBuffer(1024);
         
         signature.append(" ");
         signature.append(getExceptionDeclKeyword());
         signature.append(" ");
         if ( !StringUtils.isEmpty(platformExceptions) ) {
            signature.append(platformExceptions);
            if ( getExceptions().isEmpty() == false )
               signature.append(", ");
         }
         for (Iterator iter = getExceptions().iterator(); iter.hasNext();) {
            GeneratorClass exceptionClass = (GeneratorClass) iter.next();
            
            signature.append(exceptionClass.getPsmType());
            if ( iter.hasNext() ) {
               signature.append(", ");
            }
         }
         signature.append(getExceptionEndDeclKeyword());
         return signature.toString();
      }
      else
         return StringUtil.EMPTY;
   }
   
   /**
    * Override to return the plattform specific keyword to finish a methods exception declaration. 
    * This default implementation returns and empty string. 
    * @return
    */
   protected String getExceptionEndDeclKeyword() {
      return StringUtils.EMPTY;
   }

   /**
    * Override to return the plattform specific keyword to start a methods exception declaration. 
    * This default implementation returns <code>throws</code>. 
    */
   protected String getExceptionDeclKeyword() {
      return "throws";
   }

   /**
    * TODO
    * @return
    */
   private String getPsmExceptions() {
      return StringUtils.EMPTY;
   }

   /**
    * @return
    */
   protected String getClassScopeSignature() {
      return StringUtils.EMPTY;
   }

   
   public String getCallSignature() {
      return getCallSignature("");
   }
   
   public String getCallSignature(String parameterPrefix) {
      return getCallSignature(this, parameterPrefix);
   }
   
   public static String getCallSignature(ModelMethod method, String parameterPrefix) {
      StringBuffer buffer = new StringBuffer();
      
      buffer.append(method.getName());
      buffer.append("(");
      for (Iterator ip = method.getParameters().iterator(); ip.hasNext();) {
         ModelParameter parameter = (ModelParameter) ip.next();
         
         buffer.append(parameterPrefix);
         buffer.append(parameter.getName());
         if ( ip.hasNext() ) {
            buffer.append(", ");
         }
      }
      buffer.append(")");
      return buffer.toString();
   }

}
