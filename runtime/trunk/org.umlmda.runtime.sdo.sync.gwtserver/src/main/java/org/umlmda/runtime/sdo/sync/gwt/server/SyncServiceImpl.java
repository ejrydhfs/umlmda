package org.umlmda.runtime.sdo.sync.gwt.server;

import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.gwt.client.SyncService;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.dto.impl.TestFactoryImpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SyncServiceImpl extends RemoteServiceServlet implements SyncService {
   static Logger logger = Logger.getLogger(SyncServiceImpl.class);
   
   /**
    * 
    */
   private static final long serialVersionUID = 100L;

   /**
    * Servcerside implementation of the SyncService
    */
   public List<AbstractChangeLogEntry> synchronizeChanges(List<AbstractChangeLogEntry> changes) {
      Recorder slaveRecorder = new SynchronizerImpl();
      Player player = new PlayerImpl(new TestFactoryImpl(slaveRecorder), new ReflectionInvocationFactory());

      logger.info("synchronizeChanges()");
      
      player.playback(changes, null);

      return slaveRecorder.getChangeEntries();
   }
}
