package org.umlmda.test.combinedids.inheritance.concrete.persistence.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;

import org.umlmda.test.combinedids.inheritance.concrete.persistence.ConcreteVisitor;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I3;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I31;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I32;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of ${genPackage.qualifiedName} 
 */
public abstract class AbstractConcreteVisitor extends AbstractVisitor implements ConcreteVisitor {
   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if (I3.class.isAssignableFrom(visitableClass) || I31.class.isAssignableFrom(visitableClass)
            || I32.class.isAssignableFrom(visitableClass)) {
         return true;
      }
      else {
         return false;
      }
   }
}
