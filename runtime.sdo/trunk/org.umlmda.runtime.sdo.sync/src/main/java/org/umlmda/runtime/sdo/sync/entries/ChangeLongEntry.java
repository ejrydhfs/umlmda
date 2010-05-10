package org.umlmda.runtime.sdo.sync.entries;

public class ChangeLongEntry extends AbstractChangeEntry
{

   private static final long serialVersionUID = 123L;
   private Long              value;

   public ChangeLongEntry() {
   }

   public ChangeLongEntry(int recordId, String propertyName, Long value) {
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

      if ( obj instanceof ChangeLongEntry ) {

         ChangeLongEntry chgEntry = (ChangeLongEntry) obj;

         if ( super.equals(obj) ) {
            if ( value == chgEntry.getValue() )
               bReturn = true; // Values are the same String or both are null
            else
               bReturn = (value != null) && value.equals(chgEntry.getValue());
         }
      }

      return bReturn;

   }

}
