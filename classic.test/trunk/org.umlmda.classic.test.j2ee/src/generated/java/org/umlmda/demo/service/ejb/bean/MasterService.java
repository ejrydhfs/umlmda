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

//@@UserSection-Begin MasterService.Imports
//@@UserSection-End MasterService.Imports

/**
 * J2EE Remote Interface for org.umlmda.demo.service.MasterService
 */
public interface MasterService extends javax.ejb.EJBObject
{

   /**
    * 
    */
    void verify (org.umlmda.demo.partner.dto.Partner toVerify) throws java.rmi.RemoteException;

		

};
