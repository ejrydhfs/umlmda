package org.umlmda.runtime.sdo.sync.entries;

public class ChangeStringArrayEntry extends AbstractChangeEntry {

   private static final long serialVersionUID = 100L;
   private String[] values;

   public ChangeStringArrayEntry() {
   }

   public ChangeStringArrayEntry(int recordId, String propertyName, String[] values) {
      super(recordId, propertyName);
      this.values = values;
   }

   @Override
   public Object getValue() {
      return values;
   }

}
