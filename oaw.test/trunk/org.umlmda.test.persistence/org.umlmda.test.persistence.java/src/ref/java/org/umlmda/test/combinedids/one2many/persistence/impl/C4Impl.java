package org.umlmda.test.combinedids.one2many.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.one2many.persistence.C4;
import org.umlmda.test.combinedids.one2many.persistence.D4;
import org.umlmda.test.combinedids.one2many.persistence.One2manyVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.one2many.C4.
 */
@Entity
public class C4Impl implements C4, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.one2many.C4";
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
   public class PKey implements C4.PKey {
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
         if (obj instanceof C4.PKey) {
            C4.PKey pkey = (C4.PKey) obj;
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
   private C4.PKey pkey = new PKey();

   /**
    * Getter for the primary key
    */
   public C4.PKey getC4Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setC4Pkey(C4.PKey pkey) {
      this.pkey = pkey;
   }

   /**
    * Default Ctor. 
   

    */
   protected C4Impl() {
      super();
   }

   protected C4Impl(String groupId, String aId) {
      super();
      this.pkey = new PKey(groupId, aId);
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
   private String aId = "";

   /**
    * Get aId, 
    */
   public String getAId() {
      return aId;
   }

   /**
    * Set aId, 
    */
   public void setAId(String aId) {
      String oldValue = this.aId;
      this.aId = aId;
   }
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
   @OneToMany()
   private java.util.Set<D4> ds = new java.util.HashSet<org.umlmda.test.combinedids.one2many.persistence.D4>();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public java.util.Set<D4> getDs() {
      return ds;
   }

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param ds
    *		New value for assocation ds 
    */
   public void setDs(java.util.Set<D4> ds) {
      setDsInternal(ds);
   }

   private void setDsInternal(java.util.Set<D4> ds) {
      java.util.Set<D4> oldValue;
      if (this.ds != null) {
         oldValue = new java.util.HashSet<org.umlmda.test.combinedids.one2many.persistence.D4>(this.ds);
      }
      else {
         oldValue = null;
      }
      if (ds != null) {
         if (this.ds == null) {
            this.ds = new java.util.HashSet<org.umlmda.test.combinedids.one2many.persistence.D4>();
         }
         this.ds.clear();
         this.ds.addAll(ds);
      }
      else if (this.ds != null) {
         this.ds.clear();
         this.ds = null;
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
      marshal("C4Impl", context, true);
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
      context.simpleElement("aId", getAId());
      context.simpleElement("aAttr", getAAttr());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      for (Iterator i = getDs().iterator(); i.hasNext();) {
         Object child = i.next();
         if (child instanceof XMLSerializable)
            ((XMLSerializable) child).marshal("ds", context, false);
      }
   }

   /**
    * Marshal references
    */
   protected void marshalReferences(XMLMarshalContext context) {
   }
}
