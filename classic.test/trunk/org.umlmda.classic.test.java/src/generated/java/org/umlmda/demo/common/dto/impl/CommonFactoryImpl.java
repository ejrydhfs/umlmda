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


package org.umlmda.demo.common.dto.impl;

import org.umlmda.demo.common.dto.CommonFactory;
import org.umlmda.demo.common.dto.Note;
import org.umlmda.demo.common.dto.SecurityToken;
import org.umlmda.demo.common.dto.TimeDependent;
//@@UserSection-Begin org.umlmda.demo.common.Imports
//@@UserSection-End org.umlmda.demo.common.Imports

/**
 * Abstract factory for the modelled classes of the package org.umlmda.demo.common
 */
public class CommonFactoryImpl implements CommonFactory
{
   /**
   * Create Businessinterface implementation for Note
   * @see Note
   */
   public Note createNote() {
   	  return NoteImpl.createNoteImpl();
   }
   /**
   * Create Businessinterface implementation for SecurityToken
   * @see SecurityToken
   */
   public SecurityToken createSecurityToken() {
   	  return SecurityTokenImpl.createSecurityTokenImpl();
   }
	    

};

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
