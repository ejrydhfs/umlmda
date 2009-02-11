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
public class NoneLoggingWriter extends AbstractLoggingWriter implements LoggingWriter {

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#isLoggingSupported()
    */
   public boolean isLoggingSupported() {
      return false;
   }
   
   /**
    * @param emitter
    */
   public NoneLoggingWriter(CodeEmitter emitter) {
      super(emitter);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#importDeclaration()
    */
   public String importDeclaration() {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#initDeclaration()
    */
   public String initDeclaration() {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#traceMethodEntry(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodEntry(GeneratorMethod method) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#traceMethodEntry(java.lang.String)
    */
   public String traceMethodEntry(String methodName) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#traceMethodExit(org.umlmda.generator.model.uml.GeneratorMethod)
    */
   public String traceMethodExit(GeneratorMethod method) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#traceMethodExit(java.lang.String)
    */
   public String traceMethodExit(String methodName) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#logException(java.lang.String)
    */
   public String logException(String exception) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String error(String message) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String warn(String message) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#info(java.lang.String)
    */
   public String info(String message) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#debug(java.lang.String)
    */
   public String debug(String message) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#trace(java.lang.String)
    */
   public String trace(String message) {
      return "";
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.logging.LoggingWriter#getIfIsLogEnabled(int)
    */
   public String getIfIsLogEnabled(int level) {
      return "{";
   }
   
}
