package org.umlmda.test.combinedids.inheritance.concrete.persistence;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.test.combinedids.inheritance.concrete 
 */
public interface ConcreteVisitor extends Visitor {
   public void visit(I3 aI3);

   public void visit(I31 aI31);

   public void visit(I32 aI32);
}
