package org.umlmda.test.combinedids.one2many.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2many.persistence.C2;
import org.umlmda.test.combinedids.one2many.persistence.D2;
import org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2many.D2.
 */
@Entity
public class D2Impl implements D2, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2many.D2";
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
   public static class PKey implements D2.PKey {
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
         if (obj instanceof D2.PKey) {
            D2.PKey pkey = (D2.PKey) obj;
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
   public D2.PKey getD2Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setD2Pkey(D2.PKey pkey) {
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
   public D2Impl() {
      super();
   }

   public D2Impl(String groupId, String bId) {
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
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumns( {
         @JoinColumn(name = "groupId", referencedColumnName = "groupId", nullable = true, insertable = false, updatable = false),
         @JoinColumn(name = "aId", referencedColumnName = "aId", nullable = true, insertable = false, updatable = false) })
   private C2Impl a;

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2Many association.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public C2 getA() {
      return a;
   }

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2Many association.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param a
    *		New value for assocation a 
    */
   public void setA(C2 a) {
      this.a = (C2Impl) a;
      if (a == null) {
         c2_aId = null;
      }
   }

   // -----------------------------------------------------------------------------------------------
   // Foreign keys for association "a" to "C2"
   // -----------------------------------------------------------------------------------------------
   /**
    * Sync unshared pkey columms of association {@link #getA()} to {@link C2}
    */
   private void syncA() {
      if (a != null) {
         c2_aId = a.getC2Pkey().getAId();
         assert a.getC2Pkey().getGroupId().equals(pkey.getGroupId()) : "different groupId";
      }
      else {
         c2_aId = null;
      }
   }
   /**
    * Unshared pkey column of association {@link #getA()} to {@link C2}
    */
   @Column()
   @SuppressWarnings("unused")
   // Used by JPA implementation
   private String c2_aId;

   /**
    * Sync technical foreign key columns to related objects or the parent.
    */
   @PrePersist
   @PreRemove
   @PreUpdate
   @SuppressWarnings("unused")
   // Used by JPA implementation
   private void syncTechnicalForeignKeys() {
      // Relation "a" to "C2" 
      syncA();
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
      marshal("D2Impl", context, true);
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
