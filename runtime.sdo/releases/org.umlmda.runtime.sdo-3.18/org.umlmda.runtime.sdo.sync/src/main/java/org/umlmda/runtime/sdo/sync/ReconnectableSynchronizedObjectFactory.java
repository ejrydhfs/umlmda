package org.umlmda.runtime.sdo.sync;

public interface ReconnectableSynchronizedObjectFactory extends SynchronizedObjectFactory
{

   void setRecorder(Recorder slaveRecorder);

}
