package org.umlmda.runtime.sdo.change.test;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.umlmda.runtime.reflect.ReflectionInvocationFactory;
import org.umlmda.runtime.sdo.sync.MasterFactory;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.gwt.server.SyncContext;
import org.umlmda.runtime.sdo.sync.impl.PlayerImpl;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.DirectSynchronizerImpl;
import org.umlmda.runtime.sdo.sync.test.DirectSynchronizerImpl.FactoryBuilder;
import org.umlmda.runtime.sdo.sync.test.dto.CodeType;
import org.umlmda.runtime.sdo.sync.test.dto.IntCodeType;
import org.umlmda.runtime.sdo.sync.test.model.RootChild;
import org.umlmda.runtime.sdo.sync.test.model.RootChildren;
import org.umlmda.runtime.sdo.sync.test.model.RootClass;
import org.umlmda.runtime.sdo.sync.test.model.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.test.model.TestFactory;
import org.umlmda.runtime.sdo.sync.test.model.impl.TestFactoryImpl;

public class SynchronizedRecordingTest extends TestCase {
   private static Logger logger = Logger.getLogger(SynchronizedRecordingTest.class);
   private SynchronizerImpl recorder = new DirectSynchronizerImpl(new FactoryBuilder() {

		public MasterFactory createFactory(Recorder recorder) {
			MasterFactory masterFactory = new MasterFactory(recorder);
			
			masterFactory.registerFactory(factory);
			return masterFactory;
		}}, new FactoryBuilder() {

		public MasterFactory createFactory(Recorder recorder) {
			MasterFactory masterFactory = new MasterFactory(recorder);
			
			masterFactory.registerFactory(factory);
			return masterFactory;
		}});

   private TestFactoryImpl factory = new TestFactoryImpl(recorder);
   private Player player = new PlayerImpl("Test", factory, new ReflectionInvocationFactory());;
   public SynchronizedRecordingTest() {
      recorder.setPlayer(player);
      
      // Put recorder to thread local to be accessible in subsequent functions
      //SyncContext.recorderHolder.set(recorder);
   }
   
   protected void setUp() throws Exception {
      super.setUp();
      SyncContext.recorderHolder.set(recorder);
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

      greatChildren.setCodeAttr(CodeType.A);
      greatChildren.setIntCodeAttr(IntCodeType.A);
      greatChildren.setArrayAttr(new String[] { "A", "B"});
      
      TestUtils.logEntries(logger, recorder);
      assertEquals(15, recorder.getChangeEntries().size());
   }
   
}
