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
    void startConversation(AsyncCallback callback);

    /**
     * Finish the conversation. A new conversation can be started.
     */
    @SuppressWarnings("unchecked")
    void finishConversation(String conversationId, AsyncCallback callback);

    void synchronizeChanges(String conversationId, List<AbstractChangeLogEntry> changes, AsyncCallback<List<AbstractChangeLogEntry>> callback);

    /**
     * Invoke a method on the remote peer.
     *
     * @param object
     * @param methodName
     * @return
     */
    void invokeMethod(String conversationId, SynchronizedObjectProxy object, String methodName, List<AbstractParameter> parameters, AsyncCallback<AbstractInvocationResult> callback);

}
