package org.umlmda.runtime.sdo.change.test;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.model.RootChildren;
import org.umlmda.runtime.sdo.sync.test.model.RootClass;
import org.umlmda.runtime.sdo.sync.test.model.TestFactory;
import org.umlmda.runtime.sdo.sync.test.model.impl.TestFactoryImpl;

import junit.framework.TestCase;

public class SynchonizedListTest extends TestCase {
   private static final Logger logger = Logger.getLogger(SynchonizedListTest.class);
   
   @SuppressWarnings("unchecked")
   public void testIterator() {
      SynchronizerImpl masterRecorder = new SynchronizerImpl(null);
      TestFactory masterFactory = new TestFactoryImpl(masterRecorder);
      Player masterPlayer = new PlayerImpl(new TestFactoryImpl(masterRecorder), new ReflectionInvocationFactory());

      masterRecorder.setPlayer(masterPlayer);

      RootClass root = masterFactory.createRootClass();
      RootChildren children = masterFactory.createRootChildren();
      
      root.getRootChildren().add(children);
      
      Iterator<RootChildren> iChildren = root.getRootChildren().iterator();
      
      assertTrue(iChildren.hasNext());
      assertEquals(3, masterRecorder.getChangeEntries().size());
      
      iChildren.next();
      iChildren.remove();

      assertEquals(4, masterRecorder.getChangeEntries().size());
      
      TestUtils.logEntries(logger, masterRecorder);
   }

}
