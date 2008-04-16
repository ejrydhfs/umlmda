package org.umlmda.runtime.sdo.sync.test.dto.impl;

import java.io.Serializable;
import java.util.Iterator;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.runtime.sdo.sync.test.dto.RootChild;
import org.umlmda.runtime.sdo.sync.test.dto.RootGreatChildren;
import org.umlmda.runtime.sdo.sync.test.dto.TestVisitor;

/**
 * Business implementation of org.umlmda.runtime.sdo.sync.test.RootChild.
 */
public class RootChildImpl extends AbstractSynchronizedObject implements RootChild, Serializable, XMLSerializable,
      org.umlmda.runtime.visitor.Visitable {
   // Version information from BusinessComponent org.umlmda.runtime.sdo.sync.test
   private static final String                                              modelVersion         = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String                                              interfaceVersion     = "1.0";
   private static final long                                                serialVersionUID     = 1000L;
   //@@UserSection-End VersionInfo
   // Delegate for none generatable features
   private transient org.umlmda.runtime.sdo.sync.test.dto.RootChildDelegate theRootChildDelegate = null;

   /**
    * Lazy creation of the delegate for none generateable features. 
    */
   protected org.umlmda.runtime.sdo.sync.test.dto.RootChildDelegate getRootChildDelegate() {
      if (theRootChildDelegate == null) {
         theRootChildDelegate = new org.umlmda.runtime.sdo.sync.test.dto.impl.delegate.RootChildDelegateImpl(this);
      }
      return theRootChildDelegate;
   }

   /**
    * Default Ctor. 
   

    */
   public RootChildImpl(Recorder recorder) {
      super(recorder);
   }
   private RootGreatChildren greatChildren;

   /**
    * 
    */
   public RootGreatChildren getGreatChildren() {
      return greatChildren;
   }

   /**
    * 
    *
    * @param greatChildren
    *		New value for assocation greatChildren 
    */
   public void setGreatChildren(RootGreatChildren greatChildren) {
      RootGreatChildren oldValue = this.greatChildren;
      this.greatChildren = greatChildren;
      this.recorder.recordChange(this, PROPERTY_GREAT_CHILDREN, greatChildren);
   }

   /**
    * 
    */
   public void serverMethod() {
      getRootChildDelegate().serverMethod();
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
      marshal("RootChildImpl", context, true);
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
