/*
 * Created on 04.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml.mdr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.omg.uml.foundation.core.Classifier;
import org.omg.uml.foundation.core.Dependency;
import org.omg.uml.foundation.core.ModelElement;
import org.umlmda.model.uml.ModelClassifierBase;
import org.umlmda.model.uml.ModelDependencyBase;


/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModelDependencyImpl extends ModelElementImpl implements ModelDependencyBase {
   private final Dependency modelDependency;
   private List suppliers = null;
   private List clients = null;
   
   /**
    * @param model
    * @param owner
    */
   public ModelDependencyImpl(ModelImpl model, Dependency modelDependency) {
      super(model, modelDependency);
      this.modelDependency = modelDependency;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getClients()
    */
   public Collection getClients() {
      if ( clients == null ) {
         clients = new ArrayList();
         addElements(model, clients, modelDependency.getClient());
      }
      return suppliers;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getSuppliers()
    */
   public Collection getSuppliers() {
      if ( suppliers == null ) {
         suppliers = new ArrayList();
         addElements(model, suppliers, modelDependency.getSupplier());
      }
      return suppliers;
   }

   private static void addElements(ModelImpl model, Collection elementList, Collection modelElementList) {
      for (Iterator ic = modelElementList.iterator(); ic.hasNext();) {
         ModelElement element = (ModelElement) ic.next();
         
         if ( element instanceof Classifier ) {
            Classifier classifier = (Classifier) element;
            ModelClassifierBase modelClassifier = model.findClassifier(classifier);
            
            if ( modelClassifier != null ) {
               elementList.add(modelClassifier);
            }
            else {
               // TODO handle not found
            }
         }
         else {
            // TODO handle all types 
         }
         
      }
      
   }
}
