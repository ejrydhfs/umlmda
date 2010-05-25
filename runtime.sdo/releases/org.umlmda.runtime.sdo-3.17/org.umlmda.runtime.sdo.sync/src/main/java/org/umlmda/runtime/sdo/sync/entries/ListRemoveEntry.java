/**
 * 
 */
package org.umlmda.runtime.sdo.sync.entries;

import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;

/**
 * @author MOROFF
 */
public class ListRemoveEntry extends AbstractChangeLogEntry
{

   private static final long       serialVersionUID = 100L;
   private int                     index;
   private SynchronizedObjectProxy proxy;

   /**
    * 
    */
   public ListRemoveEntry() {
   }

   /**
    * @param recordId
    * @param index
    */
   public ListRemoveEntry(int recordId, int index, Object value) {
      super(recordId);
      this.index = index;
      if ( value instanceof SynchronizedObject ) {
         SynchronizedObject synchronizedObject = (SynchronizedObject) value;

         this.proxy = new SynchronizedObjectProxy(synchronizedObject.getRecordObjectId());
      }
      else {
         throw new IllegalArgumentException(value.getClass() + " unsupported type");
      }
   }

   public int getIndex() {
      return index;
   }

   public void setIndex(int index) {
      this.index = index;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry#toString()
    */
   @Override
   public String toString() {
      return "ListRemoveEntry: ROID=" + getRecordId() + "\" index=" + index + " value=\"" + proxy + "\"";
   }

   @Override
   public boolean equals(Object obj) {

      boolean bReturn = false;

      if ( obj instanceof ListRemoveEntry ) {

         ListRemoveEntry chgEntry = (ListRemoveEntry) obj;

         if ( super.equals(obj) ) {
            bReturn = proxy.equals(chgEntry.proxy) && (chgEntry.getIndex() == index);
         }
      }

      return bReturn;

   }

}
