//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/AbstractVisitor.vm,v 1.1.2.1 2008/01/21 14:57:15 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/AbstractVisitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:15 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.service.dto.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;



import org.umlmda.demo.service.dto.ServiceVisitor;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of org.umlmda.demo.service 
 */
public abstract class AbstractServiceVisitor extends AbstractVisitor implements ServiceVisitor {

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
	  return false;
   }
}
