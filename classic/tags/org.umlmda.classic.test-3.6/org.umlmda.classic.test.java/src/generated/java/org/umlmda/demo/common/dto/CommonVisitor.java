//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Visitor.vm,v 1.1.2.1 2008/01/21 14:57:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/Visitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:14 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.common.dto;

import org.umlmda.runtime.visitor.Visitor;


/**
 * Visitor interface for the business object of org.umlmda.demo.common 
 */
public interface CommonVisitor extends Visitor {

   public void visit(Note aNote);
   
   public void visit(SecurityToken aSecurityToken);
   
   public void visit(TimeDependent aTimeDependent);
   
}
