package org.umlmda.test.datatypes.persistence.impl;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.*;

import org.umlmda.runtime.xml.XMLMarshalContext;
import org.umlmda.runtime.xml.XMLSerializable;

import org.umlmda.test.datatypes.persistence.DatatypeTest;
import org.umlmda.test.datatypes.persistence.DatatypesVisitor;

/**
 * Business implementation of org.umlmda.test.datatypes.DatatypeTest.
 */
@Entity
@Table(name = "_DATATYPE_TEST")
public class DatatypeTestImpl implements DatatypeTest, Serializable, XMLSerializable,
      org.umlmda.runtime.visitor.Visitable {
   /**
    * Name in die UML model persistence_test_pim_java_psm
    */
   public static final String  MODEL_NAME       = "org.umlmda.test.datatypes.DatatypeTest";
   /**
    * Version information from BusinessComponent org.umlmda.test.datatypes
    */
   public static final String  MODEL_VERSION    = "1.0";
   //@@UserSection-Begin VersionInfo
   private static final String interfaceVersion = "1.0";
   private static final long   serialVersionUID = 1000L;

   //@@UserSection-End VersionInfo
   /**
    * Default Ctor. 
   

    */
   public DatatypeTestImpl() {
      super();
   }

   public DatatypeTestImpl(String id) {
      setId(id);
   }
   @Id
   @Column
   private String id;

   /**
    * Get id, 
    */
   public String getId() {
      return id;
   }

   /**
    * Set id, 
    */
   public void setId(String id) {
      String oldValue = this.id;
      this.id = id;
   }
   @Column
   @Version
   private int version = 0;

   /**
    * Get version, 
    */
   public int getVersion() {
      return version;
   }

   /**
    * Set version, 
    */
   public void setVersion(int version) {
      int oldValue = this.version;
      this.version = version;
   }
   @Column
   private boolean booleanAttr;

   /**
    * Get booleanAttr, 
    */
   public boolean isBooleanAttr() {
      return booleanAttr;
   }

   /**
    * Set booleanAttr, 
    */
   public void setBooleanAttr(boolean booleanAttr) {
      boolean oldValue = this.booleanAttr;
      this.booleanAttr = booleanAttr;
   }
   @Column
   private Boolean optBooleanAttr;

   /**
    * Get optBooleanAttr, 
    */
   public Boolean getOptBooleanAttr() {
      return optBooleanAttr;
   }

   /**
    * Set optBooleanAttr, 
    */
   public void setOptBooleanAttr(Boolean optBooleanAttr) {
      Boolean oldValue = this.optBooleanAttr;
      this.optBooleanAttr = optBooleanAttr;
   }
   @Column
   private char charAttr;

   /**
    * Get charAttr, 
    */
   public char getCharAttr() {
      return charAttr;
   }

   /**
    * Set charAttr, 
    */
   public void setCharAttr(char charAttr) {
      char oldValue = this.charAttr;
      this.charAttr = charAttr;
   }
   @Column
   private Character optCharAttr;

   /**
    * Get optCharAttr, 
    */
   public Character getOptCharAttr() {
      return optCharAttr;
   }

   /**
    * Set optCharAttr, 
    */
   public void setOptCharAttr(Character optCharAttr) {
      Character oldValue = this.optCharAttr;
      this.optCharAttr = optCharAttr;
   }
   @Column
   @Temporal(TemporalType.DATE)
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
   }
   @Column
   @Temporal(TemporalType.DATE)
   private java.util.Date optDateAtte;

   /**
    * Get optDateAtte, 
    */
   public java.util.Date getOptDateAtte() {
      return optDateAtte;
   }

   /**
    * Set optDateAtte, 
    */
   public void setOptDateAtte(java.util.Date optDateAtte) {
      java.util.Date oldValue = this.optDateAtte;
      this.optDateAtte = optDateAtte;
   }
   @Column
   @Temporal(TemporalType.TIMESTAMP)
   private java.util.Date datetimeAttr;

   /**
    * Get datetimeAttr, 
    */
   public java.util.Date getDatetimeAttr() {
      return datetimeAttr;
   }

   /**
    * Set datetimeAttr, 
    */
   public void setDatetimeAttr(java.util.Date datetimeAttr) {
      java.util.Date oldValue = this.datetimeAttr;
      this.datetimeAttr = datetimeAttr;
   }
   @Column
   @Temporal(TemporalType.TIMESTAMP)
   private java.util.Date optDatetimeAttr;

   /**
    * Get optDatetimeAttr, 
    */
   public java.util.Date getOptDatetimeAttr() {
      return optDatetimeAttr;
   }

   /**
    * Set optDatetimeAttr, 
    */
   public void setOptDatetimeAttr(java.util.Date optDatetimeAttr) {
      java.util.Date oldValue = this.optDatetimeAttr;
      this.optDatetimeAttr = optDatetimeAttr;
   }
   @Column
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
   }
   @Column
   private java.math.BigDecimal optDecimalAttr;

   /**
    * Get optDecimalAttr, 
    */
   public java.math.BigDecimal getOptDecimalAttr() {
      return optDecimalAttr;
   }

   /**
    * Set optDecimalAttr, 
    */
   public void setOptDecimalAttr(java.math.BigDecimal optDecimalAttr) {
      java.math.BigDecimal oldValue = this.optDecimalAttr;
      this.optDecimalAttr = optDecimalAttr;
   }
   @Column
   private double doubleAttr = 0.0;

   /**
    * Get doubleAttr, 
    */
   public double getDoubleAttr() {
      return doubleAttr;
   }

   /**
    * Set doubleAttr, 
    */
   public void setDoubleAttr(double doubleAttr) {
      double oldValue = this.doubleAttr;
      this.doubleAttr = doubleAttr;
   }
   @Column
   private Double optDoubleAttr;

   /**
    * Get optDoubleAttr, 
    */
   public Double getOptDoubleAttr() {
      return optDoubleAttr;
   }

   /**
    * Set optDoubleAttr, 
    */
   public void setOptDoubleAttr(Double optDoubleAttr) {
      Double oldValue = this.optDoubleAttr;
      this.optDoubleAttr = optDoubleAttr;
   }
   @Column
   private float floatAttr = 0.0f;

   /**
    * Get floatAttr, 
    */
   public float getFloatAttr() {
      return floatAttr;
   }

   /**
    * Set floatAttr, 
    */
   public void setFloatAttr(float floatAttr) {
      float oldValue = this.floatAttr;
      this.floatAttr = floatAttr;
   }
   @Column
   private Float optFloatAttr;

   /**
    * Get optFloatAttr, 
    */
   public Float getOptFloatAttr() {
      return optFloatAttr;
   }

   /**
    * Set optFloatAttr, 
    */
   public void setOptFloatAttr(Float optFloatAttr) {
      Float oldValue = this.optFloatAttr;
      this.optFloatAttr = optFloatAttr;
   }
   @Column
   private short shortAttr = 0;

   /**
    * Get shortAttr, 
    */
   public short getShortAttr() {
      return shortAttr;
   }

   /**
    * Set shortAttr, 
    */
   public void setShortAttr(short shortAttr) {
      short oldValue = this.shortAttr;
      this.shortAttr = shortAttr;
   }
   @Column
   private Short optShortAttr;

   /**
    * Get optShortAttr, 
    */
   public Short getOptShortAttr() {
      return optShortAttr;
   }

   /**
    * Set optShortAttr, 
    */
   public void setOptShortAttr(Short optShortAttr) {
      Short oldValue = this.optShortAttr;
      this.optShortAttr = optShortAttr;
   }
   @Column
   private String stringAttr;

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
   }
   @Column
   private String optStringAttr;

   /**
    * Get optStringAttr, 
    */
   public String getOptStringAttr() {
      return optStringAttr;
   }

   /**
    * Set optStringAttr, 
    */
   public void setOptStringAttr(String optStringAttr) {
      String oldValue = this.optStringAttr;
      this.optStringAttr = optStringAttr;
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
    *           must be instance of org.umlmda.test.datatypes.persistence.DatatypesVisitor.
    * @see org.umlmda.test.datatypes.persistence.DatatypesVisitor.
    */
   public void accept(org.umlmda.runtime.visitor.Visitor visitor) {
      if (visitor instanceof DatatypesVisitor) {
         DatatypesVisitor aVisitor = (DatatypesVisitor) visitor;
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
      marshal("DatatypeTestImpl", context, true);
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
      context.simpleElement("id", getId());
      context.simpleElement("version", getVersion());
      context.simpleElement("booleanAttr", isBooleanAttr());
      context.simpleElement("optBooleanAttr", getOptBooleanAttr());
      context.simpleElement("charAttr", getCharAttr());
      context.simpleElement("optCharAttr", getOptCharAttr());
      context.simpleElement("dateAttr", getDateAttr());
      context.simpleElement("optDateAtte", getOptDateAtte());
      context.simpleElement("datetimeAttr", getDatetimeAttr());
      context.simpleElement("optDatetimeAttr", getOptDatetimeAttr());
      context.simpleElement("decimalAttr", getDecimalAttr());
      context.simpleElement("optDecimalAttr", getOptDecimalAttr());
      context.simpleElement("doubleAttr", getDoubleAttr());
      context.simpleElement("optDoubleAttr", getOptDoubleAttr());
      context.simpleElement("floatAttr", getFloatAttr());
      context.simpleElement("optFloatAttr", getOptFloatAttr());
      context.simpleElement("shortAttr", getShortAttr());
      context.simpleElement("optShortAttr", getOptShortAttr());
      context.simpleElement("stringAttr", getStringAttr());
      context.simpleElement("optStringAttr", getOptStringAttr());
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
