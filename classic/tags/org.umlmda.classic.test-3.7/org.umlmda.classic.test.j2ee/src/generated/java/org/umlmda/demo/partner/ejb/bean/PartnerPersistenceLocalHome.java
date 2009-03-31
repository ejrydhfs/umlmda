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

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

/**
 * EJB local home interface for @see PartnerPersistenceLocal
 */
public interface PartnerPersistenceLocalHome extends EJBLocalHome
{
   public static final String JNDI_NAME="ejb/partner/1/PartnerPersistence";
   public static final String COMP_NAME="java:comp/env/ejb/PartnerPersistence";

   public PartnerPersistenceLocal create() throws CreateException;
}
