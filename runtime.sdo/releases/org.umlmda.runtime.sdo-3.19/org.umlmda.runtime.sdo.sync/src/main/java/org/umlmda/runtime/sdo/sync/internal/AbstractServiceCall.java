package org.umlmda.runtime.sdo.sync.internal;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.impl.ServiceCallWrapperImpl;

/**
 * Abstract implementation of a service call.
 * 
 * @author Marco Metzen
 */
public abstract class AbstractServiceCall<TypeOfResult> implements ServiceCall<TypeOfResult>
{
   private static final Logger logger = Logger.getLogger(AbstractServiceCall.class);

   public void onException(Throwable throwable, SyncServiceCallback callback) {
      if ( callback != null ) {
         callback.onException(throwable);
      }
      else {
         logger.error(throwable.getMessage(), throwable);
      }
   }

   public abstract void onExecute(ServiceCallWrapperImpl<TypeOfResult> wrapper);

   public abstract void onSucess(TypeOfResult result, SyncServiceCallback callback);

}
