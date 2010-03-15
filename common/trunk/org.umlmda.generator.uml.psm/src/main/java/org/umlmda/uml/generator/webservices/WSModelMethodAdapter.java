/*
 * Created on 04.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.uml.generator.PIMStereotypes;
import org.umlmda.uml.generator.java.JavaModelAttribute;
import org.umlmda.uml.generator.java.JavaModelClass;
import org.umlmda.uml.generator.java.JavaModelMethod;
import org.umlmda.uml.generator.java.JavaModelMethodAdapter;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class WSModelMethodAdapter extends JavaModelMethodAdapter implements WSModelMethod {

   /**
    * @param modelMethod
    * @param model
    */
   public WSModelMethodAdapter(ModelMethodBase modelMethod, Model model) {
      super(modelMethod, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelMethod#getReponseClass()
    */
   public String getReponseClass() {
      WSModelClass genClass = (WSModelClass) getGeneratorModel().getContext().getCurrentModelElement();
      
      if ( getReturnType().hasStereotype(WSStereotypes.WEB_SERVICE_RESPONSE)) {
         return genClass.getScopedName(WSArtefacts.WS_STUB, (GeneratorClass)getReturnType());
      }
      
      throw new RuntimeException("method has no wrapping response");
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getConvertToWs(java.lang.String)
    */
   public String getConvertToWs() {
      return getConvert("WebserviceUtils.convertToWs");
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getConvertToWs(java.lang.String)
    */
   public String getConvertFromWs() {
      WSModelClassifier returnType = ((WSModel)getGeneratorModel()).isSoapWrapping() ? getWrappedReturnType() : (WSModelClassifier) getReturnType();
      
      return getConvert(WSModelAttributeAdapter.getConvertFromWsMethod(returnType));
   }

   private String getConvert(String convertFunction) {
      String returnGetter;
      WSModelClassifier returnType;
      
      if ( ((WSModel)getGeneratorModel()).isSoapWrapping() ) {
         returnGetter = getWrappedReturnValueGetter();
         returnType = getWrappedReturnType();
      }
      else {
         returnGetter = getReturnGetter();
         returnType = (WSModelClassifier) getReturnType();
      }
      

      if ( returnType.getJavaType().equals(returnType.getWSJavaType()) == false && returnType instanceof WSModelDataType ) {
         return WSModelAttributeAdapter.getConvertSignature(convertFunction, (WSModelDataType)returnType, "response."+returnGetter);
         //return convertFunction+"(response."+returnGetter+"())";
      }
      else
         return "response."+returnGetter+"()";
   }
   
   public String getReturnGetter() {
      if ( getReturnType().getName().equals(ModelDataType.BOOLEAN) ) {
         return "isReturnValue()";
      }
      else {
         return "getReturnValue()";
      }
   }
   public boolean isConvertionNeeded() {
      return getJavaType().equals(super.getJavaType()) == false;
   }
   
   /**
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getJavaType()
    */
   public String getJavaType() {
      ModelClassifier classifier = getReturnType();
      
      if ( classifier instanceof WSModelDataType ) {
         WSModelDataType dataType = (WSModelDataType) classifier;
         
         return dataType.getJavaType();
      }
      else {
         return super.getJavaType();
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelMethod#getWebServiceSignature()
    */
   public String getWebServiceSignature() {
      WSModelClass genClass = (WSModelClass) getOwningClass();
      WSModel genModel = (WSModel) genClass.getGeneratorModel();
      boolean soapWrapping = genModel.isSoapWrapping();
      String returnSignature = getWebServiceType();
      String parameterSignature = getWebServiceParameter();
      String exceptionSignature = getWebServiceExceptions();
      
      return returnSignature + " " + getName() + "(" + parameterSignature + ")" + exceptionSignature;
   }

   /**
    * @return
    */
   public String getWebServiceExceptions() {
      String exceptionSignature = null;
      StringBuffer buffer = new StringBuffer();
      WSModelClass genClass = (WSModelClass) getGeneratorModel().getContext().getCurrentModelElement();
      
      // FIXME Parameter for JaxWS handling
      if ( getExceptions().size() > 0 )
      buffer.append(" throws ");
      for (Iterator ie = getExceptions().iterator(); ie.hasNext();) {
         WSModelClass exceptionClass = (WSModelClass) ie.next();
         WSModelPackage exceptionPackage = (WSModelPackage) exceptionClass.getPackage();
         
         buffer.append(exceptionPackage.getQualifiedPackageName(WSArtefacts.WS_STUB)+".");
         buffer.append(StringUtils.capitalize(getName()));
         buffer.append(exceptionClass.getGeneratedName(WSArtefacts.WS_STUB));
         if ( ie.hasNext() )
            buffer.append(", ");
      }
      
      return buffer.toString();
   }

   /**
    * @param soapWrapping
    * @return
    */
   private String getWebServiceParameter() {
      StringBuffer buffer = new StringBuffer();
      String parameterSignature = null;
      WSModelClass genClass = (WSModelClass) getGeneratorModel().getContext().getCurrentModelElement();
      WSModel genModel = (WSModel) genClass.getGeneratorModel();
      
      if ( genModel.isSoapWrapping() ) {

         buffer.append("@WebParam(name = \"request\", partName = \"request\")");
         buffer.append(getRequestClass() + " request");
      }
      else {
         for (Iterator ip = getParameters().iterator(); ip.hasNext();) {
            WSModelParameter parameter = (WSModelParameter) ip.next();
            
            buffer.append("@WebParam(name = \""+parameter.getName()+"\", partName = \""+parameter.getName()+"\")");
            buffer.append(parameter.getJavaType());
            buffer.append(" ");
            buffer.append(parameter.getName());
            if ( ip.hasNext() ) {
               buffer.append(", ");
            }
         }
      }
      parameterSignature = buffer.toString();
      
      return parameterSignature;
   }

   /**
    * @param genClass
    * @param soapWrapping
    */
   public String getWebServiceType() {
      WSModelClass genClass = (WSModelClass) getGeneratorModel().getContext().getCurrentModelElement();
      WSModel genModel = (WSModel) genClass.getGeneratorModel();
      String returnSignature = null;
      
      if ( genModel.isSoapWrapping() ) {
         returnSignature = getReponseClass();
      }
      else if ( getReturnType() instanceof WSModelClass ) {
         WSModelClass returnClass = (WSModelClass) getReturnType();
         
         returnSignature = genClass.getScopedName(WSArtefacts.WS_STUB, returnClass);
      }
      else if ( getReturnType() instanceof WSModelDataType ){
         WSModelDataType returnType = (WSModelDataType) getReturnType();
         
         returnSignature = returnType.getJavaType();
      }
      else if ( getReturnType() == null ) {
         returnSignature = "void";
      }
      
      return returnSignature;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelMethod#getPIMMethod()
    */
   public JavaModelMethod getPIMMethod() {
      if (  hasStereotype(WSStereotypes.WEB_SERVICE_METHOD) ) {
         for (Iterator id = getDependencies().iterator(); id.hasNext();) {
            ModelDependency dependency = (ModelDependency) id.next();
            
            if ( dependency.hasStereotype(PIMStereotypes.PIM_METHOD) ) {
               return (JavaModelMethod) dependency.getClients().iterator().next();
            }
         }
         
         throw new RuntimeException("Model is not constistence");
      }
      else {
         return this;
      }
   }
   
   public String getRequestClass() {
      WSModelClass genClass = (WSModelClass) getGeneratorModel().getContext().getCurrentModelElement();
      
      if ( getParameters().size() == 1 ) {
         WSModelParameter parameter = (WSModelParameter) getParameters().get(0);
         
         if ( parameter.getType().hasStereotype(WSStereotypes.WEB_SERVICE_REQUEST)) {
            return genClass.getScopedName(WSArtefacts.WS_STUB, (GeneratorClass)parameter.getType());
         }
      }
      
      throw new RuntimeException("method has no wrapping request");
   }
   
   public String getRequestSignature() {
      StringBuffer buffer = new StringBuffer();
      WSModelClass wsRequestClass = (WSModelClass) ((WSModelParameter)getParameters().get(0)).getType();
      
      for (Iterator ia = wsRequestClass.getAttributes().iterator(); ia.hasNext();) {
         WSModelAttribute parameterAttribute = (WSModelAttribute) ia.next();
         
         if ( parameterAttribute.getModelClassifier() instanceof ModelDataType ) {
            WSModelDataType wsDataType = (WSModelDataType) parameterAttribute.getModelClassifier();
            
            if ( wsDataType.isConvertionRequired() ) {
               buffer.append(getConvertToWs());
               buffer.append("(");
            }
            buffer.append(parameterAttribute.getName());
            if ( wsDataType.isConvertionRequired() ) 
               buffer.append(")");
         }
         else {
            WSModelClass wsParamClass = (WSModelClass) parameterAttribute.getModelClassifier();
            JavaModelClass pimParamClass = wsParamClass.getPIMClass();
            
            buffer.append("utils.create");
            buffer.append(wsParamClass.getName());
            buffer.append("(");
            buffer.append(parameterAttribute.getName());
            buffer.append(")");
         }
         if ( ia.hasNext() ) {
            buffer.append(", ");
         }
      }
      return buffer.toString();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelMethod#getWrappedReturnType()
    */
   public WSModelClassifier getWrappedReturnType() {
      if ( getReturnType().hasStereotype(WSStereotypes.WEB_SERVICE_RESPONSE)) {
         WSModelClass wsReturnClass = (WSModelClass) getReturnType();
         
         if ( wsReturnClass.getAttributes().size() == 0 ) {
            return null;
         }
         else if ( wsReturnClass.getAttributes().size() == 1 ) {
            return (WSModelClassifier) ((ModelAttribute)wsReturnClass.getAttributes().get(0)).getModelClassifier();
         }
      }
      
      throw new RuntimeException("method has no wrapped response");
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelMethod#getWrappedReturnValueGetter()
    */
   public String getWrappedReturnValueGetter() {
      if ( getReturnType().hasStereotype(WSStereotypes.WEB_SERVICE_RESPONSE)) {
         WSModelClass wsReturnClass = (WSModelClass) getReturnType();
         
         if ( wsReturnClass.getAttributes().size() == 1 ) {
            return ((JavaModelAttribute)wsReturnClass.getAttributes().get(0)).getGetter();
         }
      }
      
      throw new RuntimeException("method has no wrapped response");
   }
}
