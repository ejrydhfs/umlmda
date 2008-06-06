/*
 *   $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/util/ObservableList.java,v 1.1 2008/04/09 12:05:16 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/util/ObservableList.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2008/04/09 12:05:16 $
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
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of a list which can be observed for changes.
 * @author Dieter Moroff (13.04.2006), last change $Date: 2008/04/09 12:05:16 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public class ObservableList extends ObservableCollection implements List {
   private final List list;
   
   /**
    * @param collection
    */
   public ObservableList(List list) {
      super(list);
      this.list = list;
   }

   /* (non-Javadoc)
    * @see java.util.List#get(int)
    */
   public Object get(int index) {
      return list.get(index);
   }

   /* (non-Javadoc)
    * @see java.util.List#remove(int)
    */
   public Object remove(int index) {
      Object o = list.remove(index);
      setChanged();
      notifyObservers();
      return o;
   }

   /* (non-Javadoc)
    * @see java.util.List#add(int, java.lang.Object)
    */
   public void add(int index, Object element) {
      list.add(index, element);
      setChanged();
      notifyObservers();
   }

   /* (non-Javadoc)
    * @see java.util.List#indexOf(java.lang.Object)
    */
   public int indexOf(Object o) {
      return list.indexOf(o);
   }

   /* (non-Javadoc)
    * @see java.util.List#lastIndexOf(java.lang.Object)
    */
   public int lastIndexOf(Object o) {
      return list.indexOf(o);
   }

   /* (non-Javadoc)
    * @see java.util.List#addAll(int, java.util.Collection)
    */
   public boolean addAll(int index, Collection c) {
      boolean added = list.addAll(index, c);
      setChanged();
      notifyObservers();
      return added;
   }

   /* (non-Javadoc)
    * @see java.util.List#subList(int, int)
    */
   public List subList(int fromIndex, int toIndex) {
      return list.subList(fromIndex, toIndex);
   }

   /* (non-Javadoc)
    * @see java.util.List#listIterator()
    */
   public ListIterator listIterator() {
      return new ObservableListIterator(this, list.listIterator());
   }

   /* (non-Javadoc)
    * @see java.util.List#listIterator(int)
    */
   public ListIterator listIterator(int index) {
      return new ObservableListIterator(this, list.listIterator(index));
   }

   /* (non-Javadoc)
    * @see java.util.List#set(int, java.lang.Object)
    */
   public Object set(int index, Object element) {
      Object o = list.set(index, element);
      setChanged();
      notifyObservers();
      return o;
   }

}
