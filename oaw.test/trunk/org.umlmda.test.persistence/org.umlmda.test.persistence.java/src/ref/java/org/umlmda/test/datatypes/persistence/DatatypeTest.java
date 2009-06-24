package org.umlmda.test.datatypes.persistence;

/**
 * 
 */
public interface DatatypeTest extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
   public static final String PROPERTY_ID                = "id";
   public static final String PROPERTY_VERSION           = "version";
   public static final String PROPERTY_BOOLEAN_ATTR      = "booleanAttr";
   public static final String PROPERTY_OPT_BOOLEAN_ATTR  = "optBooleanAttr";
   public static final String PROPERTY_CHAR_ATTR         = "charAttr";
   public static final String PROPERTY_OPT_CHAR_ATTR     = "optCharAttr";
   public static final String PROPERTY_DATE_ATTR         = "dateAttr";
   public static final String PROPERTY_OPT_DATE_ATTE     = "optDateAtte";
   public static final String PROPERTY_DATETIME_ATTR     = "datetimeAttr";
   public static final String PROPERTY_OPT_DATETIME_ATTR = "optDatetimeAttr";
   public static final String PROPERTY_DECIMAL_ATTR      = "decimalAttr";
   public static final String PROPERTY_OPT_DECIMAL_ATTR  = "optDecimalAttr";
   public static final String PROPERTY_DOUBLE_ATTR       = "doubleAttr";
   public static final String PROPERTY_OPT_DOUBLE_ATTR   = "optDoubleAttr";
   public static final String PROPERTY_FLOAT_ATTR        = "floatAttr";
   public static final String PROPERTY_OPT_FLOAT_ATTR    = "optFloatAttr";
   public static final String PROPERTY_SHORT_ATTR        = "shortAttr";
   public static final String PROPERTY_OPT_SHORT_ATTR    = "optShortAttr";
   public static final String PROPERTY_STRING_ATTR       = "stringAttr";
   public static final String PROPERTY_OPT_STRING_ATTR   = "optStringAttr";

   /**
    * Get id, 
    */
   public String getId();

   /**
    * Set id, 
    */
   public void setId(String id);

   /**
    * Get version, 
    */
   public int getVersion();;

   /**
    * Get booleanAttr, 
    */
   public boolean isBooleanAttr();

   /**
    * Set booleanAttr, 
    */
   public void setBooleanAttr(boolean booleanAttr);

   /**
    * Get optBooleanAttr, 
    */
   public Boolean getOptBooleanAttr();

   /**
    * Set optBooleanAttr, 
    */
   public void setOptBooleanAttr(Boolean optBooleanAttr);

   /**
    * Get charAttr, 
    */
   public char getCharAttr();

   /**
    * Set charAttr, 
    */
   public void setCharAttr(char charAttr);

   /**
    * Get optCharAttr, 
    */
   public Character getOptCharAttr();

   /**
    * Set optCharAttr, 
    */
   public void setOptCharAttr(Character optCharAttr);

   /**
    * Get dateAttr, 
    */
   public java.util.Date getDateAttr();

   /**
    * Set dateAttr, 
    */
   public void setDateAttr(java.util.Date dateAttr);

   /**
    * Get optDateAtte, 
    */
   public java.util.Date getOptDateAtte();

   /**
    * Set optDateAtte, 
    */
   public void setOptDateAtte(java.util.Date optDateAtte);

   /**
    * Get datetimeAttr, 
    */
   public java.util.Date getDatetimeAttr();

   /**
    * Set datetimeAttr, 
    */
   public void setDatetimeAttr(java.util.Date datetimeAttr);

   /**
    * Get optDatetimeAttr, 
    */
   public java.util.Date getOptDatetimeAttr();

   /**
    * Set optDatetimeAttr, 
    */
   public void setOptDatetimeAttr(java.util.Date optDatetimeAttr);

   /**
    * Get decimalAttr, 
    */
   public java.math.BigDecimal getDecimalAttr();

   /**
    * Set decimalAttr, 
    */
   public void setDecimalAttr(java.math.BigDecimal decimalAttr);

   /**
    * Get optDecimalAttr, 
    */
   public java.math.BigDecimal getOptDecimalAttr();

   /**
    * Set optDecimalAttr, 
    */
   public void setOptDecimalAttr(java.math.BigDecimal optDecimalAttr);

   /**
    * Get doubleAttr, 
    */
   public double getDoubleAttr();

   /**
    * Set doubleAttr, 
    */
   public void setDoubleAttr(double doubleAttr);

   /**
    * Get optDoubleAttr, 
    */
   public Double getOptDoubleAttr();

   /**
    * Set optDoubleAttr, 
    */
   public void setOptDoubleAttr(Double optDoubleAttr);

   /**
    * Get floatAttr, 
    */
   public float getFloatAttr();

   /**
    * Set floatAttr, 
    */
   public void setFloatAttr(float floatAttr);

   /**
    * Get optFloatAttr, 
    */
   public Float getOptFloatAttr();

   /**
    * Set optFloatAttr, 
    */
   public void setOptFloatAttr(Float optFloatAttr);

   /**
    * Get shortAttr, 
    */
   public short getShortAttr();

   /**
    * Set shortAttr, 
    */
   public void setShortAttr(short shortAttr);

   /**
    * Get optShortAttr, 
    */
   public Short getOptShortAttr();

   /**
    * Set optShortAttr, 
    */
   public void setOptShortAttr(Short optShortAttr);

   /**
    * Get stringAttr, 
    */
   public String getStringAttr();

   /**
    * Set stringAttr, 
    */
   public void setStringAttr(String stringAttr);

   /**
    * Get optStringAttr, 
    */
   public String getOptStringAttr();

   /**
    * Set optStringAttr, 
    */
   public void setOptStringAttr(String optStringAttr);
}
