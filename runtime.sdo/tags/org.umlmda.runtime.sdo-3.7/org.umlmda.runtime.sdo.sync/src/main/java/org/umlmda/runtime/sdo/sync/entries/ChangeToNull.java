package org.umlmda.runtime.sdo.sync.entries;


public class ChangeToNull extends AbstractChangeEntry {

   /**
    * 
    */
   private static final long serialVersionUID = 10L;

   public ChangeToNull() {
   }

   public ChangeToNull(int recordId, String propertyName) {
      super(recordId, propertyName);
   }

   @Override
   public Object getValue() {
      return null;
   }

}
