/*
 * Copyright: (C) 2009 COR AG Financial Technologies
 * Name:      $Id: AssociationUtils.java,v $Version 02.06.2009 19:54:10 {user} Exp $
 */
package org.umlmda.oaw.util.uml2;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Relationship;

public class AssociationUtils {
   
   public static Collection<Relationship> getRelationships(Class referencedClass, Package modelPackage) {
      Collection<Relationship> associations = new LinkedHashSet<Relationship>();
      
      for (Element element : modelPackage.allOwnedElements()) {
         if ( element instanceof Relationship ) {
            Relationship relationship = (Relationship) element;
            
            if ( relationship.getRelatedElements().contains(referencedClass)) {
               associations.add((Relationship)element);
            }
         }
      }
      return associations;
   }
   
   public static Collection<Element> getRelationElements(Class referencedClass, Package modelPackage) {
      Collection<Relationship> relationships = getRelationships(referencedClass, modelPackage);
      Collection<Element> relationElements = new LinkedHashSet<Element>();
      
      for (Relationship relationship : relationships) {
         EList<Element> relatedElements = relationship.getRelatedElements();
         
         for (Element relatedElement : relatedElements) {
            if ( relatedElement != referencedClass ) {
               relationElements.add(relatedElement);
            }
         }
      }
      
      return relationElements;
   }
}
