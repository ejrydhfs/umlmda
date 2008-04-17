/*
 * Created on 17.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml.validate;

import org.umlmda.model.uml.ModelElement;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ValidationResult {
   public static final int OK = 0;
   public static final int WARNING = 1;
   public static final int ERROR = 2;
   
   private final String message;
   private final int severity;
   private final ModelElement reference;

   public ValidationResult(int severity, String message, ModelElement reference) {
      this.severity = severity;
      this.message = message;
      this.reference = reference;
   }
   
   public static ValidationResult createWarning(String message, ModelElement reference) {
      return new ValidationResult(WARNING, message, reference);
   }
   
   public static ValidationResult createError(String message, ModelElement reference) {
      return new ValidationResult(ERROR, message, reference);
   }
   
   public String getMessage() {
      return message;
   }
   
   /**
    * @return Returns the severity.
    */
   public int getSeverity() {
      return severity;
   }
   
   /**
    * Diagnostic output
    */
   public String toString() {
      StringBuffer buffer = new StringBuffer();
      
      switch (severity) {
      case WARNING:
         buffer.append("WARNING : ");
         break;
      case ERROR:
         buffer.append("ERROR   : ");
         break;
      }
      if ( reference != null ) {
         buffer.append("\"");
         buffer.append(reference.getQualifiedName());
         buffer.append("\" :");
      }
      buffer.append(message);
      return buffer.toString();
   }
}
