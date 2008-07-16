/*
 *  $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractModelElementWriter.java,v 1.9.2.1 2008/01/21 14:57:27 moroff Exp $
 *  Copyright (C) 2003, 2004 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://umlmda.sf.net)
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
 *  Created on Dec 15, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.uml.GeneratorPackage;
import org.umlmda.generator.model.util.GeneratorUtils;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.NamespaceUsage;
import org.umlmda.generator.profile.Property;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.profile.ModelTaggedValues;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractModelElementWriter extends AbstractParentWriter {

   private IClassHelper classHelper = null;
   private IMethodHelper methodHelper = null;
   private GeneratorModelElement modelElement = null;
   private Properties properties = null;
   
   protected AbstractModelElementWriter(IClassHelper classHelper, IMethodHelper methodHelper) {
      setClassHelper(classHelper);
      setMethodHelper(methodHelper);
   }
   
   /**
    * Must be overwritten to specify the package containing the model element
    * or the model element itself if it is an package.
    * @return
    */
   public abstract GeneratorPackage getGenPackage();

   /**
    * Returns the qualified name of the given class. If the class is in the
    * same package the classname without package postfix will be returned.
    * If the class is in another package, the name with the ful qualified
    * package name is returned.
    */
   public final String getType(ModelClassifier modelClassifier) {
      return classHelper.getType(modelClassifier);
   }

   /**
    * @param type
    * @return
    */
   public final String getType(ModelDataType type) {
      return classHelper.getType(type);
   }

   public final String getType(ModelAttribute attribute) {
      return classHelper.getType(attribute);
   }

   public final String getMethodSignature(ModelMethod method) {
      return methodHelper.getMethodSignature(method);
   }

   public String getCallDelegateSignature(String delegateName, ModelMethod method) {
      return getCallDelegateSignature(delegateName, "", true, method); 
   }

   public String getCallDelegateSignature(String delegateName, ModelMethod method, boolean withReturn) {
      return getCallDelegateSignature(delegateName, "", withReturn, method); 
   }

   public String getCallDelegateSignature(String delegateName, String parameterPrefix, boolean withReturn, ModelMethod method) {
      StringBuffer signature = new StringBuffer();
      
      if ( withReturn && method.getReturnType() != null && method.getReturnType().getQualifiedName().equals("void") == false) {
         signature.append("return ");
      }
      signature.append(delegateName);
      signature.append(".");
      signature.append(method.getName());
      signature.append("(");
      for (Iterator iter = method.getParameters().iterator(); iter.hasNext();) {
         ModelParameter parameter = (ModelParameter) iter.next();
         
         signature.append(parameterPrefix);
         signature.append(parameter.getName());
         if ( iter.hasNext())
            signature.append(", ");
      }
      signature.append(");");
      return signature.toString();
   }
   /**
    * @return
    */
   public IMethodHelper getMethodHelper() {
      return methodHelper;
   }

   /**
    * @param helper
    */
   public void setMethodHelper(IMethodHelper helper) {
      methodHelper = helper;
      if ( classHelper != null ) {
         methodHelper.setClassHelper(classHelper);
      }
   }

   /**
    * @return
    */
   public IClassHelper getClassHelper() {
      return classHelper;
   }

   /**
    * @param helper
    */
   public void setClassHelper(IClassHelper helper) {
      classHelper = helper;
      if ( methodHelper != null )
         methodHelper.setClassHelper(helper);
   }

   /** 
    * @deprecated Used ModelClass.getOwnedKeyAttributes(boolean)
    */
   public List getKeyAttributes(ModelClass clazz) {
      return clazz.getKeyAttributes();
   }

   /**
    * @deprecated Used ModelClass.getOwnedKeyAttributes(boolean)
    */
   public List getOwnedKeyAttributes(ModelClass clazz, boolean includeSuperClasses) {
      return clazz.getOwnedKeyAttributes(includeSuperClasses);
   }

   
   public ModelClass getParent(ModelClass clazz) {
      return clazz.getParent();
   }

   public boolean isInheritPKeyFromParent(ModelClass clazz) {
      ModelAssociation parentComposition = clazz.getParentComposition();
      
      if ( parentComposition != null ) {
         return Boolean.valueOf(parentComposition.getTaggedValues().getProperty(ModelTaggedValues.DB_PKEY_INHERIT, "false")).booleanValue();
      }
      else {
         return false;
      }
   }

   /**
    * @deprecated Use from generator model
    */
   public static String getter(ModelAttribute attribute) {
      return "get"+StringUtil.firstToUpperCase(attribute.getName());
   }

   /**
    * @deprecated Use from generator model
    */
   public static String setter(ModelAttribute attribute) {
      return "set"+StringUtil.firstToUpperCase(attribute.getName());
   }

   /**
    * @deprecated Use from generator model
    */
   public static String getter(ModelAssociation association) {
      return "get"+StringUtil.firstToUpperCase(association.getName());
   }

   /**
    * @deprecated Use from generator model
    */
   public static String setter(ModelAssociation association) {
      return "set"+StringUtil.firstToUpperCase(association.getName());
   }

   
   /**
    * determine if this writer will produce any output
    * @param modelElementList a list of model elements the writer should process
    * @param modelStereotype a model stereotype for which the writer generates output
    * @return true if any of the model elements has the given stereotype
    */
   public boolean generateOutput( List modelElementList, String modelStereotype) {
   	boolean generateOutput = false;
   
   	for (Iterator ime = modelElementList.iterator(); ime.hasNext();) {
   		ModelElement modelElement = (ModelElement) ime.next();
   		if ( modelElement.hasStereotype(modelStereotype) )
   			generateOutput = true;
   	}
   	return generateOutput;
   }

   /**
    * Packagename for the generated package
    * @see org.umlmda.generator.AbstractClassWriter#getPackageName()
    */
   public String getPackageName() {
      String artefact = getGenPackage().getGeneratorModel().getContext().getCurrentArtefact().getName();
      String qualifiedName = getGenPackage().getQualifiedPackageName(artefact);

      return qualifiedName;
   }
      
   protected final void appendPackageFolder(StringBuffer buffer) {
      Artefact artefact = getGenPackage().getGeneratorModel().getContext().getCurrentArtefact();
      
      if ( artefact.getUseNamespace() == NamespaceUsage.FULL_QUALIFIED_LITERAL 
        || artefact.getUseNamespace() == NamespaceUsage.TRUE_LITERAL ) {
         StringTokenizer parsePackage = new StringTokenizer(getPackageName(), ".");
         while ( parsePackage.hasMoreTokens() ) {
            buffer.append(File.separator);
            buffer.append(parsePackage.nextToken()); 
         }
      }
      else if ( artefact.getUseNamespace() == NamespaceUsage.NAME_ONLY_LITERAL ) {
         buffer.append(File.separator);
         
         String genName = GeneratorUtils.getGeneratedName(getGenPackage(), artefact.getName());
         buffer.append(genName.replace('/', File.separatorChar));
      }
      else if ( artefact.getUseNamespace() == NamespaceUsage.FALSE_LITERAL ) {
         // Do nothing
      }
      else {
         throw new RuntimeException("Unsupported namespace usage "+artefact.getUseNamespace().toString());
      }
   }

   /**
    * Adds to the Outputfolder the path of the package and the generate subfolder from the
    * configuration.
    * @see org.umlmda.generator.AbstractWriter#getOutputFolder()
    */
   public File getOutputFolder() {
      StringBuffer buffer = new StringBuffer(super.getOutputFolder().getAbsolutePath());
      appendPackageFolder(buffer);
      if ( config.getGeneratedFolder() != null && config.getGeneratedFolder().length() > 0 ) {      
         buffer.append(File.separator);
         buffer.append(config.getGeneratedFolder()); 
      }
      return new File(buffer.toString());
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.AbstractWriter#setModelElement(java.lang.Object)
    */
   public void setModelElement(Object element) {
      super.setModelElement(element);
      if ( element instanceof GeneratorModelElement ) {
         this.modelElement = (GeneratorModelElement) element;
         this.properties = null;
      }
   }
   
   
}
