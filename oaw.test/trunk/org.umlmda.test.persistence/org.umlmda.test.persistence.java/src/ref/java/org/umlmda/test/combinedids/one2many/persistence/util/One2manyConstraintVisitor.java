package org.umlmda.test.combinedids.one2many.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.combinedids.one2many.persistence.C1;
import org.umlmda.test.combinedids.one2many.persistence.C2;
import org.umlmda.test.combinedids.one2many.persistence.C3;
import org.umlmda.test.combinedids.one2many.persistence.C4;
import org.umlmda.test.combinedids.one2many.persistence.D1;
import org.umlmda.test.combinedids.one2many.persistence.D2;
import org.umlmda.test.combinedids.one2many.persistence.D3;
import org.umlmda.test.combinedids.one2many.persistence.D4;
import org.umlmda.test.combinedids.one2many.persistence.impl.AbstractOne2manyVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.combinedids.one2many 
 */
public class One2manyConstraintVisitor extends AbstractOne2manyVisitor implements
      org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor {
   /**
    * @param context
    */
   public One2manyConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(C1 aC1) {
      getConstraintContext().checkMultiplicityContraint(aC1.getClass().getName() + ".groupId", 1, 1, aC1.getC1Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aC1.getClass().getName() + ".aId", 1, 1, aC1.getC1Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aC1.getClass().getName() + ".aAttr", 0, 1, aC1.getAAttr());
   }

   public void visit(C2 aC2) {
      getConstraintContext().checkMultiplicityContraint(aC2.getClass().getName() + ".groupId", 1, 1, aC2.getC2Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aC2.getClass().getName() + ".aId", 1, 1, aC2.getC2Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aC2.getClass().getName() + ".aAttr", 0, 1, aC2.getAAttr());
   }

   public void visit(C3 aC3) {
      getConstraintContext().checkMultiplicityContraint(aC3.getClass().getName() + ".groupId", 1, 1, aC3.getC3Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aC3.getClass().getName() + ".aId", 1, 1, aC3.getC3Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aC3.getClass().getName() + ".aAttr", 0, 1, aC3.getAAttr());
   }

   public void visit(C4 aC4) {
      getConstraintContext().checkMultiplicityContraint(aC4.getClass().getName() + ".groupId", 1, 1, aC4.getC4Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aC4.getClass().getName() + ".aId", 1, 1, aC4.getC4Pkey().getAId());
      getConstraintContext().checkMultiplicityContraint(aC4.getClass().getName() + ".aAttr", 0, 1, aC4.getAAttr());
   }

   public void visit(D1 aD1) {
      getConstraintContext().checkMultiplicityContraint(aD1.getClass().getName() + ".groupId", 1, 1, aD1.getD1Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aD1.getClass().getName() + ".bId", 1, 1, aD1.getD1Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aD1.getClass().getName() + ".bAttr", 0, 1, aD1.getBAttr());
   }

   public void visit(D2 aD2) {
      getConstraintContext().checkMultiplicityContraint(aD2.getClass().getName() + ".groupId", 1, 1, aD2.getD2Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aD2.getClass().getName() + ".bId", 1, 1, aD2.getD2Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aD2.getClass().getName() + ".bAttr", 0, 1, aD2.getBAttr());
      getConstraintContext().checkMultiplicityContraint(aD2.getClass().getName() + ".a", 1, 1, aD2.getA());
   }

   public void visit(D3 aD3) {
      getConstraintContext().checkMultiplicityContraint(aD3.getClass().getName() + ".groupId", 1, 1, aD3.getD3Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aD3.getClass().getName() + ".bId", 1, 1, aD3.getD3Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aD3.getClass().getName() + ".bAttr", 0, 1, aD3.getBAttr());
   }

   public void visit(D4 aD4) {
      getConstraintContext().checkMultiplicityContraint(aD4.getClass().getName() + ".groupId", 1, 1, aD4.getD4Pkey().getGroupId());
      getConstraintContext().checkMultiplicityContraint(aD4.getClass().getName() + ".bId", 1, 1, aD4.getD4Pkey().getBId());
      getConstraintContext().checkMultiplicityContraint(aD4.getClass().getName() + ".bAttr", 0, 1, aD4.getBAttr());
      getConstraintContext().checkMultiplicityContraint(aD4.getClass().getName() + ".a", 1, 1, aD4.getA());
   }
}
