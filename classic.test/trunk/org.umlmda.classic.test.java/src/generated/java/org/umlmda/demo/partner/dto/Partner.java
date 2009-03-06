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

import org.umlmda.demo.common.dto.Note;
//@@UserSection-Begin Partner.Imports
//@@UserSection-End Partner.Imports

/**
 * Base of Businessobject of person or legal entity.
 */
public interface Partner 
{
   /**
   * Get id, 
   */
   public String getId();
   /**
   * Set id, 
   */
   public void setId(String id);

   /**
   * Get name, Name of the partner.
   */
   public String getName();
   /**
   * Set name, Name of the partner.
   */
   public void setName(String name);



   /**
   * 
   */
   public java.util.Collection get_eMail();

   /**
   * Setter for 
   */
   public void set_eMail(java.util.Collection _eMail);


   /**
   * 
   */
   public java.util.Collection get_instantMessenger();

   /**
   * Setter for 
   */
   public void set_instantMessenger(java.util.Collection _instantMessenger);


   /**
   * Unnamed association the check default behavior, that unnamed assocations get the name of the target class.
   */
   public java.util.Collection get_telephone();

   /**
   * Setter for Unnamed association the check default behavior, that unnamed assocations get the name of the target class.
   */
   public void set_telephone(java.util.Collection _telephone);


   /**
   * Collection of all addresses.
   */
   public java.util.Collection getAddresses();

   /**
   * Setter for Collection of all addresses.
   */
   public void setAddresses(java.util.Collection addresses);


   /**
   * Reference to a BO in an other package.
   */
   public java.util.Collection getNotes();

   /**
   * Setter for Reference to a BO in an other package.
   */
   public void setNotes(java.util.Collection notes);


   /**
   * 
   */
   public PostalAddress getPreferredAddress();

   /**
   * Setter for 
   */
   public void setPreferredAddress(PostalAddress preferredAddress);


   /**
   * The primary postal address to be used for correspondence.
   */
   public PostalAddress getPrimaryAddress();

   /**
   * Setter for The primary postal address to be used for correspondence.
   */
   public void setPrimaryAddress(PostalAddress primaryAddress);

   /**
    * Delivers the full name of the partner. Might be overwritten in subclasses.
    */
    public String getFullName ();

		

}
