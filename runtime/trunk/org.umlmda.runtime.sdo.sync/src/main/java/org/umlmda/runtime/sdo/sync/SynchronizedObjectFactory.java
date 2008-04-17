package org.umlmda.runtime.sdo.sync;

import java.io.Serializable;

public interface SynchronizedObjectFactory extends Serializable {

   public abstract SynchronizedObject create(String className);

   public abstract Recorder getRecorder();
   
}
