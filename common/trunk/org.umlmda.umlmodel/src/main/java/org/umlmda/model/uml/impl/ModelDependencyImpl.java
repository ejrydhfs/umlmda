/*
 * Created on 04.11.2005
 */
package org.umlmda.model.uml.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelDependencyBase;
import org.umlmda.model.uml.ModelElementBase;

/**
 * Defaultimplementation of a model dependancy
 * 
 * @author MOROFF
 */
public class ModelDependencyImpl extends ModelElementImpl implements ModelDependencyBase
{
   List<ModelElementBase> clients  = new ArrayList<ModelElementBase>(); // TODO Observer
   List<ModelElementBase> supplies = new ArrayList<ModelElementBase>();

   /**
    * @param model
    * @param owner
    */
   public ModelDependencyImpl(ModelBase model, ModelElementBase owner) {
      super(model, owner);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getClients()
    */
   public Collection<ModelElementBase> getClients() {
      return clients;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.model.uml.ModelDependencyBase#getSuppliers()
    */
   public Collection<ModelElementBase> getSuppliers() {
      return supplies;
   }

}
