package org.umlmda.runtime.sdo.change.test.model;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.runtime.sdo.sync.SynchronizedListWrapper;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

public class RootClass extends AbstractSynchronizedObject implements SynchronizedObject {
   public final static String PROPERTY_ROOT_CHILD = "rootChild";
   
   private RootChild rootChild;
   private List<RootChildren> rootChildren = new SynchronizedListWrapper<RootChildren>(recorder, new ArrayList<RootChildren>());
   
   public RootClass(Recorder recorder) {
      super(recorder);
   }

   public RootChild getRootChild() {
      return rootChild;
   }

   public void setRootChild(RootChild rootChild) {
      this.rootChild = rootChild;
      recorder.recordChange(this, PROPERTY_ROOT_CHILD, rootChild);
   }

   public List<RootChildren> getRootChildren() {
      return rootChildren;
   }
   
   
}
