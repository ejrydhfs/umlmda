package org.umlmda.test.combinedids.many2many.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.combinedids.many2many.persistence.E1;
import org.umlmda.test.combinedids.many2many.persistence.E2;
import org.umlmda.test.combinedids.many2many.persistence.F1;
import org.umlmda.test.combinedids.many2many.persistence.F2;
import org.umlmda.test.combinedids.many2many.persistence.impl.AbstractMany2manyVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.combinedids.many2many 
 */
public class Many2manyConstraintVisitor extends AbstractMany2manyVisitor implements
      org.umlmda.test.combinedids.many2many.persistence.Many2manyVisitor {
   /**
    * @param context
    */
   public Many2manyConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(E1 aE1) {
      getConstraintContext().checkMultiplicityContraint(aE1.getClass().getName() + ".groupId", 1, 1, aE1.getE1Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aE1.getClass().getName() + ".aId", 1, 1, aE1.getE1Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aE1.getClass().getName() + ".aAttr", 0, 1, aE1.getAAttr());
   }

   public void visit(E2 aE2) {
      getConstraintContext().checkMultiplicityContraint(aE2.getClass().getName() + ".groupId", 1, 1, aE2.getE2Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aE2.getClass().getName() + ".aId", 1, 1, aE2.getE2Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aE2.getClass().getName() + ".aAttr", 0, 1, aE2.getAAttr());
   }

   public void visit(F1 aF1) {
      getConstraintContext().checkMultiplicityContraint(aF1.getClass().getName() + ".groupId", 1, 1, aF1.getF1Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aF1.getClass().getName() + ".bId", 1, 1, aF1.getF1Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aF1.getClass().getName() + ".bAttr", 0, 1, aF1.getBAttr());
   }

   public void visit(F2 aF2) {
      getConstraintContext().checkMultiplicityContraint(aF2.getClass().getName() + ".groupId", 1, 1, aF2.getF2Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aF2.getClass().getName() + ".bId", 1, 1, aF2.getF2Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aF2.getClass().getName() + ".bAttr", 0, 1, aF2.getBAttr());
   }
}
