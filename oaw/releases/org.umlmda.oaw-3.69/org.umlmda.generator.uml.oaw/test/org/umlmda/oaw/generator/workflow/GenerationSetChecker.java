package org.umlmda.oaw.generator.workflow;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;

public class GenerationSetChecker extends AbstractWorkflowComponent {
   private String generationSetSlot;

   private Logger logger = Logger.getLogger(getClass());

   public GenerationSetChecker() {
   }

   public void checkConfiguration(Issues issues) {
   }

   public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      GenerationSet set = (GenerationSet) ctx.get(getGenerationSetSlot());
      
      if ( set == null ) {
         issues.addError("Generationset is null");
      }

      for (Iterator ip = set.getGenerationProfile().iterator(); ip.hasNext();) {
         GenerationProfile generationProfile = (GenerationProfile) ip.next();
         Profile profile = generationProfile.getProfile();
         
         if ( profile == null ) {
            issues.addError("profile in "+generationProfile.toString()+" is null");
         }
         if ( profile.getName() == null ) {
            issues.addError("profile "+profile.toString()+" has no name");
         }
         else {
            logger.info("profile "+profile.toString()+" seams to be ok");
         }
      }
   }

   public String getGenerationSetSlot() {
      return generationSetSlot;
   }

   public void setGenerationSetSlot(String generationSetSlot) {
      this.generationSetSlot = generationSetSlot;
   }

}
