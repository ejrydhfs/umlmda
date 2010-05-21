/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package org.umlmda.runtime.visitor;

import java.util.HashSet;
import java.util.Set;

public class MyVisitableObject implements Visitable
{
   private final Set<MyVisitableChildObject> children = new HashSet<MyVisitableChildObject>();

   private final String                      name;

   public MyVisitableObject(String name) {
      super();
      this.name = name;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitable#accept(org.umlmda.runtime.visitor.Visitor)
    */
   public void accept(Visitor visitor) {
      if ( visitor instanceof MyVisitor ) {
         MyVisitor aVisitor = (MyVisitor) visitor;
         aVisitor.visit(this);
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.visitor.Visitable#getVisitableIterator()
    */
   public VisitableIterator getVisitableIterator(VisitableIterator parent) {
      return new MyVisitableIterator(parent, this);
   }

   public String getName() {
      return name;
   }

   public Set<MyVisitableChildObject> getChildren() {
      return children;
   }

   @Override
   public String toString() {
      return "MyVisitableObject name=" + name;
   }

}
