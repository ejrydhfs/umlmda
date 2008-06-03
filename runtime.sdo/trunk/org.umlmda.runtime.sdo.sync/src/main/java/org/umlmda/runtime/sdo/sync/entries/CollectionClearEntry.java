/**
 * 
 */
package org.umlmda.runtime.sdo.sync.entries;

/**
 * @author MOROFF
 *
 */
public class CollectionClearEntry extends AbstractChangeLogEntry {

   private static final long serialVersionUID = 100L;

   /**
    * 
    */
   public CollectionClearEntry() {
   }

   /**
    * @param recordId
    */
   public CollectionClearEntry(int recordId) {
      super(recordId);
   }

   @Override
   public String toString() {
      return "CollectionClearEntry: ROID="+getRecordId()+"\"";
   }
   
}
