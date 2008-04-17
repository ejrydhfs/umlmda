/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: ObjectStreamException.java,v 1.1 2008/03/20 22:42:18 moroff Exp $Version 27.02.2008 12:49:32 {user} Exp $
 */
package java.io;

/**
 * Document me!
 * 
 * @author moroff (Last change: $Author: moroff $ $Date: 2008/03/20 22:42:18 $)
 * @version $Revision: 1.1 $
 */
public class ObjectStreamException extends IOException
{

   /**
    * 
    */
   public ObjectStreamException() {
      // TODO Auto-generated constructor stub
   }

   /**
    * @param message
    */
   public ObjectStreamException(String message) {
      super(message);
      // TODO Auto-generated constructor stub
   }

   /**
    * @param cause
    */
   public ObjectStreamException(Throwable cause) {
      super(cause);
      // TODO Auto-generated constructor stub
   }

   /**
    * @param message
    * @param cause
    */
   public ObjectStreamException(String message, Throwable cause) {
      super(message, cause);
      // TODO Auto-generated constructor stub
   }

}
