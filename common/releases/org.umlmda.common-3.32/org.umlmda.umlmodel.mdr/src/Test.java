import java.io.File;
import java.util.Iterator;

import javax.jmi.model.ModelElement;
import javax.jmi.model.ModelPackage;
import javax.jmi.model.MofPackage;
import javax.jmi.xmi.XmiReader;

import org.netbeans.api.mdr.MDRManager;
import org.netbeans.api.mdr.MDRepository;
import org.netbeans.api.xmi.XMIReaderFactory;
import org.netbeans.lib.jmi.xmi.InputConfig;
import org.omg.uml.foundation.core.DataType;
import org.omg.uml.foundation.core.Stereotype;
import org.omg.uml.foundation.core.TaggedValue;
import org.omg.uml.foundation.core.UmlClass;
import org.omg.uml.modelmanagement.Model;
import org.omg.uml.modelmanagement.UmlPackage;

/*
 * Created on Nov 5, 2004
 *
 * To change the template for this generated file go to
 */

/**
 * @author moroff
 *
 */
public class Test {

   // name of a MOF extent that will serve as a target extent for the UML2MOF transformation
   private static final String MOF_INSTANCE = "MOFInstance";
   // name of a UML extent (instance of UML metamodel) that the UML models will be loaded into
   private static final String UML_INSTANCE = "UMLInstance";
   // name of a MOF extent that will contain definition of UML metamodel
   private static final String UML_MM = "UML";

   // repository
   private static MDRepository rep;
   // UML extent
   private static org.omg.uml.UmlPackage uml;
   // MOF extent
   private static ModelPackage mof;
   // XMI reader
   private static XmiReader reader;
    
   public static void main(String args[]) {
       try {
           // get the default repository from the MDR manager
           rep = MDRManager.getDefault().getDefaultRepository();
           // get's the URL of the file passed as the first commandline parameter
           // (file containing the UML model to be transformed to MOF)
           String uri = new File(args[0]).toURL().toString();
           // look up an implementation of XmiReader interface
           InputConfig inputConfig = new InputConfig();
//           inputConfig.setUnknownElementsIgnored(true);
           reader = XMIReaderFactory.getDefault().createXMIReader(inputConfig);
            
           // initialize the repository (make sure the UML metamodel is loaded and both
           // UML and MOF metamodels are instantiated)
           init();
            
           // start a write transaction
           rep.beginTrans(true);
           try {
               // read the UML model into the UML extent
               reader.read(uri, uml);
               
               // List the packages
              for (Iterator iter = uml.getCore().getNamespace().refAllOfType().iterator(); iter.hasNext();) {
               //for (Iterator iter = uml.getModelManagement().refAllPackages().iterator(); iter.hasNext();) {
                  Object element = (Object) iter.next();

                  if ( element instanceof Model ) {
                     Model model = (Model) element;
                     
                     System.out.println("Model:\""+model.getName()+"\"");
                  }
                  if ( element instanceof UmlPackage ) {
                     UmlPackage umlPackage = (UmlPackage) element;
                     org.omg.uml.foundation.core.ModelElement owningNamespace = umlPackage.getNamespace();
                                          
                     if ( owningNamespace instanceof Model ) {                     
                        System.out.println("Package: \""+umlPackage.getName()+"\"");
                        dump(umlPackage);
                     }
                  }
               }
           } finally {
               // rollback the write transaction
               // (this is to make sure the transformed models are not kept in the storage - they
               // will probably not be needed anymore - another alternative to this would be to
               // remove both UML model and the resulting MOF metamodel and do commit, but in this
               // case doing rollback is simpler)
               rep.endTrans(true);
               // shutdown the repository to make sure all caches are flushed to disk
               MDRManager.getDefault().shutdownAll();
           }
       } catch (Exception e) {
          e.printStackTrace();
       }
   }

   private static void dump(org.omg.uml.foundation.core.Namespace namespace) {
      for (Iterator iterator = namespace.getOwnedElement().iterator(); iterator.hasNext();) {
         Object mElement = iterator.next();
         
         dump(mElement);
      }   
   }

