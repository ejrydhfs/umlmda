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

import org.umlmda.demo.common.dto.TimeDependent;
import org.umlmda.demo.common.dto.impl.TimeDependentImpl;
import org.umlmda.demo.partner.dto.AddressType;
import org.umlmda.demo.partner.dto.PartnerVisitor;
import org.umlmda.demo.partner.dto.PostalAddress;
//@@UserSection-Begin PostalAddress.Imports
//@@UserSection-End PostalAddress.Imports

/**
 * Postal adress.

Different types can be distinguished:
- Private address
- Business address
- Holiday address

 */
public class PostalAddressImpl  extends TimeDependentImpl  implements PostalAddress, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private int nr = 0;
   private String zip = "null";
   private String city = "null";
   private String street = "null";
   private int PRIVATE = 1;
   private int BUSINESS = 2;
   private int HOLIDAY = 3;
   private AddressType type;

   /**
    * Default Ctor
    */
   protected PostalAddressImpl() {
      super();
   }
   

   

   /**
   * Get nr
   */
   public int getNr() {
      return nr;
   }
   
   /**
   * Set nr
   */
   public void setNr(int nr) {
      this.nr = nr;
   }

   /**
   * Get zip
   */
   public String getZip() {
      return zip;
   }
   
   /**
   * Set zip
   */
   public void setZip(String zip) {
      this.zip = zip;
   }

   /**
   * Get city
   */
   public String getCity() {
      return city;
   }
   
   /**
   * Set city
   */
   public void setCity(String city) {
      this.city = city;
   }

   /**
   * Get street
   */
   public String getStreet() {
      return street;
   }
   
   /**
   * Set street
   */
   public void setStreet(String street) {
      this.street = street;
   }

   /**
   * Get PRIVATE
   */
   public int getPRIVATE() {
      return PRIVATE;
   }
   
   /**
   * Set PRIVATE
   */
   public void setPRIVATE(int PRIVATE) {
      this.PRIVATE = PRIVATE;
   }

   /**
   * Get BUSINESS
   */
   public int getBUSINESS() {
      return BUSINESS;
   }
   
   /**
   * Set BUSINESS
   */
   public void setBUSINESS(int BUSINESS) {
      this.BUSINESS = BUSINESS;
   }

   /**
   * Get HOLIDAY
   */
   public int getHOLIDAY() {
      return HOLIDAY;
   }
   
   /**
   * Set HOLIDAY
   */
   public void setHOLIDAY(int HOLIDAY) {
      this.HOLIDAY = HOLIDAY;
   }

   /**
   * Get type
   */
   public AddressType getType() {
      return type;
   }
   
   /**
   * Set type
   */
   public void setType(AddressType type) {
      this.type = type;
   }


		

   //@@UserSection-Begin PostalAddress.NonGeneratedMembers
   //@@UserSection-End PostalAddress.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static PostalAddressImpl createPostalAddressImpl() {
      return new PostalAddressImpl();
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
      
      marshal("PostalAddressImpl", context, true);
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
      context.simpleElement("nr", getNr());
      context.simpleElement("zip", getZip());
      context.simpleElement("city", getCity());
      context.simpleElement("street", getStreet());
      context.simpleElement("PRIVATE", getPRIVATE());
      context.simpleElement("BUSINESS", getBUSINESS());
      context.simpleElement("HOLIDAY", getHOLIDAY());
      if ( getType() != null ) {
         context.simpleElement("type", getType().getValue());
      } 
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
