/*
 * Created on 24.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.generator.logging;

import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.util.CodeEmitter;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonsLoggingWriter extends AbstractLoggingWriter implements LoggingWriter {

   /**
    * @param emitter
    */
   public CommonsLoggingWriter(CodeEmitter emitter) {
      super(emitter);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#importDeclaration()
    */
   public String importDeclaration() {
      return "import org.apache.commons.logging.Log;";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#initDeclaration(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public String initDeclaration() {
      return "private Log logger = Logger.getLogger(getClass());";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodEntry(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodEntry(GeneratorMethod method) {
      return "if ( logger.isTraceEnabled() { logger.trace("+method.getName()+"() entered\"); }";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodEntry(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodEntry(String methodName) {
      return "if ( logger.isTraceEnabled() { logger.trace("+methodName+"() entered\"); }";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodExit(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodExit(GeneratorMethod method) {
      return "if ( logger.isTraceEnabled() { logger.trace("+method.getName()+"() exit\"); }";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodExit(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodExit(String methodName) {
      return "if ( logger.isTraceEnabled() { logger.trace("+methodName+"() exit\"); }";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#logException(org.umlmda.generator.model.uml.GeneratorMethod, java.lang.String)
    */
   public String logException(String exception) {
      return "logger.error("+exception+".getMessage(), "+exception+");";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String error(String message) {
      return "logger.error("+message+");";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String warn(String message) {
      return "logger.warn("+message+");";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String info(String message) {
      return "logger.info("+message+");";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#debug(java.lang.String)
    */
   public String debug(String message) {
      return "logger.debug("+message+");";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#trace(java.lang.String)
    */
   public String trace(String message) {
      return "logger.trace("+message+");";
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#getIfIsLogEnabled(int, int)
    */
   public String getIfIsLogEnabled(int level) {
      return "if ( "+getEnabled(level)+" ) {";
   }
   
   private String getEnabled(int level) {
      switch (level) {
      case ERROR:
         return "logger.isErrorEnabled()";
      case WARN:
         return "logger.isWarnEnabled()";
      case INFO:
         return "logger.isInfoEnabled()";
      case DEBUG:
         return "logger.isDebugEnabled()";
      default:
         return "logger.isTraceEnabled()";
      }
   }
   
}
