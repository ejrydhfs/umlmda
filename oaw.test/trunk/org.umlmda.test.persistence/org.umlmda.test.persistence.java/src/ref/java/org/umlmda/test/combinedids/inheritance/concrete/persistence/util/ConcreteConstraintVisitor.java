package org.umlmda.test.combinedids.inheritance.concrete.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.combinedids.inheritance.concrete.persistence.I3;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I31;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.I32;
import org.umlmda.test.combinedids.inheritance.concrete.persistence.impl.AbstractConcreteVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.combinedids.inheritance.concrete 
 */
public class ConcreteConstraintVisitor extends AbstractConcreteVisitor implements
      org.umlmda.test.combinedids.inheritance.concrete.persistence.ConcreteVisitor {
   /**
    * @param context
    */
   public ConcreteConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(I3 aI3) {
      getConstraintContext().checkMultiplicityContraint(aI3.getClass().getName() + ".groupId", 1, 1, aI3.getGroupId());
      getConstraintContext().checkMultiplicityContraint(aI3.getClass().getName() + ".iId", 1, 1, aI3.getIId());
      getConstraintContext().checkMultiplicityContraint(aI3.getClass().getName() + ".i1Attr", 0, 1, aI3.getI1Attr());
   }

   public void visit(I31 aI31) {
      getConstraintContext().checkMultiplicityContraint(aI31.getClass().getName() + ".i2Attr", 0, 1, aI31.getI2Attr());
   }

   public void visit(I32 aI32) {
      getConstraintContext().checkMultiplicityContraint(aI32.getClass().getName() + ".i3Attr", 0, 1, aI32.getI3Attr());
   }
}
