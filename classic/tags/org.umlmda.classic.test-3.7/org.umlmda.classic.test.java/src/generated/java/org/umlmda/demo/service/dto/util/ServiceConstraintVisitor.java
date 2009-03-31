//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintVisitor.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/ConstraintVisitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.service.dto.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.demo.service.dto.impl.AbstractServiceVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.demo.service 
 */
public class ServiceConstraintVisitor extends AbstractServiceVisitor implements org.umlmda.demo.service.dto.ServiceVisitor {

   /**
    * @param context
    */
   public ServiceConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }
   
   
}
