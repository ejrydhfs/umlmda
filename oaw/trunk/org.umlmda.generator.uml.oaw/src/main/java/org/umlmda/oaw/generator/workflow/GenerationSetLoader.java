/**
 * 
 */
package org.umlmda.oaw.generator.workflow;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.lib.WorkflowComponentWithModelSlot;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.profile.impl.UmpPackageImpl;
import org.umlmda.generator.profile.util.UmpResourceFactoryImpl;
import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;
import org.umlmda.generator.set.impl.UmsPackageImpl;
import org.umlmda.generator.set.util.UmsResourceFactoryImpl;

/**
 * @author MOROFF
 */
public class GenerationSetLoader extends AbstractWorkflowComponent
{
   private String generationSet;

   private String generationSetSlot;

   private Logger logger = Logger.getLogger(getClass());

   /**
    * 
    */
   public GenerationSetLoader() {
   }

   /*
    * (non-Javadoc)
    * @see org.openarchitectureware.workflow.WorkflowComponent#invoke(org.openarchitectureware.workflow.WorkflowContext,
    * org.openarchitectureware.workflow.monitor.ProgressMonitor, org.openarchitectureware.workflow.issues.Issues)
    */
   public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      if ( monitor != null )
         monitor.beginTask("start loading " + generationSet, 0);
      GenerationSet set;

      // register emf packages
      UmsPackageImpl.init();
      UmpPackageImpl.init();

      // register emf resouce factories
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ums", new UmsResourceFactoryImpl());
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ump", new UmpResourceFactoryImpl());

      File generationSetFile = new File(generationSet);
      URI uri = URI.createFileURI(generationSetFile.getAbsolutePath());

      ResourceSet resourceSet = new ResourceSetImpl();
      // resourceSet.setURIConverter(new FileURIConverter(uri));
      Resource resource = resourceSet.getResource(uri, true);

      try {
         resource.load(null);
      }
      catch (IOException e) {
         e.printStackTrace();
      }

      EList list = resource.getContents();
      set = (GenerationSet) list.get(0);

      logger.info("loaded generationSet from " + resource.getURI().toFileString() + " to slot " + generationSetSlot);

      // More diagnostics
      for ( Iterator ip = set.getGenerationProfile().iterator(); ip.hasNext(); ) {
         GenerationProfile generationProfile = (GenerationProfile) ip.next();
         Profile profile = generationProfile.getProfile();

         logger.info("profile " + profile.getName() + " from " + ((EObject) profile).eResource().getURI().toFileString());
      }
      // Put the set to the slot
      ctx.set(generationSetSlot, set);
   }

   /**
    * @return the generationSet
    */
   public String getGenerationSet() {
      return generationSet;
   }

   /**
    * @param generationSet
    *           the generationSet to set
    */
   public void setGenerationSet(String generationSet) {
      this.generationSet = generationSet;
   }

   /**
    * @return the generationSetSlot
    */
   public String getGenerationSetSlot() {
      return generationSetSlot;
   }

   /**
    * @param generationSetSlot
    *           the generationSetSlot to set
    */
   public void setGenerationSetSlot(String generationSetSlot) {
      this.generationSetSlot = generationSetSlot;
   }

   public void checkConfiguration(Issues issues) {
      if ( generationSet == null ) {
         issues.addError(this, "generationSet not specified.");
      }
      else {
         File generationSetFile = new File(generationSet);

         if ( generationSetFile.canRead() == false ) {
            String msg = "File " + generationSetFile.getAbsolutePath() + " cannot be read";

            issues.addError(this, msg);
         }
      }
   }

}
