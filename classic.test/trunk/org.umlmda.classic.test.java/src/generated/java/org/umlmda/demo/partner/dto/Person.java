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

import org.umlmda.demo.common.dto.Sex;
//@@UserSection-Begin Person.Imports
//@@UserSection-End Person.Imports

/**
 * 
 */
public interface Person extends Partner
{
   /**
   * Get firstname, Surname of the partner
   */
   public String getFirstname();
   /**
   * Set firstname, Surname of the partner
   */
   public void setFirstname(String firstname);

   /**
   * Get birthdate, Birthday of the partner.
   */
   public javax.xml.datatype.XMLGregorianCalendar getBirthdate();
   /**
   * Set birthdate, Birthday of the partner.
   */
   public void setBirthdate(javax.xml.datatype.XMLGregorianCalendar birthdate);

   /**
   * Get sex, 
   */
   public Sex getSex();
   /**
   * Set sex, 
   */
   public void setSex(Sex sex);

   /**
   * Get age, Age of the person. Sample of a derived nonchangealbe attribute.
   */
   public int getAge();
   /**
   * Set age, Age of the person. Sample of a derived nonchangealbe attribute.
   */
   public void setAge(int age);

   /**
   * Get employee, 
   */
   public boolean isEmployee();
   /**
   * Set employee, 
   */
   public void setEmployee(boolean employee);

   /**
   * Get salary, 
   */
   public java.math.BigDecimal getSalary();
   /**
   * Set salary, 
   */
   public void setSalary(java.math.BigDecimal salary);

   /**
   * Get nationalities, 
   */
   public String[] getNationalities();
   /**
   * Set nationalities, 
   */
   public void setNationalities(String[] nationalities);



   /**
   * 
   */
   public Profession get_profession();

   /**
   * Setter for 
   */
   public void set_profession(Profession _profession);

   /**
    * Delivers the full name of the partner. Might be overwritten in subclasses.
    */
    public String getFullName ();

		

}
