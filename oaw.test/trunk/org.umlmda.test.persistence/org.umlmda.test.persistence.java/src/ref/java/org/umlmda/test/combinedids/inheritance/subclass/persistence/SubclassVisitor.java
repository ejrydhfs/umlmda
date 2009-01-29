package org.umlmda.test.combinedids.inheritance.subclass.persistence;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.test.combinedids.inheritance.subclass 
 */
public interface SubclassVisitor extends Visitor {
   public void visit(I2 aI2);

   public void visit(I21 aI21);

   public void visit(I22 aI22);
}
