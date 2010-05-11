package org.umlmda.runtime.sdo.change.test;

import org.apache.log4j.Logger;
import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.entries.AbstractChangeLogEntry;

class TestUtils {
   
   static void logEntries(Logger logger, Recorder recorder) {
      if ( logger.isTraceEnabled()) {
         logger.trace("<!-- LogEntries");
         for (AbstractChangeLogEntry logEntry : recorder.getChangeEntries()) {
            logger.trace(logEntry);
         }
         logger.trace("LogEntries -->");
      }
   }

}
