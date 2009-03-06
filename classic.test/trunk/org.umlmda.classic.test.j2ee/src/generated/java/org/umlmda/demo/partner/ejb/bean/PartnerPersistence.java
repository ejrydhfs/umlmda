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

//@@UserSection-Begin PartnerPersistence.Imports
//@@UserSection-End PartnerPersistence.Imports

/**
 * J2EE Remote Interface for org.umlmda.demo.partner.PartnerPersistence
 */
public interface PartnerPersistence extends javax.ejb.EJBObject
{

   /**
    * Retrieves all person, which are contact persons in a legal entity.
    */
    org.umlmda.demo.partner.dto.PersonList queryContactPersons () throws java.rmi.RemoteException;

   /**
    * null
    */
    boolean isContainerManaged () throws java.rmi.RemoteException;

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Mandator readByPKey_mandator () throws java.rmi.RemoteException;

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Mandator deleteByPKey_mandator () throws java.rmi.RemoteException;

   /**
    * null
    */
    void insert_mandator (org.umlmda.demo.partner.dto.Mandator toInsert) throws java.rmi.RemoteException;

   /**
    * null
    */
    void update_mandator (org.umlmda.demo.partner.dto.Mandator toUpdate) throws java.rmi.RemoteException;

   /**
    * null
    */
    void delete_mandator (org.umlmda.demo.partner.dto.Mandator toDelete) throws java.rmi.RemoteException;

   /**
    * null
    */
    void save_mandator (org.umlmda.demo.partner.dto.Mandator toSave) throws java.rmi.RemoteException;

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Partner readByPKeyPartner () throws java.rmi.RemoteException;

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Partner deleteByPKeyPartner () throws java.rmi.RemoteException;

   /**
    * null
    */
    void insertPartner (org.umlmda.demo.partner.dto.Partner toInsert) throws java.rmi.RemoteException;

   /**
    * null
    */
    void updatePartner (org.umlmda.demo.partner.dto.Partner toUpdate) throws java.rmi.RemoteException;

   /**
    * null
    */
    void deletePartner (org.umlmda.demo.partner.dto.Partner toDelete) throws java.rmi.RemoteException;

   /**
    * null
    */
    void savePartner (org.umlmda.demo.partner.dto.Partner toSave) throws java.rmi.RemoteException;

		

};
