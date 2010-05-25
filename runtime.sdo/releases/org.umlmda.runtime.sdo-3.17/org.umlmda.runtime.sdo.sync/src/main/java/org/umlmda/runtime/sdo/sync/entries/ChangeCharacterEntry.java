package org.umlmda.runtime.sdo.sync.entries;

public class ChangeCharacterEntry extends AbstractChangeEntry
{

   private static final long serialVersionUID = 100L;
   private Character         value;

   public ChangeCharacterEntry() {
   }

   public ChangeCharacterEntry(int recordId, String propertyName, Character value) {
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

      if ( obj instanceof ChangeCharacterEntry ) {

         ChangeCharacterEntry chgEntry = (ChangeCharacterEntry) obj;

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
