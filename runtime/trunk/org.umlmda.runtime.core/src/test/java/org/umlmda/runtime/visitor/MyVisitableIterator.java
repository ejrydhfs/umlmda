/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package org.umlmda.runtime.visitor;

public class MyVisitableIterator extends AbstractVisitableIterator
{

   public MyVisitableIterator(Object startPoint) {
      this(null, startPoint);
   }

   public MyVisitableIterator(VisitableIterator parentIterator, Object startPoint) {
      super(parentIterator, startPoint);
   }

   @Override
   protected void registerChildrenOf(Object startPoint) {

      if ( startPoint instanceof MyVisitableObject ) {
         MyVisitableObject parent = (MyVisitableObject) startPoint;
         // registerChilds(MyVisitableIterator.class, parent.getChildren());
         registerChildren(parent.getChildren());
      }
   }

}
