/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: InvocationStatus.java,v $Version 11.07.2008 13:11:19 {user} Exp $
 */
package org.umlmda.runtime.sdo.sync;

public enum InvocationStatus {
   IDLE("idling"),
   RUNNING("running");
   
   private String statusName;
   
   InvocationStatus(String statusName) {
      this.statusName = statusName;
   }
   
   @Override
   public String toString() {
      return statusName;
   }
}
