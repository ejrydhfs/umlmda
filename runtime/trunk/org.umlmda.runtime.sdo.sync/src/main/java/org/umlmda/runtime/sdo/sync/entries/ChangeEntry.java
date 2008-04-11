package org.umlmda.runtime.sdo.sync.entries;


public class ChangeEntry extends AbstractChangeLogEntry {

   private static final long serialVersionUID = 100L;

   private String propertyName;

   private Object value;

   public ChangeEntry() {
   }

   public ChangeEntry(int recordId, String propertyName, Object value) {
      super(recordId);
      this.propertyName = propertyName;
      this.value = getRecordedValue(value);
   }

   public String getPropertyName() {
      return propertyName;
   }

   public Object getValue() {
      return value;
   }

   @Override
   public String toString() {
      return "ChangeEntry: ROID="+getRecordId()+" property="+propertyName+" value=\""+value+"\"";
   }
}
