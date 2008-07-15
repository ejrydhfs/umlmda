/*
 *  $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/webservices/AbstractWSWriter.java,v 1.9 2006/06/26 20:37:26 moroff Exp $
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
 *  Created on Dec 9, 2004 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.uml.generator.webservices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;

import org.umlmda.generator.AbstractClassWriter;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.profile.ModelTaggedValues;
import org.umlmda.uml.generator.java.JavaClassHelper;
import org.umlmda.uml.generator.java.JavaMethodHelper;

/**
 * Baseclass for writer generating hibernate mappings
 * @author moroff
 */
public abstract class AbstractWSWriter extends AbstractClassWriter {
   private ModelElement attribute;
   private Map factoryMemberMap = null;
   
   public AbstractWSWriter() {
      super(new JavaClassHelper(), new JavaMethodHelper());
   }

   public WSModelClass getWSModelClass() {
      return (WSModelClass) getModelClass();
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#setModelClass(net.sourceforge.umlmda.xmi.uml.ModelClass)
    */
   public void setModelClass(ModelClass modelClass) {
      super.setModelClass(modelClass);
      factoryMemberMap = new HashMap();
   }
   
   public List getPackages() {
      return getWSModelClass().getReferencedPackages();
   }
   
   public List getReferencedClasses() {
      return getWSModelClass().getReferencedClasses();
   }

   public List getReferencedClasses(ModelPackage modelPackage) {
      return getWSModelClass().getReferencedClasses((WSModelPackage) modelPackage);
   }

   
   /**
    * Checks if a hierarchieclass has to be created
    * @param modelClass
    * @return
    */
   public boolean hasHierarchie(ModelClass modelClass) {
      return (hasDerivedClasses(modelClass) && usedAsParameterOrReference(modelClass));
   }
   
   static public boolean hasDerivedClasses(ModelClass modelClass) {
      return modelClass.getReferencedBy(ModelClass.class).size() > 0;
   }
   
//   public Collection getReferenceHierarchies() {
//      return referencedHierarchies;
//   }
   
   /**
    * 
    */
   public static Collection getDerivedClasses(ModelClass modelClass) {
      Set derivedClassSet = new HashSet();
      
      getDerivedClasses(derivedClassSet, modelClass);
      List derivedClasses = new ArrayList(derivedClassSet);
      Collections.sort(derivedClasses, new Comparator() {

         public int compare(Object o1, Object o2) {
            ModelClass mc1 = (ModelClass) o1;
            ModelClass mc2 = (ModelClass) o2;
            
            if ( mc1.isInheritedFrom(mc2) )
               return -1;
            else if ( mc2.isInheritedFrom(mc1) )
               return 1;
            else
               return mc1.getQualifiedName().compareTo(mc2.getQualifiedName());
         }});
      return derivedClasses;
   }

   public static boolean hasDerivedOptimizedClasses(ModelClass modelClass) {
      return ((WSModelClass)modelClass).hasDerivedOptimizedClasses();
   }
   
   private static void getDerivedClasses(Set derivedClasses, ModelClass modelClass) {
      if ( modelClass.isAbstract() == false ) {
         derivedClasses.add(modelClass);
      }
      for (Iterator iter = modelClass.getSubClasses().iterator(); iter.hasNext();) {
         ModelClass derivedClass = (ModelClass) iter.next();
         
         if ( derivedClass.isAbstract() == false ) { 
            if ( derivedClasses.add(derivedClass) ) {
               getDerivedClasses(derivedClasses, derivedClass);
            }
         }
      }
   }
   
   public String getTypeOrHierarchie(ModelClassifier modelClassifier) {
      return getTypeOrHierarchie(modelClassifier, "");
   }
   
   public String getTypeOrHierarchie(ModelClassifier modelClassifier, String direction) {
      if ( modelClassifier instanceof ModelClass && hasDerivedClasses((ModelClass)modelClassifier)) {
         ModelClass modelClass = (ModelClass) modelClassifier;
         if ( StringUtils.isNotEmpty(direction) && (isOptimized(modelClass) || hasDerivedOptimizedClasses(modelClass))  )
            return getType(modelClass) + direction + "Hierarchie";
         else
            return getType(modelClass) + "Hierarchie";
      }
      else if ( modelClassifier instanceof ModelClass ) {
         return getDirectionType((ModelClass)modelClassifier, direction);
      }
      else {
         return getType(modelClassifier);
      }
   }
   
   static public boolean isOptimized(ModelClass modelClass) {
      return ((WSModelClass)modelClass).isOptimized();
   }
   
   public String getDirectionType(ModelClass modelClass, String direction) {
      String type = getType(modelClass);
      if ( StringUtil.isEmpty(direction) == false && isOptimized(modelClass) ) {
         return type + direction;
      }
      else {
         return type;
      }
   }
   
   public boolean usedAsParameter(ModelClass modelClass) {
      boolean usedAsParameter = false;
      
      for (Iterator im = getModelClass().getMethods(true).iterator(); !usedAsParameter && im.hasNext();) {
         ModelMethod method = (ModelMethod) im.next();
         
         for (Iterator ip = method.getParameters().iterator(); !usedAsParameter && ip.hasNext();) {
            ModelParameter parameter = (ModelParameter) ip.next();
            
            if ( parameter.getType() == modelClass )
               usedAsParameter = true;
         }
         
         for (Iterator ie = method.getExceptions().iterator(); !usedAsParameter && ie.hasNext();) {
            ModelClass exception = (ModelClass) ie.next();
            
            if ( exception == modelClass )
               usedAsParameter = true;
         }

         if ( method.getReturnType() == modelClass )
            usedAsParameter = true;
      }
      
      return usedAsParameter;
   }
   
   public boolean usedAsParameterOrReference(ModelClass modelClass) {
      boolean usedAsParameter = usedAsParameter(modelClass);
      
      for (Iterator ic = getReferencedClasses().iterator(); !usedAsParameter && ic.hasNext();) {
         ModelClass modelClass2 = (ModelClass) ic.next();
         
         for (Iterator ia = modelClass2.getAttributes().iterator(); !usedAsParameter && ia.hasNext();) {
            ModelAttribute attribute = (ModelAttribute) ia.next();
            
            if ( attribute.getModelClass() == modelClass )
               usedAsParameter = true;
         }

         for (Iterator ia = modelClass2.getAssociations().iterator(); !usedAsParameter && ia.hasNext();) {
            ModelAssociation association = (ModelAssociation) ia.next();
            
            if ( association.getTarget() == modelClass )
               usedAsParameter = true;
         }
      }
      return usedAsParameter;
   }
   
   public boolean matchDirection(ModelElement modelElement, String direction) {
      if ( direction.equals(ModelStereotype.DIRECTION_IN) ) {
         return modelElement.hasStereotype(ModelStereotype.DIRECTION_OUT) == false;
      }
      else if ( direction.equals(ModelStereotype.DIRECTION_OUT) ) {
         return modelElement.hasStereotype(ModelStereotype.DIRECTION_IN) == false;
      }
      else
         return true;
   }

   public String getFactoryMember(ModelPackage modelPackage) {
      String factoryMember = (String) factoryMemberMap.get(modelPackage);
      
      if ( factoryMember == null  ) {
         factoryMember = "factory" + (factoryMemberMap.size() + 1);
         factoryMemberMap.put(modelPackage, factoryMember);
      }
      
      return factoryMember;
   }
}
