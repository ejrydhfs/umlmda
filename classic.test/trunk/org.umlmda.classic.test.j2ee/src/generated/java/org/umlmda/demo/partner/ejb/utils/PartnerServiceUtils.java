//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
// $Header$
// $Source$
// $Revision$
// $State$
// $Name$
// $Date$
// $Locker$
//@@UserSection-End RCSHeader


package org.umlmda.demo.partner.ejb.utils;

import org.umlmda.demo.partner.ejb.bean.PartnerServiceHome;

/**
 * EJB-Utility class for PartnerService.
 */
public class PartnerServiceUtils
{
   /** Cached remote home (EJBHome). Uses lazy loading to obtain its value (loaded by getHome() methods). */
   private static PartnerServiceHome cachedRemoteHome = null;

   private static Object lookupHome(java.util.Hashtable environment, String jndiName, Class narrowTo) throws javax.naming.NamingException {
      // Obtain initial context
      javax.naming.InitialContext initialContext = new javax.naming.InitialContext(environment);
      try {
         Object objRef = initialContext.lookup(jndiName);
         // only narrow if necessary
         if (java.rmi.Remote.class.isAssignableFrom(narrowTo)) 
            return javax.rmi.PortableRemoteObject.narrow(objRef, narrowTo);
         else
            return objRef;
      } finally {
         initialContext.close();
      }
   }

   // Home interface lookup methods

   /**
    * Obtain remote home interface from default initial context
    * @return Home interface for PartnerService. Lookup using COMP_NAME
    */
   public static PartnerServiceHome getHome() throws javax.naming.NamingException
   {
      if (cachedRemoteHome == null) { 
         try { 
            cachedRemoteHome = (PartnerServiceHome) lookupHome(null, PartnerServiceHome.COMP_NAME, PartnerServiceHome.class); 
         } catch (javax.naming.NamingException e){
            // Eat exception, some implementation throws naming exceptions, return null 
         }
         // If not yet resolved try with JNDI name of component
         if (cachedRemoteHome == null) { 
            cachedRemoteHome = (PartnerServiceHome) lookupHome(null, PartnerServiceHome.JNDI_NAME, PartnerServiceHome.class); 
         } 
      } 
      return cachedRemoteHome;
   }


}
