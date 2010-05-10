package org.umlmda.runtime.sdo.sync;

import java.util.ListIterator;

import org.umlmda.runtime.exception.FeatureNotImplemementedException;

public class SynchronizedListIteratorWrapper<T> extends SynchronizedIteratorWrapper<T> implements ListIterator<T>
{

   private final ListIterator<T> wrappedListIterator;

   public SynchronizedListIteratorWrapper(SynchronizedCollection<T> collection, ListIterator<T> wrappedIterator) {
      super(collection, wrappedIterator);
      wrappedListIterator = wrappedIterator;
   }

   @Override
   public void remove() {
      // TODO Auto-generated method stub
      throw new FeatureNotImplemementedException();
   }

   public void add(Object o) {
      // TODO Auto-generated method stub
      throw new FeatureNotImplemementedException();
   }

   public boolean hasPrevious() {
      return wrappedListIterator.hasPrevious();
   }

   public int nextIndex() {
      return wrappedListIterator.nextIndex();
   }

   public T previous() {
      return wrappedListIterator.previous();
   }

   public int previousIndex() {
      return wrappedListIterator.previousIndex();
   }

   public void set(Object o) {
      // TODO Auto-generated method stub
      throw new FeatureNotImplemementedException();
   }

}
