package org.umlmda.oaw.generator.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.model.uml.ModelElement;

/**
 * Utility and convenience methods for {@link ModelElement} and other classes of the scope <i>org.umlmda.model.uml</i>.
 */
public class ModelElementUtils
{

   private static Logger logger = Logger.getLogger(ModelElementUtils.class);

   @SuppressWarnings( { "deprecation", "unchecked" })
   public static void logStereotypeProperties(ModelElement element) {
      if ( logger.isDebugEnabled() ) {
         logger.debug("Stereotype properties of " + element.getQualifiedName() + ":");

         if ( element.getTaggedValues().size() > 0 ) {

            for ( Iterator iterator = element.getTaggedValues().keySet().iterator(); iterator.hasNext(); ) {
               String key = (String) iterator.next();

               logger.debug(key + "=" + element.getStereotypeProperty(key));
            }
         }
      }
   }

   /**
    * Filters the given element list by name, returning only those with unique names.
    * 
    * @param clazz
    *           Used only to please the XTend parser
    * @param elements
    *           List of elements to filter by name uniqueness.
    * @return Filtered list of elements, now with unique names.
    */
   public static List<ModelElement> filterDuplicateElementsByName(List<ModelElement> elements) {
      List<ModelElement> collectedElements = new ArrayList<ModelElement>();
      List<String> collectedElementNames = new ArrayList<String>();
      for ( ModelElement element : elements ) {
         if ( !collectedElementNames.contains(element.getName()) ) {
            collectedElementNames.add(element.getName());
            collectedElements.add(element);
         }
         else if ( logger.isTraceEnabled() ) {
            logger.trace("Filtering duplicate element " + element.getName());
         }
      }
      return collectedElements;
   }

}
