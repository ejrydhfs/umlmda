/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package org.umlmda.runtime.visitor;

public class MyVisitableChildObject implements Visitable
{

   public MyVisitableChildObject(String name) {
      this.name = name;
   }

   private final String name;

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

   @Override
   public String toString() {
      return "MyVisitableChildObject name=" + name;
   }

}
