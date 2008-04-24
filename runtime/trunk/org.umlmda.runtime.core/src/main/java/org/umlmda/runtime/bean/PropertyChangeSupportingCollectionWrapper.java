package org.umlmda.runtime.bean;

import java.util.Collection;
import java.util.Iterator;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

/**
 * Collection supporting {@link PropertyChangeEvent} on any change on the collection.
 * 
 * @author Dieter Moroff
 * @param <T>
 */
public abstract class PropertyChangeSupportingCollectionWrapper<T> implements Collection<T> {

   private final Collection<T> wrappedCollection;
   protected final PropertyChangeSupport owner;
   protected final String collectionPropertyName;

   PropertyChangeSupportingCollectionWrapper(PropertyChangeSupport owner, String collectionPropertyName, Collection<T> wrappedCollection) {
      this.owner = owner;
      this.collectionPropertyName = collectionPropertyName;
      this.wrappedCollection = wrappedCollection;
   }

   abstract Collection<T> createClone();
   
   void notifyChange(Collection<T> oldValue) {
      if ( owner.hasListeners(collectionPropertyName) ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, this);
      }
   }
   
   public boolean add(T o) {
      Collection<T> oldValue = keepOldValue();
      boolean added = wrappedCollection.add(o);

      if ( added && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, wrappedCollection);
      }
      return added;
   }

   public boolean addAll(Collection<? extends T> c) {
      Collection<T> oldValue = keepOldValue();
      boolean added = wrappedCollection.addAll(c);
      
      if ( added && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, wrappedCollection);
      }
      return added;
   }

   public void clear() {
      if ( wrappedCollection.size() > 0 ) {
         Collection<T> oldValue = keepOldValue();
         
         wrappedCollection.clear();
         if ( oldValue != null ) {
            owner.firePropertyChange(collectionPropertyName, oldValue, wrappedCollection);
         }
      }
   }

   public boolean contains(Object o) {
      return wrappedCollection.contains(o);
   }

   public boolean containsAll(Collection<?> c) {
      return wrappedCollection.containsAll(c);
   }

   public boolean equals(Object o) {
      return wrappedCollection.equals(o);
   }

   public int hashCode() {
      return wrappedCollection.hashCode();
   }

   public boolean isEmpty() {
      return wrappedCollection.isEmpty();
   }

   public Iterator<T> iterator() {
      return new PropertyChangeSupportingIteratorWrapper<T>(this, wrappedCollection.iterator());
   }

   public boolean remove(Object o) {
      Collection<T> oldValue = keepOldValue();
      boolean removed = wrappedCollection.remove(o);
      
      if ( removed && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, wrappedCollection);
      }
      return removed;
   }

   public boolean removeAll(Collection<?> c) {
      Collection<T> oldValue = keepOldValue();
      boolean removed = wrappedCollection.removeAll(c);
      
      if ( removed && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, wrappedCollection);
      }
      return removed;
   }

   public boolean retainAll(Collection<?> c) {
      Collection<T> oldValue = keepOldValue();
      boolean retained = wrappedCollection.retainAll(c);
      
      if ( retained && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, wrappedCollection);
      }
      return retained;
   }

   public int size() {
      return wrappedCollection.size();
   }

   public Object[] toArray() {
      return wrappedCollection.toArray();
   }

   public <TExt> TExt[] toArray(TExt[] a) {
      return wrappedCollection.toArray(a);
   }
   
   protected Collection<T> keepOldValue() {
      Collection<T> oldValue = null;
      
      if ( owner.hasListeners(collectionPropertyName)) {
         oldValue = createClone();
      }
      return oldValue;
   }

   
}
