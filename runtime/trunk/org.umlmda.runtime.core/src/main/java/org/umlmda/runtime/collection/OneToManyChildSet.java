/*
 * Copyright (C) All rights reserved 2005 - 2009, 
 * UMLMDA, http://www.umlmda.org
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
 * Created on 05.07.2009 (Dieter Moroff)
 */
package org.umlmda.runtime.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A wrapper around a {@link Set} to support bidirectionality in a one to many aggregation or composition. 
 * If an element added or removed from the set the parent in the element is modified too.
 * 
 * @author Dieter Moroff
 *
 * @param <TParent>
 * @param <TChild>
 */
public abstract class OneToManyChildSet<TParent, TChild> implements Set<TChild>, Serializable {

   private static final long serialVersionUID = 1L;
   private final Set<TChild> wrappedSet;
   private final TParent parent;

   public OneToManyChildSet(TParent parent) {
      this(parent, new LinkedHashSet<TChild>());
   }
   
   public OneToManyChildSet(TParent parent, Set<TChild> wrappedSet) {
      this.parent = parent;
      this.wrappedSet = wrappedSet;
   }

   /**
    * Method to be overwritten to set the parent to the child object.
    * @param child
    * @param parent
    */
   protected abstract void setParent(TChild child, TParent parent);
   
   /**
    * Method to get the parent of a child element.
    * @param child
    * @return
    */
   protected abstract TParent getParent(TChild child);
   
   public boolean add(TChild child) {
      boolean added = wrappedSet.add(child);
      
      if ( added ) {
         if ( parent != getParent(child)) {
            setParent(child, parent);
         }
      }
      return added;
   }

   public boolean addAll(Collection<? extends TChild> children) {
      boolean added = false;
      for (TChild child : children) {
         if ( add(child)) {
            added = true;
         }
      }
      return added;
   }

   public void clear() {
      for (TChild child : wrappedSet) {
         if ( parent == getParent(child)) {
            setParent(child, parent);
         }
      }
      wrappedSet.clear();
   }

   public boolean contains(Object o) {
      return wrappedSet.contains(o);
   }

   public boolean containsAll(Collection<?> c) {
      return wrappedSet.containsAll(c);
   }

   public boolean equals(Object o) {
      return wrappedSet.equals(o);
   }

   public int hashCode() {
      return wrappedSet.hashCode();
   }

   public boolean isEmpty() {
      return wrappedSet.isEmpty();
   }

   public Iterator<TChild> iterator() {
      return new OneToManyChildIterator(this, wrappedSet.iterator());
   }

   @SuppressWarnings("unchecked")
   public boolean remove(Object child) {
      if ( parent == getParent((TChild)child)) {
         setParent((TChild)child, null);
      }
      return wrappedSet.remove(child);
   }

   public boolean removeAll(Collection<?> children) {
      boolean removed = false;
      for (Object child : children) {
         if ( remove(child)) {
            removed = true;
         }
      }
      return removed;
   }

   public boolean retainAll(Collection<?> c) {
      boolean changed = false;
      
      for (Iterator<TChild> iterator = wrappedSet.iterator(); iterator.hasNext();) {
         TChild child = iterator.next();
         
         if ( c.contains(child) == false ) {
            iterator.remove();
            if ( parent == getParent((TChild)child)) {
               setParent(child, null);
            }
            changed = true;
         }
      }
      return changed;
   }

   public int size() {
      return wrappedSet.size();
   }

   public Object[] toArray() {
      return wrappedSet.toArray();
   }

   public <T> T[] toArray(T[] a) {
      return wrappedSet.toArray(a);
   }
   
}
