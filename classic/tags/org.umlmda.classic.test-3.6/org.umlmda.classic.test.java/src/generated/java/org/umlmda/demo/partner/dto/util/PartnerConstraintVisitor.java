//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintVisitor.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintVisitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.partner.dto.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.demo.partner.dto.CommunicationAddress;
import org.umlmda.demo.partner.dto.EMail;
import org.umlmda.demo.partner.dto.InstantMessenger;
import org.umlmda.demo.partner.dto.LegalEntity;
import org.umlmda.demo.partner.dto.Mandator;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.Person;
import org.umlmda.demo.partner.dto.PersonList;
import org.umlmda.demo.partner.dto.PostalAddress;
import org.umlmda.demo.partner.dto.Profession;
import org.umlmda.demo.partner.dto.Telephone;
import org.umlmda.demo.partner.dto.impl.AbstractPartnerVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.demo.partner 
 */
public class PartnerConstraintVisitor extends AbstractPartnerVisitor implements org.umlmda.demo.partner.dto.PartnerVisitor {

   /**
    * @param context
    */
   public PartnerConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }
   
   
   public void visit(CommunicationAddress aCommunicationAddress) {
      getConstraintContext().checkMultiplicityContraint(aCommunicationAddress.getClass().getName()+".validFrom", 1, 1, aCommunicationAddress.getValidFrom());
      getConstraintContext().checkMultiplicityContraint(aCommunicationAddress.getClass().getName()+".validTo", 0, 1, aCommunicationAddress.getValidTo());
      getConstraintContext().checkMultiplicityContraint(aCommunicationAddress.getClass().getName()+".createdAt", 1, 1, aCommunicationAddress.getCreatedAt());
      getConstraintContext().checkMultiplicityContraint(aCommunicationAddress.getClass().getName()+".dummy", 1, 1, aCommunicationAddress.getDummy());
   }
   
   public void visit(EMail aEMail) {
      getConstraintContext().checkMultiplicityContraint(aEMail.getClass().getName()+".validFrom", 1, 1, aEMail.getValidFrom());
      getConstraintContext().checkMultiplicityContraint(aEMail.getClass().getName()+".validTo", 0, 1, aEMail.getValidTo());
      getConstraintContext().checkMultiplicityContraint(aEMail.getClass().getName()+".createdAt", 1, 1, aEMail.getCreatedAt());
      getConstraintContext().checkMultiplicityContraint(aEMail.getClass().getName()+".dummy", 1, 1, aEMail.getDummy());
      getConstraintContext().checkMultiplicityContraint(aEMail.getClass().getName()+".adress", 1, 1, aEMail.getAdress());
   }
   
   public void visit(InstantMessenger aInstantMessenger) {
      getConstraintContext().checkMultiplicityContraint(aInstantMessenger.getClass().getName()+".validFrom", 1, 1, aInstantMessenger.getValidFrom());
      getConstraintContext().checkMultiplicityContraint(aInstantMessenger.getClass().getName()+".validTo", 0, 1, aInstantMessenger.getValidTo());
      getConstraintContext().checkMultiplicityContraint(aInstantMessenger.getClass().getName()+".createdAt", 1, 1, aInstantMessenger.getCreatedAt());
      getConstraintContext().checkMultiplicityContraint(aInstantMessenger.getClass().getName()+".dummy", 1, 1, aInstantMessenger.getDummy());
      getConstraintContext().checkMultiplicityContraint(aInstantMessenger.getClass().getName()+".imType", 0, 1, aInstantMessenger.getImType());
      getConstraintContext().checkMultiplicityContraint(aInstantMessenger.getClass().getName()+".imId", 1, 1, aInstantMessenger.getImId());
      getConstraintContext().checkMultiplicityContraint(aInstantMessenger.getClass().getName()+".imNick", 1, 1, aInstantMessenger.getImNick());
   }
   
   public void visit(LegalEntity aLegalEntity) {
      getConstraintContext().checkMultiplicityContraint(aLegalEntity.getClass().getName()+".id", 1, 1, aLegalEntity.getId());
      getConstraintContext().checkMultiplicityContraint(aLegalEntity.getClass().getName()+".name", 1, 1, aLegalEntity.getName());
      getConstraintContext().checkMultiplicityContraint(aLegalEntity.getClass().getName()+".legalForm", 1, 1, aLegalEntity.getLegalForm());
      getConstraintContext().checkMultiplicityContraint(aLegalEntity.getClass().getName()+".revenue", 1, 1, aLegalEntity.getRevenue());
      getConstraintContext().checkMultiplicityContraint(aLegalEntity.getClass().getName()+".addresses", 1, -1, aLegalEntity.getAddresses());
      getConstraintContext().checkMultiplicityContraint(aLegalEntity.getClass().getName()+".primaryAddress", 1, 1, aLegalEntity.getPrimaryAddress());
   }
   
   public void visit(Mandator aMandator) {
      getConstraintContext().checkMultiplicityContraint(aMandator.getClass().getName()+".mandatorId", 1, 1, aMandator.getMandatorId());
      getConstraintContext().checkMultiplicityContraint(aMandator.getClass().getName()+".name", 1, 1, aMandator.getName());
   }
   
   public void visit(Partner aPartner) {
      getConstraintContext().checkMultiplicityContraint(aPartner.getClass().getName()+".id", 1, 1, aPartner.getId());
      getConstraintContext().checkMultiplicityContraint(aPartner.getClass().getName()+".name", 1, 1, aPartner.getName());
      getConstraintContext().checkMultiplicityContraint(aPartner.getClass().getName()+".addresses", 1, -1, aPartner.getAddresses());
      getConstraintContext().checkMultiplicityContraint(aPartner.getClass().getName()+".primaryAddress", 1, 1, aPartner.getPrimaryAddress());
   }
   
   public void visit(Person aPerson) {
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".id", 1, 1, aPerson.getId());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".name", 1, 1, aPerson.getName());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".firstname", 1, 1, aPerson.getFirstname());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".birthdate", 1, 1, aPerson.getBirthdate());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".sex", 0, 1, aPerson.getSex());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".salary", 1, 1, aPerson.getSalary());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".nationalities", 0, -1, aPerson.getNationalities());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".addresses", 1, -1, aPerson.getAddresses());
      getConstraintContext().checkMultiplicityContraint(aPerson.getClass().getName()+".primaryAddress", 1, 1, aPerson.getPrimaryAddress());
   }
   
   public void visit(PersonList aPersonList) {
   }
   
   public void visit(PostalAddress aPostalAddress) {
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".validFrom", 1, 1, aPostalAddress.getValidFrom());
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".validTo", 0, 1, aPostalAddress.getValidTo());
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".createdAt", 1, 1, aPostalAddress.getCreatedAt());
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".dummy", 1, 1, aPostalAddress.getDummy());
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".zip", 1, 1, aPostalAddress.getZip());
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".city", 1, 1, aPostalAddress.getCity());
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".street", 1, 1, aPostalAddress.getStreet());
      getConstraintContext().checkMultiplicityContraint(aPostalAddress.getClass().getName()+".type", 1, 1, aPostalAddress.getType());
   }
   
   public void visit(Profession aProfession) {
      getConstraintContext().checkMultiplicityContraint(aProfession.getClass().getName()+".name", 1, 1, aProfession.getName());
   }
   
   public void visit(Telephone aTelephone) {
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".validFrom", 1, 1, aTelephone.getValidFrom());
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".validTo", 0, 1, aTelephone.getValidTo());
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".createdAt", 1, 1, aTelephone.getCreatedAt());
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".dummy", 1, 1, aTelephone.getDummy());
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".countryCode", 1, 1, aTelephone.getCountryCode());
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".areaCode", 1, 1, aTelephone.getAreaCode());
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".number", 1, 1, aTelephone.getNumber());
      getConstraintContext().checkMultiplicityContraint(aTelephone.getClass().getName()+".fullNumber", 1, 1, aTelephone.getFullNumber());
   }
   
}
