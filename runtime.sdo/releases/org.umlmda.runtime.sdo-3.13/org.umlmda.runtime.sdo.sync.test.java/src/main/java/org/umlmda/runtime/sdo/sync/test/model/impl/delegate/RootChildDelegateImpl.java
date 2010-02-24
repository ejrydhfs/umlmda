package org.umlmda.runtime.sdo.sync.test.model.impl.delegate;

import org.umlmda.runtime.sdo.sync.test.model.RootChild;
import org.umlmda.runtime.sdo.sync.test.model.RootChildDelegate;
import org.umlmda.runtime.sdo.sync.test.model.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.test.model.TestFactory;
import org.umlmda.runtime.sdo.sync.test.model.impl.RootChildImpl;
import org.umlmda.runtime.sdo.sync.test.model.impl.TestFactoryImpl;

/**
 * Implementation for none generated methods and derived attributes of
 * org.umlmda.runtime.sdo.sync.test.RootChild.
 * @see RootChild
 */
public class RootChildDelegateImpl implements RootChildDelegate {
   private final RootChildImpl businessObject;

   public RootChildDelegateImpl(RootChild businessObject) {
      this.businessObject = (RootChildImpl) businessObject;
   }

   public void serverMethod() {
      TestFactory factory = new TestFactoryImpl(businessObject.getRecorder());
      
      RootGreatChildren greatChildren = factory.createRootGreatChildren();
      
      businessObject.setGreatChildren(greatChildren);
      
//      greatChildren.setIntAttr(42);
   }

   public void init() {
      // TODO Auto-generated method stub
      
   }
}
