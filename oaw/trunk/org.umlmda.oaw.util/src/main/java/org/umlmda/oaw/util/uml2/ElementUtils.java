package org.umlmda.oaw.util.uml2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Utility and convenience methods for the UML2 class {@link Element}.
 */
public class ElementUtils
{
   private static Logger                     logger      = Logger.getLogger(ElementUtils.class);

   private static Map<String, List<Element>> destropyMap = new HashMap<String, List<Element>>();

   /**
    * Marks the given element as "to be destroyed later", with the given context name.
    */
   public static void destroyLater(Element element, String context) {
      List<Element> destroyList = destropyMap.get(context);

      if ( destroyList == null ) {
         destroyList = new ArrayList<Element>();
         destropyMap.put(context, destroyList);
      }

      destroyList.add(element);
   }

   /**
    * Destroys all collected model elements for the given context name.
    */
   public static void destroyCollected(String context) {
      List<Element> destroyList = destropyMap.get(context);

      if ( destroyList != null ) {
         for ( Iterator<Element> ie = destroyList.iterator(); ie.hasNext(); ) {
            Element element = ie.next();

            element.destroy();
            ie.remove();
            if ( element instanceof NamedElement )
               logger.info("Destroyed " + ((NamedElement) element).getQualifiedName());
            else
               logger.info("Destroyed " + element.toString());
         }
      }
   }
}
