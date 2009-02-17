package org.umlmda.test.combinedids.one2many.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2many.persistence.C5;
import org.umlmda.test.combinedids.one2many.persistence.D5;
import org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2many.D5.
 */
@Entity
public class D5Impl implements D5, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2many.D5";
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
   public static class PKey implements D5.PKey {
      private static final long serialVersionUID = 1000L;
      private String            groupId;
      private String            id;

      public PKey() {
         super();
      }

      public PKey(String groupId, String id) {
         this.groupId = groupId;
         this.id = id;
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
       * Getkey attribute id, 
       */
      public String getId() {
         return id;
      }

      /**
       * Setkey attribute id, 
       */
      public void setId(String id) {
         String oldValue = this.id;
         this.id = id;
      }

      public boolean equals(Object obj) {
         if (obj instanceof D5.PKey) {
            D5.PKey pkey = (D5.PKey) obj;
            return groupId.equals(pkey.getGroupId()) && id.equals(pkey.getId());
         }
         else {
            return super.equals(obj);
         }
      }

      public int hashCode() {
         int hashCode = 0;
         hashCode = hashCode * 29 + groupId.hashCode();
         hashCode = hashCode * 29 + id.hashCode();
         return hashCode;
      }
   }
   // The primary key
   @EmbeddedId
   private PKey pkey = new PKey();

   /**
    * Getter for the primary key
    */
   public D5.PKey getD5Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setD5Pkey(D5.PKey pkey) {
      this.pkey = (PKey) pkey;
   }

   /**
    * Default Ctor. 
   

    */
   public D5Impl() {
      super();
   }

   public D5Impl(String groupId, String id) {
      super();
      this.pkey = new PKey(groupId, id);
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
    * Get id, 
    */
   public String getId() {
      return pkey.getId();
   }

   /**
    * Set id, 
    */
   public void setId(String id) {
      pkey.setId(id);
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
   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumns( {
         @JoinColumn(name = "groupId", referencedColumnName = "groupId", nullable = true, insertable = false, updatable = false),
         @JoinColumn(name = "id", referencedColumnName = "id", nullable = true, insertable = false, updatable = false) })
   private C5Impl a;

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;
   &lt;P&gt;Bidirectional&nbsp;One2Many composition, only groupId is shared key.&lt;/P&gt;
   &lt;P&gt;@@@ TODO handle sharedKey&lt;/P&gt;&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public C5 getA() {
      return a;
   }

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;
   &lt;P&gt;Bidirectional&nbsp;One2Many composition, only groupId is shared key.&lt;/P&gt;
   &lt;P&gt;@@@ TODO handle sharedKey&lt;/P&gt;&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param a
    *		New value for assocation a 
    */
   public void setA(C5 a) {
      this.a = (C5Impl) a;
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
      marshal("D5Impl", context, true);
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
      context.simpleElement("id", getId());
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
