package org.umlmda.model.uml.uml2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
import org.umlmda.model.uml.ModelFactory;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.impl.ModelAdapterFactoryImpl;
import org.umlmda.model.uml.validate.ModelValidationException;
import org.umlmda.profile.ModelStereotype;

import junit.framework.TestCase;

public class ModelFactoryTest extends TestCase {
   private Logger logger = Logger.getLogger(getClass()); 
   private static final String UML_METAMODEL = "metamodels/UML.metamodel.uml";
   private static final String MODEL_FOLDER = "model/rsm/self";
   
   private File umlmdaProfiles = new File(".", "profiles/rsm/3rd/umlmda/profiles");
   private File rsmProfiles = new File(".", "profiles/rsm/3rd/ibm");
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
   
   public void testLoadRSMModelFile() {
      File file = new File(MODEL_FOLDER, "TestWithUMLMDAProfile.emx");

      assertTrue("Model doesn't exists "+file.getAbsolutePath(), file.exists());
      assertTrue("Profile doesn't exists "+umlmdaProfiles.getAbsolutePath(), umlmdaProfiles.exists());
      assertTrue("Profile doesn't exists "+rsmProfiles.getAbsolutePath(), rsmProfiles.exists());

      Map pathMap = getStandardPathMaps();
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

   private Map<String, String> getStandardPathMaps() {
      Map<String, String> pathMap = new HashMap<String, String>();
      pathMap.put("UMLMDA_PROFILE", umlmdaProfiles.getAbsolutePath());
      pathMap.put("UML2_MSL_PROFILES", rsmProfiles.getAbsolutePath());
      pathMap.put("UML_PROFILES", umlResoures + "profiles");
      pathMap.put("UML_METAMODES", umlResoures + "metamodels");
      pathMap.put("UML_LIBRARIES", umlResoures + "libraries");
      return pathMap;
   }

   public void testReferenceModels() {
      File file = new File(MODEL_FOLDER, "ReferencingModel.emx");

      assertTrue("Model doesn't exists "+file.getAbsolutePath(), file.exists());
      assertTrue("Profile doesn't exists "+umlmdaProfiles.getAbsolutePath(), umlmdaProfiles.exists());
      assertTrue("Profile doesn't exists "+rsmProfiles.getAbsolutePath(), rsmProfiles.exists());

      Map pathMap = getStandardPathMaps();
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