   private static void dump(Object mElement) {
      if ( mElement instanceof ModelElement ) {
         ModelElement modelElement = (ModelElement) mElement;
         
         System.out.println(modelElement.getName());
      }
      else if (mElement instanceof org.omg.uml.modelmanagement.UmlPackage ) {
         UmlPackage  umlPackage = (UmlPackage) mElement;
         
         System.out.println("Package: \""+umlPackage.getName()+"\"");
         dump(umlPackage);
      }
      else if (mElement instanceof UmlClass ) {
         UmlClass  umlClass = (UmlClass ) mElement;
         
         System.out.println("Class = \""+umlClass.getName()+"\"");
         
         for (Iterator iter = umlClass.getStereotype().iterator(); iter.hasNext();) {
            Stereotype stereotype = (Stereotype) iter.next();

            System.out.print("Stereotype: "+stereotype.getName());
         }
         for (Iterator iter = umlClass.getTaggedValue().iterator(); iter.hasNext();) {
            TaggedValue taggedValue = (TaggedValue) iter.next();
            
            System.out.print("Tagged-Value: "+taggedValue.getType().getName()+"=");
            for (Iterator ir = taggedValue.getDataValue().iterator(); ir.hasNext();) {
               Object element = (Object) ir.next();
               
               System.out.print("\""+element+"\"");
               if ( ir.hasNext() )
                  System.out.print(", ");
               else   
                  System.out.println(";");
            }
            System.out.println("Tagged-Value: "+taggedValue.getReferenceValue()+"=");
         }
      }
      else if (mElement instanceof Stereotype ) {
         Stereotype stereotype = (Stereotype) mElement;
      
         System.out.println("Stereotype: \""+stereotype.getName()+"\"");                           
      }
      else if (mElement instanceof DataType ) {
         DataType dataType = (DataType) mElement;
      
         System.out.println("Datatype: \""+dataType.getName()+"\"");                           
      }
      else 
         System.out.println(mElement);
   }
    
   /** Makes sure UML and MOF extents are created. */
   private static void init() throws Exception {
       // try to retrieve MOF and UML extents
       mof = (ModelPackage) rep.getExtent(MOF_INSTANCE);
       uml = (org.omg.uml.UmlPackage) rep.getExtent(UML_INSTANCE);
       // check whether both extents exist (they do not exist if this is the first time
       // the UML2MOF tool is run or the storage files created by previous runs
       // were deleted)
       if (mof == null) {
           // MOF extent does not exist -> create it
           mof = (ModelPackage) rep.createExtent(MOF_INSTANCE);
       }
       if (uml == null) {
           // UML extent does not exist -> create it (note that in case one want's to instantiate
           // a metamodel other than MOF, they need to provide the second parameter of the createExtent
           // method which indicates the metamodel package that should be instantiated)
           uml = (org.omg.uml.UmlPackage) rep.createExtent(UML_INSTANCE, getUmlPackage());
       }
   }
    
   /** Finds "UML" package -> this is the topmost package of UML metamodel - that's the
    * package that needs to be instantiated in order to create a UML extent
    */
   private static MofPackage getUmlPackage() throws Exception {
       // get the MOF extent containing definition of UML metamodel
       ModelPackage umlMM = (ModelPackage) rep.getExtent(UML_MM);
       if (umlMM == null) {
           // it is not present -> create it
           umlMM = (ModelPackage) rep.createExtent(UML_MM);
       }
       // find package named "UML" in this extent
       MofPackage result = getUmlPackage(umlMM);
       if (result == null) {
           // it cannot be found -> UML metamodel is not loaded -> load it from XMI
           reader.read(UmlPackage.class.getResource("resources/01-02-15_Diff.xml").toString(), umlMM);
           // try to find the "UML" package again
           result = getUmlPackage(umlMM);
       }
       return result;
   }
    
   /** Finds "UML" package in a given extent
    * @param umlMM MOF extent that should be searched for "UML" package.
    */
   private static MofPackage getUmlPackage(ModelPackage umlMM) {
       // iterate through all instances of package
       for (Iterator it = umlMM.getMofPackage().refAllOfClass().iterator(); it.hasNext();) {
           MofPackage pkg = (MofPackage) it.next();
           // is the package topmost and is it named "UML"?
           if (pkg.getContainer() == null && "UML".equals(pkg.getName())) {
               // yes -> return it
               return pkg;
           }
       }
       // a topmost package named "UML" could not be found
       return null;
   }

}
