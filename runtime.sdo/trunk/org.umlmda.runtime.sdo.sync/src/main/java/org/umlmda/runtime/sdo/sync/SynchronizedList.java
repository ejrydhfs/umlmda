package org.umlmda.runtime.sdo.sync;

import java.util.Iterator;
import java.util.List;

import org.umlmda.runtime.exception.FeatureNotImplemementedException;


public interface SynchronizedList<T> extends SynchronizedCollection<T>, List<T> {

   void add(int index, T listElement);

   public Iterator<T> iterator();

}
