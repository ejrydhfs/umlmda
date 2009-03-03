package org.umlmda.test.combinedids.one2many.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2many.persistence.D1;
import org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2many.D1.
 */
@Entity
public class D1Impl implements D1, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2many.D1";
   /**
    * Version information from BusinessComponent org.umlmda.test.combinedids.one2many
    */
   public static final String  MODEL_VERSION    = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;
   //@@UserSection-End VersionInfo
   /**
    * Primary key implementation
    */
   @Embeddable
   public static class PKey implements D1.PKey {
      private static final long serialVersionUID = 1000L;
      private String            groupId;
      private String            bId;

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
         if (obj instanceof D1.PKey) {
            D1.PKey pkey = (D1.PKey) obj;
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
   private PKey pkey = new PKey();

   /**
    * Getter for the primary key
    */
   public D1.PKey getD1Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setD1Pkey(D1.PKey pkey) {
      this.pkey = (PKey) pkey;
   }

   /**
    * Get groupId, 
    */
   public String getGroupId() {
      return pkey.getGroupId();
   }

   /**
    * Set groupId, 
    */
   public void setGroupId(String groupId) {
      pkey.setGroupId(groupId);
   }

   /**
    * Get bId, 
    */
   public String getBId() {
      return pkey.getBId();
   }

   /**
    * Set bId, 
    */
   public void setBId(String bId) {
      pkey.setBId(bId);
   }

   /**
    * Default Ctor. 
   

    */
   public D1Impl() {
      super();
   }

   public D1Impl(String groupId, String bId) {
      this.pkey = new PKey(groupId, bId);
   }
   @Column
   private String bAttr;

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
    *           must be instance of org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor.
    * @see org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor.
    */
   public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
      if (visitor instanceof One2manyVisitor) {
         One2manyVisitor aVisitor = (One2manyVisitor) visitor;
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
      marshal("D1Impl", context, true);
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
