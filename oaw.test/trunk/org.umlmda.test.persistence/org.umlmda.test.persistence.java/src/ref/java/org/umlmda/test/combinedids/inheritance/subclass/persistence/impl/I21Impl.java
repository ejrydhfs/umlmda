package org.umlmda.test.combinedids.inheritance.subclass.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.inheritance.subclass.persistence.I2;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I21;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.SubclassVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.inheritance.subclass.I21.
 */
@Entity
public class I21Impl extends I2Impl implements I21, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.inheritance.subclass.I21";
   /**
    * Version information from BusinessComponent org.umlmda.test.combinedids.inheritance.subclass
    */
   public static final String  MODEL_VERSION    = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;

   //@@UserSection-End VersionInfo
   /**
    * Default Ctor. 
   

    */
   public I21Impl() {
      super();
   }

   public I21Impl(String groupId, String iId) {
      super(groupId, iId);
   }
   @Column
   private String i2Attr = null;

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
    *           must be instance of org.umlmda.test.combinedids.inheritance.subclass.persistence.SubclassVisitor.
    * @see org.umlmda.test.combinedids.inheritance.subclass.persistence.SubclassVisitor.
    */
   public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
      if (visitor instanceof SubclassVisitor) {
         SubclassVisitor aVisitor = (SubclassVisitor) visitor;
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
      marshal("I21Impl", context, true);
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
