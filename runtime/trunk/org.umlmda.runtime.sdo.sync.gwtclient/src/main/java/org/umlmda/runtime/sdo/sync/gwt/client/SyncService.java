package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;

import com.google.gwt.user.client.rpc.RemoteService;

public interface SyncService extends RemoteService {
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
	public List<AbstractChangeLogEntry> synchronizeChanges(List<AbstractChangeLogEntry> changes);
	
	/**
	 * Invoke a method on the remote peer.
	 * @param object
	 * @param methodName
	 * @return
	 */
	public AbstractInvocationResult invokeMethod(SynchronizedObjectProxy object, String methodName);
}
