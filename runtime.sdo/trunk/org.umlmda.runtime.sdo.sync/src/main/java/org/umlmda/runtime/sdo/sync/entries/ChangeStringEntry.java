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

   @Override
   public boolean equals(Object obj) {
      
      boolean bReturn = false;
      
      if (obj instanceof ChangeStringEntry){
         
         ChangeStringEntry chgEntry = (ChangeStringEntry) obj;
         
         if (super.equals(obj)){
            if (value == chgEntry.getValue())
               bReturn = true; // Values are the same String or both are null
            else
               bReturn = (value != null) && value.equals(chgEntry.getValue());
         }
      }
      
      return bReturn;
         
   }  

   
}
