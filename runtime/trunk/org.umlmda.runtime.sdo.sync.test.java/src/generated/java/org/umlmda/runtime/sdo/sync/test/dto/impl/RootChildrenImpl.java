package org.umlmda.runtime.sdo.sync.test.dto.impl;

import java.io.Serializable;
import java.util.Iterator;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.runtime.sdo.sync.test.dto.RootChildren;
import org.umlmda.runtime.sdo.sync.test.dto.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.test.dto.TestVisitor;

/**
 * Business implementation of org.umlmda.runtime.sdo.sync.test.RootChildren.
 */
public class RootChildrenImpl extends AbstractSynchronizedObject implements RootChildren, Serializable,
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
   public RootChildrenImpl(Recorder recorder) {
      super(recorder);
   }
   private String stringAttr = "";

   /**
    * Get stringAttr, 
    */
   public String getStringAttr() {
      return stringAttr;
   }

   /**
    * Set stringAttr, 
    */
   public void setStringAttr(String stringAttr) {
      String oldValue = this.stringAttr;
      this.stringAttr = stringAttr;
      this.recorder.recordChange(this, PROPERTY_STRING_ATTR, stringAttr);
   }
   private java.util.Set rootGreatChildren = new org.umlmda.runtime.sdo.sync.SynchronizedSetWrapper(this.recorder,
                                                 new java.util.HashSet());

   /**
    * 
    */
   public java.util.Set getRootGreatChildren() {
      return rootGreatChildren;
   }

   /**
    * 
    *
    * @param rootGreatChildren
    *		New value for assocation rootGreatChildren 
    */
   public void setRootGreatChildren(java.util.Set rootGreatChildren) {
      setRootGreatChildrenInternal(rootGreatChildren);
   }

   private void setRootGreatChildrenInternal(java.util.Collection rootGreatChildren) {
      java.util.Set oldValue;
      if (this.rootGreatChildren != null) {
         oldValue = new java.util.HashSet();
         oldValue.addAll(this.rootGreatChildren);
      }
      else {
         oldValue = null;
      }
      if (rootGreatChildren != null) {
         if (this.rootGreatChildren == null) {
            this.rootGreatChildren = new java.util.HashSet();
         }
         this.rootGreatChildren.clear();
         this.rootGreatChildren.addAll(rootGreatChildren);
      }
      else if (this.rootGreatChildren != null) {
         this.rootGreatChildren.clear();
         this.rootGreatChildren = null;
      }
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
      marshal("RootChildrenImpl", context, true);
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
      context.simpleElement("stringAttr", getStringAttr());
   }

   /**
    * Marshal children
    */
   protected void marshalChildren(XMLMarshalContext context) {
      for (Iterator i = getRootGreatChildren().iterator(); i.hasNext();) {
         Object child = i.next();
         if (child instanceof XMLSerializable)
            ((XMLSerializable) child).marshal("rootGreatChildren", context, false);
      }
   }

   /**
    * Marshal references
    */
   protected void marshalReferences(XMLMarshalContext context) {
   }
}
