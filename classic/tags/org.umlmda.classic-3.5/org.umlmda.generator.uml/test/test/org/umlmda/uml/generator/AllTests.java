/*
 *   $Header$
 *   $Source$
 * $Revision$
 *     $Name$
 *     $Date$
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (02.05.2006)
 */
package test.org.umlmda.uml.generator;

import test.org.umlmda.uml.generator.webservices.WSModelAdapterTest;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Unittest suite for UMLGenerator
 * @author Dieter Moroff (02.05.2006), last change $Date$ $Name$
 * @version $Revision$
 */
public class AllTests {

   public static Test suite() {
      TestSuite suite = new TestSuite("Test for test.org.umlmda.uml.generator");
      //$JUnit-BEGIN$
      suite.addTestSuite(ValidatorTest.class);
      suite.addTestSuite(WSModelAdapterTest.class);
      //$JUnit-END$
      return suite;
   }
}
