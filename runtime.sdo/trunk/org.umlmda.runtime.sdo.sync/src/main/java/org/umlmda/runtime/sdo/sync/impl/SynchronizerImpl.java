package org.umlmda.runtime.sdo.sync.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.runtime.bean.PropertyChangeEventManager;
import org.umlmda.runtime.lang.GenericEnumeration;
import org.umlmda.runtime.sdo.sync.InvocationStatus;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.SyncService;
import org.umlmda.runtime.sdo.sync.SyncServiceCallback;
import org.umlmda.runtime.sdo.sync.SynchronizeStrategy;
import org.umlmda.runtime.sdo.sync.SynchronizedCollection;
import org.umlmda.runtime.sdo.sync.SynchronizedList;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.SynchronizedSet;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractInvocationResult;
import org.umlmda.runtime.sdo.sync.entries.ChangeBooleanEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeCharacterEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeDateEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeDoubleEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeEnumerationEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeFloatEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeIntegerEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeLongEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeObjectEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeShortEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeStringArrayEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeStringEntry;
import org.umlmda.runtime.sdo.sync.entries.ChangeToNull;
import org.umlmda.runtime.sdo.sync.entries.CollectionClearEntry;
import org.umlmda.runtime.sdo.sync.entries.CollectionRemoveEntry;
import org.umlmda.runtime.sdo.sync.entries.InvokeEntry;
import org.umlmda.runtime.sdo.sync.entries.ListAddEntry;
import org.umlmda.runtime.sdo.sync.entries.ListRemoveEntry;
import org.umlmda.runtime.sdo.sync.entries.NewEntry;
import org.umlmda.runtime.sdo.sync.entries.SetAddEntry;
import org.umlmda.runtime.sdo.sync.internal.AbstractServiceCall;

public class SynchronizerImpl implements Recorder
{
   private Logger                       logger           = Logger.getLogger(SynchronizerImpl.class);
   private List<AbstractChangeLogEntry> changeEntries    = new ArrayList<AbstractChangeLogEntry>();
   private boolean                      recording        = true;
   private final SyncService            service;
   private Player                       player;
   public SynchronizeStrategy           strategy         = SynchronizeStrategy.COLLECT;
   protected InvocationStatus           invocationStatus = InvocationStatus.IDLE;
   private String                       conversationId;

   public SynchronizerImpl(SyncService service) {
      this.service = service;
   }

