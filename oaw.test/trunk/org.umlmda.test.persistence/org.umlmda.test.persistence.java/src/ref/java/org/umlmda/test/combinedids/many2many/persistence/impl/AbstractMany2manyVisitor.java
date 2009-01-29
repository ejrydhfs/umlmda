package org.umlmda.test.combinedids.many2many.persistence.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;

import org.umlmda.test.combinedids.many2many.persistence.E1;
import org.umlmda.test.combinedids.many2many.persistence.E2;
import org.umlmda.test.combinedids.many2many.persistence.F1;
import org.umlmda.test.combinedids.many2many.persistence.F2;
import org.umlmda.test.combinedids.many2many.persistence.Many2manyVisitor;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of ${genPackage.qualifiedName} 
 */
public abstract class AbstractMany2manyVisitor extends AbstractVisitor implements Many2manyVisitor {
   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if (E1.class.isAssignableFrom(visitableClass) || E2.class.isAssignableFrom(visitableClass)
            || F1.class.isAssignableFrom(visitableClass) || F2.class.isAssignableFrom(visitableClass)) {
         return true;
      }
      else {
         return false;
      }
   }
}
