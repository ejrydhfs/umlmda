/**
 * 
 */
package org.umlmda.runtime.bean;

import java.util.Collection;
import java.util.ListIterator;

/**
 * @author MOROFF
 *
 */
public class PropertyChangeSupportingListIteratorWrapper<T> extends PropertyChangeSupportingIteratorWrapper<T> implements ListIterator<T> {

   private final ListIterator<T> wrappedListIterator;
   private final PropertyChangeSupportingCollectionWrapper<T> owner;

   /**
    * @param owner
    * @param wrappedIterator
    */
   public PropertyChangeSupportingListIteratorWrapper(PropertyChangeSupportingCollectionWrapper<T> owner, ListIterator<T> wrappedListIterator) {
      super(owner, wrappedListIterator);
      this.owner = owner;
      this.wrappedListIterator = wrappedListIterator;
   }

   /* (non-Javadoc)
    * @see java.util.ListIterator#add(java.lang.Object)
    */
   public void add(T o) {
      Collection<T> oldValue = owner.createClone();
      wrappedListIterator.add(o);
      if ( oldValue != null ) {
         owner.notifyChange(oldValue);
      }
   }

   /* (non-Javadoc)
    * @see java.util.ListIterator#set(java.lang.Object)
    */
   public void set(T o) {
      Collection<T> oldValue = owner.createClone();
      wrappedListIterator.set(o);
      if ( oldValue != null ) {
         owner.notifyChange(oldValue);
      }
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

}
