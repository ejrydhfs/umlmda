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
 * Created by Dieter Moroff (27.03.2006)
 */
package test.org.umlmda.uml.generator.webservices;

import java.util.Iterator;
import java.util.List;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.webservices.WSModel;
import org.umlmda.uml.generator.webservices.WSModelClass;
import org.umlmda.uml.generator.webservices.WSModelPackage;
import org.umlmda.uml.generator.webservices.WSStereotypes;

import test.org.umlmda.uml.generator.ModelTestCase;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (27.03.2006), last change $Date$ $Name$
 * @version $Revision$
 */
public class WSModelAdapterTest extends ModelTestCase {
   
   /* (non-Javadoc)
    * @see junit.framework.TestCase#setUp()
    */
   protected void setUp() throws Exception {
      super.setUp();
      
      ((WSModel)getPsmTestModel()).getProperties().put(WSModel.PROPERTY_SOAP_WRAPPING, "true");
   }
   
   public void testInOutOptimization() {
      WSModelClass testService = (WSModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.TestService");
      
      assertNotNull(testService);
      List referencedClasses = testService.getReferencedClasses();
      
      ModelClass nonOptBBase = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.NonOptBBase");
      ModelClass nonOptBBaseIn = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.NonOptBBaseIn");
      ModelClass nonOptBBaseInHierarchie = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.NonOptBBaseInHierarchie");
      ModelClass nonOptBBaseOutHierarchie = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.NonOptBBaseOutHierarchie");
      
      assertNotNull(nonOptBBase);
      assertTrue(nonOptBBase.hasStereotype(WSStereotypes.WEB_SERVICE_DTO));
      assertNull(nonOptBBaseIn);
      assertNull(nonOptBBaseInHierarchie);
//      assertNotNull(nonOptBBaseOutHierarchie);
      
      ModelClass nonOptBase = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.NonOptBase");

      assertNotNull(nonOptBase);
      assertTrue(nonOptBase.hasStereotype(WSStereotypes.WEB_SERVICE_DTO));
      
      ModelClass optDerived = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.OptDerived");
      ModelClass optDerivedIn = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.OptDerivedIn");
      ModelClass optDerivedOut = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.OptDerivedOut");

      assertNull(optDerived);
      assertNotNull(optDerivedIn);
      assertTrue(optDerivedIn.hasStereotype(WSStereotypes.WEB_SERVICE_DTO));
      assertNotNull(optDerivedOut);
      assertTrue(optDerivedOut.hasStereotype(WSStereotypes.WEB_SERVICE_DTO));
      
            
      ModelClass optWithNoneOptSubClassIn = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.OptWithNoneOptSubClassIn");
      ModelClass optWithNoneOptSubClassOut = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.OptWithNoneOptSubClassOut");

      ModelClass noneOptDerivedFromOptIn = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.NoneOptDerivedFromOptIn");
      ModelClass noneOptDerivedFromOptOut = (ModelClass) getPsmTestModel().find("org.umlmda.test.ws.ws.NoneOptDerivedFromOptOut");
      
      assertNotNull(noneOptDerivedFromOptIn);
      assertEquals(optWithNoneOptSubClassIn, noneOptDerivedFromOptIn.getSuperClasses().get(0));
   }
   
   public void testWsClasses() {
      List classes;
      WSModelPackage testPackage = (WSModelPackage) getPsmTestModel().find("org.umlmda.demo.partner");
      assertNotNull(testPackage);
      
      WSModelPackage testWsPackage = testPackage.getWsPackage();
      assertNotNull(testWsPackage);
      
      classes = testWsPackage.getClasses(WSStereotypes.WEB_SERVICE_OBJECT); 
      for (Iterator ic = classes.iterator(); ic.hasNext();) {
         WSModelClass wsClass = (WSModelClass) ic.next();
         
         assertTrue(wsClass.hasStereotype(WSStereotypes.WEB_SERVICE_OBJECT));
      }
      assertEquals(60, classes.size());
      
      classes = testWsPackage.getClasses(WSStereotypes.WEB_SERVICE); 
      for (Iterator ic = classes.iterator(); ic.hasNext();) {
         WSModelClass wsClass = (WSModelClass) ic.next();
         
         assertTrue(wsClass.hasStereotype(WSStereotypes.WEB_SERVICE));
      }
      assertEquals(3, testWsPackage.getClasses("WebService").size());
   }
   
   public void testPatterns() {
      ModelClass pimService = (ModelClass) getPimTestModel().find("org.umlmda.demo.partner.PartnerPersistence");
      ModelClass psmService = (ModelClass) getPsmTestModel().find("org.umlmda.demo.partner.ws.PartnerPersistence");
      
      assertNotNull(pimService);
      assertTrue(pimService.hasStereotype(ModelStereotype.BUSINESS_SERVICE));
      
      assertNotNull(psmService);
      assertTrue(psmService.hasStereotype(WSStereotypes.WEB_SERVICE));
   }
   
}
