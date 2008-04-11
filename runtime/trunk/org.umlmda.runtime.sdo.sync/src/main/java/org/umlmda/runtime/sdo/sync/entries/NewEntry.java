package org.umlmda.runtime.sdo.sync.entries;

/*
 * Change entry for new instances
 */
public class NewEntry extends AbstractChangeLogEntry {

   private static final long serialVersionUID = 100L;
   private String className;
   
   /**
    * Ctor required for serialization/deserialization
    */
   public NewEntry() {
   }

   @SuppressWarnings("unchecked")
   public NewEntry(int recordedObjectId, Class newInstanceClass) {
      super(recordedObjectId);
      className = newInstanceClass.getName();
   }

   public String getClassName() {
      return className;
   }
   
   @Override
   public String toString() {
      return "NewEntry: ROID="+getRecordId()+" class="+className;
   }
}
