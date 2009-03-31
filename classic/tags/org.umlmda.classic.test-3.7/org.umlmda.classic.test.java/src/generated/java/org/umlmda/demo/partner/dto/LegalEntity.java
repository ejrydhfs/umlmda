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


//@@UserSection-Begin LegalEntity.Imports
//@@UserSection-End LegalEntity.Imports

/**
 * 
 */
public interface LegalEntity extends Partner
{
   /**
   * Get legalForm, 
   */
   public String getLegalForm();
   /**
   * Set legalForm, 
   */
   public void setLegalForm(String legalForm);

   /**
   * Get revenue, Sample for using optional decimal attribute.
   */
   public java.math.BigDecimal getRevenue();
   /**
   * Set revenue, Sample for using optional decimal attribute.
   */
   public void setRevenue(java.math.BigDecimal revenue);



   /**
   * 
   */
   public Person getContactPerson();

   /**
   * Setter for 
   */
   public void setContactPerson(Person contactPerson);

		

}
