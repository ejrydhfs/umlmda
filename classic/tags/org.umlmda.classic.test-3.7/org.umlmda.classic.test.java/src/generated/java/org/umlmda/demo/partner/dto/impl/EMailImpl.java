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
import org.umlmda.demo.partner.dto.EMail;
import org.umlmda.demo.partner.dto.PartnerVisitor;
//@@UserSection-Begin EMail.Imports
//@@UserSection-End EMail.Imports

/**
 * 
 */
public class EMailImpl  extends CommunicationAddressImpl  implements EMail, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private String adress = "null";

   /**
    * Default Ctor
    */
   protected EMailImpl() {
      super();
   }
   

   

   /**
   * Get adress
   */
   public String getAdress() {
      return adress;
   }
   
   /**
   * Set adress
   */
   public void setAdress(String adress) {
      this.adress = adress;
   }


		

   //@@UserSection-Begin EMail.NonGeneratedMembers
   //@@UserSection-End EMail.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static EMailImpl createEMailImpl() {
      return new EMailImpl();
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
      
      marshal("EMailImpl", context, true);
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
      context.simpleElement("adress", getAdress());
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
