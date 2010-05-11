package org.umlmda.runtime.sdo.sync;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

/**
 * Interface of the property change recorder
 * 
 * @author moroff
 */
public interface Recorder
{

   List<AbstractChangeLogEntry> getChangeEntries();

   void startRecording();

   boolean stopRecording();

   boolean isRecording();

   void register(SynchronizedObject recordedObject, boolean recordCreation);

   void recordNew(SynchronizedObject object);

   void recordChange(SynchronizedObject object, String propertyName, Object value);

   void recordAdd(SynchronizedList<?> list, Object value, int index);

   void recordRemove(SynchronizedCollection<?> collection, Object object);

   void recordRemoveIndex(SynchronizedList<?> list, int index, Object object);

   void recordAdd(SynchronizedSet<?> set, Object value);

   void recordClear(SynchronizedCollection<?> collection);

   /**
    * Invoke a method without parameters on the remote peer
    * 
    * @param method
    * @return
    */
   void recordInvoke(SynchronizedObject recordedObject, String string);

   /**
    * Invoke a method with parameters on the remote peer
    * 
    * @param method
    */
   void recordInvoke(SynchronizedObject recordedObject, String method, Object... parameters);

   void reset();

   void setSynchronizeStrategy(SynchronizeStrategy strategy);

   SynchronizeStrategy getSynchronizeStrategy();
}
