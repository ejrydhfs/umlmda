package org.umlmda.runtime.sdo.sync;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.umlmda.runtime.exception.FeatureNotImplemementedException;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

public class SynchronizedListWrapper<T> extends AbstractSynchronizedObject implements SynchronizedList<T> {
   private final List<T> wrappedList;
   private final transient Recorder recorder;
   
   public SynchronizedListWrapper(Recorder recorder, List<T> wrappedList) {
      super(recorder, false);
      this.recorder = recorder;
      this.wrappedList = wrappedList;
   }
   
   public void add(int index, T o) {
      if (o instanceof SynchronizedObject) {
         SynchronizedObject recordedObject = (SynchronizedObject) o;

         wrappedList.add(index, o);
         recorder.recordAdd(this, recordedObject, index);
      }
      else {
         throw createIllegalArgumentException(o);
      }
   }

   public boolean add(T o) {
      if (o instanceof SynchronizedObject) {
         SynchronizedObject recordedObject = (SynchronizedObject) o;
         boolean listResult = wrappedList.add(o);

         if ( listResult == true ) {
            recorder.recordAdd(this, recordedObject, wrappedList.size() - 1);
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
      return wrappedList.contains(o);
   }

   public boolean containsAll(Collection<?> c) {
      return wrappedList.containsAll(c);
   }

   public boolean isEmpty() {
      return wrappedList.isEmpty();
   }

   public Iterator<T> iterator() {
      // TODO Auto-generated method stub
      throw new FeatureNotImplemementedException();
   }

   public boolean remove(Object o) {
      if (o instanceof SynchronizedObject) {
         int listIndex = wrappedList.indexOf(o);
         boolean listResult = wrappedList.remove(o);

         if ( listResult == true ) {
            recorder.recordRemove(this, listIndex);
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
      return wrappedList.size();
   }

   public Object[] toArray() {
      return wrappedList.toArray();
   }

   @SuppressWarnings("hiding")
   public <T> T[] toArray(T[] a) {
      return wrappedList.toArray(a);
   }

   public boolean addAll(int index, Collection<? extends T> c) {
      // TODO Auto-generated method stub
      return false;
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
      // TODO Auto-generated method stub
      throw new FeatureNotImplemementedException();
   }

   public ListIterator<T> listIterator(int index) {
      // TODO Auto-generated method stub
      throw new FeatureNotImplemementedException();
   }

   public T remove(int index) {
      T element = wrappedList.remove(index);
      
      if ( element != null ) {
         recorder.recordRemove(this, index);
      }

      return element;
   }

   public T set(int index, T element) {
      T oldElement = wrappedList.set(index, element);
      
      recorder.recordRemove(this, index);
      recorder.recordAdd(this, element, index);

      return oldElement;
   }

   public List<T> subList(int fromIndex, int toIndex) {
      throw new FeatureNotImplemementedException();
   }

   private IllegalArgumentException createIllegalArgumentException(Object o) {
      return new IllegalArgumentException(o.getClass().getName()+" not instanceof "+SynchronizedObject.class.getName());
   }

   
}
