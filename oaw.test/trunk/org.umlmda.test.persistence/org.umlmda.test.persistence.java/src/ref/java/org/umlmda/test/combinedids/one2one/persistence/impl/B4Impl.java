package org.umlmda.test.combinedids.one2one.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2one.persistence.A4;
import org.umlmda.test.combinedids.one2one.persistence.B4;
import org.umlmda.test.combinedids.one2one.persistence.One2oneVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2one.B4.
 */
@Entity
public class B4Impl implements B4, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2one.B4";
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
   @Embeddable
   public static class PKey implements B4.PKey {
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
         if (obj instanceof B4.PKey) {
            B4.PKey pkey = (B4.PKey) obj;
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
   public B4.PKey getB4Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setB4Pkey(B4.PKey pkey) {
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
   public B4Impl() {
      super();
   }

   public B4Impl(String groupId, String bId) {
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
   @OneToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumns( {
         @JoinColumn(name = "groupId", referencedColumnName = "groupId", nullable = true, insertable = false, updatable = false),
         @JoinColumn(name = "aId", referencedColumnName = "aId", nullable = true, insertable = false, updatable = false) })
   private A4Impl a;

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public A4 getA() {
      return a;
   }

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param a
    *		New value for assocation a 
    */
   public void setA(A4 a) {
      this.a = (A4Impl) a;
      if (a == null) {
         aId = null;
      }
   }
   /**
    * Unshared pkey column of association {@link #getA()} to {@link A4}
    */
   @Column(nullable = false)
   @SuppressWarnings("unused")
   // Used by jpa
   private String aId;

   /**
    * Sync unshared pkey columms of association {@link #getA()} to {@link A4}
    */
   @PrePersist
   @PreRemove
   @PreUpdate
   @SuppressWarnings("unused")
   // Used by jpa
   private void syncA() {
      if (a != null) {
         aId = a.getA4Pkey().getAId();
         assert a.getA4Pkey().getGroupId().equals(pkey.getGroupId()) : "different groupId";
      }
      else {
         aId = null;
      }
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
      marshal("B4Impl", context, true);
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
