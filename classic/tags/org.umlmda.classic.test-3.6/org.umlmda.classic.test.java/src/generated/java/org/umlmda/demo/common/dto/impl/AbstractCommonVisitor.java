//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/AbstractVisitor.vm,v 1.1.2.1 2008/01/21 14:57:15 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/templates/java/Attic/AbstractVisitor.vm,v $
// $Revision: 1.1.2.1 $
//     $Name:  $
//     $Date: 2008/01/21 14:57:15 $
//@@UserSection-End RCSHeader
package org.umlmda.demo.common.dto.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;



import org.umlmda.demo.common.dto.CommonVisitor;
import org.umlmda.demo.common.dto.Note;
import org.umlmda.demo.common.dto.SecurityToken;
import org.umlmda.demo.common.dto.TimeDependent;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of org.umlmda.demo.common 
 */
public abstract class AbstractCommonVisitor extends AbstractVisitor implements CommonVisitor {

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if ( Note.class.isAssignableFrom(visitableClass)
      ||   SecurityToken.class.isAssignableFrom(visitableClass)
      ||   TimeDependent.class.isAssignableFrom(visitableClass)
      ) {
         return true;
      }
      else {
         return false;
      }
   }
}
