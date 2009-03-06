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

import org.umlmda.demo.partner.dto.CommunicationAddress;
import org.umlmda.demo.partner.dto.IMType;
import org.umlmda.demo.partner.dto.InstantMessenger;
import org.umlmda.demo.partner.dto.PartnerVisitor;
//@@UserSection-Begin InstantMessenger.Imports
//@@UserSection-End InstantMessenger.Imports

/**
 * 
 */
public class InstantMessengerImpl  extends CommunicationAddressImpl  implements InstantMessenger, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private IMType imType = null;
   private String imId = "null";
   private String imNick = "null";

   /**
    * Default Ctor
    */
   protected InstantMessengerImpl() {
      super();
   }
   

   

   /**
   * Get imType
   */
   public IMType getImType() {
      return imType;
   }
   
   /**
   * Set imType
   */
   public void setImType(IMType imType) {
      this.imType = imType;
   }

   /**
   * Get imId
   */
   public String getImId() {
      return imId;
   }
   
   /**
   * Set imId
   */
   public void setImId(String imId) {
      this.imId = imId;
   }

   /**
   * Get imNick
   */
   public String getImNick() {
      return imNick;
   }
   
   /**
   * Set imNick
   */
   public void setImNick(String imNick) {
      this.imNick = imNick;
   }


		

   //@@UserSection-Begin InstantMessenger.NonGeneratedMembers
   //@@UserSection-End InstantMessenger.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static InstantMessengerImpl createInstantMessengerImpl() {
      return new InstantMessengerImpl();
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
      
      marshal("InstantMessengerImpl", context, true);
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
      super.marshalAttributes(context);
      if ( getImType() != null ) {
         context.simpleElement("imType", getImType().getValue());
      } 
      context.simpleElement("imId", getImId());
      context.simpleElement("imNick", getImNick());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      super.marshalChildren(context);
   }
   
   /**
    * @param context
    */
   protected void marshalReferences(XMLMarshalContext context) {
      super.marshalReferences(context);
   }

}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
