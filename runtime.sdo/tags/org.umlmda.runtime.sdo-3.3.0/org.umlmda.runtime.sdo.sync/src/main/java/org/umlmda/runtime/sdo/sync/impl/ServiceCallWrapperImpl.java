package org.umlmda.runtime.sdo.sync.impl;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.internal.ServiceCall;
import org.umlmda.runtime.sdo.sync.internal.ServiceQueueListener;

/**
 * This class wraps a service call and notifies the queue listener
 * to of a successful or failed service call.
 * 
 * @author Marco Metzen
 *
 */
public class ServiceCallWrapperImpl<TypeOfResult>
{
   private ServiceCall<TypeOfResult> _callback;
   private ServiceQueueListener      _listener;
   private static Logger             logger = Logger.getLogger(ServiceCallWrapperImpl.class);

   public void onSucess(TypeOfResult result, SyncServiceCallback callback) {
      if (logger.isDebugEnabled()) {
         logger.debug("onSucess on wrapper called");
      }
      _callback.onSucess(result, callback);
      _listener.onServiceSuccess();
   }

   public void onException(Throwable throwable, SyncServiceCallback callback) {
      if (logger.isDebugEnabled()) {
         logger.debug("onException on wrapper called");
      }
      _callback.onException(throwable, callback);
      _listener.onServiceFailure();
   }

   public void execute() {
      if (logger.isDebugEnabled()) {
         logger.debug("execute on wrapper called");
      }
      if ( null != _callback && null != _listener ) {
         _callback.onExecute(this);
      }
   }

   public void setListener(ServiceQueueListener listener) {
      _listener = listener;
   }

   public void setServiceCall(ServiceCall<TypeOfResult> serviceCall) {
      _callback = serviceCall;
   }
}
