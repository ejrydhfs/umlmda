package org.umlmda.runtime.sdo.sync.entries;

import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;


public class ListAddEntry extends AbstractChangeLogEntry {

   /**
    * 
    */
   private static final long serialVersionUID = 100L;
   private SynchronizedObjectProxy proxy;
   private int index;

   public ListAddEntry() {
   }

   public ListAddEntry(int recordId, Object value, int index) {
      super(recordId);
      this.index = index;
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

   public int getIndex() {
      return index;
   }

   @Override
   public String toString() {
      return "ListAddEntry: ROID="+getRecordId()+" index="+index+" value=\""+proxy+"\"";
   }
}
