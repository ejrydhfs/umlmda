package org.umlmda.runtime.sdo.sync.impl;

import java.util.ArrayList;
import java.util.List;

import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SyncService;
import org.umlmda.runtime.sdo.sync.SynchronizedCollection;
import org.umlmda.runtime.sdo.sync.SynchronizedList;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.SynchronizedSet;
import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.SyncService.InternalInvokeCallback;
import org.umlmda.runtime.sdo.sync.SyncService.InternalSynchronizeCallback;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.entries.ChangeObjectEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeStringEntry;
import org.umlmda.runtime.sdo.sync.entries.ListAddEntry;
import org.umlmda.runtime.sdo.sync.entries.NewEntry;
import org.umlmda.runtime.sdo.sync.entries.SetAddEntry;

public class SynchronizerImpl implements Recorder {
   private List<AbstractChangeLogEntry> changeEntries = new ArrayList<AbstractChangeLogEntry>();
   private int recordedObjectCount = 0;
   private boolean recording = true;
   private final SyncService service;
   private Player player;
   
   public SynchronizerImpl(SyncService service) {
      this.service = service;
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

   public synchronized void recordAdd(SynchronizedSet<?> set, Object value) {
      if ( recording ) {
         changeEntries.add(new SetAddEntry(set.getRecordObjectId(), value));
      }
   }

   public synchronized void recordChange(SynchronizedObject object, String propertyName, Object value) {
      if ( recording ) {
         if (value instanceof String) {
            changeEntries.add(new ChangeStringEntry(object.getRecordObjectId(), propertyName, (String) value));
         }
         else if (value instanceof SynchronizedObject) {
            changeEntries.add(new ChangeObjectEntry(object.getRecordObjectId(), propertyName, (SynchronizedObject) value));
         }
         else {
            throw new IllegalArgumentException(value.getClass()+ " not supported");
         }
      }
   }

   public synchronized void recordClear(SynchronizedCollection<?> collection) {
      // TODO Auto-generated method stub

   }

   public synchronized void recordNew(SynchronizedObject object) {
      if ( recording ) {
            changeEntries.add(new NewEntry(object.getRecordObjectId(), object));
      }
   }

   public synchronized void recordRemove(SynchronizedList<?> list, int index) {
      // TODO Auto-generated method stub

   }

   public synchronized void recordRemove(SynchronizedSet<?> set, Object value) {
      // TODO Auto-generated method stub

   }

   public synchronized void startRecording() {
      recording = true;
   }

   public synchronized void stopRecording() {
      recording = false;
   }

   public Object recordInvoke(SynchronizedObject recordedObject, String methodName, Object... parameters) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("TODO implementation");
   }

   public synchronized void recordInvoke(final SynchronizedObject recordedObject, final String methodName) {
      // Synchronize all avaiulable changes to remote peer before calling the method
      // TODO Check if invoke works without prio changes
      if ( service != null && changeEntries.size() > 0 ) {
         service.synchronizeChanges(changeEntries, new InternalSynchronizeCallback() {

            public void onException(Throwable throwable, SyncServiceCallback callback) {
               if ( callback != null ) {
                  callback.onException(throwable);
               }
               else {
                  // FIXME Error handling
                  throwable.printStackTrace(System.err);
               }
            }

            // Replay changes from remote to local, caused by the remote synchronization above
            public void onSucess(List<AbstractChangeLogEntry> remoteChanges, SyncServiceCallback callback) {
               
               // Get remote results put to local objects 
               if( player != null && remoteChanges != null && remoteChanges.size() > 0 ) {
                  player.playback(remoteChanges, null);
                  
                  changeEntries.removeAll(remoteChanges);
                  
               }
               
               changeEntries.clear();
               
               // Now call the method
               SynchronizedObjectProxy objectProxy = new SynchronizedObjectProxy(recordedObject.getRecordObjectId());
               service.invokeMethod(objectProxy, methodName, new InternalInvokeCallback() {

                  public void onException(Throwable throwable, SyncServiceCallback callback) {
                     if ( callback != null ) {
                        callback.onException(throwable);
                     }
                     else {
                        // FIXME Error handling
                        throwable.printStackTrace(System.err);
                     }
                  }

                  public void onSucess(AbstractInvocationResult invocationResult, SyncServiceCallback callback) {
                     if ( player != null && invocationResult.getRemoteChanges() != null && invocationResult.getRemoteChanges().size() > 0 ) {
                        player.playback(invocationResult.getRemoteChanges(), null);
                     }
                     if ( callback != null ) {
                        callback.onSuccess();
                     }
                  }
                  
               });
               
            }
            
           
         });
      }
   }

   private synchronized int getNextRecordObjectId() {
      return ++recordedObjectCount;
   }

   public Player getPlayer() {
      return player;
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

}
