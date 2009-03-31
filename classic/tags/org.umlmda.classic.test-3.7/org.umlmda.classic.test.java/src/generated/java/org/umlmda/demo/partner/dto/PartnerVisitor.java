//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Visitor.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Visitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.partner.dto;

import org.umlmda.runtime.visitor.Visitor;


/**
 * Visitor interface for the business object of org.umlmda.demo.partner 
 */
public interface PartnerVisitor extends Visitor {

   public void visit(CommunicationAddress aCommunicationAddress);
   
   public void visit(EMail aEMail);
   
   public void visit(InstantMessenger aInstantMessenger);
   
   public void visit(LegalEntity aLegalEntity);
   
   public void visit(Mandator aMandator);
   
   public void visit(Partner aPartner);
   
   public void visit(Person aPerson);
   
   public void visit(PersonList aPersonList);
   
   public void visit(PostalAddress aPostalAddress);
   
   public void visit(Profession aProfession);
   
   public void visit(Telephone aTelephone);
   
}
