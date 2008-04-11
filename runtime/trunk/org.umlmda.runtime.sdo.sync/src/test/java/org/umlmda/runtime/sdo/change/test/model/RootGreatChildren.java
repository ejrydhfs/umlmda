package org.umlmda.runtime.sdo.change.test.model;

import org.umlmda.runtime.sdo.sync.Synchronizer;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

public class RootGreatChildren extends AbstractSynchronizedObject {
   public final static String PROPERTY_STRING_ATTR = "stringAttr";
   private String stringAttr;
   
   public RootGreatChildren(Synchronizer recorder) {
      super(recorder);
   }

   public String getStringAttr() {
      return stringAttr;
   }

   public void setStringAttr(String value) {
      this.stringAttr = value;
      this.recorder.recordChange(this, PROPERTY_STRING_ATTR, value);
   }

}
