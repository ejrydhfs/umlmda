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
 * EJB local home interface for @see PartnerServiceLocal
 */
public interface PartnerServiceLocalHome extends EJBLocalHome
{
   public static final String JNDI_NAME="ejb/partner/1/PartnerService";
   public static final String COMP_NAME="java:comp/env/ejb/PartnerService";

   public PartnerServiceLocal create() throws CreateException;
}
