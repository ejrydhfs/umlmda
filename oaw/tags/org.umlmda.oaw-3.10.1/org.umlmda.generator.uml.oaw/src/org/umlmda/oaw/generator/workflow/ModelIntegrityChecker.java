package org.umlmda.oaw.generator.workflow;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.WorkflowComponentWithModelSlot;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class ModelIntegrityChecker extends WorkflowComponentWithModelSlot {
   
   public ModelIntegrityChecker() {
   }

   public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      Object model = ctx.get(getModelSlot());
      
      if ( model instanceof EObject ) {
         Map<EObject, Collection<Setting>> messages = EcoreUtil.UnresolvedProxyCrossReferencer.find((EObject) model);
         
         if ( messages.size() > 0 ) {
            issues.addError("Model integrity failed");
            for (Map.Entry<EObject, Collection<Setting>> message : messages.entrySet()) {
               issues.addError(message.getKey()+":"+ message.getValue());
            }
         }
      }
      else if ( model == null ) {
         issues.addError("Not model found in modelSlot");
      }
      else {
         issues.addError("Invalid model not an emf object "+model.getClass());
      }
   }


}
