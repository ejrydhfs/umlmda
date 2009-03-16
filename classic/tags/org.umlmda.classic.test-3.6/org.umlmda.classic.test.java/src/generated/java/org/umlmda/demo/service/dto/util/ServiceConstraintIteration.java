//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintIteration.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintIteration.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.service.dto.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;
import org.umlmda.runtime.visitor.AbstractVisitableIteration;
import org.umlmda.runtime.visitor.VisitableIterator;

import org.umlmda.demo.partner.dto.util.PartnerConstraintVisitor;
import org.umlmda.demo.service.dto.ServiceVisitableIterator;

/**
 * Constraint visitor for the business objects of org.umlmda.demo.service 
 */
public class ServiceConstraintIteration extends AbstractVisitableIteration {

   /**
    * Ctor to start the constraint check.
    * @param object Startpoint of the iteration
    */
   public ServiceConstraintIteration(Object object) {
      this(new ServiceVisitableIterator(object));
   }

   /**
    * Ctor to continue the constraint check in a child element of the start point.
	* Usually used only internal.
    * @param iterator Iterator for the child element
    */
   public ServiceConstraintIteration(VisitableIterator iterator) {
      super(iterator, new ConstraintVisitorContext());
      
      registerVisitor(new PartnerConstraintVisitor());
      registerVisitor(new ServiceConstraintVisitor());
   }

}
