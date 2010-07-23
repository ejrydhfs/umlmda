/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package org.umlmda.runtime.visitor;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.umlmda.runtime.constraint.ConstraintVisitorContext;

public class VisitorTest extends TestCase
{
   private final Logger logger = Logger.getLogger(VisitorTest.class);

   public void testVisitorRoot() {
      MyVisitableObject object = new MyVisitableObject("object");

      MyConstraintIteration iteration = new MyConstraintIteration(object);
      ConstraintVisitorContext context = (ConstraintVisitorContext) iteration.iterate();

      assertNotNull(context);
      assertEquals("expected violations", 1, context.getViolations().size());
      logger.info(context.getViolations());
   }

   public void testVisitorTree() {

      MyVisitableObject root = new MyVisitableObject("root");
      root.getChildren().add(new MyVisitableChildObject("child1"));
      root.getChildren().add(new MyVisitableChildObject("child2"));

      MyConstraintIteration iteration = new MyConstraintIteration(root);
      ConstraintVisitorContext context = (ConstraintVisitorContext) iteration.iterate();

      assertNotNull(context);
      assertEquals("expected violations", 3, context.getViolations().size());
      logger.info(context.getViolations());
   }
}
