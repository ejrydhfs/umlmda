/*
 *   $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/visitor/AbstractVisitableIterator.java,v 1.1 2008/03/25 09:54:06 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/visitor/AbstractVisitableIterator.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2008/03/25 09:54:06 $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created by Dieter Moroff (17.02.2006)
 */
package org.umlmda.runtime.visitor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * perform the iteration
 * 
 * @author Dieter Moroff (17.02.2006)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractVisitableIterator implements VisitableIterator
{
   private final Object              startPoint;
   private final List                iteratableItems   = new LinkedList();
   private final Set                 iteratableSet;
   private Iterator                  iterator;
   private boolean                   childsToAdd;
   private AbstractVisitableIterator childItemIterator = null;

   /**
    * start or continue an iteration on the given object
    */
   protected AbstractVisitableIterator(VisitableIterator parentIterator, Object startPoint) {
      super();
      this.startPoint = startPoint;
      if ( parentIterator instanceof AbstractVisitableIterator ) {
         iteratableSet = ((AbstractVisitableIterator) parentIterator).iteratableSet;
      }
      else {
         iteratableSet = new HashSet();
      }

      // If already in set do not add more
      childsToAdd = iteratableSet.add(startPoint);
      if ( startPoint instanceof Visitable ) {
         this.iteratableItems.add(startPoint);
      }
   }

   /**
    * Must be overloaded to register all children that could be visited
    */
   protected abstract void registerChildrenOf(Object startPoint);

   /**
    * Used to register a collection of children
    * 
    * @param child
    *           a visitable object
    */
   protected void registerChild(Object child) {
      if ( child instanceof Visitable ) {
         Visitable visitable = (Visitable) child;
         iteratableItems.add(visitable.getVisitableIterator(this));
      }
   }

   /**
    * Used to register a collection of children
    * 
    * @param children
    *           a collection of visitable objects
    */
   protected void registerChildren(Collection children) {
      for ( Object object : children ) {
         registerChild(object);
      }
   }

   public int getLevel() {
      return 0;
   }

   public Visitable nextVisitable() {
      return (Visitable) next();
   }

   /*
    * (non-Javadoc)
    * @see java.util.Iterator#hasNext()
    */
   public final boolean hasNext() {
      init();
      if ( childItemIterator == null ) {
         return iterator.hasNext();
      }
      else {
         if ( childItemIterator.hasNext() == true ) {
            return true;
         }
         else {
            return iterator.hasNext();
         }
      }
   }

   /**
    * 
    */
   private void init() {
      if ( childsToAdd ) {
         registerChildrenOf(startPoint);
         childsToAdd = false;
      }

      if ( iterator == null ) {
         iterator = iteratableItems.iterator();
      }
   }

   /*
    * (non-Javadoc)
    * @see java.util.Iterator#next()
    */
   public final Object next() throws NoSuchElementException {
      Object next;

      init();
      if ( childItemIterator == null ) {
         next = iterator.next();
         if ( iterator.hasNext() ) {
            childItemIterator = (AbstractVisitableIterator) iterator.next();
         }
      }
      else {
         if ( childItemIterator.hasNext() == true ) {
            next = childItemIterator.next();
         }
         else {
            childItemIterator = (AbstractVisitableIterator) iterator.next();
            next = childItemIterator.next();
         }
      }

      return next;
   }

   /**
    * Operation not supported in this iterator
    * 
    * @see java.util.Iterator#remove()
    */
   public final void remove() {
      throw new UnsupportedOperationException();
   }

}
