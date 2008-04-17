package org.umlmda.runtime.sdo.sync.test.dto.impl.delegate;

import org.umlmda.runtime.bean.NotificationChain;
import org.umlmda.runtime.sdo.sync.test.dto.RootChildren;
import org.umlmda.runtime.sdo.sync.test.dto.RootChildrenDelegate;
import java.beans.PropertyChangeSupport;

/**
 * Implementation for none generated methods and derived attributes of
 * org.umlmda.runtime.sdo.sync.test.RootChildren.
 * @see RootChildren
 */
public class RootChildrenDelegateImpl implements RootChildrenDelegate {
   private final RootChildren businessObject;
   @SuppressWarnings("unused")
   private final NotificationChain chain;

   public RootChildrenDelegateImpl(RootChildren businessObject, PropertyChangeSupport propertyChangeSupport) {
      this.businessObject = businessObject;
      
      chain = new NotificationChain(propertyChangeSupport, RootChildren.PROPERTY_DERIVED_STRING_ATTR, RootChildren.PROPERTY_STRING_ATTR);
   }

   public String getDerivedStringAttr() {
      return businessObject.getStringAttr();
   }
}
