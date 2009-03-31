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
   
package org.umlmda.demo.partner.ejb.bean;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;


/**
 * EJB Home interface for @see PartnerPersistence
 */
public interface PartnerPersistenceHome extends EJBHome
{
   public static final String JNDI_NAME="ejb/partner/1/PartnerPersistence";
   public static final String COMP_NAME="java:comp/env/ejb/PartnerPersistence";

   public PartnerPersistence create() throws RemoteException, CreateException;
}
