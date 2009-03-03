package org.umlmda.test.combinedids.one2one.persistence.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;

import org.umlmda.test.combinedids.one2one.persistence.A1;
import org.umlmda.test.combinedids.one2one.persistence.A2;
import org.umlmda.test.combinedids.one2one.persistence.A4;
import org.umlmda.test.combinedids.one2one.persistence.B1;
import org.umlmda.test.combinedids.one2one.persistence.B2;
import org.umlmda.test.combinedids.one2one.persistence.B4;
import org.umlmda.test.combinedids.one2one.persistence.One2oneVisitor;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of ${genPackage.qualifiedName} 
 */
public abstract class AbstractOne2oneVisitor extends AbstractVisitor implements One2oneVisitor {
   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if (A1.class.isAssignableFrom(visitableClass) || A2.class.isAssignableFrom(visitableClass)
            || A4.class.isAssignableFrom(visitableClass) || B1.class.isAssignableFrom(visitableClass)
            || B2.class.isAssignableFrom(visitableClass) || B4.class.isAssignableFrom(visitableClass)) {
         return true;
      }
      else {
         return false;
      }
   }
}
