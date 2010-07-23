// UMLMDA, UMLModel-API
// 
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
package org.umlmda.model.uml.mdr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


import org.omg.uml.foundation.core.Classifier;
import org.omg.uml.foundation.core.Constraint;
import org.omg.uml.foundation.core.Dependency;
import org.omg.uml.foundation.core.ModelElement;
import org.omg.uml.foundation.core.Namespace;
import org.omg.uml.foundation.core.Stereotype;
import org.omg.uml.foundation.core.TaggedValue;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelConstants;
import org.umlmda.model.uml.ModelElementBase;



/**
 * Implementation of the model element for the netbean model repository
 * @author Dieter Moroff
 */
public class ModelElementImpl implements ModelConstants, ModelElementBase {
   protected final org.omg.uml.foundation.core.ModelElement modelElement;
//   private final ModelElementUtils utils;
   protected Properties taggedValues = null;
   private List stereotypes = null;
   private List dependencies = null;
   protected final ModelImpl model;
	
	ModelElementImpl(ModelImpl model, org.omg.uml.foundation.core.ModelElement modelElement) {
		this.modelElement = modelElement;
      this.model = model;
//      this.utils = new ModelElementUtils(this);
	}
	
	/**
	 * @return
	 */
	public Properties getTaggedValues() {
		if ( taggedValues == null ) {
			taggedValues = new Properties();
         if ( modelElement != null ) {
   			for (Iterator itv = modelElement.getTaggedValue().iterator(); itv.hasNext();) {
   				TaggedValue taggedValue = (TaggedValue) itv.next();
               if ( taggedValue.getType().getName().length() > 0 && taggedValue.getDataValue().size() > 0 )	
   				  taggedValues.put(taggedValue.getType().getName(), taggedValue.getDataValue().iterator().next());
   			}
         }
		}
		return taggedValues;
	}


   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotypes()
    */
   public Collection getStereotypes() {
      if ( stereotypes == null ) {
         stereotypes = new ArrayList(modelElement.getStereotype().size());
         
         for (Iterator is = modelElement.getStereotype().iterator(); is.hasNext();) {
            Stereotype stereotype = (Stereotype) is.next();
            
            stereotypes.add(stereotype.getName());
         }
      }
      return stereotypes;
   }

   public String getName() {
      if ( modelElement != null )
         return modelElement.getName();
      else
         return EMPTY;   
   }
   
   public String getDocumentation() {
      if ( modelElement != null )
         return getTaggedValues().getProperty("documentation", EMPTY);
      else
         return EMPTY;   
      
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getOwner()
    */
   public ModelElementBase getOwnerBase() {
      Namespace container = modelElement.getNamespace();
      
      if ( container instanceof Classifier )
         return model.findClassifier((Classifier)container);
      else if ( container instanceof Namespace )
         return model.findPackage(container);
      else
         return null;
   }
   
   public ModelBase getModelBase() {
      return model;
   }

   protected String getTaggedValue(String tag, String defaultValue) {
      String value = defaultValue;
      
      for (Iterator iter = modelElement.getTaggedValue().iterator(); iter.hasNext();) {
         TaggedValue taggedValue = (TaggedValue) iter.next();
         
         if ( taggedValue.getType().getName().equals(tag)) {
            value = (String) taggedValue.getDataValue().iterator().next();
            break;
         }
      }
      
      return value;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getDependencies()
    */
   public Collection getDependencies() {
      if ( dependencies == null ) {
         dependencies = new ArrayList();
         
            for (Iterator id = modelElement.getClientDependency().iterator(); id.hasNext();) {
               Dependency dependency = (Dependency) id.next();
               
               dependencies.add(new ModelDependencyImpl((ModelImpl) getModelBase(), dependency));
            }
         
      }
      return dependencies;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String)
    */
   public String getStereotypeProperty(String name) {
      return taggedValues.getProperty(name);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String, java.lang.String)
    */
   public String getStereotypeProperty(String name, String defaultValue) {
      return taggedValues.getProperty(name, defaultValue);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getModelUId()
    */
   public String getModelUId() {
      String id = (String) modelElement.refGetValue("id"); 
      return id; 
   }

   /**
    * @param constraintsHolder
    * @return
    */
   protected String getConstraints(ModelElement constraintsHolder) {
      StringBuffer constraints = new StringBuffer();
      
      for (Iterator ic = constraintsHolder.getConstraint().iterator(); ic.hasNext();) {
         Constraint constraint = (Constraint) ic.next();
       
         constraints.append(constraint.getBody().getBody());
         if ( ic.hasNext() ) {
            constraints.append("\n");
         }
      }
      return constraints.toString();
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getConstraints()
    */
   public String getConstraints() {
      return getConstraints(modelElement);
   }

}
