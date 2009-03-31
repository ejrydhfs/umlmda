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
   
package org.umlmda.demo.common.ejb.bean;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.CreateException;


/**
 * EJB Home interface for @see CommonService
 */
public interface CommonServiceHome extends EJBHome
{
   public static final String JNDI_NAME="ejb/common/1/CommonService";
   public static final String COMP_NAME="java:comp/env/ejb/CommonService";

   public CommonService create() throws RemoteException, CreateException;
}
