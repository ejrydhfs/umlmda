package org.umlmda.test.combinedids.inheritance.subclass.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.combinedids.inheritance.subclass.persistence.I2;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I21;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I22;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.impl.AbstractSubclassVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.combinedids.inheritance.subclass 
 */
public class SubclassConstraintVisitor extends AbstractSubclassVisitor implements
      org.umlmda.test.combinedids.inheritance.subclass.persistence.SubclassVisitor {
   /**
    * @param context
    */
   public SubclassConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(I2 aI2) {
      getConstraintContext().checkMultiplicityContraint(aI2.getClass().getName() + ".groupId", 1, 1, aI2.getGroupId());
      getConstraintContext().checkMultiplicityContraint(aI2.getClass().getName() + ".iId", 1, 1, aI2.getIId());
      getConstraintContext().checkMultiplicityContraint(aI2.getClass().getName() + ".i1Attr", 0, 1, aI2.getI1Attr());
   }

   public void visit(I21 aI21) {
      getConstraintContext().checkMultiplicityContraint(aI21.getClass().getName() + ".i2Attr", 0, 1, aI21.getI2Attr());
   }

   public void visit(I22 aI22) {
      getConstraintContext().checkMultiplicityContraint(aI22.getClass().getName() + ".i3Attr", 0, 1, aI22.getI3Attr());
   }
}
