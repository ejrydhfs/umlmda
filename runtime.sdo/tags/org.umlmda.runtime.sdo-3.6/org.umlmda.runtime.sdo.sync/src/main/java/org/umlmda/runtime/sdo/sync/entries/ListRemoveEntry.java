/**
 * 
 */
package org.umlmda.runtime.sdo.sync.entries;

/**
 * @author MOROFF
 *
 */
public class ListRemoveEntry extends AbstractChangeLogEntry {

   private static final long serialVersionUID = 100L;
   private int index;

   /**
    * 
    */
   public ListRemoveEntry() {
   }

   /**
    * @param recordId
    * @param index 
    */
   public ListRemoveEntry(int recordId, int index) {
      super(recordId);
      this.index = index;
   }

   public int getIndex() {
      return index;
   }

   public void setIndex(int index) {
      this.index = index;
   }

   /* (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry#toString()
    */
   @Override
   public String toString() {
      return "CollectionListRemove: ROID="+getRecordId()+"\" index="+index;
   }

}
