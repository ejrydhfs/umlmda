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
import org.umlmda.demo.common.dto.SecurityToken;
//@@UserSection-Begin SecurityToken.Imports
//@@UserSection-End SecurityToken.Imports

/**
 * 
 */
public class SecurityTokenImpl  implements SecurityToken, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable
{
   // Version information from BusinessComponent org.umlmda.demo.common
   private static final String modelVersion = "1.0";
//@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long serialVersionUID = 1000L;
//@@UserSection-End VersionInfo
   
   private byte[] signature;
   private String[] securityIds = null;

   /**
    * Default Ctor
    */
   protected SecurityTokenImpl() {
      super();
   }
   

   

   /**
   * Get signature
   */
   public byte[] getSignature() {
      return signature;
   }
   
   /**
   * Set signature
   */
   public void setSignature(byte[] signature) {
      this.signature = signature;
   }

   /**
   * Get securityIds
   */
   public String[] getSecurityIds() {
      return securityIds;
   }
   
   /**
   * Set securityIds
   */
   public void setSecurityIds(String[] securityIds) {
      this.securityIds = securityIds;
   }


		

   //@@UserSection-Begin SecurityToken.NonGeneratedMembers
   //@@UserSection-End SecurityToken.NonGeneratedMembers

   /**
    * Factory method, only called by the factory implementation in the same package
    */
   static SecurityTokenImpl createSecurityTokenImpl() {
      return new SecurityTokenImpl();
   }
    
   
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
      
      marshal("SecurityTokenImpl", context, true);
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
      context.simpleElement("signature", getSignature());
      context.simpleElement("securityIds", getSecurityIds());
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
