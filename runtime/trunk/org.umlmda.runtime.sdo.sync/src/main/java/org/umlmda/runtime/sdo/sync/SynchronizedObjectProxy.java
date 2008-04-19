package org.umlmda.runtime.sdo.sync;

import java.io.Serializable;

import org.umlmda.runtime.sdo.sync.entries.ChangeStringEntry;

public class SynchronizedObjectProxy implements SynchronizedObject, Serializable {

   private static final long serialVersionUID = 100L;
   private int recordObjectId;

   public SynchronizedObjectProxy() {
   }
   
   public SynchronizedObjectProxy(int recordObjectId) {
      this.recordObjectId = recordObjectId;
   }

   public int getRecordObjectId() {
      return recordObjectId;
   }

   public void setRecordObjectId(int recordObjectId) {
      this.recordObjectId = recordObjectId;
   }

   @Override
   public String toString() {
      return "Proxy to ROID="+recordObjectId;
   }

   public String getModelName() {
      throw new UnsupportedOperationException();
   }

   public String getModelVersion() {
      throw new UnsupportedOperationException();
   }
   
   @Override
   public boolean equals(Object obj) {
      
      boolean bReturn = false;
      
      if (obj instanceof SynchronizedObjectProxy){
         
         SynchronizedObjectProxy proxy = (SynchronizedObjectProxy) obj;
         
         bReturn = (recordObjectId == proxy.getRecordObjectId());
      }
      
      return bReturn;
         
   }  
  
}
