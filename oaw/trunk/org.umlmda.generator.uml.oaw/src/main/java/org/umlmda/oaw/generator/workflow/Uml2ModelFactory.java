package org.umlmda.oaw.generator.workflow;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Model;
import org.openarchitectureware.workflow.WorkflowComponent;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.WorkflowComponentWithModelSlot;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.uml2.ModelFactoryImpl;
import org.umlmda.model.uml.uml2.ModelImpl;

public class Uml2ModelFactory implements ModelFactory  {
   private String modelFile;
   private String umlmodelSlot;
   private Logger logger = Logger.getLogger(getClass());
   private Map<String, String> pathMap = new HashMap<String, String>();
   
   public Uml2ModelFactory() {
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#loadModel(org.openarchitectureware.workflow.WorkflowComponent)
    */
   public ModelBase loadModel(WorkflowContext ctx, Issues issues) {
      ModelBase modelBase = null;
   
      if ( StringUtils.isNotEmpty(modelFile) ) {
         ModelFactoryImpl modelFactory = new ModelFactoryImpl();

         modelFactory.setPathMap(pathMap);
         
         File modelF = new File(modelFile);
         try {
            modelBase = modelFactory.loadModel(modelF);
         } catch (IOException e) {
            issues.addError("Error loading model "+modelF.getAbsolutePath(), e);
         }
      }
      else if ( StringUtils.isNotEmpty(umlmodelSlot)) {
         Object model = ctx.get(umlmodelSlot);
         
         if ( model == null ) {
        	 issues.addError("No model in slot "+umlmodelSlot+" found");
         }
         else if (model instanceof Model) {
             modelBase = new ModelImpl((Model)model);
		 }
         else {
        	 issues.addError("Illegal model type "+model.getClass().getName()+" "+Model.class.getName()+" expected");
         }
      }
      return modelBase;
   }

   /* (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#getModelFile()
    */
   public String getModelFile() {
      return modelFile;
   }

   /* (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#setModelFile(java.lang.String)
    */
   public void setModelFile(String modelFile) {
      this.modelFile = modelFile;
   }
   
   public void addPathMapEntry(RosePathMapEntry pathMapEntry) {
      this.pathMap.put(pathMapEntry.getKey(), pathMapEntry.getPath());
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#checkConfiguration(org.openarchitectureware.workflow.WorkflowComponent, org.openarchitectureware.workflow.issues.Issues)
    */
   public void checkConfiguration(WorkflowComponent ctx, Issues issues) {
      if ( StringUtils.isEmpty(modelFile) && StringUtils.isEmpty(umlmodelSlot)) {
         issues.addError(ctx, "both modelFile and umlmodelSlot not specified");
      }
      else if ( StringUtils.isNotEmpty(modelFile)) {
         File modelF = new File(modelFile);
         
         if ( modelF.canRead() == false ) {
            issues.addError(ctx, "modelFile "+modelF.getAbsolutePath()+" can't be read");
         }
      }
   }

   public String getUmlmodelSlot() {
      return umlmodelSlot;
   }

   public void setUmlmodelSlot(String umlmodelSlot) {
      this.umlmodelSlot = umlmodelSlot;
   }
}
