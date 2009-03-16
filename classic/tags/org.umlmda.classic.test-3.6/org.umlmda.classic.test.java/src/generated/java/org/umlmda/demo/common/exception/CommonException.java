//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
// $Header$
// $Source$
// $Revision$
// $State$
// $Name$
// $Date$
// $Locker$
//@@UserSection-End RCSHeader

package org.umlmda.demo.common.exception;


//@@UserSection-Begin CommonException.Imports
//@@UserSection-End CommonException.Imports

/**
 * Base of all exceptions.
 */
public class CommonException extends Exception
{
   // Version information from BusinessComponent org.umlmda.demo.common
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private String reason = "null";

   /**
    * Default Ctor
    */
   public CommonException() {
      super();
   }
   
   public CommonException(String reason)
   {
      this.reason = reason;
   }

   

   /**
   * Get reason
   */
   public String getReason() {
      return reason;
   }
   
   /**
   * Set reason
   */
   public void setReason(String reason) {
      this.reason = reason;
   }


		

   //@@UserSection-Begin CommonException.NonGeneratedMembers
   //@@UserSection-End CommonException.NonGeneratedMembers
}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
