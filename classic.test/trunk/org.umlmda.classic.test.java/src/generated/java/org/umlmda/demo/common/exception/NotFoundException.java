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


//@@UserSection-Begin NotFoundException.Imports
//@@UserSection-End NotFoundException.Imports

/**
 * Exception thrown when business object was not found as expected.
 */
public class NotFoundException extends CommonException
{
   // Version information from BusinessComponent org.umlmda.demo.common
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   

   /**
    * Default Ctor
    */
   public NotFoundException() {
      super();
   }
   
   public NotFoundException(String reason)
   {
      super(reason);
   }

   


		

   //@@UserSection-Begin NotFoundException.NonGeneratedMembers
   //@@UserSection-End NotFoundException.NonGeneratedMembers
}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
