package org.umlmda.generator.model;

import org.umlmda.generator.model.util.StringUtilTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

   public static Test suite() {
      TestSuite suite = new TestSuite("Test for org.umlmda.generator.model");
      // $JUnit-BEGIN$
      suite.addTestSuite(StringUtilTest.class);
      // $JUnit-END$
      return suite;
   }

}
