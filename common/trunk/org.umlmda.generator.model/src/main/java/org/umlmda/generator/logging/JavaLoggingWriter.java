/*
 * Created on 24.11.2005
 */
package org.umlmda.generator.logging;

import org.umlmda.generator.model.uml.GeneratorMethod;
import org.umlmda.generator.model.util.CodeEmitter;

/**
 * @author MOROFF
 */
public class JavaLoggingWriter extends AbstractLoggingWriter implements LoggingWriter
{

   /**
    * @param emitter
    */
   public JavaLoggingWriter(CodeEmitter emitter) {
      super(emitter);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#importDeclaration()
    */
   public String importDeclaration() {
      return "import java.util.logging.*;";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#initDeclaration(org.umlmda.generator.model.uml.GeneratorModelElement)
    */
   public String initDeclaration() {
      return "private Logger logger = Logger.getLogger(getClass().getName());";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodEntry(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodEntry(GeneratorMethod method) {
      return "if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),\"" + method.getName() + "\"); }";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodEntry(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodEntry(String methodName) {
      return "if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),\"" + methodName + "\"); }";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodExit(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodExit(GeneratorMethod method) {
      return "if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),\"" + method.getName() + "\"); }";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#traceMethodExit(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodExit(String methodName) {
      return "if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),\"" + methodName + "\"); }";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.LoggingWriter#logException(org.umlmda.generator.model.uml.GeneratorMethod, java.lang.String)
    */
   public String logException(String exception) {
      return "logger.log(Level.SEVERE, " + exception + ".getMessage(), " + exception + ");";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String error(String message) {
      return "logger.log(Level.SEVERE, " + message + ");";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String warn(String message) {
      return "logger.log(Level.WARNING, " + message + ");";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String info(String message) {
      return "logger.log(Level.INFO, " + message + ");";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#debug(java.lang.String)
    */
   public String debug(String message) {
      return "logger.log(Level.FINE, " + message + ");";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#trace(java.lang.String)
    */
   public String trace(String message) {
      return "logger.log(Level.FINER, " + message + ");";
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#getIfIsLogEnabled(int, int)
    */
   public String getIfIsLogEnabled(int level) {
      return "if ( logger.isLoggable(" + getLevel(level) + ") ) {";
   }

   public String getLevel(int level) {
      switch (level) {
      case ERROR:
         return "Level.SEVERE";
      case WARN:
         return "Level.WARNING";
      case INFO:
         return "Level.INFO";
      case DEBUG:
         return "Level.FINE";
      default:
         return "Level.FINER";
      }
   }
}
