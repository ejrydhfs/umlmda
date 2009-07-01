/*
 * Created on Nov 16, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.umlmda.model.uml.mdr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.jmi.model.ModelPackage;
import javax.jmi.model.MofPackage;
import javax.jmi.reflect.RefPackage;
import javax.jmi.xmi.MalformedXMIException;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.netbeans.api.mdr.CreationFailedException;
import org.netbeans.api.mdr.MDRManager;
import org.netbeans.api.mdr.MDRepository;
import org.netbeans.api.xmi.XMIReader;
import org.netbeans.api.xmi.XMIReaderFactory;
import org.netbeans.api.xmi.XMIWriter;
import org.netbeans.api.xmi.XMIWriterFactory;
import org.omg.uml.UmlPackage;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelFactory;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ModelFactoryImpl implements ModelFactory {

   //   // name of a MOF extent that will serve as a target extent for the UML2MOF transformation
   //   private static final String MOF_INSTANCE = "MOFInstance";
   //   // name of a UML extent (instance of UML metamodel) that the UML models will be loaded into
   //   private static final String UML_INSTANCE = "UMLInstance";
   //   // name of a MOF extent that will contain definition of UML metamodel
   //   private static final String UML_MM = "UML";
   //
   //   // repository
   //   private static MDRepository rep;
   //   // UML extent
   //   private static org.omg.uml.UmlPackage uml;
   //   // MOF extent
   //   private static ModelPackage mof;
   //   // XMI reader
   //   private static XmiReader reader;
   //
   //   public Model loadModel(File modelFile) throws IOException
   //   {
   //      Model model = null;
   //      InputStream modelStream = null;
   //      
   //      if ( modelFile.getPath().endsWith("zuml")) {
   //         ZipFile zipFile = new ZipFile(modelFile, ZipFile.OPEN_READ);
   //         for (Enumeration ez = zipFile.entries(); ez.hasMoreElements();) {
   //            ZipEntry zipEntry = (ZipEntry) ez.nextElement();
   //                     
   //            if ( zipEntry.getName().endsWith(".xmi")) {
   //               modelStream = zipFile.getInputStream(zipEntry);
   //               break;
   //            }
   //         }
   //         if ( modelStream == null )
   //            throw new RuntimeException("No xmi entry in " + modelFile.getAbsolutePath());
   //      }
   //      else {
   //         modelStream = new FileInputStream(modelFile);
   //      }
   //      
   //      return loadModel(modelStream);
   //   }
   //   
   //   /* (non-Javadoc)
   //    * @see net.sourceforge.umlmda.xmi.uml.ModelFactory#loadModel(java.io.InputStream)
   //    */
   //   public Model loadModel(InputStream modelStream) throws IOException {
   //      Model model = null;
   //      
   //      // get the default repository from the MDR manager
   //      rep = MDRManager.getDefault().getDefaultRepository();
   //      // get's the URL of the file passed as the first commandline parameter
   //      // (file containing the UML model to be transformed to MOF)
   //      // look up an implementation of XmiReader interface
   //      InputConfig inputConfig = new InputConfig();
   //      inputConfig.setUnknownElementsIgnored(true);
   //      reader = XMIReaderFactory.getDefault().createXMIReader(inputConfig);
   //            
   //      try {
   //         // initialize the repository (make sure the UML metamodel is loaded and both
   //         // UML and MOF metamodels are instantiated)
   //         init();
   //
   //         // start a write transaction
   //         rep.beginTrans(true);
   //
   //         // read the UML model into the UML extent
   //         reader.read(modelStream, null, uml);
   //
   //         for (Iterator iter = uml.getCore().getNamespace().refAllOfType().iterator(); iter.hasNext();) {
   //             Object element = (Object) iter.next();
   //
   //             if ( element instanceof org.omg.uml.modelmanagement.Model ) {
   //                model = new ModelImpl((org.omg.uml.modelmanagement.Model) element);
   //                break;
   //             }
   //          }
   //
   //      } catch (CreationFailedException e) {
   //         // TODO Auto-generated catch block
   //         e.printStackTrace();
   //      } catch (MalformedXMIException e) {
   //         // TODO Auto-generated catch block
   //         e.printStackTrace();
   //      }
   //      finally {
   //      }
   //      return model;
   //   }
   //
   //   /** Makes sure UML and MOF extents are created. */
   //   private static void init() throws CreationFailedException, IOException, MalformedXMIException {
   //       // try to retrieve MOF and UML extents
   //       mof = (ModelPackage) rep.getExtent(MOF_INSTANCE);
   //       uml = (org.omg.uml.UmlPackage) rep.getExtent(UML_INSTANCE);
   //       // check whether both extents exist (they do not exist if this is the first time
   //       // the UML2MOF tool is run or the storage files created by previous runs
   //       // were deleted)
   //       if (mof == null) {
   //           // MOF extent does not exist -> create it
   //           mof = (ModelPackage) rep.createExtent(MOF_INSTANCE);
   //       }
   //       if (uml == null) {
   //           // UML extent does not exist -> create it (note that in case one want's to instantiate
   //           // a metamodel other than MOF, they need to provide the second parameter of the createExtent
   //           // method which indicates the metamodel package that should be instantiated)
   //           uml = (org.omg.uml.UmlPackage) rep.createExtent(UML_INSTANCE, getUmlPackage());
   //       }
   //   }
   //
   //   /** Finds "UML" package -> this is the topmost package of UML metamodel - that's the
   //    * package that needs to be instantiated in order to create a UML extent
   //    */
   //   private static MofPackage getUmlPackage() throws CreationFailedException, IOException, MalformedXMIException {
   //       // get the MOF extent containing definition of UML metamodel
   //       ModelPackage umlMM = (ModelPackage) rep.getExtent(UML_MM);
   //       if (umlMM == null) {
   //           // it is not present -> create it
   //           umlMM = (ModelPackage) rep.createExtent(UML_MM);
   //       }
   //       // find package named "UML" in this extent
   //       MofPackage result = getUmlPackage(umlMM);
   //       if (result == null) {
   //           // it cannot be found -> UML metamodel is not loaded -> load it from XMI
   //           reader.read(UmlPackage.class.getResource("resources/01-02-15_Diff.xml").toString(), umlMM);
   //           // try to find the "UML" package again
   //           result = getUmlPackage(umlMM);
   //       }
   //       return result;
   //   }
   //
   //   /** Finds "UML" package in a given extent
   //    * @param umlMM MOF extent that should be searched for "UML" package.
   //    */
   //   private static MofPackage getUmlPackage(ModelPackage umlMM) {
   //       // iterate through all instances of package
   //       for (Iterator it = umlMM.getMofPackage().refAllOfClass().iterator(); it.hasNext();) {
   //           MofPackage pkg = (MofPackage) it.next();
   //           // is the package topmost and is it named "UML"?
   //           if (pkg.getContainer() == null && "UML".equals(pkg.getName())) {
   //               // yes -> return it
   //               return pkg;
   //           }
   //       }
   //       // a topmost package named "UML" could not be found
   //       return null;
   //   }
   //
   //   /* (non-Javadoc)
   //    * @see net.sourceforge.umlmda.xmi.uml.ModelFactory#setPathMap(java.util.Map)
   //    */
   //   public void setPathMap(Map pathMap) {
   //   }

   private static Log logger = LogFactory.getLog(ModelFactoryImpl.class);

   protected final static String META_PACKAGE = "UML";

   //    private ModelAccessFacade modelFacade = null;

   static {
      // configure MDR to use an in-memory storage implementation
      System.setProperty(
         "org.netbeans.mdr.storagemodel.StorageFactoryClassName",
         "org.netbeans.mdr.persistence.memoryimpl.StorageFactoryImpl");
      // set the logging so output does not go to standard out
      System.setProperty("org.netbeans.lib.jmi.Logger.fileName", "mdr.log");
   }

   protected URL metaModelURL;
   protected RefPackage model = null;

   /**
    * Constructs a Facade around a netbeans MDR (MetaDataRepository).
    */
   public ModelFactoryImpl() {
      String metamodelUri = "/M2_DiagramInterchangeModel.xml";
      // the default metamodel is now UML 1.4 plus UML 2.0 diagram extensions
      metaModelURL = ModelFactoryImpl.class.getResource(metamodelUri);

      if (metaModelURL == null) {
         throw new RuntimeException("Could not find meta model --> ' " + metamodelUri + "'");
      }
   }

   /**
    * Opens the repository and prepares it to read in models.
    * <p>
    * All the file reads are done within the context of a transaction: this
    * seems to speed up the processing.
    * </p>
    * 
    * @see org.andromda.core.repository.RepositoryFacade#open()
    */
   public void open() {
      MDRManager.getDefault().getDefaultRepository().beginTrans(true);
   }

   /**
    * Closes the repository and reclaims all resources.
    * <p>
    * This should only be called after all model processing has been completed.
    * </p>
    * 
    * @see org.andromda.core.repository.RepositoryFacade#close()
    */
   public void close() {
      MDRepository repository = MDRManager.getDefault().getDefaultRepository();
      repository.endTrans(true);
      // remove the model from the repository (if there is one)
      RefPackage model = repository.getExtent(EXTENT_NAME);
      if (model != null) {
         model.refDelete();
      }
      this.model = null;
   }

   /**
    * @see org.andromda.core.common.RepositoryFacade#readModel(java.net.URL,
    *      java.lang.String[])
    */
   public void readModel(URL modelURL, String[] moduleSearchPath) {
      final String methodName = "MDRepositoryFacade.readModel";
      //        ExceptionUtils.checkNull(methodName, "modelURL", modelURL);
      MofPackage metaModel = null;

      if (logger.isDebugEnabled())
         logger.debug("creating repository");

      MDRepository repository = MDRManager.getDefault().getDefaultRepository();

      try {
         metaModel = loadMetaModel(metaModelURL, repository);

      } catch (Throwable th) {
         String errMsg = "Error performing " + methodName;
         throw new RuntimeException(errMsg, th);
      }

      try {
         this.model = loadModel(modelURL, moduleSearchPath, metaModel, repository);
      } catch (CreationFailedException e) {
         String errMsg = "Error performing " + methodName;
         throw new RuntimeException(errMsg, e);
      }

      if (logger.isDebugEnabled())
         logger.debug("created repository");
   }

   /**
    * @see org.andromda.core.common.RepositoryFacade#readModel(java.net.URL,
    *      java.lang.String[])
    */
   public void readModel(InputStream modelStream, String[] moduleSearchPath) {
      final String methodName = "MDRepositoryFacade.readModel";
      //        ExceptionUtils.checkNull(methodName, "modelURL", modelURL);
      MofPackage metaModel = null;

      if (logger.isDebugEnabled())
         logger.debug("creating repository");

      MDRepository repository = MDRManager.getDefault().getDefaultRepository();

      try {
         metaModel = loadMetaModel(metaModelURL, repository);

      } catch (Throwable th) {
         String errMsg = "Error performing " + methodName;
         throw new RuntimeException(errMsg, th);
      }

      try {
         this.model = loadModel(modelStream, moduleSearchPath, metaModel, repository);
      } catch (CreationFailedException e) {
         String errMsg = "Error performing " + methodName;
         throw new RuntimeException(errMsg, e);
      }

      if (logger.isDebugEnabled())
         logger.debug("created repository");
   }

   /**
    * The default XMI version if none is specified.
    */
   private static final String DEFAULT_XMI_VERSION = "1.2";

   /**
    * The default encoding if none is specified
    */
   private static final String DEFAULT_ENCODING = "UTF-8";

   /**
    * @see org.andromda.core.repository.RepositoryFacade#writeModel(java.lang.Object,
    *      java.lang.String, java.lang.String)
    */
   public void writeModel(Object model, String outputLocation, String xmiVersion) {
      this.writeModel(model, outputLocation, xmiVersion, null);
   }

   /**
    * @see org.andromda.core.repository.RepositoryFacade#writeModel(java.lang.Object,
    *      java.lang.String, java.lang.String)
    */
   public void writeModel(Object model, String outputLocation, String xmiVersion, String encoding) {
      final String methodName = "MDRepositoryFacade.writeMode";
      //        ExceptionUtils.checkNull(methodName, "model", model);
      //        ExceptionUtils.checkNull(methodName, "outputLocation", outputLocation);
      //        ExceptionUtils.checkAssignable(methodName, RefPackage.class, "model", model.getClass());
      if (StringUtils.isEmpty(xmiVersion)) {
         xmiVersion = DEFAULT_XMI_VERSION;
      }
      if (StringUtils.isEmpty(encoding)) {
         encoding = DEFAULT_ENCODING;
      }
      try {
         // ensure the directory we're writing to exists
         File file = new File(outputLocation);
         File parent = file.getParentFile();
         if (parent != null) {
            parent.mkdirs();
         }
         FileOutputStream outputStream = new FileOutputStream(file);
         XMIWriter xmiWriter = XMIWriterFactory.getDefault().createXMIWriter();
         xmiWriter.getConfiguration().setEncoding(encoding);
         xmiWriter.write(outputStream, outputLocation, (RefPackage) model, xmiVersion);
      } catch (Throwable th) {
         String errMsg = "Error performing MDRepositoryFacade.writeModel";
         logger.error(errMsg, th);
         throw new RuntimeException(errMsg, th);
      }
   }

   //    /**
   //     * @see org.andromda.core.repository.RepositoryFacade#getModel()
   //     */
   //    public ModelAccessFacade getModel()
   //    {
   //        if (this.modelFacade == null) 
   //        {
   //            try 
   //            {    
   //               this.modelFacade = 
   //                    (ModelAccessFacade)
   //                 ComponentContainer.instance().findComponent(
   //                     ModelAccessFacade.class);
   //                if (this.modelFacade == null) {
   //                    throw new RepositoryFacadeException(
   //                        "Could not find implementation for the component --> '" 
   //                        + ModelAccessFacade.class + "'");
   //                }
   //               this.modelFacade.setModel(this.model);
   //            } 
   //            catch (Throwable th) 
   //            {
   //               String errMsg = "Error performing MDRepositoryFacade.getModel";
   //                logger.error(errMsg, th);
   //                throw new RepositoryFacadeException(errMsg, th);
   //            }
   //        }
   //        return this.modelFacade;
   //    }

   /**
    * Loads a metamodel into the repository.
    * 
    * @param repository MetaDataRepository
    * @return MofPackage for newly loaded metamodel
    * @exception CreationFailedException
    * @exception IOException
    * @exception MalformedXMIException
    */
   private static MofPackage loadMetaModel(URL metaModelURL, MDRepository repository)
      throws CreationFailedException, IOException, MalformedXMIException {
      if (logger.isDebugEnabled())
         logger.debug("creating MetaModel using URL --> '" + metaModelURL + "'");

      // Use the metaModelURL as the name for the repository extent.
      // This ensures we can load mutiple metamodels without them colliding.
      ModelPackage metaModelExtent = (ModelPackage) repository.getExtent(metaModelURL.toExternalForm());

      if (metaModelExtent == null) {
         metaModelExtent = (ModelPackage) repository.createExtent(metaModelURL.toExternalForm());
      }

      MofPackage metaModelPackage = findPackage(META_PACKAGE, metaModelExtent);

      if (metaModelPackage == null) {
         XMIReader xmiReader = XMIReaderFactory.getDefault().createXMIReader();
         xmiReader.read(metaModelURL.toExternalForm(), metaModelExtent);

         // locate the UML package definition that was just loaded in
         metaModelPackage = findPackage(META_PACKAGE, metaModelExtent);
      }

      if (logger.isDebugEnabled())
         logger.debug("created MetaModel");
      return metaModelPackage;
   }

   /**
    * The name (unique within the repository) for the new package extent
    */
   private static final String EXTENT_NAME = "MODEL";

   /**
    * Loads a model into the repository and validates the model against the
    * given metaModel.
    * 
    * @param modelURL url of model
    * @param repository netbeans MDR
    * @param metaModel meta model of model
    * @return populated model
    * @exception CreationFailedException unable to create model in repository
    */
   private static RefPackage loadModel(
      URL modelURL,
      String[] moduleSearchPath,
      MofPackage metaModel,
      MDRepository repository)
      throws CreationFailedException {
      RefPackage model = prepareLoadModel(metaModel, repository);

      XMIReader xmiReader =
         XMIReaderFactory.getDefault().createXMIReader(
            new MDRXmiReferenceResolver(new RefPackage[] { model }, moduleSearchPath));

      if (logger.isDebugEnabled())
         logger.debug("reading model XMI --> '" + modelURL + "'");

      try {
         xmiReader.read(modelURL.toExternalForm(), model);
      } catch (Throwable th) {
         String errMsg = "Error performing MDRepository.loadModel";
         logger.error(errMsg, th);
         throw new RuntimeException(errMsg, th);
      }
      if (logger.isDebugEnabled())
         logger.debug("read XMI and created model");
      return model;
   }

   /**
    * Loads a model into the repository and validates the model against the
    * given metaModel.
    * 
    * @param modelURL url of model
    * @param repository netbeans MDR
    * @param metaModel meta model of model
    * @return populated model
    * @exception CreationFailedException unable to create model in repository
    */
   private static RefPackage loadModel(
      InputStream modelStream,
      String[] moduleSearchPath,
      MofPackage metaModel,
      MDRepository repository)
      throws CreationFailedException {
      RefPackage model = prepareLoadModel(metaModel, repository);

      XMIReader xmiReader =
         XMIReaderFactory.getDefault().createXMIReader(
            new MDRXmiReferenceResolver(new RefPackage[] { model }, moduleSearchPath));

      try {
         xmiReader.read(modelStream, null, model);
      } catch (Throwable th) {
         String errMsg = "Error performing MDRepository.loadModel";
         logger.error(errMsg, th);
         throw new RuntimeException(errMsg, th);
      }
      if (logger.isDebugEnabled())
         logger.debug("read XMI and created model");
      return model;
   }

   private static RefPackage prepareLoadModel(MofPackage metaModel, MDRepository repository)
      throws CreationFailedException {
      if (logger.isDebugEnabled())
         logger.debug("creating model");

      RefPackage model = repository.getExtent(EXTENT_NAME);
      if (model == null) {
         if (logger.isDebugEnabled())
            logger.debug("creating the new meta model");
         model = repository.createExtent(EXTENT_NAME, metaModel);
      }

      if (logger.isDebugEnabled())
         logger.debug("creating model extent");

      if (logger.isDebugEnabled())
         logger.debug("created model extent");
      return model;
   }

   /**
    * Searches a meta model for the specified package.
    * 
    * @param packageName name of package for which to search
    * @param metaModel meta model to search
    * @return MofPackage
    */
   private static MofPackage findPackage(String packageName, ModelPackage metaModel) {
      for (Iterator it = metaModel.getMofPackage().refAllOfClass().iterator(); it.hasNext();) {
         javax.jmi.model.ModelElement temp = (javax.jmi.model.ModelElement) it.next();

         if (temp.getName().equals(packageName)) {
            return (MofPackage) temp;
         }
      }

      return null;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelFactory#loadModel(java.io.InputStream)
    */
   public ModelBase loadModel(InputStream modelStream) throws IOException {
      readModel(modelStream, null);
      
      ModelBase model = null;

      for (Iterator iter = ((UmlPackage)(this.model)).getCore().getNamespace().refAllOfType().iterator(); iter.hasNext();) {
          Object element = (Object) iter.next();

          if ( element instanceof org.omg.uml.modelmanagement.Model ) {
             model = new ModelImpl((org.omg.uml.modelmanagement.Model) element);
             break;
          }
       }
      
      return model;
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelFactory#loadModel(java.io.File)
    */
   public ModelBase loadModel(File modelFile) throws IOException {
      ModelBase model = null;
      InputStream modelStream = null;

      if (modelFile.getPath().endsWith("zuml")) {
         ZipFile zipFile = new ZipFile(modelFile, ZipFile.OPEN_READ);
         for (Enumeration ez = zipFile.entries(); ez.hasMoreElements();) {
            ZipEntry zipEntry = (ZipEntry) ez.nextElement();

            if (zipEntry.getName().endsWith(".xmi")) {
               modelStream = zipFile.getInputStream(zipEntry);
               break;
            }
         }
         if (modelStream == null)
            throw new RuntimeException("No xmi entry in " + modelFile.getAbsolutePath());
      } else {
         modelStream = new FileInputStream(modelFile);
      }

      return loadModel(modelStream);
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelFactory#setPathMap(java.util.Map)
    */
   public void setPathMap(Map pathMap) {
   }

}
