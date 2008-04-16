package org.umlmda.runtime.sdo.sync.test.dto;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.runtime.sdo.sync.test 
 */
public interface TestVisitor extends Visitor {
   public void visit(RootChild aRootChild);

   public void visit(RootChildren aRootChildren);

   public void visit(RootClass aRootClass);

   public void visit(RootGreatChildren aRootGreatChildren);
}
