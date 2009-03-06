//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header$
//   $Source$
// $Revision$
//     $Name$
//     $Date$
//@@UserSection-End RCSHeader
package org.umlmda.demo.partner.dto;

import org.umlmda.runtime.visitor.AbstractVisitableIterator;
				import org.umlmda.demo.common.dto.CommonVisitableIterator;

/**
 * Visitable iterator for the business objects of org.umlmda.demo.partner 
 */
public class PartnerVisitableIterator extends AbstractVisitableIterator {

   /**
    * 
    */
   public PartnerVisitableIterator(Object startPoint) {
      this(null, startPoint);
   }

   /**
    * 
    */
   public PartnerVisitableIterator(AbstractVisitableIterator parentIterator, Object startPoint) {
      super(parentIterator, startPoint);
   }

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.AbstractVisitableIterator#registerChilds()
    */
   protected void registerChilds(Object startPoint) {
      if ( startPoint instanceof CommunicationAddress ) {
         CommunicationAddress spCommunicationAddress = (CommunicationAddress)startPoint;

      }
      if ( startPoint instanceof EMail ) {
         EMail spEMail = (EMail)startPoint;

      }
      if ( startPoint instanceof InstantMessenger ) {
         InstantMessenger spInstantMessenger = (InstantMessenger)startPoint;

      }
      if ( startPoint instanceof LegalEntity ) {
         LegalEntity spLegalEntity = (LegalEntity)startPoint;

         registerChild(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spLegalEntity.getContactPerson());
      }
      if ( startPoint instanceof Mandator ) {
         Mandator spMandator = (Mandator)startPoint;

         registerChilds(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spMandator.get_partner());
      }
      if ( startPoint instanceof Partner ) {
         Partner spPartner = (Partner)startPoint;

         registerChilds(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPartner.get_eMail());
         registerChilds(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPartner.get_instantMessenger());
         registerChilds(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPartner.get_telephone());
         registerChilds(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPartner.getAddresses());
         registerChilds(CommonVisitableIterator.class, spPartner.getNotes());
         registerChild(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPartner.getPreferredAddress());
         registerChild(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPartner.getPrimaryAddress());
      }
      if ( startPoint instanceof Person ) {
         Person spPerson = (Person)startPoint;

         registerChild(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPerson.get_profession());
      }
      if ( startPoint instanceof PersonList ) {
         PersonList spPersonList = (PersonList)startPoint;

         registerChilds(org.umlmda.demo.partner.dto.PartnerVisitableIterator.class, spPersonList.get_person());
      }
      if ( startPoint instanceof PostalAddress ) {
         PostalAddress spPostalAddress = (PostalAddress)startPoint;

      }
      if ( startPoint instanceof Profession ) {
         Profession spProfession = (Profession)startPoint;

      }
      if ( startPoint instanceof Telephone ) {
         Telephone spTelephone = (Telephone)startPoint;

      }
   }
}

//@@UserSection-Begin RCSLog
//@@UserSection-End RCSLog