package org.umlmda.test.datatypes.persistence.util;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

import org.umlmda.test.datatypes.persistence.DatatypeTest;
import org.umlmda.test.datatypes.persistence.impl.AbstractDatatypesVisitor;

/**
 * Constraint visitor for the business objects of org.umlmda.test.datatypes 
 */
public class DatatypesConstraintVisitor extends AbstractDatatypesVisitor implements
      org.umlmda.test.datatypes.persistence.DatatypesVisitor {
   /**
    * @param context
    */
   public DatatypesConstraintVisitor() {
      super();
   }

   public ConstraintVisitorContext getConstraintContext() {
      return (ConstraintVisitorContext) getContext();
   }

   public void visit(DatatypeTest aDatatypeTest) {
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".id", 1, 1,
            aDatatypeTest.getId());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optBooleanAttr", 0, 1,
            aDatatypeTest.getOptBooleanAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optCharAttr", 0, 1,
            aDatatypeTest.getOptCharAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".dateAttr", 1, 1,
            aDatatypeTest.getDateAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optDateAtte", 0, 1,
            aDatatypeTest.getOptDateAtte());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".datetimeAttr", 1, 1,
            aDatatypeTest.getDatetimeAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optDatetimeAttr", 0, 1,
            aDatatypeTest.getOptDatetimeAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".decimalAttr", 1, 1,
            aDatatypeTest.getDecimalAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optDecimalAttr", 0, 1,
            aDatatypeTest.getOptDecimalAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optDoubleAttr", 0, 1,
            aDatatypeTest.getOptDoubleAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optFloatAttr", 0, 1,
            aDatatypeTest.getOptFloatAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optShortAttr", 0, 1,
            aDatatypeTest.getOptShortAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".stringAttr", 1, 1,
            aDatatypeTest.getStringAttr());
      getConstraintContext().checkMultiplicityContraint(aDatatypeTest.getClass().getName() + ".optStringAttr", 0, 1,
            aDatatypeTest.getOptStringAttr());
   }
}
