package org.umlmda.runtime.sdo.change.test;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.change.test.model.RootChild;
import org.umlmda.runtime.sdo.change.test.model.RootChildren;
import org.umlmda.runtime.sdo.change.test.model.RootClass;
import org.umlmda.runtime.sdo.change.test.model.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;
import org.umlmda.runtime.sdo.sync.impl.SynchronizerImpl;

import junit.framework.TestCase;

public class SynchronizedRecordingTest extends TestCase {
   private static Logger logger = Logger.getLogger(SynchronizedRecordingTest.class);
   
   protected void setUp() throws Exception {
      super.setUp();
   }

   public void testAddChild() {
      org.umlmda.runtime.sdo.sync.Synchronizer recorder = new SynchronizerImpl();
      
      RootClass root = new RootClass(recorder);
      
      root.setRootChild(new RootChild(recorder));
      
      logEntries(recorder);
      assertEquals(3, recorder.getChangeEntries().size());
      
   }

   public void testAddChildren() {
      org.umlmda.runtime.sdo.sync.Synchronizer recorder = new SynchronizerImpl();
      
      RootClass root = new RootClass(recorder);
      
      root.getRootChildren().add(new RootChildren(recorder));
      root.getRootChildren().add(new RootChildren(recorder));
      
      root.getRootChildren().get(0).setStringAttr("A string value");
      root.getRootChildren().get(1).setStringAttr("Another string value");
      
      logEntries(recorder);
      assertEquals(7, recorder.getChangeEntries().size());
   }
   
   public void testAddGreatChildren() {
      org.umlmda.runtime.sdo.sync.Synchronizer recorder = new SynchronizerImpl();
      
      RootClass root = new RootClass(recorder);
      RootChild rootChild = new RootChild(recorder);
      RootGreatChildren greatChildren = new RootGreatChildren(recorder);
      
      root.getRootChildren().add(new RootChildren(recorder));
      root.getRootChildren().add(new RootChildren(recorder));
      
      root.getRootChildren().get(0).setStringAttr("A string value");
      root.getRootChildren().get(1).setStringAttr("Another string value");
      
      root.setRootChild(rootChild);
      
      rootChild.setGreatChildren(greatChildren);
      
      root.getRootChildren().get(0).getRootGreatChildren().add(greatChildren);

      logEntries(recorder);
      assertEquals(12, recorder.getChangeEntries().size());
   }
   
   private void logEntries(org.umlmda.runtime.sdo.sync.Synchronizer recorder) {
      if ( logger.isTraceEnabled()) {
         logger.trace("<!-- LogEntries");
         for (AbstractChangeLogEntry logEntry : recorder.getChangeEntries()) {
            logger.trace(logEntry);
         }
         logger.trace("LogEntries -->");
      }
   }
}
