package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;


/**
 * Interface of the property change recorder
 * @author moroff
 *
 */
public interface Recorder {

   public abstract List<AbstractChangeLogEntry>   getChangeEntries();
   
   public abstract void startRecording();

   public abstract boolean stopRecording();
   
   public abstract boolean isRecording();
   
   public abstract void register(SynchronizedObject recordedObject, boolean recordCreation);

   public abstract void recordNew(SynchronizedObject object);
   
   public abstract void recordChange(SynchronizedObject object, String propertyName, Object value);
   
   public abstract void recordAdd(SynchronizedList<?> list, Object value, int index);
   
   public abstract void recordRemove(SynchronizedCollection<?> collection, Object object);
   
   public abstract void recordRemoveIndex(SynchronizedList<?> list, int index, Object object);
   
   public abstract void recordAdd(SynchronizedSet<?> set, Object value);
   
   public abstract void recordClear(SynchronizedCollection<?> collection);

   /**
    * Invoke a method without parameters on the remote peer
    * @param method
    * @return
    */
   public abstract void recordInvoke(SynchronizedObject recordedObject, String string);
   
   /**
    * Invoke a method with parameters on the remote peer
    * @param method
    */
   public abstract void recordInvoke(SynchronizedObject recordedObject, String method, Object... parameters);

   public abstract void reset();
   
   public abstract void setSynchronizeStrategy(SynchronizeStrategy strategy);
}
