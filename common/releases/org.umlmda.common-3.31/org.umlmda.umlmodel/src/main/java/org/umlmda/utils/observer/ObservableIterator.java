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
package org.umlmda.utils.observer;

import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

/**
 * Implementation of an iterator which can be observed if the underlying collection is changed through this iterator.
 * 
 */
public class ObservableIterator extends Observable implements Iterator
{
   private final Iterator   iterator;
   private final Collection collection;

   /**
    * 
    */
   public ObservableIterator(ObservableCollection collection, Iterator iterator) {
      super();
      this.collection = collection;
      this.iterator = iterator;

      // Notify collection on iterator.remove
      addObserver(collection);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Iterator#remove()
    */
   public void remove() {
      iterator.remove();
      setChanged();
      notifyObservers(collection);
   }

   /*
    * (non-Javadoc)
    * @see java.util.Iterator#hasNext()
    */
   public boolean hasNext() {
      return iterator.hasNext();
   }

   /*
    * (non-Javadoc)
    * @see java.util.Iterator#next()
    */
   public Object next() {
      return iterator.next();
   }

}
