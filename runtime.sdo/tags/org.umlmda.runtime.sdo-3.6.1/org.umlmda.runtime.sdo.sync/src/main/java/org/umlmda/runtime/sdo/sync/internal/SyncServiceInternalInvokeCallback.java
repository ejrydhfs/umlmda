/**
 * 
 */
package org.umlmda.runtime.sdo.sync.internal;

import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;

public interface SyncServiceInternalInvokeCallback {
      public abstract void onSucess(AbstractInvocationResult result, SyncServiceCallback callback);
      
      public abstract void onException(Throwable throwable, SyncServiceCallback callback);
   }