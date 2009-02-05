package org.umlmda.test.combinedids.test;

import org.umlmda.test.combinedids.many2many.persistence.test.AllManyToManyTests;
import org.umlmda.test.combinedids.one2many.persistence.test.AllOneToManyTests;
import org.umlmda.test.combinedids.one2one.persistence.test.AllOneToOneTests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
    public static Test suite() throws Exception 
    {
      TestSuite suite = new TestSuite( "All Tests" );
      
      suite.addTest( AllOneToManyTests.suite() );
      suite.addTest( AllOneToOneTests.suite() );
      suite.addTest( AllManyToManyTests.suite() );

      return suite;
   }
}
