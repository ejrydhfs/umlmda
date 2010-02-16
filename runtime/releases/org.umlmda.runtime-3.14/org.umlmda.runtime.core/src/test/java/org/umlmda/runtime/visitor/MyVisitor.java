/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: MyVisitor.java,v $Version 15.02.2010 09:24:05 {user} Exp $
 */
package org.umlmda.runtime.visitor;

import org.umlmda.runtime.constraint.ConstraintViolation;
import org.umlmda.runtime.constraint.ConstraintVisitorContext;

public class MyVisitor implements Visitor
{

   private VisitorContext context;

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor#getContext()
    */
   public VisitorContext getContext() {
      return context;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class<?> visitableClass) {
      return visitableClass.isAssignableFrom(MyVisitableObject.class) || //
            visitableClass.isAssignableFrom(MyVisitableChildObject.class);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor#setContext(org.umlmda.runtime.visitor.VisitorContext)
    */
   public void setContext(VisitorContext context) {
      this.context = context;
   }

   public void visit(MyVisitableObject myVisitable) {
      ConstraintVisitorContext aContext = (ConstraintVisitorContext) getContext();
      aContext.getViolations().add(new ConstraintViolation(myVisitable.toString()));
   }

   public void visit(MyVisitableChildObject myVisitable) {
      ConstraintVisitorContext aContext = (ConstraintVisitorContext) getContext();
      aContext.getViolations().add(new ConstraintViolation(myVisitable.toString()));
   }

}
