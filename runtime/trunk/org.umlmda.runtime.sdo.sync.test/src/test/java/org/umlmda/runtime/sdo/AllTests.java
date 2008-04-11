package org.umlmda.runtime.sdo;

import org.umlmda.runtime.sdo.change.test.SynchronizedPlayerTest;
import org.umlmda.runtime.sdo.change.test.SynchronizedRecordingTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

   public static Test suite() {
      TestSuite suite = new TestSuite("Test for org.umlmda.runtime.sdo.change.test");
      //$JUnit-BEGIN$
      suite.addTestSuite(SynchronizedRecordingTest.class);
      suite.addTestSuite(SynchronizedPlayerTest.class);
      //$JUnit-END$
      return suite;
   }

}
