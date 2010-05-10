/*
 * Created on 09.11.2005
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelPackage;

/**
 * @author moroff
 */
public interface WSModelPackage extends JavaModelPackage
{

   /**
    * Returns the namespace defined for this package. It can be defined in the attribute <b>WSNamespace</b> of the stereotype
    * <b>BusinessComponent</b> in the UMLMDA profile. If not defined it's generated.
    */
   String getNamespace();

   String getNamespacePrefix();

   void setNamespacePrefix(String namespacePrefix);

   /**
    * Returns the namespace prefix defined for this package in context of the given base package. It can be defined in the
    * attribute <b>WSNamespacePrefix</b> of the stereotype <b>BusinessComponent</b> in the UMLMDA profile. If not defined it's
    * generated.
    */
   String getNamespacePrefix(WSModelPackage basePackage);

   /**
    * Gets the web service package
    * 
    * @return
    */
   WSModelPackage getWsPackage();

   /**
    * Gets the plattform independent package
    * 
    * @return
    */
   JavaModelPackage getPIMPackage();
}
