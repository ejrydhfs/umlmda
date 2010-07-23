/*
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on 21.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.java;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.logging.LoggingWriter;
import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.util.CodeEmitter;
import org.umlmda.generator.model.util.GeneratorUtils;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelMethodBase;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.impl.ModelMethodAdapter;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.DefaultModelMethodAdapter;

/**
 * @author MOROFF
 */
public class JavaModelMethodAdapter extends ModelMethodAdapter implements JavaModelMethod
{
   private final JavaImportHelper       importHelper = new JavaImportHelperImpl(this);
   private final JavaModelElementHelper delegate;

   /**
    * @param modelMethod
    * @param model
    */
   public JavaModelMethodAdapter(ModelMethodBase modelMethod, Model model) {
      super(modelMethod, model);
      delegate = new JavaModelElementHelper(this);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   public ModelClassifier getReturnType() {
      if ( hasStereotype(ModelStereotype.ASYNC_CALL) ) {
         return null;
      }
      else {
         return super.getReturnType();
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#resetImports()
    */
   public void resetImports() {
      importHelper.resetImports();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#registerImport(java.lang.String)
    */
   public void registerImport(String artefactName) {
      importHelper.registerImport(artefactName);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#registerImport(java.lang.String)
    */
   public void registerImport(String artefactName, JavaModelClass genClass) {
      importHelper.registerImport(artefactName, genClass);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#getScopedName(java.lang.String, org.umlmda.model.uml.ModelClassifier)
    */
   public String getScopedName(String artefactName, JavaModelClass genClass) {
      return importHelper.getScopedName(artefactName, genClass);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#registeredImports()
    */
   public String registeredImports() {
      return importHelper.registeredImports();
   }

   /**
    * Returns the generated name of the current class and current generated artefact
    * 
    * @return
    */
   public String getGeneratedName() {
      return getGeneratedName(getGeneratorModel().getContext().getCurrentArtefact().getName());
   }

   /**
    * Returns the generated name of the current class and the given artefact
    * 
    * @param string
    * @return
    */
   public String getGeneratedName(String artefactType) {
      return GeneratorUtils.getGeneratedName(this, artefactType);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorMethod#getGeneratorClass()
    */
   public GeneratorClass getGeneratorClass() {
      return (GeneratorClass) getOwningClass();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#getSyncMethod()
    */
   public JavaModelMethod getSyncMethod() {
      return getSyncMethod(this);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#getSyncMethod()
    */
   public static JavaModelMethod getSyncMethod(ModelMethod modelMethod) {
      JavaModelMethod syncMethod = null;
      JavaModelClass parameterClass = (JavaModelClass) ((ModelParameter) modelMethod.getParameters().get(0)).getType();

      for ( Iterator im = modelMethod.getOwningClass().getMethods().iterator(); syncMethod == null && im.hasNext(); ) {
         ModelMethod method = (ModelMethod) im.next();

         if ( modelMethod.getName().startsWith(method.getName()) ) {
            JavaModelClass methodParameterClass = (JavaModelClass) ((ModelParameter) method.getParameters().get(0)).getType();

            if ( methodParameterClass == parameterClass ) {
               syncMethod = (JavaModelMethod) method;
            }
         }
      }
      return syncMethod;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getReplacementName()
    */
   public String getReplacementName() {
      return getOwningClass().getName() + "." + StringUtils.capitalize(getName());
   }

   public String getDocumentation(String context) {
      return delegate.getDocumentation(context);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#traceEntry(int)
    */
   public String traceEntry(int identLevel) {
      String code = "";
      LoggingWriter logging = getGeneratorModel().getLoggingWriter();
      CodeEmitter emitter = getEmitter(identLevel);

      if ( emitter != null ) {
         emitter.addLine(logging.traceMethodEntry(this));
         logParameters(LoggingWriter.TRACE, emitter);
         code = emitter.toString();
      }
      return code;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#logParameters(int, int)
    */
   public String logParameters(int level, int identLevel) {
      String code = "";
      GeneratorModel model = getGeneratorModel();
      LoggingWriter logging = model.getLoggingWriter();

      if ( logging.isLoggingSupported() ) {
         CodeEmitter emitter = model.createEmitter();

         emitter.setIdentBase(identLevel);
         code = logParameters(level, emitter);
      }
      return code;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#logParameters(int, int)
    */
   public String logParameters(int level, CodeEmitter emitter) {
      String code = "";

      if ( getParameters().size() > 0 ) {
         GeneratorModel model = getGeneratorModel();
         LoggingWriter logging = model.getLoggingWriter();

         emitter.addLine(logging.getIfIsLogEnabled(level));
         emitter.addLine(1, "org.umlmda.runtime.xml.XMLMarshalContext context = ");
         emitter.addLine(2, "new org.umlmda.runtime.xml.XMLMarshalContext();");
         emitter.addLine(1, "");
         emitter.addLine(1, "context.startElement(\"" + getOwningClass().getName() + "\");");
         emitter.addLine(1, "context.startElement(\"" + getName() + "\");");
         for ( Iterator ip = getParameters().iterator(); ip.hasNext(); ) {
            ModelParameter parameter = (ModelParameter) ip.next();
            String name = parameter.getName();
            ModelClassifier classifier = parameter.getType();

            if ( classifier instanceof ModelClass ) {
               emitter.addLine(1, "if ( " + name + " instanceof org.umlmda.runtime.xml.XMLSerializable )");
               emitter.addLine(2, "((org.umlmda.runtime.xml.XMLSerializable)" + name + ").marshal(\"" + name
                     + "\", context, false);");
            }
            else {
               emitter.addLine(1, "context.simpleElement(\"" + name + "\", " + name + ");");
            }
         }
         emitter.addLine(1, "context.endElement(\"" + getName() + "\");");
         emitter.addLine(1, "context.endElement(\"" + getOwningClass().getName() + "\");");
         emitter.addLine(1, logging.log(level, "context.toString()"));
         emitter.addLine("}");

         code = emitter.toString();
      }
      return code;
   }

   private CodeEmitter getEmitter(int identLevel) {
      GeneratorModel model = getGeneratorModel();
      LoggingWriter logging = model.getLoggingWriter();
      CodeEmitter emitter = null;

      if ( logging.isLoggingSupported() ) {
         emitter = model.createEmitter();
         emitter.setIdentBase(identLevel);
      }

      return emitter;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelMethod#getSignature()
    */
   public String getSignature() {
      // throw new RuntimeException("To be implemented"); //TODO refactory methodHelper
      JavaClassHelper classHelper = new JavaClassHelper();
      JavaMethodHelper methodHelper = new JavaMethodHelper(classHelper);

      classHelper.setModelClass((ModelClass) getOwningClass());
      return methodHelper.getMethodSignature(this);
   }

   /**
    * @return
    */
   public String getJavaType() {
      JavaModelClassifier classifier = (JavaModelClassifier) getReturnType();

      if ( classifier != null ) {
         return classifier.getJavaType();
      }
      else {
         return "void";
      }
   }

   public void setAsCurrentArtefact(String artefact) {
      getGeneratorModel().getContext().setCurrentModelElement(this);
      getGeneratorModel().getContext().setCurrentArtefact(getGeneratorModel().getArtefact(artefact, this));
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorMethod#getCallSignature()
    */
   public String getCallSignature() {
      return getCallSignature("");
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorMethod#getCallSignature(java.lang.String)
    */
   public String getCallSignature(String parameterPrefix) {
      return DefaultModelMethodAdapter.getCallSignature(this, parameterPrefix);
   }

   public String getUpperCaseIdentifier() {
      return StringUtil.toUpperCaseIdentifier(getName());
   }

}
