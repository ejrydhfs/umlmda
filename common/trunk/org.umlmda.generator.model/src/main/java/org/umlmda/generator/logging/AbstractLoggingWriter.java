/*
 * Created on 15.12.2005
 */
package org.umlmda.generator.logging;

import org.umlmda.generator.model.util.CodeEmitter;

/**
 * @author MOROFF
 */
public abstract class AbstractLoggingWriter implements LoggingWriter
{
   protected final CodeEmitter emitter;

   /**
    * 
    */
   public AbstractLoggingWriter(CodeEmitter emitter) {
      super();
      this.emitter = emitter;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#log(int, java.lang.String, int)
    */
   public String log(int level, String message, int ident) {
      emitter.reset();
      emitter.addLine(ident, log(level, message));
      return emitter.toString();
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#log(int, java.lang.String)
    */
   public String log(int level, String message) {
      switch (level) {
      case ERROR:
         return error(message);
      case WARN:
         return warn(message);
      case INFO:
         return info(message);
      case DEBUG:
         return debug(message);
      default:
         return trace(message);
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#isLoggingSupported()
    */
   public boolean isLoggingSupported() {
      return true;
   }
}
