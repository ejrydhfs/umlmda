package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SyncServiceAsync {
	public void synchronizeChanges(List<AbstractChangeLogEntry> changes, AsyncCallback callback);
}
