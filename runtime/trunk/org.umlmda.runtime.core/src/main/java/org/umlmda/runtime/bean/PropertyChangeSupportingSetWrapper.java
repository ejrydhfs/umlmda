/**
 * 
 */
package org.umlmda.runtime.bean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Set supporting {@link PropertyChangeEvent} on any change on the set.
 * 
 * @author Dieter Moroff (24.4.2008)
 * @param <T>
 */
public class PropertyChangeSupportingSetWrapper<T> extends PropertyChangeSupportingCollectionWrapper<T> implements Set<T> {

   private final Set<T> wrappedSet;

   /**
    * @param owner
    * @param collectionPropertyName
    * @param wrappedSet
    */
   public PropertyChangeSupportingSetWrapper(PropertyChangeSupport owner, String collectionPropertyName, Set<T> wrappedSet) {
      super(owner, collectionPropertyName, wrappedSet);
      this.wrappedSet = wrappedSet;
   }

   /* (non-Javadoc)
    * @see org.umlmda.runtime.bean.PropertyChangeSupportingCollection#createClone()
    */
   @Override
   Collection<T> createClone() {
      return new HashSet<T>(wrappedSet);
   }

}
