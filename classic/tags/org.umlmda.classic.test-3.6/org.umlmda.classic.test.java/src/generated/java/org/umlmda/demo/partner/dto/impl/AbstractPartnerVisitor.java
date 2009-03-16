//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/AbstractVisitor.vm,v 1.1.2.1 2008/01/21 14:57:15 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/AbstractVisitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:15 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.partner.dto.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;



import org.umlmda.demo.partner.dto.CommunicationAddress;
import org.umlmda.demo.partner.dto.EMail;
import org.umlmda.demo.partner.dto.InstantMessenger;
import org.umlmda.demo.partner.dto.LegalEntity;
import org.umlmda.demo.partner.dto.Mandator;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PartnerVisitor;
import org.umlmda.demo.partner.dto.Person;
import org.umlmda.demo.partner.dto.PersonList;
import org.umlmda.demo.partner.dto.PostalAddress;
import org.umlmda.demo.partner.dto.Profession;
import org.umlmda.demo.partner.dto.Telephone;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of org.umlmda.demo.partner 
 */
public abstract class AbstractPartnerVisitor extends AbstractVisitor implements PartnerVisitor {

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if ( CommunicationAddress.class.isAssignableFrom(visitableClass)
      ||   EMail.class.isAssignableFrom(visitableClass)
      ||   InstantMessenger.class.isAssignableFrom(visitableClass)
      ||   LegalEntity.class.isAssignableFrom(visitableClass)
      ||   Mandator.class.isAssignableFrom(visitableClass)
      ||   Partner.class.isAssignableFrom(visitableClass)
      ||   Person.class.isAssignableFrom(visitableClass)
      ||   PersonList.class.isAssignableFrom(visitableClass)
      ||   PostalAddress.class.isAssignableFrom(visitableClass)
      ||   Profession.class.isAssignableFrom(visitableClass)
      ||   Telephone.class.isAssignableFrom(visitableClass)
      ) {
         return true;
      }
      else {
         return false;
      }
   }
}
