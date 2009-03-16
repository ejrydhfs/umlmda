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
   
package org.umlmda.demo.service.ejb.bean;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;


/**
 * EJB Home interface for @see MasterService
 */
public interface MasterServiceHome extends EJBHome
{
   public static final String JNDI_NAME="ejb/service/1/MasterService";
   public static final String COMP_NAME="java:comp/env/ejb/MasterService";

   public MasterService create() throws RemoteException, CreateException;
}
