package org.umlmda.test.combinedids.many2many.persistence;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.test.combinedids.many2many 
 */
public interface Many2manyVisitor extends Visitor {
   public void visit(E1 aE1);

   public void visit(E2 aE2);

   public void visit(F1 aF1);

   public void visit(F2 aF2);
}
