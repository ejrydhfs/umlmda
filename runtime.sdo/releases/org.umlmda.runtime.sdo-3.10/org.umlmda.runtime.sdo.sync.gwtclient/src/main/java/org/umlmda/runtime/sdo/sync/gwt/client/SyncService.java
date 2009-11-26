package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.parameter.AbstractParameter;

import com.google.gwt.user.client.rpc.RemoteService;

public interface SyncService extends RemoteService {

    /**
     * Starts the conversation and returns a unique conversation id.
     */
    public String startConversation();

    /**
     * Finish the conversation. A new conversation can be started. The old
     * conversation id becomes invalid.
     *
     * If an invalid (non-existing) conversation id is specified, the call will
     * fail.
     *
     * @param conversationId
     *            unique conversation id
     */
    public void finishConversation(String conversationId);

    /**
     * Synchronize changes with remote peer.
     *
     * If an invalid (non-existing) conversation id is specified, the call will
     * fail.
     *
     * @param conversationId
     *            unique conversation id
     * @param changes
     * @param callback
     */

    public List<AbstractChangeLogEntry> synchronizeChanges(String conversationId, List<AbstractChangeLogEntry> changes);

    /**
     * Invoke a method on the remote peer.
     *
     * @param object
     * @param methodName
     * @return
     */

    public AbstractInvocationResult invokeMethod(String conversationId, SynchronizedObjectProxy object, String methodName, List<AbstractParameter> parameters);

}
