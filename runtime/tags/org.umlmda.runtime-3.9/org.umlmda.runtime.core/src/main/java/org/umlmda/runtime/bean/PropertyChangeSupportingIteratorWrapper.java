package org.umlmda.runtime.bean;

import java.util.Collection;
import java.util.Iterator;

public class PropertyChangeSupportingIteratorWrapper<T> implements Iterator<T> {

   private final PropertyChangeSupportingCollectionWrapper<T> owner;
   private final Iterator<T> wrappedIterator;

   PropertyChangeSupportingIteratorWrapper(PropertyChangeSupportingCollectionWrapper<T> owner, Iterator<T> wrappedIterator) {
      this.owner = owner;
      this.wrappedIterator = wrappedIterator;
   }

   public boolean hasNext() {
      return wrappedIterator.hasNext();
   }

   public T next() {
      return wrappedIterator.next();
   }

   @SuppressWarnings("unchecked")
   public void remove() {
      Collection<T> oldValue = owner.createClone();
      wrappedIterator.remove();
      if ( oldValue != null ) {
         owner.notifyChange(oldValue);
      }
   }

}
