package org.umlmda.runtime.sdo.sync.internal;

import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.impl.ServiceCallWrapperImpl;

/**
 * The interface a service call implementation must inherit.
 * 
 * @author Marco Metzen
 */
public interface ServiceCall<TypeOfResult>
{
   void onExecute(ServiceCallWrapperImpl<TypeOfResult> wrapper);

   void onSucess(TypeOfResult result, SyncServiceCallback callback);

   void onException(Throwable throwable, SyncServiceCallback callback);
}
