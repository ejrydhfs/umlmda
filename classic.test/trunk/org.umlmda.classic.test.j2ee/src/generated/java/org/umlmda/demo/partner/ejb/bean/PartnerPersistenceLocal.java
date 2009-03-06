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


//@@UserSection-Begin PartnerPersistence.Imports
//@@UserSection-End PartnerPersistence.Imports

/**
 * Local Interface for @see org.umlmda.demo.partner.PartnerPersistence
 */
public interface PartnerPersistenceLocal extends javax.ejb.EJBLocalObject {

   /**
    * Retrieves all person, which are contact persons in a legal entity.
    */
    org.umlmda.demo.partner.dto.PersonList queryContactPersons ();

   /**
    * null
    */
    boolean isContainerManaged ();

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Mandator readByPKey_mandator ();

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Mandator deleteByPKey_mandator ();

   /**
    * null
    */
    void insert_mandator (org.umlmda.demo.partner.dto.Mandator toInsert);

   /**
    * null
    */
    void update_mandator (org.umlmda.demo.partner.dto.Mandator toUpdate);

   /**
    * null
    */
    void delete_mandator (org.umlmda.demo.partner.dto.Mandator toDelete);

   /**
    * null
    */
    void save_mandator (org.umlmda.demo.partner.dto.Mandator toSave);

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Partner readByPKeyPartner ();

   /**
    * null
    */
    org.umlmda.demo.partner.dto.Partner deleteByPKeyPartner ();

   /**
    * null
    */
    void insertPartner (org.umlmda.demo.partner.dto.Partner toInsert);

   /**
    * null
    */
    void updatePartner (org.umlmda.demo.partner.dto.Partner toUpdate);

   /**
    * null
    */
    void deletePartner (org.umlmda.demo.partner.dto.Partner toDelete);

   /**
    * null
    */
    void savePartner (org.umlmda.demo.partner.dto.Partner toSave);

      
};
