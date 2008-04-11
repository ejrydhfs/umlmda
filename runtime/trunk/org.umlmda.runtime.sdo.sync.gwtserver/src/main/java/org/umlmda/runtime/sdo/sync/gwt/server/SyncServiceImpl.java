package org.umlmda.runtime.sdo.sync.gwt.server;

import java.util.List;

import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.change.test.model.TestRootFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncService;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SyncServiceImpl extends RemoteServiceServlet implements SyncService {

   /**
    * 
    */
   private static final long serialVersionUID = 100L;

   /**
    * Servcerside implementation of the SyncService
    */
   public List<AbstractChangeLogEntry> synchronizeChanges(List<AbstractChangeLogEntry> changes) {

      Recorder slaveRecorder = new SynchronizerImpl();
      Player player = new PlayerImpl(new TestRootFactory(slaveRecorder), new ReflectionInvocationFactory());
      
      player.playback(changes, null);
      
      return slaveRecorder.getChangeEntries();
   }
}
