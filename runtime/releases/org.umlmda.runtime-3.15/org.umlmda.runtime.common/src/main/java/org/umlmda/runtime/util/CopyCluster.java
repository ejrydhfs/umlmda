/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: CopyCluster.java,v $Version 01.09.2008 16:00:42 {user} Exp $
 */
package org.umlmda.runtime.util;

import java.util.IdentityHashMap;

public interface CopyCluster extends Cloneable
{
   public Object copyCluster(IdentityHashMap clusterObjectsToMap) throws CloneNotSupportedException;
   
   public IdentityHashMap collectCompositeObjects(IdentityHashMap compositeMap);

}
