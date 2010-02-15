/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: MyVisitableIteration.java,v $Version 15.02.2010 09:32:29 {user} Exp $
 */
package org.umlmda.runtime.visitor;

import org.umlmda.runtime.constraint.ConstraintVisitorContext;

public class MyConstraintIteration extends AbstractVisitableIteration
{

   /**
    * Ctor to start the constraint check with the default ConstraintVisitorContext.
    * 
    * @param startPoint
    *           start point of the iteration
    */
   public MyConstraintIteration(Object startPoint) {
      this(new MyVisitableIterator(startPoint), new ConstraintVisitorContext());
   }

   /**
    * Ctor to start the constraint check with a given VisitorContext.
    * 
    * @param startPoint
    *           start point of the iteration
    * @param visitorContext
    *           the context object that collects the iteration result
    */
   public MyConstraintIteration(Object startPoint, VisitorContext visitorContext) {
      this(new MyVisitableIterator(startPoint), visitorContext);
   }

   /**
    * Ctor to continue the constraint check in a child element of the start point. Usually used only internally.
    * 
    * @param iterator
    *           iterator for the child element
    * @param visitorContext
    *           the context object that collects the iteration result
    */
   public MyConstraintIteration(VisitableIterator iterator, VisitorContext visitorContext) {
      super(iterator, visitorContext);
      registerVisitor(new MyVisitor());
   }

}
