package org.umlmda.runtime.sdo.sync.entries;

import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;

public class ChangeObjectEntry extends AbstractChangeEntry {

   private static final long serialVersionUID = 100L;
   private SynchronizedObjectProxy proxy;

   public ChangeObjectEntry() {
      super();
   }

   public ChangeObjectEntry(int recordId, String propertyName, SynchronizedObject object) {
      super(recordId, propertyName);
      this.proxy = new SynchronizedObjectProxy(object.getRecordObjectId());
   }

   @Override
   public Object getValue() {
      return proxy;
   }

   @Override
   public boolean equals(Object obj) {
      
      boolean bReturn = false;
      
      if (obj instanceof ChangeObjectEntry){
         
         ChangeObjectEntry chgEntry = (ChangeObjectEntry) obj;
         
         if (super.equals(obj)){
            if (chgEntry.getValue() == proxy)
               bReturn = true;
            else
               bReturn = chgEntry.getValue().equals(proxy);
         }
      }
      
      return bReturn;
         
   }  
}
