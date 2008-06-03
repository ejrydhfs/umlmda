package org.umlmda.runtime.sdo.change.test;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.gwt.server.SyncContext;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.model.RootClass;
import org.umlmda.runtime.sdo.sync.test.model.TestFactory;
import org.umlmda.runtime.sdo.sync.test.model.impl.TestFactoryImpl;

public class SynchronizedPlayerTest extends TestCase {
   private static Logger logger = Logger.getLogger(SynchronizedPlayerTest.class);
   
   public SynchronizedPlayerTest(String name) {
      super(name);
   }

   protected void setUp() throws Exception {
      super.setUp();
   }

   public void testPlayback() {
      SynchronizerImpl masterRecorder = new SynchronizerImpl(null);
      TestFactory masterFactory = new TestFactoryImpl(masterRecorder);
      Player masterPlayer = new PlayerImpl("Test", new TestFactoryImpl(masterRecorder), new ReflectionInvocationFactory());

      masterRecorder.setPlayer(masterPlayer);

      SynchronizerImpl slaveRecorder = new SynchronizerImpl(null);
      TestFactory slaveFactory = new TestFactoryImpl(slaveRecorder);
      Player slavePlayer = new PlayerImpl("Test", new TestFactoryImpl(slaveRecorder), new ReflectionInvocationFactory());
      
      slaveRecorder.setPlayer(slavePlayer);
      SyncContext.recorderHolder.set(slaveRecorder);
      
      
      RootClass root = masterFactory.createRootClass();
      
      root.setRootChild(masterFactory.createRootChild());
      
      TestUtils.logEntries(logger, masterRecorder);

      RootClass copy = (RootClass) slavePlayer.playback(masterRecorder.getChangeEntries(), null);
      
      TestUtils.logEntries(logger, slaveRecorder);

      assertNotNull(copy);
      assertFalse(root == copy);
      assertEquals(masterRecorder.getChangeEntries().size(), slaveRecorder.getChangeEntries().size());
   }

}
