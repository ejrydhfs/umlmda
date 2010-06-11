package org.umlmda.runtime.sdo.sync.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.sync.internal.ServiceCall;
import org.umlmda.runtime.sdo.sync.internal.ServiceQueueListener;

/**
 * The service queue implements the behaviour of starting asynchronous service calls in a synchronous sequentiell way.
 * 
 * @author Marco Metzen
 */
@SuppressWarnings("unchecked")
public class ServiceQueue implements ServiceQueueListener
{
   private List<ServiceCallWrapperImpl> entries;
   private static Logger                logger = Logger.getLogger(ServiceQueue.class);

   /**
    * this method adds a ServiceCall to the queue. The ServiceCall must implement the execute, success and failure event and gets
    * wrapped by ServiceCallWrapperImpl which notifies the listener to start the next service in the queue after a successful
    * service call.
    * 
    * @param serviceCall
    *           the implementation of a service call.
    */
   public void addServiceCall(ServiceCall<?> serviceCall) {
      if ( null == entries ) {
         entries = new ArrayList<ServiceCallWrapperImpl>();
      }
      ServiceCallWrapperImpl abstractCall = new ServiceCallWrapperImpl();
      abstractCall.setListener(this);
      abstractCall.setServiceCall(serviceCall);
      entries.add(abstractCall);
   }

   /**
    * executes the services in the queue.
    */
   public void execute() {
      if ( null != entries && entries.size() > 0 ) {
         onServiceSuccess();
      }
   }

   /**
    * gets triggered when a service call fails.
    */
   public void onServiceFailure() {
      logger.error("onServiceFailure triggered");
   }

   /**
    * gets triggered when a service call is successful and starts the next service in the queue.
    */
   public void onServiceSuccess() {
      if ( logger.isDebugEnabled() ) {
         logger.debug("onServiceSuccess triggered");
      }

      if ( entries.size() > 0 ) {
         ServiceCallWrapperImpl call = entries.get(0);
         call.execute();
         entries.remove(0);
      }
   }
}
