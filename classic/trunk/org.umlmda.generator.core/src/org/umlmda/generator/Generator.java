// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/Generator.java,v 1.24.2.2 2008/01/21 14:57:27 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/Generator.java,v $
// $Revision: 1.24.2.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/01/21 14:57:27 $
//   $Locker:  $
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
// 
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// Created on:      23.07.2003
package org.umlmda.generator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.netbeans.junit.diff.Diff;
import org.netbeans.junit.diff.SimpleDiff;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.model.util.Feedback;
import org.umlmda.generator.model.util.FileUtils;
import org.umlmda.generator.model.util.GeneratorRuntime;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.MetaModelElement;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.profile.WriterType;
import org.umlmda.generator.profile.impl.UmpPackageImpl;
import org.umlmda.generator.profile.util.UmpResourceFactoryImpl;
import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;
import org.umlmda.generator.set.impl.UmsPackageImpl;
import org.umlmda.generator.set.util.UmsResourceFactoryImpl;
import org.umlmda.generator.writer.FreeMarkerWriter;
import org.umlmda.generator.writer.VelocityWriter;
import org.umlmda.generator.writer.oaw.XpandWriter;
import org.umlmda.merger.UserSectionMerger;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelElementBase;
import org.umlmda.model.uml.ModelFactory;
import org.umlmda.model.uml.ModelMethod;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.utils.ModelLoggingVisitor;
import org.umlmda.model.uml.utils.ModelStatistic;
import org.umlmda.model.uml.utils.ModelVisitableIterator;
import org.umlmda.model.uml.validate.ModelValidationException;
import org.umlmda.model.uml.validate.ModelValidator;
import org.umlmda.model.uml.validate.ModelValidatorFactory;
import org.umlmda.model.uml.validate.ValidationResult;


/**
 * Generic generator for UML models
 * @author Dieter Moroff
 */
@SuppressWarnings("unchecked")
public class Generator {
//   private InputStream modelStream;
   private File modelFile;
   private ModelBase pimModelBase;
//   private Model pimModel;
   private GenerationSet generationSet;
   private String generationSetName;
   private ClassLoader baseClassLoader = getClass().getClassLoader();
   private List additionalClassLoaders = new ArrayList();
   private List generatedFile = new ArrayList();
   private File outputFolder = new File(".");
   private static String mergeSubfolder = "merged";
   private String modelFactoryName = "org.umlmda.model.uml.nsuml.ModelFactoryImpl";
   private ModelFactory modelFactory = null;
   private static boolean keepFiles = false;
   private GeneratorRuntimeConfig config = new GeneratorRuntimeConfig();
   private Map pathMap = new HashMap();
   private Map writers = new HashMap();
   private Map externalWriters = null;
   private Map externalAdapterFactories = null;
   private Map externalValidatorFactories = null;
   private Map generationStrategieMap = new HashMap();
   private List templatePaths = new ArrayList();
   private final GeneratorRuntime runtime = GeneratorRuntime.getInstance();
   private GenerationProfile currentProfile = null;
   private Logger logger = Logger.getLogger(getClass().getName());
   private List<FormatterProvider> formatterProviders = new ArrayList<FormatterProvider>();
   private Map<String, Formatter> formatters = new HashMap<String, Formatter>();

   public static void main(String[] args) {
      Generator generator = new Generator(new Feedback() {
         public void tellNewStep(String message) {
            System.out.println(message);
         }
         public void tellWork(String message) {
            System.out.println(message);
         }
         public void message(int severity, String message) {
            if ( severity == INFO )
               System.out.println(message);
            else   
               System.err.println(message);
         }
         public void printStackTrace(Throwable throwable) {
            throwable.printStackTrace(System.err);
         }
      });

      generator.setModelFile(new File(args[0]));
      generator.setOutputFolder(args[1]);
      generator.run();
   }

   /**
    * Constructor for Generator.
    * @param getFeedback()
    */
   public Generator() {
      this(null);
    }

