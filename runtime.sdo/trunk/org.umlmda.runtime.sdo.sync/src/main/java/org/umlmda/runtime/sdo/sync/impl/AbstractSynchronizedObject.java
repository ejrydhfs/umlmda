package org.umlmda.runtime.sdo.sync.impl;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;

public abstract class AbstractSynchronizedObject implements SynchronizedObject
{
   protected final transient Recorder recorder;
   private int                        recordObjectId;

   protected AbstractSynchronizedObject(Recorder recorder) {
      this(recorder, true);
   }

   protected AbstractSynchronizedObject(Recorder recorder, boolean recordCreation) {
      this.recorder = recorder;
      this.recorder.register(this, recordCreation);
   }

   public int getRecordObjectId() {
      return recordObjectId;
   }

   public void setRecordObjectId(int recordObjectId) {
      this.recordObjectId = recordObjectId;
   }

   public String getModelName() {
      throw new UnsupportedOperationException();
   }

   public String getModelVersion() {
      throw new UnsupportedOperationException();
   }

   public Recorder getRecorder() {
      return recorder;
   }

}
