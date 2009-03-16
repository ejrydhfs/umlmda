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
import org.umlmda.demo.partner.dto.CommunicationAddress;
import org.umlmda.demo.partner.dto.PartnerVisitor;
//@@UserSection-Begin CommunicationAddress.Imports
//@@UserSection-End CommunicationAddress.Imports

/**
 * 
 */
public abstract class CommunicationAddressImpl  extends TimeDependentImpl  implements CommunicationAddress, Serializable, XMLSerializable
{
   // Version information from BusinessComponent org.umlmda.demo.partner
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private int nr = 0;

   /**
    * Default Ctor
    */
   protected CommunicationAddressImpl() {
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


		

   //@@UserSection-Begin CommunicationAddress.NonGeneratedMembers
   //@@UserSection-End CommunicationAddress.NonGeneratedMembers

   
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
      
      marshal("CommunicationAddressImpl", context, true);
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
