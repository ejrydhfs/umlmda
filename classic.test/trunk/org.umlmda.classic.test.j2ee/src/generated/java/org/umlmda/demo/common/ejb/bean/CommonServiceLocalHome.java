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

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

/**
 * EJB local home interface for @see CommonServiceLocal
 */
public interface CommonServiceLocalHome extends EJBLocalHome
{
   public static final String JNDI_NAME="ejb/common/1/CommonService";
   public static final String COMP_NAME="java:comp/env/ejb/CommonService";

   public CommonServiceLocal create() throws CreateException;
}
