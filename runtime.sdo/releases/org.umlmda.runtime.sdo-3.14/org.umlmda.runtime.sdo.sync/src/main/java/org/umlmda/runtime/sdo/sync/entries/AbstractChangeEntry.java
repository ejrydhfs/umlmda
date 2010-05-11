package org.umlmda.runtime.sdo.sync.entries;

public abstract class AbstractChangeEntry extends AbstractChangeLogEntry
{

   private static final long serialVersionUID = 100L;

   private String            propertyName;

   public AbstractChangeEntry() {
   }

   public AbstractChangeEntry(int recordId, String propertyName) {
      super(recordId);
      this.propertyName = propertyName;
   }

   public String getPropertyName() {
      return propertyName;
   }

   public abstract Object getValue();

   @Override
   public String toString() {
      return "ChangeEntry: ROID=" + getRecordId() + " property=" + propertyName + " value=\"" + getValue() + "\"";
   }

   @Override
   public boolean equals(Object obj) {

      boolean bReturn = false;

      if ( obj instanceof AbstractChangeEntry ) {

         AbstractChangeEntry entry = (AbstractChangeEntry) obj;

         if ( super.equals(obj) ) {
            bReturn = (propertyName != null) && propertyName.equals(entry.getPropertyName());
         }
      }

      return bReturn;

   }

}
