package org.umlmda.test.combinedids.test;

import org.umlmda.test.combinedids.one2many.persistence.test.AllOneToManyTests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
    public static Test suite() throws Exception 
    {
      TestSuite suite = new TestSuite( "All Tests" );
      
      suite.addTest( AllOneToManyTests.suite() );

      return suite;
   }
}
