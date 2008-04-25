package org.umlmda.runtime.sdo.sync.entries;

import java.io.Serializable;

import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;

public abstract class AbstractChangeLogEntry implements Serializable {

   private int recordedObjectId;

   /**
    * Ctor required for serialization/deserialization
    */
   public AbstractChangeLogEntry() {
   }
   
   protected AbstractChangeLogEntry(int recordId) {
      this.recordedObjectId = recordId;
   }
   
   /**
    * @return
    */
   public int getRecordId() {
      return recordedObjectId;
   }

   protected Object getRecordedValue(Object value) {
      if (value instanceof SynchronizedObject) {
         SynchronizedObject recordedObject = (SynchronizedObject) value;
   
         return new SynchronizedObjectProxy(recordedObject.getRecordObjectId());
      }
      else {
         return value;
      }
   }
   
   @Override
   public boolean equals(Object obj) {
      
      boolean bReturn = false;
      
      if (obj instanceof AbstractChangeLogEntry){
         
         AbstractChangeLogEntry entry = (AbstractChangeLogEntry) obj;
         
            bReturn = (recordedObjectId == entry.getRecordId());
      }
      
      return bReturn;
         
   }  

   @Override
   public abstract String toString();
}
