/*
 * Created on 04.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelDependencyBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelVisitor;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModelDependencyAdapter extends ModelElementAdapter implements ModelDependency {
   private final ModelDependencyBase modelDependency;
   private List clients = null;
   private List suppliers = null;
   
   /**
    * @param modelElement
    * @param adaptedModel
    */
   public ModelDependencyAdapter(ModelDependencyBase modelDependency, Model adaptedModel) {
      super(modelDependency, adaptedModel);
      this.modelDependency = modelDependency;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getClients()
    */
   public Collection getClients() {
      if ( clients == null ) {
         clients = new ArrayList();
         
         for (Iterator ic = modelDependency.getClients().iterator(); ic.hasNext();) {
            ModelElementBase elementBase = (ModelElementBase) ic.next();
            
            clients.add(getModel().getModelElement(elementBase));
         }
      }
      return clients;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getSuppliers()
    */
   public Collection getSuppliers() {
      if ( suppliers == null ) {
         suppliers = new ArrayList();
         
         for (Iterator is = modelDependency.getSuppliers().iterator(); is.hasNext();) {
            ModelElementBase elementBase = (ModelElementBase) is.next();
            
            suppliers.add(getModel().getModelElement(elementBase));
         }
      }
      return suppliers;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependency#getSupplier()
    */
   public ModelElement getSupplier() {
      if ( getSuppliers().size() == 1 ) {
         return (ModelElement)getSuppliers().iterator().next();
      }
      else {
         throw new IllegalStateException("More than one supplier exist in this dependency");
      }
   }
}
