package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.parameter.AbstractParameter;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SyncServiceAsync {
   /** 
    * Start the conversation
    */
   @SuppressWarnings("unchecked")
   public void startConversation(AsyncCallback callback);
   
   /**
    * Finish the conversation. A new conversation can be started.
    */
   @SuppressWarnings("unchecked")
   public void finishConversation(AsyncCallback callback);

   
	public void synchronizeChanges(List<AbstractChangeLogEntry> changes, AsyncCallback<List<AbstractChangeLogEntry>> callback);
	
   /**
    * Invoke a method on the remote peer.
    * @param object
    * @param methodName
    * @return
    */
   public void invokeMethod(SynchronizedObjectProxy object, String methodName, List<AbstractParameter> parameters, AsyncCallback<AbstractInvocationResult> callback);
	
}
