package org.umlmda.runtime.sdo.sync.gwt.client;

import java.util.List;

import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface SyncService extends RemoteService {
	public List<AbstractChangeLogEntry> synchronizeChanges(List<AbstractChangeLogEntry> changes);
}
