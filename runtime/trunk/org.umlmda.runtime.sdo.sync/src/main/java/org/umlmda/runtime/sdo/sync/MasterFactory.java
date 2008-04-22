package org.umlmda.runtime.sdo.sync;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.runtime.model.ModeledElementProxy;

public class MasterFactory implements ReconnectableSynchronizedObjectFactory {

   private static final long serialVersionUID = 100L;
   private List<ReconnectableSynchronizedObjectFactory> factories = new ArrayList<ReconnectableSynchronizedObjectFactory>();
   private Recorder recorder;

   public MasterFactory(Recorder recorder) {
      this.recorder = recorder;
   }
   
   public void setRecorder(Recorder recorder) {
      this.recorder = recorder;
      
      for (ReconnectableSynchronizedObjectFactory factory : factories) {
         factory.setRecorder(recorder);
      }
   }

   public SynchronizedObject create(ModeledElementProxy elementProxy) {
      for (ReconnectableSynchronizedObjectFactory factory : factories) {
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

   public void registerFactory(ReconnectableSynchronizedObjectFactory factory) {
      factories.add(factory);
   }
}
