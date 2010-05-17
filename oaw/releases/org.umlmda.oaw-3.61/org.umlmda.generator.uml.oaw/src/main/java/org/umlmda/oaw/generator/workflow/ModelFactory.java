package org.umlmda.oaw.generator.workflow;

import org.openarchitectureware.workflow.WorkflowComponent;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.umlmda.model.uml.ModelBase;

public interface ModelFactory
{

   /**
    * @return the modelFile
    */
   String getModelFile();

   /**
    * @param modelFile
    *           the modelFile to set
    */
   void setModelFile(String modelFile);

   void checkConfiguration(WorkflowComponent ctx, Issues issues);

   ModelBase loadModel(WorkflowContext ctx, Issues issues);

}