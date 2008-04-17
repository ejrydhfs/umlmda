package org.umlmda.runtime.sdo.change.test;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
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
      Recorder masterRecorder = new SynchronizerImpl();
      TestFactory factory = new TestFactoryImpl(masterRecorder);
      Recorder slaveRecorder = new SynchronizerImpl();
      Player player = new PlayerImpl(new TestFactoryImpl(slaveRecorder), new ReflectionInvocationFactory());
      
      RootClass root = factory.createRootClass();
      
      root.setRootChild(factory.createRootChild());
      
      TestUtils.logEntries(logger, masterRecorder);

      RootClass copy = (RootClass) player.playback(masterRecorder.getChangeEntries(), null);
      
      TestUtils.logEntries(logger, slaveRecorder);

      assertNotNull(copy);
      assertFalse(root == copy);
      assertEquals(masterRecorder.getChangeEntries().size(), slaveRecorder.getChangeEntries().size());
   }

}
