/*
 * Copyright: (C) 2008 COR AG Insurance Technologies
 * Name:      $Id: ReferenceUtils.java,v $Version 22.07.2010 15:13:07 {user} Exp $
 */
package org.umlmda.runtime.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ReferenceUtils
{
   public static ReferenceUtils               INSTANCE;
   private final Map<Object, Object>          registry        = new HashMap<Object, Object>();
   private List<ResolveReference>             resolvers       = new ArrayList<ResolveReference>();
   private Map<String, Map<Class<?>, Object>> resolveRegistry = new HashMap<String, Map<Class<?>, Object>>();
   
   public ReferenceUtils() {
      INSTANCE = this;
   }
   
   /**
    * For resolving an object reference, to be implemented for concrete associations.
    */
   public abstract static class ResolveReference {
      protected abstract void resolve();

      Object lookup(Object objectRef) {
         if (objectRef != null) {
            return INSTANCE.getRegistry().get(objectRef);
         }
         else {
            return null;
         }
      }
   }
   
   
   /**
    * @return the registry
    */
   public Map<Object, Object> getRegistry() {
      return registry;
   }

   public <T> T getObject(Class<T> clazz, String id) {
      Map<Class<?>, Object> idMap = resolveRegistry.get(id);
      Object reference = null;
      if (idMap != null) {
         for (Map.Entry<Class<?>, Object> classMapEntry : idMap.entrySet()) {
            if (clazz.isAssignableFrom(classMapEntry.getValue().getClass())) {
               if (reference == null) {
                  reference = classMapEntry.getValue();
               }
               else {
                  throw new IllegalStateException("Found more than one instance to resolve id " + id + " for class "
                        + clazz);
               }
            }
         }
      }
      if (reference == null && id != null)
         throw new NoSuchElementException("No instance to resolve id " + id + " for class " + clazz + " found!");
      return (T) reference;
   }

   public void registerObject(Object object, String id) {
      Map<Class<?>, Object> idMap = resolveRegistry.get(id);
      if (idMap == null) {
         idMap = new IdentityHashMap<Class<?>, Object>();
         idMap.put(object.getClass(), object);
         resolveRegistry.put(id, idMap);
      }
      else
         idMap.put(object.getClass(), object);
   }

   /**
    * Register a reference resolver for later resolving.
    */
   public void register(ResolveReference resolveReference) {
      resolvers.add(resolveReference);
   }

   /**
    * Resolve all registered references.
    */
   public void resolveReferences() {
      List<ResolveReference> resolver = new ArrayList<ResolveReference>(resolvers);
      for (ResolveReference resolveReference : resolver) {
         resolveReference.resolve();
      }
   }

   /**
    * Clear all collected reference resolvers.
    */
   public void resetReferences() {
      resolveRegistry.clear();
      resolvers.clear();
      registry.clear();
   }
}
