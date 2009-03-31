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

package org.umlmda.demo.partner.dto;


//@@UserSection-Begin PostalAddress.Imports
//@@UserSection-End PostalAddress.Imports

/**
 * Postal adress.

Different types can be distinguished:
- Private address
- Business address
- Holiday address

 */
public interface PostalAddress extends org.umlmda.demo.common.dto.TimeDependent
{
   /**
   * Get nr, sequential number of the addresses of one partner. Primary key (together with parent primary key attributes). 
   */
   public int getNr();
   /**
   * Set nr, sequential number of the addresses of one partner. Primary key (together with parent primary key attributes). 
   */
   public void setNr(int nr);

   /**
   * Get zip, The Cities zip code.
   */
   public String getZip();
   /**
   * Set zip, The Cities zip code.
   */
   public void setZip(String zip);

   /**
   * Get city, 
   */
   public String getCity();
   /**
   * Set city, 
   */
   public void setCity(String city);

   /**
   * Get street, 
   */
   public String getStreet();
   /**
   * Set street, 
   */
   public void setStreet(String street);

   /**
   * Get PRIVATE, 
   */
   public int getPRIVATE();
   /**
   * Set PRIVATE, 
   */
   public void setPRIVATE(int PRIVATE);

   /**
   * Get BUSINESS, 
   */
   public int getBUSINESS();
   /**
   * Set BUSINESS, 
   */
   public void setBUSINESS(int BUSINESS);

   /**
   * Get HOLIDAY, 
   */
   public int getHOLIDAY();
   /**
   * Set HOLIDAY, 
   */
   public void setHOLIDAY(int HOLIDAY);

   /**
   * Get type, 
   */
   public AddressType getType();
   /**
   * Set type, 
   */
   public void setType(AddressType type);


		

}
