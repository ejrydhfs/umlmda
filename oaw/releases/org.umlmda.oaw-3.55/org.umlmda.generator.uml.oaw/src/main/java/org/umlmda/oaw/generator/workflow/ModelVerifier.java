/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: ModelVerifier.java,v 1.1 2008/03/17 20:20:02 moroff Exp $Version 17.03.2008 21:05:16 {user} Exp $
 */
package org.umlmda.oaw.generator.workflow;

import org.apache.commons.lang.StringUtils;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class ModelVerifier extends AbstractWorkflowComponent2
{
   private String model;
   
   public ModelVerifier() {
      // TODO Auto-generated constructor stub
   }

   @Override
   protected void checkConfigurationInternal(Issues issues) {
      if ( StringUtils.isEmpty(model) ) {
         issues.addError("model not set");
      }
   }

   @Override
   protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      Object model = ctx.get(this.model);
      
      issues.addWarning("Model is of "+model.getClass()+" type");
      // TODO Auto-generated method stub

   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }


}
