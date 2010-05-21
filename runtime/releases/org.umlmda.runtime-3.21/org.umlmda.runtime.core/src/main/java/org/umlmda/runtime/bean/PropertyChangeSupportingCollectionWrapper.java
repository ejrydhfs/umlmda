package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;

/**
 * Collection supporting {@link PropertyChangeEvent} on any change on the collection.
 * 
 * @author Dieter Moroff
 * @param <T>
 */
public abstract class PropertyChangeSupportingCollectionWrapper<T> implements Collection<T>
{
   protected final Logger                      logger = Logger.getLogger(PropertyChangeSupportingCollectionWrapper.class);
   private final Collection<T>                 wrappedCollection;
   protected final PropertyChangeSupportHelper owner;
   protected final String                      collectionPropertyName;

   protected PropertyChangeSupportingCollectionWrapper(PropertyChangeSupportHelper owner, String collectionPropertyName,
         Collection<T> wrappedCollection) {
      this.owner = owner;
      this.collectionPropertyName = collectionPropertyName;
      this.wrappedCollection = wrappedCollection;
   }

   abstract Collection<T> createClone();

   void notifyChange(Collection<T> oldValue) {
      if ( owner.hasListeners(collectionPropertyName) ) {
         logger.debug("notifyChange of " + collectionPropertyName);
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      else {
         logger.debug("no notifyChange of " + collectionPropertyName + " bacuase no listeners available");
      }
   }

   public boolean add(T o) {
      Collection<T> oldValue = keepOldValue();
      boolean added = wrappedCollection.add(o);

      if ( added && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      return added;
   }

   public boolean addAll(Collection<? extends T> c) {
      Collection<T> oldValue = keepOldValue();
      boolean added = wrappedCollection.addAll(c);

      if ( added && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      return added;
   }

   public void clear() {
      if ( wrappedCollection.size() > 0 ) {
         Collection<T> oldValue = keepOldValue();

         wrappedCollection.clear();
         if ( oldValue != null ) {
            owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
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
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      return removed;
   }

   public boolean removeAll(Collection<?> c) {
      Collection<T> oldValue = keepOldValue();
      boolean removed = wrappedCollection.removeAll(c);

      if ( removed && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
      }
      return removed;
   }

   public boolean retainAll(Collection<?> c) {
      Collection<T> oldValue = keepOldValue();
      boolean retained = wrappedCollection.retainAll(c);

      if ( retained && oldValue != null ) {
         owner.firePropertyChange(collectionPropertyName, oldValue, createClone());
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

      if ( owner.hasListeners(collectionPropertyName) ) {
         oldValue = createClone();
      }
      return oldValue;
   }

}
