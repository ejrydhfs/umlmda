package org.umlmda.runtime.sdo.change.test;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.sync.Synchronizer;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

public class TestUtils {
   
   static void logEntries(Logger logger, Synchronizer recorder) {
      if ( logger.isTraceEnabled()) {
         logger.trace("<!-- LogEntries");
         for (AbstractChangeLogEntry logEntry : recorder.getChangeEntries()) {
            logger.trace(logEntry);
         }
         logger.trace("LogEntries -->");
      }
   }

}
