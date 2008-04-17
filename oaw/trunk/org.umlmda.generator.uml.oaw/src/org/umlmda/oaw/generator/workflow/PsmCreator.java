/**
 * 
 */
package org.umlmda.oaw.generator.workflow;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.validate.ModelValidationException;

/**
 * @author MOROFF
 *
 */
public class PsmCreator extends AbstractWorkflowComponent {
   private String adapterFactory;
   private String pimModelSlot;
   private String psmModelSlot;
   private String generationSetSlot;
   private String generationProfile;
   private Logger logger = Logger.getLogger(getClass());
   

   /* (non-Javadoc)
    * @see org.openarchitectureware.workflow.WorkflowComponent#checkConfiguration(org.openarchitectureware.workflow.issues.Issues)
    */
   public void checkConfiguration(Issues issues) {
      // TODO Auto-generated method stub

   }

   /* (non-Javadoc)
    * @see org.openarchitectureware.workflow.WorkflowComponent#invoke(org.openarchitectureware.workflow.WorkflowContext, org.openarchitectureware.workflow.monitor.ProgressMonitor, org.openarchitectureware.workflow.issues.Issues)
    */
   @SuppressWarnings("unchecked")
   public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      Class<ModelAdapterFactory> adapterFactoryClass;
      ModelAdapterFactory factory;
      Model pimModel = (Model) ctx.get(pimModelSlot);
      GeneratorModel psmModel = null;
      GenerationSet set = null;
      
      try {
         adapterFactoryClass = (Class<ModelAdapterFactory>) Class.forName(adapterFactory);
         factory = adapterFactoryClass.newInstance();
         psmModel = (GeneratorModel) factory.createModel(pimModel);
         set = (GenerationSet) ctx.get(generationSetSlot);
         psmModel.setGenerationSet(set);
         
         // Lockup and set profile
         for (Iterator ip = set.getGenerationProfile().iterator(); ip.hasNext();) {
            GenerationProfile generationProfile = (GenerationProfile) ip.next();
            Profile profile = generationProfile.getProfile();
            
            if ( this.generationProfile.equals(profile.getName()) ) {
               psmModel.setProfile(generationProfile);
            }
         }
         ctx.set(psmModelSlot, psmModel);
         logger.info("Put instance of "+psmModel.getClass()+" to "+psmModelSlot);
      } catch (ClassNotFoundException e) {
         issues.addError("modeladapter class "+adapterFactory+" could not be loaded");
      } catch (InstantiationException e) {
         issues.addError("modeladapter class "+adapterFactory+" could not be instantiated "+e.getMessage());
      } catch (IllegalAccessException e) {
         issues.addError("modeladapter class "+adapterFactory+" could not be instantiated "+e.getMessage());
      } catch (ModelValidationException e) {
         issues.addError("Model is not valid "+e.getValidationResults().toString());
      }

   }

   /**
    * @return the adapterFactory
    */
   public String getAdapterFactory() {
      return adapterFactory;
   }

   /**
    * @param adapterFactory the adapterFactory to set
    */
   public void setAdapterFactory(String adapterFactory) {
      this.adapterFactory = adapterFactory;
   }

   /**
    * @return the pimModelSlot
    */
   public String getPimModelSlot() {
      return pimModelSlot;
   }

   /**
    * @param pimModelSlot the pimModelSlot to set
    */
   public void setPimModelSlot(String pimModelSlot) {
      this.pimModelSlot = pimModelSlot;
   }

   /**
    * @return the psmModelSlot
    */
   public String getPsmModelSlot() {
      return psmModelSlot;
   }

   /**
    * @param psmModelSlot the psmModelSlot to set
    */
   public void setPsmModelSlot(String psmModelSlot) {
      this.psmModelSlot = psmModelSlot;
   }

   /**
    * @return the generationSetSlot
    */
   public String getGenerationSetSlot() {
      return generationSetSlot;
   }

   /**
    * @param generationSetSlot the generationSetSlot to set
    */
   public void setGenerationSetSlot(String generationSetSlot) {
      this.generationSetSlot = generationSetSlot;
   }

   /**
    * @return the generationProfile
    */
   public String getGenerationProfile() {
      return generationProfile;
   }

   /**
    * @param generationProfile the generationProfile to set
    */
   public void setGenerationProfile(String generationProfile) {
      this.generationProfile = generationProfile;
   }

}
