package org.umlmda.test.combinedids.inheritance.hierarchy.persistence;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.test.combinedids.inheritance.hierarchy 
 */
public interface HierarchyVisitor extends Visitor {
   public void visit(I1 aI1);

   public void visit(I11 aI11);

   public void visit(I12 aI12);
}