   /**
    * Constructor for Generator.
    * @param feedback
    */
   public Generator(Feedback feedback) {
      super();
      runtime.setFeedback(feedback);
           
      try {
         InputStream loggingProperties = getClass().getResourceAsStream("/umlmda.logging.properties");
         
         if ( loggingProperties == null ) {
            System.err.println("No logging configured, using jre defaults");
         }
         else {
            LogManager.getLogManager().readConfiguration(loggingProperties);
         }
      } catch (SecurityException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      
   }

   public int run() {

      try {
         GeneratorRuntime.getInstance().startup();
         
         getFeedback().tellWork("Init: Loading generation set");
         loadGenerationSet(getFeedback());

         // Create and configure formatter
         for (Iterator ifp = formatterProviders.iterator(); ifp.hasNext();) {
            FormatterProvider formatterProvider = (FormatterProvider) ifp.next();
            Formatter formatter = formatterProvider.createFormatter(getFeedback());

            for (int i = 0; i < formatterProvider.getExtensionsApplyableFor().length; i++) {
               String extension = formatterProvider.getExtensionsApplyableFor()[i];
               
               formatters.put(extension, formatter);
            }
         }

         // Lesen des Models aus Datei oder Validierung des Models im Speicher
         getFeedback().tellWork("Step 1: Load model");
         loadModel(getFeedback());
      	 
         // Erzeugen der Dateien aufgrund der Modellinformation
         for (Iterator ip = generationSet.getGenerationProfile().iterator(); ip.hasNext();) {
            currentProfile = (GenerationProfile) ip.next();
            Profile profile = currentProfile.getProfile();
            
            if ( currentProfile.isActive() ) {
               getFeedback().tellWork("Step 2: Generate new files for profile " + profile.getName());
               try {
                  GeneratorModel genModel = (GeneratorModel) createModelAdapter(getFeedback(), profile, currentProfile, generationSet);
                  
                  // Check model constaints
                  if ( StringUtils.isNotEmpty(profile.getValidatorFactory()) ) {
                     ModelValidator validator = createValidator(profile.getValidatorFactory());
                     
                        validateModel((Model)genModel, validator);
                  }
                  generate(getFeedback(), genModel);
               }
               catch ( ModelValidationException e ) {
                  getFeedback().message(Feedback.ERROR, "Aborted because of validation checks failed"+e.getValidationResults());
                  return 0;
               }
            }
            else {
               getFeedback().tellWork("Skip inactive profile " + profile.getName());
            }
         }

         // Formatting the generated Sources
         // Merge der UserSections
         getFeedback().tellWork("Step 3: Formatting generated sources");
         for (Iterator genFileIterator = generatedFile.iterator(); genFileIterator.hasNext();) {
            File generatedFile = new File((String) genFileIterator.next());
            String ext = FileUtils.getExtension(generatedFile);
            Formatter formatter = formatters.get(ext);
          
            if ( formatter != null ) {
               if ( formatter.format(generatedFile) ) {
                  getFeedback().message(Feedback.INFO, "Formatted "+generatedFile.getAbsolutePath());
               }
               else {
                  getFeedback().message(Feedback.WARNING, "Formating of "+generatedFile.getAbsolutePath()+" failed");
               }
            }
         }
         
         // Merge der UserSections
         getFeedback().tellWork("Step 4: Merging user sections");
         UserSectionMerger userSectionMerger = new UserSectionMerger(config);

         config.setMergedFolder(mergeSubfolder);

         for (Iterator genFileIterator = generatedFile.iterator(); genFileIterator.hasNext();) {
            File generatedFile = new File((String) genFileIterator.next());
            File sourceFile = new File(generatedFile.getParentFile().getParentFile(), generatedFile.getName());

            if (sourceFile.exists()) {
               if ( userSectionMerger.merge(generatedFile) == false ) {
                  getFeedback().message(Feedback.WARNING, sourceFile.getAbsolutePath()+" not mergable");
                  genFileIterator.remove();
               }
            }
         }

         // Kopieren der veränderten Dateien
         getFeedback().tellWork("Step 5: Copying modified or new files");

         int overwrittenFiles = 0;
         int overwrittenDeniedFiles = 0;
         int newFiles = 0;
         for (Iterator genFileIterator = generatedFile.iterator(); genFileIterator.hasNext();) {
            File generatedFile = new File((String) genFileIterator.next());
            File sourceFile = new File(generatedFile.getParentFile().getParentFile(), generatedFile.getName());
            File mergedFile = new File(sourceFile.getParentFile().getAbsolutePath() + File.separator + config.getMergedFolder(), generatedFile.getName());

            if (sourceFile.exists()) {
               Diff diff = new SimpleDiff();

               // Prüfen ob bereits gelöscht, weil im selben generatorlauf zweimal mit selben 
               // Namen erzeugt
               if ( mergedFile.exists() == false ) {
                  getFeedback().message(Feedback.WARNING, "File "+mergedFile.getAbsolutePath()+" removed, possibly generated twice");
               }
               else {
                  // Falls Datei verändet, kopieren ..
                  if (diff.diff(sourceFile, mergedFile, null)) {
                     getFeedback().tellWork("Overwrite file:   " + sourceFile.getAbsolutePath());
                     if ( sourceFile.canWrite() ) { 
                     	FileUtils.copyFile(mergedFile, sourceFile);
                        ++overwrittenFiles;
                     }
                     else {
                        getFeedback().message(Feedback.WARNING ,
                              "File: " + sourceFile.getName() + " is write protected! " +
                              "File will be left unmodified!");
                        ++overwrittenDeniedFiles;
                     }
                  }
                  // Löschen des "merged" Files
                  if ( !keepFiles ) {
                     if (mergedFile.delete())
                        getFeedback().tellWork("Del. merged file: " + mergedFile.getAbsolutePath());
                  }
               }
            } else {
               ++newFiles;
               getFeedback().tellWork("Copy file:        " + sourceFile.getAbsolutePath());
               FileUtils.copyFile(generatedFile, sourceFile);
            }
            
            if ( !keepFiles )
               generatedFile.delete();
         }

         // Cleanup generated and merged folders
         for (Iterator genFileIterator = generatedFile.iterator(); genFileIterator.hasNext();) {
            File generatedFile = new File((String) genFileIterator.next());
            File generatedFolder = new File(generatedFile.getParent());
            File mergedFolder = new File(generatedFolder.getParentFile(), config.getMergedFolder());
            
            deleteTempFolder(generatedFolder);
            deleteTempFolder(mergedFolder);
         }         
         
         // Summary 
         getFeedback().tellNewStep("Generation summary");
         getFeedback().message(Feedback.INFO, generatedFile.size()+" files generated");
         getFeedback().message(Feedback.INFO, newFiles+" new files generated");
         getFeedback().message(Feedback.INFO, overwrittenFiles+" files overwritten");
         if ( overwrittenDeniedFiles > 0 )
            getFeedback().message(Feedback.WARNING, overwrittenDeniedFiles+" file not overwritten, because write protection");
         
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      } finally {
         GeneratorRuntime.getInstance().shutdown();
         pimModelBase = null;
      }

      return generatedFile.size();
   }

   private void validateModel(Model genModel, ModelValidator validator) throws ModelValidationException {
      boolean hasError = false;
      List results;

      logger.config("validate model using "+validator.toString());
      results = validator.validate(genModel);;
      for (Iterator ir = results.iterator(); ir.hasNext();) {
         ValidationResult result = (ValidationResult) ir.next();

         getFeedback().message(result.getSeverity(), result.toString());
         hasError = hasError | result.getSeverity() == ValidationResult.ERROR;
      }
      
      if ( hasError ) {
         throw new ModelValidationException(results);
      }
   }

   /**
    * @param validatorFactory
    * @return
    */
   private ModelValidator createValidator(String validatorFactory) {
      ModelValidatorFactory factory = getValidatorFactory(validatorFactory);
      ModelValidator validator = new ModelValidator();
      
      factory.registerValidators(validator);
      return validator;
   }

   /**
    * @param validatorFactory
    * @return
    */
   private ModelValidatorFactory getValidatorFactory(String validatorFactory) {
      try {
         return (ModelValidatorFactory) createClass(validatorFactory, externalValidatorFactories);
      } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * @param tempFolder
    */
   private void deleteTempFolder(File tempFolder) {
      if ( tempFolder.exists() ) {
         if ( tempFolder.listFiles() == null || tempFolder.listFiles().length == 0 ) {
            getFeedback().tellWork("Delete temp folder " + tempFolder.getAbsolutePath());
            tempFolder.delete();
         } else {
            File files[] = tempFolder.listFiles();

            getFeedback().message(Feedback.INFO, "File in temp folder " + tempFolder.getAbsolutePath() + ":");
            getFeedback().message(Feedback.INFO, files.toString());
         }
      }
   }

   /**
    * reads the model from file if the model is not set already
    * @param feedback 
    * @return the model
    */
   private void loadGenerationSet(Feedback feedback) {
      if ( generationSet == null && StringUtils.isNotEmpty(generationSetName) ) {
         String setName = generationSetName;
         
         // register emf packages
         UmsPackageImpl.init();
         UmpPackageImpl.init();
         
         // register emf resouce factories
         Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ums", new UmsResourceFactoryImpl());
         Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ump", new UmpResourceFactoryImpl());

         File generationSetFile = new File(setName);
         
         if ( generationSetFile.canRead() == false ) {
            String msg = "File "+generationSetFile.getAbsolutePath()+" cannot be read";
            feedback.message(Feedback.ERROR, msg);
            throw new RuntimeException(msg);
         }
         
         URI uri = URI.createFileURI(generationSetFile.getAbsolutePath());
         
         ResourceSet resourceSet = new ResourceSetImpl();
//         resourceSet.setURIConverter(new FileURIConverter(uri));
         Resource resource = resourceSet.getResource(uri, true);
         
         try {
            resource.load(null);
         } catch (IOException e) {
            e.printStackTrace();
         }
         
         EList list = resource.getContents();
         generationSet = (GenerationSet) list.get(0);
         
         Diagnostic diagnostic = Diagnostician.INSTANCE.validate((EObject)generationSet);
         
         if ( diagnostic.getSeverity() == Diagnostic.ERROR ) {
            feedback.message(Feedback.ERROR, diagnostic.getMessage());
            feedbackChildren(feedback, diagnostic);
            throw new RuntimeException(diagnostic.getMessage());
      }
         else if ( diagnostic.getSeverity() == Diagnostic.WARNING ) {
            logger.warning(diagnostic.getMessage());
            feedbackChildren(feedback, diagnostic);
   }
      }
   }

   /**
    * @param feedback
    * @param diagnostic
    */
   private void feedbackChildren(Feedback feedback, Diagnostic diagnostic) {
      for (Iterator ic = diagnostic.getChildren().iterator(); ic.hasNext();) {
         Diagnostic child = (Diagnostic) ic.next();
         
         if ( child.getSeverity() == Diagnostic.ERROR ) {
            feedback.message(Feedback.ERROR, child.getMessage());
         }
         else if ( child.getSeverity() == Diagnostic.WARNING ) {
            feedback.message(Feedback.WARNING, child.getMessage());
         }
         else {
            feedback.message(Feedback.INFO, child.getMessage());
         }
      }
   }

   /**
    * Load the model from a file and create the inital adapter
    * @param feedback
    */
   private void loadModel(Feedback feedback) {
      // read in model from file
      if (pimModelBase == null) {
         if (modelFile.exists() == false)
            throw new RuntimeException("ModelType-File " + modelFile.getAbsolutePath() + " does not exist");
         else
            feedback.tellWork("About to read "+modelFile.getAbsolutePath());   
         try {
            getModelFactory().setPathMap(pathMap);
            pimModelBase = getModelFactory().loadModel(modelFile);
         } catch (IOException e) {
            throw new RuntimeException(e);
         }
      }
   }
   
   /**
    * Create a model apapter for the loaded model
    * @param feedback
    * @param profile 
    * @param generationSet2
    * @param currentProfile2
    * @return the created model adapter
    * @throws ModelValidationException
    */
   private Model createModelAdapter(Feedback feedback, Profile profile, GenerationProfile currentProfile2, GenerationSet generationSet2) throws ModelValidationException {
      String factoryName = profile.getAdapterFactory();
      ModelAdapterFactory factory = getAdapterFactory(factoryName);
      Model psmModel;

      getFeedback().message(Feedback.DEBUG, "Loaded model adapter factory "+factoryName);
      
      // create psm model adapter
      psmModel = factory.createModel(pimModelBase);

      if ( psmModel instanceof GeneratorModel ) {
         GeneratorModel genModel = (GeneratorModel) psmModel;
         
         genModel.setProfile(currentProfile);
         genModel.setGenerationSet(generationSet);
      }
      
      psmModel.init();
      
      // Diagnostics
      logger.fine(psmModel.getClass().getName()+": "+ new ModelStatistic(psmModel).toString());
      new ModelVisitableIterator(new ModelLoggingVisitor(Level.FINER, logger)).iterate(psmModel);
      
      return psmModel;
   }

   /**
    * Create a model factory
    */
   private ModelFactory getModelFactory() {
      List classLoaders = new ArrayList(this.additionalClassLoaders);
      classLoaders.add(this.baseClassLoader);

      // lazy create a model factory to read the model
      if (modelFactory == null ) {
         modelFactory = (ModelFactory) createClass(classLoaders, modelFactoryName);
      }
      return modelFactory;
   }

   /**
    * @param modelFactoryClass
    * @throws InstantiationException
    * @throws IllegalAccessException
    */
   private Object createClass(List classLoaders, String className) {
      Object classInstance = null;
      
      try {
         Class javaClass = loadClass(classLoaders, className);
         classInstance = javaClass.newInstance();
      } catch (InstantiationException e) {
         throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
         throw new RuntimeException(e);
      } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
      return classInstance;
   }

   /**
    * @param classLoaders
    * @param className
    * @return
    * @throws ClassNotFoundException
    */
   private Class loadClass(List classLoaders, String className) throws ClassNotFoundException {
      Class javaClass = null;
      for (Iterator icl = classLoaders.iterator(); javaClass == null && icl.hasNext();) {
         ClassLoader classLoader = (ClassLoader) icl.next();
         
         try {
            javaClass = classLoader.loadClass(className);
         } catch (ClassNotFoundException e) {
            // Ok, try next class loader
         }
      }
      
      if ( javaClass == null ) {
         throw new ClassNotFoundException(className);
      }
      
      return javaClass;
   }

   /**
    * @param string
    * 
    */
   private ModelAdapterFactory getAdapterFactory(String modelAdapterFactoryName) {
      try {
         Object instance = createClass(modelAdapterFactoryName, externalAdapterFactories);
         
         return (ModelAdapterFactory) instance;
      } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * @param string
    * @throws ClassNotFoundException
    * 
    */
   private Object createClass(String className, Map externalClasses) throws ClassNotFoundException {
      Object object;
      
      try {
         Class objectClass = null;
         
         // Search external classloaders
         try {
            objectClass = loadClass(additionalClassLoaders, className);
         } catch ( ClassNotFoundException e ) {
            // Ignore try later
         }
         
         // Search external factory
         if ( objectClass == null && externalClasses != null ) {
            objectClass = (Class) externalClasses.get(className);
         }
         
         // Search internal factory
         if ( objectClass == null ) {
            objectClass = baseClassLoader.loadClass(className);
         }
         
         object = objectClass.newInstance();
      } catch (InstantiationException e) {
         throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
         throw new RuntimeException(e);
      }

      return object;
   }
   
   /** Writer für alle Teilmodelle aufrufen */
   private void generate(Feedback feedback, GeneratorModel genModel) {
      for (Iterator ic = genModel.getModelElements().iterator(); ic.hasNext();) {
         Object element = ic.next();
         if ( element instanceof GeneratorModelElement ) {
            GeneratorModelElement modelElement = (GeneratorModelElement) element;

            writeElement(feedback, genModel, modelElement);
         }
         else {
            feedback.message(Feedback.WARNING, "element "+element.toString()+" ignored "+element.getClass().getName()+" not instanceof GeneratorModelElement");
         }
      }
   }

   /** Generierung des Moduls */
   private void writeElement(Feedback feedback, GeneratorModel genModel, GeneratorModelElement modelElement) {
      boolean generated = false;

      for (Iterator iter = modelElement.getStereotypes().iterator(); iter.hasNext();) {
         String stereoType = (String) iter.next();
         
         if ( writeElementStereotype(feedback, genModel, modelElement, stereoType) ) {
            generated = true;
         }
      }

      Profile profile = genModel.getProfile().getProfile();
      for (Iterator iter = profile.getMetaModelElements().iterator(); iter.hasNext();) {
         MetaModelElement metaModelElement = (MetaModelElement) iter.next();
         
         if ( metaModelElement.match((ModelElementBase)modelElement) ) {
            for (Iterator ia = metaModelElement.getMappings().iterator(); ia.hasNext();) {
               Mapping mapping = (Mapping) ia.next();
               Artefact artefact = mapping.getArtefact();

               if ( checkSkipModelElement(artefact, modelElement) == false ) {
                  genModel.getContext().setCurrentArtefact(artefact);
                  genModel.getContext().setCurrentModelElement(modelElement);
                  generated = generated | write(feedback, genModel, modelElement, artefact.getWriter(), null);
               }
               else {
                  feedback.message(Feedback.INFO, "Skiped model element "+modelElement.getName()+" for "+artefact.getName());
               }
            }
         }
      }

      if ( generated ) { 
            feedback.message(Feedback.INFO, "Generated for model class "+modelElement.getName());
         }
      }

   /**
    * @param artefact
    * @param modelElement
    * @return
    */
   private boolean checkSkipModelElement(Artefact artefact, GeneratorModelElement modelElement) {
      if ( artefact.getGenerationStrategy() != null ) {
         GenerationStrategy strategy = (GenerationStrategy) generationStrategieMap.get(artefact);
         
         if ( strategy == null ) {
            List classLoaders = new ArrayList(additionalClassLoaders);
            classLoaders.add(baseClassLoader);
            strategy = (GenerationStrategy) createClass(classLoaders, artefact.getGenerationStrategy()); 
            generationStrategieMap.put(artefact, strategy);
   }

         return strategy.skipGeneration(modelElement);
      }
      else 
         return false;
   }

   private boolean writeElementStereotype(Feedback feedback, GeneratorModel genModel, GeneratorModelElement modelElement, String stereoType) {
      // Look for mappings
      boolean generated = false;
      
      for (Iterator ia = genModel.getArtefacts(stereoType).iterator(); ia.hasNext();) {
         Artefact artefact = (Artefact) ia.next();
         
         if ( checkSkipModelElement(artefact, modelElement) == false ) {
	         genModel.getContext().setCurrentArtefact(artefact);
	         genModel.getContext().setCurrentModelElement(modelElement);
	         generated = generated | write(feedback, genModel, modelElement, artefact.getWriter(), null);
         }
      }
      
      return generated;
   }

   private boolean write(
      Feedback feedback,
      GeneratorModel genModel,
      GeneratorModelElement modelElement,
      String writerName,
      ChildMappings mappings) 
   {
      File generateFolder = new File(getOutputFolder(), genModel.getProfile().getDestination());
      ModelPackage modelPackage = null;
      if ( modelElement instanceof ModelPackage ) {
         modelPackage = (ModelPackage) modelElement;
      }
      else if ( modelElement instanceof ModelClass ) {
         modelPackage = ((ModelClass)modelElement).getPackage();
      }
      else if ( modelElement instanceof ModelMethod ) {
         modelPackage = (ModelPackage) ((ModelMethod)modelElement).getOwningClass().getPackageBase();
      }

      String qualifiedPackageName = modelPackage != null ? modelPackage.getQualifiedName() : "";
      
      if ( matchPackage(genModel, qualifiedPackageName) ) {
         try {
            Artefact artefact = genModel.getArtefact(); 
            AbstractWriter writer = (AbstractWriter) writers.get(artefact);
            
            if ( writer == null ) {
               if (artefact.getType() == WriterType.FREE_MARKER_LITERAL) {
                  writer = new FreeMarkerWriter(feedback, writerName, templatePaths);
               }
               else if (artefact.getType() == WriterType.VELOCITY_LITERAL) {
                  writer = new VelocityWriter(runtime, writerName, templatePaths);
               }
               else if (artefact.getType() == WriterType.EXPAND_LITERAL) {
                  writer = new XpandWriter(runtime, writerName, templatePaths);
               }
               else {
                  writer = createWriter(feedback, writerName);
               }
               
               if ( writer != null ) {
                  writers.put(artefact, writer);
               }
            }

            if ( writer != null ) {
               config.setDefaults();
               writer.setConfig(config);
               writer.setModelElement(modelElement);
               writer.setGenerator(this);
            }
            
            if ( writer != null && writer.generateOutput() == false ) {
               logger.finer(modelElement.toString()+" skipped by writer");
               return false;
            }
            
            if (writer != null && writer instanceof AbstractParentWriter ) {
               logger.finer(modelElement.toString()+" generated by "+writer.toString());
               AbstractParentWriter parentWriter = (AbstractParentWriter) writer;

               parentWriter.setOutputFolder(generateFolder);
               File actualOutputFolder = parentWriter.getOutputFolder();
               if (actualOutputFolder.exists() == false)
                  actualOutputFolder.mkdirs();
               if (mappings != null && writer instanceof AbstractParentWriter) {

                  parentWriter.setMappings(mappings);
               }
               parentWriter.run();
               generatedFile.add(parentWriter.getGeneratedSource());
            }
         } catch (Exception e) {
            feedback.message(Feedback.ERROR, "Fatal error occured while generating: " + e.toString());
            feedback.printStackTrace(e);
            throw new RuntimeException(e);
         } 
         return true;
      }
      else {
         logger.fine(modelElement.toString()+" not in package skope");
         feedback.message(Feedback.DEBUG, modelElement.toString()+" not in package skope");
         return false; 
      }
   }

   /**
    * @param genModel
    * @param qualifiedName
    * @return
    */
   private boolean matchPackage(GeneratorModel genModel, String qualifiedName) {
      if ( StringUtils.isNotEmpty(currentProfile.getPackagePrefix())) {
         StringTokenizer packageFilterParser = new StringTokenizer(currentProfile.getPackagePrefix(), ",");
         boolean match = false;
         
         while ( !match && packageFilterParser.hasMoreTokens() ) {
            String packagePrefix = packageFilterParser.nextToken();
            
            if ( qualifiedName.startsWith(packagePrefix) ) {
               match = true;
            }
         }
         return match;
      }
      else {
         return true;
      }
   }

   final AbstractWriter createWriter(Feedback feedback, String writerName) {
      AbstractWriter writer = null;
      try {
         writer = (AbstractWriter) createClass(writerName, externalWriters);
      } catch (ClassNotFoundException e) {
         feedback.message(Feedback.WARNING, "writer not found: " + writerName);
      }
      return writer;
   }

   /**
    * Returns the outputFolder.
    * @return String
    */
   public File getOutputFolder() {
      return outputFolder;
   }

   /**
    * Sets the outputFolder.
    * @param outputFolder The outputFolder to set
    */
   public void setOutputFolder(String outputFolder) {
      this.outputFolder = new File(outputFolder);
      getFeedback().message(Feedback.DEBUG, "set outputfolder to "+outputFolder);
   }

   /**
    * Sets the modelFile.
    * @param modelFile The modelFile to set
    */
   public void setModelFile(File modelFile) {
      this.modelFile = modelFile;
   }

   /**
    * Sets the outputFolder.
    * @param outputFolder The outputFolder to set
    */
   public void setOutputFolder(File outputFolder) {
      this.outputFolder = outputFolder;
   }

   /**
    * @param string
    */
   public void setModelFactoryName(String string) {
      modelFactoryName = string;
      modelFactory = null;
   }

   public void setPathMap(Map pathMap) {
      this.pathMap = pathMap;
   }
   
	public ModelBase getModel() {
		return pimModelBase;
	}
   
	public void setModel(ModelBase model) {
       pimModelBase = model;
	}
   
   /**
    * Set a map with external writer classes, key is the writer name
    */
   public void setExternalWriters(Map externalWriters) {
      this.externalWriters = externalWriters;
      for (Iterator iter = externalWriters.keySet().iterator(); iter.hasNext();) {
         String writerName = (String) iter.next();
         Class writerClass = (Class) externalWriters.get(writerName);
         
         getFeedback().message(Feedback.DEBUG, "set external writer \""+writerName+"\" to "+writerClass.getName());
      }
   }
   
   /**
    * Set a map with extern writer classes, key is the factory name
    * @param externalAdapterFactories
    */
   public void setExternalAdapterFactories(Map externalAdapterFactories) {
      this.externalAdapterFactories = externalAdapterFactories;
      for (Iterator iter = externalAdapterFactories.keySet().iterator(); iter.hasNext();) {
         String adapterFactoryName = (String) iter.next();
         Class adapterFactoryClass = (Class) externalAdapterFactories.get(adapterFactoryName);
         getFeedback().message(Feedback.DEBUG, "set external adapter factory \""+adapterFactoryName+"\" to "+adapterFactoryClass.getName());
      }
   }

   public Map getExternalValidatorFactories() {
      return externalValidatorFactories;
   }
   public void setExternalValidatorFactories(Map externalValidatorFactories) {
      this.externalValidatorFactories = externalValidatorFactories;
      for (Iterator iter = externalValidatorFactories.keySet().iterator(); iter.hasNext();) {
         String adapterFactoryName = (String) iter.next();
         Class adapterFactoryClass = (Class) externalValidatorFactories.get(adapterFactoryName);
         getFeedback().message(Feedback.DEBUG, "set external valiation factory \""+adapterFactoryName+"\" to "+adapterFactoryClass.getName());
      }
   }
   
   public List getTemplatePaths() {
      return templatePaths;
   }
   
   /**
    * Set list of directories to look for none compiled templates
    * (velocity, freemarker, ..). 
    * @param templatePaths list of @link java.lang.String or @link File 
    *        containing templates.
    */
   public void setTemplatePaths(List templatePaths) {
      this.templatePaths = templatePaths;
      for (Iterator iter = templatePaths.iterator(); iter.hasNext();) {
         Object path = iter.next(); // Can be String or URL
         getFeedback().message(Feedback.DEBUG, "set external template path to "+path.toString());
      }
   }
   
   public Feedback getFeedback() {
      return runtime.getFeedback();
   }
   
   public void setFeedback(Feedback feedback) {
      runtime.setFeedback(feedback);
   }
   
   public GenerationSet getGenerationSet() {
      return generationSet;
   }
   public void setGenerationSet(GenerationSet generationSet) {
      this.generationSet = generationSet;
   }
   public String getGenerationSetName() {
      return generationSetName;
   }
   public void setGenerationSetName(String generationSetName) {
      this.generationSetName = generationSetName;
   }
   
   public ClassLoader getBaseClassLoader() {
      return baseClassLoader;
   }
   
   public void setBaseClassLoader(ClassLoader classLoader) {
      this.baseClassLoader = classLoader;
      getFeedback().message(Feedback.DEBUG, "set classloader to "+classLoader.toString());
   }

   /**
    * @return Returns the additionalClassLoaders.
    */
   public List getAdditionalClassLoaders() {
      return additionalClassLoaders;
   }
   /**
    * @param additionalClassLoaders The additionalClassLoaders to set.
    */
   public void setAdditionalClassLoaders(List additionalClassLoaders) {
      this.additionalClassLoaders = additionalClassLoaders;
   }
   
   /**
    * @return Returns the runtime.
    */
   public GeneratorRuntime getRuntime() {
      return runtime;
   }

   /**
    * @param formatterProvider The formatterProvider to set.
    */
   public void addFormatterProvider(FormatterProvider formatterProvider) {
      this.formatterProviders.add(formatterProvider);
   }
}
