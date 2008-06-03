package org.umlmda.runtime.sdo.sync.entries;

import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;


public class SetAddEntry extends AbstractChangeLogEntry {

   /**
    * 
    */
   private static final long serialVersionUID = 100L;
   private SynchronizedObjectProxy proxy;

   public SetAddEntry() {
   }

   public SetAddEntry(int recordId, Object value) {
      super(recordId);
      if (value instanceof SynchronizedObject) {
         SynchronizedObject synchronizedObject = (SynchronizedObject) value;
         
         this.proxy = new SynchronizedObjectProxy(synchronizedObject.getRecordObjectId());
      }
      else {
         throw new IllegalArgumentException(value.getClass()+" unsupported type");
      }
   }

   public Object getValue() {
      return proxy;
   }

   @Override
   public String toString() {
      return "SetAddEntry: ROID="+getRecordId()+" value=\""+proxy+"\"";
   }
   
   @Override
   public boolean equals(Object obj) {
      
      boolean bReturn = false;
      
      if (obj instanceof SetAddEntry){
         
         SetAddEntry chgEntry = (SetAddEntry) obj;
         
         if (super.equals(obj)){
            bReturn = (proxy != null) && proxy.equals(chgEntry.getValue());
         }
      }
      
      return bReturn;
         
   }  

}
