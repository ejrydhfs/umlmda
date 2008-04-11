package org.umlmda.runtime.sdo.change.test.model;

import org.umlmda.runtime.sdo.sync.Synchronizer;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

public class RootChild extends AbstractSynchronizedObject {
   public static final String PROPERTY_GREAT_CHILDREN = "greatChildren";
   private RootGreatChildren greatChildren;
   
   public RootChild(Synchronizer recorder) {
      super(recorder);
   }

   public RootGreatChildren getGreatChildren() {
      return greatChildren;
   }

   public void setGreatChildren(RootGreatChildren greatChildren) {
      this.greatChildren = greatChildren;
      this.recorder.recordChange(this, PROPERTY_GREAT_CHILDREN, greatChildren);
   }

}
