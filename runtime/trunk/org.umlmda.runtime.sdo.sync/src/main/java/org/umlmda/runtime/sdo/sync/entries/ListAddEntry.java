package org.umlmda.runtime.sdo.sync.entries;


public class ListAddEntry extends AbstractChangeLogEntry {

   /**
    * 
    */
   private static final long serialVersionUID = 100L;
   private Object value;
   private int index;

   public ListAddEntry() {
   }

   public ListAddEntry(int recordId, Object value, int index) {
      super(recordId);
      this.index = index;
      this.value = getRecordedValue(value);
   }

   public Object getValue() {
      return value;
   }

   public int getIndex() {
      return index;
   }

   @Override
   public String toString() {
      return "ListAddEntry: ROID="+getRecordId()+" index="+index+" value=\""+value+"\"";
   }
}
