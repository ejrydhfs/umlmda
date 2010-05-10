package org.umlmda.oaw.util.uml2;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Type;

public class TypeMapper
{
   private static Map<String, Namespace> namespaceMap = new HashMap<String, Namespace>();

   private static Logger                 logger       = Logger.getLogger(TypeMapper.class);

   public static void registerNamespace(Namespace namespace, String sourcePrefix) {
      namespaceMap.put(sourcePrefix, namespace);
   }

   public static Type findType(Type type) {

      String qualifiedTypeName = type.getQualifiedName();
      String sourcePrefix = qualifiedTypeName.substring(0, qualifiedTypeName.lastIndexOf("::"));
      Namespace destNamespace = namespaceMap.get(sourcePrefix);
      if ( destNamespace != null ) {
         EList<Element> allOwnedElements = destNamespace.allOwnedElements();
         for ( Element element : allOwnedElements ) {
            if ( element instanceof Type && ((Type) element).getName().equals(type.getName()) ) {
               Type mappedType = (Type) element;

               logger.debug(type.getQualifiedName() + " mapped to " + mappedType.getQualifiedName());
               return mappedType;
            }
         }
         logger.warn(type.getQualifiedName() + " not found in any registered namespace");
      }
      else {
         logger.warn(sourcePrefix + " not found as registered namespace");

      }
      return null;
   }
}
