//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/DelegateInterface.vm,v 1.1.2.1 2008/01/21 14:57:15 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/DelegateInterface.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:15 $
//@@UserSection-End RCSHeader


package org.umlmda.demo.partner.dto;

/**
 * Interface for delegate to implement the methods and derived attributes of
 * org.umlmda.demo.partner.Person.
 * @see Person
 */
public interface PersonDelegate extends org.umlmda.runtime.lang.Delegate, PartnerDelegate{
   /**
   * Get age
   */
   public int getAge();
   /**
   * Set age
   */
   public void setAge(int age);

   /**
    * Delivers the full name of the partner. Might be overwritten in subclasses.
    */
    public String getFullName ();

}
