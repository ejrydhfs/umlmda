/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/utils/ModelIterator.java,v 1.3.2.1 2008/03/11 15:53:35 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/utils/ModelIterator.java,v $
 * $Revision: 1.3.2.1 $
 *     $Name:  $
 *     $Date: 2008/03/11 15:53:35 $
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
 * Created by Dieter Moroff (12.04.2006)
 */
package org.umlmda.model.uml.utils;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAssociation;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelGeneralization;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelParameter;

/**
 * Iterator which walks over all elements of a model and applies the visitor
 * the the model elements.
 * @author Dieter Moroff (12.04.2006), last change $Date: 2008/03/11 15:53:35 $ $Name:  $
 * @version $Revision: 1.3.2.1 $
 */
public class ModelIterator {
   private final Action action;
   
   /**
    * Interface of the action to be processed on every model element
    * passed with this iterator
    * @author Dieter Moroff (02.05.2006), last change $Date: 2008/03/11 15:53:35 $ $Name:  $
    * @version $Revision: 1.3.2.1 $
    */
   public interface Action {
      /**
       * Action callback.
       * @param modelElement
       */
      public abstract void process(ModelElement modelElement);
   }
   
  /**
    *  
    */
   public ModelIterator(Action action) {
      super();
      this.action = action;
   }

   public void iterate(Model model) {
      boolean loop = false;
      
      do {
         loop = false;
         try {

            action.process(model);
            
            // Iterate over model to initialise all elements
            for (Iterator ip = model.getPackages().iterator(); ip.hasNext();) {
               ModelPackage modelPackage = (ModelPackage) ip.next();

               action.process(modelPackage);
               
               for (Iterator id = modelPackage.getDependencies().iterator(); id.hasNext();) {
                  ModelDependency dependency = (ModelDependency) id.next();
                  
                  action.process(dependency);
               }
               
               for (Iterator ic = modelPackage.getClasses().iterator(); ic.hasNext();) {
                  ModelClass modelClass = (ModelClass) ic.next();

                  action.process(modelClass);
                  
                  for (Iterator iattr = modelClass.getAttributes().iterator(); iattr.hasNext(); ) {
                     ModelAttribute attribute = (ModelAttribute) iattr.next();
                     
                     action.process(attribute);
                  }

                  for (Iterator iasso = modelClass.getAssociations().iterator(); iasso.hasNext(); ) {
                     ModelAssociation association = (ModelAssociation) iasso.next();
                     
                     action.process(association);
                  }

                  for (Iterator igen = modelClass.getGeneralizations().iterator(); igen.hasNext();) {
                     ModelGeneralization generalization = (ModelGeneralization) igen.next();
                     
                     action.process(generalization);
                  }
                  for (Iterator imeth = modelClass.getMethods().iterator(); imeth.hasNext(); ) {
                     ModelMethod method = (ModelMethod) imeth.next();

                     action.process(method);
                     
                     for (Iterator ipar = method.getParameters().iterator(); ipar.hasNext(); ) {
                        ModelParameter parameter = (ModelParameter) ipar.next();
                        
                        action.process(parameter);
                     }
                     
                     for (Iterator iexc = method.getExceptions().iterator(); iexc.hasNext(); iexc.next()) {
                        ;
                        // TODO Create ModelException and handle here
                     }
                  }
                  
                  for (Iterator id = modelClass.getDependencies().iterator(); id.hasNext();) {
                     ModelDependency dependency = (ModelDependency) id.next();
                     
                     action.process(dependency);
                  }
                  
               }

            }
         } catch (ConcurrentModificationException e) {
            loop = true;
         }
      } while ( loop );
   }
}
