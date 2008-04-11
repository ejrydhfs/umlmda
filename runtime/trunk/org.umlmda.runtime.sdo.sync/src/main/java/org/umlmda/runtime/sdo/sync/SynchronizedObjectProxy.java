package org.umlmda.runtime.sdo.sync;

public class SynchronizedObjectProxy implements SynchronizedObject {
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
}
