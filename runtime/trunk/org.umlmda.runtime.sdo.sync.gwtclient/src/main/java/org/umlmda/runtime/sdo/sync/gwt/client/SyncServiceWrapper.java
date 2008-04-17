package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.SyncService;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class SyncServiceWrapper implements org.umlmda.runtime.sdo.sync.SyncService {

   private final SyncServiceAsync serviceAsync = SyncServiceLocator.getInstance();
   private final SyncService.Callback callback;

   public SyncServiceWrapper(SyncService.Callback callback) {
      this.callback = callback;
   }
   
   public void invokeMethod(SynchronizedObjectProxy object, String methodName, final SyncService.InternalInvokeCallback invokeCallback) {
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

   public void synchronizeChanges(List<AbstractChangeLogEntry> changes, final SyncService.InternalSynchronizeCallback synchronizeCallback) {
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

   public Callback getCallback() {
      return callback;
   }
}
