/*
 * Created on 24.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.generator.logging;

import org.umlmda.generator.model.uml.GeneratorMethod;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface LoggingWriter {
   public final int ERROR = 0;
   public final int WARN = 1;
   public final int INFO = 2;
   public final int DEBUG = 3;
   public final int TRACE = 4;
   
   boolean isLoggingSupported();
   
   /**
    * Required import for logging framework
    */
   String importDeclaration();
   
   String initDeclaration();
   
   String traceMethodEntry(GeneratorMethod method);

   String traceMethodEntry(String methodName);

   String traceMethodExit(GeneratorMethod method);
   
   String traceMethodExit(String methodName);

   String logException(String exception);

   String error(String message);

   String warn(String message);

   String info(String message);

   String debug(String message);

   String trace(String message);

   String log(int level, String message, int ident);

   String log(int level, String message);

   String getIfIsLogEnabled(int level);
}
