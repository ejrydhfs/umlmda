package org.umlmda.runtime.sdo.sync.test.dto;

/**
 * 
 */
public interface RootGreatChildren extends java.io.Serializable {
   public static final String PROPERTY_INT_ATTR     = "intAttr";
   public static final String PROPERTY_OPT_INT_ATTR = "optIntAttr";
   public static final String PROPERTY_DECIMAL_ATTR = "decimalAttr";
   public static final String PROPERTY_DATE_ATTR    = "dateAttr";

   /**
    * Get intAttr, 
    */
   public int getIntAttr();

   /**
    * Set intAttr, 
    */
   public void setIntAttr(int intAttr);

   /**
    * Get optIntAttr, 
    */
   public Integer getOptIntAttr();

   /**
    * Set optIntAttr, 
    */
   public void setOptIntAttr(Integer optIntAttr);

   /**
    * Get decimalAttr, 
    */
   public java.math.BigDecimal getDecimalAttr();

   /**
    * Set decimalAttr, 
    */
   public void setDecimalAttr(java.math.BigDecimal decimalAttr);

   /**
    * Get dateAttr, 
    */
   public java.util.Date getDateAttr();

   /**
    * Set dateAttr, 
    */
   public void setDateAttr(java.util.Date dateAttr);
}
