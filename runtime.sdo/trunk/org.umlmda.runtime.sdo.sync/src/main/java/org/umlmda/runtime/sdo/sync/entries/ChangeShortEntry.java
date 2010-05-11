package org.umlmda.runtime.sdo.sync.entries;

public class ChangeShortEntry extends AbstractChangeEntry
{

   private static final long serialVersionUID = 234L;
   private Short             value;

   public ChangeShortEntry() {
   }

   public ChangeShortEntry(int recordId, String propertyName, Short value) {
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

      if ( obj instanceof ChangeShortEntry ) {

         ChangeShortEntry chgEntry = (ChangeShortEntry) obj;

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
