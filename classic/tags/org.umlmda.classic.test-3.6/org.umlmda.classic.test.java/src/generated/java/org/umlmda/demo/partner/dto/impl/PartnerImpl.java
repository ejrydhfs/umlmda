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

package org.umlmda.demo.partner.dto.impl;

import java.io.Serializable;
import java.util.Iterator;
import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.demo.common.dto.Note;
import org.umlmda.demo.partner.dto.EMail;
import org.umlmda.demo.partner.dto.InstantMessenger;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PartnerVisitor;
import org.umlmda.demo.partner.dto.PostalAddress;
import org.umlmda.demo.partner.dto.Telephone;
//@@UserSection-Begin Partner.Imports
//@@UserSection-End Partner.Imports

/**
 * Base of Businessobject of person or legal entity.
 */
public class PartnerImpl  implements Partner, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   
   // Delegate for none generatable features
   private transient org.umlmda.demo.partner.dto.PartnerDelegate thePartnerDelegate = null;

   /**
    * Lazy creation of the delegate for none generateable features. 
    */
   protected org.umlmda.demo.partner.dto.PartnerDelegate getPartnerDelegate() {
      if ( thePartnerDelegate == null ) {
         thePartnerDelegate = new org.umlmda.demo.partner.dto.impl.delegate.PartnerDelegateImpl(this);
      }
      return thePartnerDelegate;
   }

   private String id = "null";
   private String name = "null";
   private java.util.Collection _eMail = new java.util.ArrayList();
   private java.util.Collection _instantMessenger = new java.util.ArrayList();
   private java.util.Collection _telephone = new java.util.ArrayList();
   private java.util.Collection addresses = new java.util.ArrayList();
   private java.util.Collection notes = new java.util.ArrayList();
   private PostalAddress preferredAddress = null;
   private PostalAddress primaryAddress = null;

   /**
    * Default Ctor
    */
   protected PartnerImpl() {
      super();
   }
   

   

   /**
   * Get id
   */
   public String getId() {
      return id;
   }
   
   /**
   * Set id
   */
   public void setId(String id) {
      this.id = id;
   }

   /**
   * Get name
   */
   public String getName() {
      return name;
   }
   
   /**
   * Set name
   */
   public void setName(String name) {
      this.name = name;
   }



   public java.util.Collection get_eMail() {
      return _eMail;
   }
   public void set_eMail(java.util.Collection _eMail) {
      set_eMailInternal(_eMail);
   }
   private void set_eMailInternal(java.util.Collection _eMail) {
      if ( _eMail != null ) {
         if ( this._eMail == null ) {
            this._eMail = new java.util.ArrayList();
         }
         this._eMail.clear();
         this._eMail.addAll(_eMail);
      }
      else if ( this._eMail != null ) {
         this._eMail.clear();
         this._eMail = null;
      }
   }

   public java.util.Collection get_instantMessenger() {
      return _instantMessenger;
   }
   public void set_instantMessenger(java.util.Collection _instantMessenger) {
      set_instantMessengerInternal(_instantMessenger);
   }
   private void set_instantMessengerInternal(java.util.Collection _instantMessenger) {
      if ( _instantMessenger != null ) {
         if ( this._instantMessenger == null ) {
            this._instantMessenger = new java.util.ArrayList();
         }
         this._instantMessenger.clear();
         this._instantMessenger.addAll(_instantMessenger);
      }
      else if ( this._instantMessenger != null ) {
         this._instantMessenger.clear();
         this._instantMessenger = null;
      }
   }

   public java.util.Collection get_telephone() {
      return _telephone;
   }
   public void set_telephone(java.util.Collection _telephone) {
      set_telephoneInternal(_telephone);
   }
   private void set_telephoneInternal(java.util.Collection _telephone) {
      if ( _telephone != null ) {
         if ( this._telephone == null ) {
            this._telephone = new java.util.ArrayList();
         }
         this._telephone.clear();
         this._telephone.addAll(_telephone);
      }
      else if ( this._telephone != null ) {
         this._telephone.clear();
         this._telephone = null;
      }
   }

   public java.util.Collection getAddresses() {
      return addresses;
   }
   public void setAddresses(java.util.Collection addresses) {
      setAddressesInternal(addresses);
   }
   private void setAddressesInternal(java.util.Collection addresses) {
      if ( addresses != null ) {
         if ( this.addresses == null ) {
            this.addresses = new java.util.ArrayList();
         }
         this.addresses.clear();
         this.addresses.addAll(addresses);
      }
      else if ( this.addresses != null ) {
         this.addresses.clear();
         this.addresses = null;
      }
   }

   public java.util.Collection getNotes() {
      return notes;
   }
   public void setNotes(java.util.Collection notes) {
      setNotesInternal(notes);
   }
   private void setNotesInternal(java.util.Collection notes) {
      if ( notes != null ) {
         if ( this.notes == null ) {
            this.notes = new java.util.ArrayList();
         }
         this.notes.clear();
         this.notes.addAll(notes);
      }
      else if ( this.notes != null ) {
         this.notes.clear();
         this.notes = null;
      }
   }
   public PostalAddress getPreferredAddress() {
      return preferredAddress;
   }

   public void setPreferredAddress(PostalAddress preferredAddress) {
      this.preferredAddress = preferredAddress;
      }
   public PostalAddress getPrimaryAddress() {
      return primaryAddress;
   }

   public void setPrimaryAddress(PostalAddress primaryAddress) {
      this.primaryAddress = primaryAddress;
      }
   /**
    * Delivers the full name of the partner. Might be overwritten in subclasses.
    */
    public String getFullName () {
      return getPartnerDelegate().getFullName();
    }

		

   //@@UserSection-Begin Partner.NonGeneratedMembers
   //@@UserSection-End Partner.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static PartnerImpl createPartnerImpl() {
      return new PartnerImpl();
   }
    
   
   /** 
    * Accept the visitor
    * @param visitor
    *           must be instance of org.umlmda.demo.partner.dto.PartnerVisitor.
    * @see org.umlmda.demo.partner.dto.PartnerVisitor.
    */
    public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
       if ( visitor instanceof PartnerVisitor ) {
          PartnerVisitor aVisitor = (PartnerVisitor)visitor;
          
          aVisitor.visit(this);
       }
    }
    

   /**
    * Diagnostics
    */
   public String toString() {
//@@UserSection-Begin toString
		return toXmlString();
//@@UserSection-End toString
   }

   /**
    * XML serialization
    */
   public String toXmlString() {
      XMLMarshalContext context = new XMLMarshalContext();
      
      marshal("PartnerImpl", context, true);
      return context.toString();
   }
   
   /**
    * XML serialization of the elements and all children
    */
   public void marshal(String elementName, XMLMarshalContext context, boolean isRoot) {
      context.startElement(elementName, this, isRoot);
      marshalAttributes(context);
      marshalChildren(context);
      marshalReferences(context);
      context.endElement(elementName, this, isRoot);
   }

   /**
    * Marshal attributes
    */
   protected void marshalAttributes(XMLMarshalContext context) {
      context.simpleElement("id", getId());
      context.simpleElement("name", getName());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      for (Iterator i = get_eMail().iterator(); i.hasNext();) {
         Object child = i.next();
         
         if ( child instanceof XMLSerializable )
            ((XMLSerializable)child).marshal("_eMail", context, false);
      }
      for (Iterator i = get_instantMessenger().iterator(); i.hasNext();) {
         Object child = i.next();
         
         if ( child instanceof XMLSerializable )
            ((XMLSerializable)child).marshal("_instantMessenger", context, false);
      }
      for (Iterator i = get_telephone().iterator(); i.hasNext();) {
         Object child = i.next();
         
         if ( child instanceof XMLSerializable )
            ((XMLSerializable)child).marshal("_telephone", context, false);
      }
      for (Iterator i = getAddresses().iterator(); i.hasNext();) {
         Object child = i.next();
         
         if ( child instanceof XMLSerializable )
            ((XMLSerializable)child).marshal("addresses", context, false);
      }
      for (Iterator i = getNotes().iterator(); i.hasNext();) {
         Object child = i.next();
         
         if ( child instanceof XMLSerializable )
            ((XMLSerializable)child).marshal("notes", context, false);
      }
   }
   
   /**
    * @param context
    */
   protected void marshalReferences(XMLMarshalContext context) {
      if ( getPreferredAddress() instanceof XMLSerializable )
         context.elementRef("preferredAddress", (XMLSerializable)getPreferredAddress());
      if ( getPrimaryAddress() instanceof XMLSerializable )
         context.elementRef("primaryAddress", (XMLSerializable)getPrimaryAddress());
   }

}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
