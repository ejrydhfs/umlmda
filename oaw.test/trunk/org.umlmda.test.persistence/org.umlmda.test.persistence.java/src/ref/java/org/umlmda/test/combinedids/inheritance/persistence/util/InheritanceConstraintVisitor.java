package org.umlmda.test.combinedids.inheritance.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.combinedids.inheritance.persistence.I011;
import org.umlmda.test.combinedids.inheritance.persistence.impl.AbstractInheritanceVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.combinedids.inheritance 
 */
public class InheritanceConstraintVisitor extends AbstractInheritanceVisitor implements
      org.umlmda.test.combinedids.inheritance.persistence.InheritanceVisitor {
   /**
    * @param context
    */
   public InheritanceConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(I011 aI011) {
      getConstraintContext().checkMultiplicityContraint(aI011.getClass().getName() + ".i011attr", 0, 1,
            aI011.getI011attr());
   }
}
