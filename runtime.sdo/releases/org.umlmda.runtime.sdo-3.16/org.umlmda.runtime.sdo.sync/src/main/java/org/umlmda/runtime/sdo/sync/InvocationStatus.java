/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package org.umlmda.runtime.sdo.sync;

public enum InvocationStatus {
   IDLE("idling"), RUNNING("running");

   private String statusName;

   InvocationStatus(String statusName) {
      this.statusName = statusName;
   }

   @Override
   public String toString() {
      return statusName;
   }
}
