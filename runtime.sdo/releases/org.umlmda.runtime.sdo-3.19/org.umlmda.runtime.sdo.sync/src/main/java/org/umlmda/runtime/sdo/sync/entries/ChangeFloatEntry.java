package org.umlmda.runtime.sdo.sync.entries;

public class ChangeFloatEntry extends AbstractChangeEntry
{

   private static final long serialVersionUID = 234L;
   private Float             value;

   public ChangeFloatEntry() {
   }

   public ChangeFloatEntry(int recordId, String propertyName, Float value) {
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

      if ( obj instanceof ChangeFloatEntry ) {

         ChangeFloatEntry chgEntry = (ChangeFloatEntry) obj;

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
