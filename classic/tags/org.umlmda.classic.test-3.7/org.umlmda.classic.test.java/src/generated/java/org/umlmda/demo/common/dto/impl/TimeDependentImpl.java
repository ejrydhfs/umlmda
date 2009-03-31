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

import java.io.Serializable;
import java.util.Iterator;
import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.demo.common.dto.CommonVisitor;
import org.umlmda.demo.common.dto.TimeDependent;
//@@UserSection-Begin TimeDependent.Imports
//@@UserSection-End TimeDependent.Imports

/**
 * Base
 */
public abstract class TimeDependentImpl  implements TimeDependent, Serializable, XMLSerializable
{
   // Version information from BusinessComponent org.umlmda.demo.common
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private javax.xml.datatype.XMLGregorianCalendar validFrom;
   private javax.xml.datatype.XMLGregorianCalendar validTo = null;
   private javax.xml.datatype.XMLGregorianCalendar createdAt;
   private String dummy = "null";

   /**
    * Default Ctor
    */
   protected TimeDependentImpl() {
      super();
   }
   

   

   /**
   * Get validFrom
   */
   public javax.xml.datatype.XMLGregorianCalendar getValidFrom() {
      return validFrom;
   }
   
   /**
   * Set validFrom
   */
   public void setValidFrom(javax.xml.datatype.XMLGregorianCalendar validFrom) {
      this.validFrom = validFrom;
   }

   /**
   * Get validTo
   */
   public javax.xml.datatype.XMLGregorianCalendar getValidTo() {
      return validTo;
   }
   
   /**
   * Set validTo
   */
   public void setValidTo(javax.xml.datatype.XMLGregorianCalendar validTo) {
      this.validTo = validTo;
   }

   /**
   * Get createdAt
   */
   public javax.xml.datatype.XMLGregorianCalendar getCreatedAt() {
      return createdAt;
   }
   
   /**
   * Set createdAt
   */
   public void setCreatedAt(javax.xml.datatype.XMLGregorianCalendar createdAt) {
      this.createdAt = createdAt;
   }

   /**
   * Get dummy
   */
   public String getDummy() {
      return dummy;
   }
   
   /**
   * Set dummy
   */
   public void setDummy(String dummy) {
      this.dummy = dummy;
   }


		

   //@@UserSection-Begin TimeDependent.NonGeneratedMembers
   //@@UserSection-End TimeDependent.NonGeneratedMembers

   
   /** 
    * Accept the visitor
    * @param visitor
    *           must be instance of org.umlmda.demo.common.dto.CommonVisitor.
    * @see org.umlmda.demo.common.dto.CommonVisitor.
    */
    public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
       if ( visitor instanceof CommonVisitor ) {
          CommonVisitor aVisitor = (CommonVisitor)visitor;
          
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
      
      marshal("TimeDependentImpl", context, true);
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
      context.simpleElement("validFrom", getValidFrom());
      context.simpleElement("validTo", getValidTo());
      context.simpleElement("createdAt", getCreatedAt());
      context.simpleElement("dummy", getDummy());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
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
