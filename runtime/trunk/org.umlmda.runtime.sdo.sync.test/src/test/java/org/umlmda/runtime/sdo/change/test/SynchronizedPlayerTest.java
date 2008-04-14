package org.umlmda.runtime.sdo.change.test;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.change.test.model.RootChild;
import org.umlmda.runtime.sdo.change.test.model.RootClass;
import org.umlmda.runtime.sdo.change.test.model.TestRootFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;

public class SynchronizedPlayerTest extends TestCase {
   private static Logger logger = Logger.getLogger(SynchronizedPlayerTest.class);
   
   public SynchronizedPlayerTest(String name) {
      super(name);
   }

   protected void setUp() throws Exception {
      super.setUp();
   }

   public void testPlayback() {
      Recorder masterRecorder = new SynchronizerImpl();
      Recorder slaveRecorder = new SynchronizerImpl();
      Player player = new PlayerImpl(new TestRootFactory(slaveRecorder), new ReflectionInvocationFactory());
      
      RootClass root = new RootClass(masterRecorder);
      
      root.setRootChild(new RootChild(masterRecorder));
      
      TestUtils.logEntries(logger, masterRecorder);

      RootClass copy = (RootClass) player.playback(masterRecorder.getChangeEntries(), null);
      
      TestUtils.logEntries(logger, slaveRecorder);

      assertNotNull(copy);
      assertFalse(root == copy);
      assertEquals(masterRecorder.getChangeEntries().size(), slaveRecorder.getChangeEntries().size());
   }

}
