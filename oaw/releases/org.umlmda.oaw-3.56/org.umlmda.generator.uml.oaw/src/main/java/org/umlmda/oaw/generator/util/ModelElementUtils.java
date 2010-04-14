package org.umlmda.oaw.generator.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelClass;
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
    * Filters the given attribute list by name, returning only those attributes with unique names.
    * 
    * @param clazz
    *           Used only to please the XTend parser
    * @param attributes
    *           List of attributes to filter by name uniqueness.
    * @return Filtered list of attributes, now with unique names.
    */
   public static List<ModelAttribute> filterDuplicateAttributesByName(ModelClass clazz, List<ModelAttribute> attributes) {
      List<ModelAttribute> collectedAttributes = new ArrayList<ModelAttribute>();
      List<String> collectedAttributeNames = new ArrayList<String>();
      for ( ModelAttribute attribute : attributes ) {
         if ( !collectedAttributeNames.contains(attribute.getName()) ) {
            collectedAttributeNames.add(attribute.getName());
            collectedAttributes.add(attribute);
         }
         else if ( logger.isTraceEnabled() ) {
            logger.trace("Filtering duplicate attribute " + attribute.getName() + " for class " + clazz.getName());
         }
      }
      return collectedAttributes;
   }

}
