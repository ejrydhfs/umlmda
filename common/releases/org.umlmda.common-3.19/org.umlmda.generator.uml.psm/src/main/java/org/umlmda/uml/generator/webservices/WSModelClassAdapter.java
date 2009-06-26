//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelClassAdapter.java,v 1.3 2007/04/12 06:45:54 moroff Exp $
//$Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelClassAdapter.java,v $
//$Revision: 1.3 $
// $State: Exp $
//  $Name:  $
//  $Date: 2007/04/12 06:45:54 $
//$Locker:  $
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Library General Public
//License as published by the Free Software Foundation; either
//version 2 of the License, or (at your option) any later version.
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//Library General Public License for more details.
//
//You should have received a copy of the GNU Library General Public
//License along with this library; if not, write to the
//Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//Boston, MA  02111-1307, USA. The text of license can be also found
//at http://www.gnu.org/copyleft/lgpl.html
//
//Created on Sep 22, 2005
package org.umlmda.uml.generator.webservices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.PIMStereotypes;
import org.umlmda.uml.generator.java.JavaArtefacts;
import org.umlmda.uml.generator.java.JavaModelClass;
import org.umlmda.uml.generator.java.JavaModelClassAdapter;

/**
 * web service schema adapter for model classes.
 * 
 * @author vpussel
 */
public class WSModelClassAdapter extends JavaModelClassAdapter implements WSModelClass{
   private List referencedClasses = null;
   private List referencedPackages = null;
   private Set referencedHierarchies = new HashSet();
   private Boolean optimized = null;
   private Boolean derivedOptimizedClasses = null;
   
	public WSModelClassAdapter(ModelClassBase modelClass, Model model) {
		super(modelClass, model);
	}

   /**
    * @return true if the type uses <<In>> <<Out>> Stereotypes for optimization
    */
   public boolean isOptimized() {
      if ( optimized == null ) {
         Set checkedClassesSet = new HashSet();
         
         isOptimized(checkedClassesSet);
      }
      return optimized.booleanValue();
   }
   
   private void setIfOptimized(boolean optimized) {
      if ( optimized )
         this.optimized = Boolean.TRUE;
   }
   
	/**
    * @return true if the type uses <<In>><<Out>>Stereotypes for
    *         optimization
    */
   private boolean isOptimized(Set checkedClassesSet) {
      if (optimized != null)
         return optimized.booleanValue();

      if (checkedClassesSet.contains(this)) {
         return false;
      }
      else {
         checkedClassesSet.add(this);
         boolean optimized = false;

         for (Iterator is = getSuperClasses().iterator(); is.hasNext();) {
            WSModelClassAdapter superClass = (WSModelClassAdapter) is.next();

            if (checkedClassesSet.contains(superClass) == false) {
               setIfOptimized(optimized = optimized || superClass.isOptimized(checkedClassesSet));
            }
         }

         for (Iterator ia = getAttributes().iterator(); !optimized && ia.hasNext();) {
            ModelAttribute attribute = (ModelAttribute) ia.next();
            WSModelClassAdapter attributeClass = (WSModelClassAdapter) attribute.getModelClass();

            if (attribute.hasStereotype(ModelStereotype.DIRECTION_IN)
                  || attribute.hasStereotype(ModelStereotype.DIRECTION_OUT))
               setIfOptimized(optimized = true);
            if (attributeClass != null && attributeClass.isOptimized(checkedClassesSet))
               setIfOptimized(optimized = true);
         }

         for (Iterator ia = getAssociations().iterator(); !optimized && ia.hasNext();) {
            ModelAssociation association = (ModelAssociation) ia.next();

            if (association.hasStereotype(ModelStereotype.DIRECTION_IN)
                  || association.hasStereotype(ModelStereotype.DIRECTION_OUT))
               setIfOptimized(optimized = true);

            WSModelClassAdapter assocTarget = (WSModelClassAdapter) association.getTarget();
            if (this != assocTarget
                  && (assocTarget.isOptimized(checkedClassesSet) || assocTarget.hasDerivedOptimizedClasses(checkedClassesSet)))
               setIfOptimized(optimized = true);
         }

         this.optimized = new Boolean(optimized);
         return optimized;
      }
   }

