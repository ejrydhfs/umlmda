package org.umlmda.test.combinedids.one2many.persistence;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.test.combinedids.one2many 
 */
public interface One2manyVisitor extends Visitor {
   public void visit(C1 aC1);

   public void visit(C2 aC2);

   public void visit(C3 aC3);

   public void visit(C4 aC4);

   public void visit(C5 aC5);

   public void visit(D1 aD1);

   public void visit(D2 aD2);

   public void visit(D3 aD3);

   public void visit(D4 aD4);

   public void visit(D5 aD5);
}
