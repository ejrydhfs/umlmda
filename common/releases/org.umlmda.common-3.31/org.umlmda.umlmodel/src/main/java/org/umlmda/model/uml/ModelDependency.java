/*
 * Created on 04.11.2005
 */
package org.umlmda.model.uml;

/**
 * @author MOROFF
 */
public interface ModelDependency extends ModelElement, ModelDependencyBase, ModelVisitable
{

   /**
    * If the dependency has one one supplier the supplier is returned.
    * 
    * @return
    * @throws IllegalStateException
    *            If more than one supplier exists
    */
   ModelElement getSupplier();
}
