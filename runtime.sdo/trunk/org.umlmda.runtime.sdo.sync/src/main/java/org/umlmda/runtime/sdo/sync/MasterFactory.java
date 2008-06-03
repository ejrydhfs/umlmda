package org.umlmda.runtime.sdo.sync;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.runtime.model.ModeledElementProxy;

public class MasterFactory implements ReconnectableSynchronizedObjectFactory {

   private static final long serialVersionUID = 100L;
   private List<SynchronizedObjectFactory> factories = new ArrayList<SynchronizedObjectFactory>();
   private Recorder recorder;

   public MasterFactory(Recorder recorder) {
      this.recorder = recorder;
   }
   
   public void setRecorder(Recorder recorder) {
      throw new IllegalArgumentException("Don't use any more");
   }

   public SynchronizedObject create(ModeledElementProxy elementProxy) {
      for (SynchronizedObjectFactory factory : factories) {
         try {
            SynchronizedObject object = factory.create(elementProxy);
            
            if ( object != null ) {
               return object;
            }
         }
         catch (IllegalArgumentException e) {
            // Ok, look in next factory
         }
      }
      
      throw new IllegalArgumentException(elementProxy.getModelName());
   }

   public Recorder getRecorder() {
      return recorder;
   }

   public void registerFactory(SynchronizedObjectFactory factory) {
      factories.add(factory);
   }
}
