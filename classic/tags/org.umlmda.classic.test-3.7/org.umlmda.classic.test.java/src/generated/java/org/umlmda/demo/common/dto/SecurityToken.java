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

package org.umlmda.demo.common.dto;


//@@UserSection-Begin SecurityToken.Imports
//@@UserSection-End SecurityToken.Imports

/**
 * 
 */
public interface SecurityToken 
{
   /**
   * Get signature, 
   */
   public byte[] getSignature();
   /**
   * Set signature, 
   */
   public void setSignature(byte[] signature);

   /**
   * Get securityIds, 
   */
   public String[] getSecurityIds();
   /**
   * Set securityIds, 
   */
   public void setSecurityIds(String[] securityIds);


		

}
