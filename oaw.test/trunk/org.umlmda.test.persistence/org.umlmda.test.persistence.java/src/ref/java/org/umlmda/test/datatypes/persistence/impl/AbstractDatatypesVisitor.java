package org.umlmda.test.datatypes.persistence.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;

import org.umlmda.test.datatypes.persistence.DatatypeTest;
import org.umlmda.test.datatypes.persistence.DatatypesVisitor;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of ${genPackage.qualifiedName} 
 */
public abstract class AbstractDatatypesVisitor extends AbstractVisitor implements DatatypesVisitor {
   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if (DatatypeTest.class.isAssignableFrom(visitableClass)) {
         return true;
      }
      else {
         return false;
      }
   }
}
