/**
 * 
 */
package org.umlmda.runtime.sdo.sync.internal;

import java.util.List;

import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

public interface SyncServiceInternalSynchronizeCallback {
      public abstract void onSucess(List<AbstractChangeLogEntry> result, SyncServiceCallback callback);
      
      public abstract void onException(Throwable throwable, SyncServiceCallback callback);
   }