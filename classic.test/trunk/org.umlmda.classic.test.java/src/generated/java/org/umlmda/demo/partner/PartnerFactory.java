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



/**
 *
 */
public interface PartnerFactory extends org.umlmda.demo.partner.dto.PartnerFactory
{
   /**
   * Create Businessinterface for CommonService
   * @see CommonService
   */
   public CommonService createCommonService();
   /**
   * Create Businessinterface for PartnerPersistence
   * @see PartnerPersistence
   */
   public PartnerPersistence createPartnerPersistence();
   /**
   * Create Businessinterface for PartnerService
   * @see PartnerService
   */
   public PartnerService createPartnerService();
	    

}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
