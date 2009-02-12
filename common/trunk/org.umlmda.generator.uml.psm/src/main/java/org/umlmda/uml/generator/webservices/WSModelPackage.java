/*
 * Created on 09.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelPackage;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModelPackage extends JavaModelPackage {

   /**
    * Returns the namespace defined for this package. It can be defined
    * in the attribute <b>WSNamespace</b> of the stereotype 
    * <b>BusinessComponent</b> in the UMLMDA profile. If not defined 
    * it's generated.
    */
   public String getNamespace();
   
   public String getNamespacePrefix();
   
   public void setNamespacePrefix(String namespacePrefix);
   
   /**
    * Returns the namespace prefix defined for this package in context
    * of the given base package. It can be defined in the attribute 
    * <b>WSNamespacePrefix</b> of the stereotype <b>BusinessComponent</b>
    * in the UMLMDA profile. If not defined it's generated.
    */
   public String getNamespacePrefix(WSModelPackage basePackage);

   /**
    * Gets the web service package
    * @return
    */
   public WSModelPackage getWsPackage();
   
   /**
    * Gets the plattform independent package
    * @return
    */
   public JavaModelPackage getPIMPackage();
}
