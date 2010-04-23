package org.umlmda.generator.oaw;

import org.apache.log4j.Logger;
import org.openarchitectureware.workflow.issues.Issues;
import org.umlmda.generator.model.util.Feedback;

public class OawFeedback implements Feedback {

   private final Issues issues;
   private final Logger logger;

   public OawFeedback(Issues issues, Logger logger) {
      this.issues = issues;
      this.logger = logger;
   }

   public void message(int type, String msg) {
      switch (type) {
      case Feedback.ERROR:
         issues.addError(msg);
         break;
      case Feedback.WARNING:
         issues.addWarning(msg);
         break;
      case Feedback.INFO:
         logger.info(msg);
         break;
      case Feedback.DEBUG:
         logger.debug(msg);
         break;
      default:
         break;
      }
   }

   public void printStackTrace(Throwable throwable) {
      // TODO Auto-generated method stub

   }

   public void tellNewStep(String message) {
      logger.info(message);
   }

   public void tellWork(String message) {
      logger.info(message);
   }

}
