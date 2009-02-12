// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelElementImpl.java,v 1.9 2007/11/08 09:44:05 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelElementImpl.java,v $
// $Revision: 1.9 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2007/11/08 09:44:05 $
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
package org.umlmda.model.uml.nsuml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelConstants;
import org.umlmda.model.uml.ModelElementBase;

import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MClassifier;
import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MDependency;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.MNamespace;
import ru.novosoft.uml.foundation.core.MOperation;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

/**
 * @author MOROFF
 */
public class ModelElementImpl implements ModelConstants, ModelElementBase {
   protected final MModelElement modelElement;
   protected final ModelImpl model;
   private final String modelUId;
	private Properties taggedValues = null;
	private List stereotypes = null;
   private List depencencies = null;
	
	ModelElementImpl(ModelImpl model, MModelElement modelElement) {
      this.model = model;
	  this.modelElement = modelElement;
      if ( modelElement != null && modelElement.getUUID() != null ) {
         modelUId = modelElement.getUUID();
      }
      else {
         modelUId = org.umlmda.model.uml.impl.ModelElementImpl.createUUID();
      }
	}
	
	/**
	 * @return
	 */
	public Properties getTaggedValues() {
		if ( taggedValues == null ) {
			taggedValues = new Properties();
         if ( modelElement != null ) {
   			for (Iterator itv = getModelElement().getTaggedValues().iterator(); itv.hasNext();) {
   				MTaggedValue taggedValue = (MTaggedValue) itv.next();
               if ( taggedValue.getTag().length() > 0 && taggedValue.getValue() != null )	
   				  taggedValues.put(taggedValue.getTag(), taggedValue.getValue());
   			}
         }
		}
		return taggedValues;
	}

   protected MModelElement getModelElement() {
      return this.modelElement;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelElement#getStereotypes()
    */
   public Collection getStereotypes() {
      if ( stereotypes == null ) {
         stereotypes = new ArrayList();
         
         if ( modelElement != null && modelElement.getStereotype() != null ) {
            StringTokenizer stereotype = new StringTokenizer(modelElement.getStereotype().getName(), ",");
            
            while ( stereotype.hasMoreTokens() ) {
               stereotypes.add(stereotype.nextToken().trim());
            }
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
      MModelElement container = modelElement.getModelElementContainer();
      
      if ( container instanceof MClassifier )
         return ((ModelImpl)model).findClassifier((MClassifier)container);
      else if ( container instanceof MNamespace )
         return ((ModelImpl)model).findPackage((MNamespace)container);
      else if ( container instanceof MOperation ) {
         MOperation method = (MOperation)container;
         MClass methodOwner = (MClass) method.getModelElementContainer();
         
         return ((ModelImpl)model).findMethod(methodOwner, method);
      }
      else
         return null;
   }
   
   public ModelBase getModelBase() {
      return model;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getDependencies()
    */
   public Collection getDependencies() {
      if ( depencencies == null ) {
         depencencies = new ArrayList();
         
         for (Iterator id = modelElement.getClientDependencies().iterator(); id.hasNext();) {
            MDependency dependency = (MDependency) id.next();
            
            depencencies.add(new ModelDependencyImpl((ModelImpl) getModelBase(), dependency));
         }
      }
      return depencencies;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String)
    */
   public String getStereotypeProperty(String name) {
      return getTaggedValues().getProperty(name);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getStereotypeProperty(java.lang.String, java.lang.String)
    */
   public String getStereotypeProperty(String name, String defaultValue) {
      return getTaggedValues().getProperty(name, defaultValue);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelElementBase#getModelUId()
    */
   public String getModelUId() {
      return modelUId;
   }

   /**
    * @param contraintHolder
    * @return
    */
   protected String getConstraints(MModelElement contraintHolder) {
      StringBuffer constraints = new StringBuffer();
      
      for (Iterator ic = contraintHolder.getConstraints().iterator(); ic.hasNext();) {
         MConstraint constraint = (MConstraint) ic.next();
       
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
