/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 */
package org.umlmda.runtime.util;

import java.util.Collection;
import java.util.IdentityHashMap;

public class CopyClusterUtil
{

   public static Object copyComposite(CopyCluster original/* rootObject */) throws CloneNotSupportedException {
      IdentityHashMap<CopyCluster, CopyCluster> map/* clusterObjects */= new IdentityHashMap<CopyCluster, CopyCluster>(20);
      original.collectCompositeObjects(map);
      Object copy = original.copyCluster(map);
      return copy;
   }

   public static boolean isCloned(Object source, IdentityHashMap clusteredObjectsToMap) {
      return clusteredObjectsToMap.get(source) != null;
   }

   public static void setClone(Object source, Object clone, IdentityHashMap clusteredObjectsToMap) {
      clusteredObjectsToMap.put(source, clone);
   }

   public static Object getClone(Object source, IdentityHashMap clusteredObjectsToMap) throws CloneNotSupportedException {
      Object clone = clusteredObjectsToMap.get(source);
      if ( clone != null ) {
         return clone;
      }
      // Soll es �berhaupt gecloned werden?
      if ( !clusteredObjectsToMap.containsKey(source) ) {
         return source; // Nein, dann die Source zur�ckgeben
      }
      return ((CopyCluster) source).copyCluster(clusteredObjectsToMap);
   }

   public static Object getClones(Collection sources, Collection emptyTargets, IdentityHashMap clusteredObjectsToMap)
         throws CloneNotSupportedException {
      for ( Object object : sources ) {
         Object clone = getClone(object, clusteredObjectsToMap);
         emptyTargets.add(clone);
      }
      return emptyTargets;
   }
}
