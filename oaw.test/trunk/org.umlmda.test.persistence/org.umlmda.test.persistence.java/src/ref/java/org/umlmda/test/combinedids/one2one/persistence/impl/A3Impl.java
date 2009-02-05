package org.umlmda.test.combinedids.one2one.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2one.persistence.A3;
import org.umlmda.test.combinedids.one2one.persistence.B3;
import org.umlmda.test.combinedids.one2one.persistence.One2oneVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2one.A3.
 */
@Entity
public class A3Impl implements A3, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2one.A3";
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
   public static class PKey implements A3.PKey {
      private String groupId = "";
      private String aId     = "";

      public PKey() {
         super();
      }

      public PKey(String groupId, String aId) {
         this.groupId = groupId;
         this.aId = aId;
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
       * Getkey attribute aId, 
       */
      public String getAId() {
         return aId;
      }

      /**
       * Setkey attribute aId, 
       */
      public void setAId(String aId) {
         String oldValue = this.aId;
         this.aId = aId;
      }

      public boolean equals(Object obj) {
         if (obj instanceof A3.PKey) {
            A3.PKey pkey = (A3.PKey) obj;
            return groupId.equals(pkey.getGroupId()) && aId.equals(pkey.getAId());
         }
         else {
            return super.equals(obj);
         }
      }

      public int hashCode() {
         int hashCode = 0;
         hashCode = hashCode * 29 + groupId.hashCode();
         hashCode = hashCode * 29 + aId.hashCode();
         return hashCode;
      }
   }
   // The primary key
   @EmbeddedId
   private PKey pkey = new PKey();

   /**
    * Getter for the primary key
    */
   public A3.PKey getA3Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setA3Pkey(A3.PKey pkey) {
      this.pkey = (PKey) pkey;
   }

   /**
    * Default Ctor. 
   

    */
   public A3Impl() {
      super();
   }

   public A3Impl(String groupId, String aId) {
      super();
      this.pkey = new PKey(groupId, aId);
   }
//   @Column
//   private String groupId = "";
//
//   /**
//    * Get groupId, 
//    */
//   public String getGroupId() {
//      return groupId;
//   }
//
//   /**
//    * Set groupId, 
//    */
//   public void setGroupId(String groupId) {
//      String oldValue = this.groupId;
//      this.groupId = groupId;
//   }
//   @Column
//   private String aId = "";
//
//   /**
//    * Get aId, 
//    */
//   public String getAId() {
//      return aId;
//   }
//
//   /**
//    * Set aId, 
//    */
//   public void setAId(String aId) {
//      String oldValue = this.aId;
//      this.aId = aId;
//   }
   @Column
   private String aAttr = null;

   /**
    * Get aAttr, 
    */
   public String getAAttr() {
      return aAttr;
   }

   /**
    * Set aAttr, 
    */
   public void setAAttr(String aAttr) {
      String oldValue = this.aAttr;
      this.aAttr = aAttr;
   }
   @OneToOne(cascade=CascadeType.REMOVE)
   private B3Impl b;

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public B3 getB() {
      return b;
   }

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param b
    *		New value for assocation b 
    */
   public void setB(B3 b) {
      B3 oldValue = this.b;
      this.b = (B3Impl) b;
   }

   @Transient
   public String getModelName() {
      return MODEL_NAME;
   }

   @Transient
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
      marshal("A3Impl", context, true);
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
      context.simpleElement("groupId", pkey.getGroupId());
      context.simpleElement("aId", pkey.getAId());
      context.simpleElement("aAttr", getAAttr());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      if (b instanceof XMLSerializable)
         ((XMLSerializable) b).marshal("b", context, false);
   }

   /**
    * Marshal references
    */
   protected void marshalReferences(XMLMarshalContext context) {
      if (b instanceof XMLSerializable)
         context.elementRef("b", (XMLSerializable) getB());
   }
}