   public void setConversationId(String conversationId) {
      this.conversationId = conversationId;
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
         addEntry(new ListAddEntry(list.getRecordObjectId(), value, index));
      }
   }

   public synchronized void recordAdd(SynchronizedSet<?> set, Object value) {
      if ( recording ) {
         addEntry(new SetAddEntry(set.getRecordObjectId(), value));
      }
   }

   public synchronized void recordChange(SynchronizedObject object, String propertyName, Object value) {
      if ( recording ) {
         if ( value == null ) {
            addEntry(new ChangeToNull(object.getRecordObjectId(), propertyName));
         }
         else if ( value instanceof Boolean ) {
            addEntry(new ChangeBooleanEntry(object.getRecordObjectId(), propertyName, (Boolean) value));
         }
         else if ( value instanceof Character ) {
            addEntry(new ChangeCharacterEntry(object.getRecordObjectId(), propertyName, (Character) value));
         }
         else if ( value instanceof Date ) {
            addEntry(new ChangeDateEntry(object.getRecordObjectId(), propertyName, (Date) value));
         }
         else if ( value instanceof Double ) {
            addEntry(new ChangeDoubleEntry(object.getRecordObjectId(), propertyName, (Double) value));
         }
         else if ( value instanceof Float ) {
            addEntry(new ChangeFloatEntry(object.getRecordObjectId(), propertyName, (Float) value));
         }
         else if ( value instanceof Integer ) {
            addEntry(new ChangeIntegerEntry(object.getRecordObjectId(), propertyName, (Integer) value));
         }
         else if ( value instanceof Long ) {
            addEntry(new ChangeLongEntry(object.getRecordObjectId(), propertyName, (Long) value));
         }
         else if ( value instanceof Short ) {
            addEntry(new ChangeShortEntry(object.getRecordObjectId(), propertyName, (Short) value));
         }
         else if ( value instanceof String ) {
            addEntry(new ChangeStringEntry(object.getRecordObjectId(), propertyName, (String) value));
         }
         else if ( value instanceof String[] ) {
            addEntry(new ChangeStringArrayEntry(object.getRecordObjectId(), propertyName, (String[]) value));
         }
         else if ( value instanceof GenericEnumeration ) {
            addEntry(new ChangeEnumerationEntry(object.getRecordObjectId(), propertyName, (GenericEnumeration) value));
         }
         else if ( value instanceof SynchronizedObject ) {
            addEntry(new ChangeObjectEntry(object.getRecordObjectId(), propertyName, (SynchronizedObject) value));
         }
         else {
            throw new IllegalArgumentException(value.getClass() + " not supported");
         }
      }
   }

   public synchronized void recordClear(SynchronizedCollection<?> collection) {
      if ( recording ) {
         addEntry(new CollectionClearEntry(collection.getRecordObjectId()));
      }
   }

   public synchronized void recordNew(SynchronizedObject object) {
      if ( recording ) {
         addEntry(new NewEntry(object.getRecordObjectId(), object));
      }
   }

   public synchronized void recordRemoveIndex(SynchronizedList<?> list, int index, Object object) {
      if ( recording ) {
         addEntry(new ListRemoveEntry(list.getRecordObjectId(), index, object));
      }
   }

   public synchronized void recordRemove(SynchronizedCollection<?> collection, Object value) {
      if ( recording ) {
         addEntry(new CollectionRemoveEntry(collection.getRecordObjectId(), value));
      }
   }

   public synchronized void startRecording() {
      recording = true;
   }

   public synchronized boolean stopRecording() {
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

   public void recordInvoke(final SynchronizedObject recordedObject, final String methodName, final Object... parameters) {
      // Translate parameters
      final Object transferParameter[] = new Object[parameters.length];

      for ( int i = 0; i < parameters.length; i++ ) {
         Object parameter = parameters[i];

         if ( parameter instanceof SynchronizedObject ) {
            transferParameter[i] = new SynchronizedObjectProxy(((SynchronizedObject) parameter).getRecordObjectId());
         }
         else {
            transferParameter[i] = parameter;
         }
      }

      // If in running mode queue the invoke for later invocation
      if ( invocationStatus.equals(InvocationStatus.RUNNING) ) {
         changeEntries.add(new InvokeEntry(recordedObject.getRecordObjectId(), methodName, transferParameter));
         return;
      }

      invocationStatus = InvocationStatus.RUNNING;

      if ( logger.isDebugEnabled() ) {
         logger.debug("About to invoke " + methodName + " pushd changes to remote peer");
         for ( AbstractChangeLogEntry entry : changeEntries ) {
            logger.debug(entry);
         }
      }

      ServiceQueue serviceQueue = new ServiceQueue();

      generateServiceEntries(serviceQueue, recordedObject.getRecordObjectId(), methodName, transferParameter);
      serviceQueue.execute();
   }

   /**
    * Generates the service request entries
    * 
    * @param serviceQueue
    * @param recordedObject
    * @param methodName
    * @param transferParameter
    */
   private void generateServiceEntries(final ServiceQueue serviceQueue, final int recordedObjectId, final String methodName,
         final Object[] transferParameter) {

      // Write pending changes to remote peer
      if ( changeEntries.size() > 0 ) {
         serviceQueue.addServiceCall(new AbstractServiceCall<List<AbstractChangeLogEntry>>() {

            public void onExecute(ServiceCallWrapperImpl<List<AbstractChangeLogEntry>> wrapper) {
               service.synchronizeChanges(conversationId, extractChangeEntries(changeEntries), wrapper);
            }

            public void onSucess(List<AbstractChangeLogEntry> remoteChanges, SyncServiceCallback callback) {
               // Get remote results put to local objects
               if ( player != null && remoteChanges != null && remoteChanges.size() > 0 ) {
                  playbackRemoteChanges(remoteChanges);
               }
            }

         });
      }

      // Call the service
      serviceQueue.addServiceCall(new AbstractServiceCall<AbstractInvocationResult>() {

         public void onExecute(ServiceCallWrapperImpl<AbstractInvocationResult> wrapper) {
            SynchronizedObjectProxy objectProxy = new SynchronizedObjectProxy(recordedObjectId);
            service.invokeMethod(conversationId, objectProxy, methodName, transferParameter, wrapper);
         }

         public void onSucess(AbstractInvocationResult invocationResult, SyncServiceCallback callback) {
            if ( player != null && invocationResult.getRemoteChanges() != null && invocationResult.getRemoteChanges().size() > 0 ) {
               playbackRemoteChanges(invocationResult.getRemoteChanges());
            }
            if ( callback != null ) {
               InvokeEntry invokeEntry = getNextInvokeEntry(changeEntries);

               if ( invokeEntry == null ) {
                  callback.onSuccess();
                  invocationStatus = InvocationStatus.IDLE;
               }

               // Put queued invokes to service queue
               else {
                  generateServiceEntries(serviceQueue, invokeEntry.getRecordId(), invokeEntry.getMethodName(), invokeEntry
                        .getTransferParameters());
               }
            }
         }
      });
   }

   private InvokeEntry getNextInvokeEntry(List<AbstractChangeLogEntry> allLogEntries) {
      for ( Iterator<AbstractChangeLogEntry> ile = allLogEntries.iterator(); ile.hasNext(); ) {
         AbstractChangeLogEntry logEntry = ile.next();

         if ( logEntry instanceof InvokeEntry ) {
            ile.remove();
            return (InvokeEntry) logEntry;
         }
      }
      return null;
   }

   /**
    * Returns a sublist containing "real" change log entries until the next invoke entry
    */
   private List<AbstractChangeLogEntry> extractChangeEntries(List<AbstractChangeLogEntry> allLogEntries) {
      List<AbstractChangeLogEntry> changeEntries = new ArrayList<AbstractChangeLogEntry>();

      for ( Iterator<AbstractChangeLogEntry> ile = allLogEntries.iterator(); ile.hasNext(); ) {
         AbstractChangeLogEntry logEntry = ile.next();

         if ( logEntry instanceof InvokeEntry ) {
            return changeEntries;
         }
         else {
            changeEntries.add(logEntry);
            ile.remove();
         }
      }
      return changeEntries;
   }

   private void playbackRemoteChanges(List<AbstractChangeLogEntry> remoteChanges) {
      SynchronizeStrategy oldStrategy = strategy;

      // Temporary switch to collect strategy
      setSynchronizeStrategy(SynchronizeStrategy.COLLECT);

      // Switch property change events off while doing the playback
      boolean startQueuing = PropertyChangeEventManager.INSTANCE.startQueuing();

      try {
         player.playback(remoteChanges, null);

         // Remove remote changes from local change set
         changeEntries.removeAll(remoteChanges);
      }
      catch (RuntimeException e) {
         throw e;
      }
      finally {
         // Enable property change events again
         if ( startQueuing ) {
            PropertyChangeEventManager.INSTANCE.finishQueuing();
         }
         // Switch back to old strategy
         setSynchronizeStrategy(oldStrategy);
      }

   }

   public synchronized void recordInvoke(final SynchronizedObject recordedObject, final String methodName) {
      recordInvoke(recordedObject, methodName, new Object[] {});
   }

   private synchronized int getNextRecordObjectId() {
      return ((PlayerImpl) getPlayer()).getNextRecordObjectId();
   }

   public Player getPlayer() {
      return player;
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   private void addEntry(AbstractChangeLogEntry entry) {
      changeEntries.add(entry);
      if ( logger.isDebugEnabled() ) {
         logger.debug("Recorded to (" + changeEntries.size() + "): " + entry);
      }
      strategy.postRecordAction();
   }

   public void setSynchronizeStrategy(SynchronizeStrategy strategy) {
      assert strategy != null : "Strategy must not be null";
      this.strategy = strategy;
   }

   public SynchronizeStrategy getSynchronizeStrategy() {
      return strategy;
   }
}
