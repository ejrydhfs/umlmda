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

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

/**
 * EJB local home interface for @see MasterServiceLocal
 */
public interface MasterServiceLocalHome extends EJBLocalHome
{
   public static final String JNDI_NAME="ejb/service/1/MasterService";
   public static final String COMP_NAME="java:comp/env/ejb/MasterService";

   public MasterServiceLocal create() throws CreateException;
}
