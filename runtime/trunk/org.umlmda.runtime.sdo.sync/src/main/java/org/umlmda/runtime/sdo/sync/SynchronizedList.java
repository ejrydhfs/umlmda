package org.umlmda.runtime.sdo.sync;

import java.util.List;


public interface SynchronizedList<T> extends SynchronizedCollection<T>, List<T> {

   void add(int index, Object listElement);

}
