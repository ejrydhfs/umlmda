package org.umlmda.runtime.sdo.sync.entries;

public class ChangeStringEntry extends AbstractChangeEntry {

   private static final long serialVersionUID = 100L;
   private String value;
   
   public ChangeStringEntry() {
   }

   public ChangeStringEntry(int recordId, String propertyName, String value) {
      super(recordId, propertyName);
      this.value = value;
   }

   @Override
   public Object getValue() {
      return value;
   }

}
