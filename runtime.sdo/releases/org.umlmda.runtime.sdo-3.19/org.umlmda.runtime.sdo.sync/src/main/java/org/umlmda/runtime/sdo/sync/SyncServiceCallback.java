package org.umlmda.runtime.sdo.sync;

public interface SyncServiceCallback
{
   void onSuccess();

   void onException(Throwable throwable);

}
