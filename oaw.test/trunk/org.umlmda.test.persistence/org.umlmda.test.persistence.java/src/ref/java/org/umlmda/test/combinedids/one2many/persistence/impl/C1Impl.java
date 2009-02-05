package org.umlmda.test.combinedids.one2many.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2many.persistence.C1;
import org.umlmda.test.combinedids.one2many.persistence.D1;
import org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2many.C1.
 */
@Entity
public class C1Impl implements C1, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2many.C1";
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
   public static class PKey implements C1.PKey {
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
         if (obj instanceof C1.PKey) {
            C1.PKey pkey = (C1.PKey) obj;
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
   public C1.PKey getC1Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setC1Pkey(C1.PKey pkey) {
      this.pkey = (PKey) pkey;
   }

   /**
    * Default Ctor. 
   

    */
   public C1Impl() {
      super();
   }

   public C1Impl(String groupId, String aId) {
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
   @OneToMany(fetch = FetchType.LAZY)
   // not possible without jointable
//   @JoinColumns({ @JoinColumn(name = "groupId", table="D3Impl"),@JoinColumn(name = "bId", table = "D3Impl")})
//	 org.hibernate.cfg.NotYetImplementedException: Collections having FK in secondary table
   private java.util.Set<D1Impl> ds = new java.util.HashSet<D1Impl>();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public <T> java.util.Set<T> getDs() {
      return (Set<T>) ds;
   }

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param ds
    *		New value for assocation ds 
    */
   public <T> void setDs(java.util.Set<T> ds) {
	   this.ds = (Set<D1Impl>) ds;
//      setDsInternal(ds);
   }

//   private void setDsInternal(java.util.Set<D1> ds) {
//      java.util.Set<D1> oldValue;
//      if (this.ds != null) {
//         oldValue = new java.util.HashSet<org.umlmda.test.combinedids.one2many.persistence.D1>(this.ds);
//      }
//      else {
//         oldValue = null;
//      }
//      if (ds != null) {
//         if (this.ds == null) {
//            this.ds = new java.util.HashSet<org.umlmda.test.combinedids.one2many.persistence.D1>();
//         }
//         this.ds.clear();
//         this.ds.addAll(ds);
//      }
//      else if (this.ds != null) {
//         this.ds.clear();
//         this.ds = null;
//      }
//   }

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
      marshal("C1Impl", context, true);
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
   }

   /**
    * Marshal references
    */
   protected void marshalReferences(XMLMarshalContext context) {
      for (Iterator i = getDs().iterator(); i.hasNext();) {
         Object child = i.next();
         if (child instanceof XMLSerializable)
            context.elementRef("ds", (XMLSerializable) child);
      }
   }
}
