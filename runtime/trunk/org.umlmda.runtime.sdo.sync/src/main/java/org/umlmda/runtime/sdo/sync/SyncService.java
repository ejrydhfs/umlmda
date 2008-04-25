package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.internal.SyncServiceInternalInvokeCallback;
import org.umlmda.runtime.sdo.sync.internal.SyncServiceInternalSynchronizeCallback;

public interface SyncService {
   /** 
    * Start the conversation
    */
   public void startConversation();
   
   /**
    * Finish the conversation. A new conversation can be started.
    */
   public void finishConversation();

   /**
    * Synchronize changes with remote peer
    * @param changes
    * @return
    */
	public abstract void synchronizeChanges(List<AbstractChangeLogEntry> changes, SyncServiceInternalSynchronizeCallback callback);
	
	/**
	 * Invoke a method on the remote peer.
	 * @param object
	 * @param methodName
	 * @return
	 */
	public abstract void invokeMethod(SynchronizedObjectProxy object, String methodName, SyncServiceInternalInvokeCallback callback);
	
	public abstract SyncServiceCallback getCallback();
}
