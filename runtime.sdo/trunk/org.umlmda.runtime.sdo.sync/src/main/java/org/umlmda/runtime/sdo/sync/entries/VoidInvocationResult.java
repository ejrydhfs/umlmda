package org.umlmda.runtime.sdo.sync.entries;

import java.util.List;

public class VoidInvocationResult extends AbstractInvocationResult {


   private static final long serialVersionUID = 100L;

   public VoidInvocationResult() {
   }

   public VoidInvocationResult(List<AbstractChangeLogEntry> remoteChanges) {
      super(remoteChanges);
   }

   public VoidInvocationResult(String remoteExceptionMessage, String remoteExceptionStack) {
      super(remoteExceptionMessage, remoteExceptionStack);
   }

}
