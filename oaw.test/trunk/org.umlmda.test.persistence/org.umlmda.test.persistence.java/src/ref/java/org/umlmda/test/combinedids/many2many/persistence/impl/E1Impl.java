package org.umlmda.test.combinedids.many2many.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.many2many.persistence.E1;
import org.umlmda.test.combinedids.many2many.persistence.F1;
import org.umlmda.test.combinedids.many2many.persistence.Many2manyVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.many2many.E1.
 */
@Entity
public class E1Impl implements E1, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.many2many.E1";
   /**
    * Version information from BusinessComponent org.umlmda.test.combinedids.many2many
    */
   public static final String  MODEL_VERSION    = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;
   //@@UserSection-End VersionInfo
   /**
    * Primary key implementation
    */
   public static class PKey implements E1.PKey {
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
         if (obj instanceof E1.PKey) {
            E1.PKey pkey = (E1.PKey) obj;
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
   public E1.PKey getE1Pkey() {
      return pkey;
   }

   /**
    * Setter for the primary key
    */
   public void setE1Pkey(E1.PKey pkey) {
      this.pkey = (PKey) pkey;
   }

   /**
    * Default Ctor. 
   

    */
   public E1Impl() {
      super();
   }

   public E1Impl(String groupId, String aId) {
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
   @ManyToMany
   private java.util.Set<F1Impl> fs = new java.util.HashSet<F1Impl>();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public <T> java.util.Set<T> getFs() {
      return (Set<T>) fs;
   }

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param fs
    *		New value for assocation fs 
    */
   public <T> void setFs(java.util.Set<T> fs) {
	   this.fs = (Set<F1Impl>) fs;
   }

//   private void setFsInternal(java.util.Set<F1> fs) {
//      java.util.Set<F1> oldValue;
//      if (this.fs != null) {
//         oldValue = new java.util.HashSet<org.umlmda.test.combinedids.many2many.persistence.F1>(this.fs);
//      }
//      else {
//         oldValue = null;
//      }
//      if (fs != null) {
//         if (this.fs == null) {
//            this.fs = new java.util.HashSet<org.umlmda.test.combinedids.many2many.persistence.F1>();
//         }
//         this.fs.clear();
//         this.fs.addAll(fs);
//      }
//      else if (this.fs != null) {
//         this.fs.clear();
//         this.fs = null;
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
    *           must be instance of org.umlmda.test.combinedids.many2many.persistence.Many2manyVisitor.
    * @see org.umlmda.test.combinedids.many2many.persistence.Many2manyVisitor.
    */
   public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
      if (visitor instanceof Many2manyVisitor) {
         Many2manyVisitor aVisitor = (Many2manyVisitor) visitor;
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
      marshal("E1Impl", context, true);
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
      for (Iterator i = getFs().iterator(); i.hasNext();) {
         Object child = i.next();
         if (child instanceof XMLSerializable)
            context.elementRef("fs", (XMLSerializable) child);
      }
   }
}
