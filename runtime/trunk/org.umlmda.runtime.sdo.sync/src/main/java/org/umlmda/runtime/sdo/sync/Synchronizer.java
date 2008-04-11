package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;


/**
 * Interface of the property change recorder
 * @author moroff
 *
 */
public interface Synchronizer {

   public abstract List<AbstractChangeLogEntry>   getChangeEntries();
   
   public abstract void startRecording();

   public abstract void stopRecording();
   
   public abstract void register(SynchronizedObject recordedObject, boolean recordCreation);

   public abstract void recordNew(SynchronizedObject object);
   
   public abstract void recordChange(SynchronizedObject object, String propertyName, Object value);
   
   public abstract void recordAdd(SynchronizedList<?> list, Object value, int index);
   
   public abstract void recordRemove(SynchronizedList<?> list, int index);
   
   @SuppressWarnings("unchecked")
   public abstract void recordAdd(SynchronizedSet set, Object value);
   
   @SuppressWarnings("unchecked")
   public abstract void recordRemove(SynchronizedSet set, Object value);
      
   @SuppressWarnings("unchecked")
   public abstract void recordClear(SynchronizedCollection collection);

   
}
