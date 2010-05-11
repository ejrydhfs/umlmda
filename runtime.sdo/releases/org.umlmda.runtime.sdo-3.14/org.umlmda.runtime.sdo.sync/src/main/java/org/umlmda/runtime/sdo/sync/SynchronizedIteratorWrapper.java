package org.umlmda.runtime.sdo.sync;

import java.util.Iterator;

public class SynchronizedIteratorWrapper<T> implements Iterator<T>
{
   private final Iterator<T>               wrappedIterator;
   private final SynchronizedCollection<T> collection;
   private T                               lastObject;

   SynchronizedIteratorWrapper(SynchronizedCollection<T> collection, Iterator<T> wrappedIterator) {
      this.collection = collection;
      this.wrappedIterator = wrappedIterator;
   }

   public boolean hasNext() {
      return wrappedIterator.hasNext();
   }

   public T next() {
      lastObject = wrappedIterator.next();

      return lastObject;
   }

   public void remove() {
      wrappedIterator.remove();

      collection.getRecorder().recordRemove(collection, lastObject);
   }

}
