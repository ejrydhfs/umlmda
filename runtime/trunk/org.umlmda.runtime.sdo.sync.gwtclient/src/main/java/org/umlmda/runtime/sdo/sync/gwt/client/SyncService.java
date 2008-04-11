package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface SyncService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
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
	
	public List<AbstractChangeLogEntry> synchronizeChanges(List<AbstractChangeLogEntry> changes);
}
