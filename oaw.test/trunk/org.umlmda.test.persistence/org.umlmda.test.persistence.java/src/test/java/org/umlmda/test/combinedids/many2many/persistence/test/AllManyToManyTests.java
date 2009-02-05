package org.umlmda.test.combinedids.many2many.persistence.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllManyToManyTests extends TestCase {
    public static Test suite() throws Exception 
    {
      TestSuite suite = new TestSuite( "ManyToMany" );
      suite.addTest( new TestSuite( E1Test.class ) );
      suite.addTest( new TestSuite( E2Test.class ) );
      return suite;
   }
}
