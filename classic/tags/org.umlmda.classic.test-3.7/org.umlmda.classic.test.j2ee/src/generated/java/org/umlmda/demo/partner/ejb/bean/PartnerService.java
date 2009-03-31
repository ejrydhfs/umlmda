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
import org.umlmda.demo.common.ejb.bean.CommonService;
//@@UserSection-Begin PartnerService.Imports
//@@UserSection-End PartnerService.Imports

/**
 * J2EE Remote Interface for org.umlmda.demo.partner.PartnerService
 */
public interface PartnerService extends CommonService
{

   /**
    * Reads a partner which  data valid at the given date.
    */
    org.umlmda.demo.partner.dto.Partner read (String id, javax.xml.datatype.XMLGregorianCalendar validityDate, org.umlmda.demo.common.dto.SecurityToken security) throws java.rmi.RemoteException;

   /**
    * Updates a partner which  data valid for the given date.
    */
    void update (org.umlmda.demo.partner.dto.Partner toUpdate, javax.xml.datatype.XMLGregorianCalendar validityDate) throws java.rmi.RemoteException;

   /**
    * 
    */
    org.umlmda.demo.partner.dto.Partner echo (org.umlmda.demo.partner.dto.Partner toEcho) throws java.rmi.RemoteException;

		

};
