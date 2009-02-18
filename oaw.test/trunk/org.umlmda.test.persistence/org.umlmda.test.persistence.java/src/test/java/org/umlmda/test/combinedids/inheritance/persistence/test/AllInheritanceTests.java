package org.umlmda.test.combinedids.inheritance.persistence.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllInheritanceTests extends TestCase {
    public static Test suite() throws Exception 
    {
      TestSuite suite = new TestSuite( "Inheritance" );
      suite.addTest( new TestSuite( I1TestClassHierarchy.class ) );
      suite.addTest( new TestSuite( I2TestSubClass.class ) );
      suite.addTest( new TestSuite( I3TestConcreteClass.class ) );
      return suite;
   }
}
