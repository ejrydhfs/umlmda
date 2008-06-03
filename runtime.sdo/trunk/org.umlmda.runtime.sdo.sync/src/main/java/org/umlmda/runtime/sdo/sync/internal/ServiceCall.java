package org.umlmda.runtime.sdo.sync.internal;

import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.impl.ServiceCallWrapperImpl;

/**
 * The interface a service call implementation must inherit.
 * 
 * @author Marco Metzen
 *
 */
public interface ServiceCall<TypeOfResult>
{
   public abstract void onExecute(ServiceCallWrapperImpl<TypeOfResult> wrapper);
   
   public abstract void onSucess(TypeOfResult result, SyncServiceCallback callback);

   public abstract void onException(Throwable throwable, SyncServiceCallback callback);   
}
