package org.umlmda.test.datatypes.persistence;

import org.umlmda.runtime.visitor.Visitor;

/**
 * Visitor interface for the business object of org.umlmda.test.datatypes 
 */
public interface DatatypesVisitor extends Visitor {
   public void visit(DatatypeTest aDatatypeTest);
}
