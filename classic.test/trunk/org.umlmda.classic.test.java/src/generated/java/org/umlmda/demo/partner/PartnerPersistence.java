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

import org.umlmda.demo.partner.dto.Mandator;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PersonList;
//@@UserSection-Begin PartnerPersistence.Imports
//@@UserSection-End PartnerPersistence.Imports

/**
 * 
 */
public interface PartnerPersistence 
{

   /**
    * Retrieves all person, which are contact persons in a legal entity.
    */
    public PersonList queryContactPersons ();

   /**
    * null
    */
    public boolean isContainerManaged ();

   /**
    * null
    */
    public Mandator readByPKey_mandator ();

   /**
    * null
    */
    public Mandator deleteByPKey_mandator ();

   /**
    * null
    */
    public void insert_mandator (Mandator toInsert);

   /**
    * null
    */
    public void update_mandator (Mandator toUpdate);

   /**
    * null
    */
    public void delete_mandator (Mandator toDelete);

   /**
    * null
    */
    public void save_mandator (Mandator toSave);

   /**
    * null
    */
    public Partner readByPKeyPartner ();

   /**
    * null
    */
    public Partner deleteByPKeyPartner ();

   /**
    * null
    */
    public void insertPartner (Partner toInsert);

   /**
    * null
    */
    public void updatePartner (Partner toUpdate);

   /**
    * null
    */
    public void deletePartner (Partner toDelete);

   /**
    * null
    */
    public void savePartner (Partner toSave);

		

}
