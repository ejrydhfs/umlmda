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


package org.umlmda.demo.partner.dto.impl;

import org.umlmda.demo.partner.dto.CommunicationAddress;
import org.umlmda.demo.partner.dto.EMail;
import org.umlmda.demo.partner.dto.InstantMessenger;
import org.umlmda.demo.partner.dto.LegalEntity;
import org.umlmda.demo.partner.dto.Mandator;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PartnerFactory;
import org.umlmda.demo.partner.dto.Person;
import org.umlmda.demo.partner.dto.PersonList;
import org.umlmda.demo.partner.dto.PostalAddress;
import org.umlmda.demo.partner.dto.Profession;
import org.umlmda.demo.partner.dto.Telephone;
//@@UserSection-Begin org.umlmda.demo.partner.Imports
//@@UserSection-End org.umlmda.demo.partner.Imports

/**
 * Abstract factory for the modelled classes of the package org.umlmda.demo.partner
 */
public class PartnerFactoryImpl implements PartnerFactory
{
   /**
   * Create Businessinterface implementation for EMail
   * @see EMail
   */
   public EMail createEMail() {
   	  return EMailImpl.createEMailImpl();
   }
   /**
   * Create Businessinterface implementation for InstantMessenger
   * @see InstantMessenger
   */
   public InstantMessenger createInstantMessenger() {
   	  return InstantMessengerImpl.createInstantMessengerImpl();
   }
   /**
   * Create Businessinterface implementation for LegalEntity
   * @see LegalEntity
   */
   public LegalEntity createLegalEntity() {
   	  return LegalEntityImpl.createLegalEntityImpl();
   }
   /**
   * Create Businessinterface implementation for Mandator
   * @see Mandator
   */
   public Mandator createMandator() {
   	  return MandatorImpl.createMandatorImpl();
   }
   /**
   * Create Businessinterface implementation for Partner
   * @see Partner
   */
   public Partner createPartner() {
   	  return PartnerImpl.createPartnerImpl();
   }
   /**
   * Create Businessinterface implementation for Person
   * @see Person
   */
   public Person createPerson() {
   	  return PersonImpl.createPersonImpl();
   }
   /**
   * Create Businessinterface implementation for PersonList
   * @see PersonList
   */
   public PersonList createPersonList() {
   	  return PersonListImpl.createPersonListImpl();
   }
   /**
   * Create Businessinterface implementation for PostalAddress
   * @see PostalAddress
   */
   public PostalAddress createPostalAddress() {
   	  return PostalAddressImpl.createPostalAddressImpl();
   }
   /**
   * Create Businessinterface implementation for Profession
   * @see Profession
   */
   public Profession createProfession() {
   	  return ProfessionImpl.createProfessionImpl();
   }
   /**
   * Create Businessinterface implementation for Telephone
   * @see Telephone
   */
   public Telephone createTelephone() {
   	  return TelephoneImpl.createTelephoneImpl();
   }
	    

};

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
