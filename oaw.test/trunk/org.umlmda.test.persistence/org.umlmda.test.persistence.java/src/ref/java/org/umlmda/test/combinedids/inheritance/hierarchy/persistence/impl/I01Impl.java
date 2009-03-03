package org.umlmda.test.combinedids.inheritance.hierarchy.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.HierarchyVisitor;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I0;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I01;

/**
 * Business implementation of org.umlmda.test.combinedids.inheritance.hierarchy.I01.
 */
@Entity
public class I01Impl extends I0Impl implements I01, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.inheritance.hierarchy.I01";
   /**
    * Version information from BusinessComponent org.umlmda.test.combinedids.inheritance.hierarchy
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
   public static class PKey implements I01.PKey {
      private static final long serialVersionUID = 1000L;
      private String            groupId;
      private String            iId;

      public PKey() {
         super();
      }

      public PKey(String groupId, String iId) {
         this.groupId = groupId;
         this.iId = iId;
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
       * Getkey attribute iId, 
       */
      public String getIId() {
         return iId;
      }

      /**
       * Setkey attribute iId, 
       */
      public void setIId(String iId) {
         String oldValue = this.iId;
         this.iId = iId;
      }

      public boolean equals(Object obj) {
         if (obj instanceof I01.PKey) {
            I01.PKey pkey = (I01.PKey) obj;
            return groupId.equals(pkey.getGroupId()) && iId.equals(pkey.getIId());
         }
         else {
            return super.equals(obj);
         }
      }

      public int hashCode() {
         int hashCode = 0;
         hashCode = hashCode * 29 + groupId.hashCode();
         hashCode = hashCode * 29 + iId.hashCode();
         return hashCode;
      }
   }
   // The primary key
   @EmbeddedId
   private PKey pkey = new PKey();

   /**
    * Getter for the primary key
    */
   public I01.PKey getI01Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setI01Pkey(I01.PKey pkey) {
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
    * Get iId, 
    */
   public String getIId() {
      return pkey.getIId();
   }

   /**
    * Set iId, 
    */
   public void setIId(String iId) {
      pkey.setIId(iId);
   }

   /**
    * Default Ctor. 
   

    */
   public I01Impl() {
      super();
   }

   public I01Impl(String groupId, String iId) {
   }
   @Column
   private String i2Attr;

   /**
    * Get i2Attr, 
    */
   public String getI2Attr() {
      return i2Attr;
   }

   /**
    * Set i2Attr, 
    */
   public void setI2Attr(String i2Attr) {
      String oldValue = this.i2Attr;
      this.i2Attr = i2Attr;
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
    *           must be instance of org.umlmda.test.combinedids.inheritance.hierarchy.persistence.HierarchyVisitor.
    * @see org.umlmda.test.combinedids.inheritance.hierarchy.persistence.HierarchyVisitor.
    */
   public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
      if (visitor instanceof HierarchyVisitor) {
         HierarchyVisitor aVisitor = (HierarchyVisitor) visitor;
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
      marshal("I01Impl", context, true);
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
      context.simpleElement("i2Attr", getI2Attr());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      super.marshalChildren(context);
   }

   /**
    * Marshal references
    */
   protected void marshalReferences(XMLMarshalContext context) {
      super.marshalReferences(context);
   }
}
