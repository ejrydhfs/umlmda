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


//@@UserSection-Begin ProcessingException.Imports
//@@UserSection-End ProcessingException.Imports

/**
 * Exception thrown when service could not execute because businessrule are not validated.
 */
public class ProcessingException extends CommonException
{
   // Version information from BusinessComponent org.umlmda.demo.common
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private int OK = 0;
   private int errorNumber = OK;
   private String errorCode = "N/A";

   /**
    * Default Ctor
    */
   public ProcessingException() {
      super();
   }
   
   public ProcessingException(String reason, int OK, int errorNumber, String errorCode)
   {
      super(reason);
      this.OK = OK;
      this.errorNumber = errorNumber;
      this.errorCode = errorCode;
   }

   

   /**
   * Get OK
   */
   public int getOK() {
      return OK;
   }
   
   /**
   * Set OK
   */
   public void setOK(int OK) {
      this.OK = OK;
   }

   /**
   * Get errorNumber
   */
   public int getErrorNumber() {
      return errorNumber;
   }
   
   /**
   * Set errorNumber
   */
   public void setErrorNumber(int errorNumber) {
      this.errorNumber = errorNumber;
   }

   /**
   * Get errorCode
   */
   public String getErrorCode() {
      return errorCode;
   }
   
   /**
   * Set errorCode
   */
   public void setErrorCode(String errorCode) {
      this.errorCode = errorCode;
   }


		

   //@@UserSection-Begin ProcessingException.NonGeneratedMembers
   //@@UserSection-End ProcessingException.NonGeneratedMembers
}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
