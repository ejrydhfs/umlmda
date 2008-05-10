package org.umlmda.runtime.sdo.sync.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.umlmda.runtime.bean.BeanInvocation;
import org.umlmda.runtime.bean.BeanInvocation.Factory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.CollectionClearEntry;
import org.umlmda.runtime.sdo.sync.entries.CollectionRemoveEntry;
import org.umlmda.runtime.sdo.sync.entries.ListAddEntry;
import org.umlmda.runtime.sdo.sync.entries.ListRemoveEntry;
import org.umlmda.runtime.sdo.sync.entries.NewEntry;
import org.umlmda.runtime.sdo.sync.entries.SetAddEntry;

public class PlayerImpl implements Player {
   private static final long serialVersionUID = 1L;
   private final Logger logger;
   private transient Map<Integer, SynchronizedObject> synchronizedObjects = new HashMap<Integer, SynchronizedObject>();
   private final SynchronizedObjectFactory objectFactory;
   private final Factory beanInvocationFactory;
   private int recordedObjectCount = 0;
   private final String mode;

   public PlayerImpl(String mode, SynchronizedObjectFactory objectFactory, BeanInvocation.Factory beanInvocationFactory) {
      this.mode = mode;
      this.objectFactory = objectFactory;
      this.beanInvocationFactory = beanInvocationFactory;
      this.logger = Logger.getLogger(PlayerImpl.class+"$"+mode);
   }

   public void register(int recordObjectId, SynchronizedObject recordedObject) {
      synchronizedObjects.put(recordObjectId, recordedObject);
   }
   
   public synchronized void reset() {
      logger.debug("Got reset");
      recordedObjectCount = 0;
      synchronizedObjects.clear();
   }
   
   public synchronized SynchronizedObject playback(List<AbstractChangeLogEntry> changeEntries, SynchronizedObject rootObject) {
      int count = changeEntries.size();
      Set<NewEntry> processedNewEntries = new HashSet<NewEntry>();
      
      if ( logger.isDebugEnabled() ) {
         logger.debug("Got "+count+" messages to play back");
      }
      
      // Create new Objects first
      int index = 0;
      for ( Iterator ile = changeEntries.iterator(); ile.hasNext(); ) {
         AbstractChangeLogEntry logEntry = (AbstractChangeLogEntry) ile.next();
         
         if ( logEntry instanceof NewEntry ) {
            SynchronizedObject object = synchronizedObjects.get(logEntry.getRecordId());
            NewEntry newEntry = (NewEntry) logEntry;
            
            if ( object == null ) {
               NewEntry createEntry = (NewEntry) logEntry;
               
               object = objectFactory.create(createEntry.getElementProxy());
               synchronizedObjects.put(createEntry.getRecordId(), object);
               processedNewEntries.add(createEntry);
               logger.debug("Created ("+index+"/"+count+"): "+logEntry+" as "+object.getClass().getName());
            }
         }
      }
      
      // Playback other entries
      index = 0;
      for (AbstractChangeLogEntry logEntry : changeEntries) {
         SynchronizedObject object = synchronizedObjects.get(logEntry.getRecordId());
         
         if ( logger.isDebugEnabled() ) {
            ++index;
            logger.debug("About to playback ("+index+"/"+count+"): "+logEntry);
         }
         
         if ( logEntry instanceof NewEntry && processedNewEntries.contains(logEntry) ) {
            // Done before
         }

         else if (logEntry instanceof AbstractChangeEntry) {
            AbstractChangeEntry changeEntry = (AbstractChangeEntry) logEntry;
            Object changeValue = getValue(changeEntry.getValue());
            BeanInvocation beanInvocation = beanInvocationFactory.create(object);
            
            beanInvocation.setValue(changeEntry.getPropertyName(), changeValue);
         }
         
         else if (logEntry instanceof ListAddEntry) {
            ListAddEntry listAddEntry = (ListAddEntry) logEntry;
            Object listElement = getValue(listAddEntry.getValue());
            List<Object> list = (List<Object>) object;
            
            list.add(listAddEntry.getIndex(), listElement);
         }

         else if (logEntry instanceof SetAddEntry) {
            SetAddEntry setAddEntry = (SetAddEntry) logEntry;
            Object setElement = getValue(setAddEntry.getValue());
            Set<Object> set = (Set<Object>) object;
            
            set.add(setElement);
         }

         else if (logEntry instanceof CollectionRemoveEntry) {
            CollectionRemoveEntry removeEntry = (CollectionRemoveEntry) logEntry;
            Object listElement = getValue(removeEntry.getValue());
            Collection<Object> collection = (Collection<Object>) object;
            
            collection.remove(listElement);
         }
         
         else if (logEntry instanceof CollectionClearEntry) {
            CollectionClearEntry removeEntry = (CollectionClearEntry) logEntry;
            Collection<Object> collection = (Collection<Object>) object;
            
            collection.clear();
         }
         
         else if (logEntry instanceof ListRemoveEntry) {
            ListRemoveEntry removeEntry = (ListRemoveEntry) logEntry;
            Collection<Object> collection = (Collection<Object>) object;
            
            collection.remove(removeEntry.getIndex());
         }

         else {
            throw new IllegalArgumentException();
         }
      }
      
      return synchronizedObjects.get(new Integer(1));
   }

   private Object getValue(Object changeValue) {
      if ( changeValue instanceof SynchronizedObjectProxy ) {
         SynchronizedObjectProxy proxy = (SynchronizedObjectProxy) changeValue;
         
         changeValue = synchronizedObjects.get(proxy.getRecordObjectId());
      }
      return changeValue;
   }

   public SynchronizedObject getObject(SynchronizedObjectProxy proxy) {
      return synchronizedObjects.get(proxy.getRecordObjectId());
   }

   public SynchronizedObject getObjectById(int recordObjectId) {
      return synchronizedObjects.get(recordObjectId);
   }
   
   public SynchronizedObjectFactory getObjectFactory() {
      return objectFactory;
   }
      
   synchronized int getNextRecordObjectId() {
      return ++recordedObjectCount;
   }

}
