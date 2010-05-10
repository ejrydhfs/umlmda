package org.umlmda.runtime.sdo.sync.entries;

import org.umlmda.runtime.lang.GenericEnumeration;

public class ChangeEnumerationEntry extends AbstractChangeEntry
{

   private static final long  serialVersionUID = 100L;
   private GenericEnumeration value;

   public ChangeEnumerationEntry() {
   }

   public ChangeEnumerationEntry(int recordId, String propertyName, GenericEnumeration value) {
      super(recordId, propertyName);
      this.value = value;
   }

   @Override
   public Object getValue() {
      return value;
   }

}
