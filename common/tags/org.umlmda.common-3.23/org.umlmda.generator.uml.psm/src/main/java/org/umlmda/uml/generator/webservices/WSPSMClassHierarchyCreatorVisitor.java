/*
 *   $Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassHierarchyCreatorVisitor.java,v 1.4 2007/07/31 13:05:34 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSPSMClassHierarchyCreatorVisitor.java,v $
 * $Revision: 1.4 $
 *     $Name:  $
 *     $Date: 2007/07/31 13:05:34 $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (13.04.2006)
 */
package org.umlmda.uml.generator.webservices;

import java.beans.Introspector;
import java.util.Iterator;

import org.umlmda.model.uml.DefaultModelVisitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelParameter;
import org.umlmda.model.uml.impl.ModelAssociationImpl;
import org.umlmda.model.uml.impl.ModelClassImpl;
import org.umlmda.model.uml.impl.ModelElementAdapter;
import org.umlmda.model.uml.impl.ModelMethodImpl;
import org.umlmda.model.uml.impl.ModelParameterImpl;
import org.umlmda.uml.generator.PIMStereotypes;

/**
 * Creates web service dto hierarchie for polymorphic associations,
 * parameters and return types. 
 * @author Dieter Moroff (13.04.2006), last change $Date: 2007/07/31 13:05:34 $ $Name:  $
 * @version $Revision: 1.4 $
 */
public class WSPSMClassHierarchyCreatorVisitor extends DefaultModelVisitor {
   
   public static final String HIERARCHY_POSTFIX = "Hierarchie";
   
   /**
    * 
    */
   public WSPSMClassHierarchyCreatorVisitor() {
      super();
   }

   /**
    * @param classifier
    * @return
    */
   protected ModelClassBase createOrFindWsDtoHierarchie(Model model, ModelClassifierBase classifier) {
      ModelClassBase classHierary = null;
      
      if (  classifier instanceof ModelClassBase ) {
         ModelClass modelClass = model.getModelClass((ModelClassBase) classifier);
         
         if ( modelClass.hasStereotype(WSStereotypes.WEB_SERVICE_DTO) && modelClass.hasDerivedClasses() ) {
            classHierary = createOrFindWsDtoHierarchy(modelClass);
         }
      }
      return classHierary;
   }
   
   
   public boolean visit(ModelAssociation association) {
      super.visit(association);
      ModelClass source = association.getSource();
      ModelAssociationBase associationBase = (ModelAssociationBase) association.getBase();

      if ( source.hasStereotype(WSStereotypes.WEB_SERVICE_DTO_HIERARCHY) == false && associationBase instanceof ModelAssociationImpl ) {
         ModelAssociationImpl associationImpl = (ModelAssociationImpl) association.getBase();
         ModelClassBase targetHierarchy = createOrFindWsDtoHierarchie(association.getModel(), associationImpl.getTargetBase());
         
         if (targetHierarchy != null) {
            associationImpl.setTargetBase(targetHierarchy);
         }
      }
      return true;
   }
   
   public boolean visit(ModelMethod method) {
      super.visit(method);
      if ( method.getBase() instanceof ModelMethodImpl && method.hasStereotype(WSStereotypes.WEB_SERVICE_METHOD) ) {
         ModelMethodImpl methodImpl = (ModelMethodImpl) method.getBase();
         ModelClassifier returnType = method.getReturnType();

         // Handle return type
         if ( returnType != null && returnType.hasStereotype(WSStereotypes.WEB_SERVICE_OBJECT) ) {
            ModelClassBase returnHierarchy = createOrFindWsDtoHierarchie(method.getModel(), returnType);
   
            if (returnHierarchy != null) {
               methodImpl.setReturnTypeBase(returnHierarchy);
            }
         }
      }
      return true;
   }
   
   public boolean visit(ModelParameter parameter) {
      super.visit(parameter);
      if ( parameter.getBase() instanceof ModelParameterImpl ) {
         ModelParameterImpl parameterImpl = (ModelParameterImpl) parameter.getBase();
         ModelClassBase parameterHierarchy = createOrFindWsDtoHierarchie(parameter.getModel(), parameter.getType());

         if (parameterHierarchy != null) {
            parameterImpl.setTypeBase(parameterHierarchy);
         }
      }
      return true;
   }
   
   /**
    * If not existing creates a hierachy class with an assocation on every none abstract 
    * subclass of the given modelclass
    * @param modelClass
    * @param postFix
    * @return
    */
   private ModelClassBase createOrFindWsDtoHierarchy(ModelClass modelClass) {
      WSModelPackage modelPackage = (WSModelPackage) modelClass.getPackage();
      WSModel model = (WSModel) modelPackage.getModel();
      String name = modelClass.getName() + HIERARCHY_POSTFIX;
      String qualifiedName = modelPackage.getWsPackage().getQualifiedName() + "." + name;
      ModelClass wsClass = (ModelClass) model.find(qualifiedName);
      
      if ( wsClass != null ) {
         return (ModelClassBase) wsClass.getBase();
      }
      else {
         ModelClassImpl wsClassImpl = new ModelClassImpl(model, modelPackage.getWsPackage());

         wsClassImpl.setName(name);
         wsClassImpl.setAbstract(false);
         wsClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_DTO_HIERARCHY);
         wsClassImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_OBJECT);

         ModelElementAdapter.addDependency(((WSModelClass)modelClass).getPIMClass(), PIMStereotypes.PIM_OBJECT, wsClassImpl, model);
         
         // Create an assocation on every none abstract subclass
         for ( Iterator id = ((WSModelClass)modelClass).getInstanceClasses().iterator(); id.hasNext(); ) {
            WSModelClass derivedClass = (WSModelClass)id.next();
            ModelClassBase derivedClassBase = (ModelClassBase) derivedClass.getBase();
            
            ModelAssociationImpl wsAssocImpl = new ModelAssociationImpl(model, wsClassImpl); 
            
            wsAssocImpl.setName(Introspector.decapitalize(derivedClassBase.getName()));
            wsAssocImpl.setTargetBase(derivedClassBase);
            wsAssocImpl.setSourceBase(wsClassImpl);
            wsAssocImpl.setNavigatableToSource(false);
            wsAssocImpl.setNavigatableToTarget(true);
            wsAssocImpl.setReverseBase(wsAssocImpl.createReverse());

            wsClassImpl.getAssociations().add(wsAssocImpl);
            wsClassImpl.getAllAssociations().add(wsAssocImpl);
            derivedClassBase.getAllAssociations().add(model.getModelAssociation(wsAssocImpl.getReverseBase()));
         }         

         wsClass = model.getModelClass(wsClassImpl);
         modelPackage.getWsPackage().getClasses().add(wsClass);
         model.getClasses().add(wsClass);

         return wsClassImpl;
      }
   }
   
}
