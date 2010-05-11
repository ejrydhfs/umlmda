package org.umlmda.runtime.sdo.sync.entries;

import java.math.BigDecimal;

public class ChangeBigDecimalEntry extends AbstractChangeEntry
{

   private static final long serialVersionUID = 234L;
   private BigDecimal        value;

   public ChangeBigDecimalEntry() {
   }

   public ChangeBigDecimalEntry(int recordId, String propertyName, BigDecimal value) {
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

      if ( obj instanceof ChangeBigDecimalEntry ) {

         ChangeBigDecimalEntry chgEntry = (ChangeBigDecimalEntry) obj;

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
