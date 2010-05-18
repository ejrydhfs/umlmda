package org.umlmda.runtime.sdo.sync.test.model.impl.delegate;

import org.umlmda.runtime.sdo.sync.test.model.RootClass;
import org.umlmda.runtime.sdo.sync.test.model.RootClassDelegate;
import java.beans.PropertyChangeSupport;

/**
 * Implementation for none generated methods and derived attributes of
 * org.umlmda.runtime.sdo.sync.test.RootClass.
 * @see RootClass
 */
public class RootClassDelegateImpl implements RootClassDelegate {
   private final RootClass businessObject;

   public RootClassDelegateImpl(RootClass businessObject) {
      this.businessObject = businessObject;
   }
}
