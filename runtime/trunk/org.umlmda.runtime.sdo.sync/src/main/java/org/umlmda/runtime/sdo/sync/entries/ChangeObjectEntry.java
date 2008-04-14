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

}
