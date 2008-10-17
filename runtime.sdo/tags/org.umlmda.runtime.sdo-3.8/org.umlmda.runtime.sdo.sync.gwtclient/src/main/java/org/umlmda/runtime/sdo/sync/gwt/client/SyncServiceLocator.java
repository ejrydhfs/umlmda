package org.umlmda.runtime.sdo.sync.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class SyncServiceLocator {
   private static SyncServiceAsync instance;
   public static SyncServiceAsync getInstance(){
      if (instance == null) {
         instance = (SyncServiceAsync) GWT.create(SyncService.class);
         ServiceDefTarget target = (ServiceDefTarget) instance;
         target.setServiceEntryPoint(GWT.getModuleBaseURL() + "SyncService");
      }
      return instance;
   }
}
