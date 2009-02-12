package org.umlmda.oaw.generator.workflow;

import org.openarchitectureware.workflow.WorkflowComponent;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.umlmda.model.uml.ModelBase;

public interface ModelFactory {

   /**
    * @return the modelFile
    */
   public abstract String getModelFile();

   /**
    * @param modelFile the modelFile to set
    */
   public abstract void setModelFile(String modelFile);

   public abstract void checkConfiguration(WorkflowComponent ctx, Issues issues);

   public abstract ModelBase loadModel(WorkflowContext ctx, Issues issues);

}