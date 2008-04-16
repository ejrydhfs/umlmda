package org.umlmda.runtime.sdo.sync.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.umlmda.runtime.bean.BeanInvocation;
import org.umlmda.runtime.bean.BeanInvocation.Factory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectFactory;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeEntry;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.entries.ListAddEntry;
import org.umlmda.runtime.sdo.sync.entries.NewEntry;

public class PlayerImpl implements Player {
   private Map<Integer, SynchronizedObject> synchronizedObjects = new HashMap<Integer, SynchronizedObject>();
   private final SynchronizedObjectFactory objectFactory;
   private final Factory beanInvocationFactory;

   public PlayerImpl(SynchronizedObjectFactory objectFactory, BeanInvocation.Factory beanInvocationFactory) {
      this.objectFactory = objectFactory;
      this.beanInvocationFactory = beanInvocationFactory;
   }

   @SuppressWarnings("unchecked")
   public synchronized SynchronizedObject playback(List<AbstractChangeLogEntry> changeEntries, SynchronizedObject rootObject) {
      
      for (AbstractChangeLogEntry logEntry : changeEntries) {
         SynchronizedObject object = synchronizedObjects.get(logEntry.getRecordId());
         
         if ( object == null && logEntry instanceof NewEntry ) {
            NewEntry createEntry = (NewEntry) logEntry;
            
            object = objectFactory.create(createEntry.getClassName());
            synchronizedObjects.put(createEntry.getRecordId(), object);
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
            List list = (List) object;
            
            list.add(listAddEntry.getIndex(), listElement);
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
      

}
