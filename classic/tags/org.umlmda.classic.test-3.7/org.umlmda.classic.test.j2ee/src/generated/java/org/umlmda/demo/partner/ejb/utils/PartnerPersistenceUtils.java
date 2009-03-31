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

import org.umlmda.demo.partner.ejb.bean.PartnerPersistenceHome;

/**
 * EJB-Utility class for PartnerPersistence.
 */
public class PartnerPersistenceUtils
{
   /** Cached remote home (EJBHome). Uses lazy loading to obtain its value (loaded by getHome() methods). */
   private static PartnerPersistenceHome cachedRemoteHome = null;

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
    * @return Home interface for PartnerPersistence. Lookup using COMP_NAME
    */
   public static PartnerPersistenceHome getHome() throws javax.naming.NamingException
   {
      if (cachedRemoteHome == null) { 
         try { 
            cachedRemoteHome = (PartnerPersistenceHome) lookupHome(null, PartnerPersistenceHome.COMP_NAME, PartnerPersistenceHome.class); 
         } catch (javax.naming.NamingException e){
            // Eat exception, some implementation throws naming exceptions, return null 
         }
         // If not yet resolved try with JNDI name of component
         if (cachedRemoteHome == null) { 
            cachedRemoteHome = (PartnerPersistenceHome) lookupHome(null, PartnerPersistenceHome.JNDI_NAME, PartnerPersistenceHome.class); 
         } 
      } 
      return cachedRemoteHome;
   }


}
