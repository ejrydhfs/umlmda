/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: MyVisitableIterator.java,v $Version 15.02.2010 09:59:01 {user} Exp $
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
