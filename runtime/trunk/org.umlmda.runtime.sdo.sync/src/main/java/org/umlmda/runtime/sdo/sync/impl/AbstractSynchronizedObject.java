package org.umlmda.runtime.sdo.sync.impl;

import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.Synchronizer;

public class AbstractSynchronizedObject implements SynchronizedObject {
   protected final transient Synchronizer recorder;
   private int recordObjectId;

   protected AbstractSynchronizedObject(Synchronizer recorder) {
      this(recorder, true);
   }

   protected AbstractSynchronizedObject(Synchronizer recorder, boolean recordCreation) {
      this.recorder = recorder;
      this.recorder.register(this, recordCreation);
   }

   public int getRecordObjectId() {
      return recordObjectId;
   }

   public void setRecordObjectId(int recordObjectId) {
      this.recordObjectId = recordObjectId;
   }
}
