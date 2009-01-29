package org.umlmda.test.combinedids.inheritance.hierarchy.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I1;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I11;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I12;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.impl.AbstractHierarchyVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.combinedids.inheritance.hierarchy 
 */
public class HierarchyConstraintVisitor extends AbstractHierarchyVisitor implements
      org.umlmda.test.combinedids.inheritance.hierarchy.persistence.HierarchyVisitor {
   /**
    * @param context
    */
   public HierarchyConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(I1 aI1) {
      getConstraintContext().checkMultiplicityContraint(aI1.getClass().getName() + ".groupId", 1, 1, aI1.getGroupId());
      getConstraintContext().checkMultiplicityContraint(aI1.getClass().getName() + ".iId", 1, 1, aI1.getIId());
      getConstraintContext().checkMultiplicityContraint(aI1.getClass().getName() + ".i1Attr", 0, 1, aI1.getI1Attr());
   }

   public void visit(I11 aI11) {
      getConstraintContext().checkMultiplicityContraint(aI11.getClass().getName() + ".i2Attr", 0, 1, aI11.getI2Attr());
   }

   public void visit(I12 aI12) {
      getConstraintContext().checkMultiplicityContraint(aI12.getClass().getName() + ".i3Attr", 0, 1, aI12.getI3Attr());
   }
}
