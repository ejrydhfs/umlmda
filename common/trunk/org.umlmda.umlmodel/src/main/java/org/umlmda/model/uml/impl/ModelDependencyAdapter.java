/*
 * Created on 04.11.2005
 */
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelDependencyBase;
import org.umlmda.model.uml.ModelElement;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelVisitor;

/**
 * @author MOROFF
 */
public class ModelDependencyAdapter extends ModelElementAdapter implements ModelDependency
{
   private final ModelDependencyBase modelDependency;
   private List<ModelElementBase>    clients   = null;
   private List<ModelElementBase>    suppliers = null;

   /**
    * @param modelElement
    * @param adaptedModel
    */
   public ModelDependencyAdapter(ModelDependencyBase modelDependency, Model adaptedModel) {
      super(modelDependency, adaptedModel);
      this.modelDependency = modelDependency;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getClients()
    */
   public Collection<ModelElementBase> getClients() {
      if ( clients == null ) {
         clients = new ArrayList<ModelElementBase>();

         for ( Iterator<ModelElementBase> ic = modelDependency.getClients().iterator(); ic.hasNext(); ) {
            ModelElementBase elementBase = ic.next();

            clients.add(getModel().getModelElement(elementBase));
         }
      }
      return clients;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getSuppliers()
    */
   public Collection<ModelElementBase> getSuppliers() {
      if ( suppliers == null ) {
         suppliers = new ArrayList<ModelElementBase>();

         for ( Iterator<ModelElementBase> is = modelDependency.getSuppliers().iterator(); is.hasNext(); ) {
            ModelElementBase elementBase = is.next();

            suppliers.add(getModel().getModelElement(elementBase));
         }
      }
      return suppliers;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelVisitable#accept(org.umlmda.model.uml.ModelVisitor)
    */
   public void accept(ModelVisitor visitor) {
      visitor.visit(this);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependency#getSupplier()
    */
   public ModelElement getSupplier() {
      if ( getSuppliers().size() == 1 ) {
         return (ModelElement) getSuppliers().iterator().next();
      }
      else {
         throw new IllegalStateException("More than one supplier exist in this dependency");
      }
   }
}
