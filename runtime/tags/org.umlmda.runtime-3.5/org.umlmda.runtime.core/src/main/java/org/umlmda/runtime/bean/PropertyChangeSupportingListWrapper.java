package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * List supporting {@link PropertyChangeEvent} on any change on the list.
 * 
 * @author Dieter Moroff (24.4.2008)
 * @param <T>
 */
public class PropertyChangeSupportingListWrapper<T> extends PropertyChangeSupportingCollectionWrapper<T> implements List<T> {

   private final List<T> wrappedList;

   public PropertyChangeSupportingListWrapper(PropertyChangeSupportHelper owner, String collectionPropertyName, List<T> wrappedList) {
      super(owner, collectionPropertyName, wrappedList);
      this.wrappedList = wrappedList;
   }

   @Override
   Collection<T> createClone() {
      return new ArrayList<T>(wrappedList);
   }

   public void add(int index, T element) {
      Collection<T> oldValue = keepOldValue();

      wrappedList.add(index, element);

      if ( oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
   }

   public boolean addAll(int index, Collection<? extends T> c) {
      Collection<T> oldValue = keepOldValue();
      boolean added = wrappedList.addAll(index, c);
      
      if ( added && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      return added;
   }

   public T get(int index) {
      return wrappedList.get(index);
   }

   public int indexOf(Object o) {
      return wrappedList.indexOf(o);
   }

   public int lastIndexOf(Object o) {
      return wrappedList.lastIndexOf(o);
   }

   public ListIterator<T> listIterator() {
      return new PropertyChangeSupportingListIteratorWrapper<T>(this, wrappedList.listIterator());
   }

   public ListIterator<T> listIterator(int index) {
      return new PropertyChangeSupportingListIteratorWrapper<T>(this, wrappedList.listIterator(index));
   }

   public T remove(int index) {
      Collection<T> oldValue = keepOldValue();
      T removed = wrappedList.remove(index);
      
      if ( removed != null && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      return removed;
   }

   public T set(int index, T element) {
      Collection<T> oldValue = keepOldValue();
      T removed = wrappedList.set(index, element);
      
      if ( removed != null && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      return removed;
   }

   public List<T> subList(int fromIndex, int toIndex) {
      return wrappedList.subList(fromIndex, toIndex);
   }

}
