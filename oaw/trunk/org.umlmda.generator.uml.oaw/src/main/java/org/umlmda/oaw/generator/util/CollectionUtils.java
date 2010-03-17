package org.umlmda.oaw.generator.util;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Utility class for collections and sets, independent from model specifics.
 */
public class CollectionUtils
{

   @SuppressWarnings("unchecked")
   public static Set<?> toSet(Collection<?> collection) {
      Set resultSet = new LinkedHashSet();

      for ( Object object : collection ) {
         resultSet.add(object);
      }

      return resultSet;
   }

}
