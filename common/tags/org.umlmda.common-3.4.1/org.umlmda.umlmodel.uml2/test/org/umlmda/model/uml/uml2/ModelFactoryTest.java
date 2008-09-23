package org.umlmda.model.uml.uml2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelFactory;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.impl.ModelAdapterFactoryImpl;
import org.umlmda.model.uml.validate.ModelValidationException;
import org.umlmda.profile.ModelStereotype;

import junit.framework.TestCase;

public class ModelFactoryTest extends TestCase {

   public void testLoadRSMModelFile() {
      File file = new File("test", "TestWithUMLMDAProfile.emx");

      assertTrue(file.exists());

      Map pathMap = new HashMap();
      pathMap.put("UMLMDA_PROFILE", "C:/devel/umlmda.rsm7/org.umlmda.uml2.profile/profiles");
      pathMap.put("UML_PROFILES", "C:/devel/umlmda.rsm7/org.eclipse.uml2.uml.resources-2.0.1/profiles");
      // pathMap.put("UML2_MSL_PROFILES",
      // "C:/devel/umlmda.rsm7/com.ibm.xtools.uml.msl/profiles");
      ModelFactoryImpl modelFactory = new ModelFactoryImpl();
      modelFactory.setPathMap(pathMap);

      try {
         ModelBase modelBase = modelFactory.loadModel(file);

         assertNotNull("Model loaded", modelBase);

         ModelAdapterFactory adapterFactory = new ModelAdapterFactoryImpl();
         Model model = adapterFactory.createModel(modelBase);

         ModelPackage modelPackage = (ModelPackage) model.find("org.umlmda.test");

         assertNotNull("Package found", modelPackage);
         assertTrue("Package stereotype found", modelPackage.hasStereotype(ModelStereotype.BUSINESS_COMPONENT));
      } catch (IOException e) {
         fail(e.getMessage());
      } catch (ModelValidationException e) {
         fail(e.getValidationResults().toString());
      }
   }

   public void testReferenceModels() {
      File file = new File("../org.umlmda.umlmodel.uml2.test/model/rsm/self/ReferencedModel.emx");

      assertTrue(file.exists());

      Map pathMap = new HashMap();
      pathMap.put("UMLMDA_PROFILE", "C:/devel/umlmda.rsm7/org.umlmda.uml2.profile/profiles");
      pathMap.put("UML_PROFILES", "C:/devel//umlmda.rsm7/build/plugins/org.umlmda.umlmodel.uml2.test/profiles");
      ModelFactoryImpl modelFactory = new ModelFactoryImpl();
      modelFactory.setPathMap(pathMap);

      try {
         ModelBase modelBase = modelFactory.loadModel(file);

         assertNotNull("Model loaded", modelBase);

         ModelAdapterFactory adapterFactory = new ModelAdapterFactoryImpl();
         Model model = adapterFactory.createModel(modelBase);

         ModelPackage modelPackage = (ModelPackage) model.find("org.umlmda.test");

         assertNotNull("Package found", modelPackage);
         
         ModelClass base = (ModelClass) model.find("org.umlmda.test.base.TestBaseClass");
         
      } catch (IOException e) {
         fail(e.getMessage());
      } catch (ModelValidationException e) {
         fail(e.getValidationResults().toString());
      }
   }
}
