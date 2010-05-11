/*
 * Copyright: (C) 2009 COR AG Financial Technologies
 */
package org.umlmda.oaw.util.uml2;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;

public class DependencyUtils
{

   public static Dependency getDependency(NamedElement element, String name) {
      return element.getClientDependency(name);
   }

   public static NamedElement getDependencyTarget(NamedElement element, String name) {
      if ( element.getClientDependency(name) != null && element.getClientDependency(name).getSuppliers().size() > 0 ) {
         return element.getClientDependency(name).getSuppliers().get(0);
      }
      else {
         return null;
      }
   }

}
