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


package org.umlmda.demo.common.ejb.utils;

import org.umlmda.demo.common.ejb.bean.CommonServiceHome;

/**
 * EJB-Utility class for CommonService.
 */
public class CommonServiceUtils
{
   /** Cached remote home (EJBHome). Uses lazy loading to obtain its value (loaded by getHome() methods). */
   private static CommonServiceHome cachedRemoteHome = null;

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
    * @return Home interface for CommonService. Lookup using COMP_NAME
    */
   public static CommonServiceHome getHome() throws javax.naming.NamingException
   {
      if (cachedRemoteHome == null) { 
         try { 
            cachedRemoteHome = (CommonServiceHome) lookupHome(null, CommonServiceHome.COMP_NAME, CommonServiceHome.class); 
         } catch (javax.naming.NamingException e){
            // Eat exception, some implementation throws naming exceptions, return null 
         }
         // If not yet resolved try with JNDI name of component
         if (cachedRemoteHome == null) { 
            cachedRemoteHome = (CommonServiceHome) lookupHome(null, CommonServiceHome.JNDI_NAME, CommonServiceHome.class); 
         } 
      } 
      return cachedRemoteHome;
   }


}
