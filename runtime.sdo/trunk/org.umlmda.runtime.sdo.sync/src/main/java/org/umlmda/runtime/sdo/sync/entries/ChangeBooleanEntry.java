package org.umlmda.runtime.sdo.sync.entries;

public class ChangeBooleanEntry extends AbstractChangeEntry
{

   private static final long serialVersionUID = 100L;
   private Boolean           value;

   public ChangeBooleanEntry() {
   }

   public ChangeBooleanEntry(int recordId, String propertyName, Boolean value) {
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

      if ( obj instanceof ChangeBooleanEntry ) {

         ChangeBooleanEntry chgEntry = (ChangeBooleanEntry) obj;

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
