package org.umlmda.runtime.sdo.sync;

import java.util.Iterator;
import java.util.List;

public interface SynchronizedList<T> extends SynchronizedCollection<T>, List<T>
{

   void add(int index, T listElement);

   Iterator<T> iterator();

}
