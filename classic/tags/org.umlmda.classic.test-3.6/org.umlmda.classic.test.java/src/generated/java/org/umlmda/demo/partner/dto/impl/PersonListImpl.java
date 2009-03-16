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

import org.umlmda.demo.partner.dto.PartnerVisitor;
import org.umlmda.demo.partner.dto.Person;
import org.umlmda.demo.partner.dto.PersonList;
//@@UserSection-Begin PersonList.Imports
//@@UserSection-End PersonList.Imports

/**
 * 
 */
public class PersonListImpl  implements PersonList, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private java.util.Collection _person = new java.util.ArrayList();

   /**
    * Default Ctor
    */
   protected PersonListImpl() {
      super();
   }
   

   



   public java.util.Collection get_person() {
      return _person;
   }
   public void set_person(java.util.Collection _person) {
      set_personInternal(_person);
   }
   private void set_personInternal(java.util.Collection _person) {
      if ( _person != null ) {
         if ( this._person == null ) {
            this._person = new java.util.ArrayList();
         }
         this._person.clear();
         this._person.addAll(_person);
      }
      else if ( this._person != null ) {
         this._person.clear();
         this._person = null;
      }
   }
		

   //@@UserSection-Begin PersonList.NonGeneratedMembers
   //@@UserSection-End PersonList.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static PersonListImpl createPersonListImpl() {
      return new PersonListImpl();
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
      
      marshal("PersonListImpl", context, true);
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
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      for (Iterator i = get_person().iterator(); i.hasNext();) {
         Object child = i.next();
         
         if ( child instanceof XMLSerializable )
            ((XMLSerializable)child).marshal("_person", context, false);
      }
   }
   
   /**
    * @param context
    */
   protected void marshalReferences(XMLMarshalContext context) {
   }

}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
