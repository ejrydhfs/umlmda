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
import org.umlmda.demo.partner.dto.PartnerVisitor;
import org.umlmda.demo.partner.dto.Telephone;
//@@UserSection-Begin Telephone.Imports
//@@UserSection-End Telephone.Imports

/**
 * 
 */
public class TelephoneImpl  extends CommunicationAddressImpl  implements Telephone, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   
   // Delegate for none generatable features
   private transient org.umlmda.demo.partner.dto.TelephoneDelegate theTelephoneDelegate = null;

   /**
    * Lazy creation of the delegate for none generateable features. 
    */
   protected org.umlmda.demo.partner.dto.TelephoneDelegate getTelephoneDelegate() {
      if ( theTelephoneDelegate == null ) {
         theTelephoneDelegate = new org.umlmda.demo.partner.dto.impl.delegate.TelephoneDelegateImpl(this);
      }
      return theTelephoneDelegate;
   }

   private String countryCode = "null";
   private String areaCode = "null";
   private String number = "null";

   /**
    * Default Ctor
    */
   protected TelephoneImpl() {
      super();
   }
   

   

   /**
   * Get countryCode
   */
   public String getCountryCode() {
      return countryCode;
   }
   
   /**
   * Set countryCode
   */
   public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
   }

   /**
   * Get areaCode
   */
   public String getAreaCode() {
      return areaCode;
   }
   
   /**
   * Set areaCode
   */
   public void setAreaCode(String areaCode) {
      this.areaCode = areaCode;
   }

   /**
   * Get number
   */
   public String getNumber() {
      return number;
   }
   
   /**
   * Set number
   */
   public void setNumber(String number) {
      this.number = number;
   }

   /**
   * Get fullNumber
   */
   public String getFullNumber() {
      return getTelephoneDelegate().getFullNumber();
   }
   
   /**
   * Set fullNumber
   */
   public void setFullNumber(String fullNumber) {
      getTelephoneDelegate().setFullNumber(fullNumber);
   }


		

   //@@UserSection-Begin Telephone.NonGeneratedMembers
   //@@UserSection-End Telephone.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static TelephoneImpl createTelephoneImpl() {
      return new TelephoneImpl();
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
      
      marshal("TelephoneImpl", context, true);
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
      context.simpleElement("countryCode", getCountryCode());
      context.simpleElement("areaCode", getAreaCode());
      context.simpleElement("number", getNumber());
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
