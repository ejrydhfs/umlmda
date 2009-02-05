package org.umlmda.test.combinedids.one2one.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.combinedids.one2one.persistence.A1;
import org.umlmda.test.combinedids.one2one.persistence.A2;
import org.umlmda.test.combinedids.one2one.persistence.A3;
import org.umlmda.test.combinedids.one2one.persistence.A4;
import org.umlmda.test.combinedids.one2one.persistence.B1;
import org.umlmda.test.combinedids.one2one.persistence.B2;
import org.umlmda.test.combinedids.one2one.persistence.B3;
import org.umlmda.test.combinedids.one2one.persistence.B4;
import org.umlmda.test.combinedids.one2one.persistence.impl.AbstractOne2oneVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.combinedids.one2one 
 */
public class One2oneConstraintVisitor extends AbstractOne2oneVisitor implements
      org.umlmda.test.combinedids.one2one.persistence.One2oneVisitor {
   /**
    * @param context
    */
   public One2oneConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(A1 aA1) {
      getConstraintContext().checkMultiplicityContraint(aA1.getClass().getName() + ".groupId", 1, 1, aA1.getA1Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aA1.getClass().getName() + ".aId", 1, 1, aA1.getA1Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aA1.getClass().getName() + ".aAttr", 0, 1, aA1.getAAttr());
   }

   public void visit(A2 aA2) {
      getConstraintContext().checkMultiplicityContraint(aA2.getClass().getName() + ".groupId", 1, 1, aA2.getA2Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aA2.getClass().getName() + ".aId", 1, 1, aA2.getA2Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aA2.getClass().getName() + ".aAttr", 0, 1, aA2.getAAttr());
   }

   public void visit(A3 aA3) {
      getConstraintContext().checkMultiplicityContraint(aA3.getClass().getName() + ".groupId", 1, 1, aA3.getA3Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aA3.getClass().getName() + ".aId", 1, 1, aA3.getA3Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aA3.getClass().getName() + ".aAttr", 0, 1, aA3.getAAttr());
   }

   public void visit(A4 aA4) {
      getConstraintContext().checkMultiplicityContraint(aA4.getClass().getName() + ".groupId", 1, 1, aA4.getA4Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aA4.getClass().getName() + ".aId", 1, 1, aA4.getA4Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aA4.getClass().getName() + ".aAttr", 0, 1, aA4.getAAttr());
   }

   public void visit(B1 aB1) {
      getConstraintContext().checkMultiplicityContraint(aB1.getClass().getName() + ".groupId", 1, 1, aB1.getB1Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aB1.getClass().getName() + ".bId", 1, 1, aB1.getB1Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aB1.getClass().getName() + ".bAttr", 0, 1, aB1.getBAttr());
   }

   public void visit(B2 aB2) {
      getConstraintContext().checkMultiplicityContraint(aB2.getClass().getName() + ".groupId", 1, 1, aB2.getB2Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aB2.getClass().getName() + ".bId", 1, 1, aB2.getB2Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aB2.getClass().getName() + ".bAttr", 0, 1, aB2.getBAttr());
   }

   public void visit(B3 aB3) {
      getConstraintContext().checkMultiplicityContraint(aB3.getClass().getName() + ".groupId", 1, 1, aB3.getB3Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aB3.getClass().getName() + ".bId", 1, 1, aB3.getB3Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aB3.getClass().getName() + ".bAttr", 0, 1, aB3.getBAttr());
   }

   public void visit(B4 aB4) {
      getConstraintContext().checkMultiplicityContraint(aB4.getClass().getName() + ".groupId", 1, 1, aB4.getB4Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aB4.getClass().getName() + ".bId", 1, 1, aB4.getB4Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aB4.getClass().getName() + ".bAttr", 0, 1, aB4.getBAttr());
      getConstraintContext().checkMultiplicityContraint(aB4.getClass().getName() + ".a", 1, 1, aB4.getA());
   }
}
