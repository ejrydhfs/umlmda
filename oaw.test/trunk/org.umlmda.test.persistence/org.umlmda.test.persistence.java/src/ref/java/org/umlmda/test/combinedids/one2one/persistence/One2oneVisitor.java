package org.umlmda.test.combinedids.one2one.persistence;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.test.combinedids.one2one 
 */
public interface One2oneVisitor extends Visitor {
   public void visit(A1 aA1);

   public void visit(A2 aA2);

   public void visit(A3 aA3);

   public void visit(A4 aA4);

   public void visit(B1 aB1);

   public void visit(B2 aB2);

   public void visit(B3 aB3);

   public void visit(B4 aB4);
}
