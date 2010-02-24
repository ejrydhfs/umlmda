package org.umlmda.runtime.sdo.sync.test.gwt.client.model.impl.delegate;

import org.umlmda.runtime.bean.NotificationChain;
import org.umlmda.runtime.bean.IPropertyChangeSupport;
import org.umlmda.runtime.bean.PropertyChangeSupportHelper;
import org.umlmda.runtime.sdo.sync.test.gwt.client.model.RootChildren;
import org.umlmda.runtime.sdo.sync.test.gwt.client.model.RootClass;
import org.umlmda.runtime.sdo.sync.test.gwt.client.model.RootClassDelegate;

/**
 * Implementation for none generated methods and derived attributes of
 * org.umlmda.runtime.sdo.sync.test.RootClass.
 * @see RootClass
 */
public class RootClassDelegateImpl implements RootClassDelegate {
   private final RootClass businessObject;
   @SuppressWarnings("unused")
   private NotificationChain chain;

   public RootClassDelegateImpl(RootClass businessObject, PropertyChangeSupportHelper propertyChangeSupport) {
      this.businessObject = businessObject;

      chain = new NotificationChain(propertyChangeSupport, RootClass.PROPERTY_FIRST_CHILD, RootClass.PROPERTY_ROOT_CHILDREN);
   }

   public RootChildren getFirstChild() {
      return businessObject.getRootChildren().size() > 0 ? 
              (RootChildren)businessObject.getRootChildren().get(0)
           :
              null;
   }
}
