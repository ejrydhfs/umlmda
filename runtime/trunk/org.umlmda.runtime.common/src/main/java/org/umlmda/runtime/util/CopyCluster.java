/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package org.umlmda.runtime.util;

import java.util.IdentityHashMap;

public interface CopyCluster extends Cloneable
{
   Object copyCluster(IdentityHashMap clusterObjectsToMap) throws CloneNotSupportedException;

   IdentityHashMap collectCompositeObjects(IdentityHashMap compositeMap);

}
