package org.umlmda.runtime.sdo.sync.impl;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.runtime.sdo.sync.SynchronizedCollection;
import org.umlmda.runtime.sdo.sync.SynchronizedList;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedSet;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeEntry;
import org.umlmda.runtime.sdo.sync.entries.ListAddEntry;
import org.umlmda.runtime.sdo.sync.entries.NewEntry;

public class SynchronizerImpl implements Recorder {
   private List<AbstractChangeLogEntry> changeEntries = new ArrayList<AbstractChangeLogEntry>();
   private int recordedObjectCount = 0;
   private boolean recording = true;
   
   public SynchronizerImpl() {
   }

   public synchronized List<AbstractChangeLogEntry> getChangeEntries() {
      return changeEntries;
   }

   public void register(SynchronizedObject recordedObject, boolean recordCreation) {
      recordedObject.setRecordObjectId(getNextRecordObjectId());
      if ( recordCreation ) {
         recordNew(recordedObject);
      }
   }

   public synchronized void recordAdd(SynchronizedList<?> list, Object value, int index) {
      if ( recording ) {
         changeEntries.add(new ListAddEntry(list.getRecordObjectId(), value, index));
      }
   }

   public synchronized void recordAdd(SynchronizedSet set, Object value) {
      // TODO Auto-generated method stub

   }

   public synchronized void recordChange(SynchronizedObject object, String propertyName, Object value) {
      if ( recording ) {
         changeEntries.add(new ChangeEntry(object.getRecordObjectId(), propertyName, value));
      }
   }

   public synchronized void recordClear(SynchronizedCollection collection) {
      // TODO Auto-generated method stub

   }

   public synchronized void recordNew(SynchronizedObject object) {
      if ( recording ) {
         changeEntries.add(new NewEntry(object.getRecordObjectId(), object.getClass()));
      }
   }

   public synchronized void recordRemove(SynchronizedList<?> list, int index) {
      // TODO Auto-generated method stub

   }

   public synchronized void recordRemove(SynchronizedSet set, Object value) {
      // TODO Auto-generated method stub

   }

   public synchronized void startRecording() {
      recording = true;
   }

   public synchronized void stopRecording() {
      recording = false;
   }

   private synchronized int getNextRecordObjectId() {
      return ++recordedObjectCount;
   }
}
