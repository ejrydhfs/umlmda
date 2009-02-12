package org.umlmda.oaw.util.uml2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Element;

/**
 * Utilites working with Stereotypes
 * 
 * @author moroff
 * 
 */
public class StereotypeUtils {

   static public List<Stereotype> getApplicableStereotypes(Element element) {
      if (element != null) {
         List<Stereotype> result = element.getApplicableStereotypes();
         List<Stereotype> stereotypes = new ArrayList<Stereotype>(result.size());
         for (Iterator<Stereotype> is = result.iterator(); is.hasNext();) {
            Stereotype stereotype = is.next();

            stereotypes.add(stereotype);
         }
         return stereotypes;
      } else {
         return Collections.emptyList();
      }
   }

   static public void unapplyStereotypes(Element element, List<String> stereotypes) {
      EList<Stereotype> appliedStereotypes = element.getAppliedStereotypes();

      try {
         for (Stereotype stereotype : appliedStereotypes) {
            element.unapplyStereotype(stereotype);
         }
      } catch (RuntimeException ex) {
         ex.printStackTrace(System.err);
      }
   }
}