      /*
       * (non-Javadoc)
       * 
       * @see org.umlmda.uml.generator.webservices.WSModelClass#hasDerivedOptimizedClasses()
       */
      public boolean hasDerivedOptimizedClasses() {
         if ( derivedOptimizedClasses == null ) {
            Set checkedClassesSet = new HashSet();
            
            hasDerivedOptimizedClasses(checkedClassesSet);
         }
         return derivedOptimizedClasses.booleanValue();
         
      }

      /*
       * (non-Javadoc)
       * 
       * @see org.umlmda.uml.generator.webservices.WSModelClass#hasDerivedOptimizedClasses()
       */
   private boolean hasDerivedOptimizedClasses(Set checkedClassesSet) {
      if (derivedOptimizedClasses != null)
         return derivedOptimizedClasses.booleanValue();

      if (checkedClassesSet.contains(this)) {
         return false;
      }
      else {
         checkedClassesSet.add(this);

         boolean derivedOptimizedClasses = false;

         for (Iterator ic = getAllSubClasses().iterator(); derivedOptimizedClasses == false && ic.hasNext();) {
            WSModelClassAdapter derivedClass = (WSModelClassAdapter) ic.next();

            if (derivedClass.isOptimized(checkedClassesSet))
               derivedOptimizedClasses = true;
         }
         this.derivedOptimizedClasses = new Boolean(derivedOptimizedClasses);
         return derivedOptimizedClasses;
      }
   }

   
	/**
    * @return the most basic super class for a polymorph class
    */
	public WSModelClassAdapter getPolymorphBase() {
		WSModelClassAdapter result = null;
		if (hasPolymorphicAssociations())
			result = this;
		else {
			// search backwards in super class list - from most basic to directly derived types
			for (ListIterator iter = getAllSuperClasses().listIterator(getAllSuperClasses().size()); iter.hasPrevious();) {
				WSModelClassAdapter superCls = (WSModelClassAdapter) iter.previous();
				if (superCls.hasPolymorphicAssociations()) {
					result = superCls;
					break;
				}
			}
		}
		return result;
	}


   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getDirectionType(org.umlmda.model.uml.ModelClass, java.lang.String)
    */
   public String getDirectionType(String direction) {
      String type = getSchemaType();

      if ( StringUtil.isEmpty(direction) == false && isOptimized() ) {
         type = type + direction;
      }

      return type;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getDirectionType(org.umlmda.model.uml.ModelClass, java.lang.String)
    */
   public String getDirectionTypeOrHierarchie(String direction) {
      String type = getDirectionType(direction);

      if ( hasDerivedClasses() ) {
         type = type + "Hierarchie";
      }
      
      return type;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getSchemaType(org.umlmda.model.uml.ModelClass)
    */
   public String getSchemaType() {
      WSModelPackage genPackage = (WSModelPackage) getGeneratorPackage();
      
      return genPackage.getNamespacePrefix() + ":" + getGeneratedName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getTypeOrHierarchie(java.lang.String)
    */
   public String getTypeOrHierarchie(String direction) {
      if ( hasDerivedClasses()) {
         if ( StringUtils.isNotEmpty(direction) && (isOptimized() || hasDerivedOptimizedClasses())  )
            return getSchemaType() + direction + "Hierarchie";
         else
            return getSchemaType() + "Hierarchie";
      }
      else {
         return getDirectionType(direction);
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#usedAsParameterOrReference(org.umlmda.uml.generator.webservices.WSModelClass)
    */
   public boolean usedAsParameterOrReference(WSModelClass serviceClass) {
      boolean usedAsParameter = usedAsParameter(serviceClass);
      
      if ( serviceClass != null ) {
         for (Iterator ic = serviceClass.getReferencedClasses().iterator(); !usedAsParameter && ic.hasNext();) {
            ModelClass modelClass2 = (ModelClass) ic.next();

            for (Iterator ia = modelClass2.getAttributes().iterator(); !usedAsParameter && ia.hasNext();) {
               ModelAttribute attribute = (ModelAttribute) ia.next();

               if (attribute.getModelClass() != null && attribute.getModelClass().equals(this))
                  usedAsParameter = true;
            }

            for (Iterator ia = modelClass2.getAssociations().iterator(); !usedAsParameter && ia.hasNext();) {
               ModelAssociation association = (ModelAssociation) ia.next();

               if (association.getTarget().equals(this))
                  usedAsParameter = true;
            }
         }
      }
      return usedAsParameter;
   }
   
   public boolean usedAsParameter(WSModelClass serviceClass) {
      boolean usedAsParameter = false;
      
      if ( serviceClass != null ) {
         for (Iterator im = serviceClass.getMethods(true).iterator(); !usedAsParameter && im.hasNext();) {
            ModelMethod method = (ModelMethod) im.next();

            for (Iterator ip = method.getParameters().iterator(); !usedAsParameter && ip.hasNext();) {
               ModelParameter parameter = (ModelParameter) ip.next();

               if (parameter.getType().equals(this))
                  usedAsParameter = true;
            }

            for (Iterator ie = method.getExceptions().iterator(); !usedAsParameter && ie.hasNext();) {
               ModelClass exception = (ModelClass) ie.next();

               if (exception.equals(this))
                  usedAsParameter = true;
            }

            if ( method.getReturnType() != null && method.getReturnType().equals(this))
               usedAsParameter = true;
         }
      }
      else {
         usedAsParameter = true;
      }
      
      return usedAsParameter;
   }
   
   public List getReferencedPackages() {
      if ( referencedPackages == null ) {
         Set packages = new HashSet();
         
         for (Iterator iter = getReferencedTypes().iterator(); iter.hasNext();) {
            ModelClass modelClass = (ModelClass) iter.next();
            
            packages.add(modelClass.getPackage());
         }
         packages.add(getPackage());
         referencedPackages = new ArrayList(packages);
         Collections.sort(referencedPackages);
      }
      return referencedPackages;
   }
   
   public List getReferencedClasses() {
      if ( referencedClasses == null ) {
         Set referencedClassSet = new HashSet();
         getReferencedClasses(referencedClassSet, this);
         
         referencedClasses = new ArrayList(referencedClassSet);
         Collections.sort(referencedClasses);
      }
      return referencedClasses;
   }

   public List getReferencedClasses(WSModelPackage modelPackage) {
      List referencedClasses = new ArrayList();
      
      for (Iterator iter = getReferencedClasses().iterator(); iter.hasNext();) {
         ModelClass modelClass = (ModelClass) iter.next();
         
         if ( modelClass.getPackage() == modelPackage)
            referencedClasses.add(modelClass);
      }
      return referencedClasses;
   }

   /**
    * @param referencedClassSet
    * @param modelClass
    */
   private void getReferencedClasses(Set referencedClassSet, WSModelClass modelClass) {
      Collection refClasses = modelClass.getReferencedTypes();
      if ( modelClass.hasDerivedClasses() ) {
         referencedHierarchies.add(modelClass);
         for (Iterator id = modelClass.getAllSubClasses().iterator(); id.hasNext();) {
            WSModelClass subClass = (WSModelClass) id.next();

            if ( referencedClassSet.add(subClass) ) {
               getReferencedClasses(referencedClassSet, subClass);
            }
         }
      }
      for (Iterator iter = refClasses.iterator(); iter.hasNext();) {
         WSModelClass refClass = (WSModelClass) iter.next();
         
         if ( referencedClassSet.add(refClass) ) {
            getReferencedClasses(referencedClassSet, refClass);
         }
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getInstanceClasses()
    */
   public List getInstanceClasses() {
      List instanceClasses = new ArrayList();
      
      for (Iterator ic = getAllSubClasses().iterator(); ic.hasNext();) {
         ModelClass subClass = (ModelClass) ic.next();
         
         if ( subClass.isAbstract() == false ) {
            instanceClasses.add(subClass);
         }
      }
      
      if ( isAbstract() == false ) {
         instanceClasses.add(this);
      }
      return instanceClasses;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getPIMClass()
    */
   public JavaModelClass getPIMClass() {
      if (  hasStereotype(WSStereotypes.WEB_SERVICE_REQUEST)
            || hasStereotype(WSStereotypes.WEB_SERVICE_RESPONSE) ) {
            return null;
      }
      else if (  hasStereotype(WSStereotypes.WEB_SERVICE_OBJECT)
         || hasStereotype(WSStereotypes.WEB_SERVICE_ENUMERATION)) {
         for (Iterator id = getDependencies().iterator(); id.hasNext();) {
            ModelDependency dependency = (ModelDependency) id.next();
            
            if ( dependency.hasStereotype(PIMStereotypes.PIM_OBJECT) ) {
               return (JavaModelClass) dependency.getClients().iterator().next();
            }
         }
         
         throw new RuntimeException("Model is not constistence");
      }
      else if ( hasStereotype(WSStereotypes.WEB_SERVICE) ) {
            for (Iterator id = getDependencies().iterator(); id.hasNext();) {
               ModelDependency dependency = (ModelDependency) id.next();
               
               if ( dependency.hasStereotype(PIMStereotypes.PIM_SERVICE) ) {
                  return (JavaModelClass) dependency.getClients().iterator().next();
               }
            }
            
            throw new RuntimeException("Model is not constistence");
         }
      else {
         return this;
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getReferencedPIMTypes()
    */
   public List getReferencedPIMTypes() {
      List schemaTypes = getSchemaTypes();
      Set referencePIMTypeSet = new HashSet();
      
      for (Iterator ic = schemaTypes.iterator(); ic.hasNext();) {
         WSModelClass wsClass = (WSModelClass) ic.next();
         JavaModelClass pimClass = wsClass.getPIMClass();
         
         if ( pimClass != null ) 
            referencePIMTypeSet.add(pimClass);
      }
      
      List referencePIMTypes = new ArrayList(referencePIMTypeSet);
      Collections.sort(referencePIMTypes);
      return referencePIMTypes;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClassifier#getWSJavaType()
    */
   public String getWSJavaType() {
      WSModelClass genClass = (WSModelClass) getGeneratorModel().getContext().getCurrentModelElement();
      
      if ( hasStereotype(WSStereotypes.WEB_SERVICE_OBJECT)) {
         return genClass.getScopedName(WSArtefacts.WS_STUB, this);
      }
      else if ( hasStereotype(WSStereotypes.WEB_SERVICE_REQUEST)) {
         return genClass.getScopedName(WSArtefacts.WS_STUB, this);
      }
      else if ( hasStereotype(WSStereotypes.WEB_SERVICE_RESPONSE)) {
         return genClass.getScopedName(WSArtefacts.WS_STUB, this);
      }
      else if ( hasStereotype(ModelStereotype.BUSINESS_OBJECT)) {
         return genClass.getScopedName(JavaArtefacts.BUSINESS_OBJECT_INTERFACE, this);
      } 
      else if ( hasStereotype(ModelStereotype.BUSINESS_EXCEPTION)) {
         return genClass.getScopedName(JavaArtefacts.BUSINESS_EXCEPTION, this);
      } 
      else if ( hasStereotype(ModelStereotype.ENUMERATION)) {
         return genClass.getScopedName(JavaArtefacts.ENUMERATION, this);
      } 
      // TODO Auto-generated method stub
      return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getSchemaComplexTypes()
    */
   public List getSchemaComplexTypes() {
      List schemaComplexTypes = new ArrayList(getSchemaTypes());
      
      for (Iterator it = schemaComplexTypes.iterator(); it.hasNext();) {
         ModelClass schemaType = (ModelClass) it.next();
         
         if ( ! (  schemaType.hasStereotype(WSStereotypes.WEB_SERVICE_OBJECT)
                || schemaType.hasStereotype(WSStereotypes.WEB_SERVICE_EXCEPTION)
                || schemaType.hasStereotype(WSStereotypes.WEB_SERVICE_REQUEST) 
                || schemaType.hasStereotype(WSStereotypes.WEB_SERVICE_RESPONSE))) {
            it.remove();
         }
      }
      return schemaComplexTypes;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClass#getSchemaComplexTypes()
    */
   public List getSchemaEnumTypes() {
      List schemaEnumTypes = new ArrayList(getSchemaTypes());
      
      for (Iterator it = schemaEnumTypes.iterator(); it.hasNext();) {
         ModelClass schemaType = (ModelClass) it.next();
         
         if ( ! schemaType.hasStereotype(WSStereotypes.WEB_SERVICE_ENUMERATION) ) {
            it.remove();
         }
      }
      return schemaEnumTypes;
   }
   
}
