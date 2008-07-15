/*
 * Created on Apr 14, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.j2ee;

import java.util.Iterator;
import java.util.List;

import org.umlmda.generator.GeneratorRuntimeConfig;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.profile.ModelTaggedValues;
import org.umlmda.uml.generator.java.AbstractJavaPackageWriter;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class AbstractPackageWriter extends AbstractJavaPackageWriter {

   public AbstractPackageWriter() {
      super();
   }
   
   public void setConfig(GeneratorRuntimeConfig config) {
      super.setConfig(config);
      config.setEyecatcherPrefix("");
   }
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractWriter#generateOutput()
    */
   public boolean generateOutput() {
      boolean generateOutput = false;
      
      for (Iterator ic = getModelPackage().getClasses().iterator(); ic.hasNext();) {
         ModelClass modelClass = (ModelClass) ic.next();
         
         if ( modelClass.hasStereotype(ModelStereotype.BUSINESS_SERVICE) )
            generateOutput = true;
      }
      return generateOutput;
   }
   
   public String getModuleName() {
      return getModelPackage().getStereotypeProperty(ModelTaggedValues.EBJ_COMPONENT, getModelPackage().getName());
   }

   public List getTransactionTypes() {
      return ((J2EEModelPackage)getModelPackage()).getTransactionTypes();
   }
   
   public List getMethods(ModelClass modelClass, String transactionType) {
      return ((J2EEModelPackage)getModelPackage()).getMethods(modelClass, transactionType);
   }
}
