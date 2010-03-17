package org.umlmda.oaw.util.uml2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Utilites working with {@link Stereotype}.
 * 
 * @author moroff
 */
public class StereotypeUtils
{

   /**
    * Returns the applicable stereotypes for a model element.
    */
   public static List<Stereotype> getApplicableStereotypes(Element element) {
      if ( element != null ) {
         List<Stereotype> result = element.getApplicableStereotypes();
         List<Stereotype> stereotypes = new ArrayList<Stereotype>(result.size());
         for ( Iterator<Stereotype> is = result.iterator(); is.hasNext(); ) {
            Stereotype stereotype = is.next();
            stereotypes.add(stereotype);
         }
         return stereotypes;
      }
      else {
         return Collections.emptyList();
      }
   }

   /**
    * Unapplies the list of stereotypes from the given model element.
    */
   public static void unapplyStereotypes(Element element, List<String> stereotypes) {
      EList<Stereotype> appliedStereotypes = element.getAppliedStereotypes();

      try {
         for ( Stereotype stereotype : appliedStereotypes ) {
            element.unapplyStereotype(stereotype);
         }
      }
      catch (RuntimeException ex) {
         ex.printStackTrace(System.err);
      }
   }

   /**
    * Finds the stereotype instance by the given name, if its part of the profiles assigned to the element's model.
    */
   public static Stereotype findStereotype(Element element, String stereotypeName) {
      Stereotype result = null;
      for ( Profile profile : element.getModel().getAppliedProfiles() ) {
         result = profile.getOwnedStereotype(stereotypeName);
         if ( result != null ) {
            break;
         }
      }
      return result;
   }

   /**
    * Get the given stereotype property value at the given element. Uses the given default value if the property is unset.
    */
   public static Object getStereotypeProperty(Element element, String stereotypeName, String propertyName, Object defaultValue) {
      Object result = getStereotypeProperty(element, stereotypeName, propertyName);
      if ( result == null ) {
         result = defaultValue;
      }
      return result;
   }

   /**
    * Get the given stereotype property value at the given element.
    */
   public static Object getStereotypeProperty(Element element, String stereotypeName, String propertyName) {
      Stereotype stereotype = findStereotype(element, stereotypeName);
      Object result = null;
      if ( stereotype != null && element.isStereotypeApplied(stereotype) ) {
         result = element.getValue(stereotype, propertyName);
      }
      return result;
   }

   /**
    * Set the given stereotype property value at the given element.
    */
   public static void setStereotypeProperty(Element element, String stereotypeName, String propertyName, Object value) {
      Stereotype stereotype = findStereotype(element, stereotypeName);
      if ( stereotype != null ) {
         element.setValue(stereotype, propertyName, value);
      }
   }

}
