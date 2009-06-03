// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelElementImpl.java,v 1.7.2.1.2.3 2008/03/17 20:52:07 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelElementImpl.java,v $
// $Revision: 1.7.2.1.2.3 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/03/17 20:52:07 $
//   $Locker:  $
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
package org.umlmda.model.uml.uml2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelConstants;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelMethodBase;

/**
 * Model element implementation for UML2 models based on eclipse UML2 implementation.
 * 
 * @author MOROFF
 */
public class ModelElementImpl implements ModelConstants, ModelElementBase
{
   protected final Element           modelElement;
   protected final ModelImpl         model;
   private final String              modelUId;
   private Properties                taggedValues = null;
   private List<String>              stereotypes  = null;
   private List<ModelDependencyImpl> depencencies = null;
   protected static Logger           logger       = Logger.getLogger(ModelElementImpl.class);

   ModelElementImpl(ModelImpl model, Element modelElement) {
      this.model = model;
      this.modelElement = modelElement;

      String id = null;

      if ( modelElement.eResource() != null ) {
         id = modelElement.eResource().getURIFragment(modelElement);
      }

      if ( id != null ) {
         modelUId = id;
      }
      else {
         modelUId = org.umlmda.model.uml.impl.ModelElementImpl.createUUID();
      }

   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getTaggedValues()
    */
   public Properties getTaggedValues() {
      if ( taggedValues == null ) {
         taggedValues = new Properties();

         getTaggedValues(getModelElement(), taggedValues);
      }
      return taggedValues;
   }

   /**
    * @param appliedStereotypSet
    */
   static void getTaggedValues(Element modelElement, Properties taggedValues) {
      List<Stereotype> appliedStereotypeSet = modelElement.getAppliedStereotypes();
      for ( Stereotype stereotype : appliedStereotypeSet ) {
         getTaggedValues(modelElement, stereotype, taggedValues);
      }

      List<Stereotype> stereotypeSet = modelElement.getApplicableStereotypes();
      for ( Stereotype stereotype : stereotypeSet ) {
         if ( modelElement.isStereotypeRequired(stereotype) ) {
            getTaggedValues(modelElement, stereotype, taggedValues);
         }
      }
   }

   /**
    * @param modelElement
    * @param stereotype
    * @param taggedValues
    */
   private static void getTaggedValues(Element modelElement, Stereotype stereotype, Properties taggedValues) {
      for ( Property property : stereotype.getAllAttributes() ) {
         if ( !(property.getName().startsWith("base$") || property.getName().startsWith("base_")) ) {
            Object value = modelElement.getValue(stereotype, property.getName());

            if ( value instanceof String ) {
               if ( StringUtils.isNotEmpty((String) value) )
                  taggedValues.put(property.getName(), value);
            }
            else if ( value instanceof EnumerationLiteral ) {
               EnumerationLiteral literal = (EnumerationLiteral) value;

               taggedValues.put(property.getName(), literal.getName());
            }
            else if ( value instanceof Integer ) {
               Integer intValue = (Integer) value;

               taggedValues.put(property.getName(), intValue.toString());
            }
            else if ( value instanceof Boolean ) {
               Boolean boolValue = (Boolean) value;

               taggedValues.put(property.getName(), boolValue.toString());
            }
            else if ( value != null ) {
               if ( logger.isDebugEnabled() )
                  logger.debug(property.getName() + " unknown type " + value.getClass());
            }
         }
      }
   }

   protected Element getModelElement() {
      return this.modelElement;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getStereotypes()
    */
   public Collection<String> getStereotypes() {
      if ( stereotypes == null ) {
         stereotypes = new ArrayList<String>();

         List<Stereotype> appliedStereotypeSet = modelElement.getAppliedStereotypes();
         List<String> stereotypeSet = modelElement.getKeywords();

         for ( Stereotype stereotype : appliedStereotypeSet ) {
            stereotypes.add(stereotype.getName());
         }
         for ( String stereotype : stereotypeSet ) {
            stereotypes.add(stereotype);
         }
      }
      return stereotypes;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#hasStereotype(java.lang.String)
    */
   public boolean hasStereotype(String stereotype) {
      return getStereotypes().contains(stereotype);
   }

   public String getName() {
      if ( modelElement != null && modelElement instanceof NamedElement ) {
         NamedElement namedElement = (NamedElement) modelElement;

         return namedElement.getName();
      }
      else
         return EMPTY;
   }

   public String getDocumentation() {
      List<Comment> comments = modelElement.getOwnedComments();
      if ( comments.size() > 0 ) {
         Comment comment = (Comment) comments.get(0);

         return comment.getBody();
      }
      else
         return EMPTY;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElement#getOwner()
    */
   public ModelElementBase getOwnerBase() {
      Element container = modelElement.getOwner();

      if ( container instanceof Model ) {
         if ( ((Model) container).getName().equals(model.getName()) ) {
            return model;
         }
         else {
            return model.findModel((Model) container);
         }
      }
      else if ( container instanceof Package )
         return model.findPackage((Package) container);
      else if ( container instanceof Classifier )
         return model.findClassifier((Classifier) container);
      else if ( container instanceof Operation ) {
         Operation operation = (Operation) container;
         Classifier operationOwner = (Classifier) operation.getOwner();
         ModelClassBase operationClass = (ModelClassBase) model.findClassifier(operationOwner);

         for ( Iterator im = operationClass.getMethods().iterator(); im.hasNext(); ) {
            ModelMethodBase method = (ModelMethodBase) im.next();

            if ( method.getName().equals(operation.getName()) ) {
               return method;
            }
         }
         return null;
      }
      else
         return null;
   }

   public ModelBase getModelBase() {
      return model;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getDependencies()
    */
   public Collection<ModelDependencyImpl> getDependencies() {
      if ( depencencies == null ) {
         depencencies = new ArrayList<ModelDependencyImpl>();

         if ( modelElement instanceof NamedElement ) {
            NamedElement namedElement = (NamedElement) modelElement;

            for ( Dependency dependency : namedElement.getClientDependencies() ) {
               depencencies.add(new ModelDependencyImpl((ModelImpl) getModelBase(), dependency));
            }
         }
      }
      return depencencies;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String)
    */
   public String getStereotypeProperty(String name) {
      return getTaggedValues().getProperty(name);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String, java.lang.String)
    */
   public String getStereotypeProperty(String name, String defaultValue) {
      return getTaggedValues().getProperty(name, defaultValue);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getModelUId()
    */
   public String getModelUId() {
      return modelUId;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getConstraints()
    */
   protected String getConstraints(Element contraintsHolder) {
      StringBuffer constraints = new StringBuffer();

      for ( Iterator<Element> ic = contraintsHolder.getOwnedElements().iterator(); ic.hasNext(); ) {
         Element element = (Element) ic.next();

         if ( element instanceof Constraint ) {
            Constraint constraint = (Constraint) element;

            constraints.append(constraint.getSpecification().toString());
            if ( ic.hasNext() ) {
               constraints.append("\n");
            }
         }
      }
      return constraints.toString();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAssociationBase#getConstraints()
    */
   public String getConstraints() {
      return getConstraints(modelElement);
   }

}
