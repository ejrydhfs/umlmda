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

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelFactory;
import org.umlmda.model.uml.impl.ModelAdapterFactoryImpl;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (02.05.2006), last change $Date$ $Name$
 * @version $Revision$
 */
public abstract class ModelTestCase extends TestCase {

   private ModelBase testModelBase;
   private Model psmTestModel;
   private Model pimTestModel;

   /**
    * 
    */
   public ModelTestCase() {
      super();
   }

   /**
    * @param arg0
    */
   public ModelTestCase(String arg0) {
      super(arg0);
   }

   protected void setUp() throws Exception {
      super.setUp();
      
      
      String modelFactoryProperty = org.umlmda.model.uml.ModelFactory.class.getName();
      String modelFactoryClassName = System.getProperty(modelFactoryProperty, null);
      String modelFileProperty = getClass().getName()+".model";
      String modelFileName = System.getProperty(modelFileProperty, null);
      String modelAdapterFactoryProperty = getClass().getName()+".adapterFactory";
      String modelAdapterFactoryName = System.getProperty(modelAdapterFactoryProperty, null);
      ModelFactory factory;
      
      if ( modelFactoryClassName == null ) {
         String msg = modelFactoryProperty+" not set";
         System.err.println(msg);
         throw new RuntimeException(msg);
      }
      
      if ( modelFileName == null ) {
         String msg = modelFileProperty+" not set";
         System.err.println(msg);
         throw new RuntimeException(msg);
      }
      
      if ( modelAdapterFactoryName == null ) {
         String msg = modelAdapterFactoryProperty+" not set";
         System.err.println(msg);
         throw new RuntimeException(msg);
      }
      
      
      Class modelFactoryClass = Class.forName(modelFactoryClassName); 
      factory = (ModelFactory) modelFactoryClass.newInstance();
      File modelFile = new File(modelFileName);
      testModelBase = factory.loadModel(modelFile);
   
      if ( StringUtils.isNotEmpty(modelAdapterFactoryName) ) {
         Class modelAdapterFactoryClass = Class.forName(modelAdapterFactoryName);
         ModelAdapterFactory adapterFactory = (ModelAdapterFactory) modelAdapterFactoryClass.newInstance();
   
         // Create psm modell
         psmTestModel = adapterFactory.createModel(testModelBase);
   
         // Get the underlying pim adpater
         pimTestModel = (Model) psmTestModel.getSrcModel();
      }
      else {
         pimTestModel = new ModelAdapterFactoryImpl().createModel(testModelBase);
      }
   }
   
   /**
    * @return Returns the testModelBase.
    */
   public ModelBase getTestModelBase() {
      return testModelBase;
   }
   /**
    * @return Returns the psmTestModel.
    */
   public Model getPsmTestModel() {
      return psmTestModel;
   }
   /**
    * @return Returns the pimTestModel.
    */
   public Model getPimTestModel() {
      return pimTestModel;
   }
}
