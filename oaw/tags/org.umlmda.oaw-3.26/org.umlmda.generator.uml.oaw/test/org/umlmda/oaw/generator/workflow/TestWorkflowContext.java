package org.umlmda.oaw.generator.workflow;

import java.util.HashMap;
import java.util.Map;

import org.openarchitectureware.workflow.WorkflowContext;

public class TestWorkflowContext implements WorkflowContext {
   Map<String, Object> slots = new HashMap<String, Object>();
   
   public Object get(String slotName) {
      return slots.get(slotName);
   }

   public String[] getSlotNames() {
      return null;
   }

   public void set(String slotName, Object value) {
      slots.put(slotName, value);
   }

}
