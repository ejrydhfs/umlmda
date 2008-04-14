package org.umlmda.runtime.sdo.sync;

import java.io.Serializable;

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
}
