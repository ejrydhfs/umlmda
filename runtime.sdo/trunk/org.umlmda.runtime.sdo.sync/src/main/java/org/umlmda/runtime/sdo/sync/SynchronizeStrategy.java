package org.umlmda.runtime.sdo.sync;

import org.umlmda.runtime.bean.ActionCommand;

public interface SynchronizeStrategy {

   public static final SynchronizeStrategy COLLECT = new CollectUntilInvoke();
   
   /**
    * Action invoked on the recorder after recording a change.
    */
   public abstract void postRecordAction();
   
   /**
    * Strategy collection records until invoke occurs.
    */
   public static class CollectUntilInvoke implements SynchronizeStrategy {

      public void postRecordAction() {
         // Nothing to do
      }
   }
   
   /**
    * Immediately calls a method after recording any change
    */
   public static class ImmediateInvoke<T extends SynchronizedObject> implements SynchronizeStrategy {

      private final ActionCommand<T> command;
      
      public ImmediateInvoke(ActionCommand<T> command) {
         this.command = command;
      }

      @SuppressWarnings("unchecked")
      public void postRecordAction() {
         command.invoke();
      }
   }
}
