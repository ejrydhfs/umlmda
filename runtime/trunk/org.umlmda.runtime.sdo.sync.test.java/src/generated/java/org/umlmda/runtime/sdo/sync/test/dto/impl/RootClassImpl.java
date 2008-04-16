package org.umlmda.runtime.sdo.sync.test.dto.impl;

import java.io.Serializable;
import java.util.Iterator;

import org.umlmda.runtime.sdo.sync.Recorder;
import org.umlmda.runtime.sdo.sync.impl.AbstractSynchronizedObject;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.runtime.sdo.sync.test.dto.RootChild;
import org.umlmda.runtime.sdo.sync.test.dto.RootChildren;
import org.umlmda.runtime.sdo.sync.test.dto.RootClass;
import org.umlmda.runtime.sdo.sync.test.dto.TestVisitor;

/**
 * Business implementation of org.umlmda.runtime.sdo.sync.test.RootClass.
 */
public class RootClassImpl extends AbstractSynchronizedObject implements RootClass, Serializable, XMLSerializable,
      org.umlmda.runtime.visitor.Visitable {
   // Version information from BusinessComponent org.umlmda.runtime.sdo.sync.test
   private static final String modelVersion     = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;

   //@@UserSection-End VersionInfo
   /**
    * Default Ctor. 
   

    */
   public RootClassImpl(Recorder recorder) {
      super(recorder);
   }
   private RootChild rootChild;

   /**
    * 
    */
   public RootChild getRootChild() {
      return rootChild;
   }

   /**
    * 
    *
    * @param rootChild
    *		New value for assocation rootChild 
    */
   public void setRootChild(RootChild rootChild) {
      RootChild oldValue = this.rootChild;
      this.rootChild = rootChild;
      this.recorder.recordChange(this, PROPERTY_ROOT_CHILD, rootChild);
   }
   private java.util.List rootChildren = new org.umlmda.runtime.sdo.sync.SynchronizedListWrapper(this.recorder,
                                             new java.util.ArrayList());

   /**
    * 
    */
   public java.util.List getRootChildren() {
      return rootChildren;
   }

   /**
    * 
    *
    * @param rootChildren
    *		New value for assocation rootChildren 
    */
   public void setRootChildren(java.util.List rootChildren) {
      setRootChildrenInternal(rootChildren);
   }

   private void setRootChildrenInternal(java.util.Collection rootChildren) {
      java.util.List oldValue;
      if (this.rootChildren != null) {
         oldValue = new java.util.ArrayList();
         oldValue.addAll(this.rootChildren);
      }
      else {
         oldValue = null;
      }
      if (rootChildren != null) {
         if (this.rootChildren == null) {
            this.rootChildren = new java.util.ArrayList();
         }
         this.rootChildren.clear();
         this.rootChildren.addAll(rootChildren);
      }
      else if (this.rootChildren != null) {
         this.rootChildren.clear();
         this.rootChildren = null;
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
      marshal("RootClassImpl", context, true);
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
      if (rootChild instanceof XMLSerializable)
         ((XMLSerializable) rootChild).marshal("rootChild", context, false);
      for (Iterator i = getRootChildren().iterator(); i.hasNext();) {
         Object child = i.next();
         if (child instanceof XMLSerializable)
            ((XMLSerializable) child).marshal("rootChildren", context, false);
      }
   }

   /**
    * Marshal references
    */
   protected void marshalReferences(XMLMarshalContext context) {
      if (rootChild instanceof XMLSerializable)
         context.elementRef("rootChild", (XMLSerializable) getRootChild());
   }
}
