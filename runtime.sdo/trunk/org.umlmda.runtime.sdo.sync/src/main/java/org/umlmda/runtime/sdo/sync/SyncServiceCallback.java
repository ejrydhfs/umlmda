package org.umlmda.runtime.sdo.sync;

public interface SyncServiceCallback {
   public abstract void onSuccess();
   
   public abstract void onException(Throwable throwable);

}
