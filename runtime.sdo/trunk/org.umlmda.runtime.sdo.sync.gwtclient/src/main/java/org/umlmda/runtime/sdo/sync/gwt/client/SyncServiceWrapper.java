package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.impl.ServiceCallWrapperImpl;
import org.umlmda.runtime.sdo.sync.parameter.AbstractParameter;
import org.umlmda.runtime.sdo.sync.parameter.ParameterUtil;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class SyncServiceWrapper implements org.umlmda.runtime.sdo.sync.SyncService {
    private static Logger logger = Logger.getLogger(SyncServiceWrapper.class);

    private final SyncServiceAsync serviceAsync = SyncServiceLocator.getInstance();
    private final SyncServiceCallback callback;

    public SyncServiceWrapper(SyncServiceCallback callback) {
        if (callback == null) {
            throw new NullPointerException("Callback can't be null...");
        }
        this.callback = callback;
    }

    public String startConversation() {
        throw new UnsupportedOperationException("StartConversation must be called on SyncServiceAsync directly");
    }

    public void finishConversation(String conversationId) {
        serviceAsync.finishConversation(conversationId, getAsyncCallback());
    }

    private AsyncCallback<Object> getAsyncCallback() {
        return new AsyncCallback<Object>() {
            public void onFailure(Throwable caught) {
                getCallback().onException(caught);
            }

            public void onSuccess(Object result) {
                getCallback().onSuccess();
            }
        };
    }

    public void invokeMethod(String conversationId, SynchronizedObjectProxy object, String methodName, Object[] parameters,
                    final ServiceCallWrapperImpl<AbstractInvocationResult> invokeCallback) {

        if (invokeCallback == null) {
            throw new IllegalStateException("invokeCallback not set");
        }
        logger.debug("serviceAsync started");

        List<AbstractParameter> paramList = ParameterUtil.toList(parameters);

        serviceAsync.invokeMethod(conversationId, object, methodName, paramList, new AsyncCallback<AbstractInvocationResult>() {
            public void onFailure(Throwable caught) {
                logger.debug("onFailure called");
                invokeCallback.onException(caught, callback);
            }

            public void onSuccess(AbstractInvocationResult result) {
                logger.debug("onSucess called");
                invokeCallback.onSucess(result, callback);
            }
        });

    }

    public void synchronizeChanges(String conversationId, List<AbstractChangeLogEntry> changes,
                    final ServiceCallWrapperImpl<List<AbstractChangeLogEntry>> synchronizeCallback) {
        if (synchronizeCallback == null) {
            throw new IllegalStateException("synchronizeCallback not set");
        }

        serviceAsync.synchronizeChanges(conversationId, changes, new AsyncCallback<List<AbstractChangeLogEntry>>() {
            public void onFailure(Throwable caught) {
                synchronizeCallback.onException(caught, callback);
            }

            public void onSuccess(List<AbstractChangeLogEntry> result) {
                synchronizeCallback.onSucess(result, callback);
            }
        });
    }

    public SyncServiceCallback getCallback() {
        return callback;
    }

}
