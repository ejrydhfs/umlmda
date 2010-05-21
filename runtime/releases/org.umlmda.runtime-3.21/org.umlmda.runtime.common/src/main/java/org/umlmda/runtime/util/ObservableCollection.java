/*
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
 * Created by Dieter Moroff (13.04.2006)
 */
package org.umlmda.runtime.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 * Implementation of a collection which can be observed for changes.
 */
public class ObservableCollection extends Observable implements Collection, Observer
{
   private final Collection collection;

   /**
    * 
    */
   public ObservableCollection(Collection collection) {
      super();
      this.collection = collection;
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#size()
    */
   public int size() {
      return collection.size();
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#clear()
    */
   public void clear() {
      collection.clear();
      setChanged();
      notifyObservers();
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#isEmpty()
    */
   public boolean isEmpty() {
      return collection.isEmpty();
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#toArray()
    */
   public Object[] toArray() {
      return collection.toArray();
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#add(java.lang.Object)
    */
   public boolean add(Object o) {
      boolean added = collection.add(o);
      setChanged();
      notifyObservers();
      return added;
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#contains(java.lang.Object)
    */
   public boolean contains(Object o) {
      return collection.contains(o);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#remove(java.lang.Object)
    */
   public boolean remove(Object o) {
      boolean removed = collection.remove(o);
      setChanged();
      notifyObservers();
      return removed;
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#addAll(java.util.Collection)
    */
   public boolean addAll(Collection c) {
      boolean added = collection.addAll(c);
      setChanged();
      notifyObservers();
      return false;
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#containsAll(java.util.Collection)
    */
   public boolean containsAll(Collection c) {
      return collection.containsAll(c);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#removeAll(java.util.Collection)
    */
   public boolean removeAll(Collection c) {
      boolean removed = collection.removeAll(c);
      setChanged();
      notifyObservers();
      return removed;
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#retainAll(java.util.Collection)
    */
   public boolean retainAll(Collection c) {
      boolean retained = collection.retainAll(c);
      setChanged();
      notifyObservers();
      return retained;
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#iterator()
    */
   public Iterator iterator() {
      return new ObservableIterator(this, collection.iterator());
   }

   /*
    * (non-Javadoc)
    * @see java.util.Collection#toArray(java.lang.Object[])
    */
   public Object[] toArray(Object[] a) {
      return collection.toArray(a);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable o, Object arg) {
      if ( arg == this ) {
         setChanged();
         notifyObservers();
      }
   }

}
