package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.internal.SyncServiceInternalInvokeCallback;
import org.umlmda.runtime.sdo.sync.internal.SyncServiceInternalSynchronizeCallback;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class SyncServiceWrapper implements org.umlmda.runtime.sdo.sync.SyncService {

   private final SyncServiceAsync serviceAsync = SyncServiceLocator.getInstance();
   private final SyncServiceCallback callback;

   public SyncServiceWrapper(SyncServiceCallback callback) {
      this.callback = callback;
   }
   
   @SuppressWarnings("unchecked")
   public void startConversation() {
      serviceAsync.startConversation(new AsyncCallback() {

         public void onFailure(Throwable caught) {
            getCallback().onException(caught);
         }

         public void onSuccess(Object result) {
            getCallback().onSuccess();
         }});
   }
   
   @SuppressWarnings("unchecked")
   public void finishConversation() {
      serviceAsync.finishConversation(new AsyncCallback() {

         public void onFailure(Throwable caught) {
            getCallback().onException(caught);
         }

         public void onSuccess(Object result) {
            getCallback().onSuccess();
         }});
   }
   
   public void invokeMethod(SynchronizedObjectProxy object, String methodName, final SyncServiceInternalInvokeCallback invokeCallback) {
      if ( invokeCallback == null ) {
         throw new IllegalStateException("invokeCallback not set");
      }
      serviceAsync.invokeMethod(object, methodName, new AsyncCallback<AbstractInvocationResult>(){

         public void onFailure(Throwable caught) {
            invokeCallback.onException(caught, callback);
         }

         public void onSuccess(AbstractInvocationResult result) {
            invokeCallback.onSucess(result, callback);
         }});
   }

   public void synchronizeChanges(List<AbstractChangeLogEntry> changes, final SyncServiceInternalSynchronizeCallback synchronizeCallback) {
      if ( synchronizeCallback == null ) {
         throw new IllegalStateException("synchronizeCallback not set");
      }
      serviceAsync.synchronizeChanges(changes, new AsyncCallback<List<AbstractChangeLogEntry>>() {

         public void onFailure(Throwable caught) {
            synchronizeCallback.onException(caught, callback);
         }

         public void onSuccess(List<AbstractChangeLogEntry> result) {
            synchronizeCallback.onSucess(result, callback);
         }});
   }

   public SyncServiceCallback getCallback() {
      return callback;
   }
}
