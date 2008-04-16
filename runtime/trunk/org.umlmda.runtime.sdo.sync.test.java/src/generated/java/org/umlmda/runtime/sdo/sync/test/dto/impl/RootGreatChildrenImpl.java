package org.umlmda.runtime.sdo.sync.test.dto.impl;

import java.io.Serializable;
import java.util.Iterator;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.runtime.sdo.sync.test.dto.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.test.dto.TestVisitor;

/**
 * Business implementation of org.umlmda.runtime.sdo.sync.test.RootGreatChildren.
 */
public class RootGreatChildrenImpl extends AbstractSynchronizedObject implements RootGreatChildren, Serializable,
      XMLSerializable, org.umlmda.runtime.visitor.Visitable {
   // Version information from BusinessComponent org.umlmda.runtime.sdo.sync.test
   private static final String modelVersion     = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;

   //@@UserSection-End VersionInfo
   /**
    * Default Ctor. 
   

    */
   public RootGreatChildrenImpl(Recorder recorder) {
      super(recorder);
   }
   private int intAttr;

   /**
    * Get intAttr, 
    */
   public int getIntAttr() {
      return intAttr;
   }

   /**
    * Set intAttr, 
    */
   public void setIntAttr(int intAttr) {
      int oldValue = this.intAttr;
      this.intAttr = intAttr;
      this.recorder.recordChange(this, PROPERTY_INT_ATTR, intAttr);
   }
   private Integer optIntAttr = null;

   /**
    * Get optIntAttr, 
    */
   public Integer getOptIntAttr() {
      return optIntAttr;
   }

   /**
    * Set optIntAttr, 
    */
   public void setOptIntAttr(Integer optIntAttr) {
      Integer oldValue = this.optIntAttr;
      this.optIntAttr = optIntAttr;
      this.recorder.recordChange(this, PROPERTY_OPT_INT_ATTR, optIntAttr);
   }
   private java.math.BigDecimal decimalAttr;

   /**
    * Get decimalAttr, 
    */
   public java.math.BigDecimal getDecimalAttr() {
      return decimalAttr;
   }

   /**
    * Set decimalAttr, 
    */
   public void setDecimalAttr(java.math.BigDecimal decimalAttr) {
      java.math.BigDecimal oldValue = this.decimalAttr;
      this.decimalAttr = decimalAttr;
      this.recorder.recordChange(this, PROPERTY_DECIMAL_ATTR, decimalAttr);
   }
   private java.util.Date dateAttr;

   /**
    * Get dateAttr, 
    */
   public java.util.Date getDateAttr() {
      return dateAttr;
   }

   /**
    * Set dateAttr, 
    */
   public void setDateAttr(java.util.Date dateAttr) {
      java.util.Date oldValue = this.dateAttr;
      this.dateAttr = dateAttr;
      this.recorder.recordChange(this, PROPERTY_DATE_ATTR, dateAttr);
   }

   /** 
    * Accept the visitor
    * @param visitor
    *           must be instance of org.umlmda.runtime.sdo.sync.test.dto.TestVisitor.
    * @see org.umlmda.runtime.sdo.sync.test.dto.TestVisitor.
    */
   public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
      if (visitor instanceof TestVisitor) {
         TestVisitor aVisitor = (TestVisitor) visitor;
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
      marshal("RootGreatChildrenImpl", context, true);
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
      context.simpleElement("intAttr", getIntAttr());
      context.simpleElement("optIntAttr", getOptIntAttr());
      context.simpleElement("decimalAttr", getDecimalAttr());
      context.simpleElement("dateAttr", getDateAttr());
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
