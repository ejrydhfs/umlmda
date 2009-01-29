package org.umlmda.test.combinedids.inheritance.hierarchy.persistence.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;

import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.HierarchyVisitor;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I1;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I11;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I12;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of ${genPackage.qualifiedName} 
 */
public abstract class AbstractHierarchyVisitor extends AbstractVisitor implements HierarchyVisitor {
   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if (I1.class.isAssignableFrom(visitableClass) || I11.class.isAssignableFrom(visitableClass)
            || I12.class.isAssignableFrom(visitableClass)) {
         return true;
      }
      else {
         return false;
      }
   }
}
