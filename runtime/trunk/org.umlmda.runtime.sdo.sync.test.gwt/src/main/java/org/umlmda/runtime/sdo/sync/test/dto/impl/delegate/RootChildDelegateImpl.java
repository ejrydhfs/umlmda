package org.umlmda.runtime.sdo.sync.test.dto.impl.delegate;

import org.umlmda.runtime.sdo.sync.test.dto.RootChild;
import org.umlmda.runtime.sdo.sync.test.dto.RootChildDelegate;
import java.beans.PropertyChangeSupport;

/**
 * Implementation for none generated methods and derived attributes of
 * org.umlmda.runtime.sdo.sync.test.RootChild.
 * @see RootChild
 */
public class RootChildDelegateImpl implements RootChildDelegate {
   private final RootChild businessObject;

   public RootChildDelegateImpl(RootChild businessObject, PropertyChangeSupport propertyChangeSupport) {
      this.businessObject = businessObject;
   }

   public void serverMethod() {
      // TODO Auto-generated method stub
      
   }
}
