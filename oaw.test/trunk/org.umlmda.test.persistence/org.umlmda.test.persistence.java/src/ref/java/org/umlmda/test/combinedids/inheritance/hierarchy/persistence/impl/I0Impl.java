package org.umlmda.test.combinedids.inheritance.hierarchy.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.HierarchyVisitor;
import org.umlmda.test.combinedids.inheritance.hierarchy.persistence.I0;

/**
 * Business implementation of org.umlmda.test.combinedids.inheritance.hierarchy.I0.
 */
@MappedSuperclass
public abstract class I0Impl implements I0, Serializable, XMLSerializable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.combinedids.inheritance.hierarchy.I0";
   /**
    * Version information from BusinessComponent org.umlmda.test.combinedids.inheritance.hierarchy
    */
   public static final String  MODEL_VERSION    = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;

   //@@UserSection-End VersionInfo
   /**
    * Default Ctor. 
   

    */
   public I0Impl() {
      super();
   }
   @Column
   private String i1Attr;

   /**
    * Get i1Attr, 
    */
   public String getI1Attr() {
      return i1Attr;
   }

   /**
    * Set i1Attr, 
    */
   public void setI1Attr(String i1Attr) {
      String oldValue = this.i1Attr;
      this.i1Attr = i1Attr;
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
      marshal("I0Impl", context, true);
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
      context.simpleElement("iId", getIId());
      context.simpleElement("i1Attr", getI1Attr());
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
