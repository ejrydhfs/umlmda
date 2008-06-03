package org.umlmda.runtime.sdo.sync.entries;

import java.util.Date;

public class ChangeDateEntry extends AbstractChangeEntry {

   private static final long serialVersionUID = 100L;
   private Date value;
   
   public ChangeDateEntry() {
   }

   public ChangeDateEntry(int recordId, String propertyName, Date value) {
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
      
      if (obj instanceof ChangeDateEntry){
         
         ChangeDateEntry chgEntry = (ChangeDateEntry) obj;
         
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
