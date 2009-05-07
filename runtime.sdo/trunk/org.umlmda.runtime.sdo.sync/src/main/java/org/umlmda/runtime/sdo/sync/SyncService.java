package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.impl.ServiceCallWrapperImpl;

public interface SyncService {

   /**
    * Starts the conversation.
    */
   public String startConversation();

   /**
    * Finish the conversation. A new conversation can be started.
    * The old conversation id becomes invalid.
    *
    * If an invalid (non-existing) conversation id is specified, the call
    * will fail.
    *
    * @param conversationId unique conversation id
    */
   public void finishConversation(String conversationId);

   /**
    * Synchronize changes with remote peer.
    *
    * If an invalid (non-existing) conversation id is specified, the call
    * will fail.
    *
    * @param conversationId unique conversation id
    * @param changes
    * @param callback
    */
    public abstract void synchronizeChanges(String conversationId, List<AbstractChangeLogEntry> changes, ServiceCallWrapperImpl<List<AbstractChangeLogEntry>> callback);

    /**
     * Invoke a method on the remote peer.
     *
     * If an invalid (non-existing) conversation id is specified, this call
     * will fail.
     *
     * @param conversationId unique conversation id
     * @param object
     * @param methodName
     * @param parameters
     * @param callback
     */
    public abstract void invokeMethod(String conversationId, SynchronizedObjectProxy object, String methodName, Object[] parameter, ServiceCallWrapperImpl<AbstractInvocationResult> callback);

    //TODO do we need this ?
    public abstract SyncServiceCallback getCallback();
}
