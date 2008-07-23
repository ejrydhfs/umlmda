package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.impl.ServiceCallWrapperImpl;

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
	public abstract void synchronizeChanges(List<AbstractChangeLogEntry> changes, ServiceCallWrapperImpl<List<AbstractChangeLogEntry>> callback);
	
	/**
	 * Invoke a method on the remote peer.
	 * @param object
	 * @param methodName
	 * @return
	 */
	public abstract void invokeMethod(SynchronizedObjectProxy object, String methodName, Object[] parameter, ServiceCallWrapperImpl<AbstractInvocationResult> callback);
	
	public abstract SyncServiceCallback getCallback();
}
