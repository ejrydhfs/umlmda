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

import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of a list iterator which can be observed if the underlying * collection is changed through this iterator.
 * 
 */
public class ObservableListIterator extends ObservableIterator implements ListIterator
{
   private final List         list;
   private final ListIterator listIterator;

   /**
    * @param list
    */
   public ObservableListIterator(ObservableList list, ListIterator listIterator) {
      super(list, listIterator);
      this.list = list;
      this.listIterator = listIterator;
   }

   /*
    * (non-Javadoc)
    * @see java.util.ListIterator#nextIndex()
    */
   public int nextIndex() {
      return listIterator.nextIndex();
   }

   /*
    * (non-Javadoc)
    * @see java.util.ListIterator#previousIndex()
    */
   public int previousIndex() {
      return listIterator.previousIndex();
   }

   /*
    * (non-Javadoc)
    * @see java.util.ListIterator#hasPrevious()
    */
   public boolean hasPrevious() {
      return listIterator.hasPrevious();
   }

   /*
    * (non-Javadoc)
    * @see java.util.ListIterator#previous()
    */
   public Object previous() {
      return listIterator.previous();
   }

   /*
    * (non-Javadoc)
    * @see java.util.ListIterator#add(java.lang.Object)
    */
   public void add(Object o) {
      listIterator.add(o);
      setChanged();
      notifyObservers(list);
   }

   /*
    * (non-Javadoc)
    * @see java.util.ListIterator#set(java.lang.Object)
    */
   public void set(Object o) {
      listIterator.set(o);
      setChanged();
      notifyObservers();
   }

}
