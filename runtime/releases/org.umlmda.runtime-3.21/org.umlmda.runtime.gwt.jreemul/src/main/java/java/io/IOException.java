/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package java.io;

/**
 * Document me!
 * 
 * @author moroff
 */
public class IOException extends Exception
{

   /**
    * 
    */
   public IOException() {
   }

   /**
    * @param message
    */
   public IOException(String message) {
      super(message);
   }

   /**
    * @param cause
    */
   public IOException(Throwable cause) {
      super(cause);
   }

   /**
    * @param message
    * @param cause
    */
   public IOException(String message, Throwable cause) {
      super(message, cause);
   }

}
