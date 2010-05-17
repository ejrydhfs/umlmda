/**
 * 
 */
package org.umlmda.oaw.generator.workflow;

import org.apache.log4j.Logger;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.WorkflowComponentWithModelSlot;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.impl.ModelAdapterFactoryImpl;
import org.umlmda.model.uml.validate.ModelValidationException;

/**
 * @author MOROFF
 */
public class ModelLoader extends WorkflowComponentWithModelSlot
{
   private ModelFactory modelFactory;
   private Logger       logger = Logger.getLogger(getClass());

   /**
    * 
    */
   public ModelLoader() {
   }

   /*
    * (non-Javadoc)
    * @see org.openarchitectureware.workflow.WorkflowComponent#invoke(org.openarchitectureware.workflow.WorkflowContext,
    * org.openarchitectureware.workflow.monitor.ProgressMonitor, org.openarchitectureware.workflow.issues.Issues)
    */
   public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      ModelBase modelBase = modelFactory.loadModel(ctx, issues);
      Model model = null;

      // Generated default model adapter
      try {
         model = new ModelAdapterFactoryImpl().createModel(modelBase);
      }
      catch (ModelValidationException e) {
         issues.addError(e.getValidationResults().toString());
      }

      if ( model != null ) {
         logger.info("Loaded model " + modelFactory.getModelFile() + " to slot " + getModelSlot());
         ctx.set(getModelSlot(), model);
      }
   }

   /*
    * (non-Javadoc)
    * @see
    * org.openarchitectureware.workflow.lib.WorkflowComponentWithModelSlot#checkConfiguration(org.openarchitectureware.workflow
    * .issues.Issues)
    */
   @Override
   public void checkConfiguration(Issues issues) {
      super.checkConfiguration(issues);

      if ( modelFactory == null ) {
         issues.addError(this, "modelFactory not specified");
      }
      else {
         // TODO check for existence
      }

   }

   /**
    * @return the modelFactory
    */
   public ModelFactory getModelFactory() {
      return modelFactory;
   }

   /**
    * @param modelFactory
    *           the modelFactory to set
    */
   public void setModelFactory(ModelFactory modelFactory) {
      this.modelFactory = modelFactory;
   }

}
