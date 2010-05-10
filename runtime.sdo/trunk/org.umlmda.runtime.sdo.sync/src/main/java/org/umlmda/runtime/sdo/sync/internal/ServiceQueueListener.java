package org.umlmda.runtime.sdo.sync.internal;

/**
 * The interface an implementation of a service queue listener must inherit.
 * 
 * @author Marco Metzen
 */
public interface ServiceQueueListener
{
   void onServiceSuccess();

   void onServiceFailure();
}
