package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;

public interface SyncService {
   public interface InternalInvokeCallback {
      public abstract void onSucess(AbstractInvocationResult result, SyncServiceCallback callback);
      
      public abstract void onException(Throwable throwable, SyncServiceCallback callback);
   }

   public interface InternalSynchronizeCallback {
      public abstract void onSucess(List<AbstractChangeLogEntry> result, SyncServiceCallback callback);
      
      public abstract void onException(Throwable throwable, SyncServiceCallback callback);
   }

   /**
    * Synchronize changes with remote peer
    * @param changes
    * @return
    */
	public abstract void synchronizeChanges(List<AbstractChangeLogEntry> changes, InternalSynchronizeCallback callback);
	
	/**
	 * Invoke a method on the remote peer.
	 * @param object
	 * @param methodName
	 * @return
	 */
	public abstract void invokeMethod(SynchronizedObjectProxy object, String methodName, InternalInvokeCallback callback);
	
	public abstract SyncServiceCallback getCallback();
}
