package org.umlmda.runtime.sdo.sync.entries;

public class ChangeIntegerEntry extends AbstractChangeEntry
{

   private static final long serialVersionUID = 100L;
   private Integer           value;

   public ChangeIntegerEntry() {
   }

   public ChangeIntegerEntry(int recordId, String propertyName, Integer value) {
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

      if ( obj instanceof ChangeIntegerEntry ) {

         ChangeIntegerEntry chgEntry = (ChangeIntegerEntry) obj;

         if ( super.equals(obj) ) {
            if ( value == chgEntry.getValue() )
               bReturn = true; // Values are the same object or both are null
            else
               bReturn = (value != null) && value.equals(chgEntry.getValue());
         }
      }

      return bReturn;

   }

}
