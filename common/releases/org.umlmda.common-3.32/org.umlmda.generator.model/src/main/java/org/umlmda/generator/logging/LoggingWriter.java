/*
 * Created on 24.11.2005
 */
package org.umlmda.generator.logging;

import org.umlmda.generator.model.uml.GeneratorMethod;

/**
 * @author MOROFF
 */
public interface LoggingWriter
{
   int ERROR = 0;
   int WARN  = 1;
   int INFO  = 2;
   int DEBUG = 3;
   int TRACE = 4;

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
