package org.umlmda.runtime.sdo.sync.entries;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractInvocationResult implements Serializable
{
   private List<AbstractChangeLogEntry> remoteChanges;
   private String                       remoteExceptionMessage;
   private String                       remoteExceptionStack;

   public AbstractInvocationResult() {

   }

   public AbstractInvocationResult(List<AbstractChangeLogEntry> remoteChanges) {
      this.remoteChanges = remoteChanges;
   }

   public AbstractInvocationResult(String remoteExceptionMessage, String remoteExceptionStack) {
      this.remoteExceptionMessage = remoteExceptionMessage;
      this.remoteExceptionStack = remoteExceptionStack;
   }

   public List<AbstractChangeLogEntry> getRemoteChanges() {
      return remoteChanges;
   }

   public String getRemoteExceptionMessage() {
      return remoteExceptionMessage;
   }

   public String getRemoteExceptionStack() {
      return remoteExceptionStack;
   }

}
