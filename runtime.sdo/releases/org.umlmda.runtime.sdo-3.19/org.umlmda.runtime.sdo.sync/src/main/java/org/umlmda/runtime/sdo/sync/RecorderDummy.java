package org.umlmda.runtime.sdo.sync;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

/**
 * Dummy implementation for test purposes.
 * 
 * @author Dieter Moroff
 */
public class RecorderDummy implements Recorder
{
   private List<AbstractChangeLogEntry> changeEntries = new ArrayList<AbstractChangeLogEntry>();
   private boolean                      recording     = true;

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#getChangeEntries()
    */
   public List<AbstractChangeLogEntry> getChangeEntries() {
      return changeEntries;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordAdd(org.umlmda.runtime.sdo.sync.SynchronizedList, java.lang.Object, int)
    */
   public void recordAdd(SynchronizedList<?> list, Object value, int index) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordAdd(org.umlmda.runtime.sdo.sync.SynchronizedSet, java.lang.Object)
    */
   public void recordAdd(SynchronizedSet<?> set, Object value) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordChange(org.umlmda.runtime.sdo.sync.SynchronizedObject, java.lang.String,
    * java.lang.Object)
    */
   public void recordChange(SynchronizedObject object, String propertyName, Object value) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordClear(org.umlmda.runtime.sdo.sync.SynchronizedCollection)
    */
   public void recordClear(SynchronizedCollection<?> collection) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordInvoke(org.umlmda.runtime.sdo.sync.SynchronizedObject, java.lang.String)
    */
   public void recordInvoke(SynchronizedObject recordedObject, String string) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordInvoke(org.umlmda.runtime.sdo.sync.SynchronizedObject, java.lang.String,
    * java.lang.Object[])
    */
   public void recordInvoke(SynchronizedObject recordedObject, String method, Object... parameters) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordNew(org.umlmda.runtime.sdo.sync.SynchronizedObject)
    */
   public void recordNew(SynchronizedObject object) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#recordRemove(org.umlmda.runtime.sdo.sync.SynchronizedCollection, java.lang.Object)
    */
   public void recordRemove(SynchronizedCollection<?> collection, Object object) {
   }

   public void recordRemoveIndex(SynchronizedList<?> list, int index, Object object) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#register(org.umlmda.runtime.sdo.sync.SynchronizedObject, boolean)
    */
   public void register(SynchronizedObject recordedObject, boolean recordCreation) {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#reset()
    */
   public void reset() {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#startRecording()
    */
   public void startRecording() {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.Recorder#stopRecording()
    */
   public boolean stopRecording() {
      if ( recording ) {
         recording = false;
         return true;
      }
      else {
         return false;
      }
   }

   public boolean isRecording() {
      return recording;
   }

   public boolean isInvocationRunning() {
      return false;
   }
   
   public void setSynchronizeStrategy(SynchronizeStrategy strategy) {
   }

   public SynchronizeStrategy getSynchronizeStrategy() {
      return null;
   }

}
