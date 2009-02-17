package org.umlmda.test.combinedids.one2many.persistence.impl;

import org.umlmda.runtime.visitor.AbstractVisitor;

import org.umlmda.test.combinedids.one2many.persistence.C1;
import org.umlmda.test.combinedids.one2many.persistence.C2;
import org.umlmda.test.combinedids.one2many.persistence.C3;
import org.umlmda.test.combinedids.one2many.persistence.C4;
import org.umlmda.test.combinedids.one2many.persistence.C5;
import org.umlmda.test.combinedids.one2many.persistence.D1;
import org.umlmda.test.combinedids.one2many.persistence.D2;
import org.umlmda.test.combinedids.one2many.persistence.D3;
import org.umlmda.test.combinedids.one2many.persistence.D4;
import org.umlmda.test.combinedids.one2many.persistence.D5;
import org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor;

/**
 * Abtract base class for all visitor interface implementations for the 
 * business objects of ${genPackage.qualifiedName} 
 */
public abstract class AbstractOne2manyVisitor extends AbstractVisitor implements One2manyVisitor {
   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitor\#isApplicable(java.lang.Class)
    */
   public boolean isApplicable(Class visitableClass) {
      if (C1.class.isAssignableFrom(visitableClass) || C2.class.isAssignableFrom(visitableClass)
            || C3.class.isAssignableFrom(visitableClass) || C4.class.isAssignableFrom(visitableClass)
            || C5.class.isAssignableFrom(visitableClass) || D1.class.isAssignableFrom(visitableClass)
            || D2.class.isAssignableFrom(visitableClass) || D3.class.isAssignableFrom(visitableClass)
            || D4.class.isAssignableFrom(visitableClass) || D5.class.isAssignableFrom(visitableClass)) {
         return true;
      }
      else {
         return false;
      }
   }
}
