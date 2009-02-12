/*
 * Created on 18.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test.org.umlmda.model.uml.nsuml;

import java.io.File;
import java.util.Iterator;

import org.umlmda.model.uml.ModelAssociationBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.nsuml.ModelFactoryImpl;

import junit.framework.TestCase;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestQualifier extends TestCase {
   ModelBase modelBase = null;
   
   /* (non-Javadoc)
    * @see junit.framework.TestCase#setUp()
    */
   protected void setUp() throws Exception {
      modelBase = new ModelFactoryImpl().loadModel(new File("model/rose/qualifier.mdl"));
      
      super.setUp();
   }
   
   public void testQualifier() {
      for (Iterator ic = modelBase.getClasses().iterator(); ic.hasNext();) {
         ModelClassBase modelClass = (ModelClassBase) ic.next();

         for (Iterator ia = modelClass.getAssociations().iterator(); ia.hasNext();) {
            ModelAssociationBase association = (ModelAssociationBase) ia.next();
            
            if ( modelClass.getName().equals("A") && association.getName().equals("theB")) {
               assertTrue(association.isMultiple());
            }

            if ( modelClass.getName().equals("C") && association.getName().equals("theD")) {
               assertTrue(association.isMultiple());
            }
         }
      }
   }
   
   /* (non-Javadoc)
    * @see junit.framework.TestCase#tearDown()
    */
   protected void tearDown() throws Exception {
      // TODO Auto-generated method stub
      super.tearDown();
   }
}
