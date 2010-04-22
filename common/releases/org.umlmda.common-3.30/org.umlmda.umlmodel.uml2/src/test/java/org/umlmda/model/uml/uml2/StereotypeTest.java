/*
 * Copyright (C) All rights reserved 2005 - 2009, 
 * UMLMDA, http://www.umlmda.org
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
 * Created on 05.03.2009 (Dieter Moroff)
 */
package org.umlmda.model.uml.uml2;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.UMLPackageImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.impl.ModelAdapterFactoryImpl;
import org.umlmda.model.uml.validate.ModelValidationException;

public class StereotypeTest extends TestCase {
   private Logger logger = Logger.getLogger(getClass()); 
   private static final String UML_METAMODEL = "metamodels/UML.metamodel.uml";
   private static final String MODEL_FOLDER = "model/uml2/self";
   private String umlResoures;

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      
      UMLPackageImpl.init();
      
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", UMLResource.Factory.INSTANCE);
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("emx", UMLResource.Factory.INSTANCE);
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("epx", UMLResource.Factory.INSTANCE);

      EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.0.0/UML", EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
      
      URL url = getClass().getClassLoader().getResource(UML_METAMODEL);
      
      if ( url == null ) {
         String msg = UML_METAMODEL+" not found, check classpath";
         
         logger.error(msg);
         throw new RuntimeException(msg);
      }
   
      umlResoures = url.toExternalForm().replace(UML_METAMODEL, "");
      logger.info("Load UML resoruces from "+umlResoures);
      
      assert url != null;
   }

   public void testBooleanAttributes() {
      File file = new File(MODEL_FOLDER, "StereotypeTest/StereotypeTest.uml");

      assertTrue("Model doesn't exists "+file.getAbsolutePath(), file.exists());

      ModelFactoryImpl modelFactory = new ModelFactoryImpl();

      try {
         ModelBase modelBase = modelFactory.loadModel(file);

         assertNotNull("Model loaded", modelBase);

         ModelAdapterFactory adapterFactory = new ModelAdapterFactoryImpl();
         Model model = adapterFactory.createModel(modelBase);

         ModelClass modelClass = (ModelClass) model.find("Test");

         assertNotNull("Class found", modelClass);
      } catch (IOException e) {
         fail(e.getMessage());
      } catch (ModelValidationException e) {
         fail(e.getValidationResults().toString());
      }
      
   }
}
