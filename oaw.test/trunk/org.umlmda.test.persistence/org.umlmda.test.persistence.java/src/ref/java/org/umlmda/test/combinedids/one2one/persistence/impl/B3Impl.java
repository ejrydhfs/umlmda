package org.umlmda.test.combinedids.one2one.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2one.persistence.B3;
import org.umlmda.test.combinedids.one2one.persistence.One2oneVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2one.B3.
 */
@Entity
public class B3Impl implements B3, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2one.B3";
   /**
    * Version information from BusinessComponent org.umlmda.test.combinedids.one2one
    */
   public static final String  MODEL_VERSION    = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;
   //@@UserSection-End VersionInfo
   /**
    * Primary key implementation
    */
   public class PKey implements B3.PKey {
      private String groupId = "";
      private String bId     = "";

      public PKey() {
         super();
      }

      public PKey(String groupId, String bId) {
         this.groupId = groupId;
         this.bId = bId;
      }

      /**
       * Getkey attribute groupId, 
       */
      public String getGroupId() {
         return groupId;
      }

      /**
       * Setkey attribute groupId, 
       */
      public void setGroupId(String groupId) {
         String oldValue = this.groupId;
         this.groupId = groupId;
      }

      /**
       * Getkey attribute bId, 
       */
      public String getBId() {
         return bId;
      }

      /**
       * Setkey attribute bId, 
       */
      public void setBId(String bId) {
         String oldValue = this.bId;
         this.bId = bId;
      }

      public boolean equals(Object obj) {
         if (obj instanceof B3.PKey) {
            B3.PKey pkey = (B3.PKey) obj;
            return groupId.equals(pkey.getGroupId()) && bId.equals(pkey.getBId());
         }
         else {
            return super.equals(obj);
         }
      }

      public int hashCode() {
         int hashCode = 0;
         hashCode = hashCode * 29 + groupId.hashCode();
         hashCode = hashCode * 29 + bId.hashCode();
         return hashCode;
      }
   }
   // The primary key
   @EmbeddedId
   private B3.PKey pkey = new PKey();

   /**
    * Getter for the primary key
    */
   public B3.PKey getB3Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setB3Pkey(B3.PKey pkey) {
      this.pkey = pkey;
   }

   /**
    * Default Ctor. 
   

    */
   protected B3Impl() {
      super();
   }

   protected B3Impl(String groupId, String bId) {
      super();
      this.pkey = new PKey(groupId, bId);
   }
   @Column
   private String groupId = "";

   /**
    * Get groupId, 
    */
   public String getGroupId() {
      return groupId;
   }

   /**
    * Set groupId, 
    */
   public void setGroupId(String groupId) {
      String oldValue = this.groupId;
      this.groupId = groupId;
   }
   @Column
   private String bId = "";

   /**
    * Get bId, 
    */
   public String getBId() {
      return bId;
   }

   /**
    * Set bId, 
    */
   public void setBId(String bId) {
      String oldValue = this.bId;
      this.bId = bId;
   }
   @Column
   private String bAttr = null;

   /**
    * Get bAttr, 
    */
   public String getBAttr() {
      return bAttr;
   }

   /**
    * Set bAttr, 
    */
   public void setBAttr(String bAttr) {
      String oldValue = this.bAttr;
      this.bAttr = bAttr;
   }

   public String getModelName() {
      return MODEL_NAME;
   }

   public String getModelVersion() {
      return MODEL_VERSION;
   }

   /** 
    * Accept the visitor
    * @param visitor
    *           must be instance of org.umlmda.test.combinedids.one2one.persistence.One2oneVisitor.
    * @see org.umlmda.test.combinedids.one2one.persistence.One2oneVisitor.
    */
   public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
      if (visitor instanceof One2oneVisitor) {
         One2oneVisitor aVisitor = (One2oneVisitor) visitor;
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
      marshal("B3Impl", context, true);
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
      context.simpleElement("groupId", getGroupId());
      context.simpleElement("bId", getBId());
      context.simpleElement("bAttr", getBAttr());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
   }

   /**
    * Marshal references
    */
   protected void marshalReferences(XMLMarshalContext context) {
   }
}
