package org.umlmda.test.combinedids.inheritance.subclass.persistence.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;

import org.umlmda.test.combinedids.inheritance.subclass.persistence.I2;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I21;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I22;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.SubclassVisitor;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of ${genPackage.qualifiedName} 
 */
public abstract class AbstractSubclassVisitor extends AbstractVisitor implements SubclassVisitor {
   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if (I2.class.isAssignableFrom(visitableClass) || I21.class.isAssignableFrom(visitableClass)
            || I22.class.isAssignableFrom(visitableClass)) {
         return true;
      }
      else {
         return false;
      }
   }
}
