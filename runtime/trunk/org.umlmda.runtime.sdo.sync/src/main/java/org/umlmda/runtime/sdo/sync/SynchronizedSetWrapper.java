package org.umlmda.runtime.sdo.sync;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.umlmda.runtime.exception.FeatureNotImplemementedException;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

public class SynchronizedSetWrapper<T> extends AbstractSynchronizedObject implements SynchronizedSet<T> {
   private final Set<T> wrappedSet;
   private final transient Recorder recorder;
   
   public SynchronizedSetWrapper(Recorder recorder, Set<T> wrappedList) {
      super(recorder, false);
      this.recorder = recorder;
      this.wrappedSet = wrappedList;
   }
   
   public boolean add(T o) {
      if (o instanceof SynchronizedObject) {
         SynchronizedObject recordedObject = (SynchronizedObject) o;
         boolean listResult = wrappedSet.add(o);

         if ( listResult == true ) {
            recorder.recordAdd(this, recordedObject);
         }
         return listResult;
      }
      else {
         throw createIllegalArgumentException(o);
      }
   }

   public boolean addAll(Collection<? extends T> collection) {
      boolean added = true;
      for (T element : collection) {
         if ( add(element) == false )
            added = false;
      }
      return added;
   }

   public void clear() {
      recorder.recordClear(this);
   }

   public boolean contains(Object o) {
      return wrappedSet.contains(o);
   }

   public boolean containsAll(Collection<?> c) {
      return wrappedSet.containsAll(c);
   }

   public boolean isEmpty() {
      return wrappedSet.isEmpty();
   }

   public Iterator<T> iterator() {
      return new SynchronizedIteratorWrapper<T>(this, wrappedSet.iterator());
   }

   public boolean remove(Object o) {
      if (o instanceof SynchronizedObject) {
         boolean listResult = wrappedSet.remove(o);

         if ( listResult == true ) {
            recorder.recordRemove(this, o);
         }
         return listResult;
      }
      else {
         throw createIllegalArgumentException(o);
      }
   }

   public boolean removeAll(Collection<?> collection) {
      boolean removedAll = true;
      for (Object element : collection) {
         if ( remove(element) == false )
            removedAll = false;
      }
      return removedAll;
   }

   public boolean retainAll(Collection<?> c) {
      throw new FeatureNotImplemementedException();
   }

   public int size() {
      return wrappedSet.size();
   }

   public Object[] toArray() {
      return wrappedSet.toArray();
   }

   @SuppressWarnings("hiding")
   public <T> T[] toArray(T[] a) {
      return wrappedSet.toArray(a);
   }

   public boolean addAll(int index, Collection<? extends T> c) {
      // TODO Auto-generated method stub
      return false;
   }

   private IllegalArgumentException createIllegalArgumentException(Object o) {
      return new IllegalArgumentException(o.getClass().getName()+" not instanceof "+SynchronizedObject.class.getName());
   }
   
}
