package org.umlmda.test.combinedids.one2one.persistence.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllOneToOneTests extends TestCase {
    public static Test suite() throws Exception 
    {
      TestSuite suite = new TestSuite( "OneToOne" );
      suite.addTest( new TestSuite( A1Test.class ) );
      suite.addTest( new TestSuite( A2Test.class ) );
      suite.addTest( new TestSuite( A4Test.class ) );
      return suite;
   }
}
