package org.umlmda.runtime.sdo.change.test;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.dto.RootChild;
import org.umlmda.runtime.sdo.sync.test.dto.RootChildren;
import org.umlmda.runtime.sdo.sync.test.dto.RootClass;
import org.umlmda.runtime.sdo.sync.test.dto.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.test.dto.TestFactory;
import org.umlmda.runtime.sdo.sync.test.dto.impl.TestFactoryImpl;

public class SynchronizedRecordingTest extends TestCase {
   private static Logger logger = Logger.getLogger(SynchronizedRecordingTest.class);
   private Recorder recorder = new SynchronizerImpl();
   private TestFactory factory = new TestFactoryImpl(recorder);
   
   protected void setUp() throws Exception {
      super.setUp();
   }

   public void testAddChild() {
      RootClass root = factory.createRootClass();
      
      root.setRootChild(factory.createRootChild());
      
      TestUtils.logEntries(logger, recorder);
      assertEquals(3, recorder.getChangeEntries().size());
      
   }

   public void testAddChildren() {
      RootClass root = factory.createRootClass();
      
      root.getRootChildren().add(factory.createRootChildren());
      root.getRootChildren().add(factory.createRootChildren());
      
      ((RootChildren)root.getRootChildren().get(0)).setStringAttr("A string value");
      ((RootChildren)root.getRootChildren().get(1)).setStringAttr("Another string value");
      
      TestUtils.logEntries(logger, recorder);
      assertEquals(7, recorder.getChangeEntries().size());
   }
   
   public void testAddGreatChildren() {
      RootClass root = factory.createRootClass();
      
      root.getRootChildren().add(factory.createRootChildren());
      root.getRootChildren().add(factory.createRootChildren());
      
      ((RootChildren)root.getRootChildren().get(0)).setStringAttr("A string value");
      ((RootChildren)root.getRootChildren().get(1)).setStringAttr("Another string value");

      RootChild rootChild = factory.createRootChild();
      RootGreatChildren greatChildren = factory.createRootGreatChildren();
      
      root.setRootChild(rootChild);
      
      rootChild.setGreatChildren(greatChildren);
      
      ((RootChildren)root.getRootChildren().get(0)).getRootGreatChildren().add(greatChildren);

      TestUtils.logEntries(logger, recorder);
      assertEquals(12, recorder.getChangeEntries().size());
   }
   
}
