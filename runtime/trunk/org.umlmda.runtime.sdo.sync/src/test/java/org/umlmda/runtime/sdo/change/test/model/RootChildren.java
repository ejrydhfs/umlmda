package org.umlmda.runtime.sdo.change.test.model;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.runtime.sdo.sync.SynchronizedListWrapper;
import org.umlmda.runtime.sdo.sync.Synchronizer;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

public class RootChildren extends AbstractSynchronizedObject {
   public final static String PROPERTY_STRING_ATTR = "stringAttr";
   private String stringAttr;
   private List<RootGreatChildren> rootGreatChildren = new SynchronizedListWrapper<RootGreatChildren>(recorder, new ArrayList<RootGreatChildren>());
   
   public RootChildren(Synchronizer recorder) {
      super(recorder);
   }

   public String getStringAttr() {
      return stringAttr;
   }

   public void setStringAttr(String value) {
      this.stringAttr = value;
      this.recorder.recordChange(this, PROPERTY_STRING_ATTR, value);
   }

   public List<RootGreatChildren> getRootGreatChildren() {
      return rootGreatChildren;
   }

}
