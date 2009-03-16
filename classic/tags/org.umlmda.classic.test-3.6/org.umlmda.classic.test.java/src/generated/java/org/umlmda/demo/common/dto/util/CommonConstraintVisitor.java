//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintVisitor.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintVisitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.common.dto.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.demo.common.dto.Note;
import org.umlmda.demo.common.dto.SecurityToken;
import org.umlmda.demo.common.dto.TimeDependent;
import org.umlmda.demo.common.dto.impl.AbstractCommonVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.demo.common 
 */
public class CommonConstraintVisitor extends AbstractCommonVisitor implements org.umlmda.demo.common.dto.CommonVisitor {

   /**
    * @param context
    */
   public CommonConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }
   
   
   public void visit(Note aNote) {
      getConstraintContext().checkMultiplicityContraint(aNote.getClass().getName()+".usage", 1, 1, aNote.getUsage());
      getConstraintContext().checkMultiplicityContraint(aNote.getClass().getName()+".context", 1, 1, aNote.getContext());
   }
   
   public void visit(SecurityToken aSecurityToken) {
      getConstraintContext().checkMultiplicityContraint(aSecurityToken.getClass().getName()+".securityIds", 0, -1, aSecurityToken.getSecurityIds());
   }
   
   public void visit(TimeDependent aTimeDependent) {
      getConstraintContext().checkMultiplicityContraint(aTimeDependent.getClass().getName()+".validFrom", 1, 1, aTimeDependent.getValidFrom());
      getConstraintContext().checkMultiplicityContraint(aTimeDependent.getClass().getName()+".validTo", 0, 1, aTimeDependent.getValidTo());
      getConstraintContext().checkMultiplicityContraint(aTimeDependent.getClass().getName()+".createdAt", 1, 1, aTimeDependent.getCreatedAt());
      getConstraintContext().checkMultiplicityContraint(aTimeDependent.getClass().getName()+".dummy", 1, 1, aTimeDependent.getDummy());
   }
   
}
