package org.umlmda.runtime.sdo.sync.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.runtime.lang.GenericEnumeration;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SyncService;
import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.SynchronizedCollection;
import org.umlmda.runtime.sdo.sync.SynchronizedList;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.SynchronizedSet;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.entries.ChangeBooleanEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeDateEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeDoubleEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeEnumerationEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeIntegerEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeObjectEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeStringArrayEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeStringEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeToNull;
import org.umlmda.runtime.sdo.sync.entries.CollectionClearEntry;
import org.umlmda.runtime.sdo.sync.entries.CollectionRemoveEntry;
import org.umlmda.runtime.sdo.sync.entries.ListAddEntry;
import org.umlmda.runtime.sdo.sync.entries.ListRemoveEntry;
import org.umlmda.runtime.sdo.sync.entries.NewEntry;
import org.umlmda.runtime.sdo.sync.entries.SetAddEntry;
import org.umlmda.runtime.sdo.sync.internal.AbstractServiceCall;

public class SynchronizerImpl implements Recorder {
   private Logger logger = Logger.getLogger(SynchronizerImpl.class);
   private List<AbstractChangeLogEntry> changeEntries = new ArrayList<AbstractChangeLogEntry>();
   private boolean recording = true;
   private final SyncService service;
   private Player player;
   
   public SynchronizerImpl(SyncService service) {
      this.service = service;
   }

   public void reset() {
      changeEntries.clear();
   }
   
   public synchronized List<AbstractChangeLogEntry> getChangeEntries() {
      return changeEntries;
   }

   public void register(SynchronizedObject recordedObject, boolean recordCreation) {
         recordedObject.setRecordObjectId(getNextRecordObjectId());
         if ( player != null ) {
            player.register(recordedObject.getRecordObjectId(), recordedObject);
         }
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
      if (recording) {
         if (value == null) {
            changeEntries.add(new ChangeToNull(object.getRecordObjectId(), propertyName));
         } else if (value instanceof Boolean) {
            changeEntries.add(new ChangeBooleanEntry(object.getRecordObjectId(), propertyName, (Boolean) value));
         } else if (value instanceof Date) {
            changeEntries.add(new ChangeDateEntry(object.getRecordObjectId(), propertyName, (Date) value));
         } else if (value instanceof Double) {
            changeEntries.add(new ChangeDoubleEntry(object.getRecordObjectId(), propertyName, (Double) value));
         } else if (value instanceof Integer) {
            changeEntries.add(new ChangeIntegerEntry(object.getRecordObjectId(), propertyName, (Integer) value));
         } else if (value instanceof String) {
            changeEntries.add(new ChangeStringEntry(object.getRecordObjectId(), propertyName, (String) value));
         } else if (value instanceof String[]) {
            changeEntries.add(new ChangeStringArrayEntry(object.getRecordObjectId(), propertyName, (String[]) value));
         } else if (value instanceof GenericEnumeration) {
            changeEntries.add(new ChangeEnumerationEntry(object.getRecordObjectId(), propertyName, (GenericEnumeration) value));
         } else if (value instanceof SynchronizedObject) {
            changeEntries.add(new ChangeObjectEntry(object.getRecordObjectId(), propertyName, (SynchronizedObject) value));
         } else {
            throw new IllegalArgumentException(value.getClass() + " not supported");
         }
      }
   }

   public synchronized void recordClear(SynchronizedCollection<?> collection) {
      if ( recording ) {
         changeEntries.add(new CollectionClearEntry(collection.getRecordObjectId()));
      }
   }

   public synchronized void recordNew(SynchronizedObject object) {
      if ( recording ) {
            changeEntries.add(new NewEntry(object.getRecordObjectId(), object));
      }
   }

   public synchronized void recordRemoveIndex(SynchronizedList<?> list, int index) {
      if ( recording ) {
         changeEntries.add(new ListRemoveEntry(list.getRecordObjectId(), index));
      }
   }

   public synchronized void recordRemove(SynchronizedCollection<?> collection, Object value) {
      if ( recording ) {
         changeEntries.add(new CollectionRemoveEntry(collection.getRecordObjectId(), value));
      }
   }

   public synchronized void startRecording() {
      recording = true;
   }

   public synchronized void stopRecording() {
      recording = false;
   }

   public void recordInvoke(final SynchronizedObject recordedObject, final String methodName, final Object... parameters) {
      // Translate parameters
      final Object transferParameter[] = new Object[parameters.length];
      
      for (int i = 0; i < parameters.length; i++) {
         Object parameter = parameters[i];
         
         if ( parameter instanceof SynchronizedObject ) {
            transferParameter[i] = new SynchronizedObjectProxy(((SynchronizedObject)parameter).getRecordObjectId());
         }
         else {
            transferParameter[i] = parameter;
         }
      }
      
      if ( logger.isDebugEnabled() ) {
         logger.debug("About to invoke "+methodName+" pushd changes to remote peer");
         for (AbstractChangeLogEntry entry : changeEntries) {
            logger.debug(entry);
         }
      }
      
      ServiceQueue serviceQueue = new ServiceQueue();
      
      // Write pending changes to remote peer
      if ( changeEntries.size() > 0 ) {
         serviceQueue.addServiceCall(new AbstractServiceCall<List<AbstractChangeLogEntry>>() {

            public void onExecute(ServiceCallWrapperImpl<List<AbstractChangeLogEntry>> wrapper) {
               service.synchronizeChanges(changeEntries, wrapper);
            }

            public void onSucess(List<AbstractChangeLogEntry> remoteChanges, SyncServiceCallback callback) {
               // Get remote results put to local objects 
               if ( player != null && remoteChanges != null && remoteChanges.size() > 0 ) {
                  player.playback(remoteChanges, null);
                  changeEntries.removeAll(remoteChanges);
               }
               changeEntries.clear();
            }
         });
      }
      
      // Call the service
      serviceQueue.addServiceCall(new AbstractServiceCall<AbstractInvocationResult>() {

         public void onExecute(ServiceCallWrapperImpl<AbstractInvocationResult> wrapper) {
            SynchronizedObjectProxy objectProxy = new SynchronizedObjectProxy(recordedObject.getRecordObjectId());
            service.invokeMethod(objectProxy, methodName, transferParameter, wrapper);            
         }

         public void onSucess(AbstractInvocationResult invocationResult, SyncServiceCallback callback) {
            if ( player != null && invocationResult.getRemoteChanges() != null && invocationResult.getRemoteChanges().size() > 0 ) {
               player.playback(invocationResult.getRemoteChanges(), null);
               
               changeEntries.removeAll(invocationResult.getRemoteChanges());
            }
            if ( callback != null ) {
               callback.onSuccess();
            }            
         }
      });
      
      serviceQueue.execute();
   }

   public synchronized void recordInvoke(final SynchronizedObject recordedObject, final String methodName) {
      recordInvoke(recordedObject, methodName, new Object[] {});
   }

   private synchronized int getNextRecordObjectId() {
      return ((PlayerImpl)getPlayer()).getNextRecordObjectId();
   }

   public Player getPlayer() {
      return player;
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

}
