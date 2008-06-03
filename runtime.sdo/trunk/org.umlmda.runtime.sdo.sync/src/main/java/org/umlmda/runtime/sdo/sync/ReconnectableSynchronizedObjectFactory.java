package org.umlmda.runtime.sdo.sync;


public interface ReconnectableSynchronizedObjectFactory extends SynchronizedObjectFactory {

   public abstract void setRecorder(Recorder slaveRecorder);
   
   
}
