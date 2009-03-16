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

import org.umlmda.demo.partner.dto.Mandator;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PartnerVisitor;
//@@UserSection-Begin Mandator.Imports
//@@UserSection-End Mandator.Imports

/**
 * Two separate date between different mandators.
 */
public class MandatorImpl  implements Mandator, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private String mandatorId = "null";
   private String name = "null";
   private java.util.Collection _partner = new java.util.ArrayList();

   /**
    * Default Ctor
    */
   protected MandatorImpl() {
      super();
   }
   

   

   /**
   * Get mandatorId
   */
   public String getMandatorId() {
      return mandatorId;
   }
   
   /**
   * Set mandatorId
   */
   public void setMandatorId(String mandatorId) {
      this.mandatorId = mandatorId;
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



   public java.util.Collection get_partner() {
      return _partner;
   }
   public void set_partner(java.util.Collection _partner) {
      set_partnerInternal(_partner);
   }
   private void set_partnerInternal(java.util.Collection _partner) {
      if ( _partner != null ) {
         if ( this._partner == null ) {
            this._partner = new java.util.ArrayList();
         }
         this._partner.clear();
         this._partner.addAll(_partner);
      }
      else if ( this._partner != null ) {
         this._partner.clear();
         this._partner = null;
      }
   }
		

   //@@UserSection-Begin Mandator.NonGeneratedMembers
   //@@UserSection-End Mandator.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static MandatorImpl createMandatorImpl() {
      return new MandatorImpl();
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
      
      marshal("MandatorImpl", context, true);
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
      context.simpleElement("mandatorId", getMandatorId());
      context.simpleElement("name", getName());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      for (Iterator i = get_partner().iterator(); i.hasNext();) {
         Object child = i.next();
         
         if ( child instanceof XMLSerializable )
            ((XMLSerializable)child).marshal("_partner", context, false);
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
