package org.umlmda.test.combinedids.one2many.persistence.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllOneToManyTests extends TestCase {
    public static Test suite() throws Exception 
    {
      TestSuite suite = new TestSuite( "OneToMany" );
      suite.addTest( new TestSuite( C2.class ) );
      suite.addTest( new TestSuite( C4.class ) );
      return suite;
   }
}
