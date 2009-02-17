package org.umlmda.test.combinedids.inheritance.subclass.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.inheritance.subclass.persistence.I2;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.I22;
import org.umlmda.test.combinedids.inheritance.subclass.persistence.SubclassVisitor;

/**
 * Business implementation of org.umlmda.test.combinedids.inheritance.subclass.I22.
 */
@Entity
public class I22Impl extends I2Impl implements I22, Serializable, XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.inheritance.subclass.I22";
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
   public I22Impl() {
      super();
   }

   public I22Impl(String groupId, String iId) {
      super(groupId, iId);
   }
   @Column
   private String i3Attr;

   /**
    * Get i3Attr, 
    */
   public String getI3Attr() {
      return i3Attr;
   }

   /**
    * Set i3Attr, 
    */
   public void setI3Attr(String i3Attr) {
      String oldValue = this.i3Attr;
      this.i3Attr = i3Attr;
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
      marshal("I22Impl", context, true);
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
      context.simpleElement("i3Attr", getI3Attr());
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
