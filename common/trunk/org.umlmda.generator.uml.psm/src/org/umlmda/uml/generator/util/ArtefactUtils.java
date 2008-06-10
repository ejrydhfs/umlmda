package org.umlmda.uml.generator.util;

import java.util.HashMap;
import java.util.Map;

import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.java.JavaArtefacts;

/**
 * Utilites to help defining the mapping between stereotypes and artifacts in generation templates
 * 
 * @author Dieter Moroff (7.4.2008)
 */
public class ArtefactUtils {
   public static final String SCOPE_IMPLEMENTATION = "Implementation";
   public static final String SCOPE_INTERFACE = "Interface";

   static {
	   defaultMappings = new HashMap<String, Entry>();
	   resetDefaultMappings();
   }
   
   private static class Entry extends HashMap<String, String> {
      Entry(String scope, String artefactName) {
         put(scope, artefactName);
      }
   }
   
   private static final Map<String, Entry> defaultMappings;
   
   
   public static String getScopeImplemenation() {
      return SCOPE_IMPLEMENTATION;
   }

   public static String getScopeInterface() {
      return SCOPE_INTERFACE;
   }

   public static void resetDefaultMappings() {
      defaultMappings.clear();
      
      setDefaultMapping(ModelStereotype.BUSINESS_SERVICE, JavaArtefacts.BUSINESS_SERVICE_INTERFACE);
      setDefaultMapping(ModelStereotype.BUSINESS_OBJECT, JavaArtefacts.BUSINESS_OBJECT_INTERFACE);
      setDefaultMapping(ModelStereotype.BUSINESS_OBJECT, JavaArtefacts.BUSINESS_OBJECT, SCOPE_IMPLEMENTATION);
      setDefaultMapping(ModelStereotype.BUSINESS_EXCEPTION, JavaArtefacts.BUSINESS_EXCEPTION);
      setDefaultMapping(ModelStereotype.ENUMERATION, JavaArtefacts.ENUMERATION);
      setDefaultMapping(ModelStereotype.NATIVE_CLASS, JavaArtefacts.PLAIN_CLASS);
      setDefaultMapping(ModelStereotype.NATIVE_INTERFACE, JavaArtefacts.PLAIN_INTERFACE);
   }
   
   public static String getDefaultMapping(String stereotypeName) {
      return getDefaultMapping(stereotypeName, SCOPE_INTERFACE);
   }
   
   public static String getDefaultMapping(String stereotypeName, String scope) {
      Entry entry = defaultMappings.get(stereotypeName);
      
      if ( entry != null ) {
         return entry.get(scope);
      }
      else
         return null;
   }
   
   public static void setDefaultMapping(String stereotypeName, String artefactName) {
      setDefaultMapping(stereotypeName, artefactName, SCOPE_INTERFACE);
   }
   
   public static void setDefaultMapping(String stereotypeName, String artefactName, String scope) {
      Entry entry = defaultMappings.get(stereotypeName);
      
      if ( entry != null ) {
         entry.put(scope, artefactName);
      }
      else {
         defaultMappings.put(stereotypeName, new Entry(scope, artefactName));
      }
   }
}
