package org.umlmda.oaw.generator.util;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.umlmda.model.uml.ModelElement;

public class ElementUtils {

   private static Logger logger = Logger.getLogger(ElementUtils.class);

   @SuppressWarnings( { "deprecation", "unchecked" })
   public static void logStereotypeProperties(ModelElement element) {
      if (logger.isDebugEnabled()) {
         logger.debug("Stereotype properties of " + element.getQualifiedName() + ":");

         if (element.getTaggedValues().size() > 0) {

            for (Iterator iterator = element.getTaggedValues().keySet().iterator(); iterator.hasNext();) {
               String key = (String) iterator.next();

               logger.debug(key + "=" + element.getStereotypeProperty(key));
            }
         }
      }
   }
}
