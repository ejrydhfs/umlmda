package org.umlmda.oaw.generator.workflow;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openarchitectureware.workflow.WorkflowComponent;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.nsuml.ModelFactoryImpl;

public class RoseModelFactory implements ModelFactory
{
   private String              modelFile;
   private Logger              logger  = Logger.getLogger(getClass());
   private Map<String, String> pathMap = new HashMap<String, String>();

   public RoseModelFactory() {
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#loadModel(org.openarchitectureware.workflow.WorkflowComponent)
    */
   public ModelBase loadModel(WorkflowContext ctx, Issues issues) {
      ModelBase modelBase = null;
      ModelFactoryImpl modelFactory = new ModelFactoryImpl();

      modelFactory.setPathMap(pathMap);

      File modelF = new File(modelFile);
      try {
         modelBase = modelFactory.loadModel(modelF);
      }
      catch (IOException e) {
         issues.addError("Error loading model " + modelF.getAbsolutePath(), e);
      }

      return modelBase;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#getModelFile()
    */
   public String getModelFile() {
      return modelFile;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#setModelFile(java.lang.String)
    */
   public void setModelFile(String modelFile) {
      this.modelFile = modelFile;
   }

   public void addPathMapEntry(RosePathMapEntry pathMapEntry) {
      this.pathMap.put(pathMapEntry.getKey(), pathMapEntry.getPath());
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.oaw.generator.workflow.ModelFactory#checkConfiguration(org.openarchitectureware.workflow.WorkflowComponent,
    * org.openarchitectureware.workflow.issues.Issues)
    */
   public void checkConfiguration(WorkflowComponent ctx, Issues issues) {
      if ( StringUtils.isEmpty(modelFile) ) {
         issues.addError(ctx, "modelFile not specified");
      }
      else {
         File modelF = new File(modelFile);

         if ( modelF.canRead() == false ) {
            issues.addError(ctx, "modelFile " + modelF.getAbsolutePath() + " can't be read");
         }
      }
   }
}
