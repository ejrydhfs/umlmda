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

package org.umlmda.demo.partner;

import org.umlmda.demo.common.CommonService;
import org.umlmda.demo.common.dto.SecurityToken;
import org.umlmda.demo.partner.dto.Partner;
//@@UserSection-Begin PartnerService.Imports
//@@UserSection-End PartnerService.Imports

/**
 * Sample parnter service, derived from another service.
 */
public interface PartnerService extends CommonService
{

   /**
    * Reads a partner which  data valid at the given date.
    */
    public Partner read (String id, javax.xml.datatype.XMLGregorianCalendar validityDate, SecurityToken security);

   /**
    * Updates a partner which  data valid for the given date.
    */
    public void update (Partner toUpdate, javax.xml.datatype.XMLGregorianCalendar validityDate);

   /**
    * 
    */
    public Partner echo (Partner toEcho);

		

}
