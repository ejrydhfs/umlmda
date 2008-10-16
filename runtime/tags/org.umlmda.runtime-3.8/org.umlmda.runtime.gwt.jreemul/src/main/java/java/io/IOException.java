/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: IOException.java,v 1.1 2008/03/20 22:42:18 moroff Exp $Version 27.02.2008 12:48:00 {user} Exp $
 */
package java.io;

/**
 * Document me!
 * 
 * @author moroff (Last change: $Author: moroff $ $Date: 2008/03/20 22:42:18 $)
 * @version $Revision: 1.1 $
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
