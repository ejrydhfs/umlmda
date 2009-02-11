/*
 * Created on 04.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ModelDependency extends ModelElement, ModelDependencyBase, ModelVisitable {
   
   /**
    * If the dependency has one one supplier the supplier is returned.
    * @return
    * @throws IllegalStateException
    * 	If more than one supplier exists
    */
   public ModelElement getSupplier();
}
