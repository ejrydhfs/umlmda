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

import org.umlmda.demo.partner.dto.LegalEntity;
import org.umlmda.demo.partner.dto.Partner;
import org.umlmda.demo.partner.dto.PartnerVisitor;
import org.umlmda.demo.partner.dto.Person;
//@@UserSection-Begin LegalEntity.Imports
//@@UserSection-End LegalEntity.Imports

/**
 * 
 */
public class LegalEntityImpl  extends PartnerImpl  implements LegalEntity, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   
   // Delegate for none generatable features
   private transient org.umlmda.demo.partner.dto.LegalEntityDelegate theLegalEntityDelegate = null;

   /**
    * Lazy creation of the delegate for none generateable features. 
    */
   protected org.umlmda.demo.partner.dto.LegalEntityDelegate getLegalEntityDelegate() {
      if ( theLegalEntityDelegate == null ) {
         theLegalEntityDelegate = new org.umlmda.demo.partner.dto.impl.delegate.LegalEntityDelegateImpl(this);
      }
      return theLegalEntityDelegate;
   }

   /**
    * Overwritten creation of the delegate for none generateable features from abstract base classes
    */
   protected org.umlmda.demo.partner.dto.PartnerDelegate getPartnerDelegate() {
      return getLegalEntityDelegate();
   }
   private String legalForm = "null";
   private java.math.BigDecimal revenue;
   private Person contactPerson = null;

   /**
    * Default Ctor
    */
   protected LegalEntityImpl() {
      super();
   }
   

   

   /**
   * Get legalForm
   */
   public String getLegalForm() {
      return legalForm;
   }
   
   /**
   * Set legalForm
   */
   public void setLegalForm(String legalForm) {
      this.legalForm = legalForm;
   }

   /**
   * Get revenue
   */
   public java.math.BigDecimal getRevenue() {
      return revenue;
   }
   
   /**
   * Set revenue
   */
   public void setRevenue(java.math.BigDecimal revenue) {
      this.revenue = revenue;
   }


   public Person getContactPerson() {
      return contactPerson;
   }

   public void setContactPerson(Person contactPerson) {
      this.contactPerson = contactPerson;
      }
		

   //@@UserSection-Begin LegalEntity.NonGeneratedMembers
   //@@UserSection-End LegalEntity.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static LegalEntityImpl createLegalEntityImpl() {
      return new LegalEntityImpl();
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
      
      marshal("LegalEntityImpl", context, true);
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
      context.simpleElement("legalForm", getLegalForm());
      context.simpleElement("revenue", getRevenue());
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
      if ( getContactPerson() instanceof XMLSerializable )
         context.elementRef("contactPerson", (XMLSerializable)getContactPerson());
   }

}

//@@UserSection-Begin RCSLog
// $Log$
//@@UserSection-End RCSLog
