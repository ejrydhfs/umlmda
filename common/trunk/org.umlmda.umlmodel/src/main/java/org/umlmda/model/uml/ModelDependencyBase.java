/*
 * Created on 04.11.2005
 */
package org.umlmda.model.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Dependency'. A dependency is a relationship that signifies that a single or a set of
 * model elements requires other model elements for their specification or implementation. This means that the complete semantics
 * of the depending elements is either semantically or structurally dependent on the definition of the supplier element(s).
 * 
 * @author Dieter Moroff
 */
public interface ModelDependencyBase extends ModelElementBase
{

   /**
    * Returns the 'Client' reference list.
    */
   Collection<ModelElementBase> getClients();

   /**
    * Returns the 'Supplier' reference list.
    */
   Collection<ModelElementBase> getSuppliers();
}
